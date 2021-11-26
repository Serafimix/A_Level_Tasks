package ua.rakhmail.hw31.task01.badButWork;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<TreadForTask> threads = new LinkedHashSet<>();
        for (int i = 0; i < 50; i++) {
            threads.add(new TreadForTask());
        }
        threads.stream()
                .sorted(new Comparator<TreadForTask>() {
            @Override
            public int compare(TreadForTask o1, TreadForTask o2) {
                return o2.getCountForSort() - o1.getCountForSort();
            }
        })
                .peek(Thread::start)
                .forEach(x -> {
            try {
                x.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
