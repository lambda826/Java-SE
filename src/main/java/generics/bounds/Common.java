package generics.bounds;

import java.awt.*;

public class Common {

    interface HasColorInterface {
        Color getColor();
    }

    interface WeightInterface {
        int weight();
    }

    static class Dimension {
        public int x, y, z;
    }

}
