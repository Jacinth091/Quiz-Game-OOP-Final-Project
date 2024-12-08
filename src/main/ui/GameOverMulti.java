/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.ui;

import backend.Database.DatabaseManager;
import java.util.concurrent.CompletableFuture;
import main.PlayerData.Session;
import main.logic.AppContext;
import static main.logic.GameEnums.GameMode.MULTIPLAYER;
import static main.logic.GameEnums.GameMode.SINGLE_PLAYER;

/**
 *
 * @author PCC
 */
public class GameOverMulti extends javax.swing.JFrame {

   public static GameOverMulti instance;
    public AppContext appContext;
    public Session session;
    public DatabaseManager dbManager;
    private CompletableFuture<Void> transition;

    private String playerOneName;
    private int playerOneScore;
    private double playerOneAverage;
    
    private String playerTwoName;
    private int playerTwoScore;
    private double playerTwoAverage;
    
    /**
     * Creates new form GameOverMulti
     */
    public GameOverMulti(AppContext appContext) {
        this.appContext = appContext;
        this.dbManager = appContext.getDbManager();
        this.session = appContext.getSession();
        initComponents();
        fetchUpdatedScore();
        setLocationRelativeTo(null);
    }

    public GameOverMulti() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        plyOneName = new javax.swing.JLabel();
        plyOneScore = new javax.swing.JLabel();
        plyOneAverage = new javax.swing.JLabel();
        plyAgainBtn = new javax.swing.JButton();
        HomeBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        plyTwoName = new javax.swing.JLabel();
        plyTwoScore = new javax.swing.JLabel();
        plyTwoAverage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GAME OVER");

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Player Name: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Score: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Average:");

        plyOneName.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyOneName.setForeground(new java.awt.Color(255, 255, 255));
        plyOneName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyOneName.setText("Gwapo");

        plyOneScore.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyOneScore.setForeground(new java.awt.Color(255, 255, 255));
        plyOneScore.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyOneScore.setText("0");

        plyOneAverage.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyOneAverage.setForeground(new java.awt.Color(255, 255, 255));
        plyOneAverage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyOneAverage.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(plyOneScore, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4)
                        .addGap(43, 43, 43)
                        .addComponent(plyOneAverage, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(plyOneName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plyOneName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plyOneScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plyOneAverage, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        plyAgainBtn.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        plyAgainBtn.setForeground(new java.awt.Color(0, 0, 51));
        plyAgainBtn.setText("Play Again");
        plyAgainBtn.setBorderPainted(false);
        plyAgainBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        plyAgainBtn.setFocusable(false);
        plyAgainBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plyAgainBtnActionPerformed(evt);
            }
        });

        HomeBtn.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        HomeBtn.setForeground(new java.awt.Color(0, 0, 51));
        HomeBtn.setText("Home");
        HomeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HomeBtn.setFocusable(false);
        HomeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBtnActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Player Name: ");

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total Score: ");

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Average:");

        plyTwoName.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyTwoName.setForeground(new java.awt.Color(255, 255, 255));
        plyTwoName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyTwoName.setText("Gwapo");

        plyTwoScore.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyTwoScore.setForeground(new java.awt.Color(255, 255, 255));
        plyTwoScore.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyTwoScore.setText("0");

        plyTwoAverage.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyTwoAverage.setForeground(new java.awt.Color(255, 255, 255));
        plyTwoAverage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyTwoAverage.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator11)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(plyTwoScore, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel14)
                        .addGap(42, 42, 42)
                        .addComponent(plyTwoAverage, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(plyTwoName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
            .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plyTwoName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plyTwoScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plyTwoAverage, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plyAgainBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(245, 245, 245))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plyAgainBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void plyAgainBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plyAgainBtnActionPerformed
     // Logic to restart the game
        dispose();

        transition = CompletableFuture.runAsync(() -> {
            appContext.getLoadingScreen().start();
            while (!appContext.getLoadingScreen().getIsLoadingComplete()) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        transition.thenRun(() -> {
            appContext.getLoadingScreen().setIsLoadingComplete(false);
            appContext.getLoadingScreen().dispose();
            appContext.getGameLogic(appContext.getGameMode()).resetGameLogic();
            appContext.getGame().restartGame();
        });
    }//GEN-LAST:event_plyAgainBtnActionPerformed

    private void HomeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBtnActionPerformed
        dispose();

        transition = CompletableFuture.runAsync(() -> {
            appContext.getLoadingScreen().start();
            while (!appContext.getLoadingScreen().getIsLoadingComplete()) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        transition.thenCompose(v -> CompletableFuture.runAsync(() -> {
            if (MULTIPLAYER.equals(appContext.getGame().getGameMode())) {
                appContext.resetMultiPlayer();
            } else if (SINGLE_PLAYER.equals(appContext.getGame().getGameMode())) {
                appContext.resetSinglePlayer();
            }

            appContext.getGameLogic(appContext.getGameMode()).resetGameLogic(); // Reset game logic here

        })).thenRun(() -> {
            new HomeForm(appContext).setVisible(true);
            appContext.getLoadingScreen().dispose();
        });
    }//GEN-LAST:event_HomeBtnActionPerformed

    
    public void fetchUpdatedScore() {
        // Fetch updated score information for both players
         playerOneName = appContext.getGameLogic(appContext.getGameMode()).getMultiManager().getPlayerOne().getPlayerName();
         playerOneScore = appContext.getGameLogic(appContext.getGameMode()).getMultiManager().getPlayerOne().getSinglePlay_Score();
         playerOneAverage = appContext.getGameLogic(appContext.getGameMode()).getMultiManager().getPlayerOne().getPlayer_Average();

         playerTwoName = appContext.getGameLogic(appContext.getGameMode()).getMultiManager().getPlayerTwo().getPlayerName();
         playerTwoScore = appContext.getGameLogic(appContext.getGameMode()).getMultiManager().getPlayerTwo().getSinglePlay_Score();
         playerTwoAverage = appContext.getGameLogic(appContext.getGameMode()).getMultiManager().getPlayerTwo().getPlayer_Average();


    }
    public void updatePlayerInfoLabels(){
        plyOneName.setText(playerOneName);
        plyOneScore.setText(String.valueOf(playerOneScore));
        plyOneAverage.setText(String.format("%.2f %%", playerOneAverage));

        plyTwoName.setText(playerTwoName);
        plyTwoScore.setText(String.valueOf(playerTwoScore));
        plyTwoAverage.setText(String.format("%.2f %%", playerTwoAverage));
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
            java.util.logging.Logger.getLogger(GameOverMulti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOverMulti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOverMulti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOverMulti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameOverMulti().setVisible(true);
            }
        });
    }
    
    public static synchronized GameOverMulti getInstance(AppContext appContext){
        if(instance == null){
            instance = new GameOverMulti(appContext);
        }
        return instance;
    } 
    public static void resetInstance() {
        if (instance != null) {
            instance.dispose(); // Clean up the current instance
            instance = null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HomeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton plyAgainBtn;
    private javax.swing.JLabel plyOneAverage;
    private javax.swing.JLabel plyOneName;
    private javax.swing.JLabel plyOneScore;
    private javax.swing.JLabel plyTwoAverage;
    private javax.swing.JLabel plyTwoName;
    private javax.swing.JLabel plyTwoScore;
    // End of variables declaration//GEN-END:variables
}
