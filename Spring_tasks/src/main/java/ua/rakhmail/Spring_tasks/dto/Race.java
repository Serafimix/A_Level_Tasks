package ua.rakhmail.Spring_tasks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Race {
    private Long id;
    private LocalDateTime date = LocalDateTime.now();
    private List<Horse> horses = new ArrayList<>();

}
