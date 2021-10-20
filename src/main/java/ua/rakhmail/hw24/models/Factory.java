package ua.rakhmail.hw24.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "factory")
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
    private Set<Technique> techniques;

    public Factory(String name, String country) {
        this.name = name;
        this.country = country;
        techniques = new HashSet<Technique>();
    }
}
