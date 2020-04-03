//: concurrency/waxomatic/WaxOMatic.java
// Basic task cooperation.
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;

Util.println;Util.printnb;


public class _48_WaxOMatic {

    static class Car {
        private boolean waxOn = false;

        public synchronized void waxed() {
            waxOn = true; // Ready to buff
            notifyAll();
        }

        public synchronized void buffed() {
            waxOn = false; // Ready for another coat of wax
            notifyAll();
        }

        public synchronized void waitForWaxing() throws InterruptedException {
            while (waxOn == false) {
                wait();
            }
        }

        public synchronized void waitForBuffing() throws InterruptedException {
            while (waxOn == true) {
                wait();
            }
        }
    }

    static class WaxOn implements Runnable {
        private Car car;

        public WaxOn(Car c) {
            car = c;
        }

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    printnb("Wax On! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.waxed();
                    car.waitForBuffing();
                }
            } catch (InterruptedException e) {
                println("Exiting via interrupt");
            }
            println("Ending Wax On task");
        }
    }

    static class WaxOff implements Runnable {
        private Car car;

        public WaxOff(Car c) {
            car = c;
        }

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    car.waitForWaxing();
                    printnb("Wax Off! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.buffed();
                }
            } catch (InterruptedException e) {
                println("Exiting via interrupt");
            }
            println("Ending Wax Off task");
        }
    }

    public static void main(String[] args) throws Exception {
        _48_WaxOMatic.Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }
}