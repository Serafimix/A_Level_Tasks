package ua.rakhmail.hw17.task05;

import lombok.Data;

@Data
public class Item {
    static int count = 1;
    private String name;
    private int cost;

    public Item() {
        name = "Item" + count;
        cost = Box.random.nextInt(10000) + 1;
        count++;
    }
}
