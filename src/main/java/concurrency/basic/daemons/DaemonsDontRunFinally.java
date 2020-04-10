package concurrency.basic.daemons;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;

public class DaemonsDontRunFinally {

    private static class ADaemon implements Runnable {
        public void run() {
            try {
                println("Starting ADaemon");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                println("Exiting via InterruptedException");
            } finally {
                println("Daemon threads don't run the finally clause");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        TimeUnit.SECONDS.sleep(1);
    }
}