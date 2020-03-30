package concurrency;

import java.util.concurrent.TimeUnit;

import static common.utils.PrintUtil.println;

// Daemon threads don't prevent the program from ending.

public class _11_SimpleDaemons implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new _11_SimpleDaemons());
            daemon.setDaemon(true); // Must call before start()
            daemon.start();
        }
        println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}