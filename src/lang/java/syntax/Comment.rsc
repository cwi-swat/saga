module lang::java::syntax::Comment 

extend basic::Whitespace;

layout LAYOUTLIST 
  = LAYOUT* !>> "//" !>> "/*" !>> [\t\n\ \r\f]
  ;

lexical Comment
  = "//" ![\n]* [\n] 
  | "/*" (![*] | [*] !>> [/])* "*/" 
  ;

syntax LAYOUT
  = Comment 
  ;
