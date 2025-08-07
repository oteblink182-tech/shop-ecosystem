package com.shopease.strategy;

import com.shopease.model.Store;

public class StoreContext {
    
    private final Store store;
    private final PriceStrategy priceStrategy;

    public StoreContext(Store store, PriceStrategy priceStrategy) {
        this.store = store;
        this.priceStrategy = priceStrategy;
    }

    public double getFinalPrice(double basePrice) {
        return priceStrategy.calculatePrice(basePrice);
    }

    public Store getStore() {
        return store;
    }
    
}
