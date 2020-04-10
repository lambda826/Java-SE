package concurrency.basic.interruption;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;


public class OrnamentalGarden {

    private static class Count {
        private int count = 0;
        private Random rand = new Random(47);

        // Remove the synchronized keyword to see counting fail:
        public synchronized int increment() {
            int temp = count;
            if (rand.nextBoolean()) { // Yield half the time
                Thread.yield();
            }
            return (count = ++temp);
        }

        public synchronized int value() {
            return count;
        }
    }

    private static class Entrance implements Runnable {
        private static Count count = new Count(); // Single shared counter
        private static List<Entrance> entrances = new ArrayList<>();
        private static volatile boolean canceled = false;

        // Doesn't need synchronization to read:
        private final int id;
        private int number = 0;

        // Atomic operation on a volatile field:
        public static void cancel() {
            canceled = true;
        }

        public Entrance(int id) {
            this.id = id;
            // Keep this task in a list. Also prevents garbage collection of dead tasks:
            entrances.add(this);
        }

        public void run() {
            while (!canceled) {
                synchronized (this) {
                    ++number;
                }
                println(this + " Total: " + count.increment());
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    println("sleep interrupted");
                }
            }
            println("Stopping " + this);
        }

        public synchronized int getValue() {
            return number;
        }

        public String toString() {
            return "Entrance " + id + ": " + getValue();
        }

        public static int getTotalCount() {
            return count.value();
        }

        public static int sumEntrances() {
            int sum = 0;
            for (Entrance entrance : entrances) {
                sum += entrance.getValue();
            }
            return sum;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }
        // Run for a while, then stop and collect the data:
        TimeUnit.SECONDS.sleep(2);
        Entrance.cancel();
        exec.shutdown();
        if (!exec.awaitTermination(200, TimeUnit.MILLISECONDS)) {
            println("Some tasks were not terminated!");
        }
        println("Total: " + Entrance.getTotalCount());
        println("Sum of Entrances: " + Entrance.sumEntrances());
    }
}