/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.ui;


import java.awt.Color;
import backend.Database.DatabaseManager;
import java.util.concurrent.CompletableFuture;
import javax.swing.SwingUtilities;
import main.PlayerData.Session;
import main.logic.AppContext;
import main.logic.GameEnums;
import main.ui.SinglePlayer;

/**
 *
 * @author laroc
 */
public class HomeForm extends javax.swing.JFrame {
    private AppContext appContext;
    private DatabaseManager dbManager;
    private Session session;
    private GameEnums.GameState gameState;
    private CompletableFuture transition;
    /**
     * Creates new form HomeForm
     * @param appContext
     */
    
    public HomeForm(AppContext appContext) {
        this.appContext = appContext;
        this.dbManager = appContext.getDbManager();
        this.session = appContext.getSession();
        System.out.println("User ID: "+ session.getUserId());
        System.out.println("Player Name: " + session.getPlayer().getPlayerName().toUpperCase());
        
        this.gameState = appContext.getGameState();
        initComponents();
        setLocationRelativeTo(null);


        
    }
    public HomeForm() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        homeQuizPanel = new javax.swing.JPanel();
        singlePlayBtn = new javax.swing.JButton();
        multiPlayBtn = new javax.swing.JButton();
        leaderBoardBtn = new javax.swing.JButton();
        tutorBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTextfield = new javax.swing.JTextField();
        accountPicture = new javax.swing.JLabel();
        pencilLogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IDnumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        homeQuizPanel.setBackground(new java.awt.Color(0, 0, 51));
        homeQuizPanel.setPreferredSize(new java.awt.Dimension(600, 700));

