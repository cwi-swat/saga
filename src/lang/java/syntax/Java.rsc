module lang::java::syntax::Java 

extend lang::java::syntax::ClassDecl;
extend lang::java::syntax::MethodDecl;
extend lang::java::syntax::Comment;
extend lang::java::syntax::Statements;
extend lang::java::syntax::FieldDecl;
extend lang::java::syntax::ConstructorDecl;
extend lang::java::syntax::Comment;

start syntax CompilationUnit
  = @NotSupported="prefer" \PackageDeclaration-opt-ImportDeclaration-s-TypeDeclaration-s: PackageDeclaration? ImportDeclaration* TypeDeclaration+ 
  ;

syntax PackageDeclaration
  =  \package-semicolon: "package" !>> [a-z A-Z 0-9 _] Name ";" 
  ;

syntax ImportDeclaration
  =  SingleTypeImportDeclaration: SingleTypeImportDeclaration 
    |  TypeImportOnDemandDeclaration: TypeImportOnDemandDeclaration 
  ;

syntax SingleTypeImportDeclaration
  =  \import-semicolon: "import" !>> [a-z A-Z 0-9 _] Name ";" 
  ;

syntax TypeDeclaration
  =  ClassDeclaration11: ClassDeclaration 
    |  InterfaceDeclaration: InterfaceDeclaration 
    |  semicolon5: ";" 
  ;

lexical FileHeader
  = "FILE:" ![\n]* "\n" 
  ;

syntax TypeImportOnDemandDeclaration
  =  \import-times-semicolon: "import" !>> [a-z A-Z 0-9 _] Name "." "*" ";" 
  ;

syntax File
  =  \file-with-header: FileHeader CompilationUnit 
  ;
