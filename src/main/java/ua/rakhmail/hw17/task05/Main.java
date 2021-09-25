package ua.rakhmail.hw17.task05;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            boxes.add(new Box());
        }
        Box.printFilterColl(boxes);
    }
}
