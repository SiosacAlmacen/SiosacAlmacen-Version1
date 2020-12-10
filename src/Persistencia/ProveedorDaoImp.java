/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Proveedor;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author ander
 */
public class ProveedorDaoImp implements ProveedorDao{

    @Override
    public String Create(Proveedor pro) {
        String sql = "insert into proveedor values('"+pro.getCodigo()+"','"+pro.getNombre()+"','"+pro.getNomEmpresa()+"',"+pro.getTelefono()+",'"+pro.getCorreo()+"','"+pro.getFechaRegistro()+"','"+pro.getTipoProducto()+"','"+pro.getDireccion()+"')";           
        return Operacion.ejecutar(sql);    
    }

    @Override
    public List Read() {
        List lis = new ArrayList();
        String sql = "select * from proveedor";
        List lista = Operacion.listar(sql);
        if(lista!=null){
            /*for (int i = 0; i < lista.size(); i++) {
                Object[]fila = (Object[])lista.get(i);
                Proveedor pro = new Proveedor();
                pro.setCodigo(fila[0].toString());
                pro.setNombre(fila[1].toString());
                pro.setNomEmpresa(fila[2].toString());
                pro.setTelefono((int)fila[3]);
                pro.setCorreo(fila[4].toString());
                pro.setFechaRegistro((Date)fila[5]);
                pro.setTipoProducto(fila[6].toString());
                pro.setDireccion(fila[7].toString());
                lis.add(pro);
            }
            return lis;*/
            return lista;
        }
        return null;
    }

    @Override
    public String Update(Proveedor pro) {
        String sql = "update proveedor set nom_proveedor='"+pro.getNombre()+"',nombre_empresa='"+pro.getNomEmpresa()+"',telefono="+pro.getTelefono()+",correo='"+ pro.getCorreo()+"',fecha_registro='"+pro.getFechaRegistro()+"',tipo_producto='"+pro.getTipoProducto()+"',direccion='"+pro.getDireccion()+"' where cod_proveedor='"+pro.getCodigo()+"'";
        return Operacion.ejecutar(sql);    
    }

    @Override
    public Proveedor Find(String codigo) {
        String sql = "Select * from proveedor where cod_proveedor ='"+codigo+"'";
        Object[]fila = Operacion.buscar(sql);
        if(fila != null){
                Proveedor pro = new Proveedor();
                pro.setCodigo(fila[0].toString());
                pro.setNombre(fila[1].toString());
                pro.setNomEmpresa(fila[2].toString());
                pro.setTelefono((int)fila[3]);
                pro.setCorreo(fila[4].toString());
                pro.setFechaRegistro((Date)fila[5]);
                pro.setTipoProducto(fila[6].toString());
                pro.setDireccion(fila[7].toString());
            return pro;
        }
        return null;
    }

    @Override
    public String Delete(String codigo) {
        String sql = "delete from proveedor where cod_proveedor='"+codigo+"'";
        return Operacion.ejecutar(sql); 
    }
    
    
}
