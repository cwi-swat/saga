module lang::view::\syntax::View

extend lang::java::\syntax::BigJava;
import ParseTree; // for parse()
import Exception; // for catching ParseError
import String; // for replaceAll


start syntax View
  =  LocalView: "local" "view" Identifier v "grammar" File g "specifies" ClassOrInterfaceType t "noField"? nf "{" {  LocalTokenDef ","}+ e "}"
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
  = InCall: ("call" | "return") cr "ExcludeSelfCalls"? esc MethodHeader h
  | InExec: "exec" cr MethodHeader h
  | InCons: ConsHeader h
  ;

syntax OutEvent
  = OutCall: ("call" | "return") cr "ExcludeSelfCalls"? esc GlobalMethodHeader h
  | OutExec: "exec" cr GlobalMethodHeader h
  | OutCons: ("call" | "return") cr GlobalConsHeader h
  ;
  
syntax GlobalMethodHeader
  = Modifier* m MethodRes r ClassOrInterfaceType t "." MethodDeclarator d Throws? th
  ;
  
syntax ConsHeader
  = Modifier* m "new" "(" FormalParameters p ")" Throws? th
  ;
  
syntax GlobalConsHeader
  = Modifier* m ClassOrInterfaceType t "." "new" "(" FormalParameters p ")" Throws? th
  ;


alias viewStruct = tuple[str history, str grammar, str typeName, map[InEvent,tuple[str token, str name]] inTokens, map[OutEvent,tuple[str token, str name]] outTokens, bool noField];

public viewStruct extractView(loc vw) throws ParseError {
    View viewTree = parse(#start[View], vw).top;
    
	if(/<grammarName:.*>.g/ := "<viewTree.g>") {
		if(viewTree is LocalView) {
			return generateUniqueEventNames(
					<"<viewTree.v>",
					grammarName,
					"<viewTree.t>",
	        		( ev:<"<tm>",""> | (LocalTokenDef) `<InEvent ev> <Identifier tm>` <- viewTree.e),
	        		( ev:<"<tm>",""> | (LocalTokenDef) `<OutEvent ev> <Identifier tm>` <- viewTree.e),
	        		("<viewTree.nf>" == "noField" ? true : false)>);
		} else if(viewTree is GlobalView) {
			return generateUniqueEventNames(
	    			<"<viewTree.v>",
					grammarName,
					"",
	        		(),
	        		( d.event:<"<d.terminal>",""> | (GlobalTokenDef) d <- viewTree.e),
	        		false>);
		}
	} else {
		throw "grammar filename must have .g extension";
	}
}

private viewStruct generateUniqueEventNames(viewStruct hv) {
	set[str] eventNames = {};
	
	for(e <- hv.inTokens + hv.outTokens) {
		str name, defaultName;
		if(e is InCall || e is OutCall) {
			name = defaultName = "<e.cr>_<e.h.d.id>";
		} else if(e is InCons) {
			name = defaultName = replaceAll("new_<hv.typeName>", ".", "_");
		} else if(e is OutCons) {
			name = defaultName = replaceAll("<e.cr>_new_<e.h.t>", ".", "_");
		}
		int i=0;
		while(name in eventNames) {
			name = "<defaultName><i>";
			i = i+1;
		}
		eventNames += name;
		if(e is InCall || e is InCons) hv.inTokens[e].name = name;
		else 		                   hv.outTokens[e].name = name;
	}

	return hv;
}




public start[View] view(str s, loc l) {
  return parse(#start[View], s, l);
}

public start[View] view(loc l) {
  return parse(#start[View], l);
}