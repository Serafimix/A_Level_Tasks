package ua.rakhmail.hw24.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class TechniqueH {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true, nullable = false)
    private String id;
    private String type;
    private String model;
    private int price;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;
    private boolean isHave;
    @ManyToOne
    @JoinColumn(name = "fk_factory")
    private FactoryH factoryId;
}
