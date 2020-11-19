/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Categoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ander
 */
public class CategoriaDaoImp implements CategoriaDao{

    @Override
    public String Create(Categoria cat) {
        String sql = "Insert into categoria values("+cat.getCodigo()+",'"+cat.getNombre()+"')";
        return Operacion.ejecutar(sql);   
    }

    @Override
    public List Read() {
        List lis = new ArrayList();
        String sql = "select * from categoria";
        List lista = Operacion.listar(sql);
        if(lista!=null){
            /*for (int i = 0; i < lista.size(); i++) {
                Object[]fila = (Object[])lista.get(i);
                Categoria cat = new Categoria();
                cat.setCodigo((int)fila[0]);
                cat.setNombre(fila[1].toString());
                lis.add(cat);
            }
            return lis;*/
            return lista;
        }
        return null;
    }

    @Override
    public String Update(Categoria cat) {
        String sql = "update categoria set nombre_categoria='"+cat.getNombre()+"' where cod_categoria="+cat.getCodigo()+"";
        return Operacion.ejecutar(sql);
    }

    @Override
    public Categoria Find(int codigo) {
        String sql = "Select * from categoria where cod_categoria ="+codigo;
        Object[]fila = Operacion.buscar(sql);
        if(fila != null){
            Categoria cat = new Categoria();
            cat.setCodigo((int)fila[0]);
            cat.setNombre(fila[1].toString());
            return cat;
        }
        return null;
    }

    @Override
    public String Delete(int codigo) {
        String sql = "delete from categoria where cod_categoria="+codigo;
        return Operacion.ejecutar(sql);
    }
    
}
