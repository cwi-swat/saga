module lang::java::syntax::Lexical 

extend basic::NatCon;
extend basic::Whitespace;


lexical HexIntegerLiteral
  = [0] [x X] [0-9 a-f A-F]+ 
  ;

lexical NullLiteral
  = "null" !>> [a-z A-Z 0-9 _] 
  ;

lexical OctalLongLiteral
  = [0] [0-7]+ [l L] 
  ;


lexical CharacterLiteral
  = "\'" SingleCharacter "\'" 
    | "\'" EscapeSequence "\'" 
  ;

lexical BooleanLiteral
  = "true" !>> [a-z A-Z 0-9 _] 
    | "false" !>> [a-z A-Z 0-9 _] 
  ;

syntax Literal
  = @NotSupported="prefer" IntegerLiteral: IntegerLiteral 
    | @NotSupported="prefer" BooleanLiteral: BooleanLiteral 
    | @NotSupported="prefer" FloatingPointLiteral: FloatingPointLiteral !>> [a-z A-Z 0-9 _ .] 
    | @NotSupported="prefer" CharacterLiteral: CharacterLiteral 
    | @NotSupported="prefer" DoubleLiteral: DoubleLiteral !>> [a-z A-Z 0-9 _ .] 
    | @NotSupported="prefer" NullLiteral: NullLiteral 
    | @NotSupported="prefer" LongLiteral: LongLiteral 
    | @NotSupported="prefer" StringLiteral: StringLiteral 
  ;

lexical FloatingPointLiteral
  = [0-9]+ (  [e E]  [+ \-]?  [0-9]+  )? [f F] 
    | "." [0-9]+ (  [e E]  [+ \-]?  [0-9]+  )? [f F] 
    | [0-9]+ "." [0-9]* (  [e E]  [+ \-]?  [0-9]+  )? [f F] 
    | [0-9]+ [e E] [+ \-]? [0-9]+ [f F] 
  ;

lexical DecimalIntegerLiteral
  = [1-9] [0-9]* 
    | "0" 
  ;

lexical DecimalLongLiteral
  = [1-9] [0-9]* [l L] 
    | "0" [l L] 
  ;

lexical EscapeSequence
  = "\\" [0-7] [0-7] 
    | "\\" [0-3] [0-7] [0-7] 
    | "\\" [0-7] 
    | "\\" [b t n f r \" \' \\] 
  ;

lexical SingleCharacter
  = ![\' \\] 
    | UnicodeEscape 
  ;

lexical Identifier
  = "\<init\>" !>> [a-z A-Z 0-9 _] 
    | [A-Z a-z _ $] [A-Z a-z 0-9 _ $]* !>> [a-z A-Z 0-9 _]
    | "\<static-init\>" !>> [a-z A-Z 0-9 _] 
    | "\<default-package\>" !>> [a-z A-Z 0-9 _] 
  ;

lexical StringLiteral
  =  \StringCharacter-s: "\"" StringCharacter* "\"" 
  ;

lexical DoubleLiteral
  = "." [0-9]+ (  [e E]  [+ \-]?  [0-9]+  )? [d D]? 
    | [0-9]+ "." [0-9]* (  [e E]  [+ \-]?  [0-9]+  )? [d D]? 
    | [0-9]+ (  [e E]  [+ \-]?  [0-9]+  )? [d D] 
    | [0-9]+ [e E] [+ \-]? [0-9]+ [d D]? 
  ;

lexical UnicodeEscape
  = "\\" [u]+ [0-9 a-f A-F] [0-9 a-f A-F] [0-9 a-f A-F] [0-9 a-f A-F] 
  ;

lexical OctalIntegerLiteral
  = [0] [0-7]+ 
  ;

syntax LongLiteral
  = @NotSupported="prefer" HexLongLiteral: HexLongLiteral !>> [a-z A-Z 0-9 _ .] 
    | @NotSupported="prefer" DecimalLongLiteral: DecimalLongLiteral !>> [a-z A-Z 0-9 _ .] 
    | @NotSupported="prefer" OctalLongLiteral: OctalLongLiteral !>> [a-z A-Z 0-9 _ .] 
  ;

keyword IdentifierKeywords
  = "super"  
    | "char"  
    | "protected"  
    | "void"  
    | "try"  
    | "double"  
    | "int"  
    | "float"  
    | "false"  
    | "transient"  
    | "switch"  
    | "instanceof"  
    | "byte"  
    | "final"  
    | "class"  
    | "new"  
    | "finally"  
    | "throws"  
    | "abstract"  
    | "throw"  
    | "native"  
    | "return"  
    | "break"  
    | "import"  
    | "implements"  
    | "else"  
    | "true"  
    | "catch"  
    | "long"  
    | "if"  
    | "default"  
    | "static"  
    | "this"  
    | "for"  
    | "interface"  
    | "synchronized"  
    | "private"  
    | "case"  
    | "null"  
    | "volatile"  
    | "public"  
    | "boolean"  
    | "short"  
    | "while"  
    | "package"  
    | "continue"  
    | "extends"  
    | "do"  
  ;

lexical HexLongLiteral
  = [0] [x X] [0-9 a-f A-F]+ [l L] 
  ;

lexical StringCharacter
  = UnicodeEscape 
    | EscapeSequence 
    | ![\" \\] 
  ;

syntax IntegerLiteral
  = @NotSupported="prefer" HexIntegerLiteral: HexIntegerLiteral !>> [a-z A-Z 0-9 _ .] 
    | @NotSupported="prefer" DecimalIntegerLiteral: DecimalIntegerLiteral !>> [a-z A-Z 0-9 _ .] 
    | @NotSupported="prefer" OctalIntegerLiteral: OctalIntegerLiteral !>> [a-z A-Z 0-9 _ .] 
  ;
