package fr.fc.digital_market.dto.annonceDtos;

import fr.fc.digital_market.dto.businessDtos.BusinessDTOOut;
import fr.fc.digital_market.enumerations.Cms;
import fr.fc.digital_market.enumerations.SourceAquisition;

import java.util.List;

public class AnnonceDTOOut {
    private Long id;
    private String descriptionBusiness;
    private String pointsFort;
    private List<Cms> cmsList;
    private List<SourceAquisition> sourceAcquisition;
    private BusinessDTOOut business;
}

