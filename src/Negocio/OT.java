
package Negocio;


public class Empleado {
   private String codigo;
   private String nombre;
   private String apellido;
   private String especialidad;
   private String user;
   private String pass;

    public Empleado() {
    }

    public Empleado(String codigo, String nombre, String apellido, String especialidad, String user, String pass) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.user = user;
        this.pass = pass;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



}
