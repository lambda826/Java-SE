package oop.polymorphism;

import static utils.PrintUtil.println;

class Meal {

    Meal() {
        println("Meal()");
    }

}

class Bread {

    Bread() {
        println("Bread()");
    }

}

class Cheese {

    Cheese() {
        println("Cheese()");
    }

}

class Lettuce {

    Lettuce() {
        println("Lettuce()");
    }

}

class Lunch extends Meal {

    Lunch() {
        println("Lunch()");
    }

}

class PortableLunch extends Lunch {

    PortableLunch() {
        println("PortableLunch()");
    }

}

public class _104_Sandwich extends PortableLunch {

    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    public _104_Sandwich() {
        println("Sandwich()");
    }

    public static void main(String[] args) {
        new _104_Sandwich();
    }

}