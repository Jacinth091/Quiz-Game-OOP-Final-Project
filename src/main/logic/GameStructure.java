/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;

import backend.Database.DatabaseManager;
import backend.Questions.Question;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import main.PlayerData.Session;
import static main.logic.GameEnums.GameState.Pause;
import static main.logic.GameEnums.GameState.Play;
import main.update.TimeUpdatable;

/**
 *
 * @author PCC
 */
public abstract class GameStructure extends javax.swing.JFrame implements TimeUpdatable, Playable ,Askable,java.awt.event.ActionListener{
    
    protected AppContext appContext;
    protected DatabaseManager dbManager;
    protected Session session;
    protected GameLogic gameLogic;

    protected Timer gameTimer;
    protected Question current;
    protected Question next;

    protected boolean isProcessingFlag;
    protected boolean answerTaken;
    protected boolean isPlayerOneCorrect;
    protected boolean isPlayerTwoCorrect;

    protected String firstPlayerAnswered = "";

    protected JButton[] playerButton;
    protected String[] playerKey;
    protected final Color SINGLE_DEFAULT_COLOR = Color.decode("#0066CC");
    protected final Color SINGLE_HOVER_COLOR = Color.decode("#6699FF");
    
    
    protected JButton[][] playerButtons;
    protected String[][] playerKeys;
    protected Color[][] playerColors;

    public GameStructure(AppContext appContext, GameEnums.GameMode gameMode) {
        this.appContext = appContext;
        if (appContext == null) {
            throw new IllegalArgumentException("AppContext cannot be null");
        }
        this.dbManager = appContext.getDbManager();
        this.appContext.setGameMode(gameMode);
        this.session = appContext.getSession();
        this.gameLogic = appContext.getGameLogic(gameMode);
        if (this.gameLogic == null) {
            throw new IllegalStateException("GameLogic must be initialized");
        }
        else if(gameLogic.getGameMode() == null){
            throw new IllegalStateException("GameLogic must be initialized");
        }
//        initComponents();
//        setUpButtons();
    }
    protected abstract void setUpButtons();    
    protected abstract void playerButton();
    protected abstract void resetButtonColor();

    protected abstract void processPlayerAnswer(String playerAnswer, String player);    
    protected abstract void processPlayerAnswer(String playerAnswer);

    protected abstract void displayNextQuestion();
//    protected abstract void updatePlayerScore();
    public abstract void toggleBtns(boolean value);
    protected abstract void changeBtnColor(String plyAnswer, String correctAnswer);
    protected abstract void updateTimeLabel(long timerMinutes, long timerSeconds);
    public abstract void updateScoreLabel();    
//    protected abstract void updateScoreLabel(JLabel plyOneScoreLabel, JLabel plyTwoScoreLabel);

    public abstract GameEnums.GameMode getGameMode();

    protected void resetButtonColors(JButton[][] playerButtons, Color[][] playerColors) {
        for (int i = 0; i < playerButtons.length; i++) {
            for (JButton playerButton : playerButtons[i]) {
                playerButton.setBackground(playerColors[i][0]);
                playerButton.setForeground(Color.WHITE);
            }
        }
    }

    protected void togglePlayerBtn(JButton[][] playerButtons, int index, boolean value) {
        for (JButton btn : playerButtons[index]) {
            btn.setEnabled(value);
        }
    }
    
    
    
}
