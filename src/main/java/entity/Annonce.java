package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descriptionBusiness;
    private String pointsFort;
    private Cms cms;
    private SourceAquisition sourceAcquisition;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id",referencedColumnName = "id")
    private Business business;
}
