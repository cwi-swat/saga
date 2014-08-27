grammar BReader;

@header {
	package nl.cwi.saga.breader.spec;

	import nl.cwi.saga.breader.spec.*;
}

@lexer::header {
	package nl.cwi.saga.breader.spec;
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

//////////////////////// s ::= OPEN READ* CLOSE? | /\ //////////////////////////
s : OPEN
    READ*
    (CLOSE {assert (((BReaderHistoryAspect.new_java_io_BufferedReader)$OPEN).caller()
	        == ((BReaderHistoryAspect.call_close)$CLOSE).caller());})?
  | ;

////////////////////////////////////////////////

OPEN:  'a';
READ:  'b';
CLOSE: 'c';
