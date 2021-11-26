package ua.rakhmail.module02.market.technique;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Technique {
    protected Category category;
    protected String series;
    protected String screenType;
    protected Integer price;

    public Technique(Category category, String series, String screenType, Integer price) {
        this.category = category;
        this.series = series;
        this.screenType = screenType;
        this.price = price;
    }
}
