module lang::java::syntax::FieldDecl 

extend lang::java::syntax::Modifiers;
// extend lang::java::syntax::Expressions;
extend lang::java::syntax::JavaTypes;


syntax VariableInitializer
  =  ArrayInitializer: ArrayInitializer 
    |  Expression: Expression 
  ;

syntax FieldDeclaration
  =  \comma-semicolon: Modifier* Type {VariableDeclarator ","}+ ";" 
  ;

syntax VariableDeclarator
  =  equal2: VariableDeclaratorId "=" VariableInitializer 
    |  VariableDeclaratorId: VariableDeclaratorId 
  ;

syntax VariableDeclaratorId
  =  Identifier1: Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] 
    |  VariableDeclaratorId1: VariableDeclaratorId "[" "]" 
  ;

syntax ArrayInitializer
  =  \comma-comma: "{" {VariableInitializer ","}* ","? "}" 
  ;
