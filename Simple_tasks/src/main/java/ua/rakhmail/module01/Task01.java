package ua.rakhmail.module01;

import java.util.Arrays;
import java.util.Random;

public class Task01 {

    public static void main(String[] args) {
        Integer[] numbers = new Integer[20];
        fillArray(numbers);
        System.out.println("В массиве: " + Arrays.toString(numbers));
        System.out.println(counterUnique(numbers) + " уникальных чисел.");
    }

    public static void fillArray(Integer[] array) {
        if (array.length > 0) {
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(10) + 1;
            }
        }
    }
    public static int counterUnique(Integer[] array) {
        int count = 0;
        if (array.length > 0) {
            Integer[] copyOfArray = Arrays.copyOf(array, array.length);
            for (int i = 0; i < array.length - 1; i++) {
                if (copyOfArray[i] != null) {
                    count++;
                    for (int j = i; j < array.length - 1; j++) {
                        if (copyOfArray[j + 1] != null) {
                            if (copyOfArray[i].equals(copyOfArray[j + 1])) {
                                copyOfArray[j + 1] = null;
                            }
                        }
                    }
                }
            }
//            System.out.println(Arrays.toString(copyOfArray));
            if (copyOfArray[array.length - 1] != null)
                count++;
        }
        return count;
    }
}
