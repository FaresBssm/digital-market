package fr.fc.digital_market.repository;

import fr.fc.digital_market.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepoitory extends JpaRepository<Business, Long> {
}
