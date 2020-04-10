package concurrency.basic.communication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;
import static utils.PrintUtil.printnb;


public class WaxOMatic {

    private static class Car {
        private boolean condition_waxOn = false;

        public synchronized void waxed() {
            condition_waxOn = true;
            notifyAll();
        }

        public synchronized void buffed() {
            condition_waxOn = false;
            notifyAll();
        }

        public synchronized void waitForWaxing() throws InterruptedException {
            while (condition_waxOn == false) {
                wait();
            }
        }

        public synchronized void waitForBuffing() throws InterruptedException {
            while (condition_waxOn == true) {
                wait();
            }
        }
    }

    private static class WaxOn implements Runnable {
        private Car car;

        public WaxOn(Car c) {
            car = c;
        }

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    car.waitForBuffing();
                    printnb("Wax On! ");
                    TimeUnit.SECONDS.sleep(1);
                    car.waxed(); // notify buff to run
                }
            } catch (InterruptedException e) {
                println("Exiting via interrupt");
            }
            println("Ending Wax On task");
        }
    }

    private static class WaxOff implements Runnable {
        private Car car;

        public WaxOff(Car c) {
            car = c;
        }

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    car.waitForWaxing();
                    printnb("Wax Off! ");
                    TimeUnit.SECONDS.sleep(1);
                    car.buffed(); // notify wax to run
                }
            } catch (InterruptedException e) {
                println("Exiting via interrupt");
            }
            println("Ending Wax Off task");
        }
    }

    public static void main(String[] args) throws Exception {
        WaxOMatic.Car sameCar = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(sameCar));
        exec.execute(new WaxOn(sameCar));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow(); // Interrupt all tasks
    }
}