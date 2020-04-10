package concurrency.basic.daemons;


import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.printnb;

// Daemon threads spawn other daemon threads.
public class DaemonsChildren {

    private static class DaemonChild implements Runnable {
        public void run() {
            while (true) {
                Thread.yield();
            }
        }
    }

    // If a thread is a daemon, then any threads it creates will automatically be daemons
    private static class DaemonThread implements Runnable {
        public void run() {
            int i = 0;
            while (true) {
                Thread t = new Thread(new DaemonChild(), String.valueOf(i));
                printnb("t[" + ++i + "].isDaemon() = " + t.isDaemon() + ", ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new DaemonThread());
        d.setDaemon(true);
        d.start();
        printnb("d.isDaemon() = " + d.isDaemon() + ", ");
        // Allow the daemon threads to finish their startup processes:
        TimeUnit.MILLISECONDS.sleep(100);
    }
}