package concurrency.basic.interruption;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static utils.PrintUtil.println;

// Interrupting a task blocked with a ReentrantLock.
public class Interrupting2 {

    private static class BlockedMutex {
        private Lock lock = new ReentrantLock();

        // Constructor that acquires the object's own Lock and never releases it
        public BlockedMutex() {
            // Acquire it right away, to demonstrate interruption of a task blocked on a ReentrantLock:
            lock.lock();
        }

        public void f() {
            try {
                // This will never be available to a second task
                lock.lockInterruptibly(); // Special call
                println("lock acquired in f()");
            } catch (InterruptedException e) {
                println("Interrupted from lock acquisition in f()");
            }
        }
    }

    private static class Blocked implements Runnable {
        BlockedMutex blocked = new BlockedMutex();

        @Override
        public void run() {
            println("Waiting for f() in BlockedMutex");
            blocked.f();
            println("Broken out of blocked call");
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Blocked());
        t.start(); // try to call f( ) from a second task
        TimeUnit.SECONDS.sleep(1);
        println("Issuing t.interrupt()");
        t.interrupt();
    }
}