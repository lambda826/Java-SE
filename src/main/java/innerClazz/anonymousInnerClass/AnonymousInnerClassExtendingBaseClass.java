package innerClazz.anonymousInnerClass;

public class AnonymousInnerClassExtendingBaseClass {

    public static void main(String[] args) {
        AnonymousInnerClassExtendingBaseClass p = new AnonymousInnerClassExtendingBaseClass();
        Wrapping w = p.wrapping(10);
    }

    public Wrapping wrapping(int x) {

        // Base constructor call:
        return new Wrapping(x) { // Pass constructor argument.
            @Override
            public int value() {
                return super.value() * 47;
            }
        }; // Semicolon required
    }
}

class Wrapping {
    private int i;

    public Wrapping(int x) {
        i = x;
    }

    public int value() {
        return i;
    }
}
