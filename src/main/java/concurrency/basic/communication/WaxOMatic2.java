package concurrency.basic.communication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static utils.PrintUtil.print;
import static utils.PrintUtil.printnb;

public class WaxOMatic2 {

    private static class Car {
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private boolean waxOn = false;

        public void waxed() {
            lock.lock();
            try {
                waxOn = true; // Ready to buff
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void buffed() {
            lock.lock();
            try {
                waxOn = false; // Ready for another coat of wax
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void waitForWaxing() throws InterruptedException {
            lock.lock();
            try {
                while (waxOn == false) {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }

        public void waitForBuffing() throws InterruptedException {
            lock.lock();
            try {
                while (waxOn == true) {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private static class WaxOn implements Runnable {
        private Car car;

        public WaxOn(Car car) {
            this.car = car;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    printnb("Wax On! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.waxed();
                    car.waitForBuffing();
                }
            } catch (InterruptedException e) {
                print("Exiting via interrupt");
            }
            print("Ending Wax On task");
        }
    }

    private static class WaxOff implements Runnable {
        private Car car;

        public WaxOff(Car car) {
            this.car = car;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    car.waitForWaxing();
                    printnb("Wax Off! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.buffed();
                }
            } catch (InterruptedException e) {
                print("Exiting via interrupt");
            }
            print("Ending Wax Off task");
        }
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }


}