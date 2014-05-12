import com.fredhopper.*;

import java.util.IdentityHashMap; // stores objToId
import org.antlr.runtime.*; // for use in ReplicationSnapshotHistory
import java.util.ArrayList; // for use in ReplicationSnapshotHistory
import java.util.Iterator; // for use in ReplicationSnapshotHistory
import java.util.HashSet; // for use in ReplicationSnapshotHistory
import java.util.HashMap; // for use in ReplicationSnapshotHistory

aspect ReplicationSnapshotHistoryAspect {
    private ReplicationSnapshotHistory com.fredhopper.replication.server.ReplicationSnapshot.h = new ReplicationSnapshotHistory();

///////////////////////////////////////////////////////
/////////////////////// Event classes /////////////////
///////////////////////////////////////////////////////

 public class call_clearSnapshot extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final Object caller;
  public Object caller() {
    return this.caller;
  }
  
  private final com.fredhopper.replication.server.ReplicationSnapshot callee;
  public com.fredhopper.replication.server.ReplicationSnapshot callee() {
    return this.callee;
  }
  

  public String toString() {
    return "o" + ReplicationSnapshotHistory.objToId.get(caller) + ":o" + ReplicationSnapshotHistory.objToId.get(callee) + ".clearSnapshot(" + "" + ")";
  }

  public call_clearSnapshot(Object caller, com.fredhopper.replication.server.ReplicationSnapshot callee) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
  }
}


 public class call_refreshSnapshot extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final Object caller;
  public Object caller() {
    return this.caller;
  }
  
  private final com.fredhopper.replication.server.ReplicationSnapshot callee;
  public com.fredhopper.replication.server.ReplicationSnapshot callee() {
    return this.callee;
  }
  

  public String toString() {
    return "o" + ReplicationSnapshotHistory.objToId.get(caller) + ":o" + ReplicationSnapshotHistory.objToId.get(callee) + ".refreshSnapshot(" + "" + ")";
  }

  public call_refreshSnapshot(Object caller, com.fredhopper.replication.server.ReplicationSnapshot callee) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
  }
}




///////////////////////////////////////////////////////
/////////////////////// History class /////////////////
///////////////////////////////////////////////////////
    
    public static class ReplicationSnapshotHistory implements TokenSource {
      public  static IdentityHashMap<Object, Integer> objToId = new IdentityHashMap<Object, Integer>();
      public  static HashMap<Integer, Object> idToObj = new HashMap<Integer, Object>();
      private HashSet<Integer> actors = new HashSet<Integer>();
    
      private ArrayList<CommonToken> _L = new ArrayList<CommonToken>();
      private Integer _currentToken;
      
    
      public ReplicationSnapshotHistory() {
        _L.add(new CommonToken(Token.EOF));
        _L.add(new CommonToken(Token.EOF));
    
        parse(); // the empty history
      }
    
      // Implemented for TokenSource interface
      public String getSourceName() {
        return null;
      }
    
      public void print() {
        
        System.err.println("=== ERROR! Local history of view ReplicationSnapshotHistory (events: " + Integer.toString(_L.size()-2) + ") of com.fredhopper.replication.server.ReplicationSnapshot object violates grammar ReplicationSnapshot.g === \n");
        
    
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
        ReplicationSnapshotParser parser = new ReplicationSnapshotParser(tokens);
    
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
    
      
    
      
       public synchronized void update(call_clearSnapshot e) {
         e.setType(ReplicationSnapshotLexer.CLEAR);
         _L.add(_L.size()-2, e);
    
    
         if(!objToId.containsKey(e.caller())) { // for printing
             objToId.put(e.caller(), objToId.size());
             idToObj.put(idToObj.size(),e.caller());
         }
         if(!objToId.containsKey(e.callee())) { // for printing
             objToId.put(e.callee(), objToId.size());
             idToObj.put(idToObj.size(),e.callee());
         }
         
         
         actors.add(objToId.get(e.caller()));
         actors.add(objToId.get(e.callee()));
    
         parse();
    }
      
      
       public synchronized void update(call_refreshSnapshot e) {
         e.setType(ReplicationSnapshotLexer.REFRESH);
         _L.add(_L.size()-2, e);
    
    
         if(!objToId.containsKey(e.caller())) { // for printing
             objToId.put(e.caller(), objToId.size());
             idToObj.put(idToObj.size(),e.caller());
         }
         if(!objToId.containsKey(e.callee())) { // for printing
             objToId.put(e.callee(), objToId.size());
             idToObj.put(idToObj.size(),e.callee());
         }
         
         
         actors.add(objToId.get(e.caller()));
         actors.add(objToId.get(e.callee()));
    
         parse();
    }
      
      
      
    }


///////////////////////////////////////////////////////
/////////////////////// Aspects ///////////////////////
///////////////////////////////////////////////////////

     /* call  void clearSnapshot() */
before(Object clr, com.fredhopper.replication.server.ReplicationSnapshot cle):
  (call( void *.clearSnapshot(..)) && this(clr) && target(cle) && args()
   && if(ReplicationSnapshotHistoryAspect.class.desiredAssertionStatus() )) {
    cle.h.update(new call_clearSnapshot(clr, cle));
}

before(com.fredhopper.replication.server.ReplicationSnapshot cle): // from static method
  (call( void *.clearSnapshot(..)) && !this(Object) && target(cle) && args()
   && if(ReplicationSnapshotHistoryAspect.class.desiredAssertionStatus())) {
    cle.h.update(new call_clearSnapshot(null, cle));
}
       
    

     /* call  void refreshSnapshot() */
before(Object clr, com.fredhopper.replication.server.ReplicationSnapshot cle):
  (call( void *.refreshSnapshot(..)) && this(clr) && target(cle) && args()
   && if(ReplicationSnapshotHistoryAspect.class.desiredAssertionStatus() )) {
    cle.h.update(new call_refreshSnapshot(clr, cle));
}

before(com.fredhopper.replication.server.ReplicationSnapshot cle): // from static method
  (call( void *.refreshSnapshot(..)) && !this(Object) && target(cle) && args()
   && if(ReplicationSnapshotHistoryAspect.class.desiredAssertionStatus())) {
    cle.h.update(new call_refreshSnapshot(null, cle));
}
       
    


}