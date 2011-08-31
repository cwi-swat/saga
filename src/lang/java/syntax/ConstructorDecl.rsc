module lang::java::syntax::ConstructorDecl 

extend lang::java::syntax::MethodDecl;
extend lang::java::syntax::Modifiers;
extend lang::java::syntax::Statements;


syntax ExplicitConstructorInvocation
  =  \super-comma-semicolon: "super" !>> [a-z A-Z 0-9 _] "(" {Expression ","}* ")" ";" 
    |  \this-comma-semicolon: "this" !>> [a-z A-Z 0-9 _] "(" {Expression ","}* ")" ";" 
  ;
    
syntax ConstructorDeclaration
  =  \Modifier-s-ConstructorDeclarator-Throws-opt-ConstructorBody: Modifier* ConstructorDeclarator Throws? ConstructorBody 
  ;

syntax ConstructorBody
  =  \ExplicitConstructorInvocation-opt-BlockStatement-s: "{" ExplicitConstructorInvocation? BlockStatement* "}" 
  ;

syntax ConstructorDeclarator
  =  comma5: SimpleName "(" {FormalParameter ","}* ")" 
  ;
