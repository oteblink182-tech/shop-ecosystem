package com.shopease.factory;

public class PartnerStore extends AbstractStore {
    
    public PartnerStore(String name) {
        super(name);
        this.setStoreType("PARTNER");
    }

    @Override
    public String getStoreType() {
        return "PARTNER";
    }
}
