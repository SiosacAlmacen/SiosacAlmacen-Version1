/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Negocio.Material;
import Persistencia.MaterialDao;
import Persistencia.MaterialDaoImp;
import java.util.List;

/**
 *
 * @author ander
 */
public class ServicioMaterialImp implements ServicioMaterial{
    
    private MaterialDao daoMat;
    private ServicioCategoria serCat;

    public ServicioMaterialImp() {
        serCat = new ServicioCategoriaImp();
        daoMat = new MaterialDaoImp();
    }

    
    
    @Override
    public String Create(String codigo, String codCat, String nombre, String stock, String descripcion, String unidad, String medAlto, String medAncho) {
        Material mat = new Material();
        mat.setCodigo(codigo);
        mat.setCategoria(serCat.Find(codCat));
        mat.setNombre(nombre);
        mat.setStock(Integer.parseInt(stock));
        mat.setDescripcion(descripcion);
        mat.setUnidad(unidad);
        mat.setMedidaAlto(Double.parseDouble(medAlto));
        mat.setMedidaAncho(Double.parseDouble(medAncho));
        return daoMat.Create(mat);
    }

    @Override
    public List Read() {
        return daoMat.Read();
    }

    @Override
    public String Update(String codigo, String codCat, String nombre, String stock, String descripcion, String unidad, String medAlto, String medAncho) {
        Material mat = new Material();
        mat.setCodigo(codigo);
        mat.setCategoria(serCat.Find(codCat));
        mat.setNombre(nombre);
        mat.setStock(Integer.parseInt(stock));
        mat.setDescripcion(descripcion);
        mat.setUnidad(unidad);
        mat.setMedidaAlto(Double.parseDouble(medAlto));
        mat.setMedidaAncho(Double.parseDouble(medAncho));
        return daoMat.Update(mat);
    }

    @Override
    public Material Find(String codigo) {
        return daoMat.Find(codigo);
    }

    @Override
    public String Delete(String codigo) {
        return daoMat.Delete(codigo);
    }
    
}
