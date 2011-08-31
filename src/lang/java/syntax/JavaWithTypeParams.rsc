module lang::java::syntax::JavaWithTypeParams

extend lang::java::syntax::Java;

start syntax CompilationUnit = field: FieldDeclaration; 

syntax ClassType = Identifier "\<" {ClassType ","}+ "\>";