package ua.rakhmail.hw02;

public class Task03 {

    public static void main(String[] args) {
        int number = 69;
        isEven(number);
    }

    public static void isEven(int x) {
        String even = "Четное";
        String notEven = "Не четное";
        System.out.println(x % 2 == 0 ? even : notEven);
    }
}
