/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main.logic;

/**
 *
 * @author PCC
 */
public interface Askable {
    void displayNextQuestion();
    void processPlayerAnswer(String playerAnswer, String player);
    void processPlayerAnswer(String playerAnswer);

}
