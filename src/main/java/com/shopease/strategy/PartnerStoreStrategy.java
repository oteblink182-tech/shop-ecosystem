package com.shopease.strategy;

import org.springframework.stereotype.Component;

@Component
public class PartnerStoreStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        // Descuento + tarifa de logística ajustada
        return (basePrice * 0.8) + 15;
    }
}
