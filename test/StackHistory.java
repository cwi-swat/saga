
import org.antlr.runtime.*;
import java.util.ArrayList;

public class StackHistory implements TokenSource {
  private ArrayList<CommonToken> _L = new ArrayList<CommonToken>();
  private Integer _currentToken;
  private EList<Object> _start; // Synthesized attributes of start non-terminal
  
  
  public StackHistory() {
    _L.add(new CommonToken(Token.EOF));
    parse(); // the empty history
  }

  // Implemented for TokenSource interface
  public String getSourceName() {
    return null;
  }
 
  public CommonToken nextToken() {
    return _L.get(_currentToken++);
  }

  // Parse the history in antlr and set attribute values
  private void parse() {
    _currentToken = 0;
    CommonTokenStream tokens = new CommonTokenStream(this);
    StackParser parser = new StackParser(tokens);

    try {
      
      _start = parser.start();
      
    } catch(RecognitionException r) {
      System.err.println("=== ERROR! History violates event protocol structure specified in the grammar === \n");
      //@ assert false; // Assertion Failure
    }
  }

  
  public EList<Object> stack() {
    return _start;
  }
  

  
  

  
  public void update(return_pop e) {
       e.setType(StackLexer.POP);
       _L.add(_L.size()-1, e);
       parse();
  }
  
  
  

  
  public void update(return_push e) {
       e.setType(StackLexer.PUSH);
       _L.add(_L.size()-1, e);
       parse();
  }
  
  
}