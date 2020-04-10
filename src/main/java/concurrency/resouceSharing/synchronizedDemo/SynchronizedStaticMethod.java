package concurrency.resouceSharing.synchronizedDemo;

import static utils.PrintUtil.println;

/**
 * When synchronized is modified on static method, it checks Class object lock.
 * If another method is checking an instant method, it checks this instant object lock,
 *     then there won't be a mutex and the thread-safe is not guaranteed.
 */
public class SynchronizedStaticMethod implements Runnable {

    static int i = 0;

    // synchronized static method, the lock is on Class
    public synchronized static void increaseStatic() {
        i++;
    }

    // synchronized instant method, the lock is on object
    public synchronized void increaseNonStatic() {
        // public static synchronized void increaseNonStatic() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increaseStatic();
            increaseNonStatic();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new SynchronizedStaticMethod());
        Thread t2 = new Thread(new SynchronizedStaticMethod());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        println(i);
    }

}
