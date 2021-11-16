package ua.rakhmail.hw31.task02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        fillNumber(numbers);

    }

    private static void fillNumber(List<Integer> numbers) {
        for (int i = 1; i < 101; i++) {
            numbers.add(i);
        }
    }
}
