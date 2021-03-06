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
 * @author orpcr
 */
public class pantallaEditar extends javax.swing.JFrame {

    /**
     * Creates new form pantallaEditar
     */
    public pantallaEditar() {
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

public boolean actualizar(String sql) { 
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


private DefaultListModel llenarLista(){
     
    DefaultListModel<String> model = new DefaultListModel<>();
    
    try {
                                
            funcionalidad fUsuario = new funcionalidad();
            fUsuario.conectar(); 
            ResultSet idUsuario = fUsuario.consultar("select idusuario from usuario where login='"+pantallaInicio.SesionActual.login+"'");
            idUsuario.next();
            
            ResultSet idArtistasSeguidos = fUsuario.consultar("select artista_idartista from sigue where usuario_idusuario='"+idUsuario.getString(1)+"'");
            idUsuario.close();
            
            while(idArtistasSeguidos.next()){
                
                ResultSet nombreArtista = fUsuario.consultar("select nombre from artista where idartista='"+idArtistasSeguidos.getString(1)+"'");
                nombreArtista.next();
                model.addElement(nombreArtista.getString(1));
                nombreArtista.close();
                                           
            }
            idArtistasSeguidos.close();
                        
        }catch (Exception e){
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(this,"Problemas con la consulta!");
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEditar = new javax.swing.JList();
        botonMostrar1 = new javax.swing.JButton();
        verEditar = new javax.swing.JButton();
        editarEditar = new javax.swing.JButton();
        eliminarEditar = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaEditar.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaEditar);

        botonMostrar1.setText("Mostrar Artistas Seguidos");
        botonMostrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrar1ActionPerformed(evt);
            }
        });

        verEditar.setText("Ver discos");

        editarEditar.setText("Editar");
        editarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarEditarActionPerformed(evt);
            }
        });

        eliminarEditar.setText("Eliminar");
        eliminarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEditarActionPerformed(evt);
            }
        });

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonMostrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(verEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(botonMostrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verEditar)
                    .addComponent(editarEditar)
                    .addComponent(eliminarEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static artistaActual artistaSeleccionado = new artistaActual();
    
    private void eliminarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEditarActionPerformed
        try {             
            funcionalidad fUsuario = new funcionalidad();
            fUsuario.conectar(); 
            ResultSet idartista = fUsuario.consultar("select idartista from artista where nombre='"+listaEditar.getSelectedValue().toString()+"'");
            idartista.next();
            
            String sql ="DELETE FROM sigue WHERE usuario_idusuario='"+pantallaInicio.SesionActual.id+"' AND artista_idartista='"+idartista.getString(1)+"'"; 
            boolean estado = fUsuario.escribir(sql);
            if (estado==true) {
                JOptionPane.showMessageDialog(this,"Eliminado exitosamente!");
                this.setVisible(false);
                pantallaEditar pedit = new pantallaEditar();
                pedit.setVisible(true);
                pedit.pack();
                dispose();
                
            }
            else{
                JOptionPane.showMessageDialog(this,"No pudimos eliminar el artista");
            }
               
        }catch (Exception e){
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(this,"Problemas con la consulta!");
        }
    }//GEN-LAST:event_eliminarEditarActionPerformed

    private void botonMostrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrar1ActionPerformed
        listaEditar.setModel(llenarLista());
    }//GEN-LAST:event_botonMostrar1ActionPerformed

    private void editarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarEditarActionPerformed
        artistaSeleccionado.nombre = listaEditar.getSelectedValue().toString();
       try {  
           
            funcionalidad fUsuario = new funcionalidad();
            fUsuario.conectar(); 
            
            ResultSet nacionalidad = fUsuario.consultar("select nacionalidad from artista where nombre='"+artistaSeleccionado.nombre+"'");
            nacionalidad.next();
            
            System.out.println(artistaSeleccionado.nombre);
            
            ResultSet genero = fUsuario.consultar("select genero from artista where nombre='"+artistaSeleccionado.nombre+"'");
            genero.next();
            
            ResultSet foto = fUsuario.consultar("select url_foto from artista where nombre='"+artistaSeleccionado.nombre+"'");
            foto.next();
            
            ResultSet id = fUsuario.consultar("select idartista from artista where nombre='"+artistaSeleccionado.nombre+"'");
            id.next();
            
            
            artistaSeleccionado.foto=foto.getString(1);
            artistaSeleccionado.genero=genero.getString(1);
            artistaSeleccionado.nacionalidad=nacionalidad.getString(1);
            artistaSeleccionado.id=id.getString(1);
            
                                 
        }catch (Exception e){
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(this,"Problemas con la consulta!");
        }
        
        this.setVisible(false);
        pantallaEditarArtista pEditArtista = new pantallaEditarArtista();
        pEditArtista.setVisible(true);
        pEditArtista.pack();
        dispose();
    }//GEN-LAST:event_editarEditarActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        this.setVisible(false);
        menuUsuario pMenu = new menuUsuario();
        pMenu.setVisible(true);
        pMenu.pack();
        dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

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
            java.util.logging.Logger.getLogger(pantallaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaEditar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMostrar1;
    private javax.swing.JButton botonVolver;
    private javax.swing.JButton editarEditar;
    private javax.swing.JButton eliminarEditar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaEditar;
    private javax.swing.JButton verEditar;
    // End of variables declaration//GEN-END:variables
}
