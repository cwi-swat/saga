module lang::java::syntax::BigJava 

syntax StaticInitializer
  =  static1: "static" !>> [a-z A-Z 0-9 _] Block 
  ;
  
lexical NatCon
  =  digits: [0-9]+ 
  ;
    
syntax LAYOUT
  = [\  \t \n \r] 
  ;
  

syntax ClassDeclaration
  =  class1: Modifier* "class" !>> [a-z A-Z 0-9 _] Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] Super? Interfaces? ClassBody 
  ;

syntax ClassBodyDeclaration
  =  ClassDeclaration1: ClassDeclaration 
    |  ClassMemberDeclaration: ClassMemberDeclaration 
    |  ConstructorDeclaration: ConstructorDeclaration 
    |  StaticInitializer: StaticInitializer 
    |  ClassDeclaration2: InterfaceDeclaration 
    |  semicolon11: ";" 
  ;

syntax Interfaces
  =  \implements-comma: "implements" !>> [a-z A-Z 0-9 _] {InterfaceType ","}+ 
  ;

syntax ClassBody
  =  \ClassBodyDeclaration-s: "{" ClassBodyDeclaration* "}" 
  ;

syntax Super
  =  extends: "extends" !>> [a-z A-Z 0-9 _] ClassType 
  ;

syntax ClassMemberDeclaration
  =  MethodDeclaration: MethodDeclaration 
    |  FieldDeclaration1: FieldDeclaration 
    |  BlockClassMember: Block 
  ;

layout LAYOUTLIST 
  = LAYOUT* !>> "//" !>> "/*" !>> [\t\n\ \r\f]
  ;

lexical Comment
  = @category="Comment" "//" ![\n]* [\n] 
    | @category="Comment" "/*" CommentChar* "*/" 
  ;

lexical CommentChar
  = ![*] 
    | Asterisk !>> [/] 
  ;

lexical Asterisk
  = [*] 
  ;

syntax LAYOUT
  = Comment 
  ;

syntax ExplicitConstructorInvocation
  =  \super-comma-semicolon: "super" !>> [a-z A-Z 0-9 _] "(" {Expression ","}* ")" ";" 
    |  \this-comma-semicolon: "this" !>> [a-z A-Z 0-9 _] "(" {Expression ","}* ")" ";" 
  ;
    
syntax ConstructorDeclaration
  =  \Modifier-s-ConstructorDeclarator-Throws-opt-ConstructorBody: Modifier* ConstructorDeclarator Throws? ConstructorBody 
  ;

syntax ConstructorBody
  =  \ExplicitConstructorInvocation-opt-BlockStatement-s: "{" ExplicitConstructorInvocation? BlockStatement* "}" 
  ;

syntax ConstructorDeclarator
  =  comma5: SimpleName "(" {FormalParameter ","}* ")" 
  ;

syntax DimExprInitialized
  =  \Expression-opt: "[" Expression? "]" 
  ;

syntax StatementExpression
  = @NotSupported="prefer" decr21: Expression "--" 
    | @NotSupported="prefer" incr21: Expression "++" 
    | @NotSupported="prefer" decr31: "--" Expression 
    | @NotSupported="prefer" incr31: "++" Expression 
    |  Assignment: Assignment 
  ;

syntax ClassInstanceCreationExpression
  =  \new-comma1: "new" !>> [a-z A-Z 0-9 _] ClassType "(" {Expression ","}* ")" ClassBody 
    |  \new-comma: "new" !>> [a-z A-Z 0-9 _] ClassType "(" {Expression ","}* ")" 
  ;

syntax Primary
  =  PrimaryNoNewArray: PrimaryNoNewArray 
    |  ArrayCreationExpression: ArrayCreationExpression 
  ;

