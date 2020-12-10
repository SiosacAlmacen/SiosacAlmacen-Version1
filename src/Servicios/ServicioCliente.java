
package Servicios;

import Negocio.Cliente;
import Negocio.Empleado;
import java.util.Date;
import java.util.List;


public interface ServicioCliente {
    
    public String Create(String codCliente, String codEmpleado, String nombres, String telefono, String correo, String estado, String medio, String empresa, String tipoDoc, String observacion, String fechaRegistro, String fechaContacto, String industria, String prioridad, String provincia);
    public List Read();
    public String Update(String codCliente, String codEmpleado, String nombres, String telefono, String correo, String estado, String medio, String empresa, String tipoDoc, String observacion, String fechaRegistro, String fechaContacto, String industria, String prioridad, String provincia);
    public Cliente Find(String codCliente);
    public String Delete(String codCliente);   
    
}
