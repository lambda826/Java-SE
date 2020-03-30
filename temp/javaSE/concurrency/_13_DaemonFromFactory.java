package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static common.utils.PrintUtil.println;

public class _13_DaemonFromFactory implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            println("Interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(new _12_DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new _13_DaemonFromFactory());
        }
        println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
} 