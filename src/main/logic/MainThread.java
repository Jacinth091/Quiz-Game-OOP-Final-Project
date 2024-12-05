///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package main.logic;
//
//import java.util.ArrayList;
//import javax.swing.Timer;
//import main.ui.PlayerStatsScreen;
////import main.ui.HomeForm;
//
///**
// *
// * @author PCC
// */
//public class MainThread {
//    private static MainThread instance;
//    private Timer gameTimer;
//    private GameEnums.GameState gameState;
//    private GameEnums.GameState prevGameState;
//
//    private final ArrayList<Updatable> updates = new ArrayList<>();
//    private int FPS = 25;
//
//    public MainThread() {
//        gameState = GameEnums.GameState.Play;
//        initGameTimer();
//    }
//
//    private void initGameTimer() {
//        int delay = 1000 / FPS; // Frame interval in milliseconds
//        gameTimer = new Timer(delay, e -> {
//            update(); // Call update for each frame
//        });
//    }
//
//    public void startThread() {
//        if (!gameTimer.isRunning()) {
//            gameTimer.start();
//        }
//    }
//
//    public void stopThread() {
//        if (gameTimer.isRunning()) {
//            gameTimer.stop();
//        }
//    }
//
//    public void update() {
//        notifyGameUpdates(); // Notify all registered game components
//        checkGameState(); // Handle game state changes
//    }
//
//    public synchronized void notifyGameUpdates() {
//        synchronized (updates) {
//            for (Updatable update : updates) {
//                update.update(); // Call update on all registered objects
//            }
//        }
//    }
//
//    public void addEventUpdate(Updatable gameUpdate) {
//        updates.add(gameUpdate);
//    }
//
//    public static synchronized MainThread getInstance() {
//        if (instance == null) {
//            instance = new MainThread();
//        }
//        return instance;
//    }
//
//    public void checkGameState() {
//        if (gameState != null && gameState != prevGameState) {
//            switch (gameState) {
//                case Play:
//                    System.out.println("Game is playing...");
//                    break;
//                case Pause:
//                    javax.swing.JOptionPane.showMessageDialog(null, "Game Paused");
//                    stopThread(); // Pause the timer
//                    break;
//                case GameOver:
//                    javax.swing.JOptionPane.showMessageDialog(null, "Game Over");
//                    stopThread(); // Stop the timer
//                    new PlayerStatsScreen().setVisible(true);
//                    break;
//            }
//            prevGameState = gameState;
//        }
//    }
//
//    public GameEnums.GameState getGameState() {
//        return gameState;
//    }
//
//    public void setGameState(GameEnums.GameState gameState) {
//        this.gameState = gameState;
//        if (gameState == GameEnums.GameState.Play && !gameTimer.isRunning()) {
//            startThread(); // Resume the timer if the game is playing
//        }
//    }
//
//    public static void main(String[] args) {
//        java.awt.EventQueue.invokeLater(() -> {
//            MainThread mainThread = MainThread.getInstance();
//            mainThread.startThread();
//        });
//    }
//    
//}
