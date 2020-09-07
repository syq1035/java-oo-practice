package com.twu;

public class Admin {
    private String name = "admin";
    private String password = "123";

    public boolean verify(String name, String password) {
        if(name.equals(this.name) && password.equals(this.password)) {
            return true;
        }
        return false;
    }
}
