/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;

import java.util.ArrayList;
import main.ui.HomeForm;

/**
 *
 * @author PCC
 */
public class MainThread implements Runnable{
    private Thread mainThread;
    private final ArrayList<Updatable> updates = new ArrayList<>();
    private int FPS =10;
    
    public MainThread(){
        
        
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
    public void update(){
        System.out.println("Updating....");
        notifyGameUpdates();
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
    
    
    public static void Main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainThread();
            }
        });
    }
}
