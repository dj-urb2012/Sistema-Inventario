/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.repuestostorres.invmanager.dao;

import com.repuestostorres.invmanager.model.ProductRecord;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public interface ProductRecordDao {
    void insertProductRecords();
    ArrayList<ProductRecord> getAllProductRecords();
    void updateProductRecords();
    void deleteProductRecords();
    void deleteAllProductRecords();
    void saveProductRecord();
}
