package generics.tuple;

public class Tuple2<A, B> {

    // The final declaration buys you the same safety
    public final A first;
    public final B second;

    public Tuple2(A a, B b) {
        first = a;
        second = b;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
