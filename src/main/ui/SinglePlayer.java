/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.ui;

import backend.Database.DatabaseManager;
import main.logic.AppContext;
import java.awt.Color;
import javax.swing.Timer;
import main.PlayerData.Session;

/**
 *
 * @author laroc
 * @author Jacinth
 */
public class SinglePlayer extends javax.swing.JFrame {
    private AppContext appContext;
    private DatabaseManager dbManager;
    private Session session;

    private SinglePlayerLogic singleLogic;

    /**
     * Creates new form singlePlayer
     * @param appContext
     */
    public SinglePlayer(AppContext appContext) {
        this.appContext = appContext;
        this.dbManager = appContext.getDbManager();
        this.session = appContext.getSession();
        singleLogic = new SinglePlayerLogic(appContext, this);

        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        singleLogic.startTimer();

    }

    public SinglePlayer() {

        initComponents();

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


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
        choiceA = new javax.swing.JButton();
        choiceS = new javax.swing.JButton();
        QLabel = new javax.swing.JLabel();
        ALabel = new javax.swing.JLabel();
        Wlabel = new javax.swing.JLabel();
        choiceW = new javax.swing.JButton();
        SLabel = new javax.swing.JLabel();
        goBack = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        ply1Name = new javax.swing.JLabel();
        SocreLabel = new javax.swing.JLabel();
        SocreLabel1 = new javax.swing.JLabel();
        plyScore = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(0, 0, 51));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        mainQuestionLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        mainQuestionLabel.setForeground(new java.awt.Color(255, 255, 255));
        mainQuestionLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mainQuestionLabel.setText("ASA KO NAGKUWANG???????????????????????????????????????????????????? ");
        mainQuestionLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mainQuestionLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(mainQuestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(mainQuestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        choiceQ.setBackground(new java.awt.Color(0, 102, 204));
        choiceQ.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        choiceQ.setForeground(new java.awt.Color(255, 255, 255));
        choiceQ.setText("Mars");
        choiceQ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceQ.setFocusable(false);
        choiceQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                choiceQMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choiceQMouseExited(evt);
            }
        });
        choiceQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiceQActionPerformed(evt);
            }
        });

        choiceA.setBackground(new java.awt.Color(0, 102, 204));
        choiceA.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        choiceA.setForeground(new java.awt.Color(255, 255, 255));
        choiceA.setText("Earth");
        choiceA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceA.setFocusable(false);
        choiceA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                choiceAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choiceAMouseExited(evt);
            }
        });
        choiceA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiceAActionPerformed(evt);
            }
        });

        choiceS.setBackground(new java.awt.Color(0, 102, 204));
        choiceS.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        choiceS.setForeground(new java.awt.Color(255, 255, 255));
        choiceS.setText("Jupiter");
        choiceS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceS.setFocusable(false);
        choiceS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                choiceSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choiceSMouseExited(evt);
            }
        });

        QLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        QLabel.setForeground(new java.awt.Color(0, 204, 255));
        QLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QLabel.setText("Q");

        ALabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        ALabel.setForeground(new java.awt.Color(0, 204, 255));
        ALabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ALabel.setText("E");

        Wlabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Wlabel.setForeground(new java.awt.Color(0, 204, 255));
        Wlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Wlabel.setText("W");

        choiceW.setBackground(new java.awt.Color(0, 102, 204));
        choiceW.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        choiceW.setForeground(new java.awt.Color(255, 255, 255));
        choiceW.setText("Jupiter");
        choiceW.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceW.setFocusable(false);
        choiceW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                choiceWMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choiceWMouseExited(evt);
            }
        });

        SLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        SLabel.setForeground(new java.awt.Color(0, 204, 255));
        SLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SLabel.setText("R");

        goBack.setBackground(new java.awt.Color(0, 102, 204));
        goBack.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        goBack.setForeground(new java.awt.Color(255, 255, 255));
        goBack.setText("Go back");
        goBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goBack.setFocusable(false);
        goBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                goBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                goBackMouseExited(evt);
            }
        });

        jPanel3.setBackground(null);

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setPreferredSize(new java.awt.Dimension(0, 2));

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

        plyScore.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        plyScore.setForeground(new java.awt.Color(255, 255, 255));
        plyScore.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plyScore.setText("0");

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
                        .addComponent(plyScore, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
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
                    .addComponent(plyScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        timerLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        timerLabel.setForeground(new java.awt.Color(255, 255, 255));
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText("00:00");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(choiceQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(QLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choiceA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ALabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(choiceS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choiceW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Wlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(238, 238, 238)
                                .addComponent(goBack))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goBack)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(timerLabel)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(choiceW, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Wlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(choiceS, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SLabel))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(choiceQ, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(choiceA, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ALabel)))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackMouseExited
        goBack.setBackground(Color.decode("#0066CC")); // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_goBackMouseExited

    private void goBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackMouseEntered
        goBack.setBackground(Color.decode("#6699FF"));          // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_goBackMouseEntered

    private void goBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackMouseClicked
        new HomeForm(appContext).setVisible(true);

        this.setVisible(false);        // TODO add your handling code here:
        singleLogic.stopTimer();
    }//GEN-LAST:event_goBackMouseClicked

    private void choiceWMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceWMouseExited
        choiceW.setBackground(Color.decode("#0066CC")); // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceWMouseExited

    private void choiceWMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceWMouseEntered
        choiceW.setBackground(Color.decode("#6699FF"));          // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceWMouseEntered

    private void choiceSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceSMouseExited
        choiceS.setBackground(Color.decode("#0066CC")); // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceSMouseExited

    private void choiceSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceSMouseEntered
        choiceS.setBackground(Color.decode("#6699FF"));          // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceSMouseEntered

    private void choiceAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiceAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceAActionPerformed

    private void choiceAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceAMouseExited
        choiceA.setBackground(Color.decode("#0066CC")); // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceAMouseExited

    private void choiceAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceAMouseEntered
        choiceA.setBackground(Color.decode("#6699FF"));          // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceAMouseEntered

    private void choiceQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiceQActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceQActionPerformed

    private void choiceQMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceQMouseExited
        choiceQ.setBackground(Color.decode("#0066CC")); // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceQMouseExited

    private void choiceQMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceQMouseEntered
        choiceQ.setBackground(Color.decode("#6699FF"));          // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceQMouseEntered

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

    
    public void updateTimeLabel(long timerMinutes, long timerSeconds){
        timerLabel.setText(String.format("%02d:%02d", timerMinutes, timerSeconds));
    }

    public SinglePlayerLogic getSingleLogic() {
        return singleLogic;
    }
    
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ALabel;
    private javax.swing.JLabel QLabel;
    private javax.swing.JLabel SLabel;
    private javax.swing.JLabel SocreLabel;
    private javax.swing.JLabel SocreLabel1;
    private javax.swing.JLabel Wlabel;
    private javax.swing.JButton choiceA;
    private javax.swing.JButton choiceQ;
    private javax.swing.JButton choiceS;
    private javax.swing.JButton choiceW;
    private javax.swing.JButton goBack;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mainQuestionLabel;
    private javax.swing.JLabel ply1Name;
    private javax.swing.JLabel plyScore;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}

