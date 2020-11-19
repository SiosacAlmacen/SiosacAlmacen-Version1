/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Negocio.Proveedor;
import Persistencia.ProveedorDao;
import Persistencia.ProveedorDaoImp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ander
 */
public class ServicioProveedorImp implements ServicioProveedor{
    
    private ProveedorDao daoPro;

    public ServicioProveedorImp() {
        daoPro = new ProveedorDaoImp();
    }
    
    
    
    @Override
    public String Create(String codigo, String nombre, String nombreEmpresa, String telefono, String correo, String fechaRegistro, String tipoProducto, String direccion) {
        Proveedor pro = new Proveedor();
        try {
            Date fecha =new SimpleDateFormat("dd/MM/yyyy").parse(fechaRegistro);
            pro.setCodigo(codigo);
            pro.setNombre(nombre);
            pro.setNomEmpresa(nombreEmpresa);
            pro.setTelefono(Integer.parseInt(telefono));
            pro.setCorreo(correo);
            pro.setFechaRegistro(fecha);
            pro.setTipoProducto(tipoProducto);
            pro.setDireccion(direccion);
        } catch (ParseException ex) {
            Logger.getLogger(ServicioProveedorImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daoPro.Create(pro);
    }

    @Override
    public List Read() {
        return daoPro.Read();
    }

    @Override
    public String Update(String codigo, String nombre, String nombreEmpresa, String telefono, String correo, String fechaRegistro, String tipoProducto, String direccion) {
        Proveedor pro = new Proveedor();
        try {
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaRegistro);
            pro.setCodigo(codigo);
            pro.setNombre(nombre);
            pro.setNomEmpresa(nombreEmpresa);
            pro.setTelefono(Integer.parseInt(telefono));
            pro.setCorreo(correo);
            pro.setFechaRegistro(fecha);
            pro.setTipoProducto(tipoProducto);
            pro.setDireccion(direccion);
        } catch (ParseException ex) {
            Logger.getLogger(ServicioProveedorImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daoPro.Update(pro);
    }

    @Override
    public Proveedor Find(String codigo) {
        return daoPro.Find(codigo);
    }

    @Override
    public String Delete(String codigo) {
        return daoPro.Delete(codigo);
    }
    
}
