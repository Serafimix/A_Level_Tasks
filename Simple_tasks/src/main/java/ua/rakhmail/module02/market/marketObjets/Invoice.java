package ua.rakhmail.module02.market.marketObjets;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.rakhmail.module02.market.technique.Technique;

import java.util.List;

@Data
@NoArgsConstructor
public class Invoice {
    private List<Technique> techniques;
    private Customer customer;
    private int limit;
    private String type;
}
