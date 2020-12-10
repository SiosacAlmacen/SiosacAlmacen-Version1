
package Persistencia;

import Negocio.OT;
import Negocio.Empleado;
import Persistencia.Conexion;
import java.util.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;


public class OTDAOImp implements OTDAO {
 Conexion con = new Conexion();
 Connection cn;
 PreparedStatement pst;
 ResultSet rs;
 int result = 0;
 String quitar=null;
    @Override
    public int Create(OT ot) {
       
     String sql="Insert into cliente (num_ot,cod_empleado,fecha_inicio,fecha_entrega,servicio,dias,descripcion) values(?,?,?,?,?,?,?)";
     try {
         cn=con.getConexion();
         pst=cn.prepareStatement(sql);
         
      
         DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
         String fechai = sdf.format(ot.getFechaInicio());
         String fechae = sdf.format(ot.getFechaEntrega());
       
            pst.setInt(1,ot.getNumOT());
            pst.setString(2,ot.getCodEmpleado().getNombre());
            pst.setDate(3, java.sql.Date.valueOf(fechai));
            pst.setDate(4, java.sql.Date.valueOf(fechae));
            pst.setString(5,ot.getServicio());
            pst.setInt(6,ot.getDias());
             pst.setString(7,ot.getDescripcion());
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

    @Override
    public List Read() {
          List<OT> datos=new ArrayList<>();
     
     String sql = "Select * from ot t "
                + "join empleado emp "
                + "on t.cod_empleado = emp.cod_empleado ORDER BY t.cod_empleado";
     try {
         cn=con.getConexion();
         pst=cn.prepareStatement(sql);
         rs=pst.executeQuery();
         while (rs.next()) {
           
            OT ot=new OT();
            ot.setNumOT(rs.getInt(1));
            ot.setCodEmpleado(new Empleado(rs.getString("emp.cod_empleado"), rs.getString("emp.nombre"), rs.getString("emp.apellido"), rs.getString("emp.especialidad"), rs.getString("emp.usuario"), rs.getString("emp.contraseña")));
            ot.setFechaInicio(rs.getDate(3));
            ot.setFechaEntrega(rs.getDate(4));
            ot.setServicio(rs.getString(5));
            ot.setDias(rs.getInt(6));
            ot.setDescripcion(rs.getString(7));
            datos.add(ot);
             
         }
     } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"error:"+e);
     }
     return datos; 
    }

    @Override
    public int Update(OT ot) {
          
     String sql="update ot set cod_empleado=?, fecha_inicio=?, fecha_entrega=?, servicio=?, dias=?, descripcion=? where num_ot=?";
     try {
         cn=con.getConexion();
         pst=cn.prepareStatement(sql);
           
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");       
         String fechaI = sdf.format(ot.getFechaInicio());
         String fechaE = sdf.format(ot.getFechaEntrega());
         
            pst.setString(1,ot.getCodEmpleado().getNombre());
            pst.setDate(2,java.sql.Date.valueOf(fechaI));
            pst.setDate(3,java.sql.Date.valueOf(fechaE));
            pst.setString(4,ot.getServicio());
            pst.setInt(5,ot.getDias());
            pst.setString(6,ot.getDescripcion());
            pst.setInt(7,ot.getNumOT());
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

    @Override
    public String Delete(String codigo) {
         
     String sql="delete from ot where num_ot='"+codigo+"'";
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

    @Override
     public OT Find(String codigo) {
        String sql = "Select * from ot where num_ot ='"+codigo+"'";
        Object[]fila = Operacion.buscar(sql);
        if(fila != null){
            OT ot = new OT();
                ot.setNumOT((int)fila[0]);
                ot.setCodEmpleado((Empleado)fila[1]);
                 ot.setFechaInicio((Date)fila[2]);
                ot.setFechaEntrega((Date)fila[3]);
                 ot.setServicio(fila[4].toString());
                ot.setDias((int)fila[5]);
                 ot.setDescripcion(fila[6].toString());
              
                
            return ot;
        }
        return null;
    }



}
