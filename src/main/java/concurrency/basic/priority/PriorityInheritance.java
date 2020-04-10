package concurrency.basic.priority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static utils.PrintUtil.println;

public class PriorityInheritance {

    private static class Task1 extends Thread {
        @Override
        public void run() {
            this.setPriority(8);
            println(this.getName() + " " + this.getPriority());
            Thread t2 = new Task2();
            t2.start();
        }
    }

    private static class Task2 extends Thread {
        @Override
        public void run() {
            println(this.getName() + " " + this.getPriority());
        }
    }

    public static void main(String[] args) {
        println("Child thread inherited same priority from Parent thread");
        new Task1().start();
        println("Using executorService will result in default priority of the child thread");
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new Task1());
        es.shutdown();
    }
}
