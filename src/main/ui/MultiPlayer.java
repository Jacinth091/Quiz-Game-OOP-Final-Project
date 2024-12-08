/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.ui;

import backend.Database.DatabaseManager;
import backend.Questions.Question;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import main.PlayerData.Session;
import main.logic.AppContext;
import main.logic.GameEnums;
import main.logic.GameLogic;
import static main.logic.GameEnums.GameMode.MULTIPLAYER;
import static main.logic.GameEnums.GameState.GameOver;
import static main.logic.GameEnums.GameState.Pause;
import static main.logic.GameEnums.GameState.Play;
import main.logic.GameStructure;
import main.logic.Playable;

/**
 *
 * @author laroc
 */
public class MultiPlayer extends GameStructure  {
    private static MultiPlayer instance;
    private GameEnums.GameMode gameMode;

//    private AppContext appContext;
//    private DatabaseManager dbManager;
//    private Session session;
//    private GameLogic gameLogic;
//
//    private Timer gameTimer;
//    private Question current;
//    private Question next;
//
//    private boolean isProcessingFlag;
//    private boolean answerTaken;
//    private boolean isPlayerOneCorrect;
//    private boolean isPlayerTwoCorrect;
//
//    private String firstPlayerAnswered = "";
//
//    
//    private JButton[][] playerButtons;
//    private String[][] playerKeys;
//    private Color[][] playerColors;
    
    /**
     * Creates new form MultiPlayer
     * @param appContext
     */
    public MultiPlayer(AppContext appContext) {
        super(appContext, GameEnums.GameMode.MULTIPLAYER);
        this.gameMode = GameEnums.GameMode.MULTIPLAYER;
        initComponents();
        
        setUpButtons();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


    }
    public MultiPlayer() {
        super(AppContext.getInstance(), GameEnums.GameMode.MULTIPLAYER);
        this.gameMode = MULTIPLAYER;
        initComponents();
        
        setUpButtons();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        startGame();
    }
    
    @Override
    protected void setUpButtons() {
        playerButtons = new JButton[][]{
            {oneBtnA, oneBtnS, oneBtnD, oneBtnF}, // Player 1
            {twoBtnH, twoBtnJ, Kbutton, Lbutton} // Player 2
        };
        playerKeys = new String[][]{
            {"A", "S", "D", "F"}, // Player 1 keys
            {"H", "J", "K", "L"}  // Player 2 keys
        };
        playerColors = new Color[][]{
            {Color.decode("#660099"), Color.decode("#6699FF")}, // Player 1 colors
            {Color.decode("#006666"), Color.decode("#6699FF")}  // Player 2 colors
        };
        playerButton();
    }
    
    @Override
    protected void playerButton() {
         for(int i = 0; i < playerButtons.length; i++){
            for (int j = 0; j < playerButtons[i].length; j++) {
                JButton btn = playerButtons[i][j];
                String key = playerKeys[i][j];
            final int playerIndex = i;
            ActionListener actionListener = (e) -> {
                if(!isProcessingFlag){
                    if(playerIndex ==0){
                        System.out.println("Player 1 First!");
                        firstPlayerAnswered = "playerOne";
                        
                    }
                    else{
                        System.out.println("Player 2 First!");
                        firstPlayerAnswered = "playerTwo";

                    }
                    actionPerformed(e);
                }
            };
            btn.addActionListener(actionListener);
            // Bind the action to the key
            KeyStroke keyStroke = KeyStroke.getKeyStroke(key);
            btn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "buttonAction" + key);
            btn.getActionMap().put("buttonAction" + key, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actionListener.actionPerformed(e);  // Trigger the same logic for key press
                }
            });

            // Add the action listener for mouse clicks

//                final var playerIndex = i;
//                final var buttonIndex = j;

