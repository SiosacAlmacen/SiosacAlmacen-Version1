/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Negocio.Categoria;
import java.util.List;

/**
 *
 * @author ander
 */
public interface ServicioCategoria {
    
    public String Create(String codigo,String nombre) ;
    public List Read();
    public String Update(String codigo,String nombre);
    public Categoria Find(String codigo);
    public String Delete(String codigo);   
    
}
