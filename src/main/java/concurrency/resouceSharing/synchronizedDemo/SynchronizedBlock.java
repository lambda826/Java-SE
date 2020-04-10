package concurrency.resouceSharing.synchronizedDemo;

import static utils.PrintUtil.println;

public class SynchronizedBlock implements Runnable {

    static SynchronizedBlock monitorInstance = new SynchronizedBlock();
    static int i = 0;

    @Override
    public void run() {
        // synchronized (this) {
        // synchronized (SynchronizedBlock.class) {
        synchronized (monitorInstance) {
            for (int j = 0; j < 10000000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(monitorInstance);
        Thread t2 = new Thread(monitorInstance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        println(i);
    }
}
