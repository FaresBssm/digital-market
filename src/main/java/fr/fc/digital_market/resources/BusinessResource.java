package fr.fc.digital_market.resources;

import fr.fc.digital_market.entity.Business;
import fr.fc.digital_market.entity.Cms;
import fr.fc.digital_market.entity.Monetisation;
import fr.fc.digital_market.entity.SourceAquisition;
import fr.fc.digital_market.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/business")

public class BusinessResource {

    @Autowired
    private BusinessService businessService;

    @PostMapping
    public ResponseEntity<Business> createBusiness(@RequestBody Business business) {
        Business savedBusiness = businessService.saveBusiness(business);
        return ResponseEntity.ok().body(savedBusiness);
    }

    @GetMapping
    public ResponseEntity<List<Business>> getAllBusinesses() {
        List<Business> businesses = businessService.getAllBusinesses();
        return ResponseEntity.ok().body(businesses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Business> getBusinessById(@PathVariable Long id) {
        Optional<Business> business = businessService.getBusinessById(id);
        return business.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Business> deleteBusiness(@PathVariable Long id) {
        Optional<Business> business = businessService.getBusinessById(id);
        if (business.isPresent()) {
            businessService.deleteBusinessById(id);
            return ResponseEntity.ok().body(business.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Business>> searchBusiness(
            @RequestParam(required = false) List<Monetisation> monetisationList,
            @RequestParam(required = false) Double minValue,
            @RequestParam(required = false) Double maxValue,
            @RequestParam(required = false) List<Cms> cmsList,
            @RequestParam(required = false) List<SourceAquisition> sourceAquisitions) {
        List<Business> businesses = businessService.searchBusiness(monetisationList,minValue,maxValue,cmsList,sourceAquisitions);
        return ResponseEntity.ok().body(businesses);
    }

}

