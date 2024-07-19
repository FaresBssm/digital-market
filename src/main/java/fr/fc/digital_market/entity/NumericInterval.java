package fr.fc.digital_market.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class NumericInterval {
    private Double minValue;
    private Double maxValue;

    public NumericInterval() {}

    public NumericInterval(Double minValue, Double maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
