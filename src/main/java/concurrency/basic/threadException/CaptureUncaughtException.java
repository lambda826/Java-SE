package concurrency.basic.threadException;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static utils.PrintUtil.println;

public class CaptureUncaughtException {

    private static class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            println("caught " + e);
        }
    }

    private static class HandlerThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            println(this + " creating new Thread");
            Thread t = new Thread(r);
            println("created " + t);
            t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            println("eh = " + t.getUncaughtExceptionHandler());
            return t;
        }
    }

    private static class ExceptionThread2 implements Runnable {
        @Override
        public void run() {
            Thread t = Thread.currentThread();
            println("run() by " + t);
            println("eh = " + t.getUncaughtExceptionHandler());
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        // Case-by-case basis
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
        exec.shutdown();

        // Default uncaught exception handler
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec2 = Executors.newCachedThreadPool();
        exec2.execute(new ExceptionThread2());
        exec2.shutdown();
    }
}