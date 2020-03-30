package generics.tuple;

public class Tuple4<A, B, C, D> extends Tuple3<A, B, C> {

    public final D fourth;

    public Tuple4(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ")";
    }
}