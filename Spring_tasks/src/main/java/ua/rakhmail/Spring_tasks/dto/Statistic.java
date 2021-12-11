package ua.rakhmail.Spring_tasks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {
    private int requests;
    private LocalDate date;
}
