/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;

import java.util.ArrayList;
//import main.ui.HomeForm;

/**
 *
 * @author PCC
 */
public class MainThread implements Runnable{
    private static MainThread instance;
    private Thread mainThread;
    private GameEnums.GameState gameState;
    private GameEnums.GameState prevGameState;


    private final ArrayList<Updatable> updates = new ArrayList<>();
    private int FPS =10;
    
    public MainThread(){
        gameState = GameEnums.GameState.Play;
        
    }
    
    
    
    
    
    @Override
    public void run(){
        gameLoop();
    }
    
    public void startThread(){
        if(mainThread == null){
            mainThread = new Thread(this);
            mainThread.start();
        }
    }
    
    
    public void stopThread() {
        // Add logic to safely stop the thread
        mainThread = null;
    }
    public void update(){
        System.out.println("Updating....");
        System.out.println("GameState: " + gameState);
        notifyGameUpdates();
        checkGameState();
    }
    
   public void gameLoop() {
        long nanoTime = 1000000000;
        double drawInterval = nanoTime / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (mainThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                try{
                    update();
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                delta--;
            }
        }
    }
    
    public synchronized void notifyGameUpdates(){
        synchronized(updates){
            for(Updatable update : updates){
                update.update();
            }
        }
    }
    public void addEventUpdate(Updatable gameUpdate) {
        updates.add(gameUpdate);
    }
    

    
    
    public static synchronized MainThread getInstance(){
        if(instance == null){
            instance = new MainThread();
        }
        return instance;
    }
    
    
    public void checkGameState() {
        if (gameState != null && gameState != prevGameState) {
            switch (gameState) {
                case Play:
                    System.out.println("Game is playing...");
                    break;
                case Pause:
                    javax.swing.JOptionPane.showMessageDialog(null, "Game Paused");
                    break;
                case GameOver:
                    javax.swing.JOptionPane.showMessageDialog(null, "Game Over");
                    break;
            }
            prevGameState = gameState;
        }
    }

    public GameEnums.GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameEnums.GameState gameState) {
        this.gameState = gameState;
    }
   
    
    public static void Main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainThread();
            }
        });
    }
    
}
