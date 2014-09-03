/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oracleconection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JP
 */
public class pantallaElegirDisco extends javax.swing.JFrame {

    /**
     * Creates new form pantallaElegirDisco
     */
    public pantallaElegirDisco() {
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


private DefaultListModel llenarListaDisco(){
     
    DefaultListModel<String> model = new DefaultListModel<>();
    
    try {
                                
            funcionalidad fArtista = new funcionalidad();
            fArtista.conectar(); 
            ResultSet idArtista = fArtista.consultar("select idartista from artista where nombre='"+pantallaElegirArtistaCaso4.artistaSeleccionadoCaso4.nombre+"'");
            idArtista.next();
            
            ResultSet idDiscoArtista = fArtista.consultar("select iddisco from disco where artista_idartista='"+idArtista.getString(1)+"'");
            idArtista.close();
            
            while(idDiscoArtista.next()){
                
                ResultSet nombreDisco = fArtista.consultar("select nombre from disco where iddisco='"+idDiscoArtista.getString(1)+"'");
                nombreDisco.next();
                model.addElement(nombreDisco.getString(1));
                nombreDisco.close();
                                           
            }
            idDiscoArtista.close();
                                   
        }catch (Exception e){
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(this,"El artista no tiene discos!");
        }
   return model;
}    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ELEGIRDISCO = new javax.swing.JPanel();
        elegirDisco = new javax.swing.JLabel();
        botonMostrarDiscos = new javax.swing.JButton();
        pantallaResultados = new javax.swing.JScrollPane();
        resultadosDiscos = new javax.swing.JList();
        botonSeleccionarDisco = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        elegirDisco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        elegirDisco.setText("Elegir un Disco para insertar una Canción:");

        botonMostrarDiscos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonMostrarDiscos.setText("Mostrar Discos del Artista");
        botonMostrarDiscos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarDiscosActionPerformed(evt);
            }
        });

        pantallaResultados.setViewportView(resultadosDiscos);

        botonSeleccionarDisco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonSeleccionarDisco.setText("Seleccionar Disco");
        botonSeleccionarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionarDiscoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ELEGIRDISCOLayout = new javax.swing.GroupLayout(ELEGIRDISCO);
        ELEGIRDISCO.setLayout(ELEGIRDISCOLayout);
        ELEGIRDISCOLayout.setHorizontalGroup(
            ELEGIRDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ELEGIRDISCOLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(ELEGIRDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonSeleccionarDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pantallaResultados)
                    .addComponent(botonMostrarDiscos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(elegirDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        ELEGIRDISCOLayout.setVerticalGroup(
            ELEGIRDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ELEGIRDISCOLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(elegirDisco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonMostrarDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pantallaResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSeleccionarDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(ELEGIRDISCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ELEGIRDISCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public static discoActual discoSeleccionado = new discoActual();
    
    private void botonMostrarDiscosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarDiscosActionPerformed
        // TODO add your handling code here:
        resultadosDiscos.setModel(llenarListaDisco());
        
    }//GEN-LAST:event_botonMostrarDiscosActionPerformed

    private void botonSeleccionarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarDiscoActionPerformed
        // TODO add your handling code here:
        discoSeleccionado.nombre = resultadosDiscos.getSelectedValue().toString();
        discoSeleccionado.año = null;
        this.setVisible(false);
        pantallaIngresarCancion pIngresarCancion = new pantallaIngresarCancion();
        pIngresarCancion.setVisible(true);
        pIngresarCancion.pack();
        dispose();
    }//GEN-LAST:event_botonSeleccionarDiscoActionPerformed

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
            java.util.logging.Logger.getLogger(pantallaElegirDisco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaElegirDisco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaElegirDisco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaElegirDisco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaElegirDisco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ELEGIRDISCO;
    private javax.swing.JButton botonMostrarDiscos;
    private javax.swing.JButton botonSeleccionarDisco;
    private javax.swing.JLabel elegirDisco;
    private javax.swing.JScrollPane pantallaResultados;
    private javax.swing.JList resultadosDiscos;
    // End of variables declaration//GEN-END:variables
}
