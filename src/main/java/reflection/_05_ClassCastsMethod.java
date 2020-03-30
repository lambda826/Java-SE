package reflection;

public class _05_ClassCastsMethod {

    static class Super {
    }

    static class Sub extends Super {
    }

    public static void main(String[] args) {
        Super sup = new Super();
        Sub sub = Sub.class.cast(sup); // down-casting, cast method
        Sub sub1 = (Sub) sup; // down-casting
        Sub sub2 = (Sub) sup; // down-casting, runtime error
    }
}