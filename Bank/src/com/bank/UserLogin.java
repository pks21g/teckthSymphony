package com.bank;

public abstract class UserLogin {

    private String userName;
    private String password;
    private String userId;

    public UserLogin(){
        this.userName = getUserName();
        this.password = getPassword();
    }

    public UserLogin (String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
