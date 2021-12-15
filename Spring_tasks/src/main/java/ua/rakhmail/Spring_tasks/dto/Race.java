package ua.rakhmail.Spring_tasks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Race {
    private Long id;
    private LocalDateTime date = LocalDateTime.now();
}
