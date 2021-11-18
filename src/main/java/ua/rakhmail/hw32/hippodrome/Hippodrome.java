package ua.rakhmail.hw32.hippodrome;

import java.util.ArrayList;
import java.util.Scanner;

public class Hippodrome {

    public static void startRace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, choice number of you horse:" + System.lineSeparator() +"from 1 to 10:");
        String choice = scanner.nextLine();
        ArrayList<HorseThread> horses = new ArrayList<>();
        HorseThread horseThread;
        for (int i = 1; i <= 10; i++) {
            horseThread = new HorseThread();
            horseThread.setName("Horse#"+i);
            horses.add(horseThread);
            horseThread.start();
        }
    }

}
