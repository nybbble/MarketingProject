/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software_project;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author bmetin
 */
public class registerFrame extends javax.swing.JFrame {

    /**
     * Creates new form registerFrame
     */
     Statement st;
     ResultSet rt;
   
  
    public registerFrame() {
        initComponents();
        nameF.setText(nameF.getText());
        surnameF.setText(surnameF.getText());
        emailF.setText(emailF.getText());
        passF.setText(passF.getText());
        
    }
    
    public void saveUsers() {
     
      try {
          
            Connection con = Connections.getConnection();
            st = (Statement)con.createStatement();
            
            String sql = "SELECT EMAIL FROM REGISTER WHERE EMAIL = '"+emailF.getText()+"' ";
            
            rt = st.executeQuery(sql);
            
            if(rt.next() && rt.getString("EMAIL").equals(emailF.getText()) ) {
                
                JOptionPane.showMessageDialog(null,"There is already an email account.");
            }
            
            else if(nameF.getText().isEmpty()|| surnameF.getText().isEmpty() || emailF.getText().isEmpty() || passF.getText().isEmpty()) {
               
                JOptionPane.showMessageDialog(null,"Any field cannot be null. Please enter a valid text!");
            }
            
            else if(nameF.getText().contains(" ")|| surnameF.getText().contains(" ") || emailF.getText().contains(" ") || passF.getText().contains(" ")) {
                
                JOptionPane.showMessageDialog(null,"Any field cannot be null. Please enter a valid text!");
            }
            else if(nameF.getText().contains("0")|| nameF.getText().contains("1")|| nameF.getText().contains("2")|| nameF.getText().contains("3")||
                    nameF.getText().contains("4")||nameF.getText().contains("5")||nameF.getText().contains("6")||nameF.getText().contains("7")||
                    nameF.getText().contains("8")||nameF.getText().contains("9")||nameF.getText().contains("!")||nameF.getText().contains("+")||
                    nameF.getText().contains("%")||nameF.getText().contains("&")||nameF.getText().contains("=")||nameF.getText().contains("*")||
                    nameF.getText().contains("?")||nameF.getText().contains("$")||nameF.getText().contains(".")||nameF.getText().contains(",")||
                    nameF.getText().contains(".")||nameF.getText().contains(",") || surnameF.getText().contains("0")|| surnameF.getText().contains("1")|| surnameF.getText().contains("2")|| surnameF.getText().contains("3")||
                    surnameF.getText().contains("4")||surnameF.getText().contains("5")||surnameF.getText().contains("6")||surnameF.getText().contains("7")||
                    surnameF.getText().contains("8")||surnameF.getText().contains("9")||surnameF.getText().contains("!")||surnameF.getText().contains("+")||
                    surnameF.getText().contains("%")||surnameF.getText().contains("&")||surnameF.getText().contains("=")||surnameF.getText().contains("*")||
                    surnameF.getText().contains("?")||surnameF.getText().contains("$")||surnameF.getText().contains(".")||surnameF.getText().contains(",")||
                    surnameF.getText().contains("<")||surnameF.getText().contains("<")){
             //nameF.getText().contains("0,1,2,3,4,5,6,7,8,9,!,',^,#,+,$,&,/,{,(,[,),],=,},?,*,?,-,_,<,>,|,.,,,:,`,")) 
                
                JOptionPane.showMessageDialog(null,"Invalid name or surname.");
            }
            else { 
                
            String query = "INSERT INTO REGISTER(NAME,SURNAME,EMAIL,PASSWORD) VALUES('"+nameF.getText()+"','"+surnameF.getText()+"','"+emailF.getText()+"','"+passF.getText()+"')";
            
            st.executeQuery(query);
           
	        JOptionPane.showMessageDialog(null,"Saved!");
            } 
     
        } 
        catch (SQLException ex) {
           Logger.getLogger(registerFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        mainButton = new javax.swing.JButton();
        nameF = new javax.swing.JTextField();
        surnameF = new javax.swing.JTextField();
        emailF = new javax.swing.JTextField();
        passF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        logButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 70)); // NOI18N
        jLabel1.setText("HARMONIA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(520, 60, 540, 120);

        mainButton.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        mainButton.setText("GO MAIN PAGE");
        mainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainButtonActionPerformed(evt);
            }
        });
        getContentPane().add(mainButton);
        mainButton.setBounds(70, 80, 280, 60);
        getContentPane().add(nameF);
        nameF.setBounds(640, 280, 320, 40);
        getContentPane().add(surnameF);
        surnameF.setBounds(640, 380, 320, 40);
        getContentPane().add(emailF);
        emailF.setBounds(640, 470, 320, 40);
        getContentPane().add(passF);
        passF.setBounds(640, 560, 320, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel2.setText("Name:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(640, 250, 280, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel3.setText("Surname:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(640, 360, 320, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel4.setText("Email Address:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(640, 450, 320, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel5.setText("Password:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(640, 540, 320, 20);

        saveButton.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveButton);
        saveButton.setBounds(600, 650, 160, 40);

        logButton.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        logButton.setText("GO LOGIN");
        logButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logButton);
        logButton.setBounds(940, 650, 150, 40);

        background.setIcon(new javax.swing.ImageIcon("C:\\Users\\bmetin\\Desktop\\SOFTWARE_PROJECT_COSMETIC\\software_database_images\\back3.jpg")); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background);
        background.setBounds(0, 0, 1220, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        saveUsers();
        JOptionPane.showMessageDialog(null, "Your membership is valid for 6 months.\nAfter 6 months, you are renewing your password!");
    }//GEN-LAST:event_saveButtonActionPerformed

    private void logButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logButtonActionPerformed
        loginFrame lf = new loginFrame();
        lf.setVisible(true);
    }//GEN-LAST:event_logButtonActionPerformed

    private void mainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainButtonActionPerformed
        SecondFrame sF = new SecondFrame();
        sF.setVisible(true);
    }//GEN-LAST:event_mainButtonActionPerformed

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
            java.util.logging.Logger.getLogger(registerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JTextField emailF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton logButton;
    private javax.swing.JButton mainButton;
    private javax.swing.JTextField nameF;
    private javax.swing.JTextField passF;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField surnameF;
    // End of variables declaration//GEN-END:variables
}