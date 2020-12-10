
package Servicios;

import Negocio.OT;
import java.util.List;


public interface ServicioOT {
    
    public String Create(String numOT, String codEmpleado, String fechaInicio, String fechaEntrega, String servicio, String dias, String descripcion);
    public List Read();
    public String Update(String numOT, String codEmpleado, String fechaInicio, String fechaEntrega, String servicio, String dias, String descripcion);
    public OT Find(String numOT);
    public String Delete(String numOT);   
    
}
