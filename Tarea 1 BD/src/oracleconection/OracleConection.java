/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oracleconection;

//referencias de conexion
import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConection {
    //Variable de conexion
private Connection conexion;

    //metodos para capturar y mostrar los resultados
    public Connection getConexion(){
    return conexion;
    }
    
    public void setConexion(Connection conexion) {
    this.conexion = conexion;
    }
    //metodo para conectar con oracle 11g
    public OracleConection Conectar(){
    
    try{    
    Class.forName("oracle.jdbc.OracleDriver");
    String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
    conexion = DriverManager.getConnection(BaseDeDatos,"JPCVBD","juanpablo");
    if(conexion != null){
        System.out.println("Conexion exitosa a esquema JPCVBD");
                        }
    else{
    System.out.println("Conexion fallida");
        }
        }
    catch(Exception e)
    {e.printStackTrace();}
    
    return this;
                                     }
    
    public static void main(String[] args) {
        // creando objeto de conexion, que ejecuta el metodo de conectar con la BD
        OracleConection obconeccion = new OracleConection();
    obconeccion.Conectar();
    }

    
}

