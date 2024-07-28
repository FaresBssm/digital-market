package fr.fc.digital_market.resources;

import fr.fc.digital_market.dto.businessDtos.BusinessDTOIn;
import fr.fc.digital_market.dto.businessDtos.BusinessDTOOut;
import fr.fc.digital_market.enumerations.Cms;
import fr.fc.digital_market.enumerations.Monetisation;
import fr.fc.digital_market.enumerations.SourceAquisition;
import fr.fc.digital_market.services.BusinessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/business")

public class BusinessResource {


    private final BusinessService businessService;

    public BusinessResource(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping
    public ResponseEntity<BusinessDTOOut> createBusiness(@RequestBody BusinessDTOIn business) {
        BusinessDTOOut savedBusiness = businessService.saveBusiness(business);
        return ResponseEntity.created(URI.create("api/v1/business")).body(savedBusiness);
    }

    @GetMapping
    public ResponseEntity<List<BusinessDTOOut>> getAllBusinesses() {
        return ResponseEntity.ok().body(businessService.getAllBusinesses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessDTOOut> getBusinessById(@PathVariable Long id) {
        Optional<BusinessDTOOut> business = businessService.getBusinessById(id);
        return business.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BusinessDTOOut> deleteBusiness(@PathVariable Long id) {
        Optional<BusinessDTOOut> business = businessService.getBusinessById(id);
        if (business.isPresent()) {
            businessService.deleteBusinessById(id);
            return ResponseEntity.ok().body(business.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<BusinessDTOOut>> searchBusiness(
            @RequestParam(required = false) List<Monetisation> monetisationList,
            @RequestParam(required = false) Double minValue,
            @RequestParam(required = false) Double maxValue,
            @RequestParam(required = false) List<Cms> cmsList,
            @RequestParam(required = false) List<SourceAquisition> sourceAquisitions) {
        return ResponseEntity.ok().body(businessService.searchBusiness(monetisationList, minValue, maxValue, cmsList, sourceAquisitions));
    }

}

