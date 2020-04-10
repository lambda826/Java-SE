package concurrency.basic.priority;

import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;

public class PrioritiesDemo extends Thread {

    private int count = 0;

    public PrioritiesDemo(int name) {
        super("Thread with priority(" + name + ")");
        this.setPriority(name);
    }

    @Override
    public void run() {
        try {
            while (true) {
                count++;
                Thread.yield();
            }
        } finally {
            println(this.getName() + "count: " + count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new PrioritiesDemo(Thread.MIN_PRIORITY);
        Thread t2 = new PrioritiesDemo(Thread.MAX_PRIORITY - 1);
        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t1.stop();
        t2.stop();
    }
}