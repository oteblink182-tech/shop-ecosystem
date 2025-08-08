package com.shopease.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;


// @DynamoDBTable(tableName = "Store") // → Si usaras DynamoDB real
@Schema(description = "Represents a store entity")
public class Store {
    
    @Schema(description = "Unique identifier of the store", example = "e51ec63e-b6f6-457d-b671-5447045abdf6")
    private String id;

    @Schema(description = "Name of the store", example = "Tech Store")
    private String name;
    
    @Schema(description = "Type of the store", example = "BASIC")
    private String storeType;

    @Schema(description = "List of products available in the store")
    private List<Product> products = new ArrayList<>();

    public Store(){
        this.id = UUID.randomUUID().toString();
    }

    public Store(String name){
        this();
        this.name = name;
    }

    // @DynamoDBHashKey(attributeName = "id") // → DynamoDB
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // @DynamoDBAttribute(attributeName = "storeType")
    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    // @DynamoDBIgnore // o manejo personalizado para relaciones
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
