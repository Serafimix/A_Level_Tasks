package ua.rakhmail.hw05;

public class Task01 {
    public static void main(String[] args) {
        int[][] multiPiton = new int[20][20];
        fillMultiArray(multiPiton); // Заполняем массив в соответствии с условием
        myDeepToString(multiPiton); // Выводим многомерный массив по красоте
    }

    public static int[][] fillMultiArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i % 2 == 0 ? j : -j;
            }
        }
        return array;
    }

    // хочу переопределить метод deepToString для лучшей наглядности.

    public static void myDeepToString(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i % 2 == 0)
                    System.out.print(array[i][j] + ",  ");
                else System.out.print(array[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
