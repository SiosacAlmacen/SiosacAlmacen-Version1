
package Presentacion;

import Negocio.Empleado;
import Persistencia.EmpleadoDAOImp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlAcceso implements ActionListener {
     //instanciamos los objetos 
     EmpleadoDAOImp empDAO=new EmpleadoDAOImp();
     Empleado emp=new Empleado();
     FrmLogin frmlog=new FrmLogin();
     FrmEmpleado frmemp=new FrmEmpleado();
     FrmMenu frmmenu=new FrmMenu();
     
     public ControlAcceso (FrmLogin frmlog)    {
         this.frmlog=frmlog;
         this.frmlog.btningresar.addActionListener(this);
     }
     
    //CONTROLADOR DE BOTON 
    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource() == frmlog.btningresar){ 
          ValidarAcceso();
      }

    }
    
    
    //Metodo de acceso
    
    public void ValidarAcceso()   {
      String user=this.frmlog.txtuserlog.getText();
      String pass=this.frmlog.txtpasslog.getText();
      //seteamos
      emp.setUser(user);
      emp.setPass(pass);
      Empleado emp=empDAO.validarEmpleado(user, pass);
      if(emp!=null) {
          this.frmmenu.lblcod.setText(""+emp.getCodigo());
          this.frmmenu.lblnon.setText(""+emp.getNombre());
          frmmenu.setVisible(true);
          frmlog.dispose();
      }else {
          System.out.println("acceso denegado");
      }
    }

}
