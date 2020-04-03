package generics.bounds.wildcards;

import static utils.PrintUtil.println;

public class _01_CovariantArrays {

    static class Fruit {
    }

    static class Apple extends Fruit {
    }

    static class Jonathan extends Apple {
    }

    static class Orange extends Fruit {
    }

    public static void main(String[] args) {
        // If the actual array type is Apple [], you should only be able to place an Apple or a subtype of Apple into the array
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try {
            // Compiler allows you to add Fruit:
            // ArrayStoreException
            fruit[0] = new Fruit();
        } catch (Exception e) {
            println("1: " + e);
        }
        try {
            // Compiler allows you to add Oranges:
            // ArrayStoreException
            fruit[0] = new Orange();
        } catch (Exception e) {
            System.out.println("2: " + e);
        }
        try {
            // Compiler allows you to add Oranges:
            fruit[0] = new Jonathan();
        } catch (Exception e) {
            println("3: " + e);
        }
    }
}