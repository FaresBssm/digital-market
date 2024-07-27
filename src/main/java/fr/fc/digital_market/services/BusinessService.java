package fr.fc.digital_market.services;

import fr.fc.digital_market.dto.businessDtos.BusinessDTOIn;
import fr.fc.digital_market.dto.businessDtos.BusinessDTOOut;
import fr.fc.digital_market.entity.*;
import fr.fc.digital_market.enumerations.Cms;
import fr.fc.digital_market.enumerations.Monetisation;
import fr.fc.digital_market.enumerations.SourceAquisition;
import fr.fc.digital_market.mappers.BusinessMappers;
import fr.fc.digital_market.repository.BusinessRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusinessService {

    @PersistenceContext
    private EntityManager em;


    private final BusinessRepository businessRepository;
    private final BusinessMappers businessMappers;

    public BusinessService(BusinessRepository businessRepository, BusinessMappers businessMappers) {
        this.businessRepository = businessRepository;
        this.businessMappers = businessMappers;
    }

    public ResponseEntity<List<BusinessDTOOut>> findBusinessByMonetisation(List<Monetisation> monetisations) {
        return ResponseEntity.ok(businessRepository.findByMonetisationListIn(monetisations).stream()
                .map(businessMappers::mapToBusinessDTOut)
                .collect(Collectors.toList()));
    }

    public BusinessDTOOut saveBusiness(BusinessDTOIn business) {
        return businessMappers.mapToBusinessDTOut(businessRepository.save(businessMappers.mapToBusiness(business)));
    }

    public List<BusinessDTOOut> getAllBusinesses() {
        return businessRepository.findAll().stream()
                .map(businessMappers::mapToBusinessDTOut)
                .collect(Collectors.toList());
    }

    public void deleteBusinessById(Long id) {
        businessRepository.deleteById(id);
    }

    public Optional<BusinessDTOOut> getBusinessById(Long id) {
        return businessRepository.findById(id)
                .map(businessMappers::mapToBusinessDTOut);
    }


    public List<BusinessDTOOut> searchBusiness(List<Monetisation> monetisationList, Double minValue, Double maxValue, List<Cms> cmsList, List<SourceAquisition> sourceAquisitions) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Business> cq = cb.createQuery(Business.class);
        Root<Business> business = cq.from(Business.class);
        Join<Business, Annonce> annonce = business.join("annonce", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        if (monetisationList != null && !monetisationList.isEmpty()) {
            Predicate monetisationPredicate = business.get("monetisationsList").in(monetisationList);
            predicates.add(monetisationPredicate);
        }
        if (minValue != null && maxValue != null) {
            Predicate estimationPredicate = cb.between(business.get("estimation").get("minValue"), minValue, maxValue);
            predicates.add(estimationPredicate);
        }
        if (cmsList != null && !cmsList.isEmpty()) {
            predicates.add(annonce.get("cmsList").in(cmsList));
        }
        if (sourceAquisitions != null && !sourceAquisitions.isEmpty()) {
            predicates.add(annonce.get("sourceAccquisition").in(sourceAquisitions));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList().stream().map(businessMappers::mapToBusinessDTOut).collect(Collectors.toList());
    }

}
