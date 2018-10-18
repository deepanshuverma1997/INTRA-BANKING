package adminui;

import javax.swing.JOptionPane;
import model.dao.*;
import model.to.*;
import utility.Validations;

public class AddNewUser extends javax.swing.JInternalFrame {

    public AddNewUser() {
        initComponents();
        jcbRoleName.removeAllItems();
        jcbRoleName.addItem("Choose Any Role Name");
        jcbRoleName.addItem("admin");
        jcbRoleName.addItem("user");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfUserName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jpfPassword = new javax.swing.JPasswordField();
        jcbRoleName = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add New User Details");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Enter User Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Enter Password:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Enter Role Name:");

        jtfUserName.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Add User Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jpfPassword.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N

        jcbRoleName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcbRoleName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(jpfPassword)
                            .addComponent(jcbRoleName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbRoleName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String message = "";
        boolean allvalid = true;
        String username = jtfUserName.getText().trim();
        String password = new String(jpfPassword.getPassword());
        if (Validations.isEmpty(username)) {
            allvalid = false;
            message += "Please enter some value in User Name box\n\n";
        }
        if (Validations.isEmpty(password)) {
            allvalid = false;
            message += "Please enter some value in Password box\n\n";
        }
        if (jcbRoleName.getSelectedIndex() == 0) {
            allvalid = false;
            message += "Please choose any Role Name box\n\n";
        }
        if (allvalid) {
            LoginInfoTO record = new LoginInfoTO();
            record.setUsername(username);
            record.setPassword(password);
            record.setRolename(String.valueOf(jcbRoleName.getSelectedItem()));
            LoginInfoDAO action = new LoginInfoDAO();
            if (action.insertrecord(record)) {
                //ps.button();
                message = "Login information is added in the system";
            } else {
               // ps.computererror();
                if (action.getErrormessage().contains("Duplicate entry")) {
                    message = "Username is a primary key and this username already exists.\nPlease enter some other unique entry in Username";
                } else {
                    message = "Insertion Failure due to:" + action.getErrormessage();
                }
            }
        } else {
            //ps.computererror();
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jtfRoleNameKeyTyped(java.awt.event.KeyEvent evt) {                                     
        if (!Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox jcbRoleName;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JTextField jtfUserName;
    // End of variables declaration//GEN-END:variables
}
