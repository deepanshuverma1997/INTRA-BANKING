/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userui;

import adminui.CommonOperations;
import javax.swing.JOptionPane;
import ui.LoginFrame;

/**
 *
 * @author HP
 */
public class UserMainScreen extends javax.swing.JFrame {

   private String username;
    public UserMainScreen() {
        initComponents();
        setSize(1000,600);
        setLocationRelativeTo(null);
    }
     public UserMainScreen(String username){
         this();
         this.username=username;
          
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundDesktopPane1 = new userui.BackgroundDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jmiChangePassword = new javax.swing.JMenuItem();
        jLogout = new javax.swing.JMenu();
        jExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(backgroundDesktopPane1, java.awt.BorderLayout.CENTER);

        jMenu3.setText("Settings");

        jmiChangePassword.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        jmiChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userui/icons8-Password Reset Filled-50.png"))); // NOI18N
        jmiChangePassword.setText("Change Password");
        jmiChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiChangePasswordActionPerformed(evt);
            }
        });
        jMenu3.add(jmiChangePassword);

        jMenuBar1.add(jMenu3);

        jLogout.setText("Logout");
        jLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLogoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(jLogout);

        jExit.setText("Exit");
        jExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jExitMouseClicked(evt);
            }
        });
        jMenuBar1.add(jExit);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiChangePasswordActionPerformed
        ChangePassword cp=new ChangePassword();
        cp.setUsername(username);
        CommonOperations.showScreen(backgroundDesktopPane1, cp);
    }//GEN-LAST:event_jmiChangePasswordActionPerformed

    private void jLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogoutMouseClicked
        int  result=JOptionPane.showConfirmDialog(this,"Are You Sure You Want To Log Out ? ","Message From User",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
            LoginFrame lf=new LoginFrame();
           lf.setVisible(true);
           dispose();
        }
    }//GEN-LAST:event_jLogoutMouseClicked

    private void jExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jExitMouseClicked
        int  result=JOptionPane.showConfirmDialog(this,"Are You Sure You Want To Exit ? ","Message From User",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
           dispose();
        }
    }//GEN-LAST:event_jExitMouseClicked

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
            java.util.logging.Logger.getLogger(UserMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private userui.BackgroundDesktopPane backgroundDesktopPane1;
    private javax.swing.JMenu jExit;
    private javax.swing.JMenu jLogout;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmiChangePassword;
    // End of variables declaration//GEN-END:variables
}
