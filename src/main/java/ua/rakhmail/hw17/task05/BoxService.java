package ua.rakhmail.hw17.task05;

import lombok.Value;

import java.util.Comparator;
import java.util.List;

@Value
public class BoxService {


    public static void printFilterColl(List<Box> boxes) throws ClassCastException {
        int limit = Box.random.nextInt(10) + 1;
        boxes.stream()
                .filter(box -> box.size <= limit && box.size >= limit)
                .map(Box::getItems)
                .peek(items -> items.sort(Comparator.comparingInt(Item::getCost)))
                .forEach(System.out::println);
    }

    public static void fillBoxes(List<Box> boxes, int size) {
        for (int i = 0; i < size; i++) {
            boxes.add(new Box());
        }
    }
}
