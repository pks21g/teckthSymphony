package com.project.bank.maindriver;

import com.project.bank.dao.CustomerDao;
import com.project.bank.models.Login;
import com.project.bank.models.NewCustomerAccount;
import com.project.bank.service.AccountService;

import java.util.Scanner;

public class Main {

        public static void main(String args[]) {

            String fname  = "";
            String lname = "";
            String acType  = "";
            String email = "";
            String password  = "";
            String initDepositAmount = "";


            Scanner scan = new Scanner(System.in);

            NewCustomerAccount newCustomerAccount;
            CustomerDao cs = new CustomerDao();
            AccountService as = new AccountService(cs);

            System.out.println("Enter 1 to open account");
            String userChoice = scan.nextLine();

            switch (userChoice){

                case "1":
                    System.out.print("First name: ");
                    fname = scan.nextLine();
                    System.out.println("Last name: ");
                    lname = scan.nextLine();
                    System.out.println("Email: ");
                    email = scan.nextLine();
                    System.out.println("password: ");
                    password = scan.nextLine();
                    System.out.println("Account Type: ");
                    acType = scan.nextLine();
                    System.out.println("Enter deposit amount");
                    initDepositAmount = scan.nextLine();
                    double deposit = 0;
                    // TODO: 3/27/22 fix me in the validation class
                    try {
                        deposit = Double.parseDouble(initDepositAmount);
                    }
                    catch (NumberFormatException ex) {
                        System.out.println("Could not format given data");
                        return;
                    }

                    newCustomerAccount = new NewCustomerAccount(fname, lname, email, password, acType, deposit);
                    as.openNewCustomerAccount(newCustomerAccount);
                    break;
                case "2":
                    System.out.println("Email: ");
                    email = scan.nextLine();
                    System.out.println("password: ");
                    password = scan.nextLine();
                    Login login = new Login(email, password);
                    as.loginRequest(login);
                    System.out.println("Enter amount to deposit");
                    double amount = scan.nextDouble();

                    }

            }

        }

