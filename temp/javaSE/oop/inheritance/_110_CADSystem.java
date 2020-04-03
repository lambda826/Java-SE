package oop.inheritance;

import static utils.PrintUtil.println;

/*

Note that in your cleanup method, you must also pay attention to the calling order for the base-class and member-object cleanup methods in case one subobject depends on another
First perform all of the cleanup work specific to your class, in the reverse order of creation.
Then call the base-class cleanup method, as demonstrated here.

*/

class Shape {

    Shape(int i) {
        println("Shape constructor");
    }

    void dispose() {
        println("Shape dispose");
    }
}

class Circle extends Shape {

    Circle(int i) {
        super(i);
        println("Drawing Circle");
    }

    void dispose() {
        println("Erasing Circle");
        super.dispose();
    }

}

class Triangle extends Shape {

    Triangle(int i) {
        super(i);
        println("Drawing Triangle");
    }

    void dispose() {
        println("Erasing Triangle");
        super.dispose();
    }

}

class Line extends Shape {

    private int start;
    private int end;

    Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        println("Drawing Line: " + start + ", " + end);
    }

    void dispose() {
        println("Erasing Line: " + start + ", " + end);
        super.dispose();
    }
}

public class _110_CADSystem extends Shape {

    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];

    public _110_CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j++) {
            lines[j] = new Line(j, j * j);
        }
        c = new Circle(1);
        t = new Triangle(1);
        println("Combined constructor");
    }

    public void dispose() {
        println("CADSystem.dispose()");
        // The order of cleanup is the reverse of the order of initialization:
        t.dispose();
        c.dispose();
        for (int i = lines.length - 1; i >= 0; i--) {
            lines[i].dispose();
        }
        super.dispose();
    }

    public static void main(String[] args) {
        _110_CADSystem x = new _110_CADSystem(47);
        try {
            // Code and exception handling...
        } finally {
            x.dispose();
        }
    }
}