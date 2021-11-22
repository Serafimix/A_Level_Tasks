package ua.rakhmail.hw32.task01;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int counter = 100;
        AtomicInteger number = new AtomicInteger(50);
        CountDownLatch latch = new CountDownLatch(counter);
        Runnable adders = () -> {
            try {
                number.addAndGet(2);
            } finally {
                latch.countDown();
            }
        };
        for (int x = 0; x < counter; x++) {
            new Thread(adders).start();
        }
        latch.await();
        System.out.println(number);
    }
}
