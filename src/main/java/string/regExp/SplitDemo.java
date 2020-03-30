package string.regExp;

import java.util.Arrays;
import java.util.regex.Pattern;

import static common.utils.PrintUtil.println;

public class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        println(Arrays.toString(Pattern.compile("!!").split(input)));
        // Only do the first three:
        println(Arrays.toString(Pattern.compile("!!").split(input, 3)));
    }
} /* Output:
  [This, unusual use, of exclamation, points]
  [This, unusual use, of exclamation!!points]
  *///:~
