package ua.rakhmail.hw32.hippodrome;

import lombok.Getter;

import java.util.Random;

@Getter
public class HorseThread extends Thread{
    private static int count = 1;
    private final int number;

    public HorseThread() {
        number = count++;
    }

    @Override
    public void run() {
        Random random = new Random();
    }

}
