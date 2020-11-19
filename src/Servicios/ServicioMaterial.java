/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Negocio.Material;
import java.util.List;

/**
 *
 * @author ander
 */
public interface ServicioMaterial  {
    
    public String Create(String codigo,String codCat,String nombre,String stock,String descripcion,String unidad,String medAlto,String meAncho);
    public List Read();
    public String Update(String codigo,String codCat,String nombre,String stock,String descripcion,String unidad,String medAlto,String meAncho);
    public Material Find(String codigo);
    public String Delete(String codigo);  
    
}
