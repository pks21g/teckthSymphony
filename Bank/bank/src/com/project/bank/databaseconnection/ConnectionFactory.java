package com.project.bank.databaseconnection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public abstract class ConnectionFactory {
    private static Connection connection;

    public static Connection getConnection() {
        String resource = "resources/application.properties";

        try {
            FileInputStream read = new FileInputStream(resource);
            Properties pr = new Properties();

            pr.load(read);

            Class.forName(pr.getProperty("driverClass"));
            connection =
                    DriverManager.getConnection(pr.getProperty("url"),
                            pr.getProperty("uname"),
                            pr.getProperty("password"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection closeConnection(){

        try {
            connection.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


}
