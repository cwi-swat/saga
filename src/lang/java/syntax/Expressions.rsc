module lang::java::syntax::Expressions 

// extend lang::java::syntax::ClassDecl;
extend lang::java::syntax::JavaTypes;
extend lang::java::syntax::FieldDecl;


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
