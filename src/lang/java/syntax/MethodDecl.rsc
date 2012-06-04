module lang::java::syntax::MethodDecl 

extend lang::java::syntax::Modifiers;
// extend lang::java::syntax::Statements;
extend lang::java::syntax::JavaTypes;
extend lang::java::syntax::FieldDecl;

 
syntax MethodDeclarator
  =  MethodDeclarator: MethodDeclarator "[" "]" 
    |  comma2: Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] "(" {FormalParameter ","}* ")" 
  ;

syntax MethodBody
  =  Block1: Block 
    |  semicolon3: ";" 
  ;

syntax MethodHeader
  =  MethodHeader: Modifier* MethodRes MethodDeclarator Throws? 
  ;

syntax MethodRes
  =  \type: Type 
    |  \void: "void" !>> [a-z A-Z 0-9 _] 
  ;

syntax Throws
  =  \throws-comma: "throws" !>> [a-z A-Z 0-9 _] {ClassType ","}+ 
  ;

syntax FormalParameter
  =  \Type-VariableDeclaratorId: Modifier* Type VariableDeclaratorId 
  ;

syntax MethodDeclaration
  =  \MethodHeader-MethodBody: MethodHeader MethodBody 
  ;
