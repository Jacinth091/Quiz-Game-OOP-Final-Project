/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Database;
import java.sql.*;
/**
 *
 * @author PCC
 */
public class Database {
    private static Database instance;
    private String url = "jdbc:mysql://localhost:3306/quizgamedb"; // Replace with your database name
    private String username = "root"; // Default username for XAMPP
    private String password = ""; // Default password is empty

    private Connection connection;

    private Database() throws SQLException{
          try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // Optional for modern JDBC
            this.connection = openConnection(); 
            System.out.println("Connected to the database successfully!");

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            e.printStackTrace();
        }}
    
    
    public static Database getInstance() throws SQLException {
        synchronized (Database.class) { // Thread-safe initialization
            if (instance == null) {
                instance = new Database();
                
            }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            openConnection(); // Reopen the connection if it's null or closed
        }
        return connection;
    }

    public Connection openConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}



