/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author laroc
 */
public class Leaderboard extends javax.swing.JFrame {

    /**
     * 
     */
    public Leaderboard() {
        initComponents();
        execute();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        insidePanel = new javax.swing.JPanel();
        goBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LEADERBOARD");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RANKING");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PLAYER NAME");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SCORE");

        scrollPane.setForeground(new java.awt.Color(0, 0, 51));
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        //scrollPane.setOpaque(false); // Make it blend with the background

        insidePanel.setBackground(new java.awt.Color(0, 102, 204));
        insidePanel.setForeground(new java.awt.Color(0, 0, 51));
        insidePanel.setPreferredSize(new java.awt.Dimension(57, 552));

        javax.swing.GroupLayout insidePanelLayout = new javax.swing.GroupLayout(insidePanel);
        insidePanel.setLayout(insidePanelLayout);
        insidePanelLayout.setHorizontalGroup(
            insidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        insidePanelLayout.setVerticalGroup(
            insidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(insidePanel);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel2)
                .addGap(124, 124, 124)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(95, 95, 95))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(goBack)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(goBack)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        // Set the unit and block increments for faster scrolling
        scrollPane.getVerticalScrollBar().setUnitIncrement(10); // Adjust the value as needed
        scrollPane.getVerticalScrollBar().setBlockIncrement(20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackMouseClicked
        new HomeForm().setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_goBackMouseClicked

    private void goBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackMouseEntered
        goBack.setBackground(Color.decode("#6699FF"));          // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_goBackMouseEntered

    private void goBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackMouseExited
        goBack.setBackground(Color.decode("#0066CC")); // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_goBackMouseExited

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
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Leaderboard();
//                new Leaderboard().execute();
//                  execute();
            }
        });
        
    }
     public void execute() {
    try (Connection conn = Main.DatabaseConnection.getConnection()) {
        if (conn != null) {
            String sql = "SELECT Name, Score FROM scores ORDER BY score DESC";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Clear the panel before adding new components
            insidePanel.removeAll();

            // Add each record to the panel
            int ranking = 1;
            while (resultSet.next()) {
                String Name = resultSet.getString("Name");
                int Score = resultSet.getInt("Score");

                // Create a new child panel for each record
                JPanel childPanel = new JPanel();
                insidePanel.setLayout(new BoxLayout(insidePanel, BoxLayout.Y_AXIS)); // Stacks components vertically

                childPanel.setLayout(null);
                childPanel.setPreferredSize(new Dimension(420, 50));
                childPanel.setBackground(new Color(0, 102, 204));
                childPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                
                // Create a panel for each region (optional, for better control)
                JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                leftPanel.setOpaque(false); // Make it blend with the background
                JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                centerPanel.setOpaque(false);
                JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                rightPanel.setOpaque(false);
                
                leftPanel.setBounds(40, 35, 70, 50); // x = 10, y = 20, width = 100, height = 80
                centerPanel.setBounds(200, 35, 150, 50); // x = 120, y = 20, width = 150, height = 80
                rightPanel.setBounds(450, 35, 85, 50);

                // Create labels for ranking, Name, and Score
                JLabel rankLabel = new JLabel("Rank: " + ranking);
                JLabel nameLabel = new JLabel("" + Name);
                JLabel scoreLabel = new JLabel("" + Score);    
                   
                rankLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
                nameLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
                scoreLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
                rankLabel.setForeground(Color.WHITE);
                nameLabel.setForeground(Color.WHITE);
                scoreLabel.setForeground(Color.WHITE);

               // Add labels to their respective panels
                leftPanel.add(rankLabel);
                centerPanel.add(nameLabel);
                rightPanel.add(scoreLabel);

                // Add panels to the child panel
                childPanel.add(leftPanel);
                childPanel.add(centerPanel);
                childPanel.add(rightPanel);
//                
//                rankLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 100));
//                nameLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//                scoreLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                


                // Add the child panel to the insidePanel
                insidePanel.add(childPanel);
//                panelLeaderboard.add(childPanel);

                // Increment the ranking
                ranking++;
            }

            // Refresh the parent panel
            insidePanel.revalidate();
            insidePanel.repaint();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goBack;
    private javax.swing.JPanel insidePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}