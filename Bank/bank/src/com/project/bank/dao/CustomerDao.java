package com.project.bank.dao;

import com.project.bank.databaseconnection.ConnectionFactory;
import com.project.bank.models.Customer;
import com.project.bank.models.Deposit;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CustomerDao {

    Customer customer;

    private boolean ifUserExists(String email){

        try {
            Statement st = ConnectionFactory.getConnection().createStatement();
            String query = " select * from customer where email like '" +email+"' ";
            ResultSet rs = st.executeQuery(query);
            if (rs.next())
                return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public void insertAccountDetails(Customer customer) {

            try {

                String insertUser = "insert into customer (first_name, last_name, account_type, balance, deposit, email, password) values (?,?,?,?,?,?,?)";
                PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(insertUser);

                if (!ifUserExists(customer.getEmail())) {
                    ps.setString(1, customer.getFirstName());
                    ps.setString(2, customer.getLastName());
                    ps.setString(3, customer.getAccountType());
                    ps.setDouble(4, customer.getBalance());
                    ps.setDouble(5, customer.getDeposit());
                    ps.setString(6, customer.getEmail());
                    ps.setString(7, customer.getPassword());

                    int row = ps.executeUpdate();

                    if (row == 1)
                        System.out.println(row + " insert successful");
                    else
                        System.out.println("Could not save data");
                } else {
                    System.out.println("User with " + customer.getEmail() + " already exists");
                }
                ConnectionFactory.closeConnection();

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void getAccountDetails(Customer customer){
        try {
            Statement st = ConnectionFactory.getConnection().createStatement();
            String query = " select * from customer where email like '" +customer.getEmail()+"' ";
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                System.out.println("Login Successful " + ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()));
                int id = rs.getInt(1);
                String acType = rs.getString(4);
                double balance = rs.getDouble(5);
                System.out.println("ID: " + id + "\nAccount Type: " + acType +
                        "\nBalance: " + balance);
            }
            else{
                System.out.println("Account does not exist");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getCustomer(){

        try {
            Statement st = ConnectionFactory.getConnection().createStatement();
            String query = "select * from customer";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
               int id = rs.getInt(1);
               String fname = rs.getString(2);
               String lname = rs.getString(3);
               String acType = rs.getString(4);
               double balance = rs.getDouble(5);
               double amount = rs.getDouble(6);
               String email = rs.getString(7);
               String password = rs.getString(8);
               customer = new Customer(id, fname, lname, acType, email, password, amount, balance);
                System.out.println(customer);
            }
            ConnectionFactory.closeConnection();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
