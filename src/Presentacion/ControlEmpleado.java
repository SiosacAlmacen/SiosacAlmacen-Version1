
package Presentacion;

import Persistencia.EmpleadoDAOImp;
import Negocio.Empleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.*;


public class ControlEmpleado implements ActionListener{
    //instanciamos los objetos 
     EmpleadoDAOImp empDAO=new EmpleadoDAOImp();
     Empleado emp=new Empleado();
     FrmEmpleado frmemp=new FrmEmpleado();
    //establecemos el modelo para el table
     DefaultTableModel model= new DefaultTableModel();
     //llamamos a todos los botones de la vista Empleado
    public ControlEmpleado (FrmEmpleado frmemp)     {
        this.frmemp = frmemp;
        this.frmemp.btnleer.addActionListener(this);
        this.frmemp.btnactualizar.addActionListener(this);
        this.frmemp.btneditar.addActionListener(this);
        this.frmemp.btneliminar.addActionListener(this);
        this.frmemp.btnregistrar.addActionListener(this);
        this.frmemp.btnlimpiar.addActionListener(this);
        Read(frmemp.tabla);
    } 
    
    //--CONTROLADOR DE BOTONES--
    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == frmemp.btnleer)    {
       CleanTable();
       Read(frmemp.tabla);
    }
    if(ae.getSource() == frmemp.btnregistrar)   {
        Create();
        CleanTable();
        Read(frmemp.tabla);
    }
    
    if(ae.getSource() == frmemp.btneditar)  {
      Edit();  
    }
    if(ae.getSource() == frmemp.btnactualizar)  {
        Update();
        Clean();
        CleanTable();
        Read(frmemp.tabla);
    }
    if(ae.getSource() == frmemp.btneliminar)    {
       Delete();
       CleanTable();
       Read(frmemp.tabla);
    }
    
    if(ae.getSource() == frmemp.btnlimpiar )    {
     Clean();
    }   
    
    
    
    
    }
    
    
    //METODOS CRUD
     public void Create()  {
    String codigo=frmemp.txtcodigo.getText();
    String nombre=frmemp.txtnombre.getText();
    String apellido=frmemp.txtapellido.getText();
    String especialidad=frmemp.txtespecialidad.getText();
    String user=frmemp.txtuser.getText();
    String pass=frmemp.txtpass.getText();
    
    emp.setCodigo(codigo);
    emp.setNombre(nombre);
    emp.setApellido(apellido);
    emp.setEspecialidad(especialidad);
    emp.setUser(user);
    emp.setPass(pass);
    
    int result=empDAO.Create(emp);
    if (result == 1) {  
        JOptionPane.showMessageDialog(null,"Registro exitoso");
    }else{  
        JOptionPane.showMessageDialog(null,"No se registró");
    }
    }
    
    
    public void Read(JTable jtable)  {
      centrarCeldas(jtable);
        
     model = (DefaultTableModel)jtable.getModel();
     List<Empleado> lista= empDAO.Read();
     Object[] object= new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            object[0]=lista.get(i).getCodigo();
            object[1]=lista.get(i).getNombre();
            object[2]=lista.get(i).getApellido();
            object[3]=lista.get(i).getEspecialidad();
            object[4]=lista.get(i).getUser();
            object[5]=lista.get(i).getPass();
            model.addRow(object);
        }
       frmemp.tabla.setModel(model);
    }
    
    public void Update()  {
        if (frmemp.txtcodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Elija un registro a actualizar");
        }else   {
            
        }
    
    String codigo=frmemp.txtcodigo.getText();
    String nombre=frmemp.txtnombre.getText();
    String apellido=frmemp.txtapellido.getText();
    String especialidad=frmemp.txtespecialidad.getText();
    String user=frmemp.txtuser.getText();
    String pass=frmemp.txtpass.getText();
    
    emp.setCodigo(codigo);
    emp.setNombre(nombre);
    emp.setApellido(apellido);
    emp.setEspecialidad(especialidad);
    emp.setUser(user);
    emp.setPass(pass);
    
    int result=empDAO.Update(emp);
    
    if (result == 1) {  
        JOptionPane.showMessageDialog(null,"Actualizado");
    }else{  
        JOptionPane.showMessageDialog(null,"No se actualizó");
    }
    CleanTable();
    }
    
    public void Delete()  {
    
        int element = frmemp.tabla.getSelectedRow();
        if (element == -1) {
            JOptionPane.showMessageDialog(frmemp,"Seleccione el registro a eliminar");
        }else   {
            String codigo=(String)frmemp.tabla.getValueAt(element,0);
            empDAO.Delete(codigo);
            JOptionPane.showMessageDialog(frmemp, "Registro eliminado");
        }
    }
    
    
    
    
    //METODOS ADICIONALES
    
    void centrarCeldas(JTable jtable)   {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int i = 0; i < frmemp.tabla.getColumnCount(); i++) {
            frmemp.tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
    
    //metodo para limpiar
    void CleanTable() { 
        for (int i = 0; i < frmemp.tabla.getRowCount(); i++) {
            model.removeRow(i);
            i = i-1;
            
        }
    }
    
    void Edit(){    
        int element= frmemp.tabla.getSelectedRow();
        if (element == -1) {
            JOptionPane.showMessageDialog(null,"Seleccione un registro a editar");
        }else   {
         String elementCOD=(String) frmemp.tabla.getValueAt(element,0);
         String elementNOM=(String) frmemp.tabla.getValueAt(element,1);
         String elementAPE=(String) frmemp.tabla.getValueAt(element,2);
         String elementESP=(String) frmemp.tabla.getValueAt(element,3);
         String elementUSER=(String) frmemp.tabla.getValueAt(element,4);
         String elementPASS=(String) frmemp.tabla.getValueAt(element,5);
         frmemp.txtcodigo.setText(""+elementCOD);
         frmemp.txtnombre.setText(""+elementNOM);
         frmemp.txtapellido.setText(""+elementAPE);
         frmemp.txtespecialidad.setText(""+elementESP);
         frmemp.txtuser.setText(""+elementUSER);
         frmemp.txtpass.setText(""+elementPASS);
         
        }
    }
    
    void Clean()    {
     frmemp.txtcodigo.setText("");
     frmemp.txtapellido.setText("");
     frmemp.txtnombre.setText("");
     frmemp.txtespecialidad.setText("");
     frmemp.txtuser.setText("");
     frmemp.txtpass.setText("");
     frmemp.txtcodigo.requestFocus();
     
    }
    
}
