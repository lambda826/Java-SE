package generics.generator;

public interface Generator<T> {

    // Typically, a generator just defines one method, the method that produces new objects
    T next();
}