package string.regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utils.PrintUtil.println;

// {Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }

public class _05_TestRegularExpression {

    public static void main(String[] args) {
        if (args.length < 2) {
            println("Usage:\njava TestRegularExpression " + "characterSequence regularExpression+");
            System.exit(0);
        }
        println("Input: \"" + args[0] + "\"");
        for (String arg : args) {
            println("Regular expression: \"" + arg + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            while (m.find()) {
                println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
            }
        }
    }

}