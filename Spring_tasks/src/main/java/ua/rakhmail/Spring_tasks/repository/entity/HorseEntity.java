package ua.rakhmail.Spring_tasks.repository.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@Table(name = "horse")
@NoArgsConstructor
@AllArgsConstructor
public class HorseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int place;
    private boolean isChosen = false;
    @ManyToOne
    @JoinColumn(name = "race_id")
    private RaceEntity race;

    public HorseEntity(Long id, String name, int place, boolean isChosen) {
        this.name = name;
        this.place = place;
        this.isChosen = isChosen;
    }
}