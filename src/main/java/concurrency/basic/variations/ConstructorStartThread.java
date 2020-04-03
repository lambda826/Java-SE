package concurrency.basic.variations;

public class ConstructorStartThread extends Thread {

    private int countDown = 5;
    private static int threadCount = 0;

    public ConstructorStartThread() {
        super(Integer.toString(++threadCount)); // Store the thread name
        start(); // Start in the constructor
    }

    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new ConstructorStartThread();
        }
    }
}