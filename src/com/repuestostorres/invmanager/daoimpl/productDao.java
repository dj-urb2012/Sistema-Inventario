/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repuestostorres.invmanager.daoimpl;

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
public class productDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void getAllProducts() throws SQLException {
        try {
            conn = Conexion.getConnection();
            String tSQL = "SELECT * FROM Product";
            PreparedStatement ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT
            );
            rs = ps.executeQuery();
        } catch(SQLException ex) {
            System.out.println("Error al obtener registros: " + ex.getMessage());
        }
    }
    
    public boolean insertProduct(Product product) throws SQLException {
        boolean guardado = false;
        this.getAllProducts();
        try {
            rs.moveToInsertRow();
            rs.updateString("ProductID", product.getId());
            rs.updateString("Name", product.getName());
            rs.updateString("Brand", product.getBrand());
            rs.updateString("Category", product.getType());
            rs.updateFloat("Price", product.getPrice());
            rs.updateInt("Stock", product.getStock());
            rs.moveToCurrentRow();
            guardado = true;
        } catch (SQLException ex) {
            System.out.println("Error al guaradar autor: " + ex.getMessage());
        } finally {
            try { 
                if(rs != null) {
                    rs.close();
                }
                if(ps != null) {
                    ps.close();
                }
                if(conn != null) {
                    Conexion.closeConexion(conn);
                }
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return guardado;
    }

    public void clearDatabase() {

        Statement stmt;
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            String query = "DELETE FROM Product";
            int deletedRows = stmt.executeUpdate(query);
            if (deletedRows > 0) {
                System.out.println("Deleted All Rows In The Table Successfully");
            } else {
                System.out.println("Table already empty");
            }
            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

}
