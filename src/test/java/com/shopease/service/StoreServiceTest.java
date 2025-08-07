package com.shopease.service;

import com.shopease.model.Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StoreServiceTest {
    
     @Autowired
    private StoreService storeService;

    @Test
    public void testCreateStore() {
        Store store = new Store("Test Store");
        store.setStoreType("BASIC");
        Store saved = storeService.createStore(store);

        assertNotNull(saved);
        assertEquals("Test Store", saved.getName());
        assertEquals("BASIC", saved.getStoreType());
    }
}
