/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repuestostorres.invmanager.daoimpl;

import com.repuestostorres.invmanager.dao.ProductDao;
import com.repuestostorres.invmanager.database.Conexion;
import com.repuestostorres.invmanager.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ProductDaoImpl implements ProductDao {
    private Connection conn = null;

    @Override
    public void insertProduct(Product product) {
        try {
            
            conn = Conexion.getConnection();
            String statement = "INSERT INTO Products (idProduct, productName, productBrand, productType, productPrice, productStock)"
                    + " VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setString(1, product.getId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getBrand());
            ps.setString(4, product.getType());
            ps.setFloat(5, product.getPrice());
            ps.setInt(6, product.getStock());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> allProducts = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            String tSQL = "SELECT * FROM Products";
            PreparedStatement ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                        rs.getString("idProduct"),
                        rs.getString("productName"),
                        rs.getString("productBrand"),
                        rs.getString("productType"),
                        rs.getFloat("productPrice"),
                        rs.getInt("productStock")
                );
                allProducts.add(product);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allProducts;
    }

    @Override
    public void clearDatabase() {
        
        Statement stmt;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            String query = "DELETE FROM Products";
            int deletedRows = stmt.executeUpdate(query);
            if (deletedRows > 0) {
                System.out.println("Deleted All Rows In The Table Successfully");
            } else {
                System.out.println("Table already empty");
            }
            conn.close();
            stmt.close();
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        }
    }

}
