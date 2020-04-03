package concurrency.basic;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static utils.PrintUtil.println;

public class Implement_Callable {

    @AllArgsConstructor
    private static class TaskWithResult implements Callable<String> {

        private int id;

        @Override
        public String call() {
            println("id            " + id);
            return "result of TaskWithResult " + id;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> future : results) {
            try {
                println(future.get());
            } catch (InterruptedException e) {
                println(e);
                return;
            } catch (ExecutionException e) {
                println(e);
            } finally {
                exec.shutdown();
            }
        }
    }
}