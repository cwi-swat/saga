import java.util.Vector;
  
public class EList<T> extends Vector<T> {
  private static final long serialVersionUID = 1L;

    EList<T> append(EList<T> m) {
      EList<T> res = new EList<T>();
      res.addAll(this);
      res.addAll(m);
      return res;
    }

    EList<T> appendElement(T m) {
      EList<T> res = new EList<T>();
      res.addAll(this);
      res.add(m);
      return res;
    }
    
    T head() {
        return lastElement();
    }
    
    EList<T> tail() {
      EList<T> res = new EList<T>();
      if(size() > 0)
        res.addAll(subList(0, size()-1));
      return res;
    }
}
