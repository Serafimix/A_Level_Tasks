package ua.rakhmail.hw16;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task01 {


    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(); // размер не задаю для лучших результатов
        List<Integer> linkedList = new LinkedList<>();
        System.out.println("Start arrayList work " + System.lineSeparator() + LocalTime.now());
        takeRandom(arrayList);
        System.out.println("End arrayList work" + System.lineSeparator() + LocalTime.now());
        System.out.println("Start linkedList work" + System.lineSeparator() + LocalTime.now());
        takeRandom(linkedList);
        System.out.println("End linkedList work" + System.lineSeparator() + LocalTime.now());
        /*
        Start arrayList work
        14:04:21.011032100
        End arrayList work
        14:04:21.058903300
        Start linkedList work
        14:04:21.058903300
        End linkedList work
        14:06:43.746182400
        */
    }

    public static void fillList(List<Integer> list) {
        for (int i = 0; i < 1000000; i++) {
            list.add(i + 1);
        }
    }

    public static void takeRandom(List<Integer> list) {
        fillList(list);
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int a = list.get(random.nextInt(1000000));
        }
    }
}
