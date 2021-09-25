package ua.rakhmail.hw17.task05;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Box {
    private int size;
    private List<Item> items;

    public Box () {
        for (int i = 0; i < 10; i++) {
            items = new ArrayList<>();
        }
        size = new Random().nextInt(10) + 1;
    }

//    public void print

public static void printFilterColl (List<Box> boxes) {
        int limit = new Random().nextInt(10) + 1;
        boxes.stream()
                .filter(box -> box.size <= limit && box.size >= limit)
                .flatMap(box -> box.items.stream())
                .sorted()
                .forEach(System.out::println);



}
}
