/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;


import backend.AccountManager.UserManager;

import main.ui.SignIn;



import java.sql.SQLException;

/**
 *
 * @author PCC
 */
public class App {
    
    private final AppContext appContext;
    
    public App(AppContext appContext){
        this.appContext = appContext;
    }
    

    
    public void start() throws SQLException{

        java.awt.EventQueue.invokeLater(() -> {
            try{
                createAdminAccount();
                
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
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
                //</editor-fold>
                new SignIn(appContext).setVisible(true);  

            }
            catch(SQLException e){
                e.printStackTrace();
            }
        });
        
        
        

    }
    
    private void createAdminAccount() throws SQLException{
        if(appContext.getDbManager().validateLogin("admin", "admin123")){
            System.out.println("Admin Account Already Exists!");
        }
        else{
            UserManager admin = new UserManager(appContext.getDbManager());
            admin.createUser("admin", "admin123");
       }
    }
    
    
}


