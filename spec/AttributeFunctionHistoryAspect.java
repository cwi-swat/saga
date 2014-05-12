import com.fredhopper.attribute.function.AttributeFunctionProperties;
import com.fredhopper.request.context.RequestContext;
import java.util.List;
import com.fredhopper.product.Item;

import java.util.IdentityHashMap; // stores objToId
import org.antlr.runtime.*; // for use in AttributeFunctionHistory
import java.util.ArrayList; // for use in AttributeFunctionHistory
import java.util.Iterator; // for use in AttributeFunctionHistory
import java.util.HashSet; // for use in AttributeFunctionHistory
import java.util.HashMap; // for use in AttributeFunctionHistory

aspect AttributeFunctionHistoryAspect {
    private AttributeFunctionHistory com.fredhopper.attribute.function.AttributeFunction.h = new AttributeFunctionHistory();

///////////////////////////////////////////////////////
/////////////////////// Event classes /////////////////
///////////////////////////////////////////////////////

 public class call_floatValue extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final Object caller;
  public Object caller() {
    return this.caller;
  }
  
  private final com.fredhopper.attribute.function.AttributeFunction callee;
  public com.fredhopper.attribute.function.AttributeFunction callee() {
    return this.callee;
  }
  
  private final Item item;
  public Item item() {
    return this.item;
  }
  

  public String toString() {
    return "o" + AttributeFunctionHistory.objToId.get(caller) + ":o" + AttributeFunctionHistory.objToId.get(callee) + ".floatValue(" + "o" + AttributeFunctionHistory.objToId.get(item) + ")";
  }

  public call_floatValue(Object caller, com.fredhopper.attribute.function.AttributeFunction callee, Item item) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
    this.item = item;
    
  }
}


 public class call_init extends org.antlr.runtime.CommonToken {
  private static final long serialVersionUID = 3L;

  
  private final Object caller;
  public Object caller() {
    return this.caller;
  }
  
  private final com.fredhopper.attribute.function.AttributeFunction callee;
  public com.fredhopper.attribute.function.AttributeFunction callee() {
    return this.callee;
  }
  
  private final RequestContext ctx;
  public RequestContext ctx() {
    return this.ctx;
  }
  
  private final AttributeFunctionProperties properties;
  public AttributeFunctionProperties properties() {
    return this.properties;
  }
  
  private final List queryParams;
  public List queryParams() {
    return this.queryParams;
  }
  
  private final String args;
  public String args() {
    return this.args;
  }
  

  public String toString() {
    return "o" + AttributeFunctionHistory.objToId.get(caller) + ":o" + AttributeFunctionHistory.objToId.get(callee) + ".init(" + "o" + AttributeFunctionHistory.objToId.get(ctx) + ", " +"o" + AttributeFunctionHistory.objToId.get(properties) + ", " +"o" + AttributeFunctionHistory.objToId.get(queryParams) + ", " +"o" + AttributeFunctionHistory.objToId.get(args) + ")";
  }

  public call_init(Object caller, com.fredhopper.attribute.function.AttributeFunction callee, RequestContext ctx, AttributeFunctionProperties properties, List queryParams, String args) {
    super(-1);

    
    this.caller = caller;
    
    this.callee = callee;
    
    this.ctx = ctx;
    
    this.properties = properties;
    
    this.queryParams = queryParams;
    
    this.args = args;
    
  }
}




