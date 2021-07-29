/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_Loging;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class POS_Loging extends javax.swing.JFrame {
        Main_Page pPage = new Main_Page();
        
    /**
     * Creates new form POS_login
     */
    public POS_Loging() {
        initComponents();
        
        //pPage.setVisible(true);//                                   must remove after complete
        
        
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtUser = new javax.swing.JTextField();
        jButtonLoging = new javax.swing.JButton();
        jPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 50, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THILAKSTORE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 610, 70));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 260, 40));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("User Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 260, 40));

        jTxtUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(jTxtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 260, 30));

        jButtonLoging.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButtonLoging.setText("Loging");
        jButtonLoging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogingActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLoging, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, 50));

        jPassword.setFont(new java.awt.Font("Shrikhand", 1, 14)); // NOI18N
        jPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 260, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS_Loging/logingwall.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private JFrame frame;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frame = new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"Comform if you want to Exit", "Billing System", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            System.exit(0);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonLogingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogingActionPerformed
        
        
        if("".equals(jTxtUser.getText()) || "".equals(jPassword.getText())){
    
        JOptionPane.showMessageDialog(null,"Loging details empty...");
    }
    else{
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/POS_System","root","");
                String sql = "select * from loging_details where user_name=? and password=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,jTxtUser.getText());
                pst.setString(2,jPassword.getText());
                ResultSet rs = pst.executeQuery();
                if(rs.next())
                {
                    
                    //pPage.setVisible(true);
                    
                    
                    String msg=jTxtUser.getText();
                    jTxtUser.setText("");
                    jPassword.setText("");
                    new Main_Page(msg).setVisible(true);    //main page set user name
                    
                    setVisible(false);
                   
                    
                  
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Username and Password Don't Matched");
                    jTxtUser.setText("");
                    jPassword.setText("");
                    jTxtUser.requestFocus();
                }
            }
        catch(ClassNotFoundException | SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,e);
        }
        }
    }//GEN-LAST:event_jButtonLogingActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POS_Loging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            //</editor-fold>
            
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new POS_Loging().setVisible(true);             /// must use true.....................after complete program..........................................................
                
                
                //          This is open for wampSetver 
                /*
                try 
                {
                         Runtime runTime = Runtime.getRuntime();
                        String executablePath = "C:\\Program Files (x86)\\Arduino\\arduino.exe";

                        Process process = runTime.exec(executablePath);

                 }
                catch (Exception e) {
                        JOptionPane.showMessageDialog(null,e);
                  }
                */
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonLoging;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTxtUser;
    // End of variables declaration//GEN-END:variables
}