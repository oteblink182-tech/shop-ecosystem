package com.shopease.controller;

import com.shopease.model.Product;
import com.shopease.util.ReflectionUtils;

public class controller {
    
    public static void main(String[] args) {
        Product product = new Product("Laptop Gamer", 1200.0);
        ReflectionUtils.inspectObject(product);
    }
}
