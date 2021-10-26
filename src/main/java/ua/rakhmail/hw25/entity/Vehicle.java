package ua.rakhmail.hw25.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "vehicle")
@Data
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date manufacture_date;
    private int price;
    private String tyres_type;
    @Temporal(TemporalType.DATE)
    private Date service_date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;


    // создание техники с присвоением владельца
    public Vehicle(String name, String manufacture_date, int price, String tyres_type, String service_date, Owner owner) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        this.name = name;
        Date date1 = null;
        try {
            date1 = ft.parse(manufacture_date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        this.manufacture_date = date1;
        this.price = price;
        this.tyres_type = tyres_type;
        Date date2 = null;
        try {
            date2 = ft.parse(service_date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        this.service_date = date2;
        this.owner = owner;
    }

    // создание техники без владельца (потом можно присвоить владельца через set метод)
    public Vehicle(String name, String manufacture_date, int price, String tyres_type, String service_date) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        this.name = name;
        Date date1 = null;
        try {
            date1 = ft.parse(manufacture_date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        this.manufacture_date = date1;
        this.price = price;
        this.tyres_type = tyres_type;
        Date date2 = null;
        try {
            date2 = ft.parse(service_date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        this.service_date = date2;
    }
}
