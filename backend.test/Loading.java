/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import main.logic.AppContext;

/**
 *
 * @author PCC
 */
public class Loading extends javax.swing.JFrame implements Runnable{
    private static Loading instance;
    private Thread loading;
    private int max, current, width,filledWidth;
    private boolean isLoadingComplete;
    
    private AppContext appContext;

    /**
     * Creates new form Loading
     */
    public Loading() {
//        this.appContext = appContext;

    }
    
    public void setDefault(){
        max =100;
        current =0;
        width = LoadingBar.getWidth();
        isLoadingComplete = false;
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
        jPanel1 = new javax.swing.JPanel();
        LoadingBar = new javax.swing.JProgressBar();
        LoadingLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("LoadingFrame"); // NOI18N
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(0, 0, 51));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        LoadingBar.setBackground(new java.awt.Color(236, 236, 236));
        LoadingBar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        LoadingBar.setForeground(new java.awt.Color(51, 51, 51));
        LoadingBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LoadingBar.setStringPainted(true);

        LoadingLabel.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        LoadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoadingLabel.setText("Loading..");
        LoadingLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(LoadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(LoadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LoadingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(LoadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loading().setVisible(true);
                
            }
        });
    }
    
    public static synchronized Loading getInstance(){
        if(instance == null){
            instance = new Loading();
        }
        return instance;
    }
    
    public void start(){
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefault();

        startThread();
    }
    
    public void startThread(){
        
        if(loading == null){
            loading = new Thread(this);
            loading.start();
        }
        
        
    }
    
    public void startLoading() throws InterruptedException{
        while(loading != null){
            try{
                if(max > current){
                    updateLoadingBar();
                }
                else if(current == max){
                    current = max;
                    isLoadingComplete = true;
                }
               
                Thread.sleep(15);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        } 
    }
    public void updateLoadingBar(){
        filledWidth = (int)(( current / (double)max) * 2);

        LoadingBar.setMaximum(max);
        LoadingBar.setValue(current);
        LoadingBar.setString(current + "%");
        current++;
                
    }

    public boolean getIsLoadingComplete() {
        return isLoadingComplete;
    }

    public void setIsLoadingComplete(boolean isLoadingComplete) {
        this.isLoadingComplete = isLoadingComplete;
    }
    
    
    
    
    @Override
    public void run(){
        
        try{
            startLoading();
            setDefault();
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JLabel LoadingLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
