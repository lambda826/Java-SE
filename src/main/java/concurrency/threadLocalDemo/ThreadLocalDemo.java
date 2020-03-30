package concurrency.threadLocalDemo;

import static common.utils.PrintUtil.println;

public class ThreadLocalDemo {

    public static void main(String[] args) {
        final ThreadLocal<Person> sharedThreadLocalPerson = ThreadLocal.withInitial(() -> new Person());
        Thread t1 = new Thread(new Task1(sharedThreadLocalPerson));
        Thread t2 = new Thread(new Task2(sharedThreadLocalPerson));
        t1.start();
        t2.start();
    }

    private static class Task1 implements Runnable {

        private ThreadLocal<Person> threadLocalPerson;

        public Task1(ThreadLocal<Person> threadLocalPerson) {
            this.threadLocalPerson = threadLocalPerson;
        }

        @Override
        public void run() {
            threadLocalPerson.set(threadLocalPerson.get().setAge(1));
            threadLocalPerson.set(threadLocalPerson.get().setName("a"));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            println(Thread.currentThread().getName() + " ThreadLocalPerson: " + threadLocalPerson.get());
        }
    }

    private static class Task2 implements Runnable {

        private ThreadLocal<Person> threadLocalPerson;

        public Task2(ThreadLocal<Person> threadLocalPerson) {
            this.threadLocalPerson = threadLocalPerson;
        }

        @Override
        public void run() {
            threadLocalPerson.set(threadLocalPerson.get().setAge(2));
            threadLocalPerson.set(threadLocalPerson.get().setName("b"));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            println(Thread.currentThread().getName() + " ThreadLocalPerson: " + threadLocalPerson.get());
        }
    }

}


