package ua.rakhmail.hw17.task05;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Box {
    private static int count = 1;
    private List<Item> items;
    protected int size = count;

    public Box() {
        items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            items.add(new Item());
        }
        count++;
    }
}
