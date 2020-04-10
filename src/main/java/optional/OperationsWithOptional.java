package optional;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static utils.PrintUtil.println;

public class OperationsWithOptional {

    public static void main(String... args) {
        println(max(of(3), of(5)));
        println(max(empty(), of(5)));

        Optional<Integer> opt1 = of(5);
        Optional<Integer> opt2 = opt1.or(() -> of(4));

        println(of(5).or(() -> of(4)));
    }

    public static final Optional<Integer> max(Optional<Integer> i, Optional<Integer> j) {
        return i.flatMap(a -> j.map(b -> Math.max(a, b)));
    }

}
