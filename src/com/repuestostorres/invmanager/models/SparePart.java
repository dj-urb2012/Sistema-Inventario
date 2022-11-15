/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repuestostorres.invmanager.models;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class SparePart extends Product{
    private String brand;
    private String type;    
    public static ArrayList<SparePart> listItems = new ArrayList<>();
    
    public SparePart() {
    }

    public SparePart(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public SparePart(String brand, String type, String id, String name, double price, int amount, double subTotal) {
        super(id, name, price, amount, subTotal);
        this.brand = brand;
        this.type = type;
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
    
}
