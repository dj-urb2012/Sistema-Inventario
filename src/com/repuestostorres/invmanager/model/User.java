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

    public User(String loginName, String passwd, boolean registered) {
        this.loginName = loginName;
        this.passwd = passwd;
        this.registered = registered;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }
    
    public boolean verifyAccount() throws SQLException {
        getUserData();
        return true;
    }
    
    public void getUserData() {
        try {
            conn = Conexion.getConnection();
            String tSQL = "Select * from User";
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
