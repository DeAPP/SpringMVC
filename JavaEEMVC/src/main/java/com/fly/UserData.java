package com.fly;


public class UserData {
    private String authName;
    public String getAuthName() {
        return authName;
    }
    public void setAuthName(String authName) {
        this.authName = authName;
    }
    @Override
    public String toString() {
        return "UserData{" +
                "authName='" + authName + '\'' +
                '}';
    }
}
