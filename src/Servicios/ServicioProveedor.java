/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Negocio.Proveedor;
import java.util.List;

/**
 *
 * @author ander
 */
public interface ServicioProveedor {
    public String Create(String codigo,String nombre,String nombreEmpresa,String telefono,String correo,String fechaRegistro,String tipoProducto,String direccion);
    public List Read();
    public String Update(String codigo,String nombre,String nombreEmpresa,String telefono,String correo,String fechaRegistro,String tipoProducto,String direccion);
    public Proveedor Find(String codigo);
    public String Delete(String codigo);  
}