                btn.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        if (!isProcessingFlag) {
                            btn.setBackground(playerColors[playerIndex][1]);  // Use player index (i) and button hover color (0)
                        }
                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        if (!isProcessingFlag) {
                            btn.setBackground(playerColors[playerIndex][0]);  // Use player index (i) and button default color (1)
                        }
                    }
                });

            }
        }
    }

    public void togglePlayerBtn(int index, boolean value) {
        for (JButton btn : playerButtons[index]) {
            btn.setEnabled(value);
        }
    }
    
    @Override
    protected void resetButtonColor(){
        
        for(int i = 0; i< playerButtons.length; i++){
            for (JButton btn: playerButtons[i]) {
                btn.setBackground(playerColors[i][0]);
                btn.setForeground(new Color(255,255,255));
            }
        }
    }
    public void randomizeOptionsOrder(List<String> options, int index) {
        for (int j = 0; j < playerButtons[index].length; j++) {
            playerButtons[index][j].setText("<html>" + String.join("<br>", options.get(j).split("\n")) + "</html>");
        }
    }

    public void displayQuestion() {
        mainQuestionLabel.setText("<html><div style='text-align: center;'>" +
                String.join("<br>", current.getQuestionText().split("\n")) + "</div></html>");
        for (int i = 0; i < playerButtons.length; i++) {
            List<String> options = new ArrayList<>(current.getOptions());
            Collections.shuffle(options);
            randomizeOptionsOrder(options, i);
        }
    }

    @Override
    protected void processPlayerAnswer(String playerAnswer, String player) {
       if (isProcessingFlag) return;

       if (firstPlayerAnswered.isEmpty()) {
           firstPlayerAnswered = player;
       }


       boolean isCorrect = gameLogic.checkAnswerPerQuestion(playerAnswer, current);

       if (isCorrect) {
           System.out.println(player + " answered correctly!");
           SwingUtilities.invokeLater(() -> changeBtnColor( playerAnswer, gameLogic.getCorrectAnswer(current)));
           finalizeRound(true, playerAnswer);  // End the round since the question was answered correctly
           return;
       }
       System.out.println(player + " answered incorrectly.");
       SwingUtilities.invokeLater(() -> togglePlayerBtn(player.equals("playerOne") ? 0 : 1, false)); // Disable current player's buttons

       if (player.equals("playerOne")) {
           isPlayerOneCorrect = true;
       } else {
           isPlayerTwoCorrect = true;
       }

        if(!isPlayerOneCorrect && !isPlayerTwoCorrect){
           System.out.println("Both players answered incorrectly. Skipping question...");
           finalizeRound(false, playerAnswer);  // End the round without awarding points
       }
   }

    private void finalizeRound(boolean isCorrect, String playerAnswer) {
        isProcessingFlag = true; 

        gameLogic.checkAnswer(isCorrect);
        gameLogic.updateQuestionUsed(isCorrect);
//        updatePlayerScore();

        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).thenCompose((v) -> CompletableFuture.runAsync(() -> SwingUtilities.invokeLater(() -> {
            toggleBtns(true); 
        }))).thenCompose((v) -> {
            if (!isCorrect) {
                return CompletableFuture.runAsync(() -> SwingUtilities.invokeLater(() -> {
                    changeBtnColor(playerAnswer, gameLogic.getCorrectAnswer(current));
                }));
            }
            return CompletableFuture.completedFuture(null);
        }).thenRunAsync(() -> {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).thenRun(() -> {
            SwingUtilities.invokeLater(() -> {
                resetButtonColor();
                isProcessingFlag = false;
                firstPlayerAnswered = ""; 
                isPlayerOneCorrect = false; 
                isPlayerTwoCorrect = false;
            });
        }).thenRun(() -> {
            // Display the next question
            SwingUtilities.invokeLater(() -> {
                if (GameOver.equals(gameLogic.getGameState())) return;
                displayNextQuestion();
            });
        });
    }


    @Override
    public void toggleBtns(boolean value) {
        PauseBtn.setEnabled(value);
        for (JButton[] btns : playerButtons) {
            for (JButton btn : btns) {
                btn.setEnabled(value);
            }
        }
    }

    @Override
     protected void changeBtnColor(String plyAnswer, String correctAnswer) {
                // Define colors
        Color correctColor = new Color(70, 229, 76);  // Green
        Color incorrectColor = new Color(229, 70, 70);  // Red
        Color selectedColor = new Color(255, 229, 76);  // Yellow (chosen button)
        Color blackText = new Color(0,0,0);

        resetButtonColor();

        for (JButton[] btns : playerButtons) {
            for (JButton choice : btns) {
                String choiceText = choice.getText();
                choiceText = choiceText.replaceAll("<.*?>", "");

                if (plyAnswer.equals(correctAnswer)) {
                    if (choiceText.equals(plyAnswer)) {
                        choice.setBackground(correctColor);
                        choice.setForeground(blackText);
                    } else {
                        choice.setBackground(incorrectColor); 
                    }
                } else {
                    if (choiceText.equals(correctAnswer)) {
                        choice.setBackground(correctColor); 
                        choice.setForeground(blackText);

                    } else {
                        choice.setBackground(incorrectColor); 
                    }
                }
            }
        }

    }


    @Override
    protected void displayNextQuestion() {
        current = gameLogic.getQuestionFromMap();
        SwingUtilities.invokeLater(this::displayQuestion);
    }


    @Override
    public void updateScoreLabel() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public GameEnums.GameMode getGameMode() {
        return gameMode;
    }

    @Override
    protected void updateTimeLabel(long timerMinutes, long timerSeconds) {
        SwingUtilities.invokeLater(() ->
                timerLabel.setText(String.format("%02d:%02d", timerMinutes, timerSeconds))
        );
    }


    @Override
    public void timeUpdate() {
       if (null != gameLogic.getGameState()) switch (gameLogic.getGameState()) {
            case Play:
                SwingUtilities.invokeLater(() ->
                        updateTimeLabel(gameLogic.getGameTimerClass().getTimerMinutes(),
                                gameLogic.getGameTimerClass().getTimerSeconds())
                );  break;
            case Pause:
 
                break;
            case GameOver:
                SwingUtilities.invokeLater(() ->toggleBtns(false));
                
                CompletableFuture.runAsync(() ->{
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }).thenCompose(v -> CompletableFuture.runAsync(() ->{
                    gameLogic.getGameTimerClass().stopTimer();
//                    session.getPlayer().setSinglePlay_Score(gameLogic.getPlayerScore());
//                    session.getPlayer().setPlayer_Average(gameLogic.computePlayerScore(gameLogic.getQuestionsUsed(), gameLogic.getQuesAnsweredCorrect()));
//                    
                })).thenRun(() -> {SwingUtilities.invokeLater(() ->{
                    
                    GameOver gameOver = appContext.getGameOver(appContext);
                    gameOver.fetchUpdatedScore();
                    gameOver.updatePlayerInfoLabels();
                    gameOver.setVisible(true);
                    
                    });
                
                }); 
                break;
            default:
                break;
        }
    }
    
    
    
    @Override
    public void startGame() {
        displayNextQuestion();
        gameLogic.getGameTimerClass().addEventUpdate(() -> SwingUtilities.invokeLater(this::timeUpdate));
        gameLogic.startTimer();    
    }
    
    @Override
    public void restartGame() {
        displayNextQuestion();
        SwingUtilities.invokeLater(() ->toggleBtns(true));
        gameLogic.startTimer();
    }

    @Override
    public void pauseGame() {
        if(PauseBtn.isSelected()){
            gameLogic.getGameTimerClass().setGameState(Pause);
            pauseBtnDelay(false);
            gameLogic.getGameTimerClass().pauseTimer();
        }
        else{
            gameLogic.getGameTimerClass().setGameState(Play);
            pauseBtnDelay(true);
            gameLogic.getGameTimerClass().startTimer();

        }    
    }
    
    public void pauseBtnDelay(boolean value){
        CompletableFuture.runAsync(() ->{
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        
        
        }).thenRun(() ->SwingUtilities.invokeLater(() ->{
            for(int i =0; i < playerButtons.length; i++){
                togglePlayerBtn(i, value);
            }
        }));
        
    }

    @Override
    public void stopGame() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String actionCmd = e.getActionCommand();
        System.out.println("ActionCommad: " + actionCmd);
        
        if(actionCmd.equals("Pause")){
            pauseGame();
        }
        
        for(String[] keys : playerKeys){
            for(String key : keys){
                if(actionCmd.toUpperCase().contains(key) && !actionCmd.equals("Pause")){
                    JButton src = (JButton) e.getSource();
                    String textFromBtn = src.getText();
                    String plyAnswer = textFromBtn.replaceAll("<.*?>", ""); // Removes all tags
                    answerTaken = true;
                    if(Play.equals(gameLogic.getGameState())){
                        processPlayerAnswer(plyAnswer, firstPlayerAnswered);
                    }
                    else{
                        System.out.println("GameState: " + gameLogic.getGameState());
                    }
                }
            }
        }


       

    
    }
    
    public static synchronized MultiPlayer getInstance(AppContext appContext){
        if(instance == null){
            instance = new MultiPlayer(appContext);
        }
        return instance;
    } 
    public static void resetInstance() {
        if (instance != null) {
            instance.dispose(); // Clean up the current instance
            instance = null;
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        mainQuestionLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        plyOneName = new javax.swing.JLabel();
        SocreLabel = new javax.swing.JLabel();
        SocreLabel1 = new javax.swing.JLabel();
        plyOneScoreLabel = new javax.swing.JLabel();
        SocreLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        oneBtnA = new javax.swing.JButton();
        oneBtnS = new javax.swing.JButton();
        oneBtnD = new javax.swing.JButton();
        oneLabelA = new javax.swing.JLabel();
        oneBtnF = new javax.swing.JButton();
        oneLabelS = new javax.swing.JLabel();
        oneLabelD = new javax.swing.JLabel();
        oneLabelF = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        plyTwoName = new javax.swing.JLabel();
        SocreLabel3 = new javax.swing.JLabel();
        SocreLabel4 = new javax.swing.JLabel();
        plyTwoScoreLabel = new javax.swing.JLabel();
        SocreLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        twoBtnH = new javax.swing.JButton();
        twoBtnJ = new javax.swing.JButton();
        Kbutton = new javax.swing.JButton();
        Lbutton = new javax.swing.JButton();
        twoLabelH = new javax.swing.JLabel();
        twoLabelJ = new javax.swing.JLabel();
        twoLabelK = new javax.swing.JLabel();
        twoLabelL = new javax.swing.JLabel();
        PauseBtn = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        mainQuestionLabel.setBackground(new java.awt.Color(0, 0, 0));
        mainQuestionLabel.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        mainQuestionLabel.setForeground(new java.awt.Color(255, 255, 255));
        mainQuestionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainQuestionLabel.setText("blank");
        mainQuestionLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainQuestionLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(mainQuestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(mainQuestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Time");

        timerLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        timerLabel.setForeground(new java.awt.Color(255, 255, 255));
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText("00:00");

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));

        jPanel4.setBackground(new java.awt.Color(0, 0, 51));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setPreferredSize(new java.awt.Dimension(0, 5));

        plyOneName.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyOneName.setForeground(new java.awt.Color(255, 255, 255));
        plyOneName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyOneName.setText("gawpo");

        SocreLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        SocreLabel.setForeground(new java.awt.Color(255, 255, 255));
        SocreLabel.setText("Score:");

        SocreLabel1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        SocreLabel1.setForeground(new java.awt.Color(255, 255, 255));
        SocreLabel1.setText("Name:");

        plyOneScoreLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyOneScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        plyOneScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyOneScoreLabel.setText("1 melyon");

        SocreLabel2.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        SocreLabel2.setForeground(new java.awt.Color(255, 255, 255));
        SocreLabel2.setText("PLAYER 1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(SocreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(plyOneScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(SocreLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SocreLabel2)
                            .addComponent(plyOneName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SocreLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SocreLabel1)
                    .addComponent(plyOneName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SocreLabel)
                    .addComponent(plyOneScoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        oneBtnA.setBackground(new java.awt.Color(102, 0, 153));
        oneBtnA.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        oneBtnA.setForeground(new java.awt.Color(255, 255, 255));
        oneBtnA.setText("---");
        oneBtnA.setActionCommand("choiceA");
        oneBtnA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oneBtnA.setFocusable(false);

        oneBtnS.setBackground(new java.awt.Color(102, 0, 153));
        oneBtnS.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        oneBtnS.setForeground(new java.awt.Color(255, 255, 255));
        oneBtnS.setText("---");
        oneBtnS.setActionCommand("choiceS");
        oneBtnS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oneBtnS.setFocusable(false);

        oneBtnD.setBackground(new java.awt.Color(102, 0, 153));
        oneBtnD.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        oneBtnD.setForeground(new java.awt.Color(255, 255, 255));
        oneBtnD.setText("---");
        oneBtnD.setActionCommand("choiceD");
        oneBtnD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oneBtnD.setFocusable(false);

        oneLabelA.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        oneLabelA.setForeground(new java.awt.Color(255, 255, 255));
        oneLabelA.setText("A");

        oneBtnF.setBackground(new java.awt.Color(102, 0, 153));
        oneBtnF.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        oneBtnF.setForeground(new java.awt.Color(255, 255, 255));
        oneBtnF.setText("---");
        oneBtnF.setActionCommand("choiceF");
        oneBtnF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oneBtnF.setFocusable(false);
        oneBtnF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        oneLabelS.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        oneLabelS.setForeground(new java.awt.Color(255, 255, 255));
        oneLabelS.setText("S");

        oneLabelD.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        oneLabelD.setForeground(new java.awt.Color(255, 255, 255));
        oneLabelD.setText("D");

        oneLabelF.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        oneLabelF.setForeground(new java.awt.Color(255, 255, 255));
        oneLabelF.setText("F");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(oneBtnA, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oneLabelA))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(oneBtnS, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(oneLabelS))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oneBtnD, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oneBtnF, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oneLabelD)
                            .addComponent(oneLabelF)))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oneBtnA, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneLabelA))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(oneLabelS))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(oneBtnS, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oneBtnD, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneLabelD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oneBtnF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneLabelF))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(0, 0, 51));

        jPanel8.setBackground(new java.awt.Color(0, 0, 51));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setPreferredSize(new java.awt.Dimension(0, 5));

        plyTwoName.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyTwoName.setForeground(new java.awt.Color(255, 255, 255));
        plyTwoName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyTwoName.setText("gwapo2");

        SocreLabel3.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        SocreLabel3.setForeground(new java.awt.Color(255, 255, 255));
        SocreLabel3.setText("Score:");

        SocreLabel4.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        SocreLabel4.setForeground(new java.awt.Color(255, 255, 255));
        SocreLabel4.setText("Name:");

        plyTwoScoreLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyTwoScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        plyTwoScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyTwoScoreLabel.setText("1melyon pud");

        SocreLabel5.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        SocreLabel5.setForeground(new java.awt.Color(255, 255, 255));
        SocreLabel5.setText("PLAYER 2");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(SocreLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(plyTwoScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(SocreLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(plyTwoName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(SocreLabel5)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SocreLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SocreLabel4)
                    .addComponent(plyTwoName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SocreLabel3)
                    .addComponent(plyTwoScoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jPanel6.setBackground(new java.awt.Color(0, 0, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        twoBtnH.setBackground(new java.awt.Color(0, 102, 102));
        twoBtnH.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        twoBtnH.setForeground(new java.awt.Color(255, 255, 255));
        twoBtnH.setText("---");
        twoBtnH.setActionCommand("choiceH");
        twoBtnH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        twoBtnH.setFocusable(false);

        twoBtnJ.setBackground(new java.awt.Color(0, 102, 102));
        twoBtnJ.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        twoBtnJ.setForeground(new java.awt.Color(255, 255, 255));
        twoBtnJ.setText("---");
        twoBtnJ.setActionCommand("choiceJ");
        twoBtnJ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        twoBtnJ.setFocusable(false);

        Kbutton.setBackground(new java.awt.Color(0, 102, 102));
        Kbutton.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        Kbutton.setForeground(new java.awt.Color(255, 255, 255));
        Kbutton.setText("---");
        Kbutton.setActionCommand("choiceK");
        Kbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Kbutton.setFocusable(false);

        Lbutton.setBackground(new java.awt.Color(0, 102, 102));
        Lbutton.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        Lbutton.setForeground(new java.awt.Color(255, 255, 255));
        Lbutton.setText("---");
        Lbutton.setActionCommand("choiceL");
        Lbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Lbutton.setFocusable(false);

        twoLabelH.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        twoLabelH.setForeground(new java.awt.Color(255, 255, 255));
        twoLabelH.setText("H");

        twoLabelJ.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        twoLabelJ.setForeground(new java.awt.Color(255, 255, 255));
        twoLabelJ.setText("J");

        twoLabelK.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        twoLabelK.setForeground(new java.awt.Color(255, 255, 255));
        twoLabelK.setText("K");

        twoLabelL.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        twoLabelL.setForeground(new java.awt.Color(255, 255, 255));
        twoLabelL.setText("L");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(twoLabelH, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(twoLabelJ, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(twoLabelK, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(twoLabelL, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(twoBtnJ, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoBtnH, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Kbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(twoBtnH, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoLabelH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(twoBtnJ, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoLabelJ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoLabelK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoLabelL)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );

        PauseBtn.setBackground(new java.awt.Color(0, 102, 204));
        PauseBtn.setForeground(new java.awt.Color(255, 255, 255));
        PauseBtn.setText("Pause");
        PauseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(PauseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PauseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timerLabel))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PauseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseBtnActionPerformed
        // TODO add your handling code here:
        actionPerformed(evt);

    }//GEN-LAST:event_PauseBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MultiPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MultiPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MultiPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MultiPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MultiPlayer().setVisible(true);
//                new MultiPlayer().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Kbutton;
    private javax.swing.JButton Lbutton;
    private javax.swing.JToggleButton PauseBtn;
    private javax.swing.JLabel SocreLabel;
    private javax.swing.JLabel SocreLabel1;
    private javax.swing.JLabel SocreLabel2;
    private javax.swing.JLabel SocreLabel3;
    private javax.swing.JLabel SocreLabel4;
    private javax.swing.JLabel SocreLabel5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel mainQuestionLabel;
    private javax.swing.JButton oneBtnA;
    private javax.swing.JButton oneBtnD;
    private javax.swing.JButton oneBtnF;
    private javax.swing.JButton oneBtnS;
    private javax.swing.JLabel oneLabelA;
    private javax.swing.JLabel oneLabelD;
    private javax.swing.JLabel oneLabelF;
    private javax.swing.JLabel oneLabelS;
    private javax.swing.JLabel plyOneName;
    private javax.swing.JLabel plyOneScoreLabel;
    private javax.swing.JLabel plyTwoName;
    private javax.swing.JLabel plyTwoScoreLabel;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JButton twoBtnH;
    private javax.swing.JButton twoBtnJ;
    private javax.swing.JLabel twoLabelH;
    private javax.swing.JLabel twoLabelJ;
    private javax.swing.JLabel twoLabelK;
    private javax.swing.JLabel twoLabelL;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void processPlayerAnswer(String playerAnswer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void askQuestion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean checkAnswer(String answer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 






}
