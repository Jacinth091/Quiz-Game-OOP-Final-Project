/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;

import java.util.ArrayList;
import javax.swing.Timer;
import main.update.TimeUpdatable;

/**
 *
 * @author PCC
 */
public class GameTimer{

    private Timer gameTimer;
    private long timeElapsedInSeconds, timeRemainingInSeconds = 1 * 60;
    private long timerMinutes = 0;
    private long timerSeconds = 0;
    
    
    private ArrayList<TimeUpdatable> timeUpdate;
    
    private boolean isPaused;
    private boolean isGameOver;
 

    public GameTimer() {
        timeUpdate = new ArrayList<>();
    }

    public void startTimer() {
        if (gameTimer == null || !gameTimer.isRunning()) {
            if(isPaused){
                isPaused =false;
            }
            else{
                isPaused = false;
                countDown();  
                notifyTimeUpdates();  
                countDownTimer();  
            }
            gameTimer.start();  

        }
        
        
    }

    public void stopTimer() {
        if (gameTimer != null && gameTimer.isRunning()) {
            gameTimer.stop(); // Stop the timer
            restartTimer();
        }
    }
    public void pauseTimer() {
        if (gameTimer != null && gameTimer.isRunning()) {
            gameTimer.stop(); // Stop the timer to pause it
            isPaused = true; // Set the pause state
        }
    }
    
    public void restartTimer(){
        timeRemainingInSeconds = 1 * 60;
        timerMinutes = 0;
        timerSeconds = 0;
        isPaused = false;
        isGameOver = false;
    }

    private void countDownTimer() {
        if(gameTimer == null){
            gameTimer = new Timer(0, (ae) -> {
                notifyTimeUpdates();
                countDown();
            });
            gameTimer.setDelay(1000);
        }
    }
    
    private void countDown() {
        if (timeRemainingInSeconds > 0) {
            if(timerSeconds == 20){
                isPaused = true;
            }
            timeRemainingInSeconds--; 
            timerMinutes = timeRemainingInSeconds / 60;  
            timerSeconds = timeRemainingInSeconds % 60; 
 
      } else if(timeRemainingInSeconds == 0){
          isGameOver = true;
          gameTimer.stop();
      }
        
        System.out.println("GameOver:? " + isGameOver);

    }
    
    
    
    public void addEventUpdate(TimeUpdatable eventUpdate) {
        timeUpdate.add(eventUpdate);
    }

    private synchronized void notifyTimeUpdates() {
        for (TimeUpdatable eventUpdate : timeUpdate) {
            eventUpdate.timeUpdate();
        }
    }
    
    
    
    
    
    
    public long getTimerMinutes() {
        return timerMinutes;
    }

    public long getTimerSeconds() {
        return timerSeconds;
    }

    public long getTimeRemainingInSeconds() {
        return timeRemainingInSeconds;
    }

    public String getCurrentTime() {
        return String.format("Time Remaining: %02d:%02d", timerMinutes, timerSeconds);
    }

    // Getter for Timer object to allow external control if needed
    public Timer getGameTimer() {
        return gameTimer;
    }

    public boolean getIsPaused() {
        return isPaused;
    }

    public void setIsPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    public boolean getIsGameOver() {
        return isGameOver;
    }

    public void setIsGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
    
    
    
}