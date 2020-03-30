package concurrency;

import static common.utils.PrintUtil.println;

// Daemon threads don't run the finally clause

class ADaemon implements Runnable {
    public void run() {
        try {
            println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            println("Exiting via InterruptedException");
        } finally {
            println("This should always run?");
        }
    }
}

public class _16_DaemonsDontRunFinally {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}