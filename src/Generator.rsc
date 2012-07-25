@license{Copyright CWI --- Jurgen Vinju, Stijn de Gouw 2012}
module Generator

import ParseTree; // for parse
import IO; // for println, writeFile
import ValueIO; // for readTextValueString
import List; // for intercalate, tail
import String; // for trim

extend lang::java::syntax::BigJava;
import lang::view::syntax::View;
import lang::antlr::syntax::ANTLR;

alias viewStruct = tuple[str history, str grammar, str typeName, map[InEvent,tuple[str token, str name]] inTokens, map[OutEvent,tuple[str token, str name]] outTokens];

@doc{ 
This is the main function of this application:
Usage: generate(loc view);
Example: generate(|project://Histories/test/StackHistory.view|);
Files containing event classes and history class are written
to the folder in which 'view' resides.
}

public int main(list[str] p) {
	for(str s <- p) {
		generate(readTextValueString(#loc, "|<s>|"));
	}
	return 0;
}

public void generate(loc view) {
  if(view.extension != "view")
    throw "expected .view extension of file <view>";

  println("Parsing communication view");
  h = extractView(view);
 
  println("=============== Processing communication view: " + h.history + " ===============");
  println("Parsing ANTLR grammar file: " + h.grammar + ".g");
  grammarTree = parse(#start[ANTLR], view[file=h.grammar + ".g"]).top;

  println("Generating tracing aspect");
  loc aspectLoc = view[file=h.history+"Aspect.java"];
  str historyAspect;
  if(h.typeName != "") { // Local view
  	historyAspect = localAspect(h, grammarTree);
  } else { // Global view
  	historyAspect = globalAspect(h, grammarTree);
  }
  writeFile(aspectLoc,historyAspect);
}

private str txtTokenClass({FormalParameter ","}* params, str className, str methodName, str historyClass) {
	list[str] p = tail(tail(formalsToPrintables(params, historyClass)));  // tail(tail(..)) removes caller and callee
	str methodParams = intercalate(" + \", \" +",p);
	return "public class <className> extends org.antlr.runtime.CommonToken {
	       '  private static final long serialVersionUID = 3L;
	       '
	       '  <for (FormalParameter f <- params) {>
	       '  private final <f.t> <f.v>;
	       '  public <f.t> <f.v>() {
	       '    return this.<f.v>;
	       '  }
	       '  <}>
	       '
	       '  public String toString() {
	       '    return \"o\" + <historyClass>.objToId.get(caller) + \":o\" + <historyClass>.objToId.get(callee) + \".<methodName>(\" + <methodParams == "" ? "\"\"" : methodParams> + \")\";
           '  }
	       '
	       '  public <className>(<params>) {
	       '    super(-1);
	       '
	       '    <for (FormalParameter f <- params) {>
	       '    this.<f.v> = <f.v>;
	       '    <}>
	       '  }
	       '}";
}

private str tokenClass(InEvent e, str typeName, str eventName, str historyClass) {
	{FormalParameter ","}* params = e.h.d.p;
	params = ({FormalParameter ","}*) `<[FormalParameter] "Object caller">, <[FormalParameter] "<typeName> callee">, <{FormalParameter ","}* params>`;
	if ((MethodRes) `void` !:= e.h.r && "return" == "<e.cr>") {
	  params = ({FormalParameter ","}*) `<{FormalParameter ","}* params>, <[FormalParameter] "<e.h.r> result">`;
	}
	
	return txtTokenClass(params, eventName, "<e.h.d.id>", historyClass);
}

private str tokenClass(OutEvent e, str typeName, str eventName, str historyClass) {
	{FormalParameter ","}* params = e.h.d.p;
	params = ({FormalParameter ","}*) `<[FormalParameter] "<typeName == "" ? "Object" : typeName> caller">, <[FormalParameter] "<e.h.t> callee">, <{FormalParameter ","}* params>`;
	if ((MethodRes) `void` !:= e.h.r && "return" == "<e.cr>") {
	  params = ({FormalParameter ","}*) `<{FormalParameter ","}* params>, <[FormalParameter] "<e.h.r> result">`;
	}
	
	return txtTokenClass(params, eventName, "<e.h.d.id>", historyClass);
}

private {FormalParameter ","}* getAttributesFromGrammar(ANTLR grammar) {
  if (/(Thing) `start returns [ <{FormalParameter ","}* formals> ]` := grammar) {
    return formals;
  }
  if (/(Thing) `start` := grammar) {
    return ({FormalParameter ","}*) ``;
  }
  throw "could not retrieve formals from start non-terminal in grammar";
}




private {Type ","}* formalsToTypes({FormalParameter ","}* formals) {
	result = ({Type ","}*) ``;
	for ((FormalParameter) f <- formals) {
		if(({Type ","}*) `` := result) {
			result = ({Type ","}*) `<[Type] "<f.t>">`;
		} else {
			result = ({Type ","}*) `<{Type ","}* result>, <[Type] "<f.t>">`;
		}
	}
	return result;
}

private {Expression ","}* formalsToParams({FormalParameter ","}* formals) {
	result = ({Expression ","}*) ``;
	for ((FormalParameter) f <- formals) {
		if(({Expression ","}*) `` := result) {
			result = ({Expression ","}*) `<[Identifier] "<f.v>">`;
		} else {
			result = ({Expression ","}*) `<{Expression ","}* result>, <[Identifier] "<f.v>">`;
		}
	}
	return result;
}

private list[str] formalsToPrintables({FormalParameter ","}* formals, str historyClass) {
	list[str] l = [];
	for ((FormalParameter) f <- formals) {
		if(f.t is ReferenceType) {
			l += ["\"o\" + <historyClass>.objToId.get(<f.v>)"];
		} else {
			l += ["<f.v>"];
		}
	}
	return l;
}



// Pointcut for incoming event in local history of object of type typeName
private str pointcut(InEvent e, str typeName, str eventName, str aspectName) {
	assert /(Modifier) `static` !:= e.h.m:
	       "Provided methods in local histories cannot be static: <trim("<e.h>")>";
	staticParams = e.h.d.p;
	staticParams = ({FormalParameter ","}*) `<[FormalParameter] "<typeName> cle">, <{FormalParameter ","}* staticParams>`;
	params       = ({FormalParameter ","}*) `<[FormalParameter] "Object clr">, <{FormalParameter ","}* staticParams>`;

	bool retNonVoidMethod = ("<e.cr>" == "return" && e.h.r != (MethodRes) `void`);
	str retNonVoid        = retNonVoidMethod ? " returning(<e.h.r> ret)" : "";
	str callRet           = ("<e.cr>" == "call") ? "before" : "after";
	str histParams        = "<formalsToParams(staticParams)>" + (retNonVoidMethod ? ", ret" : "");

return "/* <e.cr> <e.h.m> <e.h.r> <e.h.d> */
       '<callRet>(<params>)<retNonVoid>:
       '  (call(<e.h.m> <e.h.r> *.<e.h.d.id>(<formalsToTypes(e.h.d.p)>)) && this(clr) && target(cle) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '    h.get(cle).update(new <eventName>(clr, <histParams>));
       '}
       '
       '<callRet>(<staticParams>)<retNonVoid>: // from static method
       '  (call(<e.h.m> <e.h.r> *.<e.h.d.id>(<formalsToTypes(e.h.d.p)>)) && !this(Object) && target(cle) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '    h.get(cle).update(new <eventName>(null, <histParams>));
       '}
       ";
}

// Pointcut for outgoing event in local history of object of type typeName
private str pointcut(OutEvent e, str typeName, str eventName, str aspectName) {
	params = e.h.d.p;
	staticParams = ({FormalParameter ","}*) `<[FormalParameter] "<typeName> clr">, <{FormalParameter ","}* params>`;
	params       = ({FormalParameter ","}*) `<[FormalParameter] "<typeName> clr">, <[FormalParameter] "<e.h.t> cle">, <{FormalParameter ","}* params>`;

	bool retNonVoidMethod = ("<e.cr>" == "return" && e.h.r != (MethodRes) `void`);
	str retNonVoid        = retNonVoidMethod ? " returning(<e.h.r> ret)" : "";
	str callRet           = ("<e.cr>" == "call") ? "before" : "after";
	str histParams        = "<formalsToParams(e.h.d.p)>";
	if(e.h.d.p == ({FormalParameter ","}*) ``) {
		histParams        = (retNonVoidMethod ? "ret" : "");
	} else {
		histParams       += (retNonVoidMethod ? ", ret" : "");
	}

	if(/(Modifier) `static` !:= e.h.m) { // non-static method
return "/* <e.cr> <e.h.m> <e.h.r> <e.h.t> <e.h.d> */
       '<callRet>(<params>)<retNonVoid>:
       '  (call(<e.h.m> <e.h.r> *.<e.h.d.id>(<formalsToTypes(e.h.d.p)>)) && this(clr) && target(cle) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '    h.get(clr).update(new <eventName>(clr, cle<histParams != "" ? ", <histParams>" : "">));
       '}";
	} else { // static method
return "
       '<callRet>(<staticParams>)<retNonVoid>: // static method
       '  (call(<e.h.m> <e.h.r> <e.h.t>.<e.h.d.id>(<formalsToTypes(e.h.d.p)>)) && this(clr) && !target(Object) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '    h.get(clr).update(new <eventName>(clr, null<histParams != "" ? ", <histParams>" : "">));
       '}
       ";
	}
}

// Pointcut for event in global history
private str pointcut(OutEvent e, str eventName, str aspectName) {
	staticParams1 = e.h.d.p;
	staticParams2 = ({FormalParameter ","}*) `<[FormalParameter] "<e.h.t> cle">, <{FormalParameter ","}* staticParams1>`;
	staticParams1 = ({FormalParameter ","}*) `<[FormalParameter] "Object clr">, <{FormalParameter ","}* staticParams1>`;
	params       = ({FormalParameter ","}*) `<[FormalParameter] "Object clr">, <{FormalParameter ","}* staticParams2>`;

	bool retNonVoidMethod = ("<e.cr>" == "return" && e.h.r != (MethodRes) `void`);
	str retNonVoid        = retNonVoidMethod ? " returning(<e.h.r> ret)" : "";
	str callRet           = ("<e.cr>" == "call") ? "before" : "after";
	str histParams        = "<formalsToParams(e.h.d.p)>";
	if(e.h.d.p == ({FormalParameter ","}*) ``) {
		histParams        = (retNonVoidMethod ? "ret" : "");
	} else {
		histParams       += (retNonVoidMethod ? ", ret" : "");
	}
	
	if(/(Modifier) `static` !:= e.h.m) { // non-static method
return "/* <e.cr> <e.h.m> <e.h.r> <e.h.t> <e.h.d> */
	   '<callRet>(<params>)<retNonVoid>: // from non-static method to non-static method
       '  (call(<e.h.m> <e.h.r> *.<e.h.d.id>(<formalsToTypes(e.h.d.p)>)) && this(clr) && target(cle) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '    h.update(new <eventName>(clr, cle<histParams != "" ? ", <histParams>" : "">));
       '}
       '
       '<callRet>(<staticParams2>)<retNonVoid>: // from static method to non-static method
       '  (call(<e.h.m> <e.h.r> *.<e.h.d.id>(<formalsToTypes(e.h.d.p)>)) && !this(Object) && target(cle) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '    h.update(new <eventName>(null, cle<histParams != "" ? ", <histParams>" : "">));
       '}";
	} else {
return "
       '<callRet>(<staticParams1>)<retNonVoid>: // from non-static method to static method
       '  (call(<e.h.m> <e.h.r> <e.h.t>.<e.h.d.id>(<formalsToTypes(e.h.d.p)>)) && this(clr) && !target(Object) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '    h.update(new <eventName>(clr, null<histParams != "" ? ", <histParams>" : "">));
       '}
       '
       '<callRet>(<e.h.d.p>)<retNonVoid>: // from static method to static method
       '  (call(<e.h.m> <e.h.r> <e.h.t>.<e.h.d.id>(<formalsToTypes(e.h.d.p)>)) && !this(Object) && !target(Object) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '    h.update(new <eventName>(null, null<histParams != "" ? ", <histParams>" : "">));
       '}
       ";
	}
}

private str localAspect(viewStruct hv, ANTLR grammar) {
  {FormalParameter ","}* attributes = getAttributesFromGrammar(grammar);

return "<grammar.h ? "">
       'import java.util.IdentityHashMap; // stores local histories and objToId
       'import org.antlr.runtime.*; // for use in <hv.history>
       'import java.util.ArrayList; // for use in <hv.history>
       'import java.util.Iterator; // for use in <hv.history>
       'import java.util.HashSet; // for use in <hv.history>
       'import java.util.HashMap; // for use in <hv.history>
       '
       'aspect <hv.history>Aspect {
       '
       '    static IdentityHashMap\<<hv.typeName>, <hv.history>\> h = new IdentityHashMap\<<hv.typeName>, <hv.history>\>();
       '
       '///////////////////////////////////////////////////////
       '/////////////////////// Event classes /////////////////
       '///////////////////////////////////////////////////////
       '<for (InEvent e <- hv.inTokens) {>
       '    <tokenClass(e, hv.typeName, hv.inTokens[e].name, hv.history)>
       '<}>
       '<for (OutEvent e <- hv.outTokens) {>
       '    <tokenClass(e, hv.typeName, hv.outTokens[e].name, hv.history)>
       '<}>
       '
       '///////////////////////////////////////////////////////
       '/////////////////////// History class /////////////////
       '///////////////////////////////////////////////////////
       '    <historyContainer(hv, attributes)>
       '
       '
       '///////////////////////////////////////////////////////
       '/////////////////////// Aspects ///////////////////////
       '///////////////////////////////////////////////////////
       '<for (InEvent e <- hv.inTokens) {>
       '    <pointcut(e, hv.typeName, hv.inTokens[e].name, "<hv.history>Aspect")>
       '<}>
       '<for (OutEvent e <- hv.outTokens) {>
       '    <pointcut(e, hv.typeName, hv.outTokens[e].name, "<hv.history>Aspect")>
       '<}>
       '
       '    after() returning(<hv.typeName> o):
       '      (call(*.new(..))) {
       '        h.put(o,new <hv.history>());
       '    }
       '}";
}

private str globalAspect(viewStruct hv, ANTLR grammar) {
  {FormalParameter ","}* attributes = getAttributesFromGrammar(grammar);

return "<grammar.h ? "">
       'import java.util.IdentityHashMap; // for use in <hv.history>
       'import org.antlr.runtime.*; // for use in <hv.history>
       'import java.util.ArrayList; // for use in <hv.history>
       'import java.util.Iterator; // for use in <hv.history>
       'import java.util.HashSet; // for use in <hv.history>
       'import java.util.HashMap; // for use in <hv.history>
       '
       'aspect <hv.history>Aspect {
       '
       '    static <hv.history> h = new <hv.history>();
       '
       '///////////////////////////////////////////////////////
       '/////////////////////// Event classes /////////////////
       '///////////////////////////////////////////////////////
       '<for (OutEvent e <- hv.outTokens) {>
       '    <tokenClass(e, "", hv.outTokens[e].name, hv.history)>
       '<}>
       '
       '///////////////////////////////////////////////////////
       '/////////////////////// History class /////////////////
       '///////////////////////////////////////////////////////
       '    <historyContainer(hv, attributes)>
       '
       '
       '///////////////////////////////////////////////////////
       '/////////////////////// Aspects ///////////////////////
       '///////////////////////////////////////////////////////
       '<for (OutEvent e <- hv.outTokens) {>
       '    <pointcut(e, hv.outTokens[e].name, "<hv.history>Aspect")>
       '<}>
       '}";
}

private str updateMethod(str grammarName, str callRet, MethodRes retType, {FormalParameter ","}* params, str eventName, str token) {
return "public void update(<eventName> e) {
       '     e.setType(<grammarName>Lexer.<token>);
       '     _L.add(_L.size()-2, e);
       '
       '
       '     if(!objToId.containsKey(e.caller())) { // for printing
       '         objToId.put(e.caller(), objToId.size());
       '         idToObj.put(idToObj.size(),e.caller());
       '     }
       '     if(!objToId.containsKey(e.callee())) { // for printing
       '         objToId.put(e.callee(), objToId.size());
       '         idToObj.put(idToObj.size(),e.callee());
       '     }
       '     <if(callRet == "return" && retType != (MethodRes) `void`) {>
       '     if(!objToId.containsKey(e.result())) { // for printing
       '         objToId.put(e.result(), objToId.size());
       '         idToObj.put(idToObj.size(),e.result());
       '     }           
       '     <}>
       '     <for(FormalParameter f <- params) {>
       '     if(!objToId.containsKey(e.<f.v>())) { // for printing
       '         objToId.put(e.<f.v>(), objToId.size());
       '         idToObj.put(idToObj.size(),e.<f.v>());
       '     }
       '     <}>
       '     actors.add(objToId.get(e.caller()));
       '     actors.add(objToId.get(e.callee()));
       '
       '     parse();
       '}";
}

private str historyContainer(viewStruct hv, {FormalParameter ","}* attributes) {
return "
       'public static class <hv.history> implements TokenSource {
       '  public  static IdentityHashMap\<Object, Integer\> objToId = new IdentityHashMap\<Object, Integer\>();
       '  public  static HashMap\<Integer, Object\> idToObj = new HashMap\<Integer, Object\>();
       '  private HashSet\<Integer\> actors = new HashSet\<Integer\>();
       '
       '  private ArrayList\<CommonToken\> _L = new ArrayList\<CommonToken\>();
       '  private Integer _currentToken;
       '  <if ( ({FormalParameter ","}*) `<Modifier* _> <Type t> <VariableDeclaratorId _>` := attributes) {>private <t> _start; // Synthesized attribute of start non-terminal
       '  <} else{><if (!(({FormalParameter ","}*) `` := attributes)) {>private <hv.grammar>Parser.start_return _start; // Synthesized attributes of start non-terminal<}><}>
       '
       '  public <hv.history>() {
       '    _L.add(new CommonToken(Token.EOF));
       '    _L.add(new CommonToken(Token.EOF));
       '
       '    parse(); // the empty history
       '  }
       '
       '  // Implemented for TokenSource interface
       '  public String getSourceName() {
       '    return null;
       '  }
       '
       '  public void print() {
       '    Iterator\<Integer\> it = actors.iterator();
       '	while(it.hasNext()) {
       '		Integer objId = it.next();
       '		System.out.println(\"o\" + objId + \":\" + idToObj.get(objId).getClass().getName());
       '	}
       '	System.out.println(\"\");
       '    for(int i=0; i\<_L.size()-2; i++) {
       '      System.out.println(_L.get(i).toString());
       '    }
       '  }
       '
       '  public CommonToken nextToken() {
       '    return _L.get(_currentToken++);
       '  }
       '
       '  // Parse the history in antlr and set attribute values
       '  private void parse() {
       '    _currentToken = 0;
       '    CommonTokenStream tokens = new CommonTokenStream(this);
       '    <hv.grammar>Parser parser = new <hv.grammar>Parser(tokens);
       '
       '    try {
       '      <if (({FormalParameter ","}*) `` := attributes) {>
       '      parser.start();
       '      <} else {>
       '      _start = parser.start();
       '      <}>
       '    } catch(RecognitionException r) {
       '        <if(hv.typeName == "") {>
       '        System.err.println(\"=== ERROR! Global history of view <hv.history> (events: \" + Integer.toString(_L.size()-2) + \") violates protocol structure specified in <hv.grammar>.g === \\n\");
       '        print();
       '        System.err.println(\"-------------------------------------------\");
       '        <} else {>
       '        System.err.println(\"=== ERROR! Local history of view <hv.history> (events: \" + Integer.toString(_L.size()-2) + \") of <hv.typeName> object violates protocol structure specified in <hv.grammar>.g === \\n\");
       '        print();
       '        System.err.println(\"-------------------------------------------\");
       '        <}>
       '        assert false; // Assertion Failure
       '    } catch(AssertionError r) {
       '        <if(hv.typeName == "") {>
       '        System.err.println(\"=== Assertion error in global history of view <hv.history> (events: \" + Integer.toString(_L.size()-2) + \") in grammar <hv.grammar>.g === \\n\");
       '        print();
       '        System.err.println(\"-------------------------------------------\");
       '        <} else {>
       '        System.err.println(\"=== Assertion error in local history of view <hv.history> (events: \" + Integer.toString(_L.size()-2) + \") of <hv.typeName> object in grammar <hv.grammar>.g === \\n\");
       '        print();
       '        System.err.println(\"-------------------------------------------\");
       '        <}>
       '        assert false; // Assertion Failure
       '    }
       '  }
       '
       '  <if ( ({FormalParameter ","}*) `<Modifier* _> <Type t> <VariableDeclaratorId id>` := attributes) {>
       '  public <t> <id>() {
       '    return _start;
       '  }
       '  <} else {><for (FormalParameter f <- attributes) {>
       '  public <f.t> <f.v>() {
       '    return _start.<f.v>;
       '  }
       '  <}><}>
       '
       '  <for (InEvent e <- hv.inTokens) {>
       '  <updateMethod(hv.grammar, "<e.cr>", e.h.r, e.h.d.p, hv.inTokens[e].name, hv.inTokens[e].token)>
       '  <}>
       '  <for (OutEvent e <- hv.outTokens) {>
       '  <updateMethod(hv.grammar, "<e.cr>", e.h.r, e.h.d.p, hv.outTokens[e].name, hv.outTokens[e].token)>
       '  <}>
       '}";
}