package fr.fc.digital_market.services;

import fr.fc.digital_market.entity.*;
import fr.fc.digital_market.repository.BusinessRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private static BusinessRepository businessRepository;

    public static ResponseEntity<List<Business>> findBusinessByMonetisation(List<Monetisation> monetisations) {
        return businessRepository.findByMonetisationListIn(monetisations);
    }

    public Business saveBusiness(Business business) { return businessRepository.save(business); }

    public List<Business> getAllBusinesses() { return businessRepository.findAll(); }

    public void deleteBusinessById(Long id) { businessRepository.deleteById(id); }

    public Optional<Business> getBusinessById(Long id) { return businessRepository.findById(id);}


    public List<Business> searchBusiness(List<Monetisation> monetisationList, Double minValue, Double maxValue, List<Cms> cmsList, List<SourceAquisition> sourceAquisitions) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Business> cq = cb.createQuery(Business.class);
        Root<Business> business = cq.from(Business.class);
        Join<Business, Annonce> annonce =business.join("annonce",JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        if(monetisationList != null && !monetisationList.isEmpty()) {
            Predicate monetisationPredicate = business.get("monetisationsList").in(monetisationList);
            predicates.add(monetisationPredicate);
        }
        if(minValue != null && maxValue != null) {
            Predicate estimationPredicate = cb.between(business.get("estimation").get("minValue"), minValue, maxValue);
            predicates.add(estimationPredicate);
        }
        if (cmsList != null && !cmsList.isEmpty()){
            predicates.add(annonce.get("cmsList").in(cmsList));
        }
        if ( sourceAquisitions != null && !sourceAquisitions.isEmpty()){
            predicates.add(annonce.get("sourceAccquisition").in(sourceAquisitions));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }

}
