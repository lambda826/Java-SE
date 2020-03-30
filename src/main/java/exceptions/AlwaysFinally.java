/**
 *  @author Yunxiang He
 *  @date Feb 13, 2018 4:26:56 PM
 */

package exceptions;

import static common.utils.PrintUtil.println;

/*

Even in cases in which the exception is not caught in the current set of catch clauses,
finally will be executed before the exception-handling mechanism continues its search for a handler at the next higher level

 */

class FourException extends Exception {
}

public class AlwaysFinally {
    public static void main(String[] args) {
        println("Entering first try block");
        try {
            println("Entering second try block");
            try {
                throw new FourException();
            } finally {
                println("finally in 2nd try block");
            }
        } catch (FourException e) {
            System.out.println("Caught FourException in 1st try block");
        } finally {
            System.out.println("finally in 1st try block");
        }
    }
}