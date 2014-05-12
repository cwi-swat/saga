import java.util.List;
import java.util.Collection;
import java.util.HashSet;
import com.fredhopper.util.stream.StreamUtil;
import com.fredhopper.replication.server.item.ServerReplicationItem;
import com.fredhopper.replication.server.ReplicationSnapshot;
import com.fredhopper.application.SyncServer;
import com.fredhopper.log.FHLogger;
import com.fredhopper.log.FHLoggerFactory;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.PrintStream;

import java.util.IdentityHashMap; // stores objToId
import org.antlr.runtime.*; // for use in ConnectionThreadRegisterItemsHistory
import java.util.ArrayList; // for use in ConnectionThreadRegisterItemsHistory
import java.util.Iterator; // for use in ConnectionThreadRegisterItemsHistory
import java.util.HashSet; // for use in ConnectionThreadRegisterItemsHistory
import java.util.HashMap; // for use in ConnectionThreadRegisterItemsHistory

aspect ConnectionThreadRegisterItemsHistoryAspect {
    private ConnectionThreadRegisterItemsHistory com.fredhopper.replication.server.ConnectionThread.h = new ConnectionThreadRegisterItemsHistory();

///////////////////////////////////////////////////////
/////////////////////// Event classes /////////////////
///////////////////////////////////////////////////////

 public class call_registerItems extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final Object caller;
  public Object caller() {
    return this.caller;
  }
  
  private final com.fredhopper.replication.server.ConnectionThread callee;
  public com.fredhopper.replication.server.ConnectionThread callee() {
    return this.callee;
  }
  
  private final String aScheduleName;
  public String aScheduleName() {
    return this.aScheduleName;
  }
  
  private final DataInputStream clientInput;
  public DataInputStream clientInput() {
    return this.clientInput;
  }
  
  private final DataOutputStream clientOutput;
  public DataOutputStream clientOutput() {
    return this.clientOutput;
  }
  

  public String toString() {
    return "o" + ConnectionThreadRegisterItemsHistory.objToId.get(caller) + ":o" + ConnectionThreadRegisterItemsHistory.objToId.get(callee) + ".registerItems(" + "o" + ConnectionThreadRegisterItemsHistory.objToId.get(aScheduleName) + ", " +"o" + ConnectionThreadRegisterItemsHistory.objToId.get(clientInput) + ", " +"o" + ConnectionThreadRegisterItemsHistory.objToId.get(clientOutput) + ")";
  }

  public call_registerItems(Object caller, com.fredhopper.replication.server.ConnectionThread callee, String aScheduleName,
			DataInputStream clientInput,
			DataOutputStream clientOutput) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
    this.aScheduleName = aScheduleName;
    
    this.clientInput = clientInput;
    
    this.clientOutput = clientOutput;
    
  }
}


 public class return_registerItems extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final Object caller;
  public Object caller() {
    return this.caller;
  }
  
  private final com.fredhopper.replication.server.ConnectionThread callee;
  public com.fredhopper.replication.server.ConnectionThread callee() {
    return this.callee;
  }
  
  private final String aScheduleName;
  public String aScheduleName() {
    return this.aScheduleName;
  }
  
  private final DataInputStream clientInput;
  public DataInputStream clientInput() {
    return this.clientInput;
  }
  
  private final DataOutputStream clientOutput;
  public DataOutputStream clientOutput() {
    return this.clientOutput;
  }
  
  private final List result;
  public List result() {
    return this.result;
  }
  

  public String toString() {
    return "o" + ConnectionThreadRegisterItemsHistory.objToId.get(caller) + ":o" + ConnectionThreadRegisterItemsHistory.objToId.get(callee) + ".registerItems(" + "o" + ConnectionThreadRegisterItemsHistory.objToId.get(aScheduleName) + ", " +"o" + ConnectionThreadRegisterItemsHistory.objToId.get(clientInput) + ", " +"o" + ConnectionThreadRegisterItemsHistory.objToId.get(clientOutput) + ", " +"o" + ConnectionThreadRegisterItemsHistory.objToId.get(result) + ")";
  }

  public return_registerItems(Object caller, com.fredhopper.replication.server.ConnectionThread callee, String aScheduleName,
			DataInputStream clientInput,
			DataOutputStream clientOutput, List result) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
    this.aScheduleName = aScheduleName;
    
    this.clientInput = clientInput;
    
    this.clientOutput = clientOutput;
    
    this.result = result;
    
  }
}



 public class call_writeStringUTFUtility extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final com.fredhopper.replication.server.ConnectionThread caller;
  public com.fredhopper.replication.server.ConnectionThread caller() {
    return this.caller;
  }
  
  private final StreamUtil callee;
  public StreamUtil callee() {
    return this.callee;
  }
  
  private final DataOutputStream stream;
  public DataOutputStream stream() {
    return this.stream;
  }
  
  private final String s;
  public String s() {
    return this.s;
  }
  

  public String toString() {
    return "o" + ConnectionThreadRegisterItemsHistory.objToId.get(caller) + ":o" + ConnectionThreadRegisterItemsHistory.objToId.get(callee) + ".writeStringUTFUtility(" + "o" + ConnectionThreadRegisterItemsHistory.objToId.get(stream) + ", " +"o" + ConnectionThreadRegisterItemsHistory.objToId.get(s) + ")";
  }

  public call_writeStringUTFUtility(com.fredhopper.replication.server.ConnectionThread caller, StreamUtil callee, DataOutputStream stream, String s) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
    this.stream = stream;
    
    this.s = s;
    
  }
}


 public class call_getItems extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final com.fredhopper.replication.server.ConnectionThread caller;
  public com.fredhopper.replication.server.ConnectionThread caller() {
    return this.caller;
  }
  
  private final ReplicationSnapshot callee;
  public ReplicationSnapshot callee() {
    return this.callee;
  }
  
  private final String schedule;
  public String schedule() {
    return this.schedule;
  }
  

  public String toString() {
    return "o" + ConnectionThreadRegisterItemsHistory.objToId.get(caller) + ":o" + ConnectionThreadRegisterItemsHistory.objToId.get(callee) + ".getItems(" + "o" + ConnectionThreadRegisterItemsHistory.objToId.get(schedule) + ")";
  }

  public call_getItems(com.fredhopper.replication.server.ConnectionThread caller, ReplicationSnapshot callee, String schedule) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
    this.schedule = schedule;
    
  }
}


 public class return_getItems extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final com.fredhopper.replication.server.ConnectionThread caller;
  public com.fredhopper.replication.server.ConnectionThread caller() {
    return this.caller;
  }
  
  private final ReplicationSnapshot callee;
  public ReplicationSnapshot callee() {
    return this.callee;
  }
  
  private final String schedule;
  public String schedule() {
    return this.schedule;
  }
  
  private final List result;
  public List result() {
    return this.result;
  }
  

  public String toString() {
    return "o" + ConnectionThreadRegisterItemsHistory.objToId.get(caller) + ":o" + ConnectionThreadRegisterItemsHistory.objToId.get(callee) + ".getItems(" + "o" + ConnectionThreadRegisterItemsHistory.objToId.get(schedule) + ", " +"o" + ConnectionThreadRegisterItemsHistory.objToId.get(result) + ")";
  }

  public return_getItems(com.fredhopper.replication.server.ConnectionThread caller, ReplicationSnapshot callee, String schedule, List result) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
    this.schedule = schedule;
    
    this.result = result;
    
  }
}


 public class return_getReplicationSnapshot extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final com.fredhopper.replication.server.ConnectionThread caller;
  public com.fredhopper.replication.server.ConnectionThread caller() {
    return this.caller;
  }
  
  private final SyncServer callee;
  public SyncServer callee() {
    return this.callee;
  }
  
  private final ReplicationSnapshot result;
  public ReplicationSnapshot result() {
    return this.result;
  }
  

  public String toString() {
    return "o" + ConnectionThreadRegisterItemsHistory.objToId.get(caller) + ":o" + ConnectionThreadRegisterItemsHistory.objToId.get(callee) + ".getReplicationSnapshot(" + "o" + ConnectionThreadRegisterItemsHistory.objToId.get(result) + ")";
  }

  public return_getReplicationSnapshot(com.fredhopper.replication.server.ConnectionThread caller, SyncServer callee, ReplicationSnapshot result) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
    this.result = result;
    
  }
}



