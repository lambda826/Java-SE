package concurrency.basic.join;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;

public class JoinDemoThreadPool {
    private static class NetWorkRequest implements Runnable {
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            println("result");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new NetWorkRequest());
        TimeUnit.SECONDS.sleep(3);
        es.execute(new NetWorkRequest());
        println("proceeding1");
        println("proceeding2");
        println("proceeding3");
        println("proceeding4");
        es.shutdown();
        es.awaitTermination(15, TimeUnit.SECONDS); // Wait for all the tasks to complete submitted by the executorService
        println("proceeding5");

    }
}
