package ua.rakhmail.hw05;

import java.util.Arrays;
import java.util.Random;

public class Task04a {
    public static void main(String[] args) {
        int K = 5;
        int[] numbers = new int[10];
        fill(numbers);
        System.out.println("Выводим массив: " + Arrays.toString(numbers));

        // Как я понял, нужно удалить сам индекс с массива,
        // а не заменить его на 0 и передвинуть его в конец массива ( ведь 0 это тоже значение)

        System.out.println("Удаляем индекс \"К\" из массива: " + Arrays.toString(deleteElements(numbers, K)));
        System.out.println("Изначальный массив не пострадал: " + Arrays.toString(numbers));
    }

    public static int[] fill(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10) + 1;
        }
        return array;
    }

    public static int[] deleteElements(int[] array, int element) {
        if (array!=null || array.length != 0 || element < array.length) {
            int[] copyOfArray = Arrays.copyOf(array, array.length);
                for (int i = element; i < copyOfArray.length - 1; i++) {
                    copyOfArray[i] = array[i + 1];
                }
            return Arrays.copyOf(copyOfArray, copyOfArray.length-1);
        }
        return array;
    }
}
