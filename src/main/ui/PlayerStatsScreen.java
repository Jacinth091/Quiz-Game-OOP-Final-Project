/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.ui;

import backend.Database.DatabaseManager;
import java.util.concurrent.CompletableFuture;
import main.PlayerData.Session;
import main.logic.AppContext;
import static main.logic.GameEnums.GameState.Play;

/**
 *
 * @author PCC
 */
public class PlayerStatsScreen extends javax.swing.JFrame {
    private AppContext appContext;
    private Session session;

    /**
     * Creates new form PlayerStatsScreen
     * @param appContext
     */
    public PlayerStatsScreen(AppContext appContext) {
        this.appContext = appContext;
        this.session = appContext.getSession();
        initComponents();
        setLocationRelativeTo(null);

    }
    
    public PlayerStatsScreen() {
        this.appContext = AppContext.getInstance();
        
        this.session = appContext.getSession();
        initComponents();
        setLocationRelativeTo(null);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jSeparator9 = new javax.swing.JSeparator();
        ply1Name5 = new javax.swing.JLabel();
        SocreLabel12 = new javax.swing.JLabel();
        SocreLabel13 = new javax.swing.JLabel();
        plyScoreLabel7 = new javax.swing.JLabel();
        SocreLabel14 = new javax.swing.JLabel();
        plyScoreLabel8 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        homeBtn = new javax.swing.JButton();
        plyAgainBtn = new javax.swing.JButton();
        SocreLabel18 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        plyIdLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(508, 555));

        jPanel5.setBackground(new java.awt.Color(0, 0, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(500, 555));

        jPanel8.setBackground(new java.awt.Color(173, 216, 230));

        jPanel9.setBackground(new java.awt.Color(0, 0, 51));

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator9.setPreferredSize(new java.awt.Dimension(0, 5));

        ply1Name5.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        ply1Name5.setForeground(new java.awt.Color(255, 255, 255));
        ply1Name5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ply1Name5.setText(session.getPlayer().getPlayerName()
        );

        SocreLabel12.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        SocreLabel12.setForeground(new java.awt.Color(255, 255, 255));
        SocreLabel12.setText("Score");

        SocreLabel13.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        SocreLabel13.setForeground(new java.awt.Color(255, 255, 255));
        SocreLabel13.setText("Player Name ");

        plyScoreLabel7.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyScoreLabel7.setForeground(new java.awt.Color(255, 255, 255));
        plyScoreLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyScoreLabel7.setText(String.valueOf(appContext.getGameLogic(appContext.getGameMode()).getPlayerScore()
        ));

        SocreLabel14.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        SocreLabel14.setForeground(new java.awt.Color(255, 255, 255));
        SocreLabel14.setText("No Of Questions ");

        plyScoreLabel8.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyScoreLabel8.setForeground(new java.awt.Color(255, 255, 255));
        plyScoreLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyScoreLabel8.setText(String.valueOf(appContext.getGameLogic(appContext.getGameMode()).getQuestionsUsed()
        ));

        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator10.setPreferredSize(new java.awt.Dimension(0, 5));

        homeBtn.setText("Home");
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        plyAgainBtn.setText("Play Again");
        plyAgainBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plyAgainBtnActionPerformed(evt);
            }
        });

        SocreLabel18.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        SocreLabel18.setForeground(new java.awt.Color(255, 255, 255));
        SocreLabel18.setText("Player ID");

        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator13.setPreferredSize(new java.awt.Dimension(0, 5));

        plyIdLabel.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        plyIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyIdLabel.setText(session.getPlayer().getPlayerId()
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(plyAgainBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(SocreLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plyIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(SocreLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plyScoreLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(SocreLabel13)
                        .addGap(50, 50, 50)
                        .addComponent(ply1Name5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(SocreLabel14)
                        .addGap(26, 26, 26)
                        .addComponent(plyScoreLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SocreLabel13)
                    .addComponent(ply1Name5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SocreLabel18)
                    .addComponent(plyIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SocreLabel12)
                    .addComponent(plyScoreLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SocreLabel14)
                    .addComponent(plyScoreLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(homeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plyAgainBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(229, 225, 218));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Game Over");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(47, 47, 47)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void plyAgainBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plyAgainBtnActionPerformed
//        appContext.getGameThread().setGameState(Play);
        this.dispose();
        CompletableFuture<Void> loadingFuture = CompletableFuture.runAsync(() -> {

        appContext.getLoadingScreen().start(); // Starts the loading screen and runs its thread
        while (!appContext.getLoadingScreen().getIsLoadingComplete()) {
            try {
                Thread.sleep(10); // Check periodically if loading is complete
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }).thenRun(() -> {
            appContext.getLoadingScreen().setIsLoadingComplete(false);
            appContext.getLoadingScreen().dispose();



        }).thenCompose(v -> CompletableFuture.runAsync(() -> {
            appContext.getSinglePlayer().toggleBtns(true);
        
        })).thenRun(() -> {
            appContext.getGameLogic(appContext.getGameMode()).setGameState(Play);
            appContext.getGameLogic(appContext.getGameMode()).restartGame();
            appContext.getSinglePlayer().updatePlayerScore();
            appContext.getGameLogic(appContext.getGameMode()).getGameTimerClass().startTimer();
            this.dispose();

        });
            // TODO add your handling code here:
    }//GEN-LAST:event_plyAgainBtnActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CompletableFuture<Void> loadingFuture = CompletableFuture.runAsync(() -> {

        appContext.getLoadingScreen().start(); // Starts the loading screen and runs its thread
        while (!appContext.getLoadingScreen().getIsLoadingComplete()) {
            try {
                Thread.sleep(10); // Check periodically if loading is complete
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }).thenRun(() -> {
            appContext.getLoadingScreen().setIsLoadingComplete(false);
            appContext.getLoadingScreen().dispose();
        }).thenCompose(v -> CompletableFuture.runAsync(() -> {
            appContext.getSinglePlayer().toggleBtns(true);
            
        })).thenRun(() -> {
            appContext.getSinglePlayer().dispose();
            appContext.getGameLogic(appContext.getGameMode()).setGameState(Play);
            appContext.getGameLogic(appContext.getGameMode()).restartGame();
            appContext.getSinglePlayer().updatePlayerScore();
//            appContext.getGameLogic(appContext.getGameMode()).getGameTimerClass().startTimer();
            new HomeForm(appContext).setVisible(true);
            this.dispose();

        });

    }//GEN-LAST:event_homeBtnActionPerformed

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
            java.util.logging.Logger.getLogger(PlayerStatsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerStatsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerStatsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerStatsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerStatsScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SocreLabel12;
    private javax.swing.JLabel SocreLabel13;
    private javax.swing.JLabel SocreLabel14;
    private javax.swing.JLabel SocreLabel18;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel ply1Name5;
    private javax.swing.JButton plyAgainBtn;
    private javax.swing.JLabel plyIdLabel;
    private javax.swing.JLabel plyScoreLabel7;
    private javax.swing.JLabel plyScoreLabel8;
    // End of variables declaration//GEN-END:variables
}
