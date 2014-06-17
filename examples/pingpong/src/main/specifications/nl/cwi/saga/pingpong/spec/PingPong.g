grammar PingPong;

@header {
	package nl.cwi.saga.pingpong.spec;

	import nl.cwi.saga.pingpong.*;
}

@lexer::header {
	package nl.cwi.saga.pingpong.spec;
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

//////////////////////// s ::= (PING PONG)* PING? | (PONG PING)* PONG? //////////////////////////
s : (PING PONG)* PING?
  | (PONG PING)* PONG? ;

////////////////////////////////////////////////

PING:  'a';
PONG:  'b';
