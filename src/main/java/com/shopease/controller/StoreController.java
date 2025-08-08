package com.shopease.controller;

import com.shopease.model.Product;
import com.shopease.model.Store;
import com.shopease.service.StoreService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Store Controller", description = "Operations related to stores")
@RestController
@RequestMapping("/stores")
public class StoreController {
    
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }
    
    @Operation(summary = "Create a new store")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Store created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid store data")
    })
    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        return ResponseEntity.ok(storeService.createStore(store));
    }

    @Operation(summary = "Retrieve all stores")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of stores returned"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<Store>> getAllStores() {
        return ResponseEntity.ok(storeService.getAllStores());
    }

    @Operation(summary = "Add a product to a specific store")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product added to store"),
        @ApiResponse(responseCode = "404", description = "Store not found")
    })
    @PostMapping("/{storeId}/products")
    public ResponseEntity<Product> addProduct(
            @PathVariable String storeId,
            @RequestBody Product product) {
        return ResponseEntity.ok(storeService.addProductToStore(storeId, product));
    }

    @Operation(summary = "Get all products from a specific store")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of products returned"),
        @ApiResponse(responseCode = "404", description = "Store not found")
    })
    @GetMapping("/{storeId}/products")
    public ResponseEntity<List<Product>> getProducts(
            @PathVariable String storeId) {
        return ResponseEntity.ok(storeService.getProductsByStore(storeId));
    }

    @Operation(summary = "Calculate the final price of a product in a store using pricing strategy")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Final price calculated"),
        @ApiResponse(responseCode = "404", description = "Store or product not found")
    })
    @GetMapping("/{storeId}/products/{productId}/price")
    public ResponseEntity<Double> getFinalPrice(
            @PathVariable String storeId,
            @PathVariable String productId) {
        double finalPrice = storeService.calculateFinalPrice(storeId, productId);
        return ResponseEntity.ok(finalPrice);
    }

    @Operation(summary = "Create a store using Factory Pattern")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Store created via factory"),
        @ApiResponse(responseCode = "400", description = "Invalid store type or name")
    })
    @PostMapping("/factory")
    public ResponseEntity<Store> createStoreWithFactory(
            @RequestParam  String name,
            @RequestParam  String type) {
        return ResponseEntity.ok(storeService.createStoreFromFactory(name, type));
    }
}
