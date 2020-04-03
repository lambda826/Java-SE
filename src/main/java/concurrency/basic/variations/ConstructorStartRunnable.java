package concurrency.basic.variations;

import static utils.PrintUtil.println;

public class ConstructorStartRunnable implements Runnable {

    private int countDown = 5;
    private Thread t = new Thread(this);

    public ConstructorStartRunnable() {
        t.start();
    }

    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + "), ";
    }

    @Override
    public void run() {
        while (true) {
            println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new ConstructorStartRunnable();
        }
    }
} 