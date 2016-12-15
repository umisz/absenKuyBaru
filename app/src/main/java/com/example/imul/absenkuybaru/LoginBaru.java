package com.example.imul.absenkuybaru;

/**
 * Created by Imul on 15-Dec-16.
 */

public class LoginBaru {
    String userName;
    String password;

    public LoginBaru() {

    }

    public LoginBaru(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
