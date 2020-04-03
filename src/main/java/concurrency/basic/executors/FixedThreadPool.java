package concurrency.basic.executors;

import concurrency.basic.Implement_Runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            exec.execute(new Implement_Runnable());
        }
        exec.shutdown();
    }
} 