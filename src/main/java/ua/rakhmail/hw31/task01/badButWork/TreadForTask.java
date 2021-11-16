package ua.rakhmail.hw31.task01.badButWork;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TreadForTask extends Thread {
    private static int count = 1;
    private int countForSort;

    public TreadForTask() {
        countForSort = count++;
    }

    @Override
    public void run() {
        System.out.println("Hello from" + this.getName());
    }
}
