package stream;

import common.utils.PrintUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static common.utils.PrintUtil.newLine;
import static common.utils.PrintUtil.println;

public class _05_BuildingStreams {

    public static void main(String... args) {
        generateStream();
        streamsIterate();
        streamsGenerate();
    }

    public static void generateStream() {
        // Stream.of
        Stream.of("Java 8", "Lambdas", "In", "Action").map(String::toUpperCase).forEach(PrintUtil::println);

        // Stream.empty
        Stream<String> emptyStream = Stream.empty();

        // Arrays.stream
        Arrays.stream(new int[] { 2, 3, 5, 7, 11, 13 }).sum();

        // Files.lines
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        println("There are " + uniqueWords + " unique words in data.txt");
    }

    /**
     * Streams from functions (infinite stream)
     * static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
     * static <T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next), JDK 9
     */
    public static void streamsIterate() {
        Stream.iterate(0, n -> n + 2)
              .limit(10)
              .forEach(PrintUtil::println);

        // Fibonacci with iterate
        Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] })
              .limit(10)
              .forEach(t -> println("(" + t[0] + ", " + t[1] + ")"));

        Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] })
              .limit(10).map(t -> t[0])
              .forEach(PrintUtil::println);
    }

    /**
     * static <T> Stream<T> generate(Supplier<? extends T> s)
     */
    public static void streamsGenerate() {
        Stream.generate(Math::random).limit(10).forEach(PrintUtil::println);
        IntStream.generate(() -> 1).limit(5).forEach(n -> println(n + " "));
        newLine();

        IntStream.generate(new IntSupplier() {
            public int getAsInt() {
                return 2;
            }
        }).limit(5).forEach(n -> println(n + " "));
        newLine();

        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            public int getAsInt() {
                int nextValue = previous + current;
                previous = current;
                current = nextValue;
                return previous;
            }
        };
        IntStream.generate(fib).limit(10).forEach((n) -> println(n + " "));
    }

}
