grammar Deadlock;

@header {
	package nl.cwi.saga.deadlock.spec;

	import nl.cwi.saga.deadlock.*;
	import java.util.Map;
	import java.util.HashMap;
	import org.jgrapht.*;
	import org.jgrapht.graph.*;
	import org.jgrapht.alg.*;
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
start : s[new HashMap<Long, Object>(), new HashMap<Long, Map<Object, Integer> >()] EOF;

//////////////////////// s ::= REQ* //////////////////////////
s[Map<Long, Object> reqLock, Map<Long, Map<Object, Integer> > hasLock] :
    REQ
    {
	    long tId; Object callee;
	    if($REQ instanceof DeadlockHistoryAspect.call_bow) {
			DeadlockHistoryAspect.call_bow event = (DeadlockHistoryAspect.call_bow)$REQ;
			tId = event.threadId();
			callee = event.callee();
	    } else {
			DeadlockHistoryAspect.call_bowBack event = (DeadlockHistoryAspect.call_bowBack)$REQ;
			tId = event.threadId();
			callee = event.callee();
	    }
	    reqLock.put(tId, callee);
    }
    s[reqLock,hasLock]
    
  | ACQ
    {
	    long tId; Object callee;
	    if($ACQ instanceof DeadlockHistoryAspect.exec_bow) {
			DeadlockHistoryAspect.exec_bow event = (DeadlockHistoryAspect.exec_bow)$ACQ;
			tId = event.threadId();
			callee = event.callee();
	    } else {
			DeadlockHistoryAspect.exec_bowBack event = (DeadlockHistoryAspect.exec_bowBack)$ACQ;
			tId = event.threadId();
			callee = event.callee();
	    }
	    reqLock.remove(tId);
		Map<Object, Integer> m = hasLock.get(tId);
		int newCnt = 1;
		if(m == null) {
			m = new HashMap<Object, Integer>();
			hasLock.put(tId, m);
		} else if(m.get(callee) != null) {
			newCnt = m.get(callee)+1;
		}
		m.put(callee, newCnt);
    }

    s[reqLock,hasLock]
    
  | REL
    {
  		long tId; Object caller;
	    if($REL instanceof DeadlockHistoryAspect.return_bow) {
			DeadlockHistoryAspect.return_bow event = (DeadlockHistoryAspect.return_bow)$REL;
			tId = event.threadId();
			caller = event.caller();
	    } else {
			DeadlockHistoryAspect.return_bowBack event = (DeadlockHistoryAspect.return_bowBack)$REL;
			tId = event.threadId();
			caller = event.caller();
	    }
		Map<Object, Integer> m = hasLock.get(tId);
		Integer cnt = m.get(caller);
		if(cnt == 1) {
			m.remove(caller);
		}
		else {
			m.put(caller, cnt-1);
		}
  
  }
    s[reqLock,hasLock]
    
  |
  {
	DirectedGraph<Long, DefaultEdge> g =
            new DefaultDirectedGraph<Long, DefaultEdge>(DefaultEdge.class);
	for(Long rl : reqLock.keySet() ) {
		for(Long hl : hasLock.keySet() ) {
			if(hasLock.get(hl).containsKey(reqLock.get(rl))) {
				g.addVertex(rl);
				g.addVertex(hl);
				g.addEdge(rl, hl);
			}
		}
	}
	
	CycleDetector<Long, DefaultEdge> d = new CycleDetector<Long, DefaultEdge>(g);
	assert !d.detectCycles();

  }
  ;

////////////////////////////////////////////////

REQ: 'a';
ACQ: 'b';
REL: 'c'; 
