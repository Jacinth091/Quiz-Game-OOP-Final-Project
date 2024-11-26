/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.ui;

import java.awt.Color;
import backend.Database;
import backend.DatabaseManager;

/**
 *
 * @author laroc
 */
public class HomeForm extends javax.swing.JFrame {
    private DatabaseManager dbManager;
    /**
     * Creates new form homeQUIZ
     */
    
    public HomeForm(DatabaseManager dbManager) {
        this.dbManager = dbManager;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        homeQuizPanel.setBackground(new java.awt.Color(0, 0, 51));
        homeQuizPanel.setPreferredSize(new java.awt.Dimension(559, 664));

        singlePlayBtn.setBackground(new java.awt.Color(0, 51, 102));
        singlePlayBtn.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        singlePlayBtn.setForeground(new java.awt.Color(255, 255, 255));
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
        multiPlayBtn.setForeground(new java.awt.Color(255, 255, 255));
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
        leaderBoardBtn.setForeground(new java.awt.Color(255, 255, 255));
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
        tutorBtn.setForeground(new java.awt.Color(255, 255, 255));
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
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Quiz Game");

        LogoutBtn.setBackground(new java.awt.Color(0, 51, 102));
        LogoutBtn.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
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
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout homeQuizPanelLayout = new javax.swing.GroupLayout(homeQuizPanel);
        homeQuizPanel.setLayout(homeQuizPanelLayout);
        homeQuizPanelLayout.setHorizontalGroup(
            homeQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeQuizPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(homeQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(multiPlayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(singlePlayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaderBoardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tutorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(218, 218, 218))
            .addGroup(homeQuizPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        homeQuizPanelLayout.setVerticalGroup(
            homeQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeQuizPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(singlePlayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(multiPlayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(leaderBoardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(tutorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeQuizPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeQuizPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void singlePlayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlePlayBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_singlePlayBtnActionPerformed

    private void multiPlayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiPlayBtnActionPerformed
        // TODO add your handling code here:
  
    }//GEN-LAST:event_multiPlayBtnActionPerformed

    private void leaderBoardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderBoardBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leaderBoardBtnActionPerformed

    private void singlePlayBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_singlePlayBtnMouseClicked
            new SinglePlayer(dbManager).getSingleLogic().startTimer();
            this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_singlePlayBtnMouseClicked

    private void multiPlayBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiPlayBtnMouseClicked
            new MultiPlayer(dbManager).setVisible(true);
            this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_multiPlayBtnMouseClicked

    private void LogoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBtnMouseClicked
        new SignIn(dbManager).setVisible(true);
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

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutBtnActionPerformed

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
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JPanel homeQuizPanel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton leaderBoardBtn;
    private javax.swing.JButton multiPlayBtn;
    private javax.swing.JButton singlePlayBtn;
    private javax.swing.JButton tutorBtn;
    // End of variables declaration//GEN-END:variables
}
