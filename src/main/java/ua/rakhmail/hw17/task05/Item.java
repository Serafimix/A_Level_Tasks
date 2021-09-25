package ua.rakhmail.hw17.task05;

import lombok.Data;

import java.util.Random;

@Data
public class Item {
    static Random random = new Random();
    static int count = 1;

    private String name;
    private int cost;

    public Item() {
        name = "Item" + count;
        cost = random.nextInt(10000) + 1;
        count++;
    }
}
