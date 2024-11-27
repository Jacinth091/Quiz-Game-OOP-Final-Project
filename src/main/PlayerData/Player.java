/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.PlayerData;

/**
 *
 * @author PCC
 */
public class Player {
    
    private String userId, userName, playerId, playerName;
    
    private int singlePlay_Score = 0;
    private int multiPlay_Score = 0;
    

    public Player(String userId, String userName , String playerId, String playerName, int singlePlay_Score, int multiPlay_Score) {
        this.userId = userId;
        this.userName = userName;
        this.playerId = playerId;
        this.playerName = playerName;
        this.singlePlay_Score = singlePlay_Score;
        this.multiPlay_Score = multiPlay_Score;
    }
    
    
    
    
    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getSinglePlay_Score() {
        return singlePlay_Score;
    }

    public void setSinglePlay_Score(int singlePlay_Score) {
        this.singlePlay_Score = singlePlay_Score;
    }

    public int getMultiPlay_Score() {
        return multiPlay_Score;
    }

    public void setMultiPlay_Score(int multiPlay_Score) {
        this.multiPlay_Score = multiPlay_Score;
    }
    
    
    
    
    
    
    

    
    
}
