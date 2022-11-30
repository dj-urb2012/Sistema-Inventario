/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.repuestostorres.invmanager;

import com.repuestostorres.invmanager.model.User;
import com.repuestostorres.invmanager.view.FrmInventory;
import com.repuestostorres.invmanager.view.FrmUser;
import com.repuestostorres.invmanager.view.NewUser;
import java.sql.SQLException;


/**
 *
 * @author Diego
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        FrmInventory frm = new FrmInventory();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }
    
}
