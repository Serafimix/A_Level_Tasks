package ua.rakhmail.hw04;

import java.util.Arrays;
import java.util.Random;

public class Task02 {

    public static void main(String[] args) {
        int[] numbers = new int[1000];
        fillArray(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("Количество простых чисел в массиве: " + isSimple(numbers));
    }

    public static int isSimple(int[] number) {
        int count = 0;
        for (int j = 0; j < number.length; j++) {
            int n = number[j];
            boolean simple = true;
            int i;
            for (i = 2; i < n; i++) {
                if (n % i == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple){
                count++;
            }
        }
        return count;
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
//            array[i] = new Random().nextInt(Integer.MAX_VALUE) + 1;
            array[i] = new Random().nextInt(100000000) + 1; // если поставлю больше на нолик, то
                                                                  // расчеты на простоту чисел происходят долго.
//            array[i] = new Random().nextInt(100) + 1;
        }
    }

}
