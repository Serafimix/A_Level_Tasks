package ua.rakhmail.Spring_tasks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
    private Long id;
    private String name;
    private LocalDateTime date;
    private String city;
}