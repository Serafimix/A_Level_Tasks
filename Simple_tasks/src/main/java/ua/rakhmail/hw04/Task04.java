package ua.rakhmail.hw04;

import java.util.Arrays;
import java.util.Random;

public class Task04 {

    public static void main(String[] args) {
        int[] numbers = new int[2000];
        fillsArray(numbers);
        System.out.println("Заполненный массив" + System.lineSeparator() + Arrays.toString(numbers));
        int[] copyOfNumbers = copyOfArray(numbers);
        zeroGetAway(copyOfNumbers);
        System.out.println("Долой четные числа" + System.lineSeparator() + Arrays.toString(copyOfNumbers));
        System.out.println(Arrays.toString(numbers)); // изначальный массив не изменился.


    }

    public static void zeroGetAway(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = 0;
            }
        }
    }

    private static void fillsArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt();
        }
    }

    public static int[] copyOfArray(int[] array) {
        return Arrays.stream(array).toArray();
    }

}
