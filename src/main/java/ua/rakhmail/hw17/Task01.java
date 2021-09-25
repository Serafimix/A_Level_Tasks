package ua.rakhmail.hw17;

import java.util.Arrays;

public class Task01 {

    public static void printSortArray(String[] strings) {
        Arrays.stream(strings)
                .sorted()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        String[] strings = {"Баоря", "Baomon", "Аалан", "Боря", "Bomon", "Amon", "Abmon", "Ассан"};
        printSortArray(strings);
    }
}
