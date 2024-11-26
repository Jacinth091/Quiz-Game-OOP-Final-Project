/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.AccountManager;

import backend.Database;
import backend.DatabaseManager;
import java.sql.SQLException;

/**
 *
 * @author PCC
 */
public class UserManager {
    private final DatabaseManager dbManager;
    public UserManager(DatabaseManager dbManager){
        this.dbManager = dbManager;
    }
    
    
    public void createUser (String userName, String userPass) throws SQLException{
        dbManager.insertUser(userName, userPass);

    }
    
}
