package fr.fc.digital_market.services;

import fr.fc.digital_market.entity.Business;
import fr.fc.digital_market.repository.BusinessRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepoitory businessRepoitory;

    public Business saveBusiness(Business business) { return businessRepoitory.save(business); }

    public List<Business> getAllBusinesses() { return businessRepoitory.findAll(); }

    public void deleteBusinessById(Long id) { businessRepoitory.deleteById(id); }

    public Optional<Business> getBusinessById(Long id) { return businessRepoitory.findById(id);}

}
