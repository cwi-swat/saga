import java.util.HashSet;
import com.fredhopper.replication.server.SyncClientProxy;

import java.util.IdentityHashMap; // stores objToId
import org.antlr.runtime.*; // for use in SyncServerClientCoordinatorHistory
import java.util.ArrayList; // for use in SyncServerClientCoordinatorHistory
import java.util.Iterator; // for use in SyncServerClientCoordinatorHistory
import java.util.HashSet; // for use in SyncServerClientCoordinatorHistory
import java.util.HashMap; // for use in SyncServerClientCoordinatorHistory

aspect SyncServerClientCoordinatorHistoryAspect {
    private SyncServerClientCoordinatorHistory com.fredhopper.replication.server.SyncServerClientCoordinator.h = new SyncServerClientCoordinatorHistory();

///////////////////////////////////////////////////////
/////////////////////// Event classes /////////////////
///////////////////////////////////////////////////////

 public class call_finishNonAtomicReplicationUpdate extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final Object caller;
  public Object caller() {
    return this.caller;
  }
  
  private final com.fredhopper.replication.server.SyncServerClientCoordinator callee;
  public com.fredhopper.replication.server.SyncServerClientCoordinator callee() {
    return this.callee;
  }
  
  private final SyncClientProxy thread;
  public SyncClientProxy thread() {
    return this.thread;
  }
  

  public String toString() {
    return "o" + SyncServerClientCoordinatorHistory.objToId.get(caller) + ":o" + SyncServerClientCoordinatorHistory.objToId.get(callee) + ".finishNonAtomicReplicationUpdate(" + "o" + SyncServerClientCoordinatorHistory.objToId.get(thread) + ")";
  }

  public call_finishNonAtomicReplicationUpdate(Object caller, com.fredhopper.replication.server.SyncServerClientCoordinator callee, SyncClientProxy thread) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
    this.thread = thread;
    
  }
}


 public class call_startNonAtomicReplicationUpdate extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final Object caller;
  public Object caller() {
    return this.caller;
  }
  
  private final com.fredhopper.replication.server.SyncServerClientCoordinator callee;
  public com.fredhopper.replication.server.SyncServerClientCoordinator callee() {
    return this.callee;
  }
  
  private final SyncClientProxy thread;
  public SyncClientProxy thread() {
    return this.thread;
  }
  

  public String toString() {
    return "o" + SyncServerClientCoordinatorHistory.objToId.get(caller) + ":o" + SyncServerClientCoordinatorHistory.objToId.get(callee) + ".startNonAtomicReplicationUpdate(" + "o" + SyncServerClientCoordinatorHistory.objToId.get(thread) + ")";
  }

  public call_startNonAtomicReplicationUpdate(Object caller, com.fredhopper.replication.server.SyncServerClientCoordinator callee, SyncClientProxy thread) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
    this.thread = thread;
    
  }
}




