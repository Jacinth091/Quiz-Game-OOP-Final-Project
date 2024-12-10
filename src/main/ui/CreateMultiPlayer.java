/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.ui;

import java.util.concurrent.CompletableFuture;
import javax.swing.SwingUtilities;
import main.PlayerData.MultiManager;
import main.PlayerData.Player;
import main.PlayerData.Single;
import main.logic.AppContext;
import main.logic.GameEnums;
import static main.logic.GameEnums.GameMode.MULTIPLAYER;

/**
 *
 * @author PCC
 */
public class CreateMultiPlayer extends javax.swing.JFrame {
    private static CreateMultiPlayer instance;
    private MultiManager multiManager;
    private AppContext appContext;
    private CompletableFuture transition;
    /**
     * Creates new form CreateMultiPlayer
     */
    public CreateMultiPlayer(AppContext appContext) {
        this.appContext = appContext;
        this.multiManager= new MultiManager();
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

        mainPanel = new javax.swing.JPanel();
        panelContainer = new javax.swing.JPanel();
        playerOneField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        createPlayerBtn = new javax.swing.JButton();
        playerTwoField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 700));
        setPreferredSize(new java.awt.Dimension(600, 700));

        mainPanel.setBackground(new java.awt.Color(0, 0, 51));

        panelContainer.setBackground(new java.awt.Color(173, 216, 230));

        playerOneField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        playerOneField.setActionCommand("playerOne");
        playerOneField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel7.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 128));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Enter Player Name");

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 128));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Player ONE:");

        createPlayerBtn.setBackground(new java.awt.Color(0, 51, 102));
        createPlayerBtn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        createPlayerBtn.setForeground(new java.awt.Color(255, 255, 255));
        createPlayerBtn.setText("Create and Start");
        createPlayerBtn.setActionCommand("Create");
        createPlayerBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createPlayerBtn.setBorderPainted(false);
        createPlayerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createPlayerBtn.setFocusable(false);
        createPlayerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createPlayerBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createPlayerBtnMouseExited(evt);
            }
        });
        createPlayerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPlayerBtnActionPerformed(evt);
            }
        });

        playerTwoField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        playerTwoField.setActionCommand("playerTwo");
        playerTwoField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 128));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Player TWO:");

        javax.swing.GroupLayout panelContainerLayout = new javax.swing.GroupLayout(panelContainer);
        panelContainer.setLayout(panelContainerLayout);
        panelContainerLayout.setHorizontalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createPlayerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelContainerLayout.createSequentialGroup()
                        .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerTwoField, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerOneField, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContainerLayout.setVerticalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addGap(33, 33, 33)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(playerOneField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(playerTwoField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(createPlayerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("2 Player");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(panelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(panelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createPlayerBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createPlayerBtnMouseEntered
        createPlayerBtn.setBackground(java.awt.Color.decode("#000080"));        // TODO add your handling code here:
    }//GEN-LAST:event_createPlayerBtnMouseEntered

    private void createPlayerBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createPlayerBtnMouseExited
        createPlayerBtn.setBackground(java.awt.Color.decode("#003366"));        // TODO add your handling code here:
    }//GEN-LAST:event_createPlayerBtnMouseExited

    private void createPlayerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPlayerBtnActionPerformed
        System.out.println("Player has been Created!");
        createPlayers();
    }//GEN-LAST:event_createPlayerBtnActionPerformed
   
    private void createPlayers() {
        boolean plyOne = false;
        boolean plyTwo = false;
        String playerOneName = playerOneField.getText().trim();
        String playerTwoName = playerTwoField.getText().trim();

            // Validate the input for both player names
            if (playerOneName.isEmpty() || playerTwoName.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(null, "Please provide both players' names.");
                return;
            } else if (playerOneName.length() < 3 || playerTwoName.length() < 3) {
                javax.swing.JOptionPane.showMessageDialog(null, "Player names must have at least 8 characters!");
                return;
            }
            else{
                plyOne = true;
                plyTwo = true;
            }

            try {
                Player playerOne = new Single("Player 01", playerOneName, 0);
                Player playerTwo = new Single("Player 02", playerTwoName, 0);

                if (!plyOne || !plyTwo) {
                   javax.swing.JOptionPane.showMessageDialog(this, "One or both player names failed to create.");
               } else {
                   System.out.println("Player One and Player Two successfully added!");
                   multiManager = new MultiManager(playerOne, playerTwo);
                   
                   startMultiPlayerGame();
                   
                   
                   
                   
                   this.dispose(); // Close the current form
               }
            } catch (Exception e) {
                e.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(this, "Error while creating players.");
            }
    }

    public void startMultiPlayerGame(){
        System.out.println("GameMode:" + appContext.getGameMode());

        appContext.resetMultiPlayer();

        System.out.println("GameMode:" + appContext.getGameMode());

        appContext.setMultiManager(multiManager);
        appContext.getGameLogic(appContext.getGameMode()).resetGameLogic(); // Reset logic here
        appContext.getGameLogic(appContext.getGameMode()).setMultiManager(multiManager);
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
            
        });
        transition.thenRun(() -> {
          appContext.getLoadingScreen().setIsLoadingComplete(false);
          appContext.getLoadingScreen().dispose();

            appContext.getGame().startGame();
            appContext.getGame().setVisible(true);

      });
        
        
        
    }
    
    
    
    public static synchronized CreateMultiPlayer getInstance(AppContext appContext){
        if(instance == null){
            instance = new CreateMultiPlayer(appContext);
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
            java.util.logging.Logger.getLogger(CreateMultiPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateMultiPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateMultiPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateMultiPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new CreateMultiPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createPlayerBtn;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JTextField playerOneField;
    private javax.swing.JTextField playerTwoField;
    // End of variables declaration//GEN-END:variables
}
