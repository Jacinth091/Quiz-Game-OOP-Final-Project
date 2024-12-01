/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;

import backend.Database.DatabaseManager;
import backend.Questions.Question;
//import backend.Questions.Question;
import backend.Questions.QuestionLogic;
import java.util.List;
import javax.swing.Timer;
import main.ui.SinglePlayer;

/**
 *
 * @author PCC
 */
public class SinglePlayerLogic{
    private AppContext appContext;
    private DatabaseManager dbManager;
    private SinglePlayer singlePlayer;
    
    private QuestionLogic qLogic;
    private GameLogic gameLogic;
    
    private Timer gameTimer;
    private long timeElapsedInSeconds, timeRemainingInSeconds =1 * 60;
    private long timerMinutes = 0;
    private long timerSeconds = 0;
    // GamePlay
    
    private int playerScore =0;
    private Question current;
    private Question next;
    private String playerAnswer;
    private int playerAnswerQuestionKey;

    
    public SinglePlayerLogic(AppContext appContext,GameEnums.GameMode gameMode, SinglePlayer singlePlayer){
        this.appContext = appContext;
        this.dbManager = appContext.getDbManager();
        this.gameLogic = appContext.getGameLogic(gameMode);
        this.singlePlayer = singlePlayer;
        qLogic = new QuestionLogic();

//        gameLogic.displayAllQuestionsInMap();
        
        
    }
    
    
    public void startTimer() {
        if (gameTimer == null || !gameTimer.isRunning()) {
            // Update the label immediately
            timerMinutes = timeRemainingInSeconds / 60;
            timerSeconds = timeRemainingInSeconds % 60;
            singlePlayer.updateTimeLabel(timerMinutes, timerSeconds);

            countDownTimer(); // Initialize the timer
            gameTimer.start(); // Start the timer
        }
     }

     public void stopTimer() {
         if (gameTimer != null && gameTimer.isRunning()) {
             gameTimer.stop(); // Stop the timer
         }
     }

    public void countDownTimer(){
        if(gameTimer == null){
            gameTimer = new Timer(0,(ae) -> {

                timerMinutes = timeRemainingInSeconds / 60;
                timerSeconds = timeRemainingInSeconds % 60;
                singlePlayer.updateTimeLabel(timerMinutes, timerSeconds);
                System.out.println(String.format("Time Remaining: %02d:%02d", timerMinutes, timerSeconds)); // Print remaining time
//                if(gameLogic.getQuestionsUsed() <= 30){
//                    Question ques = gameLogic.getQuestionFromMap();
//                    System.out.println(ques.getQuestionText());
//                    singlePlayer.displayQuestion(ques);
//                }

                timeRemainingInSeconds--;


            });
            gameTimer.setDelay(1000);
        
        }
        
    }

    

    
    // Getter and Setter
    public long getTimerMinutes() {
        return timerMinutes;
    }

    public long getTimerSeconds() {
        return timerSeconds;
    }

    public long getTimeRemainingInSeconds() {
        return timeRemainingInSeconds;
    }
    
    
    public Question getCurrent() {
        if(current == null){
            current = gameLogic.getQuestionFromMap();
        }
        return current;
    }

    public void setCurrent(Question current) {
        this.current = current;
    }
}