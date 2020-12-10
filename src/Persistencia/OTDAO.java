
package Persistencia;

import Negocio.*;
import java.util.List;


public interface OTDAO {

 public int Create(OT ot) ;
 public List Read();
 public int Update(OT ot);
 public String Delete(String codigo);
 public OT Find(String codigo);
}
