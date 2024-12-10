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
import main.PlayerData.Single;

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
        String query = "INSERT INTO player (player_Name, user_Id, highScore) VALUES (?,?,?) ";
        try(PreparedStatement prepStatement = connection.prepareStatement(query)){
            prepStatement.setString(1, playerName);
            prepStatement.setString(2, userId);
            prepStatement.setString(3, "0");

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
                String singleHighScore = resultSet.getString("highScore");

                data = new String[] {
                    playerID, playerName, singleHighScore
                };
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return data;
    }
    
    public Single getPlayerDetails(Connection connection, String user_Id)throws SQLException{
        Single player = null;
        
        try{
            String[] data = getPlayerAccount(connection, user_Id);
            
            player = new Single(data[0], data[1], Integer.parseInt(data[2]));
            
        }catch(SQLException e){
            e.printStackTrace();
        }

        return player;
    }
    
    public void updatePlayerName(String playerId, String newPlayerName) {
        String updatePlayerSQL = "UPDATE player SET player_Name = ? WHERE player_Id = ?";
        String updateLeaderboardSQL = "UPDATE leaderboard SET playerName = ? WHERE player_Id = ?";

        try (Connection conn = Database.getInstance().getConnection()) {
            if (conn != null) {
                // Update the player name in the player table
                PreparedStatement updatePlayerStatement = conn.prepareStatement(updatePlayerSQL);
                updatePlayerStatement.setString(1, newPlayerName);
                updatePlayerStatement.setInt(2, Integer.parseInt(playerId));
                int rowsUpdated = updatePlayerStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Player name updated successfully.");

                    // Synchronize the leaderboard table
                    PreparedStatement updateLeaderboardStatement = conn.prepareStatement(updateLeaderboardSQL);
                    updateLeaderboardStatement.setString(1, newPlayerName);
                    updateLeaderboardStatement.setInt(2, Integer.parseInt(playerId));
                    updateLeaderboardStatement.executeUpdate();

                    System.out.println("Leaderboard updated with new player name.");
                } else {
                    System.out.println("No matching player found. Update failed.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    
    public void updateScoreInLeaderboard(String playerId, int newScore) {
     String selectPlayerSQL = "SELECT highScore FROM player WHERE player_Id = ?";
     String updatePlayerSQL = "UPDATE player SET highScore = ? WHERE player_Id = ?";
     String selectLeaderboardSQL = "SELECT score FROM leaderboard WHERE player_Id = ?";
     String updateLeaderboardSQL = "UPDATE leaderboard SET score = ? WHERE player_Id = ?";
     String insertToLeaderboardSQL = "INSERT INTO leaderboard (player_Id, playerName, score) " +
                                      "SELECT player_Id, player_Name, ? FROM player WHERE player_Id = ?";

     try (Connection conn = Database.getInstance().getConnection()) {
         if (conn != null) {
             // Step 1: Check the current high score in the player table
             PreparedStatement selectPlayerStatement = conn.prepareStatement(selectPlayerSQL);
             selectPlayerStatement.setInt(1, Integer.parseInt(playerId));
             ResultSet playerResultSet = selectPlayerStatement.executeQuery();

             if (playerResultSet.next()) {
                 int currentHighScore = playerResultSet.getInt("highScore");

                 if (newScore > currentHighScore) {
                     // Step 2: Update the player's high score in the player table
                     PreparedStatement updatePlayerStatement = conn.prepareStatement(updatePlayerSQL);
                     updatePlayerStatement.setInt(1, newScore);
                     updatePlayerStatement.setInt(2, Integer.parseInt(playerId));
                     int rowsUpdated = updatePlayerStatement.executeUpdate();

                     if (rowsUpdated > 0) {
                         System.out.println("Successfully updated the high score for player ID: " + playerId);

                         // Step 3: Check if the player exists in the leaderboard
                         PreparedStatement selectLeaderboardStatement = conn.prepareStatement(selectLeaderboardSQL);
                         selectLeaderboardStatement.setInt(1, Integer.parseInt(playerId));
                         ResultSet leaderboardResultSet = selectLeaderboardStatement.executeQuery();

                         if (leaderboardResultSet.next()) {
                             // Step 4a: Update the score in the leaderboard
                             PreparedStatement updateLeaderboardStatement = conn.prepareStatement(updateLeaderboardSQL);
                             updateLeaderboardStatement.setInt(1, newScore);
                             updateLeaderboardStatement.setInt(2, Integer.parseInt(playerId));
                             updateLeaderboardStatement.executeUpdate();
                             System.out.println("Leaderboard updated for player ID: " + playerId);
                         } else {
                             // Step 4b: Insert a new record into the leaderboard
                             PreparedStatement insertLeaderboardStatement = conn.prepareStatement(insertToLeaderboardSQL);
                             insertLeaderboardStatement.setInt(1, newScore);
                             insertLeaderboardStatement.setInt(2, Integer.parseInt(playerId));
                             insertLeaderboardStatement.executeUpdate();
                             System.out.println("New leaderboard entry created for player ID: " + playerId);
                         }
                     } else {
                         System.out.println("Failed to update the player's high score.");
                     }
                 } else {
                     System.out.println("New score is not higher than the current high score. No update performed.");
                 }
             } else {
                 System.out.println("Player not found in the player table.");
             }
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
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

