/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;

import backend.Database.DatabaseManager;
import backend.Images;
import main.PlayerData.Session;

/**
 *
 * @author PCC
 */
public class AppContext {
    private static AppContext instance;
    private MainThread gameThread;
    private DatabaseManager dbManager;
    private Session session;
    private GameLogic gameLogic;
    private Images imgs;
    
    private GameEnums.GameMode gameMode;
    private GameEnums.GameState gameState;
    
    private AppContext(){

        gameThread = MainThread.getInstance();
        gameState = gameThread.getGameState();
        gameThread.startThread();
        
        
              // Add a shutdown hook to stop the thread safely
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (gameThread != null) {
                gameThread.stopThread();
            }
        }));
    }
    

    public static synchronized AppContext getInstance(){
        if(instance == null){
            instance = new AppContext();
        }

        return instance;
    }

    public DatabaseManager getDbManager() {
        if (dbManager == null) {
            dbManager = DatabaseManager.getInstance();
        }
        return dbManager;
    }

    public Session getSession() {
        if (session == null) {
            session = Session.getInstance();
        }
        return session;
    }

    public Images getImageHelper() {
        if (imgs == null) {
            imgs = Images.getInstance();
        }
        return imgs;
    }
    
    
    public GameLogic getGameLogic(GameEnums.GameMode gameMode) {
        if (gameLogic == null) {
            gameLogic = GameLogic.getInstance(this, gameMode);
        }
        return gameLogic;
    }

    public GameEnums.GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameEnums.GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public GameEnums.GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameEnums.GameState gameState) {
        gameThread.setGameState(gameState);
    }

    public MainThread getGameThread() {
        return gameThread;
    }
    
    
}
