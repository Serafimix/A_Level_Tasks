package ua.rakhmail.hw17.task05;

import java.util.Comparator;
import java.util.List;

public final class BoxService {

    private BoxService() {

    }

    public static void printFilterColl(List<Box> boxes) throws ClassCastException {
        int limit = Box.random.nextInt(10) + 1;
        boxes.stream()
                .filter(box -> box.size <= limit && box.size >= limit)
                .map(Box::getItems)
                .peek(items -> items.sort(Comparator.comparingInt(Item::getCost)))
                .forEach(System.out::println);
        // если метод ничего не вывел, значит по фильтру ничего не прошло, т.к.
        // при малой коллекции с малым колличеством Box, может не быть созданных Box
    }

    public static void fillBoxes(List<Box> boxes, int size) {
        for (int i = 0; i < size; i++) {
            boxes.add(new Box());
        }
    }
}
