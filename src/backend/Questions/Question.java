/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Questions;

/**
 *
 * @author PCC
 */
enum QuestionType{
    Single,
    Multi,
}


public class Question {
    
    private QuestionType quesType;
    private String questionText;  // Stores the question text
    private String[] options;     // Stores the multiple-choice options
    private char correctAnswer;   // Stores the correct answer (e.g., 'A', 'B', 'C', 'D')

    // Constructor to initialize all fields
    public Question(String questionText, String[] options, char correctAnswer, QuestionType quesType) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.quesType = quesType;
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
    public String[] getOptions() {
        return options;
    }

    // Setter for options
    public void setOptions(String[] options) {
        if (options.length != 4) {
            throw new IllegalArgumentException("There must be exactly 4 options.");
        }
        this.options = options;
    }

    // Getter for correctAnswer
    public char getCorrectAnswer() {
        return correctAnswer;
    }

    // Setter for correctAnswer
    public void setCorrectAnswer(char correctAnswer) {
        if (correctAnswer < 'A' || correctAnswer > 'D') {
            throw new IllegalArgumentException("Correct answer must be one of 'A', 'B', 'C', or 'D'.");
        }
        this.correctAnswer = correctAnswer;
    }

    // Method to check if an answer is correct
    public boolean isCorrect(char answer) {
        return Character.toUpperCase(answer) == correctAnswer;
    }

}

