package ua.rakhmail.hw32.task02.hippodrome;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Hippodrome {

    @SneakyThrows
    public static void startRace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter numbers of horses for this race");
        int numbersOfHorse = 0;
        try {
            numbersOfHorse = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Please, choice number of you horse:" + System.lineSeparator()
                + "from 1 to you choice of count horses:");
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
            horseThread.setName("Horse#" + i);
            horses.add(horseThread);
        }
        horses.forEach(Thread::start);

        /* так как я здесь проверил существует ли лошать, которую мы выбрали,
           мы можем без опаски достать коня с опционала и делать с ним разные проверки без возможности на exception.
         */

        if (asChoice > 0 && asChoice <= numbersOfHorse) {
            Optional<HorseThread> youHorse;
            int finalAsChoice = asChoice;
            youHorse = horses.stream().filter(x -> x.getNumber() == finalAsChoice).findFirst();
            while (youHorse.get().getPlaceInRace() == 0) {
                Thread.sleep(100);
            }
            System.out.print("Place of you horse with #" + asChoice + " come in ");
            System.out.println(youHorse.get().getPlaceInRace() + " place");
        } else {
            System.out.println("You don't choice any real horse...");
        }
    }
}
