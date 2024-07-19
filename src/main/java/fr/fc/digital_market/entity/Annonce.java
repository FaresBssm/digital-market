package fr.fc.digital_market.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descriptionBusiness;
    private String pointsFort;

    @ElementCollection(targetClass = Cms.class)
    @Enumerated(EnumType.STRING)
    private List<Cms> cmsList;

    @ElementCollection(targetClass = SourceAquisition.class)
    @Enumerated(EnumType.STRING)
    private List<SourceAquisition> sourceAcquisition;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id",referencedColumnName = "id")
    private Business business;
}
