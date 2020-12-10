
package Persistencia;

import Negocio.*;
import java.util.List;


public interface ClienteDAO {

 public int Create(Cliente client) ;
 public List Read();
 public int Update(Cliente client);
 public String Delete(String codigo);
 public Cliente Find(String codigo);
}
