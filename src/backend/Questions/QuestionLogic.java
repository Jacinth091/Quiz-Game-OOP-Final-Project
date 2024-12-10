/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Questions;


import java.util.Collections;


/**
 *
 * @author PCC
 */
public class QuestionLogic {
    private QuestionData quesData;
    

    
    public QuestionLogic(){
        quesData = new QuestionData();
        randomizeQuestions();
        randomizeOptionsPerQuestion();
//        displayAllQuestions();
        
    }
    
    
//    public int generateRandomIndex(){
//        return randIndex.nextInt(qd.getQuestions().size() - 1) + 1;
//    }
    
    private void randomizeQuestions(){
        Collections.shuffle(quesData.getQuestions());
    }
    private void randomizeOptionsPerQuestion(){
        for(Question ques : quesData.getQuestions()){
            Collections.shuffle(ques.getOptions());
        }
    }
    
//    public void displayAllQuestions() {
//        for (Question question : quesData.getQuestions()) {
//            // Display the question text
//            System.out.println("Question: " + question.getQuestionText());
//
//            // Display the options
//            char optionLabel = 'A'; // Start labeling options with 'A'
//            for (String opt : question.getOptions()) {
//                System.out.println(optionLabel + ") " + opt);
//                optionLabel++; // Increment the label for the next option
//            }
//
//            System.out.println(); // Add a blank line after each question for readability
//        }
//    }

    public QuestionData getQuesData() {
        return quesData;
    }
    
    
    
}

