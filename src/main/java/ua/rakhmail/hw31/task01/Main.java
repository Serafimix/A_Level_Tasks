package ua.rakhmail.hw31.task01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        TreadForTask tread;
        Set<TreadForTask> treads = new LinkedHashSet<>();
        for (int i = 0; i < 50; i++) {
            treads.add(new TreadForTask());
        }
        treads.forEach(Thread::start);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        treads.stream()
                .sorted(new Comparator<TreadForTask>() {
                    @Override
                    public int compare(TreadForTask o1, TreadForTask o2) {
                        return o2.getCountTread() - o1.getCountTread();
                    }
                })
                .forEach(Object::notify);
    }

}
