grammar ConnectionThreadRegisterItems;

@header {
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
}

@members {
private final FHLogger logger = FHLoggerFactory.createLogger(ConnectionThreadRegisterItemsParser.class);

private void log(String msg) {
  if (logger.isDebugEnabled()) {
    logger.debug(msg);
  }
}

private HashSet names(Collection items) {
  HashSet names = new HashSet();
  for (Object i : items) {
  	ServerReplicationItem item = (ServerReplicationItem) i;
   	names.add(item.getName());
  }
  return names;
}
}

@rulecatch {
catch(RecognitionException e) {
	throw e;
}
}

//////////////////////// start ::= t EOF//////////////////////////////////
start
 : t EOF;

//////////////////////// t ::= /\ | REGISTER u | SNAPSHOT t | WRITE t //////////////////////////
t returns [String schedule, DataOutputStream output]
 : REGISTER 
   {
    $schedule = ((ConnectionThreadRegisterItemsHistoryAspect.call_registerItems) $REGISTER).aScheduleName(); 
	$output = ((ConnectionThreadRegisterItemsHistoryAspect.call_registerItems) $REGISTER).clientOutput();
   }
   u[$schedule, $output] 
 | SNAPSHOT t
 | WRITE t
 | ;

//////////////////////// u ::= /\ | SNAPSHOT w //////////////////////////
u [String schedule, DataOutputStream output] returns [ReplicationSnapshot snapshot]
 : SNAPSHOT
   { 
     $snapshot = ((ConnectionThreadRegisterItemsHistoryAspect.return_getReplicationSnapshot) $SNAPSHOT).result();
   }
   v[$schedule, $output, $snapshot]
 | ;

//////////////////////// v ::= /\ | LIST w //////////////////////////
v [String schedule, DataOutputStream output, ReplicationSnapshot snapshot]
 : LIST
   { 
     assert ((ConnectionThreadRegisterItemsHistoryAspect.call_getItems) $LIST).callee() == $snapshot;
     assert ((ConnectionThreadRegisterItemsHistoryAspect.call_getItems) $LIST).schedule().equals($schedule);
   }
   w[$output]
 | ;
 
//////////////////////// w ::= /\ | LISTITEMS x //////////////////////////
w [DataOutputStream output] returns [HashSet itemNames, HashSet items]
 : LISTITEMS 
   { 
     $items = new HashSet(((ConnectionThreadRegisterItemsHistoryAspect.return_getItems) $LISTITEMS).result());
     $itemNames = this.names($items);
   }
   x[$output, $itemNames, $items]
 | ;

//////////////////////// x ::= /\ | WRITE x | ITEMS y //////////////////////////
x [DataOutputStream output, HashSet itemNames, HashSet items]
 : WRITE 
   { 
     assert ((ConnectionThreadRegisterItemsHistoryAspect.call_writeStringUTFUtility) $WRITE).stream() == output;
     $itemNames.remove(((ConnectionThreadRegisterItemsHistoryAspect.call_writeStringUTFUtility) $WRITE).s());
   }
   x1=x[$output, $itemNames, $items]
 | ITEMS
   {
   	 assert $itemNames.isEmpty();
     assert $items.containsAll(((ConnectionThreadRegisterItemsHistoryAspect.return_registerItems) $ITEMS).result());
     this.log("finish ConnectionThreadRegisterItems.g");
   } y
 | ;

//////////////////////// y ::= /\ | WRITE y | SNAPSHOT y //////////////////////////
y 
 : SNAPSHOT y
 | WRITE y
 | ;

SNAPSHOT: 'a';
LIST: 'b';
REGISTER: 'c';
LISTITEMS: 'd';
ITEMS: 'e';
WRITE: 'f';