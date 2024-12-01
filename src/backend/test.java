/*
package backend;

import java.sql.*;
import java.util.*;

public class test{
    public static void main(String[] args) {
        // backend.Database connection details
        Database database = new Database();
        Scanner console = new Scanner(System.in);

        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(database.getUrl(), database.getUser(), database.getPassword());
            System.out.println("Connection successful!");

//            System.out.print("Enter name: ");
//            String name = console.nextLine();
//            System.out.println("Enter contact: ");
//            String contact = console.nextLine();
//            String query = "INSERT INTO player (player_name, player_contact) VALUES (?, ?)";
//            // SQL query to insert data
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            // Set values for placeholders
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, contact);
//
//            // Execute the query
//            int rowsInserted = preparedStatement.executeUpdate();
//            // Execute the query
//
//
//            // Check if the insertion was successful
//            if (rowsInserted > 0) {
//                System.out.println("Data inserted successfully!");
//            }
            String getQuery = "SELECT * FROM player";

            // Create a Statement object
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getQuery);

            // Check if there are any rows and print the result
            while (resultSet.next()) {
                String playerId = resultSet.getString("player_id");
                String playerName = resultSet.getString("player_name");
                String playerContact = resultSet.getString("player_contact");
                System.out.println("Player Id: " + playerId + ", Player Name: " + playerName + ", Player Contact: " + playerContact);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

//class Database{
//   private String url = "jdbc:mysql://localhost:3306/practice"; // Replace with your database name
//    private String user = "root"; // Default username for XAMPP
//    private String password = ""; // Default password is empty
//
//   Database(){
//       //default
//   }
//
//   public String getUrl(){
//       return this.url;
//   }
//    public String getUser(){
//        return this.user;
//    }
//    public String getPassword(){
//        return this.password;
//    }
//}*/
