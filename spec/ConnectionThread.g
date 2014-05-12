grammar ConnectionThread;

@header {
import java.util.List;
import java.util.ArrayList;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import com.fredhopper.replication.server.SyncServerSchedule;
import com.fredhopper.replication.server.item.ServerReplicationItem;
}

@rulecatch {
catch(RecognitionException e) {
	throw e;
}
}

//////////////////////// start ::= t EOF//////////////////////////////////
start
 : t[(String) null,new ArrayList()] EOF;

//////////////////////// t ::= /\ | ESTABLISH u //////////////////////////
t [String Schedule, ArrayList Items]
 : ESTABLISH 
   { 
     assert ((ConnectionThreadHistoryAspect.call_establishSchedule) $ESTABLISH).clientScheduleName() != null;
     $Schedule = ((ConnectionThreadHistoryAspect.call_establishSchedule) $ESTABLISH).clientScheduleName();
   } 
   u[$Schedule, $Items]
 | ;

//////////////////////// u ::= /\ | REGISTER w //////////////////////////
u [String Schedule, ArrayList Items]
 : {!($Schedule.equals(com.fredhopper.application.SyncServer.COMMAND_LIST_SCHEDULES))}? => REGISTER
   { 
     assert ((ConnectionThreadHistoryAspect.call_registerItems) $REGISTER).aScheduleName().equals($Schedule); 
   }
   v[$Schedule, $Items]
 | ;

//////////////////////// v ::= /\ | ITEMS w //////////////////////////
v [String Schedule, ArrayList Items]
 : ITEMS
   { 
     $Items.addAll(((ConnectionThreadHistoryAspect.return_registerItems) $ITEMS).result()); 
   }
   w[$Schedule, $Items]
 | ;
 
 //////////////////////// w ::= /\ | TRANSFER w //////////////////////////
w [String Schedule, ArrayList Items]
 : TRANSFER 
   { 
     assert $Items.get(0).equals(((ConnectionThreadHistoryAspect.call_transferItem) $TRANSFER).item()); 
     $Items.remove(((ConnectionThreadHistoryAspect.call_transferItem) $TRANSFER).item()); 
   }
   w1=w[$Schedule, $Items]
 | ;

////////////////////////////////////////////////

ESTABLISH: 'b';
REGISTER: 'c';
ITEMS: 'd';
TRANSFER: 'e';