class SinglePlayerLogic{
    private AppContext appContext;
    private DatabaseManager dbManager;
    private SinglePlayer singlePlayer;
    private Timer gameTimer;
    private long timeElapsedInSeconds, timeRemainingInSeconds =1 * 60;
    private long timerMinutes = 0;
    private long timerSeconds = 0;
    
    // GamePlay
    
    private int playerScore =0;
    
    public SinglePlayerLogic(AppContext appContext, SinglePlayer singlePlayer){
        this.appContext = appContext;
        this.dbManager = appContext.getDbManager();
        this.singlePlayer = singlePlayer;
        
    }
    
    
    
    public void startTimer() {
        if (gameTimer == null || !gameTimer.isRunning()) {
            // Update the label immediately
            timerMinutes = timeRemainingInSeconds / 60;
            timerSeconds = timeRemainingInSeconds % 60;
            singlePlayer.updateTimeLabel(timerMinutes, timerSeconds);

            countDownTimer(); // Initialize the timer
            gameTimer.start(); // Start the timer
        }
     }

     public void stopTimer() {
         if (gameTimer != null && gameTimer.isRunning()) {
             gameTimer.stop(); // Stop the timer
         }
     }

    public void countDownTimer(){
        if(gameTimer == null){
            gameTimer = new Timer(0,(ae) -> {

                timerMinutes = timeRemainingInSeconds / 60;
                timerSeconds = timeRemainingInSeconds % 60;
                singlePlayer.updateTimeLabel(timerMinutes, timerSeconds);
                System.out.println(String.format("Time Remaining: %02d:%02d", timerMinutes, timerSeconds)); // Print remaining time
                timeRemainingInSeconds--;


            });
            gameTimer.setDelay(1000);
        
        }
        
    }

    public long getTimerMinutes() {
        return timerMinutes;
    }

    public long getTimerSeconds() {
        return timerSeconds;
    }

    public long getTimeRemainingInSeconds() {
        return timeRemainingInSeconds;
    }
}