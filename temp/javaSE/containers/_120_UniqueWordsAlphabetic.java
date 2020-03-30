package containers;

import utils.TextFile;

import java.util.Set;
import java.util.TreeSet;

public class _120_UniqueWordsAlphabetic {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        words.addAll(new TextFile("SetOperations.java", "\\W+"));
        System.out.println(words);
    }
}