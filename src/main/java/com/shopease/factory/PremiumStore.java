package com.shopease.factory;

public class PremiumStore extends AbstractStore {
    
    public PremiumStore(String name) {
        super(name);
        this.setStoreType("PREMIUM");
    }

    @Override
    public String getStoreType() {
        return "PREMIUM";
    }
}
