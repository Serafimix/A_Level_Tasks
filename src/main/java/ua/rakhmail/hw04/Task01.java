package ua.rakhmail.hw04;

import java.util.Arrays;
import java.util.Random;

public class Task01 {

    public static void main(String[] args) {
        int[] numbers = new int[400];
        fillArray(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("Среднеарифметическое массива = " + midArifmetik(numbers));
        System.out.println("Среднегеометрическое массива = " + midGeometrik(numbers));
    }


    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10) + 1;
        }
    }

    public static double midArifmetik(int[] array) {
        double mid = 0.0;
        for (int i = 0; i < array.length; i++) {
            mid += array[i];
        }
        return mid / array.length;
    }

    public static double midGeometrik(int[] array) {
        double mid = 1.0, nextMid;
        for (int i = 0; i < array.length; i++) {
            nextMid = array[i];
            mid *= nextMid;
        }
        return Math.pow(mid, 1.0 / array.length);
    }
}
