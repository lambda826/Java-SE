package containers;

import utils.TextFile;

import java.util.Set;
import java.util.TreeSet;

public class _119_UniqueWords {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(new TextFile("SetOperations.java", "\\W+"));
        System.out.println(words);
    }
}