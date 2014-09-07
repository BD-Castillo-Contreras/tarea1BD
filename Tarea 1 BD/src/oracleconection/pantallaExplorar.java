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
public class pantallaExplorar extends javax.swing.JFrame {

    /**
     * Creates new form pantallaExplorar
     */
    public pantallaExplorar() {
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


private DefaultListModel llenarListaArtistasSeguidos(){
     
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

private DefaultListModel llenarListaTodosLosArtistas(){
    
    DefaultListModel<String> model = new DefaultListModel<>();
    
    try{
        
            funcionalidad fUsuario = new funcionalidad();
            fUsuario.conectar();
            ResultSet nombreArtista = fUsuario.consultar("select nombre from artista");            
            
            while(nombreArtista.next()){
                model.addElement(nombreArtista.getString(1));
            }
            
    }catch (SQLException e){
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(this,"Problemas con la consulta!");
        }
    
    return model;
}

private DefaultListModel llenarListaTodosLosUsuarios(){
    
    DefaultListModel<String> model = new DefaultListModel<>();
    
    try{
        
            funcionalidad fUsuario = new funcionalidad();
            fUsuario.conectar();
            
            ResultSet nombreUsuarioLogeado = fUsuario.consultar("select nombre from usuario where login='"+pantallaInicio.SesionActual.login+"'");
            nombreUsuarioLogeado.next();
            
            ResultSet nombreUsuarios = fUsuario.consultar("select nombre from usuario where not nombre='"+nombreUsuarioLogeado.getString(1)+"'");            
            
            while(nombreUsuarios.next()){
                model.addElement(nombreUsuarios.getString(1));
            }
            
    }catch (SQLException e){
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
    
    public static artistaActual artistaSeleccionadoExplorar = new artistaActual();
    public static usuarioActual usuarioSeleccionadoExplorar = new usuarioActual();
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EXPLORAR = new javax.swing.JPanel();
        textoExplorarTitulo = new javax.swing.JLabel();
        botonTodo = new javax.swing.JButton();
        botonLoQueSigo = new javax.swing.JButton();
        botonSeleccionarArtista = new javax.swing.JButton();
        botonMisListas = new javax.swing.JButton();
        pantallaResultadosArtistas = new javax.swing.JScrollPane();
        artistasEncontrados = new javax.swing.JList();
        pantallaResultadosUsuarios = new javax.swing.JScrollPane();
        usuariosEncontrados = new javax.swing.JList();
        textoArtistasEncontrados = new javax.swing.JLabel();
        textoUsuariosEncontrados = new javax.swing.JLabel();
        botonSeleccionarUsuario = new javax.swing.JButton();
        botonCrearNuevaLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoExplorarTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoExplorarTitulo.setText("Explorar Artistas y Usuarios:");

        botonTodo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonTodo.setText("Todo");
        botonTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTodoActionPerformed(evt);
            }
        });

        botonLoQueSigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonLoQueSigo.setText("Lo que sigo");
        botonLoQueSigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLoQueSigoActionPerformed(evt);
            }
        });

        botonSeleccionarArtista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonSeleccionarArtista.setText("Seleccionar Artista");
        botonSeleccionarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionarArtistaActionPerformed(evt);
            }
        });

        botonMisListas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonMisListas.setText("Mis listas");
        botonMisListas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMisListasActionPerformed(evt);
            }
        });

        pantallaResultadosArtistas.setViewportView(artistasEncontrados);

        pantallaResultadosUsuarios.setViewportView(usuariosEncontrados);

        textoArtistasEncontrados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoArtistasEncontrados.setText("Artistas Encontrados:");

        textoUsuariosEncontrados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoUsuariosEncontrados.setText("Usuarios Encontrados:");

        botonSeleccionarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonSeleccionarUsuario.setText("Seleccionar Usuario");
        botonSeleccionarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionarUsuarioActionPerformed(evt);
            }
        });

        botonCrearNuevaLista.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonCrearNuevaLista.setText("Crear nueva lista");
        botonCrearNuevaLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearNuevaListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EXPLORARLayout = new javax.swing.GroupLayout(EXPLORAR);
        EXPLORAR.setLayout(EXPLORARLayout);
        EXPLORARLayout.setHorizontalGroup(
            EXPLORARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EXPLORARLayout.createSequentialGroup()
                .addGroup(EXPLORARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EXPLORARLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(EXPLORARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonSeleccionarArtista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pantallaResultadosArtistas, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(EXPLORARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pantallaResultadosUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(botonLoQueSigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonSeleccionarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(EXPLORARLayout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addGroup(EXPLORARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonMisListas, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(botonCrearNuevaLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EXPLORARLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EXPLORARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EXPLORARLayout.createSequentialGroup()
                        .addComponent(textoArtistasEncontrados)
                        .addGap(138, 138, 138)
                        .addComponent(textoUsuariosEncontrados)
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EXPLORARLayout.createSequentialGroup()
                        .addComponent(textoExplorarTitulo)
                        .addGap(262, 262, 262))))
        );
        EXPLORARLayout.setVerticalGroup(
            EXPLORARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EXPLORARLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoExplorarTitulo)
                .addGap(18, 18, 18)
                .addGroup(EXPLORARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonTodo)
                    .addComponent(botonLoQueSigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EXPLORARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoArtistasEncontrados)
                    .addComponent(textoUsuariosEncontrados))
                .addGap(18, 18, 18)
                .addGroup(EXPLORARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pantallaResultadosUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(pantallaResultadosArtistas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EXPLORARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSeleccionarArtista)
                    .addComponent(botonSeleccionarUsuario))
                .addGap(26, 26, 26)
                .addComponent(botonMisListas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCrearNuevaLista)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EXPLORAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EXPLORAR, javax.swing.GroupLayout.PREFERRED_SIZE, 569, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonMisListasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMisListasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMisListasActionPerformed

    private void botonLoQueSigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLoQueSigoActionPerformed
        // TODO add your handling code here:
        artistasEncontrados.setModel(llenarListaArtistasSeguidos());
    }//GEN-LAST:event_botonLoQueSigoActionPerformed

    private void botonTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTodoActionPerformed
        // TODO add your handling code here:
        artistasEncontrados.setModel(llenarListaTodosLosArtistas());
        usuariosEncontrados.setModel(llenarListaTodosLosUsuarios());
    }//GEN-LAST:event_botonTodoActionPerformed

    private void botonSeleccionarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarArtistaActionPerformed
        // TODO add your handling code here:
        artistaSeleccionadoExplorar.nombre = artistasEncontrados.getSelectedValue().toString();
        artistaSeleccionadoExplorar.nacionalidad = null;
        this.setVisible(false);
        pantallaPerfilArtista pPerfilArtista = new pantallaPerfilArtista();
        pPerfilArtista.setVisible(true);
        pPerfilArtista.pack();
        dispose();
        
    }//GEN-LAST:event_botonSeleccionarArtistaActionPerformed

    private void botonSeleccionarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarUsuarioActionPerformed
        // TODO add your handling code here:
        usuarioSeleccionadoExplorar.nombre = usuariosEncontrados.getSelectedValue().toString();
        this.setVisible(false);
        pantallaPerfilUsuario pPerfilUsuario = new pantallaPerfilUsuario();
        pPerfilUsuario.setVisible(true);
        pPerfilUsuario.pack();
        dispose();
        
    }//GEN-LAST:event_botonSeleccionarUsuarioActionPerformed

    private void botonCrearNuevaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearNuevaListaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        pantallaIngresarLista pIngresarLista = new pantallaIngresarLista();
        pIngresarLista.setVisible(true);
        pIngresarLista.pack();
        dispose();
    }//GEN-LAST:event_botonCrearNuevaListaActionPerformed

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
            java.util.logging.Logger.getLogger(pantallaExplorar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaExplorar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaExplorar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaExplorar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaExplorar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EXPLORAR;
    private javax.swing.JList artistasEncontrados;
    private javax.swing.JButton botonCrearNuevaLista;
    private javax.swing.JButton botonLoQueSigo;
    private javax.swing.JButton botonMisListas;
    private javax.swing.JButton botonSeleccionarArtista;
    private javax.swing.JButton botonSeleccionarUsuario;
    private javax.swing.JButton botonTodo;
    private javax.swing.JScrollPane pantallaResultadosArtistas;
    private javax.swing.JScrollPane pantallaResultadosUsuarios;
    private javax.swing.JLabel textoArtistasEncontrados;
    private javax.swing.JLabel textoExplorarTitulo;
    private javax.swing.JLabel textoUsuariosEncontrados;
    private javax.swing.JList usuariosEncontrados;
    // End of variables declaration//GEN-END:variables
}
