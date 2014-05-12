import java.util.List;
import java.util.ArrayList;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import com.fredhopper.replication.server.SyncServerSchedule;
import com.fredhopper.replication.server.item.ServerReplicationItem;

import java.util.IdentityHashMap; // stores objToId
import org.antlr.runtime.*; // for use in ConnectionThreadHistory
import java.util.ArrayList; // for use in ConnectionThreadHistory
import java.util.Iterator; // for use in ConnectionThreadHistory
import java.util.HashSet; // for use in ConnectionThreadHistory
import java.util.HashMap; // for use in ConnectionThreadHistory

aspect ConnectionThreadHistoryAspect {
    private ConnectionThreadHistory com.fredhopper.replication.server.ConnectionThread.h = new ConnectionThreadHistory();

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
    return "o" + ConnectionThreadHistory.objToId.get(caller) + ":o" + ConnectionThreadHistory.objToId.get(callee) + ".registerItems(" + "o" + ConnectionThreadHistory.objToId.get(aScheduleName) + ", " +"o" + ConnectionThreadHistory.objToId.get(clientInput) + ", " +"o" + ConnectionThreadHistory.objToId.get(clientOutput) + ")";
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


 public class call_establishSchedule extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final Object caller;
  public Object caller() {
    return this.caller;
  }
  
  private final com.fredhopper.replication.server.ConnectionThread callee;
  public com.fredhopper.replication.server.ConnectionThread callee() {
    return this.callee;
  }
  
  private final String clientScheduleName;
  public String clientScheduleName() {
    return this.clientScheduleName;
  }
  
  private final SyncServerSchedule serverSchedule;
  public SyncServerSchedule serverSchedule() {
    return this.serverSchedule;
  }
  
  private final DataOutputStream clientOutput;
  public DataOutputStream clientOutput() {
    return this.clientOutput;
  }
  

  public String toString() {
    return "o" + ConnectionThreadHistory.objToId.get(caller) + ":o" + ConnectionThreadHistory.objToId.get(callee) + ".establishSchedule(" + "o" + ConnectionThreadHistory.objToId.get(clientScheduleName) + ", " +"o" + ConnectionThreadHistory.objToId.get(serverSchedule) + ", " +"o" + ConnectionThreadHistory.objToId.get(clientOutput) + ")";
  }

  public call_establishSchedule(Object caller, com.fredhopper.replication.server.ConnectionThread callee, String clientScheduleName,
			SyncServerSchedule serverSchedule,
			DataOutputStream clientOutput) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
    this.clientScheduleName = clientScheduleName;
    
    this.serverSchedule = serverSchedule;
    
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
    return "o" + ConnectionThreadHistory.objToId.get(caller) + ":o" + ConnectionThreadHistory.objToId.get(callee) + ".registerItems(" + "o" + ConnectionThreadHistory.objToId.get(aScheduleName) + ", " +"o" + ConnectionThreadHistory.objToId.get(clientInput) + ", " +"o" + ConnectionThreadHistory.objToId.get(clientOutput) + ", " +"o" + ConnectionThreadHistory.objToId.get(result) + ")";
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


 public class call_transferItem extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final Object caller;
  public Object caller() {
    return this.caller;
  }
  
  private final com.fredhopper.replication.server.ConnectionThread callee;
  public com.fredhopper.replication.server.ConnectionThread callee() {
    return this.callee;
  }
  
  private final ServerReplicationItem item;
  public ServerReplicationItem item() {
    return this.item;
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
    return "o" + ConnectionThreadHistory.objToId.get(caller) + ":o" + ConnectionThreadHistory.objToId.get(callee) + ".transferItem(" + "o" + ConnectionThreadHistory.objToId.get(item) + ", " +"o" + ConnectionThreadHistory.objToId.get(clientInput) + ", " +"o" + ConnectionThreadHistory.objToId.get(clientOutput) + ")";
  }

  public call_transferItem(Object caller, com.fredhopper.replication.server.ConnectionThread callee, ServerReplicationItem item,
			DataInputStream clientInput,
			DataOutputStream clientOutput) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
    this.item = item;
    
    this.clientInput = clientInput;
    
    this.clientOutput = clientOutput;
    
  }
}




