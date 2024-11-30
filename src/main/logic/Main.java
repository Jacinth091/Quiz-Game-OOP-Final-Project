package main.logic;


import java.sql.SQLException;


public class Main {

    public static void main(String[] args){
        AppContext appContext = AppContext.getInstance();
        runApp(appContext);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainThread().startThread();
            }
        });
        
    }
    public static void runApp(AppContext appContext){
           java.awt.EventQueue.invokeLater(() -> {
            try {
                // Pass dbManager to the SignIn form
                new App(appContext).start();
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(0);
            } finally {
                appContext.getDbManager().closeConnection(); // Ensure the connection is closed properly
            }
        });
    }

    


}