syntax ArrayCreationExpression
  =  new1: "new" !>> [a-z A-Z 0-9 _] ClassOrInterfaceType DimExpr+ Dim* 
    |  new2: "new" !>> [a-z A-Z 0-9 _] PrimitiveType DimExprInitialized+ ArrayInitializer 
    |  new: "new" !>> [a-z A-Z 0-9 _] PrimitiveType DimExpr+ Dim* 
    |  new3: "new" !>> [a-z A-Z 0-9 _] ClassOrInterfaceType DimExprInitialized+ ArrayInitializer 
  ;

syntax MethodInvocation
  = @NotSupported="prefer" MethodInvocationConstructor: Primary "." ClassInstanceCreationExpression 
    |  comma21: Primary "." Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] "(" {Expression ","}* ")" 
    | @NotSupported="prefer" \super-comma: "super" !>> [a-z A-Z 0-9 _] "." Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] "(" {Expression ","}* ")" 
    | @NotSupported="avoid" comma11: Name "(" {Expression ","}* ")" 
  ;

syntax AssignmentOperator
  =  assignSR: "\>\>=" 
    |  assignOr: "|=" 
    |  assignMin: "-=" 
    |  assignAnd: "&=" 
    |  assignMul: "*=" 
    |  \AssignmentOperator-dunno-b_0: "\>\>\>=" 
    |  equal1: "=" 
    |  assignDiv: "/=" 
    |  assignSL: "\<\<=" 
    |  assignPlus: "+=" 
    |  assignExp: "^=" 
    |  assignMod: "%=" 
  ;

syntax FieldAccess
  = @NotSupported="prefer" super: "super" !>> [a-z A-Z 0-9 _] "." Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] 
    |  \Primary-Identifier: Primary "." Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] 
    | @NotSupported="avoid" Name11: Name 
  ;

syntax PrimaryNoNewArray
  =  this0: "this" !>> [a-z A-Z 0-9 _] 
    |  ArrayAccess: ArrayAccess 
    |  FieldAccess: FieldAccess 
    | @NotSupported="avoid" Literal: Literal 
    |  Expression1: "(" Expression ")" 
    |  MethodInvocation1: MethodInvocation 
    |  ClassInstanceCreationExpression1: ClassInstanceCreationExpression 
    |  this1: Name "." "this" !>> [a-z A-Z 0-9 _] 
  ;

syntax LeftHandSide
  =  ArrayAccess1: ArrayAccess 
    |  FieldAccess1: FieldAccess 
  ;

syntax Assignment
  =  \LeftHandSide-AssignmentOperator-Expression: LeftHandSide AssignmentOperator Expression 
  ;

syntax DimExpr
  =  Expression2: "[" Expression "]" 
  ;

syntax ArrayAccess
  = @NotSupported="prefer" \PrimaryNoNewArray-Expression: PrimaryNoNewArray "[" Expression "]" 
    |  \Name-Expression: Name "[" Expression "]" 
  ;

syntax Dim
  =  \Dim-dunno-a_0: "[" "]" 
  ;

