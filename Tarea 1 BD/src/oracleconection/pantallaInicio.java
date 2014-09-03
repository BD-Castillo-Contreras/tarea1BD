/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oracleconection;

import java.sql.*;
import javax.swing.*;

public class pantallaInicio extends javax.swing.JFrame {
    
     static Connection conn=null;
     
    /**
     * Creates new form pantallaInicio
     */
    public pantallaInicio() {
        initComponents();
    }
    
public class funcionalidad { 
        private Connection conexion; 

        public Connection getConexion() { 
            return conexion; 
        }    public void setConexion(Connection conexion) { 
            this.conexion = conexion; 
        }  



public funcionalidad conectar() { 
    try { 
        Class.forName("oracle.jdbc.OracleDriver"); 
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE"; 
          
        conexion = DriverManager.getConnection(BaseDeDatos, "TAREA1BD","marti");             
        if (conexion != null) { 
            System.out.println("Conexion exitosa!"); 
        } else { 
            System.out.println("Conexion fallida!"); 
        } 
    } catch (Exception e) { 
        e.printStackTrace(); 
    }        return this; 
} 

public boolean escribir(String sql) { 
        try { 
            Statement sentencia; 
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
            sentencia.executeUpdate(sql); 
            getConexion().commit(); 
            sentencia.close(); 
             
        } catch (SQLException e) { 
            e.printStackTrace(); 
            System.out.print("ERROR SQL"); 
            return false; 
        }         
        return true; 
    } 

public ResultSet consultar(String sql) { 
        ResultSet resultado = null; 
        try { 
            Statement sentencia; 
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
            resultado = sentencia.executeQuery(sql); 
             
        } catch (SQLException e) { 
            e.printStackTrace(); 
            return null; 
        }        return resultado; 
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

        LOGIN = new javax.swing.JPanel();
        inicioTitulo = new javax.swing.JLabel();
        inicioUsuario = new javax.swing.JLabel();
        inicioClave = new javax.swing.JLabel();
        inicioLogin = new javax.swing.JTextField();
        inicioPassword = new javax.swing.JPasswordField();
        inicioBotonEntrar = new javax.swing.JButton();
        inicioPregunta = new javax.swing.JLabel();
        inicioBotonRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inicioTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        inicioTitulo.setText("Red social de Música");

        inicioUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inicioUsuario.setText("Usuario:");

        inicioClave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inicioClave.setText("Contraseña:");

        inicioLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioLoginActionPerformed(evt);
            }
        });

        inicioBotonEntrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inicioBotonEntrar.setText("Entrar");
        inicioBotonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioBotonEntrarActionPerformed(evt);
            }
        });

        inicioPregunta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inicioPregunta.setText("No estas registrado?");

        inicioBotonRegistro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inicioBotonRegistro.setText("Registrarme");
        inicioBotonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioBotonRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LOGINLayout = new javax.swing.GroupLayout(LOGIN);
        LOGIN.setLayout(LOGINLayout);
        LOGINLayout.setHorizontalGroup(
            LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LOGINLayout.createSequentialGroup()
                .addGroup(LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LOGINLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(inicioTitulo))
                    .addGroup(LOGINLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LOGINLayout.createSequentialGroup()
                                .addComponent(inicioUsuario)
                                .addGap(41, 41, 41)
                                .addComponent(inicioLogin))
                            .addGroup(LOGINLayout.createSequentialGroup()
                                .addComponent(inicioClave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(inicioPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(LOGINLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LOGINLayout.createSequentialGroup()
                        .addComponent(inicioBotonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(inicioPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LOGINLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inicioBotonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        LOGINLayout.setVerticalGroup(
            LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LOGINLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inicioTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inicioUsuario)
                    .addComponent(inicioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inicioClave)
                    .addComponent(inicioPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(inicioBotonEntrar)
                .addGap(18, 18, 18)
                .addComponent(inicioPregunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inicioBotonRegistro)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public static sesion SesionActual =  new sesion();

    private void inicioBotonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioBotonEntrarActionPerformed
        // TODO add your handling code here:
        try{    
                funcionalidad f = new funcionalidad(); 
                f.conectar(); 
                ResultSet login = f.consultar("select login from usuario where login='"+inicioLogin.getText()+"'");
                login.next();
                               
                if(inicioLogin.getText().equals(login.getObject(1))){
                    
                    login.close();
                    ResultSet clave = f.consultar("select password from usuario where password='"+inicioPassword.getText()+"'");
                    clave.next();
                    
                    if(inicioPassword.getText().equals(clave.getObject(1))){
                        
                        clave.close();                                                                       
                        JOptionPane.showMessageDialog(this,"Bienvenido "+inicioLogin.getText()+" a la Red Social de Música!");
                        
                        SesionActual.login=inicioLogin.getText();
                        
                        this.setVisible(false);
                        menuUsuario pUsuario = new menuUsuario();
                        pUsuario.setVisible(true);
                        pUsuario.pack();
                        dispose();
                    }
                                        
                }    
        }catch (Exception e){
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(this,"Usuario no existe o clave erronea!");
        }
        
    }//GEN-LAST:event_inicioBotonEntrarActionPerformed

    private void inicioBotonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioBotonRegistroActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        pantallaRegistro pRegistro   = new pantallaRegistro();
        pRegistro.setVisible(true);
        pRegistro.pack();

    }//GEN-LAST:event_inicioBotonRegistroActionPerformed

    private void inicioLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicioLoginActionPerformed

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
            java.util.logging.Logger.getLogger(pantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LOGIN;
    private javax.swing.JButton inicioBotonEntrar;
    private javax.swing.JButton inicioBotonRegistro;
    private javax.swing.JLabel inicioClave;
    private javax.swing.JTextField inicioLogin;
    private javax.swing.JPasswordField inicioPassword;
    private javax.swing.JLabel inicioPregunta;
    private javax.swing.JLabel inicioTitulo;
    private javax.swing.JLabel inicioUsuario;
    // End of variables declaration//GEN-END:variables
}
