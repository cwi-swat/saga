module lang::view::syntax::View

extend lang::java::syntax::BigJava;
import ParseTree; // for parse()
import Exception; // for catching ParseError


start syntax View
  =  LocalView: "local" "view" Identifier v "grammar" File g "specifies" ClassOrInterfaceType t "{" {  LocalTokenDef ","}+ e "}"
  | GlobalView: "global" "view" Identifier v "grammar" File g                                   "{" { GlobalTokenDef ","}+ e "}"
  ;

syntax File
  = "/"? {Identifier "/"}+ ("." Identifier)?
  ;

syntax LocalTokenDef
  =  InEvent event Identifier terminal
  | OutEvent event Identifier terminal
  ;

syntax GlobalTokenDef
  = OutEvent event Identifier terminal
  ;

syntax InEvent
  = ("call" | "return") cr MethodHeader h
  ;

syntax OutEvent
  = ("call" | "return") cr GlobalMethodHeader h
  ;
  
syntax GlobalMethodHeader
  = Modifier* m MethodRes r ClassOrInterfaceType t "." MethodDeclarator d Throws? th
  ;


alias viewStruct = tuple[str history, str grammar, str typeName, map[InEvent,tuple[str token, str name]] inTokens, map[OutEvent,tuple[str token, str name]] outTokens];

public viewStruct extractView(loc vw) throws ParseError {
    View viewTree = parse(#start[View], vw).top;
    
	if(/<grammarName:.*>.g/ := "<viewTree.g>") {
		if(viewTree is LocalView) {
			return generateUniqueEventNames(
					<"<viewTree.v>",
					grammarName,
					"<viewTree.t>",
	        		( ev:<"<tm>",""> | (LocalTokenDef) `<InEvent ev> <Identifier tm>` <- viewTree.e),
	        		( ev:<"<tm>",""> | (LocalTokenDef) `<OutEvent ev> <Identifier tm>` <- viewTree.e)>);
		} else { // Global view
			return generateUniqueEventNames(
	    			<"<viewTree.v>",
					grammarName,
					"",
	        		(),
	        		( d.event:<"<d.terminal>",""> | (GlobalTokenDef) d <- viewTree.e)>);
		}
	} else {
		throw "grammar filename must have .g extension";
	}
}

private viewStruct generateUniqueEventNames(viewStruct hv) {
	set[str] eventNames = {};
	
	for(InEvent e <- hv.inTokens) {
		str name = "<e.cr>_<e.h.d.id>";  // default event name
		int i=0;
		while(name in eventNames) {
			name = "<name><i>";
			i = i+1;
		}
		eventNames += name;
		hv.inTokens[e].name = name;
	}
	
	for(OutEvent e <- hv.outTokens) {
		str name = "<e.cr>_<e.h.d.id>"; // default event name
		int i=0;
		while(name in eventNames) {
			name = "<name><i>";
			i = i+1;
		}
		eventNames += name;
		hv.outTokens[e].name = name;
	}
	return hv;
}




public start[View] view(str s, loc l) {
  return parse(#start[View], s, l);
}

public start[View] view(loc l) {
  return parse(#start[View], l);
}