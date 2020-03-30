package generics;

import generics.generator.Generator;

public class _118_BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<_117_CountedObject> gen = _116_BasicGenerator.create(_117_CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
}