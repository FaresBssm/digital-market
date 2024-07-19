package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data

public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long profitByMonth;
    private Long visitByMonth;
    private LocalDate creationDate;
    private LocalDate publicationDate;
    private Interval estimation;

    @OneToMany(mappedBy = "business",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Monetisation> monetisation;

}
