/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Material;
import java.util.List;

/**
 *
 * @author ander
 */
public interface MaterialDao {
    public String Create(Material mat) ;
    public List Read();
    public String Update(Material mat);
    public Material Find(String codigo);
    public String Delete(String codigo);   
}
