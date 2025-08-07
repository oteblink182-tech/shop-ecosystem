package com.shopease.controller;

import com.shopease.model.Product;
import com.shopease.model.Store;
import com.shopease.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {
    
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        return ResponseEntity.ok(storeService.createStore(store));
    }

    @GetMapping
    public ResponseEntity<List<Store>> getAllStores() {
        return ResponseEntity.ok(storeService.getAllStores());
    }

    @PostMapping("/{storeId}/products")
    public ResponseEntity<Product> addProduct(
            @PathVariable String storeId,
            @RequestBody Product product) {
        return ResponseEntity.ok(storeService.addProductToStore(storeId, product));
    }

    @GetMapping("/{storeId}/products")
    public ResponseEntity<List<Product>> getProducts(
            @PathVariable String storeId) {
        return ResponseEntity.ok(storeService.getProductsByStore(storeId));
    }

    @GetMapping("/{storeId}/products/{productId}/price")
    public ResponseEntity<Double> getFinalPrice(
            @PathVariable String storeId,
            @PathVariable String productId) {
        double finalPrice = storeService.calculateFinalPrice(storeId, productId);
        return ResponseEntity.ok(finalPrice);
    }

    @PostMapping("/factory")
    public ResponseEntity<Store> createStoreWithFactory(
            @RequestParam  String name,
            @RequestParam  String type) {
        return ResponseEntity.ok(storeService.createStoreFromFactory(name, type));
    }
}
