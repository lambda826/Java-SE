package concurrency;

// {RunByHand}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import static utils.PrintUtil.println;

class LiftOffRunner implements Runnable {
    private BlockingQueue<_01_LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<_01_LiftOff> queue) {
        rockets = queue;
    }

    public void add(_01_LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            println("Interrupted during put()");
        }
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                _01_LiftOff rocket = rockets.take();
                rocket.run(); // Use this thread
            }
        } catch (InterruptedException e) {
            println("Waking from take()");
        }
        println("Exiting LiftOffRunner");
    }
}

public class TestBlockingQueues {
    static void getkey() {
        try {
            // Compensate for Windows/Linux difference in the
            // length of the result produced by the Enter key:
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getkey(String message) {
        println(message);
        getkey();
    }

    static void test(String msg, BlockingQueue<_01_LiftOff> queue) {
        println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new _01_LiftOff(5));
        }
        getkey("Press 'Enter' (" + msg + ")");
        t.interrupt();
        println("Finished " + msg + " test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", // Unlimited size
             new LinkedBlockingQueue<_01_LiftOff>());
        test("ArrayBlockingQueue", // Fixed size
             new ArrayBlockingQueue<_01_LiftOff>(3));
        test("SynchronousQueue", // Size of 1
             new SynchronousQueue<_01_LiftOff>());
    }
} ///:~
