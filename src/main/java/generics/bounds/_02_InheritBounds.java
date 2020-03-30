package generics.bounds;

import generics.bounds.Common.Dimension;
import generics.bounds.Common.HasColorInterface;
import generics.bounds.Common.WeightInterface;
import generics.bounds._01_BasicBounds.Bounded;

import java.awt.*;

public class _02_InheritBounds {

    static class HoldItem<T> {
        T item;

        HoldItem(T item) {
            this.item = item;
        }

        T getItem() {
            return item;
        }
    }

    static class Colored<T extends HasColorInterface> extends HoldItem<T> {
        Colored(T item) {
            super(item);
        }

        Color color() {
            return item.getColor();
        }
    }

    static class ColoredDimension<T extends Dimension & HasColorInterface> extends Colored<T> {
        ColoredDimension(T item) {
            super(item);
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

    static class Solid<T extends Dimension & HasColorInterface & WeightInterface> extends ColoredDimension<T> {
        Solid(T item) {
            super(item);
        }

        int weight() {
            return item.weight();
        }
    }

    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}
