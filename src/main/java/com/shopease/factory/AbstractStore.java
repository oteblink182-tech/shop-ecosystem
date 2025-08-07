package com.shopease.factory;

import com.shopease.model.Store;

public abstract  class AbstractStore extends Store {
    
    public AbstractStore(String name) {
        super(name);
    }

    public abstract String getStoreType();
}
