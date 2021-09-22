package ua.rakhmail.hw16;

import java.util.*;

public class Task02 {
    static SortedMap<String, Integer> vocabulary = new TreeMap<>();

    public static void putInVocabulary(String line) {
        if (line != null) {
            vocabulary.put(line, vocabulary.containsKey(line) ? vocabulary.get(line) + 1 : 1);
        }
    }

    public static void printMap(Map<String, Integer> map) {
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        putInVocabulary("Mom");
        putInVocabulary("Mom");
        putInVocabulary("Mom");
        putInVocabulary("Mom");
        putInVocabulary("Mom");
        putInVocabulary("Dad");
        putInVocabulary("Dad");
        putInVocabulary("Dad");
        putInVocabulary("Son");
        putInVocabulary("Son");
        putInVocabulary("Son");
        putInVocabulary("Son");
        putInVocabulary("Son");
        putInVocabulary("Son");
        printMap(vocabulary);
    }
}