        singlePlayBtn.setBackground(new java.awt.Color(0, 51, 102));
        singlePlayBtn.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        singlePlayBtn.setForeground(new java.awt.Color(229, 225, 218));
        singlePlayBtn.setText("Singleplayer");
        singlePlayBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        singlePlayBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                singlePlayBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                singlePlayBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                singlePlayBtnMouseExited(evt);
            }
        });
        singlePlayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlePlayBtnActionPerformed(evt);
            }
        });

        multiPlayBtn.setBackground(new java.awt.Color(0, 51, 102));
        multiPlayBtn.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        multiPlayBtn.setForeground(new java.awt.Color(229, 225, 218));
        multiPlayBtn.setText("Multiplayer");
        multiPlayBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        multiPlayBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                multiPlayBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                multiPlayBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                multiPlayBtnMouseExited(evt);
            }
        });
        multiPlayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiPlayBtnActionPerformed(evt);
            }
        });

        leaderBoardBtn.setBackground(new java.awt.Color(0, 51, 102));
        leaderBoardBtn.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        leaderBoardBtn.setForeground(new java.awt.Color(229, 225, 218));
        leaderBoardBtn.setText("Leaderboards");
        leaderBoardBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        leaderBoardBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                leaderBoardBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                leaderBoardBtnMouseExited(evt);
            }
        });
        leaderBoardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderBoardBtnActionPerformed(evt);
            }
        });

        tutorBtn.setBackground(new java.awt.Color(0, 51, 102));
        tutorBtn.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        tutorBtn.setForeground(new java.awt.Color(229, 225, 218));
        tutorBtn.setText("Tutorial");
        tutorBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tutorBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tutorBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tutorBtnMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(229, 225, 218));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Quiz Game");

        LogoutBtn.setBackground(new java.awt.Color(0, 51, 102));
        LogoutBtn.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(229, 225, 218));
        LogoutBtn.setText("Logout");
        LogoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogoutBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogoutBtnMouseExited(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 225, 218));
        jLabel1.setText("Name:");

        nameTextfield.setBackground(new java.awt.Color(0, 0, 51));
        nameTextfield.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        nameTextfield.setForeground(new java.awt.Color(229, 225, 218));
        nameTextfield.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nameTextfield.setText(session.getPlayer().getPlayerName());
        nameTextfield.setBorder(null);
        nameTextfield.setFocusable(false);
        nameTextfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                HomeForm.this.focusLost(evt);
            }
        });
        nameTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextfieldActionPerformed(evt);
            }
        });

        accountPicture.setText("account");

        pencilLogo.setForeground(new java.awt.Color(255, 255, 255));
        pencilLogo.setText("Pen");
        pencilLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pencilLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pencilLogoMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 225, 218));
        jLabel2.setText("ID:");

        IDnumber.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        IDnumber.setForeground(new java.awt.Color(229, 225, 218));
        IDnumber.setText(session.getPlayer().getPlayerId());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(accountPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pencilLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(IDnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(accountPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pencilLogo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(IDnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout homeQuizPanelLayout = new javax.swing.GroupLayout(homeQuizPanel);
        homeQuizPanel.setLayout(homeQuizPanelLayout);
        homeQuizPanelLayout.setHorizontalGroup(
            homeQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeQuizPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeQuizPanelLayout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(homeQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeQuizPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeQuizPanelLayout.createSequentialGroup()
                        .addGroup(homeQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeQuizPanelLayout.createSequentialGroup()
                                .addComponent(singlePlayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(multiPlayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeQuizPanelLayout.createSequentialGroup()
                                .addGroup(homeQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tutorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(leaderBoardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(94, 94, 94)))
                        .addGap(128, 128, 128))))
        );
        homeQuizPanelLayout.setVerticalGroup(
            homeQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeQuizPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(homeQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(singlePlayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(multiPlayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(leaderBoardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(tutorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeQuizPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeQuizPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void singlePlayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlePlayBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();// Hide the current frame
        
        appContext.resetSinglePlayer();
        appContext.setGame(appContext.getSinglePlayer(appContext));

        //TODO: TO BE MODIFIED!!
        transition = CompletableFuture.runAsync(() ->{
            
            appContext.getLoadingScreen().start();
            while(!appContext.getLoadingScreen().getIsLoadingComplete() ){
                try{
                    Thread.sleep(20);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            
        }).thenRunAsync(() -> {
          SwingUtilities.invokeLater(() -> {

            appContext.getGame().startGame();
          
          });
      });
        transition.thenRun(() -> {
          appContext.getLoadingScreen().setIsLoadingComplete(false);
          appContext.getLoadingScreen().dispose();
            appContext.getGame().setVisible(true);

      });
        
    }//GEN-LAST:event_singlePlayBtnActionPerformed

    private void multiPlayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiPlayBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();// Hide the current frame
//        
//        appContext.resetSinglePlayer();
//        // Create a new instance of SinglePlayer and set it in the app context
//        MultiPlayer multiPlayer = appContext.getMultiPlayer(appContext);
//     
//        // Make the new SinglePlayer visible
//        multiPlayer.setVisible(true);

        appContext.resetMultiPlayer();
        appContext.setGame(appContext.getMultiPlayer(appContext));

        //TODO: TO BE MODIFIED!!
        transition = CompletableFuture.runAsync(() ->{
            
            appContext.getLoadingScreen().start();
            while(!appContext.getLoadingScreen().getIsLoadingComplete() ){
                try{
                    Thread.sleep(20);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            
        }).thenRunAsync(() -> {
          SwingUtilities.invokeLater(() -> {

            appContext.getGame().startGame();
          
          });
      });
        transition.thenRun(() -> {
          appContext.getLoadingScreen().setIsLoadingComplete(false);
          appContext.getLoadingScreen().dispose();
            appContext.getGame().setVisible(true);

      });
        
                   

  
    }//GEN-LAST:event_multiPlayBtnActionPerformed

    private void leaderBoardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderBoardBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leaderBoardBtnActionPerformed

    private void singlePlayBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_singlePlayBtnMouseClicked



        // TODO add your handling code here:
    }//GEN-LAST:event_singlePlayBtnMouseClicked

    private void multiPlayBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiPlayBtnMouseClicked
            new MultiPlayer(appContext).setVisible(true);
            this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_multiPlayBtnMouseClicked

    private void LogoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBtnMouseClicked
        new SignIn(appContext).setVisible(true);
        appContext.resetMultiPlayer();
        appContext.resetSinglePlayer();
        this.setVisible(false);   // TODO add your handling code here:
    }//GEN-LAST:event_LogoutBtnMouseClicked

    private void singlePlayBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_singlePlayBtnMouseEntered
        singlePlayBtn.setBackground(Color.decode("#000080"));         // TODO add your handling code here:
    }//GEN-LAST:event_singlePlayBtnMouseEntered

    private void multiPlayBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiPlayBtnMouseEntered
        multiPlayBtn.setBackground(Color.decode("#000080"));         // TODO add your handling code here:
    }//GEN-LAST:event_multiPlayBtnMouseEntered

    private void leaderBoardBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leaderBoardBtnMouseEntered
        leaderBoardBtn.setBackground(Color.decode("#000080"));         // TODO add your handling code here:
    }//GEN-LAST:event_leaderBoardBtnMouseEntered

    private void tutorBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tutorBtnMouseEntered
        tutorBtn.setBackground(Color.decode("#000080"));         // TODO add your handling code here:
    }//GEN-LAST:event_tutorBtnMouseEntered

    private void LogoutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBtnMouseEntered
        LogoutBtn.setBackground(Color.decode("#000080"));         // TODO add your handling code here:
    }//GEN-LAST:event_LogoutBtnMouseEntered

    private void singlePlayBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_singlePlayBtnMouseExited
       singlePlayBtn.setBackground(Color.decode("#003366"));         // TODO add your handling code here:
    }//GEN-LAST:event_singlePlayBtnMouseExited

    private void multiPlayBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiPlayBtnMouseExited
        multiPlayBtn.setBackground(Color.decode("#003366"));        // TODO add your handling code here:
    }//GEN-LAST:event_multiPlayBtnMouseExited

    private void leaderBoardBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leaderBoardBtnMouseExited
        leaderBoardBtn.setBackground(Color.decode("#003366"));        // TODO add your handling code here:
    }//GEN-LAST:event_leaderBoardBtnMouseExited

    private void tutorBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tutorBtnMouseExited
        tutorBtn.setBackground(Color.decode("#003366"));         // TODO add your handling code here:
    }//GEN-LAST:event_tutorBtnMouseExited

    private void LogoutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBtnMouseExited
        LogoutBtn.setBackground(Color.decode("#003366"));        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutBtnMouseExited

    private void pencilLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pencilLogoMouseClicked
            
//             nameTextfield.requestFocus();
             nameTextfield.requestFocusInWindow();
             nameTextfield.setFocusable(true);  

    }//GEN-LAST:event_pencilLogoMouseClicked

    private void nameTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextfieldActionPerformed
        nameTextfield.setFocusable(false);        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextfieldActionPerformed

    private void focusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_focusLost
        nameTextfield.setFocusable(false);      // TODO add your handling code here:
    }//GEN-LAST:event_focusLost

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
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDnumber;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JLabel accountPicture;
    private javax.swing.JPanel homeQuizPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton leaderBoardBtn;
    private javax.swing.JButton multiPlayBtn;
    private javax.swing.JTextField nameTextfield;
    private javax.swing.JLabel pencilLogo;
    private javax.swing.JButton singlePlayBtn;
    private javax.swing.JButton tutorBtn;
    // End of variables declaration//GEN-END:variables
}
