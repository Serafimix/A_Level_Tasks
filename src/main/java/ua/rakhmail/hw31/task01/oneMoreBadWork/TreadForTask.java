package ua.rakhmail.hw31.task01.oneMoreBadWork;


import lombok.SneakyThrows;

public class TreadForTask extends Thread {
    private static long sleep = 5000;
    @SneakyThrows
    @Override
    public void run() {
        sleep -= 50;
        sleep(sleep);
        System.out.println("Hello from" + this.getName());
    }
}