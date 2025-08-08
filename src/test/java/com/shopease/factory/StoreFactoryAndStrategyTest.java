
package com.shopease.factory;

import com.shopease.model.Store;
import com.shopease.strategy.BasicStoreStrategy;
import com.shopease.strategy.PartnerStoreStrategy;
import com.shopease.strategy.PremiumStoreStrategy;
import com.shopease.strategy.PriceStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StoreFactoryAndStrategyTest {

    @Test
    public void testCreateBasicStore() {
        Store store = StoreFactory.createStore("BasicStore", "BASIC");
        assertNotNull(store);
        assertEquals("BasicStore", store.getName());
        assertEquals("BASIC", store.getStoreType());
    }

    @Test
    public void testCreatePremiumStore() {
        Store store = StoreFactory.createStore("PremiumStore", "PREMIUM");
        assertNotNull(store);
        assertEquals("PremiumStore", store.getName());
        assertEquals("PREMIUM", store.getStoreType());
    }

    @Test
    public void testCreatePartnerStore() {
        Store store = StoreFactory.createStore("PartnerStore", "PARTNER");
        assertNotNull(store);
        assertEquals("PartnerStore", store.getName());
        assertEquals("PARTNER", store.getStoreType());
    }

    @Test
    public void testBasicPriceStrategy() {
        PriceStrategy strategy = new BasicStoreStrategy();
        double result = strategy.calculatePrice(100);
        assertEquals(100, result);
    }

    @Test
    public void testPremiumPriceStrategy() {
        PriceStrategy strategy = new PremiumStoreStrategy();
        double result = strategy.calculatePrice(100);
        assertEquals(90, result); // 10% discount
    }

    @Test
    public void testPartnerPriceStrategy() {
        PriceStrategy strategy = new PartnerStoreStrategy();
        double result = strategy.calculatePrice(100);
        assertEquals(95, result); // 20% discount + $15 logistics charge
    }
}