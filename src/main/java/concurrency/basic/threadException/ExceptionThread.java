package concurrency.basic.threadException;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static utils.PrintUtil.println;

public class ExceptionThread implements Runnable {

    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        // Native exception handler won't capture the exception
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (Exception e) {
            // This statement will NOT execute!
            println("Exception has been handled!");
        }
    }
}
