package ua.rakhmail.hw09.task02;

public class Test {

    private static final int NUMBER = 5;
    private static final int POW = 4;


    static Pow exponentiation = (x, y) -> {
        int result = 1;
        for (int i = 1; i <= y; i++) {
            result *= x;
        }
        return result;
    };

    public static void main(String[] args) {
        System.out.println(exponentiation.pow(NUMBER, POW));
    }
}
