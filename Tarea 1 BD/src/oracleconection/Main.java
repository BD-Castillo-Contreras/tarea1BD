/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oracleconection;

import java.sql.*;

public class Main {

    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;
    
 
    
    static String bd="XE";
    static String login="TAREA1BD";
    static String password="marti";
    static String url="jdbc:oracle:thin:@localhost:1521:XE";
    
    public static Connection Enlace(Connection conn)throws SQLException    {
        try {
         Class.forName("oracle.jdbc.OracleDriver");
         conn=DriverManager.getConnection(url, login, password);
        }
        catch(ClassNotFoundException e )
        {
            System.out.print("Clase no encontrada");
        }
        return conn;
    }
    
    public static Statement sta(Statement st)throws SQLException    {
        conn=Enlace(conn);
        st=conn.createStatement();
        return st;
    }
    public static ResultSet EnlEst(ResultSet rs)throws SQLException    {
       st=sta(st);
       rs=st.executeQuery("select * from usuario");
        return rs;
    }

}
