
package Servicios;

import Negocio.OT;
import Negocio.Empleado;
import Persistencia.OTDAOImp;
import Persistencia.OTDAO;
import Persistencia.EmpleadoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServicioOTImp implements ServicioOT{
    
    private OTDAO daoot;
    private ServicioEmpleado serEmp;
    
   

    public ServicioOTImp() {
        daoot = new OTDAOImp();
        serEmp = new ServicioEmpleadoImp();
    }
    
    
    
    @Override
    public String Create(String numOT, String codEmpleado, String fechaInicio, String fechaEntrega, String servicio, String dias, String descripcion) {
        OT ot = new OT();
        try {
            Date fechai =new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio);
            Date fechae =new SimpleDateFormat("dd/MM/yyyy").parse(fechaEntrega);
     
    ot.setNumOT(Integer.parseInt(numOT));
    ot.setCodEmpleado(serEmp.Find(codEmpleado));
    ot.setFechaInicio(fechai);
    ot.setFechaEntrega(fechae);
    ot.setServicio(servicio);
   ot.setDias(Integer.parseInt(dias));
    ot.setDescripcion(descripcion);
      } catch (ParseException ex) {
            Logger.getLogger(ServicioProveedorImp.class.getName()).log(Level.SEVERE, null, ex);
        }
     return daoot.Create(ot);
    }

    @Override
    public List Read() {
        return daoot.Read();
    }

    @Override
    public String Update(String numOT, String codEmpleado, String fechaInicio, String fechaEntrega, String servicio, String dias, String descripcion) {
            OT ot = new OT();
          try {
            Date fechai =new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio);
            Date fechae =new SimpleDateFormat("dd/MM/yyyy").parse(fechaEntrega);
     
    ot.setNumOT(Integer.parseInt(numOT));
    ot.setCodEmpleado(serEmp.Find(codEmpleado));
    ot.setFechaInicio(fechai);
    ot.setFechaEntrega(fechae);
    ot.setServicio(servicio);
   ot.setDias(Integer.parseInt(dias));
    ot.setDescripcion(descripcion);
      } catch (ParseException ex) {
            Logger.getLogger(ServicioProveedorImp.class.getName()).log(Level.SEVERE, null, ex);
        }
     return daoot.Create(ot);
    }

    @Override
    public OT Find(String numOT) {
        return daoot.Find(numOT);
    }

    @Override
    public String Delete(String numOT) {
        return daoot.Delete(numOT);
    }
    
}
