grammar Bow;

@header {
	package nl.cwi.saga.deadlock.spec;

	import nl.cwi.saga.deadlock.*;
	import nl.cwi.saga.deadlock.spec.*;
	import nl.cwi.saga.deadlock.Deadlock.Friend;
	import java.io.*;
}

@lexer::header {
	package nl.cwi.saga.deadlock.spec;
}

@parser::members {
  @Override
  protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
    throw new MismatchedTokenException(ttype, input);
  }

  @Override
  public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException {
    throw e;
  }
}

@rulecatch {
catch(RecognitionException e) {
  throw e;
}
}

//////////////////////// start ::= s EOF//////////////////////////////////
start : s EOF;

//////////////////////// s ::= BOW BOWBACK? | /\ //////////////////////////
s : BOW
    (BOWBACK {assert (((BowHistoryAspect.call_bow)$BOW).bower()
	        == ((BowHistoryAspect.call_bowBack)$BOWBACK).callee());})?
  | ;

////////////////////////////////////////////////

BOW:  'a';
BOWBACK: 'b';
