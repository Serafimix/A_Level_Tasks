package ua.rakhmail.hw17.task05;

import lombok.Value;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Value
public class BoxService {
    public static Random random = new Random();

    public static void printFilterColl(List<Box> boxes) throws ClassCastException {
        int limit = BoxService.random.nextInt(boxes.size()) + 1;
        boxes.stream()
                .filter(box -> box.size <= limit && box.size >= limit)
                .map(Box::getItems)
                .peek(items -> items.sort(Comparator.comparingInt(Item::getCost)))
                .forEach(System.out::println);
        System.out.println("Filter for Box with size: " + limit);
    }

    public static void fillBoxes(List<Box> boxes, int size) {
        for (int i = 0; i < size; i++) {
            boxes.add(new Box());
        }
    }
}
