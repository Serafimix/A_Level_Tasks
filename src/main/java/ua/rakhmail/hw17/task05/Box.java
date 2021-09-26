package ua.rakhmail.hw17.task05;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Box {
    protected static Random random = new Random();
    protected int size = random.nextInt(10) + 1;
    private List<Item> items;

    public Box() {
        items = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            items.add(new Item());
        }
    }
}
