package generics.OTHERS;

// Autoboxing compensates for the inability to use
// primitives in generics.

public class ListOfInt {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            li.add(i);
        }
        for (int i : li) {
            System.out.println(i + " ");
        }
    }
} /* Output:
  0 1 2 3 4
  *///:~
