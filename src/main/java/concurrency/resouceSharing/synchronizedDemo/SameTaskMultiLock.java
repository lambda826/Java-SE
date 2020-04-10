package concurrency.resouceSharing.synchronizedDemo;

import static utils.PrintUtil.println;

/**
 * Same mutex can be multiply acquired by the same task
 */
public class SameTaskMultiLock {
    public synchronized void f1(int count) {
        if (count-- > 0) {
            println("f1() calling f2() with count " + count);
            f2(count);
        }
    }

    public synchronized void f2(int count) {
        if (count-- > 0) {
            println("f2() calling f1() with count " + count);
            f1(count);
        }
    }

    public static void main(String[] args) {
        final SameTaskMultiLock sameTaskMultiLock = new SameTaskMultiLock();
        new Thread() {
            public void run() {
                sameTaskMultiLock.f1(10);
            }
        }.start();
    }
}