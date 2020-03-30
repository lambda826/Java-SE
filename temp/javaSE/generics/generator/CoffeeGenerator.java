package generics.generator;

import generics.generator.coffee.Americano;
import generics.generator.coffee.Breve;
import generics.generator.coffee.Cappuccino;
import generics.generator.coffee.Coffee;
import generics.generator.coffee.Latte;
import generics.generator.coffee.Mocha;

import java.util.Iterator;
import java.util.Random;

import static common.utils.PrintUtil.println;


/**
 * The parameterized Generator interface ensures that next() returns the parameter type
 * CoffeeGenerator also implements the Iterable interface, so it can be used in a foreach statement
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class[] types = { Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class, };
    private static Random rand = new Random(47);

    // For iteration:
    private int size = 0;

    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee> {

        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Coffee next() {
            --count;
            return CoffeeGenerator.this.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; ++i) {
            println(gen.next());
        }
        for (Coffee c : new CoffeeGenerator(5)) {
            println(c);
        }
    }
}