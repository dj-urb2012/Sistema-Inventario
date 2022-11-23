/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repuestostorres.invmanager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class BDConnection {
    private static final String SERVER = "localhost";
    private static final String USER = "sa";
    private static final String PASSWORD = "12345";
    private static final String DBNAME = "InventoryBD";
    private static final String PORT = "1433";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLSeverDriver";
    
    public Connection getConnection() {
        try {
            String connectionUrl = "jdbc::sqlserver://" + SERVER + ": " + PORT +
                    "; Databasename= " + DBNAME + "; user= " + USER + "; password= "
                    + PASSWORD + ";";
            Class.forName(DRIVER);
            return (DriverManager.getConnection(connectionUrl));
        } catch(ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void close(Connection conn) {
        try {
            conn.close();
        } catch(SQLException ex) {
            Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
