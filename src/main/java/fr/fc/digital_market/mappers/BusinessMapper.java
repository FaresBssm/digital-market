package fr.fc.digital_market.mappers;


import fr.fc.digital_market.dto.BusinessDto;
import fr.fc.digital_market.entity.Business;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class BusinessMapper {

    public BusinessDto mapToBusinessDto(Business business) {
        return BusinessDto.builder()
                .name(business.getName())
                .creationDate(business.getCreationDate())
                .profitByMonth(business.getProfitByMonth())
                .visitByMonth(business.getVisitByMonth())
                .build();
    }
    public Business mapToBusiness(BusinessDto businessDto) {
        return Business.builder()
                .name(businessDto.getName())
                .creationDate(businessDto.getCreationDate())
                .profitByMonth(businessDto.getProfitByMonth())
                .visitByMonth(businessDto.getVisitByMonth())
                .build();
    }


}
