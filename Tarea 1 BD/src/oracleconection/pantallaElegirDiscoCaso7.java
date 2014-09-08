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
public class pantallaElegirDiscoCaso7 extends javax.swing.JFrame {

    /**
     * Creates new form pantallaElegirDiscoCaso7
     */
    public pantallaElegirDiscoCaso7() {
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
                                
            funcionalidad fDisco = new funcionalidad();
            fDisco.conectar();
            
            ResultSet idUsuario = fDisco.consultar("select idusuario from usuario where login='"+pantallaInicio.SesionActual.login+"'");
            idUsuario.next();
            
            ResultSet artista_idArtista = fDisco.consultar("select artista_idartista from sigue where usuario_idusuario='"+idUsuario.getString(1)+"'");
            
            
            while(artista_idArtista.next()){
                
                ResultSet nombreDisco = fDisco.consultar("select nombre from disco where artista_idartista='"+artista_idArtista.getString(1)+"'");
                nombreDisco.next();
                model.addElement(nombreDisco.getString(1));
                nombreDisco.close();
                
            }
            artista_idArtista.close();
            idUsuario.close();
            
            JOptionPane.showMessageDialog(this,"Discos encontrados!");
                                   
        }catch (SQLException e){
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(this,"El usuario no sigue a ningun artista y disco!");
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
        textoTitulo = new javax.swing.JLabel();
        pantallaResultados = new javax.swing.JScrollPane();
        discosEncontrados = new javax.swing.JList();
        botonMostrarDiscos = new javax.swing.JButton();
        botonSeleccionarDisco = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoTitulo.setText("Elija un disco de un artista:");

        pantallaResultados.setViewportView(discosEncontrados);

        botonMostrarDiscos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonMostrarDiscos.setText("Mostrar Discos que sigo");
        botonMostrarDiscos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarDiscosActionPerformed(evt);
            }
        });

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
                .addGroup(ELEGIRDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ELEGIRDISCOLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(textoTitulo))
                    .addGroup(ELEGIRDISCOLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(ELEGIRDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pantallaResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(botonMostrarDiscos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonSeleccionarDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        ELEGIRDISCOLayout.setVerticalGroup(
            ELEGIRDISCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ELEGIRDISCOLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonMostrarDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pantallaResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSeleccionarDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ELEGIRDISCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ELEGIRDISCO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

public static discoActual discoSeleccionado = new discoActual();
    
    private void botonSeleccionarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarDiscoActionPerformed
        // TODO add your handling code here:
        discoSeleccionado.nombre = discosEncontrados.getSelectedValue().toString();
        
        try{
            
        funcionalidad fDisco = new funcionalidad();
        fDisco.conectar();
            
        ResultSet añoDisco = fDisco.consultar("select año from disco where nombre='"+discoSeleccionado.nombre+"'");
        añoDisco.next();
            
        discoSeleccionado.año = añoDisco.getString(1);
        añoDisco.close();
        
        this.setVisible(false);
        pantallaElegirCancionCaso7 pElegirCancionCaso7 = new pantallaElegirCancionCaso7();
        pElegirCancionCaso7.setVisible(true);
        pElegirCancionCaso7.pack();
        dispose();
        
        }catch(SQLException e){
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(this,"Problemas seleccionando el Disco!");
        }
    }//GEN-LAST:event_botonSeleccionarDiscoActionPerformed

    private void botonMostrarDiscosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarDiscosActionPerformed
        // TODO add your handling code here:
        discosEncontrados.setModel(llenarListaDisco());
    }//GEN-LAST:event_botonMostrarDiscosActionPerformed

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
            java.util.logging.Logger.getLogger(pantallaElegirDiscoCaso7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaElegirDiscoCaso7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaElegirDiscoCaso7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaElegirDiscoCaso7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaElegirDiscoCaso7().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ELEGIRDISCO;
    private javax.swing.JButton botonMostrarDiscos;
    private javax.swing.JButton botonSeleccionarDisco;
    private javax.swing.JList discosEncontrados;
    private javax.swing.JScrollPane pantallaResultados;
    private javax.swing.JLabel textoTitulo;
    // End of variables declaration//GEN-END:variables
}
