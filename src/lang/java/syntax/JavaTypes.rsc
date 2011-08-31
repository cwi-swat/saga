module lang::java::syntax::JavaTypes 

extend lang::java::syntax::Names;
  

syntax IntegralType
  =  short: "short" !>> [a-z A-Z 0-9 _] 
    |  \int: "int" !>> [a-z A-Z 0-9 _] 
    |  byte: "byte" !>> [a-z A-Z 0-9 _] 
    |  long: "long" !>> [a-z A-Z 0-9 _] 
    |  char: "char" !>> [a-z A-Z 0-9 _] 
  ;

syntax NumericType
  =  IntegralType: IntegralType 
    |  FloatingPointType: FloatingPointType 
  ;

syntax FloatingPointType
  =  float: "float" !>> [a-z A-Z 0-9 _] 
    |  double: "double" !>> [a-z A-Z 0-9 _] 
  ;

syntax ReferenceType
  =  ArrayType: ArrayType 
    |  ClassOrInterfaceType: ClassOrInterfaceType 
  ;

syntax ClassType
  =  ClassOrInterfaceType1: ClassOrInterfaceType 
  ;

syntax InterfaceType
  =  ClassOrInterfaceType2: ClassOrInterfaceType 
  ;

syntax ArrayType
  =  ArrayType1: ArrayType "[" "]" 
    |  PrimitiveType1: PrimitiveType "[" "]" 
    |  Name1: Name "[" "]" 
  ;

syntax PrimitiveType
  =  NumericType: NumericType 
    |  boolean: "boolean" !>> [a-z A-Z 0-9 _] 
  ;

syntax Type
  =  ReferenceType: ReferenceType 
    |  PrimitiveType: PrimitiveType 
  ;

syntax Name
  =  class: Type "." "class" !>> [a-z A-Z 0-9 _] 
  ;

syntax ClassOrInterfaceType
  =  Name: Name 
  ;
