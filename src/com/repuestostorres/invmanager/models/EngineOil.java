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
public class EngineOil extends Product{
    private String oilType;
    private String liquidVolume;
    public static ArrayList<SparePart> listItemss = new ArrayList<>();

    public EngineOil() {
    }

    public EngineOil(String oilType, String liquidVolume) {
        this.oilType = oilType;
        this.liquidVolume = liquidVolume;
    }

    public EngineOil(String oilType, String liquidVolume, String id, String name, double price, int amount, double subTotal) {
        super(id, name, price, amount, subTotal);
        this.oilType = oilType;
        this.liquidVolume = liquidVolume;
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public String getLiquidVolume() {
        return liquidVolume;
    }

    public void setLiquidVolume(String liquidVolume) {
        this.liquidVolume = liquidVolume;
    }
    
}
