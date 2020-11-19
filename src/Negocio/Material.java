/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author ander
 */
public class Material {
 
    private String codigo;
    private Categoria categoria;
    private String nombre;
    private int stock;
    private String descripcion;
    private String unidad;
    private double medidaAlto;
    private double medidaAncho;

    public Material() {
    }

    public Material(String codigo, Categoria categoria, String nombre, int stock, String descripcion, String unidad, double medidaAlto, double medidaAncho) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.nombre = nombre;
        this.stock = stock;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.medidaAlto = medidaAlto;
        this.medidaAncho = medidaAncho;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getMedidaAlto() {
        return medidaAlto;
    }

    public void setMedidaAlto(double medidaAlto) {
        this.medidaAlto = medidaAlto;
    }

    public double getMedidaAncho() {
        return medidaAncho;
    }

    public void setMedidaAncho(double medidaAncho) {
        this.medidaAncho = medidaAncho;
    }
    
    
}
