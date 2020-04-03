package concurrency.basic.daemons;

import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;

public class SimpleDaemons implements Runnable {
    public void run() {
        try {
            while (true) {
                // TimeUnit.MILLISECONDS.sleep(100);
                TimeUnit.MILLISECONDS.sleep(1000);
                println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // Must call before start()
            daemon.start();
        }
        println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}