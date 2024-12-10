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
    
    questions.add(new Question("What is the national flower\nof Japan?", 
            Arrays.asList("Rose", "Cherry Blossom", "Lotus", "Daisy"), "Cherry Blossom"));
    questions.add(new Question("What is the hardest\nnatural substance on Earth?", 
                Arrays.asList("Gold", "Iron", "Diamond", "Quartz"), "Diamond"));
    questions.add(new Question("Who developed the theory\nof relativity?", 
                Arrays.asList("Newton", "Einstein", "Tesla", "Hawking"), "Einstein"));
    questions.add(new Question("What is the name of the\nlongest bone in the human body?", 
                Arrays.asList("Femur", "Humerus", "Tibia", "Fibula"), "Femur"));
    questions.add(new Question("Which country hosted the\n2016 Summer Olympics?", 
                Arrays.asList("Brazil", "China", "UK", "USA"), "Brazil"));
    questions.add(new Question("Which element is denoted\nby the symbol 'O'?", 
                Arrays.asList("Oxygen", "Gold", "Silver", "Iron"), "Oxygen"));
    questions.add(new Question("What is the freezing point\nof water in Celsius?", 
                Arrays.asList("0", "100", "-1", "50"), "0"));
    questions.add(new Question("Who painted the ceiling of\nthe Sistine Chapel?", 
                Arrays.asList("Da Vinci", "Raphael", "Michelangelo", "Van Gogh"), "Michelangelo"));
    questions.add(new Question("What is the smallest\nplanet in our solar system?", 
                Arrays.asList("Mars", "Venus", "Mercury", "Pluto"), "Mercury"));
    questions.add(new Question("Which is the largest\ncontinent by land area?", 
                Arrays.asList("Africa", "Asia", "Europe", "North America"), "Asia"));

    questions.add(new Question("Who discovered gravity?", 
                Arrays.asList("Einstein", "Newton", "Galileo", "Copernicus"), "Newton"));
    questions.add(new Question("What is the capital of\nAustralia?", 
                Arrays.asList("Sydney", "Canberra", "Melbourne", "Perth"), "Canberra"));
    questions.add(new Question("What is the largest planet\nin the solar system?", 
                Arrays.asList("Earth", "Mars", "Jupiter", "Saturn"), "Jupiter"));
    questions.add(new Question("Which metal is known as\nthe 'metal of kings'?", 
                Arrays.asList("Iron", "Gold", "Silver", "Copper"), "Gold"));
    questions.add(new Question("Which country is home to\nthe Great Pyramid of Giza?", 
                Arrays.asList("Mexico", "China", "Egypt", "India"), "Egypt"));
    questions.add(new Question("What is the primary gas\nfound in Earth's atmosphere?", 
                Arrays.asList("Oxygen", "Nitrogen", "Carbon Dioxide", "Helium"), "Nitrogen"));
    questions.add(new Question("Which is the smallest unit\nof life?", 
                Arrays.asList("Atom", "Molecule", "Cell", "Organ"), "Cell"));
    questions.add(new Question("Who wrote the novel\n'Moby-Dick'?", 
                Arrays.asList("Herman Melville", "Mark Twain", "Ernest Hemingway", "John Steinbeck"), "Herman Melville"));
    questions.add(new Question("Which is the largest\nfreshwater lake in the world?", 
                Arrays.asList("Lake Superior", "Lake Victoria", "Lake Baikal", "Lake Tanganyika"), "Lake Superior"));
    questions.add(new Question("Who was the first\nPresident of the United States?", 
                Arrays.asList("George Washington", "Abraham Lincoln", "Thomas Jefferson", "John Adams"), "George Washington"));

    questions.add(new Question("What is the main language\nspoken in Brazil?", 
                Arrays.asList("Spanish", "English", "Portuguese", "French"), "Portuguese"));
    questions.add(new Question("What is the chemical\nsymbol for gold?", 
                Arrays.asList("Au", "Ag", "Fe", "Pb"), "Au"));
    questions.add(new Question("Which planet is known as\nthe Earth's twin?", 
                Arrays.asList("Venus", "Mars", "Mercury", "Jupiter"), "Venus"));
    questions.add(new Question("Who invented the light\nbulb?", 
                Arrays.asList("Nikola Tesla", "Thomas Edison", "Alexander Graham Bell", "James Watt"), "Thomas Edison"));
    questions.add(new Question("What is the name of the\nhighest waterfall in the world?", 
                Arrays.asList("Niagara Falls", "Victoria Falls", "Angel Falls", "Iguazu Falls"), "Angel Falls"));
    questions.add(new Question("Which is the longest bone\nin the human body?", 
                Arrays.asList("Femur", "Humerus", "Tibia", "Fibula"), "Femur"));
    questions.add(new Question("Who was the first woman\nto win a Nobel Prize?", 
                Arrays.asList("Marie Curie", "Ada Lovelace", "Rosalind Franklin", "Jane Goodall"), "Marie Curie"));
    questions.add(new Question("What is the most abundant\nmetal in Earth's crust?", 
                Arrays.asList("Iron", "Aluminum", "Copper", "Zinc"), "Aluminum"));
    questions.add(new Question("Which country is known as\nthe birthplace of democracy?", 
                Arrays.asList("Italy", "Greece", "USA", "France"), "Greece"));
    questions.add(new Question("What is the world's\nlongest railway line?", 
                Arrays.asList("Trans-Siberian", "Orient Express", "Eurostar", "Rocky Mountaineer"), "Trans-Siberian"));

    questions.add(new Question("What is the main component\nof the Sun?", 
                Arrays.asList("Helium", "Oxygen", "Hydrogen", "Carbon"), "Hydrogen"));
    questions.add(new Question("Which country gifted the\nStatue of Liberty to the USA?", 
                Arrays.asList("France", "Italy", "UK", "Germany"), "France"));
    questions.add(new Question("Which famous ship sank\nin 1912?", 
                Arrays.asList("Titanic", "Lusitania", "Britannic", "Queen Mary"), "Titanic"));
    questions.add(new Question("What is the main ingredient\nin guacamole?", 
                Arrays.asList("Avocado", "Tomato", "Cucumber", "Pepper"), "Avocado"));
    questions.add(new Question("Who is known as the\nfather of modern physics?", 
                Arrays.asList("Newton", "Einstein", "Galileo", "Bohr"), "Einstein"));
    questions.add(new Question("What is the capital of\nCanada?", 
                Arrays.asList("Toronto", "Vancouver", "Ottawa", "Montreal"), "Ottawa"));
    questions.add(new Question("Which planet has the\nmost moons?", 
                Arrays.asList("Earth", "Jupiter", "Mars", "Saturn"), "Saturn"));
    questions.add(new Question("Who painted 'Starry\nNight'?", 
                Arrays.asList("Van Gogh", "Monet", "Picasso", "Rembrandt"), "Van Gogh"));
    questions.add(new Question("Which is the largest land\nanimal?", 
                Arrays.asList("Elephant", "Hippopotamus", "Rhino", "Giraffe"), "Elephant"));
    questions.add(new Question("Which country is famous\nfor the Eiffel Tower?", 
                Arrays.asList("France", "Germany", "Italy", "Spain"), "France"));

    questions.add(new Question("What is the most common\nelement in the universe?", 
                Arrays.asList("Oxygen", "Carbon", "Hydrogen", "Nitrogen"), "Hydrogen"));
    questions.add(new Question("Which bird is known for\nits colorful feathers?", 
                Arrays.asList("Parrot", "Peacock", "Flamingo", "Toucan"), "Peacock"));
    questions.add(new Question("Who is known as the\nfather of the telephone?", 
                Arrays.asList("Alexander Graham Bell", "Thomas Edison", "Nikola Tesla", "Marconi"), "Alexander Graham Bell"));
    questions.add(new Question("What is the fastest bird\nin the world?", 
                Arrays.asList("Eagle", "Peregrine Falcon", "Ostrich", "Albatross"), "Peregrine Falcon"));
    questions.add(new Question("What is the name of the\nGreek god of the sea?", 
                Arrays.asList("Zeus", "Hades", "Poseidon", "Apollo"), "Poseidon"));
    questions.add(new Question("Which country is known for\nits maple syrup?", 
                Arrays.asList("USA", "Canada", "Australia", "New Zealand"), "Canada"));
    questions.add(new Question("Who is the author of 'The\nHobbit'?", 
                Arrays.asList("J.R.R. Tolkien", "C.S. Lewis", "J.K. Rowling", "George Orwell"), "J.R.R. Tolkien"));
    questions.add(new Question("What is the chemical\nsymbol for silver?", 
                Arrays.asList("Si", "Ag", "Au", "Sn"), "Ag"));
    questions.add(new Question("What is the smallest\ncontinent by land area?", 
                Arrays.asList("Europe", "Australia", "Antarctica", "South America"), "Australia"));
    questions.add(new Question("What is the hottest planet\nin our solar system?", 
                Arrays.asList("Mercury", "Venus", "Mars", "Earth"), "Venus"));

    questions.add(new Question("Which country is known for\nits pasta and pizza?", 
                Arrays.asList("France", "Italy", "Spain", "Greece"), "Italy"));
    questions.add(new Question("Who invented the World\nWide Web?", 
                Arrays.asList("Tim Berners-Lee", "Bill Gates", "Steve Jobs", "Mark Zuckerberg"), "Tim Berners-Lee"));
    questions.add(new Question("What is the currency of\nJapan?", 
                Arrays.asList("Won", "Yen", "Dollar", "Euro"), "Yen"));
    questions.add(new Question("Which is the longest\nriver in Africa?", 
                Arrays.asList("Congo", "Nile", "Zambezi", "Orange"), "Nile"));
    questions.add(new Question("What is the boiling point\nof water in Celsius?", 
                Arrays.asList("90", "100", "110", "120"), "100"));
    questions.add(new Question("Which country is known for\nits pyramids?", 
                Arrays.asList("Egypt", "Mexico", "China", "India"), "Egypt"));
    questions.add(new Question("Who wrote 'Pride and\nPrejudice'?", 
                Arrays.asList("Jane Austen", "Charlotte Bronte", "George Eliot", "Mary Shelley"), "Jane Austen"));
    questions.add(new Question("What is the primary source\nof energy for life on Earth?", 
                Arrays.asList("Moon", "Earth's core", "Sun", "Wind"), "Sun"));
    questions.add(new Question("Which is the coldest\ncontinent on Earth?", 
                Arrays.asList("Arctic", "Antarctica", "Europe", "Asia"), "Antarctica"));
    questions.add(new Question("Who painted 'The Last\nSupper'?", 
                Arrays.asList("Da Vinci", "Michelangelo", "Raphael", "Titian"), "Da Vinci"));

    questions.add(new Question("What is the smallest prime\nnumber?", 
                Arrays.asList("0", "1", "2", "3"), "2"));
    questions.add(new Question("Which country has the\nlargest population?", 
                Arrays.asList("India", "China", "USA", "Indonesia"), "China"));
    questions.add(new Question("What is the capital of\nIndia?", 
                Arrays.asList("Mumbai", "Delhi", "Kolkata", "Bangalore"), "Delhi"));
    questions.add(new Question("What is the official\nlanguage of Brazil?", 
                Arrays.asList("Portuguese", "Spanish", "English", "French"), "Portuguese"));
    questions.add(new Question("Which is the closest star\nto Earth?", 
                Arrays.asList("Sirius", "Alpha Centauri", "Proxima Centauri", "The Sun"), "The Sun"));
    questions.add(new Question("What is the primary gas in\nthe Earth's atmosphere?", 
                Arrays.asList("Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"), "Nitrogen"));
    questions.add(new Question("Which country is known for\nTaj Mahal?", 
                Arrays.asList("India", "Pakistan", "Nepal", "Bangladesh"), "India"));
    questions.add(new Question("What is the capital of\nRussia?", 
                Arrays.asList("Moscow", "Saint Petersburg", "Kazan", "Novosibirsk"), "Moscow"));
    questions.add(new Question("Which is the most widely\nspoken language in the world?", 
                Arrays.asList("English", "Spanish", "Mandarin", "Hindi"), "Mandarin"));
    questions.add(new Question("What is the longest\nmountain range in the world?", 
                Arrays.asList("Himalayas", "Andes", "Rockies", "Alps"), "Andes"));
    }

    
    
    public List<Question> getQuestions() {
        return questions;
    }

    
}
