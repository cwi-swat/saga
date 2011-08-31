module lang::java::syntax::Interfaces 

extend lang::java::syntax::MethodDecl;
extend lang::java::syntax::Modifiers;


syntax ConstantDeclaration
  =  FieldDeclaration: FieldDeclaration 
  ;

syntax AbstractMethodDeclaration
  =  semicolon4: MethodHeader ";" 
  ;

syntax InterfaceMemberDeclaration
  =  InnerInterfaceDeclaration: InterfaceDeclaration 
    |  AbstractMethodDeclaration: AbstractMethodDeclaration 
    |  ConstantDeclaration: ConstantDeclaration 
    |  InnerClassDeclaration: ClassDeclaration 
  ;

syntax ExtendsInterfaces
  =  \extends-comma: "extends" !>> [a-z A-Z 0-9 _] {InterfaceType ","}+ 
  ;

syntax InterfaceDeclaration
  =  interface: Modifier* "interface" !>> [a-z A-Z 0-9 _] Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] ExtendsInterfaces? InterfaceBody 
  ;

syntax InterfaceBody
  =  \InterfaceMemberDeclaration-s: "{" InterfaceMemberDeclaration* "}" 
  ;
