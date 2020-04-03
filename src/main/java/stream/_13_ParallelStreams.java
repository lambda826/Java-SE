package stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static utils.PrintUtil.println;

public class _13_ParallelStreams {

    public static void main(String[] args) {
        println("Iterative Sum done in: " + measurePerf(_13_ParallelStreams::iterativeSum, 10_000_000L) + " msecs");
        println("Sequential Sum done in: " + measurePerf(_13_ParallelStreams::sequentialSum, 10_000_000L) + " msecs");
        println("Parallel forkJoinSum done in: " + measurePerf(_13_ParallelStreams::parallelSum, 10_000_000L) + " msecs");
        println("Range forkJoinSum done in: " + measurePerf(_13_ParallelStreams::rangedSum, 10_000_000L) + " msecs");
        println("Parallel range forkJoinSum done in: " + measurePerf(_13_ParallelStreams::parallelRangedSum, 10_000_000L) + " msecs");
        println("ForkJoin sum done in: " + measurePerf(_13_ParallelStreams::forkJoinSum, 10_000_000L) + " msecs");
        println("SideEffect sum done in: " + measurePerf(_13_ParallelStreams::sideEffectSum, 10_000_000L) + " msecs");
        println("SideEffect parallel sum done in: " + measurePerf(_13_ParallelStreams::sideEffectParallelSum, 10_000_000L) + " msecs");
    }

    public static <T, R> long measurePerf(Function<T, R> f, T input) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            R result = f.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            println("Result: " + result);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

    // 3 msecs
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    // 108 msecs
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(Long::sum).get();
    }

    // 302 msecs
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(Long::sum).get();
    }

    // 8 msecs
    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n) {
        // 1 msecs
        return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).getAsLong();
    }

    // 53 msecs
    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new _14_ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    // 17 msecs
    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    // 32 msecs
    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        private long total = 0;

        public void add(long value) {
            total += value;
        }
    }
}
