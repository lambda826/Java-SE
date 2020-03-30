package oop.polymorphism;

import static common.utils.PrintUtil.println;

class Glyph {
    void draw() {
        println("Glyph.draw()");
    }

    Glyph() {
        println("Glyph() before draw()");
        draw();
        println("Glyph() after draw()");
    }
}

/*
1. The storage allocated for the object is initialized to binary zero before anything else happens.
2. The base-class constructors are called as described previously. At this point, the overridden draw( ) method is called (yes, before the RoundGlyph constructor is called), which discovers a radius value of zero, due to Step 1.
3. Member initializers are called in the order of declaration.
4. The body of the derived-class constructor is called.
*/
class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        println("RoundGlyph.draw(), radius = " + radius);
    }
}

public class _107_PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}