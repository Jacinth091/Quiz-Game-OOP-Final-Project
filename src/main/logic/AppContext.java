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
    private DatabaseManager dbManager;
    private Session session;
    private GameLogic gameLogic;
    private Images imgs;
    
    private GameEnums.GameMode gameMode;
    
    private AppContext(){}
    

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
            gameLogic = GameLogic.getInstance(session, gameMode);
        }
        return gameLogic;
    }
    
    
}
