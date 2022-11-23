/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repuestostorres.invmanager.dao;

import com.repuestostorres.invmanager.models.ProductRecord;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class InventoryFlow {
    private ArrayList<ProductRecord> productsOut = new ArrayList<>();
    private ArrayList<ProductRecord> productsIn = new ArrayList<>();
    private float totalIn;
    private float totalOut;
    

    public InventoryFlow() {
    }

    public float getTotalAmountIn() {
        return totalIn;
    }

    public void setTotalAmountIn(float totalAmountIn) {
        this.totalIn = totalAmountIn;
    }

    public float getTotalAmountOut() {
        return totalOut;
    }

    public void setTotalAmountOut(float totalAmountOut) {
        this.totalOut = totalAmountOut;
    }

    public void addProductRecord(ProductRecord productRecord) {
        if("In".equals(productRecord.getRecordType())) 
            this.productsIn.add(productRecord);
        else this.productsOut.add(productRecord);
    }
    
    public float calculateTotalOut() {
        float sumOfCosts = 0;
        for(ProductRecord productRecord : productsOut) {
            sumOfCosts += productRecord.calculateTotal();
        }
        this.totalOut = sumOfCosts;
        return sumOfCosts;
    }
    private float calculateTotalIn() {
        float sumOfCosts = 0;
        for(ProductRecord productRecord : productsIn) {
            sumOfCosts += productRecord.calculateTotal();
        }
        this.totalIn = sumOfCosts;
        return sumOfCosts;
    }
}
