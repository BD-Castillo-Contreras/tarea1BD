/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oracleconection;

import java.sql.*;
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
public class pantallaPerfilArtista extends javax.swing.JFrame {
        
    static Connection conn=null;
    /**
     * Creates new form pantallaPerfilArtista
     */
    public pantallaPerfilArtista() {
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
public String NombreArtista(String nombre){
        String Resultado = "Sin Informacion";    
    try{
        funcionalidad fArtista = new funcionalidad();
        fArtista.conectar(); 
        ResultSet nombreArtista = fArtista.consultar("select nombre from artista where nombre='"+nombre+"'");
        nombreArtista.next();
        Resultado = nombreArtista.getString(1);
        
    }catch(SQLException e){
        System.out.println(e.getCause());
    }
    return Resultado;
}

public String NacionalidadArtista(String nombre){
        String Resultado = "Sin Informacion";    
    try{
        funcionalidad fArtista = new funcionalidad();
        fArtista.conectar(); 
        ResultSet nacionalidadArtista = fArtista.consultar("select nacionalidad from artista where nombre='"+nombre+"'");
        nacionalidadArtista.next();
        Resultado = nacionalidadArtista.getString(1);
        
    }catch(SQLException e){
        System.out.println(e.getCause());
    }
    return Resultado;
}

public String GeneroArtista(String nombre){
        String Resultado = "Sin Informacion";    
    try{
        funcionalidad fArtista = new funcionalidad();
        fArtista.conectar(); 
        ResultSet generoArtista = fArtista.consultar("select genero from artista where nombre='"+nombre+"'");
        generoArtista.next();
        Resultado = generoArtista.getString(1);
        
    }catch(SQLException e){
        System.out.println(e.getCause());
    }
    return Resultado;
}

public String FotoArtista(String nombre){
        String Resultado = "Sin Informacion";    
    try{
        funcionalidad fArtista = new funcionalidad();
        fArtista.conectar(); 
        ResultSet fotoArtista = fArtista.consultar("select url_foto from artista where nombre='"+nombre+"'");
        fotoArtista.next();
        Resultado = fotoArtista.getString(1);
        
    }catch(SQLException e){
        System.out.println(e.getCause());
    }
    return Resultado;
}

private DefaultListModel llenarListaDiscosArtista(){
    
    DefaultListModel<String> model = new DefaultListModel<>();
    
    try{
        
            funcionalidad fUsuario = new funcionalidad();
            fUsuario.conectar();
            ResultSet idArtista = fUsuario.consultar("select idartista from artista where nombre='"+pantallaExplorar.artistaSeleccionadoExplorar.nombre+"'");
            idArtista.next();
            
            ResultSet nombreDisco = fUsuario.consultar("select nombre from disco where artista_idartista='"+idArtista.getString(1)+"'");
            
            while(nombreDisco.next()){
                model.addElement(nombreDisco.getString(1));
            }
            
    }catch (SQLException e){
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(this,"Problemas con la consulta!");
        }
    
    return model;
}

public String NombreDisco(String disco){
        String Resultado = "Sin Informacion";    
    try{
        funcionalidad fArtista = new funcionalidad();
        fArtista.conectar(); 
        ResultSet nombreDisco = fArtista.consultar("select nombre from disco where nombre='"+disco+"'");
        nombreDisco.next();
        Resultado = nombreDisco.getString(1);
        
    }catch(SQLException e){
        System.out.println(e.getCause());
    }
    return Resultado;
}

public String AñoDisco(String disco){
        String Resultado = "Sin Informacion";    
    try{
        funcionalidad fArtista = new funcionalidad();
        fArtista.conectar(); 
        ResultSet añoDisco = fArtista.consultar("select año from disco where nombre='"+disco+"'");
        añoDisco.next();
        Resultado = añoDisco.getString(1);
        
    }catch(SQLException e){
        System.out.println(e.getCause());
    }
    return Resultado;
}

public String FotoDisco(String disco){
        String Resultado = "Sin Informacion";    
    try{
        funcionalidad fArtista = new funcionalidad();
        fArtista.conectar(); 
        ResultSet fotoDisco = fArtista.consultar("select url_foto from disco where nombre='"+disco+"'");
        fotoDisco.next();
        Resultado = fotoDisco.getString(1);
        
    }catch(SQLException e){
        System.out.println(e.getCause());
    }
    return Resultado;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PERFILARTISTA = new javax.swing.JPanel();
        textoTitulo = new javax.swing.JLabel();
        textoNombre = new javax.swing.JLabel();
        textoNacionalidad = new javax.swing.JLabel();
        textoGenero = new javax.swing.JLabel();
        textoUrl_Foto = new javax.swing.JLabel();
        String nombre = NombreArtista(pantallaExplorar.artistaSeleccionadoExplorar.nombre);
        textoDatosNombre = new javax.swing.JLabel();
        String nacionalidad = NacionalidadArtista(pantallaExplorar.artistaSeleccionadoExplorar.nombre);
        textoDatosNacionalidad = new javax.swing.JLabel();
        String genero = GeneroArtista(pantallaExplorar.artistaSeleccionadoExplorar.nombre);
        textoDatosGenero = new javax.swing.JLabel();
        String foto = FotoArtista(pantallaExplorar.artistaSeleccionadoExplorar.nombre);
        textoDatosUrl_Foto = new javax.swing.JLabel();
        pantallaResultados = new javax.swing.JScrollPane();
        resultadosDiscos = new javax.swing.JList();
        botonInformacionDisco = new javax.swing.JButton();
        botonSeguirArtista = new javax.swing.JButton();
        botonDiscos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoTitulo.setText("Perfil Artista:");

        textoNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoNombre.setText("Nombre:");

        textoNacionalidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoNacionalidad.setText("Nacionalidad:");

        textoGenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoGenero.setText("Genero:");

        textoUrl_Foto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoUrl_Foto.setText("Url_Foto:");

        textoDatosNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoDatosNombre.setText(nombre);

        textoDatosNacionalidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoDatosNacionalidad.setText(nacionalidad);

        textoDatosGenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoDatosGenero.setText(genero);

        textoDatosUrl_Foto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoDatosUrl_Foto.setText(foto);

        pantallaResultados.setViewportView(resultadosDiscos);

        botonInformacionDisco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonInformacionDisco.setText("Ver Informacion Disco");
        botonInformacionDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInformacionDiscoActionPerformed(evt);
            }
        });

        botonSeguirArtista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonSeguirArtista.setText("Seguir Artista");
        botonSeguirArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeguirArtistaActionPerformed(evt);
            }
        });

        botonDiscos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonDiscos.setText("Discos");
        botonDiscos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDiscosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PERFILARTISTALayout = new javax.swing.GroupLayout(PERFILARTISTA);
        PERFILARTISTA.setLayout(PERFILARTISTALayout);
        PERFILARTISTALayout.setHorizontalGroup(
            PERFILARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PERFILARTISTALayout.createSequentialGroup()
                .addGroup(PERFILARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PERFILARTISTALayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(PERFILARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PERFILARTISTALayout.createSequentialGroup()
                                .addGroup(PERFILARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoNacionalidad)
                                    .addComponent(textoNombre)
                                    .addComponent(textoGenero)
                                    .addComponent(textoUrl_Foto))
                                .addGroup(PERFILARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PERFILARTISTALayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(textoDatosNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PERFILARTISTALayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(PERFILARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textoDatosNacionalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textoDatosGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textoDatosUrl_Foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(PERFILARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(botonSeguirArtista, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonInformacionDisco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(botonDiscos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pantallaResultados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addGroup(PERFILARTISTALayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(textoTitulo)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        PERFILARTISTALayout.setVerticalGroup(
            PERFILARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PERFILARTISTALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoTitulo)
                .addGap(32, 32, 32)
                .addGroup(PERFILARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoNombre)
                    .addComponent(textoDatosNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PERFILARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textoNacionalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoDatosNacionalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PERFILARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textoGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoDatosGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PERFILARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoUrl_Foto)
                    .addComponent(textoDatosUrl_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonDiscos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pantallaResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonInformacionDisco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonSeguirArtista)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PERFILARTISTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PERFILARTISTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void botonSeguirArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeguirArtistaActionPerformed
        // TODO add your handling code here:
        try{
            
            conn = Main.Enlace(conn);
            
            funcionalidad fArtista = new funcionalidad(); 
            fArtista.conectar(); 
            ResultSet idUsuario = fArtista.consultar("select idusuario from usuario where login='"+pantallaInicio.SesionActual.login+"'");
            idUsuario.next();
            
            
            ResultSet idArtista = fArtista.consultar("select idartista from artista where nombre='"+NombreArtista(pantallaExplorar.artistaSeleccionadoExplorar.nombre)+"' and nacionalidad='"+NacionalidadArtista(pantallaExplorar.artistaSeleccionadoExplorar.nombre)+"'");
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
            
            JOptionPane.showMessageDialog(this,"Artista seguido!");
        }catch(SQLException  e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Ya sigue a este Artista!");
        }
    }//GEN-LAST:event_botonSeguirArtistaActionPerformed

    private void botonInformacionDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInformacionDiscoActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this,"Nombre Disco: "+NombreDisco(resultadosDiscos.getSelectedValue().toString())+"\n Año Disco: "+AñoDisco(resultadosDiscos.getSelectedValue().toString())+"\n Foto Disco: "+FotoDisco(resultadosDiscos.getSelectedValue().toString()));
    }//GEN-LAST:event_botonInformacionDiscoActionPerformed

    private void botonDiscosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDiscosActionPerformed
        // TODO add your handling code here:
        resultadosDiscos.setModel(llenarListaDiscosArtista());
    }//GEN-LAST:event_botonDiscosActionPerformed

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
            java.util.logging.Logger.getLogger(pantallaPerfilArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaPerfilArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaPerfilArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaPerfilArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaPerfilArtista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PERFILARTISTA;
    private javax.swing.JButton botonDiscos;
    private javax.swing.JButton botonInformacionDisco;
    private javax.swing.JButton botonSeguirArtista;
    private javax.swing.JScrollPane pantallaResultados;
    private javax.swing.JList resultadosDiscos;
    private javax.swing.JLabel textoDatosGenero;
    private javax.swing.JLabel textoDatosNacionalidad;
    private javax.swing.JLabel textoDatosNombre;
    private javax.swing.JLabel textoDatosUrl_Foto;
    private javax.swing.JLabel textoGenero;
    private javax.swing.JLabel textoNacionalidad;
    private javax.swing.JLabel textoNombre;
    private javax.swing.JLabel textoTitulo;
    private javax.swing.JLabel textoUrl_Foto;
    // End of variables declaration//GEN-END:variables
}
