package ua.rakhmail.Spring_tasks.repository.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "race")
@NoArgsConstructor
@AllArgsConstructor
public class RaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date = LocalDateTime.now();
    @OneToMany(mappedBy = "race")
    @ToString.Exclude
    private List<HorseEntity> horses = new ArrayList<>();
}