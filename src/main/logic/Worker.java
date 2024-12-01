/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;

import backend.Database.DatabaseManager;
import backend.Database.DatabaseManagerCallback;


/**
 *
 * @author PCC
 */
public class Worker implements DatabaseManagerCallback{
    private DatabaseManager dbManagaer;
    
    public Worker(DatabaseManager dbManagaer){
        this.dbManagaer = dbManagaer;
    }
    
    
    
    
    @Override
    public void onFetchComplete(String msg){
        
    }
    
}