syntax Expression
  =  not: "!" Expression 
    |  \PrimitiveType-Dim-s-Expression: "(" PrimitiveType Dim* ")" Expression 
    | @NotSupported="prefer" Primary: Primary 
    | left lt1: Expression "\<" Expression 
    |  minus: "-" Expression 
    | left \Expression-Expression31: Expression "^" Expression 
    | left times1: Expression "*" Expression 
    | left ge1: Expression "\>=" Expression 
    | left \plus-Expression11: Expression "+" Expression 
    | left div1: Expression "/" Expression 
    |  instanceof: Expression "instanceof" !>> [a-z A-Z 0-9 _] ReferenceType 
    |  \Name-Dim-p-Expression: "(" Name Dim+ ")" Expression 
    | left le1: Expression "\<=" Expression 
    |  plus: "+" Expression 
    | left \shift-right1: Expression "\>\>" Expression 
    | left equal1: Expression "==" Expression 
    | left gt1: Expression "\>" Expression 
    |  tilde: "~" Expression 
    | @NotSupported="prefer" colon2: Expression "?" Expression ":" Expression 
    |  Assignment1: Assignment 
    | left \shift-left1: Expression "\<\<" Expression 
    | left or11: Expression "||" Expression 
    | left and11: Expression "&&" Expression 
    |  StatementExpression: StatementExpression 
    | left Expression12: Expression "\>\>\>" Expression 
    | left \mod-Expression11: Expression "%" Expression 
    | left \minus-Expression11: Expression "-" Expression 
    | left \not-equal1: Expression "!=" Expression 
    | left address11: Expression "&" Expression 
    |  \Cast-Expression: "(" Type ")" Expression 
    | left bar11: Expression "|" Expression 
    |  \Cast-Expression: "(" Type ")" Expression 
      > @NotSupported="prefer" incr21: Expression "++" 
        | @NotSupported="prefer" decr21: Expression "--" 
      >  not: "!" Expression 
        |  minus: "-" Expression 
        | @NotSupported="prefer" incr31: "++" Expression 
        | @NotSupported="prefer" decr31: "--" Expression 
        |  plus: "+" Expression 
        |  tilde: "~" Expression 
      >  \PrimitiveType-Dim-s-Expression: "(" PrimitiveType Dim* ")" Expression 
      >  \Name-Dim-p-Expression: "(" Name Dim+ ")" Expression 
      > left times1: Expression "*" Expression 
      > left div1: Expression "/" Expression 
      > left \mod-Expression11: Expression "%" Expression 
      > left \plus-Expression11: Expression "+" Expression 
      > left \minus-Expression11: Expression "-" Expression 
      > left \shift-left1: Expression "\<\<" Expression 
      > left \shift-right1: Expression "\>\>" Expression 
      > left Expression12: Expression "\>\>\>" Expression 
      > left gt1: Expression "\>" Expression 
        | left lt1: Expression "\<" Expression 
        | left ge1: Expression "\>=" Expression 
        | left le1: Expression "\<=" Expression 
      >  instanceof: Expression "instanceof" !>> [a-z A-Z 0-9 _] ReferenceType 
      > left equal1: Expression "==" Expression 
      > left \not-equal1: Expression "!=" Expression 
      > left address11: Expression "&" Expression 
      > left \Expression-Expression31: Expression "^" Expression 
      > left bar11: Expression "|" Expression 
      > left and11: Expression "&&" Expression 
      > left or11: Expression "||" Expression 
      >  Assignment1: Assignment 
  ;

syntax VariableInitializer
  =  ArrayInitializer: ArrayInitializer 
    |  Expression: Expression 
  ;

syntax FieldDeclaration
  =  \comma-semicolon: Modifier* Type {VariableDeclarator ","}+ ";" 
  ;

syntax VariableDeclarator
  =  equal2: VariableDeclaratorId "=" VariableInitializer 
    |  VariableDeclaratorId: VariableDeclaratorId 
  ;

syntax VariableDeclaratorId
  =  Identifier1: Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] 
    |  VariableDeclaratorId1: VariableDeclaratorId "[" "]" 
  ;

syntax ArrayInitializer
  =  \comma-comma: "{" {VariableInitializer ","}* ","? "}" 
  ;

syntax ConstantDeclaration
  =  FieldDeclaration: FieldDeclaration 
  ;

syntax AbstractMethodDeclaration
  =  semicolon4: MethodHeader ";" 
  ;

syntax InterfaceMemberDeclaration
  =  InnerInterfaceDeclaration: InterfaceDeclaration 
    |  AbstractMethodDeclaration: AbstractMethodDeclaration 
    |  ConstantDeclaration: ConstantDeclaration 
    |  InnerClassDeclaration: ClassDeclaration 
  ;

syntax ExtendsInterfaces
  =  \extends-comma: "extends" !>> [a-z A-Z 0-9 _] {InterfaceType ","}+ 
  ;

