
package Negocio;

import java.util.Date;


public class OT {
   private String numOT;
   private Empleado codEmpleado;
   private Date fechaInicio;
   private Date fechaEntrega;
   private String servicio;
   private int dias;
   private String descripcion;
 

    public OT() {
    }

    public OT(String numOT, Empleado codEmpleado, Date fechaInicio, Date fechaEntrega, String servicio, int dias, String descripcion) {
        this.numOT = numOT;
        this.codEmpleado = codEmpleado;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.servicio = servicio;
        this.dias = dias;
        this.descripcion = descripcion;
    }

    public String getNumOT() {
        return numOT;
    }

    public void setNumOT(String numOT) {
        this.numOT = numOT;
    }

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
