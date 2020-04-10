package concurrency.basic.communication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;
import static utils.PrintUtil.printnb;


public class Restaurant {

    private static class Meal {
        private final int orderNum;

        public Meal(int orderNum) {
            this.orderNum = orderNum;
        }

        public String toString() {
            return "Meal " + orderNum;
        }
    }

    private static class WaitPerson implements Runnable {
        private Restaurant restaurant; // Shared resource

        public WaitPerson(Restaurant r) {
            restaurant = r;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (this) {
                        while (restaurant.meal == null) {
                            wait(); // ... for the chef to produce a meal
                        }
                    }
                    println("Waitperson got " + restaurant.meal);
                    synchronized (restaurant.chef) {
                        restaurant.meal = null;
                        restaurant.chef.notifyAll(); // Ready for another
                    }
                }
            } catch (InterruptedException e) {
                println("WaitPerson interrupted");
            }
        }
    }

    private static class Chef implements Runnable {
        private Restaurant restaurant; // Shared resource
        private int count = 0;

        public Chef(Restaurant r) {
            restaurant = r;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (this) {
                        while (restaurant.meal != null) {
                            wait();
                        }
                    }
                    if (++count == 10) {
                        println("Out of food, closing");
                        restaurant.exec.shutdownNow();
                    }
                    printnb("Order up! ");
                    synchronized (restaurant.waitPerson) {
                        restaurant.meal = new Meal(count);
                        restaurant.waitPerson.notifyAll();
                    }
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e) {
                println("Chef interrupted");
            }
        }
    }

    private Meal meal;
    private ExecutorService exec = Executors.newCachedThreadPool();
    private WaitPerson waitPerson = new WaitPerson(this);
    private Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}