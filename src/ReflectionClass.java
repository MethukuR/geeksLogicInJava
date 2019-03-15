import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Reference : http://www.javatpoint.com/how-to-call-private-method-from-another-class-in-java
 * 
 * @author Raju Rockzz :P
 *
 */
class Dummy {
  private void foo() {
    System.out.println("hello foo()");
  }
}


public class ReflectionClass {
  public static void main(String[] args) throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Dummy d = new Dummy();
    Method m = Dummy.class.getDeclaredMethod("foo");
    // m.invoke(d);// throws java.lang.IllegalAccessException
    m.setAccessible(true);// Abracadabra
    m.invoke(d);// now its OK
  }

}

