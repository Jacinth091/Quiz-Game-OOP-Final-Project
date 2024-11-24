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
    private String name = "admin", pass = "admin";

    private Connection connection;


   public String getUrl(){
       return this.url;
   }
    public String getUser(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    
    
    public void insertDataToTable(String userName, String userPassword)throws SQLException{
        String insertQuery = "INSERT INTO user (user_Name, user_Password) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, userPassword);

        int rowsInserted = preparedStatement.executeUpdate();

        if(rowsInserted > 0){
            System.out.println("Data is inserted Successfully");
        }

    }

    public boolean validateUserLogIn(String userName, String userPassword) throws SQLException {
    boolean auth = false;

    // Query to check for the existence of the username
    String selQuery = "SELECT user_Pass FROM user WHERE user_Name = ?";
    try {
        if (this.connection == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "Database connection is not established!");
            throw new NullPointerException("Database connection is null");
        }

        // Check if the username exists
        PreparedStatement preparedStatement = connection.prepareStatement(selQuery);
        preparedStatement.setString(1, userName);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            // Username exists; validate password
            String storedPassword = resultSet.getString("user_Pass");
            if (storedPassword.equals(userPassword)) {
                auth = true; // Successful login
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Incorrect password.");
            }
        } else {
            // Username does not exist
            javax.swing.JOptionPane.showMessageDialog(null, "Account not found!");
        }
    } catch (NullPointerException e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
    }

    return auth;
}

    private Database() throws SQLException {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // Optional for modern JDBC
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database successfully!");




        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            e.printStackTrace();
        }
    }

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



    public Connection getConnection() {
        return connection;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}
