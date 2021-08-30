package ua.rakhmail.hw03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        System.out.println("Угадай число от 1 до 100(включительно).");
        letsGame();
    }

    public static void letsGame() {
        Random random = new Random();
        int secret = random.nextInt(100) + 1; // рандом дает случайное число с 0, меня устраивает с 1.
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Итак, введи свою догадку...");
            int count = 1; // счетчик попыток отгадок.
            while (true) {
                if (scanner.hasNextInt()) {
                    int guess  = scanner.nextInt();
                    if (guess  < secret) {
                        System.out.println("Твое число меньше загаданного... Ещё вариант.");
                        count++;
                    } else if (guess  > secret) {
                        System.out.println("Твое число больше загаданного... Ещё вариант.");
                        count++;
                    } else {
                        System.out.println("Молодец, ты угадал с " + count + " попытки.");
                        break;
                    }
                } else if (!scanner.hasNextInt()) {
                    System.out.println("Вводи только целые числа, пожалуйста, а не \"" + scanner.nextLine() + "\"");
                    continue;

                }
            }
        }
    }
}
