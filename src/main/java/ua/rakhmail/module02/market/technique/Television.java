package ua.rakhmail.module02.market.technique;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Television extends Technique {
    private int diagonal;
    private String country;

    public Television(Category category, String series, String screenType, Integer price, int diagonal, String country) {
        super(category, series, screenType, price);
        this.diagonal = diagonal;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Television{" +
                "series='" + series + '\'' +
                ", diagonal=" + diagonal +
                ", screenType='" + screenType + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                '}';
    }
}
