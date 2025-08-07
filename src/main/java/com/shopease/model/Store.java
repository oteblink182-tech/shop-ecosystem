package com.shopease.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


// @DynamoDBTable(tableName = "Store") // → Si usaras DynamoDB real
public class Store {
    
    private String id;
    private String name;
    private String storeType;
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
