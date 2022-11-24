/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repuestostorres.invmanager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Diego
 */
public class Database {
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        String connectionUrl = "jdbc:sqlserver://localhost:14433;"
                + "database=InventoryBD;"
                + "user=sa"
                + "password=1234"
                + "loginTimeout=30;";
        try { 
            connection = DriverManager.getConnection(connectionUrl);
            connection.setAutoCommit(true);
            return connection;
        } catch(SQLException ex) {
            System.out.println(ex.toString());
            return null;
        } finally {
            connection.close();
        }
    }
}
