package ua.rakhmail.hw16;

import java.util.*;

public class Task02 {
    static SortedMap<String, Integer> vocabulary = new TreeMap<>();

    public static void putInVocabulary(String line) {
        if (line != null) {
//          vocabulary.put(line, vocabulary.containsKey(line) ? vocabulary.get(line) + 1 : 1); (старый метод)
            vocabulary.merge(line.toLowerCase(Locale.ROOT), 1, Integer::sum); // (аналогичный метод, но короче)
        }
    }

    public static void printMap(Map<String, Integer> map) {
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }

    public static void putTextIntoVocabulary(String text) {
        Arrays.stream(text
                .replaceAll("[1234567890']", "")
                .replaceAll("[^a-zA-Zа-яА-ЯёЁ]+", " ")
                .split(" ")).forEach(Task02::putInVocabulary);
    }

    public static void main(String[] args) {
        putTextIntoVocabulary("Мама125, Ма124ма, мама124, Мам'а, Папа, папа~!, папа&?, П1а2п3а! папа, Папа");
        printMap(vocabulary);
//        putTextIntoVocabulary("Феанор велел остановиться, раны его были смертельны и он знал," +
//                " что час его близок. И бросив последние взгяды со склона Фарад-Витрина он узрез" +
//                " вдали пики Тангородрима1 — мощнейшей из твердынь Средиземья… " +
//                "И осознал в прозрении Смерти что никогда не достанет у Нолдоров" +
//                " силы сокрушить их, но трижды проклял он имя Моргота и оставил" +
//                " сыновьям завет хранить клятву и отомстить за отца. Затем он умер ," +
//                " но нет у него ни могилы , ни гробницы , ибо столь пламенным был его дух," +
//                " что едва он отлетел тело Феанора стало золой — и развеялось, как дым." +
//                " Подобных ему никогда больше не появлялось в Арде, а дух его не покидал чертогов Мандоса." +
//                " Так закончил жизнь величайший из Нолдоров," +
//                " чьи дела принесли им величайшую славу и гибельнейшую беду...");
//        printMap(vocabulary);
    }
}
