/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PCC
 */
public class DatabaseManager {
    
    private Database db;
    
    
    public DatabaseManager() {
          try{
            this.db = Database.getInstance();
          
          }catch(SQLException e){
              e.printStackTrace();
          }
    }
    


    // Insert a new user into the database
    public void insertUser(String userName, String userPassword) throws SQLException {
        String insertQuery = "INSERT INTO user (user_Name, user_Pass) VALUES (?, ?)";

        try (Connection connection = db.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPassword);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;  // Propagate the SQLException
        }
    }

    // Validate login credentials
    public boolean validateLogin(String userName, String userPassword) throws SQLException {
        boolean isValid = false;
        String selQuery = "SELECT user_Pass FROM user WHERE user_Name = ?";

        try (Connection connection = db.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selQuery)) {
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("user_Pass");
                isValid = storedPassword.equals(userPassword);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;  // Propagate the SQLException
        }

        return isValid;
    }
//    
//    public boolean validateUsername(){
//        boolean isUnique = false;
//        
//        String query = "SELECT user_Name FROM user";
//        
//        try(Connection connection = db.openConnection()){
//            PreparedStatement pState = connection.pState(query);
//            ResultSet reSet = pState.executeQuery();
//            
//            
//        }
//        
//        
//    }

    // Other CRUD operations (example: read all users)
    public void displayAllUsers() throws SQLException {
        String query = "SELECT * FROM user";
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String userName = resultSet.getString("user_Name");
                String userPassword = resultSet.getString("user_Pass");
                System.out.println("Username: " + userName + ", Password: " + userPassword);
            }
        }
    }
    
    public void testConnection() {
        try (Connection connection = db.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                System.out.println("DatabaseManager: Successfully connected to the database!");
            } else {
                System.out.println("DatabaseManager: Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DatabaseManager: Error while testing the connection.");
        }
    }
    
    public void closeConnection() {
        if (db.getConnection() != null) {
            try {
                db.getConnection().close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Failed to close database connection.");
                e.printStackTrace();
            }
        }
    }

}
