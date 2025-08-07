package com.shopease.strategy;

import org.springframework.stereotype.Component;

@Component
public class PremiumStoreStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.9; // 10% de descuento
    }
}