///////////////////////////////////////////////////////
/////////////////////// History class /////////////////
///////////////////////////////////////////////////////
    
    public static class AttributeFunctionHistory implements TokenSource {
      public  static IdentityHashMap<Object, Integer> objToId = new IdentityHashMap<Object, Integer>();
      public  static HashMap<Integer, Object> idToObj = new HashMap<Integer, Object>();
      private HashSet<Integer> actors = new HashSet<Integer>();
    
      private ArrayList<CommonToken> _L = new ArrayList<CommonToken>();
      private Integer _currentToken;
      
    
      public AttributeFunctionHistory() {
        _L.add(new CommonToken(Token.EOF));
        _L.add(new CommonToken(Token.EOF));
    
        parse(); // the empty history
      }
    
      // Implemented for TokenSource interface
      public String getSourceName() {
        return null;
      }
    
      public void print() {
        
        System.err.println("=== ERROR! Local history of view AttributeFunctionHistory (events: " + Integer.toString(_L.size()-2) + ") of com.fredhopper.attribute.function.AttributeFunction object violates grammar AttributeFunction.g === \n");
        
    
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
        AttributeFunctionParser parser = new AttributeFunctionParser(tokens);
    
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
    
      
    
      
       public synchronized void update(call_floatValue e) {
         e.setType(AttributeFunctionLexer.USE);
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
         
         actors.add(objToId.get(e.caller()));
         actors.add(objToId.get(e.callee()));
    
         parse();
    }
      
      
       public synchronized void update(call_init e) {
         e.setType(AttributeFunctionLexer.INIT);
         _L.add(_L.size()-2, e);
    
    
         if(!objToId.containsKey(e.caller())) { // for printing
             objToId.put(e.caller(), objToId.size());
             idToObj.put(idToObj.size(),e.caller());
         }
         if(!objToId.containsKey(e.callee())) { // for printing
             objToId.put(e.callee(), objToId.size());
             idToObj.put(idToObj.size(),e.callee());
         }
         
         
         if(!objToId.containsKey(e.ctx())) { // for printing
             objToId.put(e.ctx(), objToId.size());
             idToObj.put(idToObj.size(),e.ctx());
         }
         
         if(!objToId.containsKey(e.properties())) { // for printing
             objToId.put(e.properties(), objToId.size());
             idToObj.put(idToObj.size(),e.properties());
         }
         
         if(!objToId.containsKey(e.queryParams())) { // for printing
             objToId.put(e.queryParams(), objToId.size());
             idToObj.put(idToObj.size(),e.queryParams());
         }
         
         if(!objToId.containsKey(e.args())) { // for printing
             objToId.put(e.args(), objToId.size());
             idToObj.put(idToObj.size(),e.args());
         }
         
         actors.add(objToId.get(e.caller()));
         actors.add(objToId.get(e.callee()));
    
         parse();
    }
      
      
      
    }


///////////////////////////////////////////////////////
/////////////////////// Aspects ///////////////////////
///////////////////////////////////////////////////////

     /* call  float floatValue(Item item) */
before(Object clr, com.fredhopper.attribute.function.AttributeFunction cle, Item item):
  (call( float *.floatValue(..)) && this(clr) && target(cle) && args(item)
   && if(AttributeFunctionHistoryAspect.class.desiredAssertionStatus() )) {
    cle.h.update(new call_floatValue(clr, clr, cle, item));
}

before(com.fredhopper.attribute.function.AttributeFunction cle, Item item): // from static method
  (call( float *.floatValue(..)) && !this(Object) && target(cle) && args(item)
   && if(AttributeFunctionHistoryAspect.class.desiredAssertionStatus())) {
    cle.h.update(new call_floatValue(null, clr, cle, item));
}

    

     /* call  void init(RequestContext ctx, AttributeFunctionProperties properties, List queryParams, String args) */
before(Object clr, com.fredhopper.attribute.function.AttributeFunction cle, RequestContext ctx, AttributeFunctionProperties properties, List queryParams, String args):
  (call( void *.init(..)) && this(clr) && target(cle) && args(ctx, properties, queryParams, args)
   && if(AttributeFunctionHistoryAspect.class.desiredAssertionStatus() )) {
    cle.h.update(new call_init(clr, clr, cle, ctx, properties, queryParams, args));
}

before(com.fredhopper.attribute.function.AttributeFunction cle, RequestContext ctx, AttributeFunctionProperties properties, List queryParams, String args): // from static method
  (call( void *.init(..)) && !this(Object) && target(cle) && args(ctx, properties, queryParams, args)
   && if(AttributeFunctionHistoryAspect.class.desiredAssertionStatus())) {
    cle.h.update(new call_init(null, clr, cle, ctx, properties, queryParams, args));
}

    


}