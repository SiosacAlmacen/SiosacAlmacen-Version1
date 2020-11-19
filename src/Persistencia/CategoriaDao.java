/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Categoria;
import java.util.List;

/**
 *
 * @author ander
 */
public interface CategoriaDao {
    public String Create(Categoria cat) ;
    public List Read();
    public String Update(Categoria cat);
    public Categoria Find(int codigo);
    public String Delete(int codigo);   
}
