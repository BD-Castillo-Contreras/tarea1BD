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
public class pantallaIngresarLista extends javax.swing.JFrame {
    
    static Connection conn=null;
    /**
     * Creates new form pantallaIngresarLista
     */
    public pantallaIngresarLista() {
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

        INGRESARARTISTA = new javax.swing.JPanel();
        textoTitulo = new javax.swing.JLabel();
        textotNombre = new javax.swing.JLabel();
        textotDescripcion = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        textoDescripcion = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoTitulo.setText("Datos Lista:");

        textotNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textotNombre.setText("Nombre de la Lista:");

        textotDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textotDescripcion.setText("Descripcion:");

        botonAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout INGRESARARTISTALayout = new javax.swing.GroupLayout(INGRESARARTISTA);
        INGRESARARTISTA.setLayout(INGRESARARTISTALayout);
        INGRESARARTISTALayout.setHorizontalGroup(
            INGRESARARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(INGRESARARTISTALayout.createSequentialGroup()
                .addGroup(INGRESARARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(INGRESARARTISTALayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(INGRESARARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textotDescripcion)
                            .addComponent(textotNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(INGRESARARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(INGRESARARTISTALayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(textoTitulo))
                    .addGroup(INGRESARARTISTALayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(botonAceptar)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        INGRESARARTISTALayout.setVerticalGroup(
            INGRESARARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(INGRESARARTISTALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoTitulo)
                .addGap(29, 29, 29)
                .addGroup(INGRESARARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textotNombre)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(INGRESARARTISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textotDescripcion)
                    .addComponent(textoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonAceptar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(INGRESARARTISTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(INGRESARARTISTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // TODO add your handling code here:
        try {
            
            conn = Main.Enlace(conn);
            String sqlinsertar = "insert into lista values (?,?,?)";
            PreparedStatement psta = conn.prepareStatement(sqlinsertar);
            psta.setString(1, null);
            psta.setString(2, textoNombre.getText());
            psta.setString(3, textoDescripcion.getText());           
            psta.execute();
            psta.close();
            
            funcionalidad fLista = new funcionalidad(); 
            fLista.conectar(); 
            ResultSet idUsuario = fLista.consultar("select idusuario from usuario where login='"+pantallaInicio.SesionActual.login+"'");
            idUsuario.next();
            
            
            ResultSet idLista = fLista.consultar("select idlista from lista where nombre='"+textoNombre.getText()+"'");
            idLista.next();
            
            
            String sqlinsertar_sigue = "insert into sigue values (?,?,?,?,?)";
            PreparedStatement insercion = conn.prepareStatement(sqlinsertar_sigue);
            insercion.setString(1, null);
            insercion.setString(2, idUsuario.getString(1));
            insercion.setString(3, null);
            insercion.setString(4, null);
            insercion.setString(5, idLista.getString(1));
            insercion.execute();
            insercion.close();
            
            idUsuario.close();
            idLista.close();
            
            JOptionPane.showMessageDialog(this,"Lista ingresada exitosamente!");
                       
                this.setVisible(false);
                pantallaElegirDiscoCaso7 pElegirDiscoCaso7 = new pantallaElegirDiscoCaso7();
                pElegirDiscoCaso7.setVisible(true);
                pElegirDiscoCaso7.pack();
                dispose();
            
        }catch (SQLException e){
            System.out.println(e.getCause());
            JOptionPane.showMessageDialog(this,"Problemas con la lista");
            
        }
        
    }//GEN-LAST:event_botonAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(pantallaIngresarLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaIngresarLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaIngresarLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaIngresarLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaIngresarLista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel INGRESARARTISTA;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JTextField textoDescripcion;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JLabel textoTitulo;
    private javax.swing.JLabel textotDescripcion;
    private javax.swing.JLabel textotNombre;
    // End of variables declaration//GEN-END:variables
}
