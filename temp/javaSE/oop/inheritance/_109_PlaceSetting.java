package oop.inheritance;

import static common.utils.PrintUtil.println;

class Plate {
    Plate(int i) {
        println("Plate constructor");
    }
}

class DinnerPlate extends Plate {
    DinnerPlate(int i) {
        super(i);
        println("DinnerPlate constructor");
    }
}

class Utensil {
    Utensil(int i) {
        println("Utensil constructor");
    }
}

class Spoon extends Utensil {
    Spoon(int i) {
        super(i);
        println("Spoon constructor");
    }
}

class Fork extends Utensil {
    Fork(int i) {
        super(i);
        println("Fork constructor");
    }
}

class Knife extends Utensil {
    Knife(int i) {
        super(i);
        println("Knife constructor");
    }
}

// A cultural way of doing something:
class Custom {
    Custom(int i) {
        println("Custom constructor");
    }
}

public class _109_PlaceSetting extends Custom {

    private Spoon sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate pl;

    public _109_PlaceSetting(int i) {
        super(i + 1);
        sp = new Spoon(i + 2);
        frk = new Fork(i + 3);
        kn = new Knife(i + 4);
        pl = new DinnerPlate(i + 5);
        println("PlaceSetting constructor");
    }

    public static void main(String[] args) {
        _109_PlaceSetting x = new _109_PlaceSetting(9);
    }
}