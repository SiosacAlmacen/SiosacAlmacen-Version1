/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Categoria;
import Negocio.Material;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ander
 */
public class MaterialDaoImp implements MaterialDao{

    @Override
    public String Create(Material mat) {
        String sql = "insert into material values('"+mat.getCodigo()+"',"+mat.getCategoria().getCodigo() +",'"+mat.getNombre() +"',"+mat.getStock()+",'"+ mat.getDescripcion()+"','"+mat.getUnidad()+"',"+mat.getMedidaAlto()+","+mat.getMedidaAncho()+")";           
        return Operacion.ejecutar(sql);    
    }

    @Override
    public List Read() {
        List lis = new ArrayList();
        String sql = "select * from material";
        List lista = Operacion.listar(sql);
        if(lista!=null){
            /*for (int i = 0; i < lista.size(); i++) {
                Object[]fila = (Object[])lista.get(i);
                Material mat = new Material();
                mat.setCodigo(fila[0].toString());
                mat.setCategoria((Categoria) fila[1]);
                mat.setNombre(fila[2].toString());
                mat.setStock((int)fila[3]);
                mat.setDescripcion(fila[4].toString());
                mat.setUnidad(fila[5].toString());
                mat.setMedidaAlto((double)fila[6]);
                mat.setMedidaAncho((double)fila[7]);
                
                lis.add(mat);
            }
            return lis;*/
            return lista;
        }
        return null;
    }

    @Override
    public String Update(Material mat) {
        
        String sql = "update material set cod_categoria="+mat.getCategoria().getCodigo()+",nombre_material='"+mat.getNombre() +"',stock="+mat.getStock()+",descripcion='"+ mat.getDescripcion()+"',unidad='"+mat.getUnidad()+"',medidaAlto="+mat.getMedidaAlto()+",medidaAncho="+mat.getMedidaAncho()+" where cod_categoria='"+mat.getCodigo()+"'";
        return Operacion.ejecutar(sql);
        
    }

    @Override
    public Material Find(String codigo) {
        String sql = "Select * from material where cod_material ='"+codigo+"'";
        Object[]fila = Operacion.buscar(sql);
        if(fila != null){
            Material mat = new Material();
                mat.setCodigo(fila[0].toString());
                mat.setCategoria((Categoria)fila[1]);
                mat.setNombre(fila[2].toString());
                mat.setStock((int)fila[3]);
                mat.setDescripcion(fila[4].toString());
                mat.setUnidad(fila[5].toString());
                mat.setMedidaAlto((double)fila[6]);
                mat.setMedidaAncho((double)fila[7]);
            return mat;
        }
        return null;
    }

    @Override
    public String Delete(String codigo) {
        String sql = "delete from material where cod_material='"+codigo+"'";
        return Operacion.ejecutar(sql);    
    }
    
}
