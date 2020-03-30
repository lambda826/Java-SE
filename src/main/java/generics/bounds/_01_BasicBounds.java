package generics.bounds;

import generics.bounds.Common.Dimension;
import generics.bounds.Common.HasColorInterface;
import generics.bounds.Common.WeightInterface;

import java.awt.*;

public class _01_BasicBounds {

    static class Colored<T extends HasColorInterface> {
        T item;

        Colored(T item) {
            this.item = item;
        }

        T getItem() {
            return item;
        }

        // The bound allows you to call a method:
        Color color() {
            return item.getColor();
        }
    }

    // Multiple bounds: Class must come before interfaces
    static class ColoredDimension<T extends Dimension & HasColorInterface> {
        T item;

        ColoredDimension(T item) {
            this.item = item;
        }

        T getItem() {
            return item;
        }

        Color color() {
            return item.getColor();
        }

        int getX() {
            return item.x;
        }

        int getY() {
            return item.y;
        }

        int getZ() {
            return item.z;
        }
    }

    // As with inheritance, you can have only one concrete class but multiple interfaces:
    static class Solid<T extends Dimension & HasColorInterface & WeightInterface> {
        T item;

        Solid(T item) {
            this.item = item;
        }

        T getItem() {
            return item;
        }

        Color color() {
            return item.getColor();
        }

        int getX() {
            return item.x;
        }

        int getY() {
            return item.y;
        }

        int getZ() {
            return item.z;
        }

        int weight() {
            return item.weight();
        }
    }

    static class Bounded extends Dimension implements HasColorInterface, WeightInterface {
        public Color getColor() {
            return null;
        }

        public int weight() {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}
