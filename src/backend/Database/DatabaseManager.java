/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Database;

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
    private static DatabaseManager instance;
    private Database db;
    private DatabaseManagerCallback dbManCallback;
    
    
    public DatabaseManager() {
          try{
            this.db = Database.getInstance();
          
          }catch(SQLException e){
              e.printStackTrace();
          }
    }
    
    
    public void setCallback(DatabaseManagerCallback callback){
        this.dbManCallback = callback;
    }
    
    public static synchronized DatabaseManager getInstance(){
        if(instance == null){
            instance = new DatabaseManager();
        }
        return instance;
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
    
    public boolean validateLogin(Connection connection, String userName, String userPassword) throws SQLException {
        boolean isValid = false;
        String selQuery = "SELECT user_Pass FROM user WHERE user_Name = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selQuery)) 
        {
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

    public String getUserId(Connection connection, String userName) throws SQLException{
        String userId = "";
        String query = "SELECT user_Id FROM user WHERE user_Name = ?";
        
        try(PreparedStatement prepStatement = connection.prepareStatement(query)){
            prepStatement.setString(1, userName);
            ResultSet resultSet = prepStatement.executeQuery();

            if(resultSet.next()){
                userId = resultSet.getString("user_Id");
            }


        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return userId; 
    }
        
    public boolean checkIfUserHasPlayerAcc(Connection connection, String userName) throws SQLException{
        boolean flag = false;
        String query = "SELECT player_Id FROM player WHERE user_Id = ?";
        String userID, playerID;
        try(PreparedStatement prepStatement = connection.prepareStatement(query)){
                        
            userID  = getUserId(connection, userName);
            prepStatement.setString(1, userID);
            ResultSet resultSet = prepStatement.executeQuery();

            if(resultSet.next()){
                playerID = resultSet.getString("player_Id");
                System.out.println("Player ID: " + playerID);
                flag = true;
            }
            else{
                flag = false;
            }

            
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
        
        return flag;

        
    }
    
    public boolean createPlayerAccount(Connection connection, String playerName, String userId){
        boolean flag = false;
        String query = "INSERT INTO player (player_Name, user_Id, singlePlay_HighScore, multiPlay_HighScore) VALUES (?,?,?,?) ";
        try(PreparedStatement prepStatement = connection.prepareStatement(query)){
            prepStatement.setString(1, playerName);
            prepStatement.setString(2, userId);
            prepStatement.setString(3, "0");
            prepStatement.setString(4, "0");

            int rowsAffected = prepStatement.executeUpdate();
            if(rowsAffected > 0){
                flag = true;
            }
            else{
                flag = false;
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return flag;

    }
    
    
    public String[] getPlayerAccount(Connection connection, String userId) throws SQLException{
        String[] data = null;
        String query = "SELECT * FROM player WHERE user_Id = ?";
        try(PreparedStatement prepStatement = connection.prepareStatement(query)){
            prepStatement.setString(1, userId);
            ResultSet resultSet = prepStatement.executeQuery();
            
            if(resultSet.next()){
                String playerID = resultSet.getString("player_Id");
                String playerName = resultSet.getString("player_Name");
                String singleHighScore = resultSet.getString("singlePlay_HighScore");
                String multiHighScore = resultSet.getString("multiPlay_HighScore");

                data = new String[] {
                    playerID, playerName, singleHighScore, multiHighScore
                };
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return data;
    }
    
    public boolean insertScoreLeaderboards(Connection connection, String playerId, int score){
        boolean flag = false;
        String query = "INSERT INTO leaderboards (player_id player_Score, ) VALUE (?,?)";
        try(PreparedStatement prepStatement = connection.prepareStatement(query)){
            prepStatement.setString(1,playerId); 
//            prepStatement.setString(2,playerName);
            prepStatement.setString(2,String.valueOf(score));
            
            int rowsAffected = prepStatement.executeUpdate();
            if(rowsAffected > 0){
                flag = true;
            }
            else{
                flag = false;
            }


        }
        catch(SQLException e){
            e.printStackTrace();

        }
        
        return flag;
    }
    
    
    
    
    // Other CRUD operations (example: read all users)
    public void displayAllUsers() throws SQLException {
        String query = "SELECT * FROM user";
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String userID = resultSet.getString("user_Id");
                String userName = resultSet.getString("user_Name");
                String userPassword = resultSet.getString("user_Pass");
                System.out.println("UserId: "+userID + " Username: " + userName + ", Password: " + userPassword);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw e;  // Propagate the SQLException
        }

    }
    
    public void displayAllUsers(Connection connection) throws SQLException {
        String query = "SELECT * FROM user";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String userID = resultSet.getString("user_Id");
                String userName = resultSet.getString("user_Name");
                String userPassword = resultSet.getString("user_Pass");
                System.out.println("UserId: "+userID + " Username: " + userName + ", Password: " + userPassword);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw e;  // Propagate the SQLException
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
        
        try(Connection connection = db.getConnection())
        {
            if ( connection != null) {
                try {
                    db.getConnection().close();
                    System.out.println("Database connection closed.");
                } catch (SQLException e) {
                    System.err.println("Failed to close database connection.");
                    e.printStackTrace();
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        
        
  
    }

    public Database getDb() {
        return db;
    }

    
    
    
}

