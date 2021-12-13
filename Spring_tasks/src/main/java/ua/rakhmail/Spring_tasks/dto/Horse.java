package ua.rakhmail.Spring_tasks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.rakhmail.Spring_tasks.repository.entity.RaceEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Horse {

    private Long id;
    private String name;
    private int place;
    private boolean isChosen = false;

    private RaceEntity race;
}
