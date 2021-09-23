package ua.rakhmail.hw16;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Task02 {
    static SortedMap<String, Integer> vocabulary = new TreeMap<>();

    public static void putInVocabulary(String line) {
        if (line != null) {
//            Pattern.compile("^[a-zA-Zа-яА-Я]", line).asPredicate(); (спросить)
//            vocabulary.put(line, vocabulary.containsKey(line) ? vocabulary.get(line) + 1 : 1); (старый метод)
            vocabulary.merge(line, 1, Integer::sum); // (аналогичный метод, но короче)
        }
    }

    public static void printMap(Map<String, Integer> map) {
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
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
        putInVocabulary("Daughter");
        printMap(vocabulary);
    }
}
