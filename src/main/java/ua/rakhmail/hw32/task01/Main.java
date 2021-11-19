package ua.rakhmail.hw32.task01;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread thread;
        for (int i = 0; i < 100; i++) {
            thread = new Thread(() -> {
                lock.lock();
                count.set(count.get() + 2);
                lock.unlock();
            });
            thread.start();
            thread.join();
        }
        System.out.println(count.get());
    }


    private static final AtomicInteger count = new AtomicInteger(50);


}
