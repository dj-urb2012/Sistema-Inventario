/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repuestostorres.invmanager.models;

/**
 *
 * @author Diego
 */
public class ProductRecord {
    private String name;
    private String brand;
    private String recordType;
    private int numberOfProducts;
    private float price;

    public ProductRecord() {
    }

    public ProductRecord(String name, String brand, String recordType, int numberOfProducts, float price) {
        this.name = name;
        this.brand = brand;
        this.recordType = recordType;
        this.numberOfProducts = numberOfProducts;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public float calculateTotal() {
        return numberOfProducts * price;
    }
}