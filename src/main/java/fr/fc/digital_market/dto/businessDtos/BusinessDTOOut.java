package fr.fc.digital_market.dto.businessDtos;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import fr.fc.digital_market.enumerations.Monetisation;
import fr.fc.digital_market.entity.NumericInterval;
import fr.fc.digital_market.dto.annonceDtos.AnnonceDTOOut;

public class BusinessDTOOut {
    private Long id;
    private String name;
    private Long profitByMonth;
    private Long visitByMonth;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;

    private NumericInterval estimation;
    private List<Monetisation> monetisationList;
    private AnnonceDTOOut annonce;
}

