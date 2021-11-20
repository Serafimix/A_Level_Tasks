package ua.rakhmail.hw32.task02.hippodrome;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Hippodrome {
    @SneakyThrows
    public static void startRace() {
        int numbersOfHorse = createNumberOfHorses();
        int asChoice = choiceHorses(numbersOfHorse);
        System.out.println("Attention");
        Thread.sleep(1000);
        System.out.println("START!");
        ArrayList<HorseThread> horses = new ArrayList<>();
        HorseThread horseThread;
        for (int i = 1; i <= numbersOfHorse; i++) {
            horseThread = new HorseThread();
            horseThread.setName("Horse#" + i);
            horses.add(horseThread);
        }
        horses.forEach(Thread::start);

        while (true) {
            if (horses.stream().noneMatch(Thread::isAlive)) {
                Optional<HorseThread> youHorse;
                youHorse = horses.stream().filter(x -> x.getNumber() == asChoice).findFirst();
                while (youHorse.get().getPlaceInRace() == 0) {
                    Thread.sleep(100);
                }
                System.out.print("Place of you horse with #" + asChoice + " come in ");
                System.out.println(youHorse.get().getPlaceInRace() + " place");
                break;
            } else {
                Thread.sleep(1000);
            }
        }
    }

    private static int createNumberOfHorses() {
        System.out.println("Please, enter numbers of horses for this race");
        Scanner scanner = new Scanner(System.in);
        String text = "Please, write correct positive Number e.g: '5', '15'";
        int count;
        while (true) {
            try {
                count = Integer.parseInt(scanner.nextLine());
                if (count > 0) {
                    return count;
                } else {
                    System.out.println(text);
                }
            } catch (Exception e) {
                System.out.println(text);
            }
        }
    }

    private static int choiceHorses(int x) {
        System.out.println("Please, choice number of you horse:" + System.lineSeparator()
                + "from 1 to you choice of count horses:");
        Scanner scanner = new Scanner(System.in);
        String text = "Please, write correct Number e.g: '5', '15'. from 1 to count of horses.";
        int count;
        while (true) {
            try {
                count = Integer.parseInt(scanner.nextLine());
                if (count <= x && count > 0) {
                    return count;
                } else {
                    System.out.println(text);
                }
            } catch (Exception e) {
                System.out.println(text);
            }
        }
    }
}
