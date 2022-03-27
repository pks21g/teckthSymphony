package com.project.bank.models;

public class NewCustomerAccount {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String accountType;
    private double deposit;

    public NewCustomerAccount(){
        super();
    }

    public NewCustomerAccount(String firstName, String lastName, String email, String password, String accountType, double deposit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.deposit = deposit;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Customer getCustomer(){
        return new Customer(firstName, lastName,  email, password, accountType, deposit);
    }

    @Override
    public String toString() {
        return "NewCustomer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
