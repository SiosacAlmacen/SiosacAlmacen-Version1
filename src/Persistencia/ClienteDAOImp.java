
package Persistencia;

import Negocio.Cliente;
import Negocio.Empleado;
import Persistencia.Conexion;
import java.util.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.sql.Date;


public class ClienteDAOImp implements ClienteDAO {
 Conexion con = new Conexion();
 Connection cn;
 PreparedStatement pst;
 ResultSet rs;
 int result = 0;
 String quitar=null;

    @Override
    public String Create(Cliente client) {
        String msg="tgfertger";
     String sql="Insert into cliente (cod_cliente,cod_empleado,nombres,telefono,correo,estado,medio,empresa,tipo_doc,observacion,fecha_registro,fecha_contacto,industria,prioridad,provincia) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
     try {
         cn=con.getConexion();
         pst=cn.prepareStatement(sql);
         
     
         DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
         String fechaR = sdf.format(client.getFechaRegistro());
         String fechaC = sdf.format(client.getFechaContacto());
       
            pst.setString(1,client.getCodCliente());
            pst.setString(2,client.getCodEmpleado().getNombre());
            pst.setString(3,client.getNombres());
            pst.setInt(4,client.getTelefono());
            pst.setString(5,client.getCorreo());
            pst.setString(6,client.getEstado());
            pst.setString(7,client.getMedio());
            pst.setString(8,client.getEmpresa());
            pst.setString(9,client.getTipoDoc());
            pst.setString(10,client.getObservacion());
            pst.setDate(11, java.sql.Date.valueOf(fechaR));
            pst.setDate(12, java.sql.Date.valueOf(fechaC));
            pst.setString(13,client.getIndustria());
            pst.setString(14,client.getPrioridad());
             pst.setString(15,client.getProvincia());
            result=pst.executeUpdate();
          } catch (SQLException E) {
              msg = E.getLocalizedMessage();
          }
     return msg;
    }

    @Override
    public List Read() {
          List<Cliente> datos=new ArrayList<>();
     
     String sql = "Select * from cliente ";
     try {
         cn=con.getConexion();
         pst=cn.prepareStatement(sql);
         rs=pst.executeQuery();
         while (rs.next()) {           
            Cliente client=new Cliente();
            client.setCodCliente(rs.getString(1));
            client.setCodEmpleado(new Empleado(rs.getString(2)));
            client.setNombres(rs.getString(3));
            client.setTelefono(rs.getInt(4));
            client.setCorreo(rs.getString(5));
            client.setEstado(rs.getString(6));  
            client.setMedio(rs.getString(7));
            client.setEmpresa(rs.getString(8));
            client.setTipoDoc(rs.getString(9));
            client.setObservacion(rs.getString(10));
            client.setFechaRegistro(rs.getDate(11));
            client.setFechaContacto(rs.getDate(12));
            client.setIndustria(rs.getString(13));
            client.setPrioridad(rs.getString(14));
            client.setProvincia(rs.getString(15));
            datos.add(client);
         }
     } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"error:"+e);
     }
     return datos;
    }

    @Override
    public int Update(Cliente client) {
          
     String sql="update cliente set cod_empleado=?, nombres=?, telefono=?, correo=?, estado=?, medio=?, empresa=?, tipo_doc=?, observacion=?, fecha_registro=?, fecha_contacto=?, industria=?, prioridad=?, provincia=? where cod_cliente=?";
     try {
         cn=con.getConexion();
         pst=cn.prepareStatement(sql);

           
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");       
         String fechaR = sdf.format(client.getFechaRegistro());
         String fechaC = sdf.format(client.getFechaContacto());
         
            pst.setString(1,client.getCodEmpleado().getNombre());
            pst.setString(2,client.getNombres());
            pst.setInt(3,client.getTelefono());
            pst.setString(4,client.getCorreo());
            pst.setString(5,client.getEstado());
            pst.setString(6,client.getMedio());
            pst.setString(7,client.getEmpresa());
            pst.setString(8,client.getTipoDoc());
            pst.setString(9,client.getObservacion());
            pst.setDate(10,java.sql.Date.valueOf(fechaR));
            pst.setDate(11,java.sql.Date.valueOf(fechaC));
            pst.setString(12,client.getIndustria());
            pst.setString(13,client.getPrioridad());
            pst.setString(14,client.getProvincia());
            pst.setString(15,client.getCodCliente());
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
         
     String sql="delete from cliente where cod_cliente='"+codigo+"'";
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
     public Cliente Find(String codigo) {
        String sql = "Select * from cliente where cod_cliente ='"+codigo+"'";
        Object[]fila = Operacion.buscar(sql);
        if(fila != null){
            Cliente client = new Cliente();
                client.setCodCliente(fila[0].toString());
                client.setCodEmpleado((Empleado)fila[1]);
                client.setNombres(fila[2].toString());
                client.setTelefono((int)fila[3]);
                client.setCorreo(fila[4].toString());
                client.setEstado(fila[5].toString());
                 client.setMedio(fila[6].toString());
                client.setEmpresa(fila[7].toString());
                 client.setTipoDoc(fila[8].toString());
                client.setObservacion(fila[9].toString());
                 client.setFechaRegistro((Date)fila[10]);
                client.setFechaContacto((Date)fila[11]);
                 client.setIndustria(fila[12].toString());
                client.setPrioridad(fila[13].toString());
                 client.setProvincia(fila[14].toString());
              
                
            return client;
        }
        return null;
    }
}
