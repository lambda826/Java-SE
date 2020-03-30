package oop.inheritance;

import static common.utils.PrintUtil.println;

class Cleanser {

    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        println(x);
    }

}

public class _103_Detergent extends Cleanser {

    // Change a method:
    public void scrub() {
        append(" Detergent.scrub()");
        // Call base-class version
        super.scrub();
    }

    // Add methods to the interface:
    public void foam() {
        append(" foam()");
    }

    // Test the new class:
    public static void main(String[] args) {
        _103_Detergent x = new _103_Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        println(x);
        println("Testing base class:");
        Cleanser.main(args);
    }
}