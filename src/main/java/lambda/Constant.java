package lambda;

import common.pojos.Color;
import common.pojos.fruit.Apple;

import java.util.Arrays;
import java.util.List;

public class Constant {
    public static final List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN), new Apple(155, Color.GREEN), new Apple(120, Color.RED));
    public static final String path = "/src/lambda/Note.txt";
}
