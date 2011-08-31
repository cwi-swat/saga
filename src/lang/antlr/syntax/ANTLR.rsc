module lang::antlr::syntax::ANTLR

extend lang::std::Whitespace;
extend lang::java::syntax::Java;
import ParseTree;
import util::IDE;

start syntax ANTLR = "grammar" Identifier ";" Thing+ ;

lexical Word =  (![\n\t\ \r/] | [/] !>> [/ *])+ !>> ![\n\t\ \r/];

syntax Thing 
  =  Word \ "start"                                                         
  |  "start" "returns" "[" {FormalParameter ","}* "]" /* Word+ ":" */
  |  "start" () !>> "returns"                                                  
  ;
  
syntax Type = Identifier "\<" {Type ","}+ "\>" ;

public start[ANTLR] antlr(str s, loc l) {
  return parse(#start[ANTLR], x, l);
}

public start[ANTLR] antlr(loc l) {
  return parse(#start[ANTLR], l);
}

public int main() {
  registerLanguage("ANTLR", "g", start[ANTLR] (str s, loc l) { return parse(#start[ANTLR], s, l); });
  return 0;
}