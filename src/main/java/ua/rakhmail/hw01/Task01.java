package ua.rakhmail.hw01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task01 {
    private static final String MY_NAME = "Vitalii Rakhmail"; // it's me

    public static void main(String[] args) {

        Date time = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MMMM HH:mm:ss");
        String adventureTime = simpleDate.format(time);
        System.out.println("\t - Hello " + MY_NAME + ", what time is it?" + System.lineSeparator() +
                "\t - it's " + adventureTime);
    }
}
