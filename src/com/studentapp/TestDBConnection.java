package com.studentapp;

import java.sql.Connection;

public class TestDBConnection {

    public static void main(String[] args) {
        System.out.println("Attempting to connect to the database...");
        
        // Call your static method to get a connection
        Connection connection = DBConnection.getConnection();
        
        if (connection != null) {
            System.out.println("✅ Success! Database connection established.");
            try {
                // Good practice to close the connection after testing
                connection.close();
                System.out.println("Connection closed.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("❌ Failure! Could not establish a database connection.");
            System.out.println("Check the following:");
            System.out.println("- Is MySQL running?");
            System.out.println("- Are the URL, USER, and PASSWORD correct?");
            System.out.println("- Have you added the MySQL JDBC Driver (Connector/J) to your project's Build Path?");
        }
    }
}