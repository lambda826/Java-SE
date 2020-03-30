/**
 *  @author Yunxiang He
 *  @date Feb 13, 2018 3:51:47 PM
 */

package exceptions;

import static common.utils.PrintUtil.println;

public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            println("Caught Exception");
            println("getMessage():" + e.getMessage());
            println("getLocalizedMessage():" + e.getLocalizedMessage());
            println("toString():" + e);
            println("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }
}