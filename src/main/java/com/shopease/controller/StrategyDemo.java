package com.shopease.controller;

import com.shopease.model.Store;
import com.shopease.strategy.BasicStoreStrategy;
import com.shopease.strategy.PartnerStoreStrategy;
import com.shopease.strategy.PremiumStoreStrategy;
import com.shopease.strategy.StoreContext;

public class StrategyDemo {
    public static void main(String[] args) {

        // Creamos las tiendas
        Store tiendaBasica = new Store("Tienda BASIC");
        tiendaBasica.setStoreType("BASIC");

        Store tiendaPremium = new Store("Tienda Premium");
        tiendaPremium.setStoreType("PREMIUM");

        Store tiendaPARTNER = new Store("Tienda PARTNER");
        tiendaPARTNER.setStoreType("PARTNER");
        
        StoreContext  basic = new StoreContext(tiendaBasica, new BasicStoreStrategy());
        StoreContext  premium = new StoreContext(tiendaPremium, new PremiumStoreStrategy());
        StoreContext  partner = new StoreContext(tiendaPARTNER, new PartnerStoreStrategy());

        double basePrice = 100;

        System.out.println("BASIC: " + basic.getFinalPrice(basePrice));   // 100.0
        System.out.println("Premium: " + premium.getFinalPrice(basePrice)); // 90.0
        System.out.println("PARTNER: " + partner.getFinalPrice(basePrice));   // 95.0 (80 + 15)
    }
}
