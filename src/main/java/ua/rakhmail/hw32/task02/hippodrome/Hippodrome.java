package ua.rakhmail.hw32.task02.hippodrome;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Scanner;

public class Hippodrome {

    @SneakyThrows
    public static void startRace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter numbers of horses for this race");
        int numbersOfHorse;
        try {
            numbersOfHorse = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            numbersOfHorse = 1;
        }
        System.out.println("Please, choice number of you horse:" + System.lineSeparator()
                +"from 1 to you choice of count horses:");
        String choice = scanner.nextLine();
        int asChoice = 0;
        try {
            asChoice = Integer.parseInt(choice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Attention");
        Thread.sleep(1000);
//        for (int i = 3; i > 0; i--) {
//            System.out.println(i);
//            Thread.sleep(1000);
//        }
        System.out.println("START!");
        ArrayList<HorseThread> horses = new ArrayList<>();
        HorseThread horseThread;
        for (int i = 1; i <= numbersOfHorse; i++) {
            horseThread = new HorseThread();
            horseThread.setName("Horse#"+i);
            horses.add(horseThread);
        }
        horses.forEach(Thread::start);
        Thread.sleep(5000);
    }

}
