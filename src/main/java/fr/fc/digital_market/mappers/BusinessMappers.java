package fr.fc.digital_market.mappers;

import fr.fc.digital_market.dto.businessDtos.BusinessDTOIn;
import fr.fc.digital_market.dto.businessDtos.BusinessDTOOut;
import fr.fc.digital_market.entity.Business;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BusinessMappers {
    BusinessDTOOut mapToBusinessDTOut(Business business);
    Business mapToBusiness(BusinessDTOIn businessIn);
}
