package ua.rakhmail.hw17.task05;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>(10);
        BoxService.fillBoxes(boxes, 10); //size = количество Элементов Box
        BoxService.printFilterColl(boxes);
    }
}