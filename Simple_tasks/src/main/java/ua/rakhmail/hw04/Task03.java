package ua.rakhmail.hw04;

import java.util.Arrays;
import java.util.Random;

public class Task03 {

    public static void main(String[] args) {
        int[] numbers = new int[1000];
        fillArray(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("Количество составных чисел в массиве: "+ counterOfComposite(numbers));
    }

    public static int counterOfComposite(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (isComposite(array[i])) {
                count++;
            }
        }
        return count;
    }

    public static boolean isComposite(int number) {
        int n = number;
        boolean composite = false;
        int i;
        for (i = 2; i < n; i++) {
            if (n % i == 0) {
                composite = true;
                break;
            }
        }
        return composite;
    }


    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100000000) + 1;
        }
    }
}