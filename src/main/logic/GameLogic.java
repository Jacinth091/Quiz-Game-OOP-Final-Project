/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;

import backend.Questions.Question;
import backend.Questions.QuestionLogic;
import java.util.HashMap;
import java.util.Map;
import main.PlayerData.Session;
import java.util.Random;

/**
 *
 * @author PCC
 */
public class GameLogic {
    private static GameLogic instance;
    private GameEnums.GameMode gameMode;
    private Session session;
    private QuestionLogic qLogic;
    private Random rand;
    
    // Player 
    private int playerScore =0;
    private int[] players_Score = new int[2];
    
    
    // Questions
    private final Map<Integer, Question> questions = new HashMap<>();

    private Map<Question, String> playerAns= new HashMap<>();
    private int questionsUsed =0;

    
    public GameLogic(Session session, GameEnums.GameMode gameMode ){
        this.session = session;
        this.gameMode = gameMode;
        qLogic = new QuestionLogic();
        rand = new Random();
        initializeQuestionMap();
        
    }
    
//    public Question getQuestionToDisplay(int index){
//        return qLogic.getQuesData().getQuestions().get(index);
//            
//    }
    
    public Question getQuestionFromMap(){
        int index =0;
        Question tempQues = null;
        while(true){
            index = rand.nextInt(questions.size() - 1) + 1;
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
    
    public void addPlayerAnswerToList(String playerAnswer, int index){
        playerAns.put(qLogic.getQuesData().getQuestions().get(index), playerAnswer);
    }
//    
//    public int getUniqueRandomIndex(){
//        int index =0;
//        for(Question question : qLogic.getQuesData().getQuestions()){
//            if(question.getIsQuestionUsed()){
//                index = 
//            }
//        }
//    }
//    
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
    
    public static synchronized GameLogic getInstance(Session session, GameEnums.GameMode gameMode){
        if(instance == null){
            instance = new GameLogic(session, gameMode);
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
    
    
    
    
}
