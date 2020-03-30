/**
 *  @author Yunxiang He
 *  @date Feb 14, 2018 12:52:09 AM
 */

package exceptions;

/*



 */

public class _904_FootBall {
    public static void main(String[] officials) {
        try {
            System.out.println('A');
            throw new RuntimeException("Out of bounds!");
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println('B');
        } finally {
            System.out.println('C');
        }
    }
}