module lang::java::syntax::Names 

extend lang::java::syntax::Lexical;
extend lang::java::syntax::Comment;

syntax SimpleName
  =  Identifier: Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] 
  ;

syntax Name
  = @NotSupported="avoid" \Identifier-p: {Identifier \ IdentifierKeywords "."}+ 
  ;
