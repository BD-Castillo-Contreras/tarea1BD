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
public class pantallaPerfilUsuario extends javax.swing.JFrame {

    /**
     * Creates new form pantallaPerfilUsuario
     */
    public pantallaPerfilUsuario() {
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
public String NombreUsuario(String nombre){
        String Resultado = "Sin Informacion";    
    try{
        funcionalidad fArtista = new funcionalidad();
        fArtista.conectar(); 
        ResultSet nombreUsuario = fArtista.consultar("select nombre from usuario where nombre='"+nombre+"'");
        nombreUsuario.next();
        Resultado = nombreUsuario.getString(1);
        
    }catch(SQLException e){
        System.out.println(e.getCause());
    }
    return Resultado;
}

public String ApellidosUsuario(String nombre){
        String Resultado = "Sin Informacion";    
    try{
        funcionalidad fArtista = new funcionalidad();
        fArtista.conectar(); 
        ResultSet apellidosUsuario = fArtista.consultar("select apellidos from usuario where nombre='"+nombre+"'");
        apellidosUsuario.next();
        Resultado = apellidosUsuario.getString(1);
        
    }catch(SQLException e){
        System.out.println(e.getCause());
    }
    return Resultado;
}

public String EdadUsuario(String nombre){
        String Resultado = "Sin Informacion";    
    try{
        funcionalidad fArtista = new funcionalidad();
        fArtista.conectar(); 
        ResultSet edadUsuario = fArtista.consultar("select edad from usuario where nombre='"+nombre+"'");
        edadUsuario.next();
        Resultado = edadUsuario.getString(1);
        
    }catch(SQLException e){
        System.out.println(e.getCause());
    }
    return Resultado;
}

public String NacionalidadUsuario(String nombre){
        String Resultado = "Sin Informacion";    
    try{
        funcionalidad fArtista = new funcionalidad();
        fArtista.conectar(); 
        ResultSet nacionalidadUsuario = fArtista.consultar("select nacionalidad from usuario where nombre='"+nombre+"'");
        nacionalidadUsuario.next();
        Resultado = nacionalidadUsuario.getString(1);
        
    }catch(SQLException e){
        System.out.println(e.getCause());
    }
    return Resultado;
}

public String FotoUsuario(String nombre){
        String Resultado = "Sin Informacion";    
    try{
        funcionalidad fArtista = new funcionalidad();
        fArtista.conectar(); 
        ResultSet fotoUsuario = fArtista.consultar("select url_foto from usuario where nombre='"+nombre+"'");
        fotoUsuario.next();
        Resultado = fotoUsuario.getString(1);
        
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

        PERFILUSUARIO = new javax.swing.JPanel();
        textoTitulo = new javax.swing.JLabel();
        textoNombre = new javax.swing.JLabel();
        textoApellidos = new javax.swing.JLabel();
        textoEdad = new javax.swing.JLabel();
        textoNacionalidad = new javax.swing.JLabel();
        textoFoto = new javax.swing.JLabel();
        String nombre = NombreUsuario(pantallaExplorar.usuarioSeleccionadoExplorar.nombre);
        textoDatosNombre = new javax.swing.JLabel();
        String apellidos = ApellidosUsuario(pantallaExplorar.usuarioSeleccionadoExplorar.nombre);
        textoDatosApellidos = new javax.swing.JLabel();
        String edad = EdadUsuario(pantallaExplorar.usuarioSeleccionadoExplorar.nombre);
        textoDatosEdad = new javax.swing.JLabel();
        String nacionalidad = NacionalidadUsuario(pantallaExplorar.usuarioSeleccionadoExplorar.nombre);
        textoDatosNacionalidad = new javax.swing.JLabel();
        String foto = FotoUsuario(pantallaExplorar.usuarioSeleccionadoExplorar.nombre);
        textoDatosFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoTitulo.setText("Perfil Usuario:");

        textoNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoNombre.setText("Nombre:");

        textoApellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoApellidos.setText("Apellidos:");

        textoEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoEdad.setText("Edad:");

        textoNacionalidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoNacionalidad.setText("Nacionalidad:");

        textoFoto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoFoto.setText("Foto:");

        textoDatosNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoDatosNombre.setText(nombre);

        textoDatosApellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoDatosApellidos.setText(apellidos);

        textoDatosEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoDatosEdad.setText(edad);

        textoDatosNacionalidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoDatosNacionalidad.setText(nacionalidad);

        textoDatosFoto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoDatosFoto.setText(foto);

        javax.swing.GroupLayout PERFILUSUARIOLayout = new javax.swing.GroupLayout(PERFILUSUARIO);
        PERFILUSUARIO.setLayout(PERFILUSUARIOLayout);
        PERFILUSUARIOLayout.setHorizontalGroup(
            PERFILUSUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PERFILUSUARIOLayout.createSequentialGroup()
                .addGroup(PERFILUSUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PERFILUSUARIOLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(textoTitulo))
                    .addGroup(PERFILUSUARIOLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(PERFILUSUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PERFILUSUARIOLayout.createSequentialGroup()
                                .addGroup(PERFILUSUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoNombre)
                                    .addComponent(textoApellidos)
                                    .addComponent(textoEdad))
                                .addGap(43, 43, 43)
                                .addGroup(PERFILUSUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoDatosEdad)
                                    .addComponent(textoDatosApellidos)
                                    .addComponent(textoDatosNombre)))
                            .addGroup(PERFILUSUARIOLayout.createSequentialGroup()
                                .addGroup(PERFILUSUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoNacionalidad)
                                    .addComponent(textoFoto))
                                .addGap(18, 18, 18)
                                .addGroup(PERFILUSUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoDatosFoto)
                                    .addComponent(textoDatosNacionalidad))))))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        PERFILUSUARIOLayout.setVerticalGroup(
            PERFILUSUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PERFILUSUARIOLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoTitulo)
                .addGap(18, 18, 18)
                .addGroup(PERFILUSUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoNombre)
                    .addComponent(textoDatosNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PERFILUSUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoApellidos)
                    .addComponent(textoDatosApellidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PERFILUSUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoEdad)
                    .addComponent(textoDatosEdad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PERFILUSUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoNacionalidad)
                    .addComponent(textoDatosNacionalidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PERFILUSUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoFoto)
                    .addComponent(textoDatosFoto))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PERFILUSUARIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PERFILUSUARIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(pantallaPerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaPerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaPerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaPerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaPerfilUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PERFILUSUARIO;
    private javax.swing.JLabel textoApellidos;
    private javax.swing.JLabel textoDatosApellidos;
    private javax.swing.JLabel textoDatosEdad;
    private javax.swing.JLabel textoDatosFoto;
    private javax.swing.JLabel textoDatosNacionalidad;
    private javax.swing.JLabel textoDatosNombre;
    private javax.swing.JLabel textoEdad;
    private javax.swing.JLabel textoFoto;
    private javax.swing.JLabel textoNacionalidad;
    private javax.swing.JLabel textoNombre;
    private javax.swing.JLabel textoTitulo;
    // End of variables declaration//GEN-END:variables
}
