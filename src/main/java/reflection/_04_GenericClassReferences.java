package reflection;

import java.util.ArrayList;
import java.util.List;

import static utils.PrintUtil.println;

public class _04_GenericClassReferences<T> {
    static class CountedInteger {
        private static long counter;
        private final long id = counter++;

        public String toString() {
            return Long.toString(id);
        }

        public CountedInteger() {} // Notice that this class must assume that any type that it works with has a default constructor

        public CountedInteger(int i) {}
    }

    private Class<T> type;

    public _04_GenericClassReferences(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int n) {
        List<T> result = new ArrayList<>();
        try {
            for (int i = 0; i < n; i++) {
                result.add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        _04_GenericClassReferences<CountedInteger> fl = new _04_GenericClassReferences<>(CountedInteger.class);
        println(fl.create(15));
    }
}