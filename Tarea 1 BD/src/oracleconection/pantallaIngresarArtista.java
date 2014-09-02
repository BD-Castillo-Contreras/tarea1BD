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
public class pantallaIngresarArtista extends javax.swing.JFrame {
    
    static Connection conn=null;
    /**
     * Creates new form pantallaIngresarArtista
     */
    public pantallaIngresarArtista() {
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

        ARTISTA = new javax.swing.JPanel();
        artistaTitulo = new javax.swing.JLabel();
        artistatNombre = new javax.swing.JLabel();
        artistatNacionalidad = new javax.swing.JLabel();
        artistatGenero = new javax.swing.JLabel();
        artistatUrl_foto = new javax.swing.JLabel();
        artistaNombre = new javax.swing.JTextField();
        artistaNacionalidad = new javax.swing.JTextField();
        artistaGenero = new javax.swing.JTextField();
        artistaUrl_foto = new javax.swing.JTextField();
        artistaBotonAceptar = new javax.swing.JButton();
        artistaBotonSeguir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        artistaTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        artistaTitulo.setText("Datos del Artista:");

        artistatNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        artistatNombre.setText("Nombre:");

        artistatNacionalidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        artistatNacionalidad.setText("Nacionalidad:");

        artistatGenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        artistatGenero.setText("Genero:");

        artistatUrl_foto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        artistatUrl_foto.setText("Url foto artista:");

        artistaUrl_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artistaUrl_fotoActionPerformed(evt);
            }
        });

        artistaBotonAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        artistaBotonAceptar.setText("Aceptar");
        artistaBotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artistaBotonAceptarActionPerformed(evt);
            }
        });

        artistaBotonSeguir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        artistaBotonSeguir.setText("Seguir Artista");
        artistaBotonSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artistaBotonSeguirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ARTISTALayout = new javax.swing.GroupLayout(ARTISTA);
        ARTISTA.setLayout(ARTISTALayout);
        ARTISTALayout.setHorizontalGroup(
            ARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ARTISTALayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(ARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, ARTISTALayout.createSequentialGroup()
                        .addComponent(artistatNacionalidad)
                        .addGap(25, 25, 25)
                        .addComponent(artistaNacionalidad))
                    .addGroup(ARTISTALayout.createSequentialGroup()
                        .addGroup(ARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(artistatGenero)
                            .addComponent(artistatUrl_foto))
                        .addGap(14, 14, 14)
                        .addGroup(ARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(artistaGenero)
                            .addComponent(artistaUrl_foto)))
                    .addGroup(ARTISTALayout.createSequentialGroup()
                        .addGroup(ARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(artistaTitulo, javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, ARTISTALayout.createSequentialGroup()
                                .addComponent(artistatNombre)
                                .addGap(51, 51, 51)
                                .addComponent(artistaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(70, 70, 70))
            .addGroup(ARTISTALayout.createSequentialGroup()
                .addGroup(ARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ARTISTALayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(artistaBotonAceptar))
                    .addGroup(ARTISTALayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(artistaBotonSeguir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ARTISTALayout.setVerticalGroup(
            ARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ARTISTALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(artistaTitulo)
                .addGap(31, 31, 31)
                .addGroup(ARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistatNombre)
                    .addComponent(artistaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistatNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(artistaNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistatGenero)
                    .addComponent(artistaGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistatUrl_foto)
                    .addComponent(artistaUrl_foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(artistaBotonAceptar)
                .addGap(27, 27, 27)
                .addComponent(artistaBotonSeguir)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(ARTISTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ARTISTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void artistaUrl_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_artistaUrl_fotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_artistaUrl_fotoActionPerformed

    private void artistaBotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_artistaBotonAceptarActionPerformed
        // TODO add your handling code here:
        
        try {
            
            conn = Main.Enlace(conn);
            String sqlinsertar = "insert into artista values (?,?,?,?,?)";
            PreparedStatement psta = conn.prepareStatement(sqlinsertar);
            psta.setString(1, null);
            psta.setString(2, artistaNombre.getText());
            psta.setString(3, artistaNacionalidad.getText());
            psta.setString(4, artistaGenero.getText());
            psta.setString(5, artistaUrl_foto.getText());            
            psta.execute();
            psta.close();
            
            funcionalidad fArtista = new funcionalidad(); 
            fArtista.conectar(); 
            ResultSet idUsuario = fArtista.consultar("select idusuario from usuario where login='"+pantallaInicio.SesionActual.login+"'");
            idUsuario.next();
            
            
            ResultSet idArtista = fArtista.consultar("select idartista from artista where nombre='"+artistaNombre.getText()+"' and nacionalidad='"+artistaNacionalidad.getText()+"'");
            idArtista.next();
            
            
            String sqlinsertar_sigue = "insert into sigue values (?,?,?,?,?)";
            PreparedStatement insercion = conn.prepareStatement(sqlinsertar_sigue);
            insercion.setString(1, null);
            insercion.setString(2, idUsuario.getString(1));
            insercion.setString(3, idArtista.getString(1));
            insercion.setString(4, null);
            insercion.setString(5, null);
            insercion.execute();
            insercion.close();
            
            idUsuario.close();
            idArtista.close();
            
            JOptionPane.showMessageDialog(this,"Artista ingresado exitosamente!");
                       
                this.setVisible(false);
                menuUsuario pMenuUsuario = new menuUsuario();
                pMenuUsuario.setVisible(true);
                pMenuUsuario.pack();
                dispose();
            
        }catch (Exception e){
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(this,"Nombre y nacionalidad del artista ya existe, porfavor elija la opcion Seguir Artista.");
        }
        
    }//GEN-LAST:event_artistaBotonAceptarActionPerformed

    private void artistaBotonSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_artistaBotonSeguirActionPerformed
        // TODO add your handling code here:
        try{
            
            funcionalidad fArtista = new funcionalidad(); 
            fArtista.conectar(); 
            pantallaInicio.SesionActual.getLogin();
            ResultSet idUsuario = fArtista.consultar("select idusuario from usuario where login='"+pantallaInicio.SesionActual.login+"'");
            idUsuario.next();
            
            pantallaInicio.SesionActual.getLogin();
                        
            ResultSet idArtista = fArtista.consultar("select idartista from artista where nombre='"+artistaNombre.getText()+"' and nacionalidad='"+artistaNacionalidad.getText()+"'");
            idArtista.next();
                        
            conn = Main.Enlace(conn);
            String sqlinsertar_sigue = "insert into sigue values (?,?,?,?,?)";
            PreparedStatement insercion = conn.prepareStatement(sqlinsertar_sigue);
            insercion.setString(1, null);
            insercion.setString(2, idUsuario.getString(1));
            insercion.setString(3, idArtista.getString(1));
            insercion.setString(4, null);
            insercion.setString(5, null);
            insercion.execute();
            insercion.close();
            
            idUsuario.close();
            idArtista.close();
            
            JOptionPane.showMessageDialog(this,"Artista seguido exitosamente!");
            
            this.setVisible(false);
                menuUsuario pMenuUsuario = new menuUsuario();
                pMenuUsuario.setVisible(true);
                pMenuUsuario.pack();
                dispose();
                
        }catch (Exception e){
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(this,"Este artista no existe, porfavor elija la opcion Aceptar");
        }   
    }//GEN-LAST:event_artistaBotonSeguirActionPerformed

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
            java.util.logging.Logger.getLogger(pantallaIngresarArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaIngresarArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaIngresarArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaIngresarArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaIngresarArtista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ARTISTA;
    private javax.swing.JButton artistaBotonAceptar;
    private javax.swing.JButton artistaBotonSeguir;
    private javax.swing.JTextField artistaGenero;
    private javax.swing.JTextField artistaNacionalidad;
    private javax.swing.JTextField artistaNombre;
    private javax.swing.JLabel artistaTitulo;
    private javax.swing.JTextField artistaUrl_foto;
    private javax.swing.JLabel artistatGenero;
    private javax.swing.JLabel artistatNacionalidad;
    private javax.swing.JLabel artistatNombre;
    private javax.swing.JLabel artistatUrl_foto;
    // End of variables declaration//GEN-END:variables
}
