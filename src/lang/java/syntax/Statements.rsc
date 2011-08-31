module lang::java::syntax::Statements 

// extend lang::java::syntax::ClassDecl;
extend lang::java::syntax::MethodDecl;
extend lang::java::syntax::Expressions;


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
