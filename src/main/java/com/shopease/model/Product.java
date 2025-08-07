package com.shopease.model;

import java.util.UUID;

import com.shopease.annotations.ImportantField;

// @DynamoDBDocument // Si deseas anidarlo en DynamoDB
public class Product {

    private String id;

    @ImportantField(description = "Product name visible to customers")
    private String name;
    
    @ImportantField(description = "Base price without discounts")
    private double price;

    public Product() {
        this.id = UUID.randomUUID().toString();
    }

    public Product(String name, double price) {
        this();
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}