module lang::antlr::\syntax::ANTLR

extend lang::std::Whitespace;
extend lang::java::\syntax::BigJava;
import ParseTree;






start syntax ANTLR
  = "grammar" Identifier ";" "@header" "{" Header h "}" Thing+
  | "grammar" Identifier ";" Thing+
  ;

syntax Header
  = PackageDeclaration? ImportDeclaration* TypeDeclaration*
  ;

lexical Word
  =  (![\n\t\ \r/] | [/] !>> [/ *])+ !>> ![\n\t\ \r/]
  ;

syntax Thing 
  =  Word \ "start" \ "@header"
  |  "start" "returns" "[" {FormalParameter ","}* "]" /* Word+ ":" */
  |  "start" () !>> "returns"                                                  
  ;
  
syntax Type
  = Identifier "\<" {Type ","}+ "\>"
  ;

public start[ANTLR] antlr(str s, loc l) {
  return parse(#start[ANTLR], s, l);
}

public start[ANTLR] antlr(loc l) {
  return parse(#start[ANTLR], l);
}