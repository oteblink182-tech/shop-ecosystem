package com.shopease.model;

import java.util.UUID;

import com.shopease.annotations.ImportantField;

import io.swagger.v3.oas.annotations.media.Schema;

// @DynamoDBDocument // Si deseas anidarlo en DynamoDB
@Schema(description = "Represents a product entity")
public class Product {

    @Schema(description = "Unique identifier of the product", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Name of the product", example = "Laptop")
    @ImportantField(description = "Product name visible to customers")
    private String name;
    
    @Schema(description = "Price base of the product", example = "500000")
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