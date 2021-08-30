package ua.rakhmail.hw02;

public class Task04 {
    public static void main(String[] args) {
        System.out.println(minOfDouble(24.5, -1421.3, 24.4));
    }

    public static double minOfDouble(double firstNumber, double secondNumber, double thirstNumber) {
        double a = Math.abs(firstNumber);
        double b = Math.abs(secondNumber);
        double c = Math.abs(thirstNumber);
        return (a < b) ? ((a < c) ? a : c) : ((b < c) ? b : c);
    }
}
