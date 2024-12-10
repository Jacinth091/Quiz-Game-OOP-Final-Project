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
import main.PlayerData.MultiManager;
import static main.logic.GameEnums.GameMode.MULTIPLAYER;
import static main.logic.GameEnums.GameState.GameOver;
import static main.logic.GameEnums.GameState.Play;

/**
 *
 * @author PCC
 */

public class GameLogic {
    private static GameLogic instance;
    private AppContext appContext;
    private GameEnums.GameMode gameMode;


    
    private Session session;
    private MultiManager multiManager;
    private QuestionLogic qLogic;
    private GameTimer gameTimer;
    private Random rand;
    
    // Player 
    private int playerScore = 0;
    private int[] multPlayerScore = new int[2];
    private int[] multAnsweredCorrect = new int[2];

    private String[] players;    
    
    // Questions
    private final Map<Integer, Question> questions = new HashMap<>();
    private Map<Question, String> playerAns = new HashMap<>();

    private int questionsUsed =0;
    private int quesAnsweredCorrect =0;
    private Question current;
    private Question next;
    
    
    private boolean isPaused;
    private boolean isGameOver;
    
    
    // GameLogic 
    private int multiplier =10;
    
    public GameLogic(AppContext appContext, GameEnums.GameMode gameMode ){
        this.session = appContext.getSession();
        this.gameMode = gameMode;
        this.players = new String[]{"playerOne", "playerTwo"};
        qLogic = new QuestionLogic();
        rand = new Random();
        
        this.gameTimer = new GameTimer();
        
        initializeQuestionMap();
        
    }
    

    public Question getQuestionFromMap(){
        Question tempQues = null;
        while(true){
            int index = rand.nextInt(questions.size() - 1) + 1;
            if(!questions.get(index).getIsQuestionUsed()){
                tempQues = questions.get(index);
                tempQues.setIsQuestionUsed(true);
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
                break;
            }
        }
        return tempQues;
    }
    
    public void updateQuestionUsed(boolean isCorrect){
        if(isCorrect) quesAnsweredCorrect++;
        questionsUsed++;
        System.out.println("Questions Used: " + questionsUsed);
        System.out.println("Correct Answer Count: " + quesAnsweredCorrect);
    }
    
