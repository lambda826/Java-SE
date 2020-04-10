package concurrency.basic.interruption;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;


public class Interrupting {

    private static class SleepBlocked_100Sec implements Runnable {
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                println("InterruptedException");
            }
            println("Exiting SleepBlocked.run()");
        }
    }

    private static class IOBlocked implements Runnable {
        private InputStream in;

        public IOBlocked(InputStream is) {
            in = is;
        }

        public void run() {
            try {
                println("Waiting for read():");
                in.read();
            } catch (IOException e) {
                if (Thread.currentThread().isInterrupted()) {
                    println("Interrupted from blocked I/O");
                } else {
                    throw new RuntimeException(e);
                }
            }
            println("Exiting IOBlocked.run()");
        }
    }

    private static class SynchronizedBlocked implements Runnable {

        public synchronized void f() {
            while (true) { // Never releases lock
                Thread.yield();
            }
        }

        public SynchronizedBlocked() {
            new Thread() {
                public void run() {
                    f(); // Lock acquired by this thread
                }
            }.start();
        }

        public void run() {
            println("Trying to call f()");
            f();
            println("Exiting SynchronizedBlocked.run()");
        }
    }

    private static ExecutorService exec = Executors.newCachedThreadPool();

    private static void test(Runnable r) throws InterruptedException {
        Future<?> future = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        println("Interrupting " + r.getClass().getName());
        future.cancel(true); // Interrupts if running
        println("Interrupt sent to " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
        test(new SleepBlocked_100Sec());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        println("Aborting with System.exit(0)");
        System.exit(0); // ... since last 2 interrupts failed
    }
}