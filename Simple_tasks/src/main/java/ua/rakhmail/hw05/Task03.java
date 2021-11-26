package ua.rakhmail.hw05;

import java.util.Random;

public class Task03 {
    public static void main(String[] args) {
        int[][] numbers = new int[10][10];
        System.out.println("Выводим массив на экран");
        fill(numbers);
        myDeepToString(numbers);
        System.out.println("Меняем местами значения в строках на значения в рядках и сразу выводим на экран");
        myDeepToString(arraySwap(numbers));
        System.out.println("Изначальный массив не изменился");
        myDeepToString(numbers);
    }

    public static int[][] arraySwap(int[][] array) {
        int[][] newArray = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                newArray[j][i] = array[i][j];
            }
        }
        return newArray;
    }

    public static int[][] fill(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Random().nextInt(99) + 1;
            }
        }
        return array;
    }

    public static void myDeepToString(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
