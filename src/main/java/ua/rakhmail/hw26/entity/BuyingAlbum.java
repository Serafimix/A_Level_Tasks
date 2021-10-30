package ua.rakhmail.hw26.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "buying_album")
@Data
@NoArgsConstructor
public class BuyingAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id")
    private Album album;

    public BuyingAlbum(Album album) {
        this.album = album;
    }
}
