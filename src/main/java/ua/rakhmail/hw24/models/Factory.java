package ua.rakhmail.hw24.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "factorys")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String country;
    @OneToMany(mappedBy = "factory")
    @JoinColumn(name = "technique_id")
    private Set<Technique> techniques;
}
