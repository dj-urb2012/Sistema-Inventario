/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repuestostorres.invmanager.model;

/**
 *
 * @author Diego
 */
public class User {

    private String loginName;
    private String passwd;
    private static boolean registered;

    public User() {
    }
    
    public User(String loginName, String passwd) {
        this.loginName = loginName;
        this.passwd = passwd;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPasswd() {
        return passwd;
    }
    
    public static boolean isRegistered() {
        return registered;
    }

    public static void setRegistered(boolean aRegistered) {
        registered = aRegistered;
    }
    
    public void createAccount() {
        
        //
    }
    public void verifyIfAccountIsCreated() {
        //
    }
    public void logout() {
        //
    }
    public void login() {
        //
    }
}
