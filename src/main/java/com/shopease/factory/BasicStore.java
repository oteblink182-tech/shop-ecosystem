package com.shopease.factory;

public class BasicStore extends AbstractStore {

    public BasicStore(String name) {
        super(name);
        this.setStoreType("BASIC");
    }

    @Override
    public String getStoreType() {
        return "BASIC";
    }    
}