syntax InterfaceDeclaration
  =  interface: Modifier* "interface" !>> [a-z A-Z 0-9 _] Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] ExtendsInterfaces? InterfaceBody 
  ;

syntax InterfaceBody
  =  \InterfaceMemberDeclaration-s: "{" InterfaceMemberDeclaration* "}" 
  ;

start syntax CompilationUnit
  = @NotSupported="prefer" \PackageDeclaration-opt-ImportDeclaration-s-TypeDeclaration-s: PackageDeclaration? ImportDeclaration* TypeDeclaration+ 
  ;

syntax PackageDeclaration
  =  \package-semicolon: "package" !>> [a-z A-Z 0-9 _] Name ";" 
  ;

syntax ImportDeclaration
  =  SingleTypeImportDeclaration: SingleTypeImportDeclaration 
    |  TypeImportOnDemandDeclaration: TypeImportOnDemandDeclaration 
  ;

syntax SingleTypeImportDeclaration
  =  \import-semicolon: "import" !>> [a-z A-Z 0-9 _] Name ";" 
  ;

syntax TypeDeclaration
  =  ClassDeclaration11: ClassDeclaration 
    |  InterfaceDeclaration: InterfaceDeclaration 
    |  semicolon5: ";" 
  ;

lexical FileHeader
  = "FILE:" ![\n]* "\n" 
  ;

syntax TypeImportOnDemandDeclaration
  =  \import-times-semicolon: "import" !>> [a-z A-Z 0-9 _] Name "." "*" ";" 
  ;

syntax File
  =  \file-with-header: FileHeader CompilationUnit 
  ;

syntax IntegralType
  =  short: "short" !>> [a-z A-Z 0-9 _] 
    |  \int: "int" !>> [a-z A-Z 0-9 _] 
    |  byte: "byte" !>> [a-z A-Z 0-9 _] 
    |  long: "long" !>> [a-z A-Z 0-9 _] 
    |  char: "char" !>> [a-z A-Z 0-9 _] 
  ;

syntax NumericType
  =  IntegralType: IntegralType 
    |  FloatingPointType: FloatingPointType 
  ;

syntax FloatingPointType
  =  float: "float" !>> [a-z A-Z 0-9 _] 
    |  double: "double" !>> [a-z A-Z 0-9 _] 
  ;

syntax ReferenceType
  =  ArrayType: ArrayType 
    |  ClassOrInterfaceType: ClassOrInterfaceType 
  ;

syntax ClassType
  =  ClassOrInterfaceType1: ClassOrInterfaceType 
  ;

syntax InterfaceType
  =  ClassOrInterfaceType2: ClassOrInterfaceType 
  ;

syntax ArrayType
  =  ArrayType1: ArrayType "[" "]" 
    |  PrimitiveType1: PrimitiveType "[" "]" 
    |  Name1: Name "[" "]" 
  ;

syntax PrimitiveType
  =  NumericType: NumericType 
    |  boolean: "boolean" !>> [a-z A-Z 0-9 _] 
  ;

syntax Type
  =  ReferenceType: ReferenceType 
    |  PrimitiveType: PrimitiveType 
  ;

syntax Name
  =  class: Type "." "class" !>> [a-z A-Z 0-9 _] 
  ;

syntax ClassOrInterfaceType
  =  Name: Name 
  ;

start syntax CompilationUnit = field: FieldDeclaration; 

syntax ClassType = Identifier "\<" {ClassType ","}+ "\>";


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

syntax MethodDeclarator
  =  MethodDeclarator: MethodDeclarator "[" "]" 
    |  comma2: Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] "(" {FormalParameter ","}* ")" 
  ;

syntax MethodBody
  =  Block1: Block 
    |  semicolon3: ";" 
  ;

syntax MethodHeader
  =  MethodHeader: Modifier* MethodRes MethodDeclarator Throws? 
  ;

syntax MethodRes
  =  \type: Type 
    |  \void: "void" !>> [a-z A-Z 0-9 _] 
  ;

