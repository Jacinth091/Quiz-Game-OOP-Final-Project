/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;


import backend.DatabaseManager;
import javax.swing.Timer;
//import main.logic.GameTimer;

/**
 *
 * @author PCC
 */
public class SinglePlayerLogic{
    private DatabaseManager dbManager;
    private long totalGameTime =  10*60;
    private Timer timer;
    private long timeElapsedInSeconds;
    private long timerMinutes = 0;
    private long timerSeconds = 0;

    
    public SinglePlayerLogic(DatabaseManager dbManager){
        this.dbManager = dbManager;
        
        
    }
    
    
    
    
    
    
    
    
    
}
