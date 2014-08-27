@license{Copyright CWI --- Jurgen Vinju, Stijn de Gouw 2014}
module GeneratorEclipse

import util::IDE;
import lang::view::\syntax::View;

public void enableSyntaxHighlighting() {
	registerLanguage("VIEW", "view", start[View] (str s, loc l) { return view(s, l); });
}