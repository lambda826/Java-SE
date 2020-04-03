package concurrency.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;

public class SleepingTask extends Implement_Runnable {

    public void run() {
        try {
            while (countDown-- > 0) {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println(status());
                // Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}