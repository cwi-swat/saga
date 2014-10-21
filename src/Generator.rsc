@license{Copyright CWI --- Jurgen Vinju, Stijn de Gouw 2014}
module Generator

import ParseTree; // for parse
import IO; // for println, writeFile
import ValueIO; // for readTextValueString
import List; // for intercalate, tail
import String; // for trim

extend lang::java::\syntax::BigJava;
import lang::view::\syntax::View;
import lang::antlr::\syntax::ANTLR;

alias viewStruct = tuple[str history, str grammar, str typeName, map[InEvent,tuple[str token, str name]] inTokens, map[OutEvent,tuple[str token, str name]] outTokens, bool noField];

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

  println("Starting SAGA version 0.1.3");
  h = extractView(view);
 
  println("=============== Processing communication view: " + h.history + " ===============");
  println("Parsing ANTLR grammar file: " + h.grammar + ".g");
  grammarTree = parse(#start[ANTLR], view[file=h.grammar + ".g"]).top;

  println("Generating tracing aspect");
  loc aspectLoc = view[file=h.history+"Aspect.java"];
  str historyAspect;
  println("Aspect saved to <aspectLoc>...");
  if(h.typeName != "") { // Local view
      historyAspect = localAspect(h, grammarTree);
  } else { // Global view
      historyAspect = globalAspect(h, grammarTree);
  }
  writeFile(aspectLoc,historyAspect);
  println("Successfully wrote tracing aspect to <aspectLoc>");
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
  
{FormalParameter ","}* makeParameters(list[FormalParameter] params) {
    FormalParameters result = (FormalParameters) ``;
    
    for (param <- params) {
       {FormalParameter ","}* prefix = result.elements;
       result = (FormalParameters) `<{FormalParameter ","}* prefix>, <FormalParameter param>`;
    }
    
    return result.elements;
}

/* Creates a token class representing an incoming constructor return in local history of object of type typeName
 * to store the attributes involved in the event
 * @param e   The event for which the token class must be created
 * @param typeName   The type of the object under test
 * @param eventName   The name that will be used for the token class storing the attributes involved in the event
 * @param historyClass   The name of the history class (only used for printing)
 * @return   The token class (as a string) for the communication event
*/
private str tokenClassCons(InEvent e, str typeName, str eventName, str historyClass) {
    params = [elem | elem <- e.h.p.elements];
    caller = [FormalParameter] "Object caller";
    callee = [FormalParameter] "<typeName> callee";
    result = [FormalParameter] "<typeName> result";
    thread = [FormalParameter] "long threadId";
    params = [caller, callee, *params, result, thread];
    
    return txtTokenClass(makeParameters(params), eventName, typeName, historyClass);
}

private str tokenClassMethod(InEvent e, str typeName, str eventName, str historyClass) {
    params = [elem | elem <- e.h.d.p.elements];
    caller = [FormalParameter] "Object caller";
    callee = [FormalParameter] "<typeName> callee";
    params = [caller, callee, *params];
    
    if ((MethodRes) `void` !:= e.h.r && "return" == "<e.cr>") {
      result = [FormalParameter] "<e.h.r> result";
      params = params + [result];
    }
    thread = [FormalParameter] "long threadId";
    params = [*params, thread];
    
    return txtTokenClass(makeParameters(params), eventName, "<e.h.d.id>", historyClass);
}

private str tokenClassCons(OutEvent e, str typeName, str eventName, str historyClass) {
    params = [ elem | elem <- e.h.p.elements];
    caller = [FormalParameter] "<typeName == "" ? "Object" : typeName> caller";
    callee = [FormalParameter] "<e.h.t> callee";
    params = [caller, callee, *params];
    
    if ("return" == "<e.cr>") {
      result = <[FormalParameter] "<e.h.t> result">;
      params = [*params, result];
    }
    thread = [FormalParameter] "long threadId";
    params = [*params, thread];
    
    return txtTokenClass(makeParameters(params), eventName, "new_<e.h.t>", historyClass);
}

private str tokenClassMethod(OutEvent e, str typeName, str eventName, str historyClass) {
    params = [ elem | elem <- e.h.d.p.elements];
    caller = [FormalParameter] "<typeName == "" ? "Object" : typeName> caller";
    callee = [FormalParameter] "<e.h.t> callee";
    params = [caller, callee, *params];
    
    if ((MethodRes) `void` !:= e.h.r && "return" == "<e.cr>") {
      result = [FormalParameter] "<e.h.r> result";
      params = [*params, result];
    }
    thread = [FormalParameter] "long threadId";
    params = [*params, thread];
    
    return txtTokenClass(makeParameters(params), eventName, "<e.h.d.id>", historyClass);
}

private FormalParameters getAttributesFromGrammar(ANTLR grammar) {
  if (/(Thing) `start returns [ <FormalParameters formals> ]` := grammar) {
    return formals;
  }
  if (/(Thing) `start` := grammar) {
    return (FormalParameters) ``;
  }
  throw "could not retrieve formals from start non-terminal in grammar";
}


{Expression ","}* makeExpressions(list[Expression] params) {
    Expressions result = (Expressions) ``;
    
    for (param <- params) {
       {Expression ","}* prefix = result.elements;
       result = (Expressions) `<{Expression ","}* prefix>, <Expression param>`;
    }
     
    return result.elements;
}

private {Expression ","}* formalsToParams(list[FormalParameter] formals) {
    return makeExpressions([elem.v | elem <- formals]);
}

private {Expression ","}* formalsToParams(FormalParameters formals) = formalsToParams(formals.elements);

private {Expression ","}* formalsToParams({FormalParameter ","}* formals) {
  return makeExpressions([ f.v | f <- formals]);
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

/* Creates a pointcut for an incoming constructor return in local history of object of type typeName
 * @param e   The event for which a pointcut must be created
 * @param typeName   The type of the object under test
 * @param eventName   The token class storing the attributes involved in the event
 * @param viewName   The name of the enclosing communication view
 * @param noField   Should intertype declarations be used to add history as a new field to the created object?
 * @return   The pointcut (as a string) for the communication event
*/
private str pointcutCons(InEvent e, str typeName, str eventName, str viewName, bool noField) {
    staticParams = [ elem | elem <- e.h.p.elements];
    clr = [FormalParameter] "Object clr";
    params = [clr, *staticParams];
    ret = [FormalParameter] "<typeName> ret";
    histParams = [*staticParams, ret];
    thread = [FormalParameter] "long threadId";
    histParams = [*histParams, thread];
    str aspectName = "<viewName>Aspect";
    
return "/* <e.h.m> new(<e.h.p>) */
       'after(<makeParameters(params)>) returning(<typeName> ret):
       '  (call(<e.h.m> *.new(..)) && this(clr) && args(<formalsToParams(e.h.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '        long threadId = Thread.currentThread().getId();
       '    <if(/java(x?)\..*/ := typeName || noField) {>
       '        if(h.get(ret) == null) {
       '            h.put(ret, new <viewName>());
       '        }
       '        h.get(ret).update(new <eventName>(clr, ret, <formalsToParams(histParams)>));
       '    <} else {>
       '        ret.h.update(new <eventName>(clr, ret, <formalsToParams(histParams)>));
       '    <}>
       '}
       '
       'after(<makeParameters(staticParams)>) returning(<typeName> ret): // from static method
       '  (call(<e.h.m> *.new(..)) && !this(Object) && args(<formalsToParams(e.h.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '        long threadId = Thread.currentThread().getId();
       '    <if(/java(x?)\..*/ := typeName || noField) {>
       '        if(h.get(ret) == null) {
       '            h.put(ret, new <viewName>());
       '        }
       '        h.get(ret).update(new <eventName>(null, ret, <formalsToParams(histParams)>));
       '    <} else {>
       '        ret.h.update(new <eventName>(null, ret, <formalsToParams(histParams)>));
       '    <}>
       '}
       ";
}

/* Creates a pointcut for an incoming method call/return in local history of object of type typeName
 * @param e   The event for which a pointcut must be created
 * @param typeName   The type of the object under test
 * @param eventName   The token class storing the attributes involved in the event
 * @param viewName   The name of the enclosing communication view
 * @param noField   Should intertype declarations be used to add history as a new field to the callee?
 * @return   The pointcut (as a string) for the communication event
*/
private str pointcutMethod(InEvent e, str typeName, str eventName, str viewName, bool noField) {
    assert /(Modifier) `static` !:= e.h.m:
           "Provided methods in local histories cannot be static: <trim("<e.h>")>";
    cle = [FormalParameter] "<typeName> cle";
    clr = [FormalParameter] "Object clr";
    staticParams = cle + [elem | elem <- e.h.d.p.elements];
    params = clr + staticParams;
    str aspectName = "<viewName>Aspect";

    bool retNonVoidMethod = ("<e.cr>" == "return" && e.h.r != (MethodRes) `void`);
    str retNonVoid        = retNonVoidMethod ? " returning(<e.h.r> ret)" : "";
    str callRet           = ("<e.cr>" == "call") ? "before" : "after";
    histParams = retNonVoidMethod ? (staticParams + [FormalParameter] "<e.h.r> ret")
                                  : staticParams;
    thread = [FormalParameter] "long threadId";
    histParams = [*histParams, thread];

return "/* <e.cr> <e.h.m> <e.h.r> <e.h.d> */
       '<callRet>(<makeParameters(params)>)<retNonVoid>:
       '  (call(<e.h.m> <e.h.r> *.<e.h.d.id>(..)) && this(clr) && target(cle) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus() <if("<e.esc>"=="ExcludeSelfCalls") {>&& clr!=cle <}>)) {
       '        long threadId = Thread.currentThread().getId();
       '    <if(/java(x?)\..*/ := typeName || noField) {>
       '        if(h.get(cle) == null) {
       '            h.put(cle, new <viewName>());
       '        }
       '        h.get(cle).update(new <eventName>(clr, <formalsToParams(histParams)>));
       '    <} else {>
       '        cle.h.update(new <eventName>(clr, <formalsToParams(histParams)>));
       '    <}>
       '}
       '
       '<callRet>(<makeParameters(staticParams)>)<retNonVoid>: // from static method
       '  (call(<e.h.m> <e.h.r> *.<e.h.d.id>(..)) && !this(Object) && target(cle) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '        long threadId = Thread.currentThread().getId();
       '    <if(/java(x?)\..*/ := typeName || noField) {>
       '        if(h.get(cle) == null) {
       '            h.put(cle, new <viewName>());
       '        }
       '        h.get(cle).update(new <eventName>(null, <formalsToParams(histParams)>));
       '    <} else {>
       '        cle.h.update(new <eventName>(null, <formalsToParams(histParams)>));
       '    <}>
       '}
       ";
}

/* Creates a pointcut for an outgoing constructor call/return in local history of object of type typeName
 * @param e   The event for which a pointcut must be created
 * @param typeName   The type of the object under test
 * @param eventName   The token class storing the attributes involved in the event
 * @param viewName   The name of the enclosing communication view
 * @param noField   Should intertype declarations be used to add history as a new field to the caller?
 * @return   The pointcut (as a string) for the communication event
*/
private str pointcutCons(OutEvent e, str typeName, str eventName, str viewName, bool noField) {
    params = [elem | elem <- e.h.p.elements];
    histParams = params;
    clr =[FormalParameter] "<typeName> clr";
    params = [clr, *params];
    str aspectName = "<viewName>Aspect";
    
    bool retNonVoidMethod = ("<e.cr>" == "return");
    str retNonVoid        = retNonVoidMethod ? " returning(<e.h.t> ret)" : "";
    str callRet           = ("<e.cr>" == "call") ? "before" : "after";
    
    histParams = retNonVoidMethod ? (histParams + [FormalParameter] "<e.h.t> ret")
                                  : histParams;
    thread = [FormalParameter] "long threadId";
    histParams = [*histParams, thread];

return "/* <e.cr> <e.h.m> <e.h.t>.new(<e.h.p>) */
       '<callRet>(<makeParameters(params)>)<retNonVoid>:
       '  (call(<e.h.m> <e.h.t>+.new(..)) && this(clr) && args(<formalsToParams(e.h.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '        long threadId = Thread.currentThread().getId();
       '    <if(/java(x?)\..*/ := typeName || noField) {>
       '        if(h.get(clr) == null) {
       '            h.put(clr, new <viewName>());
       '        }
       '        h.get(clr).update(new <eventName>(clr, null<histParams != [] ? ", <formalsToParams(histParams)>" : "">));
       '    <} else {>
       '        clr.h.update(new <eventName>(clr, null<histParams != [] ? ", <formalsToParams(histParams)>" : "">));
       '    <}>
       '}
       ";
}

/* Creates a pointcut for an outgoing method call/return in local history of object of type typeName
 * @param e   The event for which a pointcut must be created
 * @param typeName   The type of the object under test
 * @param eventName   The token class storing the attributes involved in the event
 * @param viewName   The name of the enclosing communication view
 * @param noField   Should intertype declarations be used to add history as a new field to the caller?
 * @return   The pointcut (as a string) for the communication event
*/
private str pointcutMethod(OutEvent e, str typeName, str eventName, str viewName, bool noField) {
    params = [elem | elem <- e.h.d.p.elements];
    histParams = params;
    clr = [FormalParameter] "<typeName> clr";
    cle = [FormalParameter] "<e.h.t> cle";
    ret = [FormalParameter] "<e.h.r> ret";
    staticParams = [clr, *params];
    params = [clr, cle, *params];
    str aspectName = "<viewName>Aspect";

    bool retNonVoidMethod = ("<e.cr>" == "return" && e.h.r != (MethodRes) `void`);
    str retNonVoid        = retNonVoidMethod ? " returning(<e.h.r> ret)" : "";
    str callRet           = ("<e.cr>" == "call") ? "before" : "after";
    
    histParams = retNonVoidMethod ? (histParams + [FormalParameter] "<e.h.r> ret")
                                  : histParams;
    thread = [FormalParameter] "long threadId";
    histParams = [*histParams, thread];
    
    if(/(Modifier) `static` !:= e.h.m) { // non-static method
return "/* <e.cr> <e.h.m> <e.h.r> <e.h.t> <e.h.d> */
       '<callRet>(<makeParameters(params)>)<retNonVoid>:
       '  (call(<e.h.m> <e.h.r> *.<e.h.d.id>(..)) && this(clr) && target(cle) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus() <if("<e.esc>"=="ExcludeSelfCalls") {>&& clr!=cle <}>)) {
       '        long threadId = Thread.currentThread().getId();
       '    <if(/java(x?)\..*/ := typeName || noField) {>
       '        if(h.get(clr) == null) {
       '            h.put(clr, new <viewName>());
       '        }
       '        h.get(clr).update(new <eventName>(clr, cle<histParams != [] ? ", <formalsToParams(histParams)>" : "">));
       '    <} else {>
       '        clr.h.update(new <eventName>(clr, cle<histParams != [] ? ", <formalsToParams(histParams)>" : "">));
       '    <}>
       '}";
    } else { // static method
return "
       '<callRet>(<makeParameters(staticParams)>)<retNonVoid>: // static method
       '  (call(<e.h.m> <e.h.r> <e.h.t>.<e.h.d.id>(..)) && this(clr) && !target(Object) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '        long threadId = Thread.currentThread().getId();
       '    <if(/java(x?)\..*/ := typeName || noField) {>
       '        if(h.get(clr) == null) {
       '            h.put(clr, new <viewName>());
       '        }
       '        h.get(clr).update(new <eventName>(clr, null<histParams != [] ? ", <formalsToParams(histParams)>" : "">));
       '    <} else {>
       '        clr.h.update(new <eventName>(clr, null<histParams != [] ? ", <formalsToParams(histParams)>" : "">));
       '    <}>
       '}
       ";
    }
}

/* Creates a pointcut for a constructor call/return in global history
 * @param e   The event for which a pointcut must be created
 * @param eventName   The token class storing the attributes involved in the event
 * @param viewName   The name of the enclosing communication view
 * @return   The pointcut (as a string) for the communication event
*/
private str pointcutCons(OutEvent e, str eventName, str viewName) {
    params = [elem | elem <- e.h.p.elements];
    histParams = params;
    clr = [FormalParameter] "Object clr";
    params = [clr, *params];
    str aspectName = "<viewName>Aspect";
    
    bool retNonVoidMethod = ("<e.cr>" == "return");
    str retNonVoid        = retNonVoidMethod ? " returning(<e.h.t> ret)" : "";
    str callRet           = ("<e.cr>" == "call") ? "before" : "after";
    
    histParams = retNonVoidMethod ? (histParams + [FormalParameter] "<e.h.t> ret")
                                  : histParams;
    thread = [FormalParameter] "long threadId";
    histParams = [*histParams, thread];
    
    
return "/* <e.cr> <e.h.m> <e.h.t>.new(<e.h.p>) */
       '<callRet>(<makeParameters(params)>)<retNonVoid>:
       '  (call(<e.h.m> <e.h.t>+.new(..)) && this(clr) && args(<formalsToParams(e.h.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '    long threadId = Thread.currentThread().getId();
       '    h.update(new <eventName>(clr, null<histParams != [] ? ", <formalsToParams(histParams)>" : "">));
       '}
       '
       '<callRet>(<e.h.p>)<retNonVoid>: // static method
       '  (call(<e.h.m>  <e.h.t>+.new(..)) && !this(Object) && args(<formalsToParams(e.h.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
           '    long threadId = Thread.currentThread().getId();
       '    h.update(new <eventName>(null, null<histParams != [] ? ", <formalsToParams(histParams)>" : "">));
       '}
       ";
}

/* Creates a pointcut for a method call/return in global history
 * @param e   The event for which a pointcut must be created
 * @param eventName   The token class storing the attributes involved in the event
 * @param viewName   The name of the enclosing communication view
 * @return   The pointcut (as a string) for the communication event
*/
private str pointcutMethod(OutEvent e, str eventName, str viewName) {
    staticParams1 = [elem | elem <- e.h.d.p.elements];
    histParams = staticParams1;
    cle = [FormalParameter] "<e.h.t> cle";
    clr = [FormalParameter] "Object clr";
    staticParams2 = [cle, *staticParams1];
    staticParams1 = [clr, *staticParams1];
    params = [clr, *staticParams2];
    str aspectName = "<viewName>Aspect";

    bool retNonVoidMethod = ("<e.cr>" == "return" && e.h.r != (MethodRes) `void`);
    str retNonVoid        = retNonVoidMethod ? " returning(<e.h.r> ret)" : "";
    str callRet           = ("<e.cr>" == "call") ? "before" : "after";
    
    histParams = retNonVoidMethod ? [*histParams, ret]: histParams;
    thread = [FormalParameter] "long threadId";
    histParams = [*histParams, thread];
    
    if(/(Modifier) `static` !:= e.h.m) { // to non-static method
return "/* <e.cr> <e.h.m> <e.h.r> <e.h.t> <e.h.d> */
       '<callRet>(<makeParameters(params)>)<retNonVoid>: // from non-static method to non-static method
       '  (call(<e.h.m> <e.h.r> *.<e.h.d.id>(..)) && this(clr) && target(cle) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus() <if("<e.esc>"=="ExcludeSelfCalls") {>&& clr!=cle <}>)) {
       '    long threadId = Thread.currentThread().getId();
       '    h.update(new <eventName>(clr, cle<histParams != [] ? ", <formalsToParams(histParams)>" : "">));
       '}
       '
       '<callRet>(<makeParameters(staticParams2)>)<retNonVoid>: // from static method to non-static method
       '  (call(<e.h.m> <e.h.r> *.<e.h.d.id>(..)) && !this(Object) && target(cle) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '    long threadId = Thread.currentThread().getId();
       '    h.update(new <eventName>(null, cle<histParams != [] ? ", <formalsToParams(histParams)>" : "">));
       '}";
    } else { // to static method
return "
       '<callRet>(<makeParameters(staticParams1)>)<retNonVoid>: // from non-static method to static method
       '  (call(<e.h.m> <e.h.r> <e.h.t>.<e.h.d.id>(..)) && this(clr) && !target(Object) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '    long threadId = Thread.currentThread().getId();
       '    h.update(new <eventName>(clr, null<histParams != [] ? ", <formalsToParams(histParams)>" : "">));
       '}
       '
       '<callRet>(<e.h.d.p>)<retNonVoid>: // from static method to static method
       '  (call(<e.h.m> <e.h.r> <e.h.t>.<e.h.d.id>(..)) && !this(Object) && !target(Object) && args(<formalsToParams(e.h.d.p)>)
       '   && if(<aspectName>.class.desiredAssertionStatus())) {
       '    long threadId = Thread.currentThread().getId();
       '    h.update(new <eventName>(null, null<histParams != [] ? ", <formalsToParams(histParams)>" : "">));
       '}
       ";
    }
}

private str localAspect(viewStruct hv, ANTLR grammar) {
  FormalParameters attributes = getAttributesFromGrammar(grammar);

return "<grammar.h ? "">
       'import java.util.IdentityHashMap; // stores objToId
       'import org.antlr.runtime.*; // for use in <hv.history>
       'import java.util.ArrayList; // for use in <hv.history>
       'import java.util.Iterator; // for use in <hv.history>
       'import java.util.HashSet; // for use in <hv.history>
       'import java.util.HashMap; // for use in <hv.history>
       '
       'aspect <hv.history>Aspect {
       '    <if(/java(x?)\..*/ := hv.typeName || hv.noField) {>
       '        private static IdentityHashMap\<Object, <hv.history>\> h = new IdentityHashMap\<Object, <hv.history>\>();
       '    <} else {>
       '        private <hv.history> <hv.typeName>.h = new <hv.history>();
       '    <}>
       '
       '
       '///////////////////////////////////////////////////////
       '/////////////////////// Events ////////////////////////
       '///////////////////////////////////////////////////////
       '<for (InEvent e <- hv.inTokens) {>
       '  <if(e is InCall)  {>
       '    <tokenClassMethod(e, hv.typeName, hv.inTokens[e].name, hv.history)>
       '    <pointcutMethod(e, hv.typeName, hv.inTokens[e].name, hv.history, hv.noField)>
       '  <} else {> <if(e is InCons) {>
       '    <tokenClassCons(e, hv.typeName, hv.inTokens[e].name, hv.history)>
       '    <pointcutCons(e, hv.typeName, hv.inTokens[e].name, hv.history, hv.noField)>
       '  <}> <}>
       '///////////////////////////////////////////////////////
       '///////////////////////////////////////////////////////
       '<}>
       '
       '<for (OutEvent e <- hv.outTokens) {>
       '  <if(e is OutCall) {>
       '    <tokenClassMethod(e, hv.typeName, hv.outTokens[e].name, hv.history)>
       '    <pointcutMethod(e, hv.typeName, hv.outTokens[e].name, hv.history, hv.noField)>
       '  <} else {> <if(e is OutCons) {>
       '    <tokenClassCons(e, hv.typeName, hv.outTokens[e].name, hv.history)>
       '    <pointcutCons(e,hv.typeName, hv.outTokens[e].name, hv.history, hv.noField)>
       '  <}> <}>
       '///////////////////////////////////////////////////////
       '///////////////////////////////////////////////////////
       '<}>
       '
       '///////////////////////////////////////////////////////
       '/////////////////////// History class /////////////////
       '///////////////////////////////////////////////////////
       '    <historyContainer(hv, attributes)>
       '}";
}

private str globalAspect(viewStruct hv, ANTLR grammar) {
  FormalParameters attributes = getAttributesFromGrammar(grammar);

return "<grammar.h ? "">
       'import java.util.IdentityHashMap; // for use in <hv.history>
       'import org.antlr.runtime.*; // for use in <hv.history>
       'import java.util.ArrayList; // for use in <hv.history>
       'import java.util.Iterator; // for use in <hv.history>
       'import java.util.HashSet; // for use in <hv.history>
       'import java.util.HashMap; // for use in <hv.history>
       '
       'aspect <hv.history>Aspect {
       '    static <hv.history> h = new <hv.history>();
       '
       '///////////////////////////////////////////////////////
       '/////////////////////// Events ////////////////////////
       '///////////////////////////////////////////////////////
       '<for (OutEvent e <- hv.outTokens) {>
       '  <if(e is OutCall) {>
       '    <tokenClassMethod(e, "", hv.outTokens[e].name, hv.history)>
       '    <pointcutMethod(e, hv.outTokens[e].name, hv.history)>
       '  <} else {> <if(e is OutCons) {>
       '    <tokenClassCons(e, "", hv.outTokens[e].name, hv.history)>
       '    <pointcutCons(e, hv.outTokens[e].name, hv.history)>
       '  <}> <}>
       '///////////////////////////////////////////////////////
       '///////////////////////////////////////////////////////
       '<}>
       '
       '///////////////////////////////////////////////////////
       '/////////////////////// History class /////////////////
       '///////////////////////////////////////////////////////
       '    <historyContainer(hv, attributes)>
       '}";
}

private str updateMethod(str grammarName, str callRet, MethodRes retType, {FormalParameter ","}* params, str eventName, str token) {
return "public synchronized void update(<eventName> e) {
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

private str historyContainer(viewStruct hv, FormalParameters attributes) {
return "
       'public static class <hv.history> implements TokenSource {
       '  public  static IdentityHashMap\<Object, Integer\> objToId = new IdentityHashMap\<Object, Integer\>();
       '  public  static HashMap\<Integer, Object\> idToObj = new HashMap\<Integer, Object\>();
       '  private HashSet\<Integer\> actors = new HashSet\<Integer\>();
       '
       '  private ArrayList\<CommonToken\> _L = new ArrayList\<CommonToken\>();
       '  private Integer _currentToken;
       '  <if ( (FormalParameters) `<Modifier* _> <Type t> <VariableDeclaratorId _>` := attributes) {>private <t> _start; // Synthesized attribute of start non-terminal
       '  <} else{><if (!((FormalParameters) `` := attributes)) {>private <hv.grammar>Parser.start_return _start; // Synthesized attributes of start non-terminal<}><}>
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
       '    <if(hv.typeName == "") {>
       '    System.err.println(\"=== ERROR! Global history of view <hv.history> (events: \" + Integer.toString(_L.size()-2) + \") violates grammar <hv.grammar>.g === \\n\");
       '    <} else {>
       '    System.err.println(\"=== ERROR! Local history of view <hv.history> (events: \" + Integer.toString(_L.size()-2) + \") of <hv.typeName> object violates grammar <hv.grammar>.g === \\n\");
       '    <}>
       '
       '    // Print actors of the sequence diagram
       '    Iterator\<Integer\> it = actors.iterator();
       '    while(it.hasNext()) {
       '        Integer objId = it.next();
       '        if(idToObj.get(objId) != null) {
       '          System.out.println(\"o\" + objId + \":\" + idToObj.get(objId).getClass().getName());
       '        } else {
       '          System.out.println(\"o\" + objId + \":Object\");
       '        }
       '    }
       '    // Print messages between actors
       '    System.out.println(\"\");
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
       '      <if ((FormalParameters) `` := attributes) {>
       '      parser.start();
       '      <} else {>
       '      _start = parser.start();
       '      <}>
       '    } catch(Exception r) { // Protocol violation in grammar
       '        print();
       '        assert false;
       '    } catch(Error r) { // Assertion Failure in grammar
       '        print();
       '        assert false;
       '    }
       '  }
       '
       '  <if ( (FormalParameters) `<Modifier* _> <Type t> <VariableDeclaratorId id>` := attributes) {>
       '  public <t> <id>() {
       '    return _start;
       '  }
       '  <} else {><for (FormalParameter f <- attributes.elements) {>
       '  public <f.t> <f.v>() {
       '    return _start.<f.v>;
       '  }
       '  <}><}>
       '
       '  <for (InEvent e <- hv.inTokens) {>
       '    <if(e is InCall) {>
       '      <updateMethod(hv.grammar, "<e.cr>", e.h.r, e.h.d.p.elements, hv.inTokens[e].name, hv.inTokens[e].token)>
       '    <} else          { typeName = [MethodRes] "<hv.typeName>";> <updateMethod(hv.grammar, "return", (MethodRes) `<MethodRes typeName>`, e.h.p.elements, hv.inTokens[e].name, hv.inTokens[e].token)> <}>
       '  <}>
       '  <for (OutEvent e <- hv.outTokens) {>
       '    <if(e is OutCall) {>
       '      <updateMethod(hv.grammar, "<e.cr>", e.h.r, e.h.d.p.elements, hv.outTokens[e].name, hv.outTokens[e].token)>
       '    <} else           { typeName = [MethodRes] "<e.h.t>";>
       '      <updateMethod(hv.grammar, "<e.cr>", (MethodRes) `<MethodRes typeName>`, e.h.p.elements, hv.outTokens[e].name, hv.outTokens[e].token)>
       '    <}>
       '  <}>
       '}";
}
