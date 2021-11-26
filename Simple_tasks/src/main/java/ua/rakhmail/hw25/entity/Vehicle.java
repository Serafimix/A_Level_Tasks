package ua.rakhmail.hw25.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
    @Column(nullable = false)
    private LocalDate manufacture_date;
    private int price;
    @Enumerated(EnumType.STRING)
    private TyresType tyres_type;
    private LocalDate service_date;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Vehicle(String name, LocalDate manufacture_date, int price, TyresType tyres_type, LocalDate service_date) {
        this.name = name;
        this.manufacture_date = manufacture_date;
        this.price = price;
        this.tyres_type = tyres_type;
        this.service_date = service_date;
    }
}
