package fr.fc.digital_market.dto.annonceDtos;

import fr.fc.digital_market.enumerations.Cms;
import fr.fc.digital_market.enumerations.SourceAquisition;

import java.util.List;

public class AnnonceDTOIn {
    private String descriptionBusiness;
    private String pointsFort;
    private List<Cms> cmsList;
    private List<SourceAquisition> sourceAcquisition;
    private Long businessId;

}
