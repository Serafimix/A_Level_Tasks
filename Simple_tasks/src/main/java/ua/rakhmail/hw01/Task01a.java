package ua.rakhmail.hw01;

import java.util.Scanner;


public class Task01a {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String str = String.valueOf(x);
        int[] number = new int[str.length()];
        for (int y = number.length - 1, i = 0; y >= 0; y--, i++) {
            number[y] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        for (int i : number) {
            System.out.print(i);
        }
    }
}


