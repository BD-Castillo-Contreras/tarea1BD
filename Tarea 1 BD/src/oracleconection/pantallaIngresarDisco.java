/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oracleconection;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author JP
 */
public class pantallaIngresarDisco extends javax.swing.JFrame {
    
    static Connection conn=null;
    /**
     * Creates new form pantallaIngresarDisco
     */
    public pantallaIngresarDisco() {
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

        INGRESARDISCO = new javax.swing.JPanel();
        discoTitulo = new javax.swing.JLabel();
        discotNombre = new javax.swing.JLabel();
        discotAño = new javax.swing.JLabel();
        discotUrl_foto = new javax.swing.JLabel();
        discoNombre = new javax.swing.JTextField();
        discoAño = new javax.swing.JTextField();
        discoUrl_foto = new javax.swing.JTextField();
        discoBotonAceptar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        discoTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        discoTitulo.setText("Datos del Disco:");

        discotNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discotNombre.setText("Nombre del disco:");

        discotAño.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discotAño.setText("Año:");

        discotUrl_foto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discotUrl_foto.setText("Url foto disco:");

        discoAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discoAñoActionPerformed(evt);
            }
        });

        discoUrl_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discoUrl_fotoActionPerformed(evt);
            }
        });

        discoBotonAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discoBotonAceptar.setText("Aceptar");
        discoBotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discoBotonAceptarActionPerformed(evt);
            }
        });

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout INGRESARDISCOLayout = new javax.swing.GroupLayout(INGRESARDISCO);
        INGRESARDISCO.setLayout(INGRESARDISCOLayout);
        INGRESARDISCOLayout.setHorizontalGroup(
            INGRESARDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, INGRESARDISCOLayout.createSequentialGroup()
                .addGroup(INGRESARDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, INGRESARDISCOLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(INGRESARDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(INGRESARDISCOLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(discotAño))
                            .addComponent(discotUrl_foto))
                        .addGap(18, 18, 18)
                        .addGroup(INGRESARDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(discoAño)
                            .addComponent(discoUrl_foto)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, INGRESARDISCOLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(discotNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(discoNombre)))
                .addGap(32, 32, 32))
            .addGroup(INGRESARDISCOLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(discoBotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, INGRESARDISCOLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(INGRESARDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, INGRESARDISCOLayout.createSequentialGroup()
                        .addComponent(discoTitulo)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, INGRESARDISCOLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(132, 132, 132))))
        );
        INGRESARDISCOLayout.setVerticalGroup(
            INGRESARDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(INGRESARDISCOLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(discoTitulo)
                .addGroup(INGRESARDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(INGRESARDISCOLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(discoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, INGRESARDISCOLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discotNombre)))
                .addGap(18, 18, 18)
                .addGroup(INGRESARDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discotAño)
                    .addComponent(discoAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(INGRESARDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discotUrl_foto)
                    .addComponent(discoUrl_foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(discoBotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(INGRESARDISCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(INGRESARDISCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void discoUrl_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discoUrl_fotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discoUrl_fotoActionPerformed

    private void discoAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discoAñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discoAñoActionPerformed

    private void discoBotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discoBotonAceptarActionPerformed
        // TODO add your handling code here:
        try {
                        
            funcionalidad fDisco = new funcionalidad(); 
            fDisco.conectar();
            ResultSet idArtista = fDisco.consultar("select idartista from artista where nombre='"+pantallaElegirArtista.artistaSeleccionado.nombre+"'");
            idArtista.next();
                                    
            conn = Main.Enlace(conn);
            String sqlinsertar = "insert into disco values (?,?,?,?,?)";
            PreparedStatement insercion = conn.prepareStatement(sqlinsertar);
            insercion.setString(1, null);
            insercion.setString(2, idArtista.getString(1));
            insercion.setString(3, discoNombre.getText());
            insercion.setString(4, discoAño.getText());
            insercion.setString(5, discoUrl_foto.getText());
            insercion.execute();
            insercion.close();

            ResultSet idDisco = fDisco.consultar("select iddisco from disco where nombre='"+discoNombre.getText()+"' and año='"+discoAño.getText()+"'");
            idDisco.next();
            
            ResultSet idUsuario = fDisco.consultar("select idusuario from usuario where login='"+pantallaInicio.SesionActual.login+"'");
            idUsuario.next();
            
            conn = Main.Enlace(conn);
            String sqlinsertar_sigue = "insert into sigue values (?,?,?,?,?)";
            PreparedStatement insercion_sigue = conn.prepareStatement(sqlinsertar_sigue);
            insercion_sigue.setString(1, null);
            insercion_sigue.setString(2, idUsuario.getString(1));
            insercion_sigue.setString(3, null);
            insercion_sigue.setString(4, idDisco.getString(1));
            insercion_sigue.setString(5, null);
            insercion_sigue.execute();
            insercion_sigue.close();
            
            JOptionPane.showMessageDialog(this,"Disco agregado con exito!");
            this.setVisible(false);
            menuUsuario pUsuario = new menuUsuario();
            pUsuario.setVisible(true);
            pUsuario.pack();
            dispose();
                                                
        }catch (Exception e){
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(this,"El disco ya existe, porfavor correjir nombre y año");
        }
    }//GEN-LAST:event_discoBotonAceptarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        pantallaElegirArtista pIngresarCancion = new pantallaElegirArtista();
        pIngresarCancion.setVisible(true);
        pIngresarCancion.pack();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(pantallaIngresarDisco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaIngresarDisco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaIngresarDisco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaIngresarDisco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaIngresarDisco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel INGRESARDISCO;
    private javax.swing.JTextField discoAño;
    private javax.swing.JButton discoBotonAceptar;
    private javax.swing.JTextField discoNombre;
    private javax.swing.JLabel discoTitulo;
    private javax.swing.JTextField discoUrl_foto;
    private javax.swing.JLabel discotAño;
    private javax.swing.JLabel discotNombre;
    private javax.swing.JLabel discotUrl_foto;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
