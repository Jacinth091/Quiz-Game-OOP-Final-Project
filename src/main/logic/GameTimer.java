/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import static main.logic.GameEnums.GameState.GameOver;
import static main.logic.GameEnums.GameState.Pause;
import static main.logic.GameEnums.GameState.Play;
import main.update.TimeUpdatable;

/**
 *
 * @author PCC
 */
public class GameTimer{

    private Timer gameTimer;
    private long timeElapsedInSeconds, timeRemainingInSeconds = 5;
    private long timerMinutes = 0;
    private long timerSeconds = 0;
    private long pauseStartTime;
    
    
    private ArrayList<TimeUpdatable> timeUpdate;
    
    private boolean isPaused;
    private boolean isGameOver;
    
    private GameEnums.GameState gameState;

 

    public GameTimer() {
        timeUpdate = new ArrayList<>();
        gameState = GameEnums.GameState.Play;
    }

    public void startTimer() {
        if (gameTimer == null || !gameTimer.isRunning()) {
            if(Pause.equals(gameState)){
                long pauseDuration = (System.currentTimeMillis() - pauseStartTime) / 1000; // Pause duration in seconds
                timeRemainingInSeconds -= pauseDuration; // Adjust remaining time
                gameState = Play;
            }
            else{
//                gameState = Play;
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
            gameTimer.stop(); // Stop the timer
            pauseStartTime = System.currentTimeMillis(); // Record the pause time
            gameState = Pause;
        }
    }
    
    public void restartTimer(){
        timeRemainingInSeconds = 5;
        timerMinutes = 0;
        timerSeconds = 0;
        gameState = Play;
    }

    private void countDownTimer() {
        if (gameTimer == null) {
            gameTimer = new Timer(1000, ae -> {
                countDown();
                notifyTimeUpdates();
            });
            gameTimer.setRepeats(true); 
        }


    }
    
    private void countDown() {
        if (timeRemainingInSeconds > 0) {
            timeRemainingInSeconds--; 
            timerMinutes = timeRemainingInSeconds / 60;  
            timerSeconds = timeRemainingInSeconds % 60; 
//            System.out.println("Timer Updated: " + getCurrentTime()); // Debug log
 
      } else if(timeRemainingInSeconds == 0 ){
          gameState = GameOver;
          gameTimer.stop();
      }
        
//        System.out.println("GameState: " + gameState);
        System.out.println("Time Remaining: " + getCurrentTime() + ", GameState: " + gameState);
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

    public GameEnums.GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameEnums.GameState gameState) {
        this.gameState = gameState;
    }


    
}