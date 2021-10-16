package ua.rakhmail.hw23.objects;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Technique {
    private final int serial;
    private final TechniqueType type;
    private final String model;
    private final int price;
    private final Date date;
    private final String description;
    private boolean isHave;
    private int IDFactory;
}
