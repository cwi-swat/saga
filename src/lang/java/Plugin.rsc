module lang::java::Plugin

import util::IDE;
extend lang::java::syntax::JavaWithTypeParams;
import ParseTree;

public int main() {
   registerLanguage("Java for Histories", "java", start[CompilationUnit] (str input, loc l) { return parse(#start[CompilationUnit], input, l); });
   return 0;
}