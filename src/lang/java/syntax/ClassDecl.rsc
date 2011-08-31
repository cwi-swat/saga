module lang::java::syntax::ClassDecl 

extend lang::java::syntax::MethodDecl;
extend lang::java::syntax::Interfaces;
extend lang::java::syntax::Statements;
extend lang::java::syntax::ConstructorDecl;


syntax StaticInitializer
  =  static1: "static" !>> [a-z A-Z 0-9 _] Block 
  ;

syntax ClassDeclaration
  =  class1: Modifier* "class" !>> [a-z A-Z 0-9 _] Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] Super? Interfaces? ClassBody 
  ;

syntax ClassBodyDeclaration
  =  ClassDeclaration1: ClassDeclaration 
    |  ClassMemberDeclaration: ClassMemberDeclaration 
    |  ConstructorDeclaration: ConstructorDeclaration 
    |  StaticInitializer: StaticInitializer 
    |  ClassDeclaration2: InterfaceDeclaration 
    |  semicolon11: ";" 
  ;

syntax Interfaces
  =  \implements-comma: "implements" !>> [a-z A-Z 0-9 _] {InterfaceType ","}+ 
  ;

syntax ClassBody
  =  \ClassBodyDeclaration-s: "{" ClassBodyDeclaration* "}" 
  ;

syntax Super
  =  extends: "extends" !>> [a-z A-Z 0-9 _] ClassType 
  ;

syntax ClassMemberDeclaration
  =  MethodDeclaration: MethodDeclaration 
    |  FieldDeclaration1: FieldDeclaration 
    |  BlockClassMember: Block 
  ;
