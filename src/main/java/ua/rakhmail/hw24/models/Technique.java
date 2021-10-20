package ua.rakhmail.hw24.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "techniques")
public class Technique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String model;
    private int price;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Lob
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "factory_id")
    private Factory factory;

    public Technique(String type, String model, int price, String date, String description, Factory factory) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        this.type = type;
        this.model = model;
        this.price = price;
        Date dateS = null;
        try {
            dateS = ft.parse(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        this.date = dateS;
        this.description = description;
        this.factory = factory;
    }
}
