/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repuestostorres.invmanager.models;

/**
 *
 * @author Diego
 */
public class User {

    public static boolean isIsRegistered() {
        return isRegistered;
    }
    private String loginName;
    private String passwd;
    private static boolean isRegistered;

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
    
    public void createAccount() {
        //
    }
    public void checkAccount() {
        //
    }
    public void closeSession() {
        //
    }
    public void login() { //boolean
        //
    }
}
