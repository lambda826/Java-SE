//: access/PrintTest.java
// Uses the static printing methods in Print.java.
package access;

import static utils.PrintUtil.println;

public class PrintTest {
    public static void main(String[] args) {
        println("Available from now on!");
        println(100);
        println(100L);
        println(3.14159);
    }
} /* Output:
  Available from now on!
  100
  100
  3.14159
  *///:~
