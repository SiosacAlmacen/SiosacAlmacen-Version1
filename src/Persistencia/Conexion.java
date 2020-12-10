
package Persistencia;

import java.sql.*;

public class Conexion {
    static Connection cn=null;
    static String URL="jdbc:mysql://localhost/siosac_bd?useTimezone=true&serverTimezone=UTC";
     static String USUARIO="root";
    static String PASSWORD=" ";
    public static Connection getConexion()  {
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        cn=DriverManager.getConnection(URL,USUARIO,PASSWORD);  
        } catch (Exception e) {
            System.out.println("error de conexion : "+e);
        }
         
       return cn; 
    }
   
}
