/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;

import backend.Questions.Question;
import backend.Questions.QuestionLogic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import main.PlayerData.Session;
import java.util.Random;
import javax.swing.Timer;
import main.update.GameTimeUpdate;

/**
 *
 * @author PCC
 */

public class GameLogic {
    private static GameLogic instance;
    private AppContext appContext;
//    private GameTimeUpdate gameTimeUp;
    private GameEnums.GameMode gameMode;
    private GameEnums.GameState gameState;


    
    private Session session;
    private QuestionLogic qLogic;
    private GameTimer gameTimer;
    private Random rand;
    
    // Player 
    private int playerScore = 0;
    private int[] players_Score = new int[2];
    
    
    // Questions
    private final Map<Integer, Question> questions = new HashMap<>();
    private Map<Question, String> playerAns= new HashMap<>();

    private int questionsUsed =0;
    private Question current;
    private Question next;
    
    
    private boolean isPaused;
    private boolean isGameOver;
    
    public GameLogic(AppContext appContext, GameEnums.GameMode gameMode ){
        gameState = appContext.getGameState();
        this.session = appContext.getSession();
        this.gameMode = gameMode;
//        gameTimeUp = new GameTimeUpdate();
        qLogic = new QuestionLogic();
        rand = new Random();
        
        this.gameTimer = new GameTimer();
        
        isPaused = gameTimer.getIsPaused();
        isGameOver = gameTimer.getIsGameOver();
        
        
        initializeQuestionMap();
        
    }
    

    public Question getQuestionFromMap(){
        Question tempQues = null;
        while(true){
            int index = rand.nextInt(questions.size() - 1) + 1;
            if(!questions.get(index).getIsQuestionUsed()){
                tempQues = questions.get(index);
                tempQues.setIsQuestionUsed(true);
                questionsUsed++;
                System.out.println("Unique");
                System.out.println("Questions Used: " + questionsUsed);

                break;
            }
        }
        return tempQues;
    }
    
    public Question getQuestionFromMap(int index){
        Question tempQues = null;
        while(true){
            if(!questions.get(index).getIsQuestionUsed()){
                tempQues = questions.get(index);
                tempQues.setIsQuestionUsed(true);
                if(gameState == GameEnums.GameState.GameOver){
                    resetQuesStatus(tempQues);
                    questionsUsed =0;
                }
                questionsUsed++;
                System.out.println("Unique");
                System.out.println("Questions Used: " + questionsUsed);

                break;
            }
        }
        return tempQues;
    }
    
    public int getRandomIndex(){
        return rand.nextInt(questions.size() - 1) + 1;
    }
    
    public void addPlayerAnswerToList(String playerAnswer, Question currQuestion){
        playerAns.put(currQuestion, playerAnswer);
    }
    
    public boolean checkAnswerPerQuestion(String plyAnswer, Question currentQues){
        String corAns= currentQues.getCorrectAnswer();
        System.out.println("\nCorrect Answer: " + corAns + "\nPlayer Answer: " + plyAnswer);
        return currentQues.getCorrectAnswer().equals(plyAnswer); 
        
    }
    
    public String getCorrectAnswer(Question currentQues){
        return currentQues.getCorrectAnswer();
        
    }

    private void initializeQuestionMap(){
        for(int i =0; i < qLogic.getQuesData().getQuestions().size(); i++){
            questions.put((i+1), qLogic.getQuesData().getQuestions().get(i));
        }
    }
    public void displayAllQuestionsInMap(){
        for (int key : questions.keySet()) {
             String quesText = questions.get(key).getQuestionText();
             System.out.println("\n"+key + ". " + quesText + ". ");
            
            char optionLabel = 'A'; // Start labeling options with 'A'
            for (String opt : questions.get(key).getOptions()) {
                System.out.println(optionLabel + ") " + opt);
                optionLabel++; // Increment the label for the next option
            }
        }
    }
    
    public void checkAnswers(String plyAnswer){
        if( gameMode == GameEnums.GameMode.SINGLE_PLAYER){
            if(current.getCorrectAnswer().equals(plyAnswer)){
                playerScore += 10;
            }

        }
        else if(gameMode == GameEnums.GameMode.MULTIPLAYER){
            
        }

    }
    
    public void checkAnswer(boolean isCorrect){
        if( gameMode == GameEnums.GameMode.SINGLE_PLAYER){
            if(isCorrect){
                playerScore += 10;
            }

        }
        else if(gameMode == GameEnums.GameMode.MULTIPLAYER){
            
        }
    }
    
    public void resetQuesStatus(Question question){
            question.setIsQuestionUsed(false);
    }
    
    
    
    
    
    
    
    
    
    // Getter And Setters
    public static synchronized GameLogic getInstance(AppContext appContext, GameEnums.GameMode gameMode){
        if(instance == null){
            instance = new GameLogic(appContext, gameMode);
        }
        return instance;
    }



    public int getPlayerScore() {
        return playerScore;
    }

    public int[] getPlayers_Score() {
        return players_Score;
    }
    
    
    public int getQuestionsUsed() {
        return questionsUsed;
    }


//    public Question getCurrent() {
//        if(current == null){
//            current = getQuestionFromMap(getRandomIndex());
//        }
//        return current;
//    }
//    
//    public Question getNext() {
//        if(next == null){
//            next = getQuestionFromMap();
//        }
//        return next;
//    }
    
        // Method to start the game timer
    public void startTimer() {
        gameTimer.startTimer();
    }

    // Method to stop the game timer
    public void stopTimer() {
        gameTimer.stopTimer();
    }
    
    public void resetTimer() {
        gameTimer.restartTimer();
    }

    // Method to get current time from the GameTimer
    public String getCurrentTime() {
        return gameTimer.getCurrentTime();
    }

    // Getter to expose the Timer object to other forms
    public Timer getGameTimer() {
        return gameTimer.getGameTimer();
    }
//
//    public GameTimeUpdate getGameTimeUp() {
//        return gameTimeUp;
//    }
    
    public GameTimer getGameTimerClass(){
        return gameTimer;
    }

    public boolean getIsPaused() {
        return gameTimer.getIsPaused();
    }

    public void setIsPaused(boolean isPaused) {
        gameTimer.setIsPaused(isPaused);
    }

    public boolean getIsGameOver() {
        return gameTimer.getIsGameOver();
    }

    public void setIsGameOver(boolean isGameOver) {
        gameTimer.setIsGameOver(isGameOver);
    }

    public GameEnums.GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameEnums.GameState gameState) {
        appContext.setGameState(gameState);
    }
    
    
    
}




