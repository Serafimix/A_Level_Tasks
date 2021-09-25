package ua.rakhmail.hw17;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task03 {
    public static boolean checkDate(List<String> dates) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        try {
            return dates.stream()
                    .map(d -> LocalDate.parse(d, format))
                    .anyMatch(s -> s.getYear() == 2021);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage() + System.lineSeparator() +
                    "Please, enter date in format YYYY/MM/dd");
            return false;
        }
    }

    public static void main(String[] args) {
        List<String> dates = new ArrayList<>();
        Collections.addAll(dates, "1234/01/23", "2021/02/31", "2022/05/30", "2020/04/13");
        System.out.println("In dates list attend 2021 year? " + checkDate(dates));

        List<String> dates1 = new ArrayList<>();
        Collections.addAll(dates1, "1234/01/23", "2022/02/31", "2022/05/30", "2020/04/13");
        System.out.println("In dates list attend 2021 year? " + checkDate(dates1));

    }
}
