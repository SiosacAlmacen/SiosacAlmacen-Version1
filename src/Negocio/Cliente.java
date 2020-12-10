
package Negocio;

import java.util.Date;


public class Cliente {
   private String codCliente;
   private Empleado codEmpleado;
   private String nombres;
   private int telefono;
   private String correo;
   private String estado;
   private String medio;
   private String empresa;
   private String tipoDoc;
   private String observacion;
   private Date fechaRegistro;
   private Date fechaContacto;
   private String industria;
   private String prioridad;
   private String provincia;

    public Cliente() {
    }

    public Cliente(String codCliente, Empleado codEmpleado, String nombres, int telefono, String correo, String estado, String medio, String empresa, String tipoDoc, String observacion, Date fechaRegistro, Date fechaContacto, String industria, String prioridad, String provincia) {
        this.codCliente = codCliente;
        this.codEmpleado = codEmpleado;
        this.nombres = nombres;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
        this.medio = medio;
        this.empresa = empresa;
        this.tipoDoc = tipoDoc;
        this.observacion = observacion;
        this.fechaRegistro = fechaRegistro;
        this.fechaContacto = fechaContacto;
        this.industria = industria;
        this.prioridad = prioridad;
        this.provincia = provincia;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaContacto() {
        return fechaContacto;
    }

    public void setFechaContacto(Date fechaContacto) {
        this.fechaContacto = fechaContacto;
    }

    public String getIndustria() {
        return industria;
    }

    public void setIndustria(String industria) {
        this.industria = industria;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
   
   

  
   
    
}
