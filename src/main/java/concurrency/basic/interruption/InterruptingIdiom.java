package concurrency.basic.interruption;

import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;

public class InterruptingIdiom {

    static class NeedsCleanup {
        private final int id;

        public NeedsCleanup(int id) {
            this.id = id;
            println("NeedsCleanup " + id);
        }

        public void cleanup() {
            println("Cleaning up " + id);
        }
    }

    static class Blocked implements Runnable {
        private volatile double d = 0.0;

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    // point1
                    NeedsCleanup n1 = new NeedsCleanup(1);
                    // Start try-finally immediately after definition of n1, to guarantee proper cleanup of n1:
                    try {
                        println("Sleeping");
                        TimeUnit.SECONDS.sleep(1);
                        // point2
                        NeedsCleanup n2 = new NeedsCleanup(2);
                        // Guarantee proper cleanup of n2:
                        try {
                            println("Calculating");
                            // A time-consuming, non-blocking operation:
                            for (int i = 1; i < 2500000; i++) {
                                d = d + (Math.PI + Math.E) / d;
                            }
                            println("Finished time-consuming operation");
                        } finally {
                            n2.cleanup();
                        }
                    } finally {
                        n1.cleanup();
                    }
                }
                println("Exiting via while() test");
            } catch (InterruptedException e) {
                println("Exiting via InterruptedException");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            println("usage: java InterruptingIdiom delay-in-mS");
            System.exit(1);
        }
        Thread t = new Thread(new Blocked());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        t.interrupt();
    }
}