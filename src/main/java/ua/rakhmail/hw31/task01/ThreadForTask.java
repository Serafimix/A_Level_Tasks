package ua.rakhmail.hw31.task01;

import java.util.*;

public class ThreadForTask extends Thread {

    public void run() {
        ThreadsForThread th;
        List<ThreadsForThread> list = new ArrayList<>();
        try {
            for (int i = 0; i < 50; i++) {
                th = new ThreadsForThread();
                list.add(th);
            }
            for (int i = 49; i >= 0; i--) {
                list.get(i).start();
                list.get(i).join();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
