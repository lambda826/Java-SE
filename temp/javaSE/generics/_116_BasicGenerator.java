package generics;

import generics.generator.Generator;

public class _116_BasicGenerator<T> implements Generator<T> {

    private Class<T> type;

    public _116_BasicGenerator(Class<T> type) {
        this.type = type;
    }

    public T next() {
        try {
            // Assumes type is a public class:
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Produce a Default generator given a type token:
    public static <T> Generator<T> create(Class<T> type) {
        return new _116_BasicGenerator<T>(type);
    }
}
