package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Monetisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Monetisation type;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

}
