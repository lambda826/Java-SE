package concurrency.threadLocalDemo;

import static common.utils.PrintUtil.println;

public class ThreadUsingInstanceVariable {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task1());
        Thread t2 = new Thread(new Task2());
        t1.start();
        t2.start();
    }

    private static class Task1 implements Runnable {

        private Person person = new Person();

        @Override
        public void run() {
            person.setAge(1);
            person.setName("a");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            println(Thread.currentThread().getName() + " Instance Person: " + person);
        }
    }

    private static class Task2 implements Runnable {

        private Person person = new Person();

        @Override
        public void run() {
            person.setAge(2);
            person.setName("b");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            println(Thread.currentThread().getName() + " Instance Person: " + person);
        }
    }
}
