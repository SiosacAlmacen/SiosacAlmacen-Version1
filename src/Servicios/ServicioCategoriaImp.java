/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Negocio.Categoria;
import Persistencia.CategoriaDao;
import Persistencia.CategoriaDaoImp;
import java.util.List;

/**
 *
 * @author ander
 */
public class ServicioCategoriaImp implements ServicioCategoria{
    
    private CategoriaDao daoCat;

    public ServicioCategoriaImp() {
        daoCat = new CategoriaDaoImp();
    }
    
    

    @Override
    public String Create(String codigo, String nombre) {
        Categoria cat = new Categoria(Integer.parseInt(codigo), nombre);
        return daoCat.Create(cat);
    }

    @Override
    public List Read() {
        return daoCat.Read();
    }

    @Override
    public String Update(String codigo, String nombre) {
        Categoria cat = new Categoria(Integer.parseInt(codigo), nombre);
        return daoCat.Update(cat);
    }

    @Override
    public Categoria Find(String codigo) {
        return daoCat.Find(Integer.parseInt(codigo));
    }
    

    @Override
    public String Delete(String codigo) {
        return daoCat.Delete(Integer.parseInt(codigo));
    }
    
}
