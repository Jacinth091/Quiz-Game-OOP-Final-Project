/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Questions;

import java.util.List;
import main.logic.GameEnums;

/**
 *
 * @author PCC
 */



public class Question {

    private GameEnums.Difficulty difficulty;
    private String questionText;  // Stores the question text
    private List<String> options;     // Stores the multiple-choice options
    private String correctAnswer;   // Stores the correct answer (e.g., 'A', 'B', 'C', 'D')
    private boolean isQuestionUsed;


    
    public Question(String questionText, List<String> options, String correctAnswer, GameEnums.Difficulty difficulty) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
    }
    
    public Question(String questionText, List<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.isQuestionUsed = false;
    }

    
    
    
    // Getter for questionText
    public String getQuestionText() {
        return questionText;
    }

    // Setter for questionText
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    // Getter for options
    public List<String> getOptions() {
        return options;
    }

    // Setter for options
    public void setOptions(List<String> options) {
        if (options.size() != 4) {
            throw new IllegalArgumentException("There must be exactly 4 options.");
        }
        this.options = options;
    }
    
    

    // Getter for correctAnswer
//    public char getCorrectAnswer() {
//        return correctAnswer;
//    }
//
//    // Setter for correctAnswer
//    public void setCorrectAnswer(char correctAnswer) {
//        if (correctAnswer < 'A' || correctAnswer > 'D') {
//            throw new IllegalArgumentException("Correct answer must be one of 'A', 'B', 'C', or 'D'.");
//        }
//        this.correctAnswer = correctAnswer;
//    }
//
//    // Method to check if an answer is correct
//    public boolean isCorrect(char answer) {
//        return Character.toUpperCase(answer) == correctAnswer;
//    }

    public boolean getIsQuestionUsed() {
        return isQuestionUsed;
    }

    public void setIsQuestionUsed(boolean isQuestionUsed) {
        this.isQuestionUsed = isQuestionUsed;
    }

}

