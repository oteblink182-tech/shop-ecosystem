package com.shopease.antipattern;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.shopease.model.Product;
import com.shopease.model.Store;

/**
 * ANTIPATTERN: GOD OBJECT
 *
 * This class represents an antipattern because it mixes multiple responsibilities:
 * - Store management
 * - Product management
 * - Revenue calculation
 * - Report generation
 * - Backup operations
 *
 * ➤ This violates the principle of separation of concerns.
 * ➤ It complicates unit testing and makes the system harder to maintain and scale.
 * ➤ This illustrates a clear case of high coupling and low cohesion between components.
 */
public class StoreGodService {
    
    private final Map<String, Store> storeDB = new HashMap<>();

    // Esta clase hace TODO: lógica de tienda, productos, usuarios, reportes, y más

    public Store createStore(String name, String type) {
        Store store = new Store(name);
        store.setStoreType(type);
        storeDB.put(store.getId(), store);
        return store;
    }

    public Product createProduct(String storeId, String productName, double price) {
        Store store = storeDB.get(storeId);
        if (store == null) {
            throw new NoSuchElementException("Tienda no encontrada");
        }
        Product product = new Product(productName, price);
        store.getProducts().add(product);
        return product;
    }

    public double calculateRevenue(String storeId) {
        Store store = storeDB.get(storeId);
        return store.getProducts()
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void generateMonthlyReport(String storeId) {
        // Simulación de generación de reporte
        System.out.println("Generando reporte para tienda " + storeId);
    }

    public void backupStoreData(String storeId) {
        // Simulación de backup
        System.out.println("Backup ejecutado para " + storeId);
    }
}
// How can this be improved?
// This class should be split into at least three services:
// - StoreService (for store management)
// - ProductService (for product handling)
// - ReportService (for calculations and reporting)
// Each with its own interface and single responsibility.