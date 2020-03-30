package generics.tuple;

public class Tuple5<A, B, C, D, E> extends Tuple4<A, B, C, D> {

    public final E fifth;

    public Tuple5(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        fifth = e;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + ")";
    }
}
