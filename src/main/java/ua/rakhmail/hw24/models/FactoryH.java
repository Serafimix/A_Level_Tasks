package ua.rakhmail.hw24.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "FactoryH")
@Data
@NoArgsConstructor
public class FactoryH {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true, nullable = false)
    private String id;
    private String name;
    private String country;
    @OneToMany(mappedBy = "techniqueHId")
    @ToString.Exclude
    private Set<TechniqueH> techniqueHs;
}
