/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repuestostorres.invmanager.model;

import com.repuestostorres.invmanager.database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diego
 */
public class User {

    private String loginName;
    private String passwd;
    private boolean registered;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public User() {
    }
    
    public boolean verifyAccount() throws SQLException {
        getUserData();
        boolean tieneCuenta = rs.getBoolean("isRegistered");
        return tieneCuenta;
    }
    
    public void getUserData() {
        try {
            this.conn = Conexion.getConnection();
            String tSQL = "SELECT * FROM User";
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT
                );
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener registros" + ex.getStackTrace());
        }
    } 
}
