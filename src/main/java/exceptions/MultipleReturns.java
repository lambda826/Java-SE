/**
 *  @author Yunxiang He
 *  @date Feb 13, 2018 4:29:21 PM
 */

package exceptions;

import static utils.PrintUtil.println;

/*

Because a finally clause is always executed,
it’s possible to return from multiple points within a method and still guarantee that important cleanup will be performed

 */

public class MultipleReturns {
    public static void f(int i) {
        println("Initialization that requires cleanup");
        try {
            println("Point 1");
            if (i == 1) {
                return;
            }
            println("Point 2");
            if (i == 2) {
                return;
            }
            println("Point 3");
            if (i == 3) {
                return;
            }
            println("End");
            return;
        } finally {
            println("Performing cleanup");
        }
    }

    public static int g() {
        try {
            return 1;
        } finally {
            println("111");
        }

    }

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            f(i);
        }
        System.out.println(g());
    }
}