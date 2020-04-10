package concurrency.basic.join;

import java.util.concurrent.TimeUnit;

import static utils.PrintUtil.println;

public class JoinDemo2 {

    private static class JoiningTask extends Thread {

        public JoiningTask() {
            start();
        }

        @Override
        public void run() {
            try {
                println("Joining task started");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                println("Joining task was interrupted. " + "isInterrupted(): " + isInterrupted());
                return;
            }
            println("Joining task completed");

        }
    }

    private static class MainTask extends Thread {
        private JoiningTask joiningTask;

        public MainTask(JoiningTask joiningTask) {
            this.joiningTask = joiningTask;
            start();
        }

        @Override
        public void run() {
            try {
                println("Main task started");
                // Wait for the task1 to complete before proceeding
                println("Wait for joining task to complete");
                joiningTask.join();
                println("Main task proceeds");
            } catch (InterruptedException e) {
                println("Main task interrupted. " + "isInterrupted(): " + isInterrupted());
                return;
            }
            println("Main task completed");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        JoiningTask joiningTask = new JoiningTask();
        MainTask mainTask = new MainTask(joiningTask);
        TimeUnit.SECONDS.sleep(5);
        joiningTask.interrupt(); // Once joining task is interrupted, main task proceed to execute immediately
        mainTask.interrupt(); // If main task is interrupted, joining task keeps running
    }
}