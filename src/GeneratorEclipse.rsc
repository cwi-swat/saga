@license{Copyright CWI --- Jurgen Vinju, Stijn de Gouw 2014}
module GeneratorEclipse

import util::IDE;
extend Generator;

public int main() {
	registerLanguage("VIEW", "view", start[View] (str s, loc l) { return view(s, l); });
	registerLanguage("ANTLR", "g", start[ANTLR] (str s, loc l) { return antlr(s, l); });
	return 0;
}