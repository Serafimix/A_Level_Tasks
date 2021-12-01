package ua.rakhmail.hw35.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
    private String name;
    private String date;
    private String city;
}
