package com.project.bank.maindriver;


import com.project.bank.databaseconnection.ConnectionFactory;
import com.project.bank.models.Customer;
import com.project.bank.dao.CustomerDao;
import com.project.bank.service.AccountService;
import com.project.bank.service.DepositService;

import java.sql.*;
import java.util.Scanner;

public class Main {

        public static void main(String args[]) throws SQLException {

            Scanner scan = new Scanner(System.in);

            Customer customer;
            CustomerDao customerDao = new CustomerDao();
            AccountService as = new AccountService();

            double balance = 0;

            System.out.println("Enter 1 to open account");
            String userChoice = scan.nextLine();

            switch (userChoice){

                case "1":
                    System.out.print("First name: ");
                    String fname = scan.nextLine();
                    System.out.println("Last name: ");
                    String lname = scan.nextLine();
                    System.out.println("Email: ");
                    String email = scan.nextLine();
                    System.out.println("password: ");
                    String password = scan.nextLine();
                    System.out.println("Account Type: ");
                    String acType = scan.nextLine();
                    System.out.println("Enter deposit amount");
                    double initDepositAmount = scan.nextDouble();

                    customer = new Customer(fname, lname, acType, balance, initDepositAmount, email, password );

                    customerDao.openAccount(customer);


                    }

            }

        }

