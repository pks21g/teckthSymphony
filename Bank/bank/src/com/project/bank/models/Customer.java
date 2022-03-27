package com.project.bank.models;

public class Customer {

    private int userId;
    private String firstName;
    private String lastName;
    private String accountType;
    private double balance;
    private double deposit;
    private String email;
    private String password;

    public Customer(){
        super();
    }

    public Customer(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Customer(String email, String password, double deposit) {
        this.email = email;
        this.password = password;
        this.deposit = deposit;
    }

    public Customer(String firstName, String lastName, String email, String password, String accountType, double deposit) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.accountType = accountType;
        this.email = email;
        this.password = password;
        this.deposit = deposit;
    }

    public Customer(String firstName, String lastName , String email, String password, String accountType, double deposit,  double balance) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.accountType = accountType;
        this.deposit = deposit;
        this.balance = balance;
        this.email = email;
        this.password = password;
    }

    public Customer(int userId, String firstName, String lastName, String email, String password, String accountType, double deposit, double balance) {

        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountType = accountType;
        this.deposit = deposit;
        this.balance = balance;
        this.email = email;
        this.password = password;
    }

    public int getUserId(){
        return this.userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance + deposit;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
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

    @Override
    public String toString() {
        return "Customer:" +
                userId +
                "," + firstName +
                "," + lastName +
                "," + email +
                "," + password +
                "," + accountType +
                "," + deposit +
                "," + balance;
    }
}
