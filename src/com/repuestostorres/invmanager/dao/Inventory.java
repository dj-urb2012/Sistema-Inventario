/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repuestostorres.invmanager.dao;

import com.repuestostorres.invmanager.models.Product;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author Diego
 */
public class Inventory {
    private HashMap<String, Product> allProducts = new HashMap<>();
    private float totalCost;
    private int numberOfProducts;
    ResultSet rs = null;

    public Inventory() {
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }
    
    public float calculateInventoryCost(){
        if(allProducts.isEmpty()) return 0;
        float sumOfCosts = 0;
        for(Product product : allProducts.values()) {
            sumOfCosts += product.calculateSubtotal();
        }
        this.totalCost = sumOfCosts;
        return sumOfCosts;
    }
    public void editProductStockValue(String id, int newStockValue) {
        this.allProducts.get(id).setStock(newStockValue);
    }
    public int calculateNumberOfProducts() {
        this.numberOfProducts = allProducts.size();
        return allProducts.size();
    }
    public void addProduct(Product product) {
        this.allProducts.put(product.getId(), product);
    }
    public void removeProduct(String id) {
        this.allProducts.remove(id);
    }
    public Product searchProduct(String id) {
        return allProducts.get(id);
    } 
}
