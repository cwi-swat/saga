grammar Stack;

////
@rulecatch {
catch(RecognitionException e) {
  throw e;
}
}

start
                 		returns [EList<Object> stack]
  ////               		
@init {
    $stack = new EList<Object>();
}
     : s[0, $stack] EOF {$s.ok}?
       { $stack = $s.completeStack; } ;

s        [int size, EList<Object> stack]
 returns [EList<Object> completeStack, boolean ok]
 : PUSH
   s1=s[$size+1, $stack.appendElement(((return_push)$PUSH).item())]
   { $completeStack = $s1.completeStack; $ok = ($s1.ok && $size>=0); }
 
 | POP
   s1=s[$size-1, $stack.tail()]
   { $completeStack = $s1.completeStack; $ok = ($s1.ok && $size>=0); }

 | { $completeStack = $stack; $ok = $size>=0; };

PUSH: 'bla';
POP:  'ts';
