module lang::view::syntax::View

extend lang::std::Whitespace;
extend lang::java::syntax::Lexical;
extend lang::java::syntax::Comment;

syntax File = "/"? {Identifier "/"}+ ("." Identifier)?;
  
start syntax View = "view" Identifier "grammar" File "{" {TokenDef ","}* "}";

syntax TokenDef = Identifier Identifier;