/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.PlayerData;



/**
 *
 * @author PCC
 */
public class Session extends Player{
    private static Session instance;
    private String userId, userName;
    private Player singlePlayer;

    public Session() {
    }
    
    
    public static synchronized Session getInstance(){
        if(instance == null){
            instance = new Session();
        }
        return instance;
    }
    
    

    public Player getPlayer() {
        return singlePlayer;
    }
    
    public void setPlayer(Single player){
        this.singlePlayer = player;
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
    
    




    
    
    
    
    
    

    
    
}
