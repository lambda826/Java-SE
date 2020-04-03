package concurrency.basic;

import static utils.PrintUtil.print;
import static utils.PrintUtil.println;

/**
 * 1. Implement Runnable
 * 2. Hand it to Thread constructor
 * 3. Start thread
 */
public class Implement_Runnable implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public Implement_Runnable() {}

    public Implement_Runnable(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Done!") + "), ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            print(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Implement_Runnable()).start();
        }
        println("Last line in main");
    }
}
