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
    private String type;
    private int amount;
    private float cost;

    public ProductRecord() {
    }

    public ProductRecord(String name, String brand, String type, int amount, float cost) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.amount = amount;
        this.cost = cost;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    public float calculateCost() {
        return amount * cost;
    }
}
