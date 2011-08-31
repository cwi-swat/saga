public interface StackInterface {
    /*@ public StackHistory history = new StackHistory(); @*/
    
    //@ ensures history.stack().equals(\old(history.stack()).appendElement(item));
    public void push(Object item);
    
    //@ requires history.stack().size() != 0;
    //@ ensures history.stack().equals(\old(history.stack()).tail());
    //@ ensures \result == \old(history.stack()).head();
    public Object pop();
    
    // view StackHistory grammar Stack.g { return_push PUSH, return_pop POP }
}
