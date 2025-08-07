package com.shopease.strategy;

import org.springframework.stereotype.Component;

@Component
public class BasicStoreStrategy implements PriceStrategy  {

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice; // Sin descuento
    }
    
}
