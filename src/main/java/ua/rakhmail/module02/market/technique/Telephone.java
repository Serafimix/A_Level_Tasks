package ua.rakhmail.module02.market.technique;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Telephone extends Technique {
    private String model;

    public Telephone(Category category, String series, String screenType, Integer price, String model) {
        super(category, series, screenType, price);
        this.model = model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "series='" + series + '\'' +
                ", model='" + model + '\'' +
                ", screenType='" + screenType + '\'' +
                ", price=" + price +
                '}';
    }
}

