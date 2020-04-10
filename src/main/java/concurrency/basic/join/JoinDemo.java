package concurrency.basic.join;

import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;

public class JoinDemo {

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
        Thread t = new Thread(new NetWorkRequest());
        t.start();
        println("proceeding1");
        println("proceeding2");
        println("proceeding3");
        println("proceeding4");
        t.join(); // Have to wait for t to finish and then proceed
        println("proceeding5");
    }

}
