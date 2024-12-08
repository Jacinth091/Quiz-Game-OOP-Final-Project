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
    
    private String playerId, playerName;
    
    private int highScore = 0;
    private double player_Average;
    

    public Player( String playerId, String playerName, int highScore) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.highScore = highScore;

    }
    public Player(){}


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
        System.out.println("Get Single Score: " + this.highScore);

        return highScore;
        
    }

    public void setSinglePlay_Score(int singlePlay_Score) {
        this.highScore = singlePlay_Score;
        System.out.println("Set Single Score: " + this.highScore);
    }


    public double getPlayer_Average() {
        return player_Average;
    }

    public void setPlayer_Average(double player_Average) {
        this.player_Average = player_Average;
    }
    
    
    
    
    
    
    

    
    
}
