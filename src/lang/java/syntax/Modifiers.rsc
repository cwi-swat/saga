module lang::java::syntax::Modifiers 



syntax Modifier
  =  static: "static" !>> [a-z A-Z 0-9 _] 
    |  \private: "private" !>> [a-z A-Z 0-9 _] 
    |  \public: "public" !>> [a-z A-Z 0-9 _] 
    |  final: "final" !>> [a-z A-Z 0-9 _] 
    |  transient: "transient" !>> [a-z A-Z 0-9 _] 
    |  volatile: "volatile" !>> [a-z A-Z 0-9 _] 
    |  abstract: "abstract" !>> [a-z A-Z 0-9 _] 
    |  protected: "protected" !>> [a-z A-Z 0-9 _] 
    |  synchronized1: "synchronized" !>> [a-z A-Z 0-9 _] 
    |  native: "native" !>> [a-z A-Z 0-9 _] 
  ;