syntax Throws
  =  \throws-comma: "throws" !>> [a-z A-Z 0-9 _] {ClassType ","}+ 
  ;

syntax FormalParameter
  =  \Type-VariableDeclaratorId: Modifier* Type VariableDeclaratorId 
  ;

syntax MethodDeclaration
  =  \MethodHeader-MethodBody: MethodHeader MethodBody 
  ;

syntax Modifier
  =  static: "static" !>> [a-z A-Z 0-9 _] 
    |  \private: "private" !>> [a-z A-Z 0-9 _] 
    |  \public: "public" !>> [a-z A-Z 0-9 _] 
    |  final: "final" !>> [a-z A-Z 0-9 _] 
    |  transient: "transient" !>> [a-z A-Z 0-9 _] 
    |  volatile: "volatile" !>> [a-z A-Z 0-9 _] 
    |  abstract: "abstract" !>> [a-z A-Z 0-9 _] 
    |  protected: "protected" !>> [a-z A-Z 0-9 _] 
    |  synchronized1: "synchronized" !>> [a-z A-Z 0-9 _] 
    |  native: "native" !>> [a-z A-Z 0-9 _] 
  ;

syntax SimpleName
  =  Identifier: Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] 
  ;

syntax Name
  = @NotSupported="avoid" \Identifier-p: {Identifier \ IdentifierKeywords "."}+
  ;

syntax ForStatement
  =  \for-semicolon-semicolon: "for" !>> [a-z A-Z 0-9 _] "(" ForInit? ";" Expression? ";" ForUpdate? ")" Statement 
  ;

syntax StatementExpression
  =  ClassInstanceCreationExpression: ClassInstanceCreationExpression 
    |  MethodInvocation: MethodInvocation 
  ;

syntax DoStatement
  =  \do-while-semicolon: "do" !>> [a-z A-Z 0-9 _] Statement "while" !>> [a-z A-Z 0-9 _] "(" Expression ")" ";" 
  ;

syntax StatementWithoutTrailingSubstatement
  =  BreakStatement: BreakStatement 
    |  EmptyStatement: EmptyStatement 
    |  TryStatement: TryStatement 
    |  ReturnStatement: ReturnStatement 
    |  ThrowStatement: ThrowStatement 
    |  DoStatement: DoStatement 
    |  SynchronizedStatement: SynchronizedStatement 
    |  Block: Block 
    |  SwitchStatement: SwitchStatement 
    |  ContinueStatement: ContinueStatement 
    |  ExpressionStatement: ExpressionStatement 
  ;

syntax StatementExpressionList
  =  comma1: {StatementExpression ","}+ 
  ;

syntax EmptyStatement
  =  semicolon1: ";" 
  ;

syntax BlockStatement
  =  LocalVariableDeclarationStatement: Modifier* LocalVariableDeclarationStatement 
    |  Statement: Statement 
  ;

syntax SwitchLabel
  =  \case-colon: "case" !>> [a-z A-Z 0-9 _] Expression ":" 
    |  \default-colon: "default" !>> [a-z A-Z 0-9 _] ":" 
  ;

syntax Statement
  =  WhileStatement: WhileStatement 
    |  ForStatement: ForStatement 
    |  IfThenElseStatement: IfThenElseStatement 
    |  ClassDeclaration: ClassDeclaration 
    |  IfThenStatement: IfThenStatement 
    |  StatementWithoutTrailingSubstatement: StatementWithoutTrailingSubstatement 
    |  LabeledStatement: LabeledStatement 
    |  AssertStatement: AssertStatement 
  ;

syntax ThrowStatement
  =  \throw-semicolon: "throw" !>> [a-z A-Z 0-9 _] Expression ";" 
  ;

syntax SwitchBlockStatementGroup
  =  \SwitchLabel-p-BlockStatement-p: SwitchLabel+ BlockStatement+ 
  ;

