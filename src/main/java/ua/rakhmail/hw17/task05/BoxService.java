package ua.rakhmail.hw17.task05;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class BoxService extends Box {

    private static Stream<Box> choseFilter (Stream<Box> boxStream){



        return boxStream;
    }

    public static void printFilterColl(List<Box> boxes) throws ClassCastException {
        int limit = new Random().nextInt(10) + 1;
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
