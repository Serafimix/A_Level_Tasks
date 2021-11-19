package ua.rakhmail.hw32.task02.hippodrome;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class HorseThread extends Thread{
    private static int count = 1;
    private final int number;
    private int distance;
    private volatile int placeInRace;
    private static AtomicInteger placeCount = new AtomicInteger(0);

    public HorseThread() {
        number = count++;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (distance<1000){
            distance = distance + ThreadLocalRandom.current().nextInt(100, 200);
            Thread.sleep(ThreadLocalRandom.current().nextLong(400, 500));
        }
        placeInRace = placeCount.addAndGet(1);
        System.out.println(getName() + "Finish in place" + placeInRace);
    }

}
