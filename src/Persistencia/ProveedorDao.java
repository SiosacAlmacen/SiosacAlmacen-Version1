/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Proveedor;
import java.util.List;

/**
 *
 * @author ander
 */
public interface ProveedorDao {
    public String Create(Proveedor pro) ;
    public List Read();
    public String Update(Proveedor pro);
    public Proveedor Find(String codigo);
    public String Delete(String codigo);   
}