///////////////////////////////////////////////////////
/////////////////////// History class /////////////////
///////////////////////////////////////////////////////
    
    public static class ConnectionThreadRegisterItemsHistory implements TokenSource {
      public  static IdentityHashMap<Object, Integer> objToId = new IdentityHashMap<Object, Integer>();
      public  static HashMap<Integer, Object> idToObj = new HashMap<Integer, Object>();
      private HashSet<Integer> actors = new HashSet<Integer>();
    
      private ArrayList<CommonToken> _L = new ArrayList<CommonToken>();
      private Integer _currentToken;
      
    
      public ConnectionThreadRegisterItemsHistory() {
        _L.add(new CommonToken(Token.EOF));
        _L.add(new CommonToken(Token.EOF));
    
        parse(); // the empty history
      }
    
      // Implemented for TokenSource interface
      public String getSourceName() {
        return null;
      }
    
      public void print() {
        
        System.err.println("=== ERROR! Local history of view ConnectionThreadRegisterItemsHistory (events: " + Integer.toString(_L.size()-2) + ") of com.fredhopper.replication.server.ConnectionThread object violates grammar ConnectionThreadRegisterItems.g === \n");
        
    
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
        ConnectionThreadRegisterItemsParser parser = new ConnectionThreadRegisterItemsParser(tokens);
    
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
    
      
    
      
       public synchronized void update(call_registerItems e) {
         e.setType(ConnectionThreadRegisterItemsLexer.REGISTER);
         _L.add(_L.size()-2, e);
    
    
         if(!objToId.containsKey(e.caller())) { // for printing
             objToId.put(e.caller(), objToId.size());
             idToObj.put(idToObj.size(),e.caller());
         }
         if(!objToId.containsKey(e.callee())) { // for printing
             objToId.put(e.callee(), objToId.size());
             idToObj.put(idToObj.size(),e.callee());
         }
         
         
         if(!objToId.containsKey(e.aScheduleName())) { // for printing
             objToId.put(e.aScheduleName(), objToId.size());
             idToObj.put(idToObj.size(),e.aScheduleName());
         }
         
         if(!objToId.containsKey(e.clientInput())) { // for printing
             objToId.put(e.clientInput(), objToId.size());
             idToObj.put(idToObj.size(),e.clientInput());
         }
         
         if(!objToId.containsKey(e.clientOutput())) { // for printing
             objToId.put(e.clientOutput(), objToId.size());
             idToObj.put(idToObj.size(),e.clientOutput());
         }
         
         actors.add(objToId.get(e.caller()));
         actors.add(objToId.get(e.callee()));
    
         parse();
    }
      
      
       public synchronized void update(return_registerItems e) {
         e.setType(ConnectionThreadRegisterItemsLexer.ITEMS);
         _L.add(_L.size()-2, e);
    
    
         if(!objToId.containsKey(e.caller())) { // for printing
             objToId.put(e.caller(), objToId.size());
             idToObj.put(idToObj.size(),e.caller());
         }
         if(!objToId.containsKey(e.callee())) { // for printing
             objToId.put(e.callee(), objToId.size());
             idToObj.put(idToObj.size(),e.callee());
         }
         
         if(!objToId.containsKey(e.result())) { // for printing
             objToId.put(e.result(), objToId.size());
             idToObj.put(idToObj.size(),e.result());
         }           
         
         
         if(!objToId.containsKey(e.aScheduleName())) { // for printing
             objToId.put(e.aScheduleName(), objToId.size());
             idToObj.put(idToObj.size(),e.aScheduleName());
         }
         
         if(!objToId.containsKey(e.clientInput())) { // for printing
             objToId.put(e.clientInput(), objToId.size());
             idToObj.put(idToObj.size(),e.clientInput());
         }
         
         if(!objToId.containsKey(e.clientOutput())) { // for printing
             objToId.put(e.clientOutput(), objToId.size());
             idToObj.put(idToObj.size(),e.clientOutput());
         }
         
         actors.add(objToId.get(e.caller()));
         actors.add(objToId.get(e.callee()));
    
         parse();
    }
      
      
      
       public synchronized void update(call_writeStringUTFUtility e) {
         e.setType(ConnectionThreadRegisterItemsLexer.WRITE);
         _L.add(_L.size()-2, e);
    
    
         if(!objToId.containsKey(e.caller())) { // for printing
             objToId.put(e.caller(), objToId.size());
             idToObj.put(idToObj.size(),e.caller());
         }
         if(!objToId.containsKey(e.callee())) { // for printing
             objToId.put(e.callee(), objToId.size());
             idToObj.put(idToObj.size(),e.callee());
         }
         
         
         if(!objToId.containsKey(e.stream())) { // for printing
             objToId.put(e.stream(), objToId.size());
             idToObj.put(idToObj.size(),e.stream());
         }
         
         if(!objToId.containsKey(e.s())) { // for printing
             objToId.put(e.s(), objToId.size());
             idToObj.put(idToObj.size(),e.s());
         }
         
         actors.add(objToId.get(e.caller()));
         actors.add(objToId.get(e.callee()));
    
         parse();
    }
      
      
       public synchronized void update(call_getItems e) {
         e.setType(ConnectionThreadRegisterItemsLexer.LIST);
         _L.add(_L.size()-2, e);
    
    
         if(!objToId.containsKey(e.caller())) { // for printing
             objToId.put(e.caller(), objToId.size());
             idToObj.put(idToObj.size(),e.caller());
         }
         if(!objToId.containsKey(e.callee())) { // for printing
             objToId.put(e.callee(), objToId.size());
             idToObj.put(idToObj.size(),e.callee());
         }
         
         
         if(!objToId.containsKey(e.schedule())) { // for printing
             objToId.put(e.schedule(), objToId.size());
             idToObj.put(idToObj.size(),e.schedule());
         }
         
         actors.add(objToId.get(e.caller()));
         actors.add(objToId.get(e.callee()));
    
         parse();
    }
      
      
       public synchronized void update(return_getItems e) {
         e.setType(ConnectionThreadRegisterItemsLexer.LISTITEMS);
         _L.add(_L.size()-2, e);
    
    
         if(!objToId.containsKey(e.caller())) { // for printing
             objToId.put(e.caller(), objToId.size());
             idToObj.put(idToObj.size(),e.caller());
         }
         if(!objToId.containsKey(e.callee())) { // for printing
             objToId.put(e.callee(), objToId.size());
             idToObj.put(idToObj.size(),e.callee());
         }
         
         if(!objToId.containsKey(e.result())) { // for printing
             objToId.put(e.result(), objToId.size());
             idToObj.put(idToObj.size(),e.result());
         }           
         
         
         if(!objToId.containsKey(e.schedule())) { // for printing
             objToId.put(e.schedule(), objToId.size());
             idToObj.put(idToObj.size(),e.schedule());
         }
         
         actors.add(objToId.get(e.caller()));
         actors.add(objToId.get(e.callee()));
    
         parse();
    }
      
      
       public synchronized void update(return_getReplicationSnapshot e) {
         e.setType(ConnectionThreadRegisterItemsLexer.SNAPSHOT);
         _L.add(_L.size()-2, e);
    
    
         if(!objToId.containsKey(e.caller())) { // for printing
             objToId.put(e.caller(), objToId.size());
             idToObj.put(idToObj.size(),e.caller());
         }
         if(!objToId.containsKey(e.callee())) { // for printing
             objToId.put(e.callee(), objToId.size());
             idToObj.put(idToObj.size(),e.callee());
         }
         
         if(!objToId.containsKey(e.result())) { // for printing
             objToId.put(e.result(), objToId.size());
             idToObj.put(idToObj.size(),e.result());
         }           
         
         
         actors.add(objToId.get(e.caller()));
         actors.add(objToId.get(e.callee()));
    
         parse();
    }
      
      
    }


///////////////////////////////////////////////////////
/////////////////////// Aspects ///////////////////////
///////////////////////////////////////////////////////

     /* call  List registerItems(String aScheduleName,
			DataInputStream clientInput,
			DataOutputStream clientOutput) */
before(Object clr, com.fredhopper.replication.server.ConnectionThread cle, String aScheduleName,
			DataInputStream clientInput,
			DataOutputStream clientOutput):
  (call( List *.registerItems(..)) && this(clr) && target(cle) && args(aScheduleName, clientInput, clientOutput)
   && if(ConnectionThreadRegisterItemsHistoryAspect.class.desiredAssertionStatus() )) {
    cle.h.update(new call_registerItems(clr, cle, aScheduleName, clientInput, clientOutput));
}

before(com.fredhopper.replication.server.ConnectionThread cle, String aScheduleName,
			DataInputStream clientInput,
			DataOutputStream clientOutput): // from static method
  (call( List *.registerItems(..)) && !this(Object) && target(cle) && args(aScheduleName, clientInput, clientOutput)
   && if(ConnectionThreadRegisterItemsHistoryAspect.class.desiredAssertionStatus())) {
    cle.h.update(new call_registerItems(null, cle, aScheduleName, clientInput, clientOutput));
}
       
    

     /* return  List registerItems(String aScheduleName,
			DataInputStream clientInput,
			DataOutputStream clientOutput) */
after(Object clr, com.fredhopper.replication.server.ConnectionThread cle, String aScheduleName,
			DataInputStream clientInput,
			DataOutputStream clientOutput) returning(List ret):
  (call( List *.registerItems(..)) && this(clr) && target(cle) && args(aScheduleName, clientInput, clientOutput)
   && if(ConnectionThreadRegisterItemsHistoryAspect.class.desiredAssertionStatus() )) {
    cle.h.update(new return_registerItems(clr, cle, aScheduleName, clientInput, clientOutput, ret));
}

after(com.fredhopper.replication.server.ConnectionThread cle, String aScheduleName,
			DataInputStream clientInput,
			DataOutputStream clientOutput) returning(List ret): // from static method
  (call( List *.registerItems(..)) && !this(Object) && target(cle) && args(aScheduleName, clientInput, clientOutput)
   && if(ConnectionThreadRegisterItemsHistoryAspect.class.desiredAssertionStatus())) {
    cle.h.update(new return_registerItems(null, cle, aScheduleName, clientInput, clientOutput, ret));
}
       
    


     
before(com.fredhopper.replication.server.ConnectionThread clr, DataOutputStream stream, String s): // static method
  (call(static void StreamUtil.writeStringUTFUtility(..)) && this(clr) && !target(Object) && args(stream, s)
   && if(ConnectionThreadRegisterItemsHistoryAspect.class.desiredAssertionStatus())) {
    clr.h.update(new call_writeStringUTFUtility(clr, null, stream, s));
}
       
    

     /* call  List ReplicationSnapshot getItems(String schedule) */
before(com.fredhopper.replication.server.ConnectionThread clr, ReplicationSnapshot cle, String schedule):
  (call( List *.getItems(..)) && this(clr) && target(cle) && args(schedule)
   && if(ConnectionThreadRegisterItemsHistoryAspect.class.desiredAssertionStatus() )) {
    clr.h.update(new call_getItems(clr, cle, schedule));
}
    

     /* return  List ReplicationSnapshot getItems(String schedule) */
after(com.fredhopper.replication.server.ConnectionThread clr, ReplicationSnapshot cle, String schedule) returning(List ret):
  (call( List *.getItems(..)) && this(clr) && target(cle) && args(schedule)
   && if(ConnectionThreadRegisterItemsHistoryAspect.class.desiredAssertionStatus() )) {
    clr.h.update(new return_getItems(clr, cle, schedule, ret));
}
    

     /* return  ReplicationSnapshot SyncServer getReplicationSnapshot() */
after(com.fredhopper.replication.server.ConnectionThread clr, SyncServer cle) returning(ReplicationSnapshot ret):
  (call( ReplicationSnapshot *.getReplicationSnapshot(..)) && this(clr) && target(cle) && args()
   && if(ConnectionThreadRegisterItemsHistoryAspect.class.desiredAssertionStatus() )) {
    clr.h.update(new return_getReplicationSnapshot(clr, cle, ret));
}
    

}