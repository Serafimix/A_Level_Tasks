package ua.rakhmail.module02.market.marketObjets;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    private String id;
    private String email;
    private int age;
}
