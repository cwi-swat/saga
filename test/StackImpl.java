import java.util.Vector;

public class StackImpl extends Vector<Object> implements StackInterface {
  private static final long serialVersionUID = 1L;

  public void push(Object item) { add(item);
                               history.update(new return_push(item)); }

  public Object pop() { Object ret = null;
    remove(ret = lastElement());
	{Object history_tmp = ret; history.update(new return_pop(history_tmp)); return history_tmp;} }
}