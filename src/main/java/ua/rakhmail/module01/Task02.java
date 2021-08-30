package ua.rakhmail.module01;

import java.util.Scanner;

public class Task02 {
    private static final char[] HORIZONTAL = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private static final short[] VERTICAL = {8, 7, 6, 5, 4, 3, 2, 1};
    private static final int SIDE = 8;
    private static String[][] board = new String[SIDE][SIDE];
    private static final String HORSE = "Конь";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createBoard(board);
        myDeepToString(board);
        horseOnBoard(board);
        myDeepToString(board);
        moveHorse();
        myDeepToString(board);
        scanner.close();
    }

    static void createBoard(String[][] strings) {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                strings[i][j] = "" + HORIZONTAL[j] + VERTICAL[i];
            }
        }
    }

    static void horseOnBoard(String[][] array) {
        System.out.println("Введите координаты шахматной доски по типу А1-H8");
        boolean isHave = true;
        while (isHave) {
            String s = scanner.nextLine();
            for (int i = 0; i < SIDE; i++) {
                for (int j = 0; j < SIDE; j++) {
                    if (array[i][j].equalsIgnoreCase(s)) {
                        array[i][j] = HORSE;
                        System.out.println("Конь на " + s);
                        isHave = false;
                    }
                }
            }
        }
    }


    static void myDeepToString(String[][] strings) {
        for (String[] string : strings) {
            for (int j = 0; j < strings.length; j++) {
                System.out.print(string[j] + " ");
            }
            System.out.println();
        }
    }


    static void moveHorse() {
        System.out.println("Куда вы хотите переместить своего коня?");
        boolean isTrue = true;
        String str;
        while (isTrue) {
            str = scanner.nextLine();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    String string = board[i][j];
                    if (str.equalsIgnoreCase(string)) {
                        if (i + 2 < SIDE && j - 1 >= 0) {
                            if (board[i + 2][j - 1].equals(HORSE)) {
                                board[i][j] = HORSE;
                                board[i + 2][j - 1] = "" + HORIZONTAL[j - 1] + VERTICAL[i + 2];
                                isTrue = false;
                                break;
                            }
                        }
                        if (i + 2 < SIDE && j + 1 < SIDE) {
                            if (board[i + 2][j + 1].equals(HORSE)) {
                                board[i + 2][j + 1] = "" + HORIZONTAL[j + 1] + VERTICAL[i + 2];
                                board[i][j] = HORSE;
                                isTrue = false;
                                break;
                            }
                        }
                        if (i - 2 >= 0 && j - 1 >= 0) {
                            if (board[i - 2][j - 1].equals(HORSE)) {
                                board[i - 2][j - 1] = "" + HORIZONTAL[j - 1] + VERTICAL[i - 2];
                                board[i][j] = HORSE;
                                isTrue = false;
                                break;
                            }
                        }
                        if (i - 2 >= 0 && j + 1 < SIDE) {
                            if (board[i - 2][j + 1].equals(HORSE)) {
                                board[i - 2][j + 1] = "" + HORIZONTAL[j + 1] + VERTICAL[i - 2];
                                board[i][j] = HORSE;
                                isTrue = false;
                                break;
                            }
                        }
                        if (i + 1 < SIDE && j - 2 >= 0) {
                            if (board[i + 1][j - 2].equals(HORSE)) {
                                board[i + 1][j - 2] = "" + HORIZONTAL[j - 2] + VERTICAL[i + 1];
                                board[i][j] = HORSE;
                                isTrue = false;
                                break;
                            }
                        }
                        if (i + 1 < SIDE && j + 2 < SIDE) {
                            if (board[i + 1][j + 2].equals(HORSE)) {
                                board[i + 1][j + 2] = "" + HORIZONTAL[j + 2] + VERTICAL[i + 1];
                                board[i][j] = HORSE;
                                isTrue = false;
                                break;
                            }
                        }
                        if (i - 1 >= 0 && j - 2 >= 0) {
                            if (board[i - 1][j - 2].equals(HORSE)) {
                                board[i - 1][j - 2] = "" + HORIZONTAL[j - 2] + VERTICAL[i - 1];
                                board[i][j] = HORSE;
                                isTrue = false;
                                break;
                            }
                        }
                        if (i - 1 >= 0 && j + 2 < SIDE) {
                            if (board[i - 1][j + 2].equals(HORSE)) {
                                board[i - 1][j + 2] = "" + HORIZONTAL[j + 2] + VERTICAL[i - 1];
                                board[i][j] = HORSE;
                                isTrue = false;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println("Пожалуйста, проверте о возможности передвижения в данные кординаты вашего коня за один ход.");
        }
    }
}