package string.regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static common.utils.PrintUtil.println;
import static common.utils.PrintUtil.printnb;


public class _06_Finding {

    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings");
        while (m.find()) {
            printnb(m.group() + " ");
        }
        println();
        int i = 0;
        while (m.find(i)) {
            printnb(m.group() + " ");
            i++;
        }
    }

}