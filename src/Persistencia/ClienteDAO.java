
package Persistencia;

import Negocio.*;
import java.util.List;


public interface EmpleadoDAO {

 public int Create(Empleado emp) ;
 public List Read();
 public int Update(Empleado emp);
 public String Delete(String codigo);   
 public Empleado validarEmpleado(String user,String pass);
}
