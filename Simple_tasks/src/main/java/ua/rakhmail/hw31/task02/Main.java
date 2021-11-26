package ua.rakhmail.hw31.task02;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        fillNumber(numbers);

        Thread t1 = new Thread(new ThreadForTask(numbers), "Thread1");
        Thread t2 = new Thread(new ThreadForTask(numbers), "Thread2");

        t1.start();
        t2.start();
        t2.join();
        System.out.println(new ThreadForTask().getTemp());
    }

    private static void fillNumber(List<Integer> numbers) {
        for (int i = 1; i < 5_000_000; i++) {
            numbers.add(i);
        }
    }
}
