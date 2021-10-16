package ua.rakhmail.hw23.objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Factory {
    private final int serial;
    private final String name;
    private final String country;
}
