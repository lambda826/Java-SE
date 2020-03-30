package generics.erasure;


public class ErasureAndInheritance {
    static class GenericBase<T> {
        private T element;

        public void set(T arg) {
            arg = element;
        }

        public T get() {
            return element;
        }
    }

    static class Derived1<T> extends GenericBase<T> {
    }

    static class Derived2 extends GenericBase {
    }

    // class Derived3 extends GenericBase<?> {}
    // Strange error:
    //   unexpected type found : ?
    //   required: class or interface without bounds


    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);
    }
}
