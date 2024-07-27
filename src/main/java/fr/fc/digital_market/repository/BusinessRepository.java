package fr.fc.digital_market.repository;

import fr.fc.digital_market.entity.Business;
import fr.fc.digital_market.enumerations.Monetisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
   List<Business> findByMonetisationListIn(List<Monetisation> monetisations);
}
