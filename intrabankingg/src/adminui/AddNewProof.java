package adminui;

import model.dao.*;
import model.to.*;
import javax.swing.JOptionPane;
import utility.Validations;

public class AddNewProof extends javax.swing.JInternalFrame {

    private int proofid;
    public AddNewProof() {
        initComponents();
    }

    public AddNewProof(ProofInfoTO record) {
       this();
        if (record != null){
            this.proofid=record.getProofid();
            jtfProofName.setText(record.getProofname());
            jtfTotalDigits.setText(record.getTotaldigits());
            btnAdd.setText("Update Account Information");
            setTitle("Update Account Information");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfProofName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jtfTotalDigits = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add New Proof Details");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Enter Proof Name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Enter Digits");

        jtfProofName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfProofName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfProofNameActionPerformed(evt);
            }
        });
        jtfProofName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfProofNameKeyTyped(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setText("Add Proof Details");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jtfTotalDigits.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfTotalDigits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTotalDigitsActionPerformed(evt);
            }
        });
        jtfTotalDigits.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTotalDigitsKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfProofName, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTotalDigits, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfProofName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfTotalDigits, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfProofNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfProofNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfProofNameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String message = "";
        boolean allvalid = true;

        String tdigits = jtfTotalDigits.getText().trim();
        if (Validations.isEmpty(tdigits)) {
            message += "Please Enter Digits\n\n";
            allvalid = false;
        }
        String pname = jtfProofName.getText().trim();
        if (Validations.isEmpty(pname)) {
            message += "Please Enter Proof Name\n\n";
            allvalid = false;
        }
        if (allvalid) {
            ProofInfoTO record = new ProofInfoTO();
            record.setProofname(pname);
            record.setTotaldigits(tdigits);
            ProofInfoDAO action = new ProofInfoDAO();
            if (btnAdd.getText().contains("Add")){
            if (action.insertrecord(record)) {
                int proofid = CommonDAO.getLastInsertID();
                message = "Proof Info Is Added With Proof ID [ " + proofid + " ] in System Database";
            } else {
                message = "Insertion Failure Due " + action.getErrormessage();
            }
        }else if(btnAdd.getText().contains("Update")){
            record.setProofid(proofid);
            if (action.updaterecord(record)) {
                    message = "Proof Info Is Updated In Database";
                } else {
                    message = "Info Is Not Updated  Due To " + action.getErrormessage();
                }
                CommonOperations.showScreen(getDesktopPane(), new ViewProofDetails());
                dispose();
        } else{
             message = "Invalid Operation";
        }
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_btnAddActionPerformed

    private void jtfProofNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfProofNameKeyTyped
        if (!Character.isLetter(evt.getKeyChar())) {
            if (!Character.isWhitespace(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_jtfProofNameKeyTyped

    private void jtfTotalDigitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTotalDigitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTotalDigitsActionPerformed

    private void jtfTotalDigitsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTotalDigitsKeyTyped
        if (!Character.isLetterOrDigit(evt.getKeyChar())) {
            evt.consume();
        }
        if(Character.isLowerCase(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_jtfTotalDigitsKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jtfProofName;
    private javax.swing.JTextField jtfTotalDigits;
    // End of variables declaration//GEN-END:variables
}
