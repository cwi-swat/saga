
public class Test {
    public static void main(String[] args) throws Exception {
      StackImpl s = new StackImpl();
      s.push(new Integer(7));
      s.pop();
      s.push(new Integer(3));
      s.pop();
      s.pop();
    }
}