syntax ExpressionStatement
  =  semicolon2: StatementExpression ";" 
  ;

syntax TryStatement
  =  \try: "try" !>> [a-z A-Z 0-9 _] Block CatchClause+ 
    |  try1: "try" !>> [a-z A-Z 0-9 _] Block CatchClause* Finally 
  ;

syntax IfThenStatement
  =  \if: "if"  "(" Expression ")" Statement 
  ;

syntax ForUpdate
  =  StatementExpressionList1: StatementExpressionList 
  ;

syntax LocalVariableDeclaration
  =  comma: Type {VariableDeclarator ","}+ 
  ;

syntax BreakStatement
  =  \break-semicolon: "break" !>> [a-z A-Z 0-9 _] Identifier? ";" 
  ;

syntax WhileStatement
  =  \while: "while" !>> [a-z A-Z 0-9 _] "(" Expression ")" Statement 
  ;

syntax LocalVariableDeclarationStatement
  =  semicolon: LocalVariableDeclaration ";" 
  ;

syntax LabeledStatementNoShortIf
  =  colon1: Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] ":" StatementNoShortIf 
  ;

syntax IfThenElseStatement
  =  \if-else: "if" !>> [a-z A-Z 0-9 _] "(" Expression ")" StatementNoShortIf "else" !>> [a-z A-Z 0-9 _] Statement 
  ;

syntax SynchronizedStatement
  =  synchronized: "synchronized" !>> [a-z A-Z 0-9 _] "(" Expression ")" Block 
  ;

syntax SwitchBlock
  =  \SwitchBlockStatementGroup-s-SwitchLabel-s: "{" SwitchBlockStatementGroup* SwitchLabel* "}" 
  ;

syntax ForInit
  =  LocalVariableDeclaration: LocalVariableDeclaration 
    |  StatementExpressionList: StatementExpressionList 
  ;

syntax Finally
  =  \finally: "finally" !>> [a-z A-Z 0-9 _] Block 
  ;

syntax Block
  =  \BlockStatement-s: "{" BlockStatement* "}" 
  ;

syntax CatchClause
  =  \catch: "catch" !>> [a-z A-Z 0-9 _] "(" FormalParameter ")" Block 
  ;

syntax ContinueStatement
  =  \continue-semicolon: "continue" !>> [a-z A-Z 0-9 _] Identifier? ";" 
  ;

syntax AssertStatement
  = @NotSupported="prefer" assertWithExpression: "assert" Expression ";" 
  ;

syntax StatementNoShortIf
  =  IfThenElseStatementNoShortIf: IfThenElseStatementNoShortIf 
    |  StatementWithoutTrailingSubstatement1: StatementWithoutTrailingSubstatement 
    |  WhileStatementNoShortIf: WhileStatementNoShortIf 
    |  LabeledStatementNoShortIf: LabeledStatementNoShortIf 
    |  ForStatementNoShortIf: ForStatementNoShortIf 
  ;
  
syntax ForStatementNoShortIf
  = \for-semicolon-semicolon: "for" "(" ForInit? ";" Expression? ";" ForUpdate? ")" StatementNoShortIf
  ;
  
syntax IfThenElseStatementNoShortIf 
  = \if-else: "if"  "(" Expression ")" StatementNoShortIf "else" !>> [a-z A-Z 0-9 _] StatementNoShortIf
  ;

syntax ReturnStatement
  =  \return-semicolon: "return" !>> [a-z A-Z 0-9 _] Expression? ";" 
  ;

syntax LabeledStatement
  =  colon: Identifier \ IdentifierKeywords !>> [a-z A-Z 0-9 _ $] ":" Statement 
  ;

syntax WhileStatementNoShortIf
  =  while1: "while"  "(" Expression ")" StatementNoShortIf 
  ;

syntax SwitchStatement
  =  \switch: "switch"  "(" Expression ")" SwitchBlock 
  ;