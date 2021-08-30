package ua.rakhmail.hw01;

import java.util.Scanner;

/*
В данном примере число может быть любого размера.
Но проверку на вводимые данные не проходит. Переписать.
 */

public class Task01c {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String number = scanner.nextLine();
            String reversNumber = "";
            char[] reversNumberChar = number.toCharArray();
            for (int y = reversNumberChar.length - 1, i = 0; y >= 0; y--, i++) {
                reversNumber = reversNumber + reversNumberChar[y];
            }
            System.out.println(reversNumber);
        }
    }
}
