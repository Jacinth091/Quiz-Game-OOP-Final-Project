package main.logic;

import javax.swing.Timer;



public class GameTimer {
    private Timer gameTimer;
//    private int totalGameTime = 15 * 60;
    private long timeElapsedInSeconds;
    private long timerMinutes = 0;
    private long timerSeconds = 0;

    public GameTimer(Long timeElapsedInSeconds){
        this.timeElapsedInSeconds = timeElapsedInSeconds;


    }
    public GameTimer(){
        
    }

    public void countDownTimer(){
        gameTimer = new Timer(1000, (ae) -> {
            timeElapsedInSeconds--;
            timerMinutes = timeElapsedInSeconds / 60;
            timerSeconds = timeElapsedInSeconds % 60;
            System.out.println(String.format("Time Remaining: %02d:%02d", timerMinutes, timerSeconds)); // Print remaining time

        });
        gameTimer.setDelay(1000);
    }


    public void countUptimer(){
        gameTimer = new Timer(1000, (ae) -> {
            timeElapsedInSeconds--;
            timerMinutes = timeElapsedInSeconds / 60;
            timerSeconds = timeElapsedInSeconds % 60;
            System.out.println(String.format("Time Remaining: %02d:%02d", timerMinutes, timerSeconds)); // Print remaining time

        });
        gameTimer.setDelay(1000);

    }
    

    public void startTimer(){
        gameTimer.start();
    }

    public Timer getGameTimer() {
        return gameTimer;
    }
    
    public void setTimer(Timer gameTimer){
        this.gameTimer = gameTimer;
    }

    public long getTimeElapsedInSeconds() {
        return timeElapsedInSeconds;
    }

    public long getTimerMinutes() {
        return timerMinutes;
    }

    public long getTimerSeconds() {
        return timerSeconds;
    }

    
    


}
