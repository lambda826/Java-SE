package generics.genericArray;

public class GenericArray<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        // The only way to successfully create an array of a generic type is to create a new array of the erased type, and cast that
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Method that exposes the underlying representation:
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);

        // This causes a ClassCastException:
        //! Integer[] ia = gai.rep();

        // This is OK:
        Object[] oa = gai.rep();
    }
}