/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
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
        if (instance == null) {
            synchronized (Database.class) { // Thread-safe initialization
                if (instance == null) {
                    instance = new Database();

                }
            }
        }
        return instance;
    }

    public Connection openConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }
    
   public String getUrl(){
       return this.url;
   }
    public String getUser(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    


    public Connection getConnection() {
        return connection;
    }

}
