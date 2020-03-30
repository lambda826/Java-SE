package generics.tuple;

public class Tuple3<A, B, C> extends Tuple2<A, B> {

    public final C third;

    public Tuple3(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }
}
