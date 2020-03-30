package generics.bounds.wildcards;

public class CaptureConversion {
    static <T> void f1(_05_Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(_05_Holder<?> holder) {
        f1(holder); // Call with captured type
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        _05_Holder raw = new _05_Holder<Integer>(1);
        // f1(raw); // Produces warnings
        f2(raw); // No warnings
        _05_Holder rawBasic = new _05_Holder();
        rawBasic.set(new Object()); // Warning
        f2(rawBasic); // No warnings
        // Upcast to Holder<?>, still figures it out:
        _05_Holder<?> wildcarded = new _05_Holder<Double>(1.0);
        f2(wildcarded);
    }
} /* Output:
  Integer
  Object
  Double
  *///:~
