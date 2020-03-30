package stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

import static common.utils.PrintUtil.println;


public class _14_ForkJoinSumCalculator extends RecursiveTask<Long> {

    public static final long THRESHOLD = 10_000;

    private final long[] numbers;
    private final int start;
    private final int end;

    public _14_ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private _14_ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
        final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();
        ForkJoinTask<Long> task = new _14_ForkJoinSumCalculator(numbers);
        println(FORK_JOIN_POOL.invoke(task));
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSumSequentially();
        }
        // left fork
        _14_ForkJoinSumCalculator leftTask = new _14_ForkJoinSumCalculator(numbers, start, start + length / 2);
        leftTask.fork();
        // right
        _14_ForkJoinSumCalculator rightTask = new _14_ForkJoinSumCalculator(numbers, start + length / 2, end);
        Long rightResult = rightTask.compute();
        // left join
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private long computeSumSequentially() {
        long sum = 0;
        for (int i = start; i < end; ++i) {
            sum += numbers[i];
        }
        return sum;
    }
}
