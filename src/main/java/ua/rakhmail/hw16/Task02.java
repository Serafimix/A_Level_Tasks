package ua.rakhmail.hw16;

import java.util.Map;
import java.util.TreeMap;

public class Task02 {
    static Map<String, Integer> vocabulary = new TreeMap<String, Integer>();

    public static void putInVocabulary(String line){
        vocabulary.put(line, vocabulary.containsKey(line) ? vocabulary.get(line) + 1 : 1);
    }

    public static void main(String[] args) {
        putInVocabulary("Mom");
        System.out.println(vocabulary.get("Mom"));
        putInVocabulary("Mom");
        System.out.println(vocabulary.get("Mom"));
    }
}
