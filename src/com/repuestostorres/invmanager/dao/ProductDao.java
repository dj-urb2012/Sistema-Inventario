/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.repuestostorres.invmanager.dao;

import com.repuestostorres.invmanager.model.Product;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public interface ProductDao {
    void insertProduct(Product product);
    ArrayList<Product> getAllProducts();
    Product getProductByName();
    Product getProdyById();
    void updateProduct();
    void deleteProduct();
    void saveProducts();
}
