package string.regExp;


import static common.utils.PrintUtil.println;

public class _03_Replacing {

    static String s = _02_Splitting.knights;

    public static void main(String[] args) {
        println(s);
        println(s.replaceFirst("f\\w+", "located"));
        println(s);
        println(s.replaceAll("shrubbery|tree|herring", "banana"));
    }

}