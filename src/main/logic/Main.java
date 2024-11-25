package main.logic;

import backend.Database;
import backend.Helper;

import java.sql.SQLException;
import main.ui.SignIn;
import backend.Database;
import backend.DatabaseManager;
import backend.Helper;
import backend.AccountManager.LogInManager;
import backend.AccountManager.UserManager;

public class Main {
    public static void main(String[] args){
        
        DatabaseManager dbManager = new DatabaseManager();


   java.awt.EventQueue.invokeLater(() -> {
            try {
                // Pass dbManager to the SignIn form
                new App(dbManager).start();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                dbManager.closeConnection(); // Ensure the connection is closed properly
            }
        });
    }



}