///////////////////////////////////////////////////////
/////////////////////// History class /////////////////
///////////////////////////////////////////////////////
    
    public static class SyncServerClientCoordinatorHistory implements TokenSource {
      public  static IdentityHashMap<Object, Integer> objToId = new IdentityHashMap<Object, Integer>();
      public  static HashMap<Integer, Object> idToObj = new HashMap<Integer, Object>();
      private HashSet<Integer> actors = new HashSet<Integer>();
    
      private ArrayList<CommonToken> _L = new ArrayList<CommonToken>();
      private Integer _currentToken;
      
    
      public SyncServerClientCoordinatorHistory() {
        _L.add(new CommonToken(Token.EOF));
        _L.add(new CommonToken(Token.EOF));
    
        parse(); // the empty history
      }
    
      // Implemented for TokenSource interface
      public String getSourceName() {
        return null;
      }
    
      public void print() {
        
        System.err.println("=== ERROR! Local history of view SyncServerClientCoordinatorHistory (events: " + Integer.toString(_L.size()-2) + ") of com.fredhopper.replication.server.SyncServerClientCoordinator object violates grammar SyncServerClientCoordinator.g === \n");
        
    
        // Print actors of the sequence diagram
        Iterator<Integer> it = actors.iterator();
    	while(it.hasNext()) {
    		Integer objId = it.next();
            if(idToObj.get(objId) != null) {
    		  System.out.println("o" + objId + ":" + idToObj.get(objId).getClass().getName());
            } else {
    		  System.out.println("o" + objId + ":Object");
            }
    	}
        // Print messages between actors
    	System.out.println("");
        for(int i=0; i<_L.size()-2; i++) {
          System.out.println(_L.get(i).toString());
        }
      }
    
      public CommonToken nextToken() {
        return _L.get(_currentToken++);
      }
    
      // Parse the history in antlr and set attribute values
      private void parse() {
        _currentToken = 0;
        CommonTokenStream tokens = new CommonTokenStream(this);
        SyncServerClientCoordinatorParser parser = new SyncServerClientCoordinatorParser(tokens);
    
        try {
          
          parser.start();
          
        } catch(RecognitionException r) {
            print();
            assert false; // Assertion Failure
        } catch(AssertionError r) {
            print();
            assert false; // Assertion Failure
        }
      }
    
      
    
      
       public synchronized void update(call_finishNonAtomicReplicationUpdate e) {
         e.setType(SyncServerClientCoordinatorLexer.FINISH);
         _L.add(_L.size()-2, e);
    
    
         if(!objToId.containsKey(e.caller())) { // for printing
             objToId.put(e.caller(), objToId.size());
             idToObj.put(idToObj.size(),e.caller());
         }
         if(!objToId.containsKey(e.callee())) { // for printing
             objToId.put(e.callee(), objToId.size());
             idToObj.put(idToObj.size(),e.callee());
         }
         
         
         if(!objToId.containsKey(e.thread())) { // for printing
             objToId.put(e.thread(), objToId.size());
             idToObj.put(idToObj.size(),e.thread());
         }
         
         actors.add(objToId.get(e.caller()));
         actors.add(objToId.get(e.callee()));
    
         parse();
    }
      
      
       public synchronized void update(call_startNonAtomicReplicationUpdate e) {
         e.setType(SyncServerClientCoordinatorLexer.START);
         _L.add(_L.size()-2, e);
    
    
         if(!objToId.containsKey(e.caller())) { // for printing
             objToId.put(e.caller(), objToId.size());
             idToObj.put(idToObj.size(),e.caller());
         }
         if(!objToId.containsKey(e.callee())) { // for printing
             objToId.put(e.callee(), objToId.size());
             idToObj.put(idToObj.size(),e.callee());
         }
         
         
         if(!objToId.containsKey(e.thread())) { // for printing
             objToId.put(e.thread(), objToId.size());
             idToObj.put(idToObj.size(),e.thread());
         }
         
         actors.add(objToId.get(e.caller()));
         actors.add(objToId.get(e.callee()));
    
         parse();
    }
      
      
      
    }


///////////////////////////////////////////////////////
/////////////////////// Aspects ///////////////////////
///////////////////////////////////////////////////////

     /* call  void finishNonAtomicReplicationUpdate(SyncClientProxy thread) */
before(Object clr, com.fredhopper.replication.server.SyncServerClientCoordinator cle, SyncClientProxy thread):
  (call( void *.finishNonAtomicReplicationUpdate(..)) && this(clr) && target(cle) && args(thread)
   && if(SyncServerClientCoordinatorHistoryAspect.class.desiredAssertionStatus() )) {
    cle.h.update(new call_finishNonAtomicReplicationUpdate(clr, cle, thread));
}

before(com.fredhopper.replication.server.SyncServerClientCoordinator cle, SyncClientProxy thread): // from static method
  (call( void *.finishNonAtomicReplicationUpdate(..)) && !this(Object) && target(cle) && args(thread)
   && if(SyncServerClientCoordinatorHistoryAspect.class.desiredAssertionStatus())) {
    cle.h.update(new call_finishNonAtomicReplicationUpdate(null, cle, thread));
}
       
    

     /* call  void startNonAtomicReplicationUpdate(SyncClientProxy thread) */
before(Object clr, com.fredhopper.replication.server.SyncServerClientCoordinator cle, SyncClientProxy thread):
  (call( void *.startNonAtomicReplicationUpdate(..)) && this(clr) && target(cle) && args(thread)
   && if(SyncServerClientCoordinatorHistoryAspect.class.desiredAssertionStatus() )) {
    cle.h.update(new call_startNonAtomicReplicationUpdate(clr, cle, thread));
}

before(com.fredhopper.replication.server.SyncServerClientCoordinator cle, SyncClientProxy thread): // from static method
  (call( void *.startNonAtomicReplicationUpdate(..)) && !this(Object) && target(cle) && args(thread)
   && if(SyncServerClientCoordinatorHistoryAspect.class.desiredAssertionStatus())) {
    cle.h.update(new call_startNonAtomicReplicationUpdate(null, cle, thread));
}
       
    


}