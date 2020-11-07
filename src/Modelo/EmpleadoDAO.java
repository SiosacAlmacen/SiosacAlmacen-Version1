
package Modelo;

import java.util.*;
import java.sql.*;


public class EmpleadoDAO {
 Conexion con = new Conexion();
 Connection cn;
 PreparedStatement pst;
 ResultSet rs;
 int result = 0;
 String quitar=null;
 
  public int Create(Empleado emp) {
     //preparamos la sentencia
     String sql="Insert into empleado (cod_empleado,nombre,apellido,especialidad,user,pass) values(?,?,?,?,?,?)";
     try {
         cn=con.getConexion();
         pst=cn.prepareStatement(sql);
            pst.setString(1,emp.getCodigo());
            pst.setString(2,emp.getNombre());
            pst.setString(3,emp.getApellido());
            pst.setString(4,emp.getEspecialidad());
            pst.setString(5,emp.getUser());
            pst.setString(6,emp.getPass());
            result=pst.executeUpdate();
            if (result ==1) {
             return 1;
            }else   {
             return 0;
            }
             
          } catch (Exception e) {
          }
     return result;
 }
 
 public List Read() {
     List<Empleado> datos=new ArrayList<>();
     //preparamos la sentencia
     String sql="Select * from empleado";
     try {
         cn=con.getConexion();
         pst=cn.prepareStatement(sql);
         rs=pst.executeQuery();
         while (rs.next()) {
            //instanciamos el objeto emp de la clase empleado 
            Empleado emp=new Empleado();
            emp.setCodigo(rs.getString(1));
            emp.setNombre(rs.getString(2));
            emp.setApellido(rs.getString(3));
            emp.setEspecialidad(rs.getString(4));
            emp.setUser(rs.getString(5));
            emp.setPass(rs.getString(6));
            datos.add(emp);
             
         }
     } catch (Exception e) {
     }
     return datos;
 }
 
 
   public int Update(Empleado emp) {
     //preparamos la sentencia
     String sql="update empleado set nombre=?, apellido=?, especialidad=?, user=?, pass=? where cod_empleado=?";
     try {
         cn=con.getConexion();
         pst=cn.prepareStatement(sql);
           
            pst.setString(1,emp.getNombre());
            pst.setString(2,emp.getApellido());
            pst.setString(3,emp.getEspecialidad());
            pst.setString(4,emp.getUser());
            pst.setString(5,emp.getPass());
            pst.setString(6,emp.getCodigo());
            result=pst.executeUpdate();
            if (result ==1) {
             return 1;
            }else   {
             return 0;
            }
             
          } catch (Exception e) {
          }
     return result;
 }
   
      public String Delete(String codigo) {
     //preparamos la sentencia
     String sql="delete from empleado where cod_empleado='"+codigo+"'";
     try {
         cn=con.getConexion();
         pst=cn.prepareStatement(sql);
         quitar=""+pst.executeUpdate();
          if (quitar.equals("1")) {
             return "1";
         }else  {
              return "0";
          }
             
          } catch (Exception e) {
          }
     return quitar;
 }
   
   public Empleado validarEmpleado(String user,String pass) {    
       List lista=Read();
       if (lista!=null) {
           for (int i = 0; i < lista.size(); i++) {
               Empleado emp=(Empleado)lista.get(i);
               if(emp.getUser().equals(user) && emp.getPass().equals(pass)) {
                    return emp;
               }   
           }
       }else    {
           System.out.println("Empleado no encontrado");
       }
       return null;
   }

}
