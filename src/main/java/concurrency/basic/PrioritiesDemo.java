package concurrency.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static utils.PrintUtil.println;

public class PrioritiesDemo implements Runnable {

    private int countDown = 5;
    private volatile double d; // No optimization
    private int priority;
    private String name;

    public PrioritiesDemo(int priority) {
        this.priority = priority;
        if (priority == Thread.MIN_PRIORITY) {
            this.name = "MIN_PRIORITY";
        } else {
            this.name = "-----------";
        }
    }

    public String toString() {
        return Thread.currentThread() + " " + name + ": " + countDown;
    }

    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            // An expensive, interruptable operation:
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new PrioritiesDemo(Thread.MIN_PRIORITY));
        }
        exec.execute(new PrioritiesDemo(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}