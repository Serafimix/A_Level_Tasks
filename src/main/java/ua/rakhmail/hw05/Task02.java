package ua.rakhmail.hw05;

import java.util.Arrays;

public class Task02 {
    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numbers2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Вывод массива numbers1 на экран:" + System.lineSeparator() + Arrays.toString(numbers1));
        System.out.println("Массив numbers1 отсортированый по убыванию? - " + isBiggerThenPast(numbers1));
        System.out.println("Вывод массива numbers2 на экран:" + System.lineSeparator() + Arrays.toString(numbers2));
        System.out.println("Массив numbers2 отсортированый по убыванию? - " + isBiggerThenPast(numbers2));
    }

    public static boolean isBiggerThenPast(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return true;
            }
        }
        return false;
    }

}
