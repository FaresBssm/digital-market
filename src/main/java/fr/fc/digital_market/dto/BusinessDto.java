package fr.fc.digital_market.dto;

import fr.fc.digital_market.entity.NumericInterval;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class BusinessDto {

    private String name;
    private Long profitByMonth;
    private Long visitByMonth;
    private LocalDate creationDate;
    private NumericInterval estimation;

}
