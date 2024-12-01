/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.AccountManager;

import backend.Database.Database;
import backend.Database.DatabaseManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author PCC
 */
public class LogInManager {
    private final DatabaseManager dbManager;
    public LogInManager(DatabaseManager dbManager){
        this.dbManager = dbManager;
    }
    
    
    public boolean logInUser(String userName, String userPass) throws SQLException{
        return dbManager.validateLogin(userName, userPass);
    }
        public boolean logInUser(Connection connection, String userName, String userPass) throws SQLException{
        return dbManager.validateLogin(connection, userName, userPass);
    }
    
}
