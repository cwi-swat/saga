grammar AttributeFunction;

@header {
import com.fredhopper.attribute.function.AttributeFunctionProperties;
import com.fredhopper.request.context.RequestContext;
import java.util.List;
import com.fredhopper.product.Item;
}

@rulecatch {
catch(RecognitionException e) {
  throw e;
}
}

//////////////////////// start ::= s EOF//////////////////////////////////
start : s EOF;

//////////////////////// s ::= /\ | INIT t //////////////////////////
s : INIT {assert false; } t | ;

//////////////////////// t ::= /\ | USE t //////////////////////////
t : USE  t | ;

////////////////////////////////////////////////

INIT: 'a';
USE: 'b';
