import java.util.Arrays;

public class Test {
  
  public static void main(String[] args) {
    /*char a = 'a';
    char A = 'A';
    if( A == (a^32)) {
      System.out.println(Integer.toBinaryString(a));
      System.out.println(Integer.toBinaryString(A^32));

      System.out.println("yep");
    }*/
    String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
    Arrays.stream(names)    // same as Stream.of(names)
        .filter(x -> x.startsWith("S"))
        .sorted()
        .forEach(System.out::println);
  }
  
  
  
  private static void testStatic() {
      /*char a = 'a';
      char A = 'A';
      if( a == (A^32)) {
        System.out.println("yep");
      }*/
    
    int x = 6;
    x = (x<<1);
    System.out.println(x);
    
  }
  
}


