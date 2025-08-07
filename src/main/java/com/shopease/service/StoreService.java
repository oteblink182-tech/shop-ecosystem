package com.shopease.service;

import com.shopease.factory.StoreFactory;
import com.shopease.model.Product;
import com.shopease.model.Store;
import com.shopease.strategy.PriceStrategy;
import com.shopease.strategy.PriceStrategyFactory;
import com.shopease.strategy.StoreContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StoreService {
    
    // Simulando la base de datos
    private final Map<String, Store> storeDB = new HashMap<>();
    private final PriceStrategyFactory priceStrategyFactory;
    @Autowired
    private StoreFactory storeFactory;

    public StoreService(PriceStrategyFactory priceStrategyFactory) {
        this.priceStrategyFactory = priceStrategyFactory;
    }

    public List<Store> getAllStores() {
        return new ArrayList<>(storeDB.values());
    }

    public Store createStore(Store store) {
        storeDB.put(store.getId(), store);
        return store;
    }

    public Optional<Store> getStoreById(String id) {
        return Optional.ofNullable(storeDB.get(id));
    }

    public Product addProductToStore(String storeId, Product product) {
        Store store = storeDB.get(storeId);
        if (store != null) {
            store.getProducts().add(product);
            return product;
        }
        throw new NoSuchElementException("Store not found");
    }

    public List<Product> getProductsByStore(String storeId) {
        Store store = storeDB.get(storeId);
        if (store != null) {
            return store.getProducts();
        }
        throw new NoSuchElementException("Store not found");
    }

    // Method responsible for calculated the final price using Strategy pattern
    public double calculateFinalPrice(String storeId, String productId) {
        Store store = storeDB.get(storeId);
        if (store == null) {
            throw new NoSuchElementException("Store not found");
        }

        Product product = store.getProducts()
            .stream()
            .filter(p -> p.getId().equals(productId))
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Product not found"));

        PriceStrategy strategy = priceStrategyFactory.getStrategy(store.getStoreType());
        StoreContext context = new StoreContext(store, strategy);

        return context.getFinalPrice(product.getPrice());
    }

    // Method responsible for creating a Store using the Factory pattern
    public Store createStoreFromFactory(String name, String type) {
        Store store = storeFactory.createStore(name, type);
        storeDB.put(store.getId(), store);
        return store;
    }
}