    public void updateQuestionUsed(boolean isCorrect, String player){
      if( gameMode == GameEnums.GameMode.MULTIPLAYER){
            if(isCorrect){
                if(player.equals(players[0])){
                    multAnsweredCorrect[0]++;
                }
                else if(player.equals(players[1])){
                     multAnsweredCorrect[1]++;
                }
                questionsUsed++;
            }
            else{
                System.out.println("Player: " + player + "is Incorrect!");
            }
            System.out.println("Questions Used: " + questionsUsed);
            System.out.println("Player One Correct Answer Count: " + multAnsweredCorrect[0]);
            System.out.println("Player One Correct Answer Count: " + multAnsweredCorrect[1]);
        }
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
    


    private void initializeQuestionMap(){
        for(int i =0; i < qLogic.getQuesData().getQuestions().size(); i++){
            questions.put((i+1), qLogic.getQuesData().getQuestions().get(i));
        }
    }
    
    public void displayAllQuestionsInMap(){
        for (int key : questions.keySet()) {
             String quesText = questions.get(key).getQuestionText();
             System.out.println("\n"+key + ". " + quesText + ". ");
            
            char optionLabel = 'A';
            for (String opt : questions.get(key).getOptions()) {
                System.out.println(optionLabel + ") " + opt);
                optionLabel++; 
            }
        }
    }
    
    public void checkAnswer(String player, boolean isCorrect){
        if( gameMode == GameEnums.GameMode.MULTIPLAYER){
            if(isCorrect){
                if(player.equals(players[0])){
                    multPlayerScore[0] += multiplier;  
                }
                else if(player.equals(players[1])){
                    multPlayerScore[1] += multiplier;
                }
            }
            else{
                System.out.println("Player: " + player + "is Incorrect!");
            }
        }
        System.out.println("GIATAAAYYY" );
        System.out.println("Game Mode: " + gameMode);

    }
    
    public void checkAnswer(boolean isCorrect){
        if( gameMode == GameEnums.GameMode.SINGLE_PLAYER){
            if(isCorrect){
                playerScore += multiplier;

            }
            else{
                System.out.println("Incorrect Answer!");
            }

        }
     
    }
    
    
    public double computePlayerScore(int questionUsed, int correctAnswers){
        double aveScore = 0f;
        if (questionsUsed > 0) { // Avoid division by zero
            double percentage = (double) correctAnswers / questionsUsed * 100;
            aveScore = percentage;
        } else {
            System.out.println("No questions were used. Average cannot be calculated.");
        }
        return aveScore;
    }
    
    
    
    
    
    
    
    
    
    
    public void resetQuesStatus(){
        for (int key : questions.keySet()) {
            Question ques = questions.get(key);
            if(ques.getIsQuestionUsed()){
                ques.setIsQuestionUsed(false);
            }
        }
    }
    
    public void restartGame(){
        gameTimer.restartTimer();
        resetQuesStatus();
        playerScore = 0;
        questionsUsed =0;
        quesAnsweredCorrect =0;
        gameTimer.setGameState(Play);
        if(MULTIPLAYER.equals(gameMode)){
            multPlayerScore[0] =0;
            multPlayerScore[1] =0;
            multAnsweredCorrect[0] =0;
            multAnsweredCorrect[1] =0;

        }
        session.getPlayer().setSinglePlay_Score(0);
        

    }
    public void pauseGame(){
        getGameTimerClass().pauseTimer();
    }
    
    
    
    
    public void resetGameLogic() {
        if (gameTimer != null) {
            gameTimer.stopTimer(); // Stop the timer
        }
        restartGame();        
        // Reset other game-related resources
    }
    public void dispose() {
        gameMode = null;
//        appContext.setGameMode(null);
        if (gameTimer != null) {
            gameTimer.stopTimer(); 
            gameTimer = null;
        }

        if (questions != null) {
            questions.clear();
        }

        if (playerAns != null) {
            playerAns.clear();
        }

        playerScore = 0;
        questionsUsed = 0;
        quesAnsweredCorrect = 0;

        if (MULTIPLAYER.equals(gameMode)) {
            multPlayerScore[0] = 0;
            multPlayerScore[1] = 0;
            multAnsweredCorrect[0] = 0;
            multAnsweredCorrect[1] = 0;
        }

        session = null;
        multiManager = null;
        players = null;

    }
    
    
    
    
    
    
    
    // Getter And Setters
    public static synchronized GameLogic getInstance(AppContext appContext, GameEnums.GameMode gameMode){
        if(instance == null){
            instance = new GameLogic(appContext, gameMode);
        }
        return instance;
    } 
    public static void resetInstance() {
        if (instance != null) {
            instance.dispose(); 
            instance = null;
        }
    }

    public String getCorrectAnswer(Question currentQues){
        return currentQues.getCorrectAnswer();
        
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int[] getMultPlayerScore() {
        return multPlayerScore;
    }

    public int getQuesAnsweredCorrect() {
        return quesAnsweredCorrect;
    }

    public void setQuesAnsweredCorrect(int quesAnsweredCorrect) {
        this.quesAnsweredCorrect = quesAnsweredCorrect;
    }
    
    
    
    public int getQuestionsUsed() {
        return questionsUsed;
    }


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

    public GameEnums.GameState getGameState() {
        return gameTimer.getGameState();
    }

    public void setGameState(GameEnums.GameState gameState) {
        gameTimer.setGameState(gameState);
    }

//    public void setGameState(GameEnums.GameState gameState) {
//        appContext.setGameState(gameState);
//    }

    public GameEnums.GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameEnums.GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public MultiManager getMultiManager() {
        return multiManager;
    }

    public void setMultiManager(MultiManager multiManager) {
        this.multiManager = multiManager;
    }

    public int[] getMultAnsweredCorrect() {
        return multAnsweredCorrect;
    }

    public void setMultAnsweredCorrect(int[] multAnsweredCorrect) {
        this.multAnsweredCorrect = multAnsweredCorrect;
    }
    
    
    
    
}




