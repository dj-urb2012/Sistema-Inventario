/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repuestostorres.invmanager.models;

import java.util.HashMap;

/**
 *
 * @author Diego
 */
public class Inventory {
    HashMap<String, Product> allProducts = new HashMap<>();
    
    private float calcultateInventoryCost(){
        float totalCost = 0;
        for(Product product : allProducts.values()){
            totalCost += totalCost + product.calculateSubtotal();
        }
        return totalCost;
    }
}
