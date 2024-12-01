/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author PCC
 */
public class QuestionData {
    private final List<Question> questions = new ArrayList<>();

    public QuestionData(){
        initializeQuestions();
    }
    
    private void initializeQuestions(){
    questions.add(new Question("What is the capital of\nFrance?", 
            Arrays.asList("Paris", "London", "Berlin", "Rome"), "Paris"));
    questions.add(new Question("Which planet is known as\nthe Red Planet?", 
            Arrays.asList("Venus", "Mars", "Jupiter", "Saturn"), "Mars"));
    questions.add(new Question("What is the largest ocean\non Earth?", 
            Arrays.asList("Atlantic", "Indian", "Arctic", "Pacific"), "Pacific"));
    questions.add(new Question("Who wrote 'Romeo and\nJuliet'?", 
            Arrays.asList("Charles Dickens", "William Shakespeare", 
                          "Jane Austen", "Mark Twain"), "William Shakespeare"));
    questions.add(new Question("What is the chemical\nsymbol for water?", 
            Arrays.asList("H2O", "CO2", "O2", "N2"), "H2O"));
    questions.add(new Question("How many continents are\nthere on Earth?", 
            Arrays.asList("5", "6", "7", "8"), "7"));
    questions.add(new Question("Which country is known as\nthe Land of the Rising Sun?", 
            Arrays.asList("China", "Japan", "Thailand", "Vietnam"), "Japan"));
    questions.add(new Question("What is the square root\nof 64?", 
            Arrays.asList("6", "7", "8", "9"), "8"));
    questions.add(new Question("Which animal is known as\nthe King of the Jungle?", 
            Arrays.asList("Tiger", "Lion", "Elephant", "Leopard"), "Lion"));
    questions.add(new Question("What is the currency of\nthe United States?", 
            Arrays.asList("Euro", "Yen", "Pound", "Dollar"), "Dollar"));

    questions.add(new Question("Who painted the Mona\nLisa?", 
            Arrays.asList("Van Gogh", "Leonardo da Vinci", 
                          "Picasso", "Michelangelo"), "Leonardo da Vinci"));
    questions.add(new Question("Which is the smallest\ncountry in the world?", 
            Arrays.asList("Monaco", "Vatican City", 
                          "San Marino", "Liechtenstein"), "Vatican City"));
    questions.add(new Question("What is the powerhouse of\nthe cell?", 
            Arrays.asList("Nucleus", "Mitochondria", "Ribosome", 
                          "Golgi Apparatus"), "Mitochondria"));
    questions.add(new Question("Which sport is known as\nthe 'king of sports'?", 
            Arrays.asList("Basketball", "Football (Soccer)", 
                          "Cricket", "Tennis"), "Football (Soccer)"));
    questions.add(new Question("What is the tallest\nmountain in the world?", 
            Arrays.asList("K2", "Kilimanjaro", "Everest", 
                          "Denali"), "Everest"));
    questions.add(new Question("Which planet is closest\nto the Sun?", 
            Arrays.asList("Earth", "Mercury", "Venus", "Mars"), "Mercury"));
    questions.add(new Question("Who is known as the\nfather of computers?", 
            Arrays.asList("Charles Babbage", "Alan Turing", 
                          "Bill Gates", "Steve Jobs"), "Charles Babbage"));
    questions.add(new Question("How many days are there\nin a leap year?", 
            Arrays.asList("364", "365", "366", "367"), "366"));
    questions.add(new Question("What is the largest\nmammal on Earth?", 
            Arrays.asList("Elephant", "Blue Whale", "Giraffe", "Shark"), "Blue Whale"));
    questions.add(new Question("Who discovered\npenicillin?", 
            Arrays.asList("Marie Curie", "Alexander Fleming", 
                          "Louis Pasteur", "Isaac Newton"), "Alexander Fleming"));

    questions.add(new Question("Which language has the\nmost native speakers?", 
            Arrays.asList("English", "Mandarin Chinese", 
                          "Spanish", "Hindi"), "Mandarin Chinese"));
    questions.add(new Question("What is the name of the\nlargest desert in the world?", 
            Arrays.asList("Gobi", "Sahara", "Arctic", "Antarctic"), "Antarctic"));
    questions.add(new Question("What is the main\ningredient in sushi?", 
            Arrays.asList("Noodles", "Rice", "Seaweed", "Fish"), "Rice"));
    questions.add(new Question("Which gas do plants\nabsorb from the atmosphere?", 
            Arrays.asList("Oxygen", "Carbon Dioxide", 
                          "Nitrogen", "Methane"), "Carbon Dioxide"));
    questions.add(new Question("Who was the first man to\nstep on the Moon?", 
            Arrays.asList("Neil Armstrong", "Buzz Aldrin", 
                          "Yuri Gagarin", "Michael Collins"), "Neil Armstrong"));
    questions.add(new Question("What is the longest\nriver in the world?", 
            Arrays.asList("Amazon", "Nile", "Yangtze", 
                          "Mississippi"), "Nile"));
    questions.add(new Question("Which instrument has\n88 keys?", 
            Arrays.asList("Guitar", "Violin", "Piano", "Flute"), "Piano"));
    questions.add(new Question("Which is the largest\norgan in the human body?", 
            Arrays.asList("Heart", "Liver", "Brain", "Skin"), "Skin"));
    questions.add(new Question("Who wrote the 'Harry\nPotter' series?", 
            Arrays.asList("J.K. Rowling", "Tolkien", 
                          "George R.R. Martin", "Suzanne Collins"), "J.K. Rowling"));
    questions.add(new Question("Which is the fastest\nland animal?", 
            Arrays.asList("Cheetah", "Lion", "Horse", "Kangaroo"), "Cheetah"));

    }

    
    
    public List<Question> getQuestions() {
        return questions;
    }

    
}
