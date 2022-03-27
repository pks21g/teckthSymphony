package com.project.bank.models;

public class Deposit {
    String email;
    String password;
    double deposit;

    public Deposit(String email, String password, double deposit) {
        this.email = email;
        this.password = password;
        this.deposit = deposit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }
    public Customer extractDeposit(){
        return new Customer(email, password, deposit);
    }
}
