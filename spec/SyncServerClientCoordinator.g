grammar SyncServerClientCoordinator;

@header {
import java.util.HashSet;
import com.fredhopper.replication.server.SyncClientProxy;
}

@rulecatch {
catch(RecognitionException e) {
  throw e;
}
}

//////////////////////// start ::= s EOF//////////////////////////////////
start
 : s[new HashSet()] EOF;

//////////////////////// s ::= /\ | START s | FINISH s //////////////////////////
s [HashSet Proxies]
 : START 
   { 	
     assert ! $Proxies.contains(((SyncServerClientCoordinatorHistoryAspect.call_startNonAtomicReplicationUpdate) $START).thread());
   	 $Proxies.add(((SyncServerClientCoordinatorHistoryAspect.call_startNonAtomicReplicationUpdate) $START).thread());
   } 
   s1=s[$Proxies]
 | FINISH
   { 	
     assert $Proxies.contains(((SyncServerClientCoordinatorHistoryAspect.call_finishNonAtomicReplicationUpdate) $FINISH).thread()); 
  	 $Proxies.remove(((SyncServerClientCoordinatorHistoryAspect.call_finishNonAtomicReplicationUpdate) $FINISH).thread()); 
   }
   s1=s[$Proxies]
 | ;

////////////////////////////////////////////////

START: 'a';
FINISH: 'b';
