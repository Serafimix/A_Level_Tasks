package ua.rakhmail.hw26.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "album")
@Data
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate ReleaseDate;
    @Enumerated(EnumType.STRING)
    private MusicStyle musicStyle;
    private String single;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Album(String name, LocalDate releaseDate, MusicStyle musicStyle, String single, Artist artist) {
        this.name = name;
        ReleaseDate = releaseDate;
        this.musicStyle = musicStyle;
        this.single = single;
        this.artist = artist;
    }
}
