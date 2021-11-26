package ua.rakhmail.hw17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Task02 {

    public static void printNumberStatistic(List<Integer> list) {
        IntSummaryStatistics statistics = list.stream()
                .filter(x -> x >= 0)
                .mapToInt(x -> x)
                .summaryStatistics();
        System.out.println(statistics);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 6, 1, 7, 9, 4, 12, 3, 6, 15,
                7, 1, 2, 5, 7, -5, -12, -6, 12, -1256, -1241256);
        printNumberStatistic(numbers);
    }
}
