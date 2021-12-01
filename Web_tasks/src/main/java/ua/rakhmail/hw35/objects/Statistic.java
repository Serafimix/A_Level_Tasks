package ua.rakhmail.hw35.objects;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class Statistic {
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private int requests;
    private String date;

    public Statistic(int requests) {
        this.requests = requests;
        this.date = LocalDateTime.now().format(format);
    }
}
