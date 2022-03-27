package com.project.bank.service;

import com.project.bank.dao.CustomerDao;
import com.project.bank.models.Customer;
import com.project.bank.models.Login;
import com.project.bank.models.NewCustomerAccount;
import java.util.InputMismatchException;

public class AccountService {

    CustomerDao customerDao;
    public AccountService(CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    public void openNewCustomerAccount(NewCustomerAccount newCustomerAccount){

        Customer customer = newCustomerAccount.getCustomer();

        if(!isValidName(customer.getFirstName()))
            System.out.println("Invalid first");
        if (!isValidName(customer.getLastName()))
            System.out.println("Invalid last name");
        if (!isValidEmail(customer.getEmail()))
            System.out.println("Invalid email");
        if(!isValidName(customer.getPassword()))
            System.out.println("Invalid password");
        if(!isValidAccountType(customer.getAccountType()))
            System.out.println("Invalid account type");
        if (!isValidDeposit(customer.getDeposit()))
            System.out.println("Deposit needs to be positive value");
        if (!validateCustomer(customer))
            System.out.println("Bad customer details");

        if (customer.getAccountType().equalsIgnoreCase("c") &&
                customer.getDeposit() < 20) {
            System.out.println("deposit must be 20 or greater");
            return;
        }
        else if (customer.getAccountType().equalsIgnoreCase("s") &&
                customer.getDeposit() < 40 ) {
            System.out.println("deposit must be 40 or greater");
            return;
        }

        if(validateCustomer(customer)) {
            customerDao.insertAccountDetails(customer);
            System.out.println("New account created");
        }
    }

    public void loginRequest(Login login){
        Customer customer = login.ExtractLogin();
        if (!isValidEmail(login.getEmail()) ||
            !isValidName(login.getPassword())) {
            System.out.println("Invalid login details");
        }
        else {
            customerDao.getAccountDetails(customer);
        }
    }

    public boolean validateCustomer(Customer customer){
        return  (isValidName(customer.getFirstName()) &&
                isValidName(customer.getLastName()) &&
                isValidAccountType(customer.getAccountType()) &&
                isValidEmail(customer.getEmail()) &&
                isValidName(customer.getPassword()));
    }

    private boolean isValidName(String name){
        if (name == null) return false;
        return name.matches("^[a-zA-Z]{2,15}");
    }

    public static boolean isValidEmail(String email){
        if (email == null)
            return false;
        return email.matches("^[a-zA-Z0-9]{5,15}" +
                "[@]{1}" + "[a-zA-Z]{3,6}" +
                "[.]{1}" + "[a-zA-Z]{2,3}$");
    }
    public boolean isValidAccountType(String accountType){
        if (accountType == null) return false;
        return (accountType.equalsIgnoreCase("c") ||
                accountType.equalsIgnoreCase("s"));
    }

    // TODO: 3/27/22 proper validation fixing for deposit
    private boolean isValidDeposit(double dpst){
        double deposit = 0;
        try {
            deposit = dpst;
        }
        catch (InputMismatchException ex){

        }
        return deposit > 0;
    }
}
