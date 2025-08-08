package com.shopease.factory;

import org.springframework.stereotype.Component;

import com.shopease.model.Store;

@Component
public class StoreFactory {

    public static Store createStore(String name, String type) {
        switch (type.toUpperCase()) {
            case "PREMIUM":
                return new PremiumStore(name);
            case "PARTNER":
                return new PartnerStore(name);
            default:
                return new BasicStore(name);
        }
    }    
}
