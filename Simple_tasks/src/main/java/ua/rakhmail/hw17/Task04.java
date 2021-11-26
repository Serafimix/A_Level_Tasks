package ua.rakhmail.hw17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task04 {

    public static int minOfList(List<Integer> list) {
        return list.stream()
                .reduce(Integer.MAX_VALUE, (i, x) -> i < x ? i : x);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, -5, -50, 124, 61, 124, 12, 61, 100, 0);
        System.out.println(" Minimum from the list = " + minOfList(numbers));
    }
}
