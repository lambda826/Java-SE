package clazz;

import static common.utils.PrintUtil.println;

public class _101_Flower {
    int petalCount = 0;
    String s = "initial value";

    _101_Flower(int petals) {
        petalCount = petals;
        println("Constructor w/ int arg only, petalCount= " + petalCount);
    }

    _101_Flower(String ss) {
        println("Constructor w/ String arg only, s = " + ss);
        s = ss;
    }

    _101_Flower(String s, int petals) {
        this(petals);
        // Can't call two!
        //!    this(s); 
        // Another use of "this"
        this.s = s;
        println("String & int args");
    }

    _101_Flower() {
        this("hi", 47);
        println("default constructor (no args)");
    }

    void printPetalCount() {
        // Not inside non-constructor!
        //! this(11); 
        println("petalCount = " + petalCount + " s = " + s);
    }

    public static void main(String[] args) {
        _101_Flower x = new _101_Flower();
        x.printPetalCount();
    }
}