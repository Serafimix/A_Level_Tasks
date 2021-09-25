package ua.rakhmail.hw17.task05;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Data
public class Box {
    Random random = new Random();
    private int size = random.nextInt(10) + 1;
    private List<Item> items;

    public Box() {
        items = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            items.add(new Item());
        }
    }

    public static void printFilterColl(List<Box> boxes) throws ClassCastException {
        int limit = new Random().nextInt(10) + 1;
        boxes.stream()
                .filter(box -> box.size <= limit && box.size >= limit)
                .map(Box::getItems)
                .peek(items -> items.sort(Comparator.comparingInt(Item::getCost)))
                .forEach(System.out::println);


    }
}
