package main.logic;

import javax.swing.Timer;



public class GameTimer {
    private Timer gameTimer;
    private int totalGameTime = 15 * 60;
    private long timeElapsedInSeconds = 0;
    private long timerMinutes = 0;
    private long timerSeconds = 0;

    public GameTimer(){



    }

    public void createTimer(){
        gameTimer = new Timer(1000, (ae) -> {
            setTime();

        });
        gameTimer.setDelay(1000);
    }


    public void setTime(){
        timeElapsedInSeconds++;
        timerMinutes = timeElapsedInSeconds / 60;
        timerSeconds = timeElapsedInSeconds % 60;
        System.out.println(String.format("Time Remaining: %02d:%02d", timerMinutes, timerSeconds)); // Print remaining time



    }

    public void startTimer(){
        gameTimer.start();
    }



}
