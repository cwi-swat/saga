@license{Copyright CWI --- Jurgen Vinju, Stijn de Gouw 2011}
module Generator

extend lang::java::syntax::BigJava;
extend lang::view::syntax::View;
extend lang::antlr::syntax::ANTLR;
import IO;  
import ToString;    
import String;
          
alias historyVar = tuple[str history, str grammar, map[str,str] tokens, str field];
 
@doc{ 
This is the main function of this application:
Usage: generate(|project://Histories/examples/StackWithSource/StackInterface.java|,|project://Histories/examples/StackWithSource/StackImpl.java|);
  or:  generate(|project://Histories/test/StackInterface.java|,|project://Histories/test/StackImpl.java|);
} 
public int generate(loc interface, loc implementation) {
  if (interface.extension != "java" || implementation.extension != "java")
    throw "unexpected arguments <grammar>, <interface>, <implementation>";

  println("Parsing java interface");
  interfaceTree = parse(#start[CompilationUnit], interface).top;
   
  println("Generating communication event classes");
  generateTokenClasses(interface, interfaceTree);
  
  println("Parsing java implementation");
  implementationTree = parse(#start[CompilationUnit], implementation).top;
  
  println("Parsing communication views");
  histories = getView(interfaceTree);
  
  for(historyVar hv <- histories) {
    println("=============== Processing communication view: " + hv.history + " ===============");
    println("Parsing ANTLR grammar file: " + hv.grammar + ".g");
    grammarTree = parse(#start[ANTLR], interface[file=hv.grammar + ".g"]).top;
    
    println("Generating communication view class");
    generateHistoryContainer(interface, interfaceTree, grammarTree, hv);

    println("Weaving in tracing for history: " + hv.field);
    implementationTree = weaveTracerCalls(implementationTree, interfaceTree, hv.tokens, hv.field);
  }
  
  println("=======================================================================");
  println("Writing new implementation with history updates to disk");
  writeFile(implementation, implementationTree);
  
  return 0;
}

private CompilationUnit weaveTracerCalls(CompilationUnit implementationTree, CompilationUnit interfaceTree, map[str,str] tokens, str history) {
   set[Identifier] methods = { getMethodName(h) | /MethodHeader h := interfaceTree};
   
   newTree = visit(implementationTree) {
     case (MethodDeclaration) `<Modifier* ms> <MethodRes res> <Identifier id>(<{FormalParameter ","}* formals>) { <BlockStatement* stats> }` =>
          (MethodDeclaration) `<Modifier* ms> <MethodRes res> <Identifier id>(<{FormalParameter ","}* formals>) { <BlockStatement* newstats> }`
     when id in methods,
          {Expression ","}* params := formalsToParams(formals),
          BlockStatement* newstats := addHistoryUpdates(stats, id, res, history, params, tokens)
   }
   return newTree;
}

private {Expression ","}* formalsToParams({FormalParameter ","}* formals) {
  result = ({Expression ","}*) ``;
  for ((FormalParameter) `<Modifier* m> <Type t> <VariableDeclaratorId id>` <- formals) {
    if(({Expression ","}*) `` := result) {
      result = ({Expression ","}*) `<[Identifier] "<id>">`;
    } else {
      result = ({Expression ","}*) `<{Expression ","}* result>, <[Identifier] "<id>">`;
    }
  }
  return result;
}

private BlockStatement* addHistoryUpdates(BlockStatement* stats, Identifier id, MethodRes res, str history, {Expression ","}* params, map[str,str] tokens) {
  c = "call_" + toString(id); 
  
  if (c in tokens) {
    stats = addCallUpdate(stats, id, history, params);
  }
  
  r = "return_" + toString(id);
  if (r in tokens) {
    stats = addReturnUpdates(stats, id, res, history, params);
  }
  
  return stats;
}

private BlockStatement* addCallUpdate(BlockStatement* stats, Identifier id, str history, {Expression ","}* params) {
  return (BlockStatement*) `<[Identifier] history>.update(new <[Identifier] "call_<id>">(<{Expression ","}* params>));
                            <stats>`;
}

private BlockStatement* addReturnUpdates(BlockStatement* stats, Identifier id, MethodRes res, str history, {Expression ","}* params) {
  if ((MethodRes) `void` := res) {
    stats = (BlockStatement*) `<stats>
                               <[Identifier] history>.update(new <[Identifier] "return_<id>">(<{Expression ","}* params>));`;
  } else {
    stats = visit(stats) {
    case (ReturnStatement) `return <Expression e>;` =>
         (Statement)       `{<Type res> <[Identifier] "<history>_tmp"> = <Expression e>; <[Identifier] history>.update(new <[Identifier] "return_<id>">(<[Identifier] "<history>_tmp">, <{Expression ","}* params>)); return <[Identifier] "<history>_tmp">;}`
    }
  }
  
  return stats;
}

public void generateTokenClasses(loc target, CompilationUnit interface) {
  set[MethodHeader] methods = { h | /MethodHeader h := interface };

  for (MethodHeader h <- methods) {
    writeFile(target[file="call_<getMethodName(h)>.java"], tokenClass(h, "call"));
    writeFile(target[file="return_<getMethodName(h)>.java"], tokenClass(h, "return"));
  }
}

public Identifier getMethodName(MethodHeader h) {
  if ((MethodHeader) `<Modifier* a> <MethodRes b> <Identifier id> ( <{FormalParameter ","}* c>)` := h) {
    return id;
  }
  rprintln(h);
  throw "unexpected header <h>";
}

private str tokenClass(MethodHeader h, str callReturn) {
  if ((MethodHeader) `<Modifier* _> <MethodRes res> <Identifier id> ( <{FormalParameter ","}* formals>)` := h) {

    {FormalParameter ","}* params = formals;
    if ((MethodRes) `void` !:= res && "return" := callReturn) {
      params = ({FormalParameter ","}*) `<Type res><[VariableDeclaratorId] "result">,<{FormalParameter ","}* formals>`;
    }

    return "public class <callReturn>_<id> extends org.antlr.runtime.CommonToken {
           '  private static final long serialVersionUID = 2L;
           '
           '  <for ((FormalParameter) `<Modifier* ms> <Type t> <VariableDeclaratorId id>` <- formals) {>private final <t> <id>;
           '  public <t> <id>() {
           '    return this.<id>;
           '  }
           '  <}>
           '
           '  <if(!(formals == params)) {>
           '  private final <res> result;
           '  public <res> result() {
           '    return this.result;
           '  }
           '  <}>
           '  
           '  public <callReturn>_<id>(<params>) {
           '    super(-1);
           '    <if(!(formals == params)) {>
           '    this.result = result;
           '    <}>
           '    <for ((FormalParameter) `<Modifier* _> <Type _> <VariableDeclaratorId id>` <- formals) {>
           '    this.<id> = <id>;
           '    <}>
           '  }
           '}";
  }
  throw "unexpected methodhead <h>";
}

private set[historyVar] getView(CompilationUnit interface) {
  set[historyVar] histories = {};
  
  for (/\/\/\s*<v:view.*>\n/ := "<interface>") {
    View viewTree = parse(#View, v);
    if ((View) `view <Identifier v> grammar <gram> { <{TokenDef ","}* tokens> }` := parse(#View, v)) {

      try {
      for (/\/\*@<decl:.*>@\*\// := "<interface>") {
          FieldDeclaration field = parse(#FieldDeclaration, trim(decl));
        

        if ((FieldDeclaration) `<Modifier* _> <[Identifier] v> <Identifier name> = <VariableInitializer _>;` := field) {
          if(/<grammarName:.*>.g/ := "<gram>") {
            histories = histories + {<"<v>", "<grammarName>", ( "<m>":"<tok>" | (TokenDef) `<Identifier m> <Identifier tok>` <- tokens), "<name>">};
          } else {
            throw "grammar filename must have .g extension";
          }
        }
     }
     }
     catch ParseError(loc l): {
        throw "parse error in field declaration \'<decl>\' at column <l.begin.column>";
     }
     
     // throw "no history model variable found corresponding to communication view <v>";
    }
  }
  
  if(histories != {}) {
    return histories;
  } else {
    throw "failed to retrieve communication view from interface";
  }
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

private void generateHistoryContainer(loc target, CompilationUnit interface, ANTLR grammar, historyVar hv) {
  {FormalParameter ","}* attributes = getAttributesFromGrammar(grammar);
  
  writeFile(target[file="<hv.history>.java"],
            historyContainer(hv.history, hv.grammar, { h | /MethodHeader h := interface }, attributes, hv.tokens));
}

private str historyContainer(str historyName, str grammarName, set[MethodHeader] methods, {FormalParameter ","}* attributes, map[str,str] tokens) {
return "
       'import org.antlr.runtime.*;
       'import java.util.ArrayList;
       '
       'public class <historyName> implements TokenSource {
       '  private ArrayList\<CommonToken\> _L = new ArrayList\<CommonToken\>();
       '  private Integer _currentToken;
       '  <if ( ({FormalParameter ","}*) `<Modifier* _> <Type t> <VariableDeclaratorId _>` := attributes) {>private <t> _start; // Synthesized attributes of start non-terminal
       '  <} else{><if (!(({FormalParameter ","}*) `` := attributes)) {>private <grammarName>Parser.start_return _start; // Synthesized attributes of start non-terminal<}><}>
       '  
       '  public <historyName>() {
       '    _L.add(new CommonToken(Token.EOF));
       '    _L.add(new CommonToken(Token.EOF));
       '    parse(); // the empty history
       '  }
       '
       '  // Implemented for TokenSource interface
       '  public String getSourceName() {
       '    return null;
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
       '    <grammarName>Parser parser = new <grammarName>Parser(tokens);
       '
       '    try {
       '      <if (({FormalParameter ","}*) `` := attributes) {>
       '      parser.start();
       '      <} else {>
       '      _start = parser.start();
       '      <}>
       '    } catch(RecognitionException r) {
       '      System.err.println(\"=== ERROR! History violates event protocol structure specified in the grammar === \\n\");
       '      //@ assert false; // Assertion Failure
       '    }
       '  }
       '
       '  <if ( ({FormalParameter ","}*) `<Modifier* _> <Type t> <VariableDeclaratorId id>` := attributes) {>
       '  public <t> <id>() {
       '    return _start;
       '  }
       '  <} else {><for ((FormalParameter) `<Modifier* _> <Type t> <VariableDeclaratorId id>` <- attributes) {>
       '  public <t> <id>() {
       '    return _start.<id>;
       '  }
       '  <}><}>
       '
       '  <for ((MethodHeader) `<Modifier* _> <MethodRes _> <Identifier id> ( <{FormalParameter ","}* _>)` <- methods) {
          r = "return_" + toString(id); c = "call_" + toString(id);>
       '  <if (c in tokens) /* store only if in view */ {>
       '  public void update(<c> e) {
       '       e.setType(<grammarName>Lexer.<tokens[c]>);
       '       _L.add(_L.size()-2, e);
       '       parse();
       '  }
       '  <}>
       '
       '  <if (r in tokens) /* store only if in view */ {>
       '  public void update(<r> e) {
       '       e.setType(<grammarName>Lexer.<tokens[r]>);
       '       _L.add(_L.size()-2, e);
       '       parse();
       '  }
       '  <}>
       '  <}>
       '}";
}