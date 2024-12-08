/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.ui;

import backend.Database.DatabaseManager;
import backend.Questions.Question;
import main.logic.AppContext;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import main.PlayerData.Player;
import main.PlayerData.Session;
import main.PlayerData.Single;
import main.logic.GameEnums;
import static main.logic.GameEnums.GameMode.MULTIPLAYER;
import static main.logic.GameEnums.GameMode.SINGLE_PLAYER;
import static main.logic.GameEnums.GameState.GameOver;
import static main.logic.GameEnums.GameState.Pause;
import static main.logic.GameEnums.GameState.Play;
import main.logic.GameLogic;
import main.logic.GameStructure;
import main.update.TimeUpdatable;

/**
 *
 * @author laroc
 * @author Jacinth
 */
public class SinglePlayer extends GameStructure{
    private static SinglePlayer instance;
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
//    private Timer reEnableTimer, nextQuestionTimer;
    
    
    

    /**
     * Creates new form singlePlayer
     * @param appContext
     */
    public SinglePlayer(AppContext appContext) {
        super(appContext, appContext.getGameMode());
        this.gameMode = SINGLE_PLAYER;

        initComponents();
        
        setUpButtons();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public SinglePlayer() {
        super(AppContext.getInstance(),SINGLE_PLAYER);
        this.gameMode = SINGLE_PLAYER;
        this.session.setPlayer(new Single("1", "Gwapo",  0));
        initComponents();
        setUpButtons();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        startGame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        mainQuestionLabel = new javax.swing.JLabel();
        choiceQ = new javax.swing.JButton();
        choiceE = new javax.swing.JButton();
        choiceR = new javax.swing.JButton();
        choiceW = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        ply1Name = new javax.swing.JLabel();
        SocreLabel = new javax.swing.JLabel();
        SocreLabel1 = new javax.swing.JLabel();
        plyScoreLabel = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PauseBtn = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(0, 0, 51));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        mainQuestionLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        mainQuestionLabel.setForeground(new java.awt.Color(255, 255, 255));
        mainQuestionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainQuestionLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(mainQuestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(mainQuestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        choiceQ.setBackground(new java.awt.Color(0, 102, 204));
        choiceQ.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        choiceQ.setForeground(new java.awt.Color(255, 255, 255));
        choiceQ.setActionCommand("choiceQ");
        choiceQ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceQ.setFocusable(false);
        choiceQ.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        choiceE.setBackground(new java.awt.Color(0, 102, 204));
        choiceE.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        choiceE.setForeground(new java.awt.Color(255, 255, 255));
        choiceE.setActionCommand("choiceE");
        choiceE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceE.setFocusable(false);
        choiceE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        choiceR.setBackground(new java.awt.Color(0, 102, 204));
        choiceR.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        choiceR.setForeground(new java.awt.Color(255, 255, 255));
        choiceR.setActionCommand("choiceR");
        choiceR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceR.setFocusable(false);
        choiceR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        choiceW.setBackground(new java.awt.Color(0, 102, 204));
        choiceW.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        choiceW.setForeground(new java.awt.Color(255, 255, 255));
        choiceW.setActionCommand("choiceW");
        choiceW.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceW.setFocusable(false);
        choiceW.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setPreferredSize(new java.awt.Dimension(0, 5));

        ply1Name.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        ply1Name.setForeground(new java.awt.Color(255, 255, 255));
        ply1Name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ply1Name.setText(session.getPlayer().getPlayerName()
        );

        SocreLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        SocreLabel.setForeground(new java.awt.Color(255, 255, 255));
        SocreLabel.setText("Score:");

        SocreLabel1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        SocreLabel1.setForeground(new java.awt.Color(255, 255, 255));
        SocreLabel1.setText("Name:");

        plyScoreLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        plyScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyScoreLabel.setText(String.valueOf(gameLogic.getPlayerScore()));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(SocreLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ply1Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(SocreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(plyScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SocreLabel1)
                    .addComponent(ply1Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SocreLabel)
                    .addComponent(plyScoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        timerLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        timerLabel.setForeground(new java.awt.Color(255, 255, 255));
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText("00:00");

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Time");

        PauseBtn.setBackground(new java.awt.Color(0, 102, 204));
        PauseBtn.setForeground(new java.awt.Color(255, 255, 255));
        PauseBtn.setActionCommand("Pause");
        PauseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(choiceQ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(choiceE, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(choiceW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(choiceR, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(jLabel1)))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(253, 253, 253)
                                .addComponent(PauseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(PauseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timerLabel)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(choiceW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(choiceQ, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(choiceE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(choiceR, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PauseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseBtnActionPerformed
        // TODO add your handling code here:
        actionPerformed(evt);
        
    }//GEN-LAST:event_PauseBtnActionPerformed
    
    
    // TODO: Guba Pa na version 
    /*
        Kani na function kay dili pa mao
    */

    public void displayQuestion(){
        mainQuestionLabel.setText("<html><div style='text-align: center;'>" + String.join("<br>", current.getQuestionText().split("\n")) + "</div></html>");
        for(int i =0; i < playerButton.length; i++){
           playerButton[i].setText("<html>" + String.join("<br>", current.getOptions().get(i).split("\n")) + "</html>");
        }
    }

    @Override
    protected void setUpButtons() {
        playerButton = new JButton[]{
            choiceQ, choiceW, choiceE, choiceR
        };
        
//        if (playBtn == null || pauseBtn == null) {
//            System.out.println("Icons are not loaded properly.");
//        }
        PauseBtn.setIcon(pauseBtn);
        playerButton();
    }

    @Override
    protected void playerButton(){
        for(JButton btn : playerButton){
            btn.addActionListener((e) -> {
                if(!isProcessingFlag){
                    actionPerformed(e);
                }
            });

            btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(!isProcessingFlag){
                    btn.setBackground(Color.decode("#6699FF")); 

                }

            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(!isProcessingFlag) {
                    btn.setBackground(Color.decode("#0066CC")); 
                }
            }
            });

        }
    }


    @Override
    protected void processPlayerAnswer(String playerAnswer) {
        if (isProcessingFlag) return;

        isProcessingFlag = true; 

        boolean isCorrect = gameLogic.checkAnswerPerQuestion(playerAnswer, current);
        System.out.println("IsCorrect? " + isCorrect);
        gameLogic.checkAnswer(isCorrect);
        gameLogic.updateQuestionUsed(isCorrect);
        updateScoreLabel();
        SwingUtilities.invokeLater(() -> changeBtnColor( playerAnswer, gameLogic.getCorrectAnswer(current)));


        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(700); // Delay before resetting colors
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).thenRun(() -> SwingUtilities.invokeLater(() -> {
            resetButtonColor();
            if(GameOver.equals(gameLogic.getGameState())) return;
            displayNextQuestion();
            isProcessingFlag = false; // Re-enable interactions
        }));

    }

    @Override
    protected void changeBtnColor(String plyAnswer, String correctAnswer) {
        Color correctColor = new Color(70, 229, 76); // Green
        Color incorrectColor = new Color(229, 70, 70); // Red

        resetButtonColor();

        for (JButton choice : playerButton) {
            String choiceText = choice.getText();
            choiceText = choiceText.replaceAll("<.*?>", "");
            if (choiceText.equals(correctAnswer)) {
                choice.setBackground(correctColor);
            } else {
                choice.setBackground(incorrectColor);
            }
        }    
    }

    @Override
    protected void updateTimeLabel(long timerMinutes, long timerSeconds) {
        if (Play.equals(gameLogic.getGameState())) {
            SwingUtilities.invokeLater(() -> 
                timerLabel.setText(String.format("%02d:%02d", timerMinutes, timerSeconds))
            );
        }
    }

    @Override
    public void updateScoreLabel() {
        if(Play.equals(gameLogic.getGameState())){
            System.out.println("Player Score: " + gameLogic.getPlayerScore());
            plyScoreLabel.setText(String.valueOf(gameLogic.getPlayerScore()));
        }    
    }

    @Override
    protected void resetButtonColor(){
        for (JButton btn: playerButton) {
            btn.setBackground(SINGLE_DEFAULT_COLOR);
            btn.setForeground(new Color(255,255,255));
        }
    }

    @Override
    public void toggleBtns(boolean value){
        PauseBtn.setEnabled(value);
        for(JButton btn : playerButton){
            btn.setEnabled(value);
       }
    }


    @Override
    public GameEnums.GameMode getGameMode() {
        return gameMode;
    }

    @Override
    public void startGame() {
        displayNextQuestion();
        gameLogic.getGameTimerClass().addEventUpdate(() -> SwingUtilities.invokeLater(this::timeUpdate));
        PauseBtn.setSelected(false);
        PauseBtn.setIcon(pauseBtn);
        gameLogic.startTimer();
    }
    
    @Override
    public void restartGame() {
        gameLogic.startTimer();
        displayNextQuestion();
        SwingUtilities.invokeLater(() ->toggleBtns(true));
        PauseBtn.setSelected(false);
        PauseBtn.setIcon(pauseBtn);
        updateScoreLabel();
        repaint();
        revalidate();

    }

    @Override
    public void pauseGame() {
        if (PauseBtn.isSelected()) {
          // Set icon to play button
          PauseBtn.setIcon(playBtn);
          pauseBtnDelay(false);
          
          gameLogic.getGameTimerClass().setGameState(Pause);
          gameLogic.getGameTimerClass().pauseTimer();
      } else {

          PauseBtn.setIcon(pauseBtn);
          pauseBtnDelay(true);

          gameLogic.getGameTimerClass().setGameState(Play);
          gameLogic.getGameTimerClass().startTimer();
      }
          PauseBtn.revalidate();
          PauseBtn.repaint();

    }
    
    public void pauseBtnDelay(boolean value) {
       CompletableFuture.runAsync(() -> {
           try {
               // Wait for the delay before showing the pause screen
               Thread.sleep(500);  // 500ms delay
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }).thenCompose(v -> CompletableFuture.runAsync(() -> {
           // Reset and show the pause screen after the delay
           appContext.resetPauseFrame();
           // Ensure the pause screen is made visible in the event dispatch thread
           SwingUtilities.invokeLater(() -> {
             pauseScreen = appContext.getPauseScreen(appContext);
             pauseScreen.setLocationRelativeTo(this);
             pauseScreen.setVisible(true);
           });
       })).thenRun(() -> SwingUtilities.invokeLater(() -> {
           // Update the button state or do other UI updates after the delay
           toggleBtns(value);
       }));
   }

    @Override
    public void stopGame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void displayNextQuestion() {
        current = gameLogic.getQuestionFromMap();
        SwingUtilities.invokeLater(this::displayQuestion);    
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
                System.out.println("Paused!");
                pauseGame();
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
                    session.getPlayer().setSinglePlay_Score(gameLogic.getPlayerScore());
                    session.getPlayer().setPlayer_Average(gameLogic.computePlayerScore(gameLogic.getQuestionsUsed(), gameLogic.getQuesAnsweredCorrect()));
                    
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
    public void actionPerformed(ActionEvent e) {
        String actionCmd = e.getActionCommand();
//        System.out.println(actionCmd);
        if(actionCmd.equals("choiceQ") || actionCmd.equals("choiceW") || actionCmd.equals("choiceE") || actionCmd.equals("choiceR")){
            JButton src = (JButton) e.getSource();
            
            String textFromBtn = src.getText();
            String plyAnswer = textFromBtn.replaceAll("<.*?>", ""); // Removes all tags

            if(Play.equals(gameLogic.getGameState())){
                processPlayerAnswer(plyAnswer);
            }
            else{
                System.out.println("GameState: " + gameLogic.getGameState());
            }
            
           
        }
        else if(actionCmd.equals("Pause")){
            pauseGame();
        }
       

    }

    
    public static synchronized SinglePlayer getInstance(AppContext appContext){
        if(instance == null){
            instance = new SinglePlayer(appContext);
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
            java.util.logging.Logger.getLogger(SinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SinglePlayer().setVisible(true);
            }
        });
    }
    
    @Override
    public JToggleButton getPauseBtn() {
        return PauseBtn;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton PauseBtn;
    private javax.swing.JLabel SocreLabel;
    private javax.swing.JLabel SocreLabel1;
    private javax.swing.JButton choiceE;
    private javax.swing.JButton choiceQ;
    private javax.swing.JButton choiceR;
    private javax.swing.JButton choiceW;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mainQuestionLabel;
    private javax.swing.JLabel ply1Name;
    private javax.swing.JLabel plyScoreLabel;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void processPlayerAnswer(String playerAnswer, String player) {
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

