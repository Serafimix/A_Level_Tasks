package ua.rakhmail.hw07.task03;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Vector[] vectors = Vector.vectorRandomArray(5);
        System.out.println(Arrays.deepToString(vectors));
        System.out.println("Длинна 1го вектора массива = " + vectors[0].vectorLength());
        System.out.println("Векторное произведение 2 и 3-го вектора массива = " + vectors[1].vectorVecPro(vectors[2]));
        System.out.println("Скалярное произведение 4-го и 5-го вектора массива = " +
                vectors[3].vectorScalarPro(vectors[4]));
        System.out.println("Косинус угла между векторами 4 и 5 = " + vectors[3].vectorCos(vectors[4]) + " радиан.");
        System.out.println("Сумма 1-го и 2-го вектора массива = " + vectors[0].vectorSum(vectors[1]));
        System.out.println("Разность 1-го и 2-го вектора массива = " + vectors[0].vectorSubtraction(vectors[1]));
    }
}
