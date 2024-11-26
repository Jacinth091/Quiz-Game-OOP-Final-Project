/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;

import backend.Database;
import backend.DatabaseManager;
import backend.Helper;
import backend.AccountManager.LogInManager;
import backend.AccountManager.UserManager;

import main.ui.SignIn;



import java.sql.SQLException;

/**
 *
 * @author PCC
 */
public class App {
    
   private Helper util;
   private DatabaseManager dbManager ;
    
    public App(DatabaseManager dbManager){
        this.dbManager = dbManager;
        util = new Helper();
    }
    
    
    public void start() throws SQLException{

        if(dbManager.validateLogin("admin", "admin123")){
            System.out.println("Admin Account Already Exists!");
        }
        else{
            UserManager admin = new UserManager(dbManager);
            admin.createUser("admin", "admin123");
            

        }
        new SignIn(dbManager).setVisible(true);
        

    }
    
    public void initObjects() throws NullPointerException{
    
    
    
    }
    
    
}


