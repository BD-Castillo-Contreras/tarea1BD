/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oracleconection;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JP
 */
public class pantallaRegistro extends javax.swing.JFrame {
    
    static Connection conn=null;
    /**
     * Creates new form pantallaRegistro
     */
    public pantallaRegistro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        REGISTRO = new javax.swing.JPanel();
        registroTitulo = new javax.swing.JLabel();
        registrotNombre = new javax.swing.JLabel();
        registrotApellidos = new javax.swing.JLabel();
        registrotUsuario = new javax.swing.JLabel();
        registrotPassword = new javax.swing.JLabel();
        registrotRepitePassword = new javax.swing.JLabel();
        registrotEdad = new javax.swing.JLabel();
        registroBotonAceptar = new javax.swing.JButton();
        registroNombre = new javax.swing.JTextField();
        registroApellidos = new javax.swing.JTextField();
        registroEdad = new javax.swing.JTextField();
        registroLogin = new javax.swing.JTextField();
        registroPassword = new javax.swing.JPasswordField();
        registroRepitePassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        registroTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        registroTitulo.setText("Datos para Registrarse");

        registrotNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registrotNombre.setText("Nombre:");

        registrotApellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registrotApellidos.setText("Apellidos:");

        registrotUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registrotUsuario.setText("Usuario:");

        registrotPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registrotPassword.setText("Clave");

        registrotRepitePassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registrotRepitePassword.setText("Repite Clave:");

        registrotEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registrotEdad.setText("Edad:");

        registroBotonAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registroBotonAceptar.setText("Aceptar");
        registroBotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroBotonAceptarActionPerformed(evt);
            }
        });

        registroNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroNombreActionPerformed(evt);
            }
        });

        registroEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroEdadActionPerformed(evt);
            }
        });

        registroLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroLoginActionPerformed(evt);
            }
        });

        registroPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout REGISTROLayout = new javax.swing.GroupLayout(REGISTRO);
        REGISTRO.setLayout(REGISTROLayout);
        REGISTROLayout.setHorizontalGroup(
            REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(REGISTROLayout.createSequentialGroup()
                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(REGISTROLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(REGISTROLayout.createSequentialGroup()
                                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registrotEdad)
                                    .addComponent(registrotApellidos)
                                    .addComponent(registrotUsuario)
                                    .addComponent(registrotPassword))
                                .addGap(27, 27, 27)
                                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registroApellidos)
                                    .addComponent(registroEdad)))
                            .addGroup(REGISTROLayout.createSequentialGroup()
                                .addComponent(registrotNombre)
                                .addGap(29, 29, 29)
                                .addComponent(registroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(REGISTROLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(registrotRepitePassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registroRepitePassword))
                    .addGroup(REGISTROLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registroLogin)
                            .addComponent(registroPassword))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, REGISTROLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(registroTitulo)
                .addGap(59, 59, 59))
            .addGroup(REGISTROLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(registroBotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        REGISTROLayout.setVerticalGroup(
            REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(REGISTROLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registroTitulo)
                .addGap(18, 18, 18)
                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrotNombre)
                    .addComponent(registroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrotApellidos)
                    .addComponent(registroApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registroEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrotEdad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registroLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrotUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrotPassword)
                    .addComponent(registroPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrotRepitePassword)
                    .addComponent(registroRepitePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(registroBotonAceptar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(REGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(REGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registroNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroNombreActionPerformed

    private void registroLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroLoginActionPerformed

    private void registroEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroEdadActionPerformed

    private void registroBotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroBotonAceptarActionPerformed
        // TODO add your handling code here:
        try {
                               
           if(registroPassword.getText().equals(registroRepitePassword.getText())){
                
                conn = Main.Enlace(conn);
                String sqlinsertar = "insert into usuario values (?,?,?,?,?,?,?,?)";
                PreparedStatement psta = conn.prepareStatement(sqlinsertar);
                psta.setString(1, null);
                psta.setString(2, registroNombre.getText());
                psta.setString(3, registroApellidos.getText());
                psta.setString(4, registroEdad.getText());
                psta.setString(5, null);
                psta.setString(6, null);
                psta.setString(7, registroLogin.getText());
                psta.setString(8, registroPassword.getText());
                psta.execute();
                psta.close();

                JOptionPane.showMessageDialog(this,"Datos registrados exitosamente!");

                this.setVisible(false);
                pantallaInicio pInicio = new pantallaInicio();
                pInicio.setVisible(true);
                pInicio.pack();
                dispose();}
           
           else{JOptionPane.showMessageDialog(this,"La password que ingreso no es valida");}
           
        }catch (Exception e){
            System.out.println(e.getCause());
        }

    }//GEN-LAST:event_registroBotonAceptarActionPerformed

    private void registroPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(pantallaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel REGISTRO;
    private javax.swing.JTextField registroApellidos;
    private javax.swing.JButton registroBotonAceptar;
    private javax.swing.JTextField registroEdad;
    private javax.swing.JTextField registroLogin;
    private javax.swing.JTextField registroNombre;
    private javax.swing.JPasswordField registroPassword;
    private javax.swing.JPasswordField registroRepitePassword;
    private javax.swing.JLabel registroTitulo;
    private javax.swing.JLabel registrotApellidos;
    private javax.swing.JLabel registrotEdad;
    private javax.swing.JLabel registrotNombre;
    private javax.swing.JLabel registrotPassword;
    private javax.swing.JLabel registrotRepitePassword;
    private javax.swing.JLabel registrotUsuario;
    // End of variables declaration//GEN-END:variables
}
