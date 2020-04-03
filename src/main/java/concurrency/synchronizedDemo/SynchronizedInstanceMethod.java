package concurrency.synchronizedDemo;

import static utils.PrintUtil.println;

public class SynchronizedInstanceMethod implements Runnable {

    // Shared data
    public static int i = 0;

    // synchronized instant method
    public synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            increase();
        }
    }

    private static void test(SynchronizedInstanceMethod instance) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        println(i);
    }

    private static void test2(SynchronizedInstanceMethod instance, SynchronizedInstanceMethod instance2) throws InterruptedException {
        // Different instances, different locks
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        println(i);
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedInstanceMethod instance = new SynchronizedInstanceMethod();
        SynchronizedInstanceMethod instance2 = new SynchronizedInstanceMethod();
        test(instance);
        test2(instance, instance2);
    }
}