///////////////////////////////////////////////////////
/////////////////////// History class /////////////////
///////////////////////////////////////////////////////
    
    public static class ConnectionThreadHistory implements TokenSource {
      public  static IdentityHashMap<Object, Integer> objToId = new IdentityHashMap<Object, Integer>();
      public  static HashMap<Integer, Object> idToObj = new HashMap<Integer, Object>();
      private HashSet<Integer> actors = new HashSet<Integer>();
    
      private ArrayList<CommonToken> _L = new ArrayList<CommonToken>();
      private Integer _currentToken;
      
    
      public ConnectionThreadHistory() {
        _L.add(new CommonToken(Token.EOF));
        _L.add(new CommonToken(Token.EOF));
    
        parse(); // the empty history
      }
    
      // Implemented for TokenSource interface
      public String getSourceName() {
        return null;
      }
    
      public void print() {
        
        System.err.println("=== ERROR! Local history of view ConnectionThreadHistory (events: " + Integer.toString(_L.size()-2) + ") of com.fredhopper.replication.server.ConnectionThread object violates grammar ConnectionThread.g === \n");
        
    
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
        ConnectionThreadParser parser = new ConnectionThreadParser(tokens);
    
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
         e.setType(ConnectionThreadLexer.REGISTER);
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
      
      
       public synchronized void update(call_establishSchedule e) {
         e.setType(ConnectionThreadLexer.ESTABLISH);
         _L.add(_L.size()-2, e);
    
    
         if(!objToId.containsKey(e.caller())) { // for printing
             objToId.put(e.caller(), objToId.size());
             idToObj.put(idToObj.size(),e.caller());
         }
         if(!objToId.containsKey(e.callee())) { // for printing
             objToId.put(e.callee(), objToId.size());
             idToObj.put(idToObj.size(),e.callee());
         }
         
         
         if(!objToId.containsKey(e.clientScheduleName())) { // for printing
             objToId.put(e.clientScheduleName(), objToId.size());
             idToObj.put(idToObj.size(),e.clientScheduleName());
         }
         
         if(!objToId.containsKey(e.serverSchedule())) { // for printing
             objToId.put(e.serverSchedule(), objToId.size());
             idToObj.put(idToObj.size(),e.serverSchedule());
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
         e.setType(ConnectionThreadLexer.ITEMS);
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
      
      
       public synchronized void update(call_transferItem e) {
         e.setType(ConnectionThreadLexer.TRANSFER);
         _L.add(_L.size()-2, e);
    
    
         if(!objToId.containsKey(e.caller())) { // for printing
             objToId.put(e.caller(), objToId.size());
             idToObj.put(idToObj.size(),e.caller());
         }
         if(!objToId.containsKey(e.callee())) { // for printing
             objToId.put(e.callee(), objToId.size());
             idToObj.put(idToObj.size(),e.callee());
         }
         
         
         if(!objToId.containsKey(e.item())) { // for printing
             objToId.put(e.item(), objToId.size());
             idToObj.put(idToObj.size(),e.item());
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
   && if(ConnectionThreadHistoryAspect.class.desiredAssertionStatus() )) {
    cle.h.update(new call_registerItems(clr, cle, aScheduleName, clientInput, clientOutput));
}

before(com.fredhopper.replication.server.ConnectionThread cle, String aScheduleName,
			DataInputStream clientInput,
			DataOutputStream clientOutput): // from static method
  (call( List *.registerItems(..)) && !this(Object) && target(cle) && args(aScheduleName, clientInput, clientOutput)
   && if(ConnectionThreadHistoryAspect.class.desiredAssertionStatus())) {
    cle.h.update(new call_registerItems(null, cle, aScheduleName, clientInput, clientOutput));
}
       
    

     /* call  void establishSchedule(String clientScheduleName,
			SyncServerSchedule serverSchedule,
			DataOutputStream clientOutput) */
before(Object clr, com.fredhopper.replication.server.ConnectionThread cle, String clientScheduleName,
			SyncServerSchedule serverSchedule,
			DataOutputStream clientOutput):
  (call( void *.establishSchedule(..)) && this(clr) && target(cle) && args(clientScheduleName, serverSchedule, clientOutput)
   && if(ConnectionThreadHistoryAspect.class.desiredAssertionStatus() )) {
    cle.h.update(new call_establishSchedule(clr, cle, clientScheduleName, serverSchedule, clientOutput));
}

before(com.fredhopper.replication.server.ConnectionThread cle, String clientScheduleName,
			SyncServerSchedule serverSchedule,
			DataOutputStream clientOutput): // from static method
  (call( void *.establishSchedule(..)) && !this(Object) && target(cle) && args(clientScheduleName, serverSchedule, clientOutput)
   && if(ConnectionThreadHistoryAspect.class.desiredAssertionStatus())) {
    cle.h.update(new call_establishSchedule(null, cle, clientScheduleName, serverSchedule, clientOutput));
}
       
    

     /* return  List registerItems(String aScheduleName,
			DataInputStream clientInput,
			DataOutputStream clientOutput) */
after(Object clr, com.fredhopper.replication.server.ConnectionThread cle, String aScheduleName,
			DataInputStream clientInput,
			DataOutputStream clientOutput) returning(List ret):
  (call( List *.registerItems(..)) && this(clr) && target(cle) && args(aScheduleName, clientInput, clientOutput)
   && if(ConnectionThreadHistoryAspect.class.desiredAssertionStatus() )) {
    cle.h.update(new return_registerItems(clr, cle, aScheduleName, clientInput, clientOutput, ret));
}

after(com.fredhopper.replication.server.ConnectionThread cle, String aScheduleName,
			DataInputStream clientInput,
			DataOutputStream clientOutput) returning(List ret): // from static method
  (call( List *.registerItems(..)) && !this(Object) && target(cle) && args(aScheduleName, clientInput, clientOutput)
   && if(ConnectionThreadHistoryAspect.class.desiredAssertionStatus())) {
    cle.h.update(new return_registerItems(null, cle, aScheduleName, clientInput, clientOutput, ret));
}
       
    

     /* call  void transferItem(ServerReplicationItem item,
			DataInputStream clientInput,
			DataOutputStream clientOutput) */
before(Object clr, com.fredhopper.replication.server.ConnectionThread cle, ServerReplicationItem item,
			DataInputStream clientInput,
			DataOutputStream clientOutput):
  (call( void *.transferItem(..)) && this(clr) && target(cle) && args(item, clientInput, clientOutput)
   && if(ConnectionThreadHistoryAspect.class.desiredAssertionStatus() )) {
    cle.h.update(new call_transferItem(clr, cle, item, clientInput, clientOutput));
}

before(com.fredhopper.replication.server.ConnectionThread cle, ServerReplicationItem item,
			DataInputStream clientInput,
			DataOutputStream clientOutput): // from static method
  (call( void *.transferItem(..)) && !this(Object) && target(cle) && args(item, clientInput, clientOutput)
   && if(ConnectionThreadHistoryAspect.class.desiredAssertionStatus())) {
    cle.h.update(new call_transferItem(null, cle, item, clientInput, clientOutput));
}
       
    


}