
package Servicios;

import Negocio.Cliente;
import Negocio.Empleado;
import Persistencia.ClienteDAO;
import Persistencia.ClienteDAOImp;
import Persistencia.EmpleadoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServicioClienteImp implements ServicioCliente{
    
    private ClienteDAO daoClient;
    private ServicioEmpleado serEmp;
    
   

    public ServicioClienteImp() {
        daoClient = new ClienteDAOImp();
        serEmp = new ServicioEmpleadoImp();
    }
    
    
    
    @Override
    public String Create(String codCliente, String codEmpleado, String nombres, String telefono, String correo, String estado, String medio, String empresa, String tipoDoc, String observacion, String fechaRegistro, String fechaContacto, String industria, String prioridad, String provincia) {
        Cliente client = new Cliente();
        try {
            Date fechar =new SimpleDateFormat("dd/MM/yyyy").parse(fechaRegistro);
            Date fechac =new SimpleDateFormat("dd/MM/yyyy").parse(fechaContacto);
     
    client.setCodCliente(codCliente);
    client.setCodEmpleado(serEmp.Find(codEmpleado));
    client.setTelefono(Integer.parseInt(telefono));
    client.setCorreo(correo);
    client.setEstado(estado);
    client.setMedio(medio);
    client.setEmpresa(empresa);
    client.setTipoDoc(tipoDoc);
    client.setProvincia(provincia);
    client.setFechaRegistro(fechar);
    client.setFechaContacto(fechac);
    client.setIndustria(industria);
    client.setPrioridad(prioridad);
    client.setObservacion(observacion);
      } catch (ParseException ex) {
            Logger.getLogger(ServicioProveedorImp.class.getName()).log(Level.SEVERE, null, ex);
        }
     return daoClient.Create(client);
    }

    @Override
    public List Read() {
        return daoClient.Read();
    }

    @Override
    public String Update(String codCliente, String codEmpleado, String nombres, String telefono, String correo, String estado, String medio, String empresa, String tipoDoc, String observacion, String fechaRegistro, String fechaContacto, String industria, String prioridad, String provincia) {
            Cliente client = new Cliente();
        try {
            Date fechar =new SimpleDateFormat("dd/MM/yyyy").parse(fechaRegistro);
            Date fechac =new SimpleDateFormat("dd/MM/yyyy").parse(fechaContacto);
     
    client.setCodCliente(codCliente);
    client.setCodEmpleado(serEmp.Find(codEmpleado));
    client.setTelefono(Integer.parseInt(telefono));
    client.setCorreo(correo);
    client.setEstado(estado);
    client.setMedio(medio);
    client.setEmpresa(empresa);
    client.setTipoDoc(tipoDoc);
    client.setProvincia(provincia);
    client.setFechaRegistro(fechar);
    client.setFechaContacto(fechac);
    client.setIndustria(industria);
    client.setPrioridad(prioridad);
    client.setObservacion(observacion);
      } catch (ParseException ex) {
            Logger.getLogger(ServicioProveedorImp.class.getName()).log(Level.SEVERE, null, ex);
        }
     return daoClient.Create(client);
    }

    @Override
    public Cliente Find(String codCliente) {
        return daoClient.Find(codCliente);
    }

    @Override
    public String Delete(String codCliente) {
        return daoClient.Delete(codCliente);
    }
    
}
