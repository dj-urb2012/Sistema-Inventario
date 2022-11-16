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

    public static void setIsRegistered(boolean aIsRegistered) {
        isRegistered = aIsRegistered;
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

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
