package ua.rakhmail.hw26.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "orders_date")
    private LocalDate orderDate = LocalDate.now();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buying_album_id")
    private BuyingAlbum buyingAlbum;

    public Orders(BuyingAlbum buyingAlbum) {
        this.buyingAlbum = buyingAlbum;
    }
}
