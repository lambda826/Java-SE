package concurrency.basic;

import static utils.PrintUtil.println;

public class JoinDemo2 {

    private static class Sleeper extends Thread {
        private int duration;

        public Sleeper(String name, int sleepTime) {
            super(name);
            duration = sleepTime;
            start();
        }

        @Override
        public void run() {
            try {
                sleep(duration);
            } catch (InterruptedException e) {
                println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
                return;
            }
            println(getName() + " has awakened");
        }
    }

    private static class Joiner extends Thread {
        private Sleeper sleeper;

        public Joiner(String name, Sleeper sleeper) {
            super(name);
            this.sleeper = sleeper;
            start();
        }

        @Override
        public void run() {
            try {
                // Wait for the sleeper to complete before proceeding
                sleeper.join();
            } catch (InterruptedException e) {
                println("Interrupted");
            }
            println(getName() + " join completed");
        }
    }


    public static void main(String[] args) {
        Sleeper sleeper1 = new Sleeper("sleeper1", 1500);
        Joiner joiner1 = new Joiner("joiner1", sleeper1);
        sleeper1.interrupt();

        Sleeper sleeper2 = new Sleeper("sleeper2", 2500);
        Joiner joiner2 = new Joiner("joiner2", sleeper2);

    }
}