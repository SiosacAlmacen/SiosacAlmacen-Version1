
package Presentacion;


import Negocio.Empleado;
import Negocio.OT;
import Persistencia.EmpleadoDAO;
import Persistencia.OTDAOImp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.*;



public class ControlOT implements ActionListener{
    
     OTDAOImp otDAO=new OTDAOImp();
     OT ot=new OT();
     FrmOT frmot=new FrmOT();
     
       private EmpleadoDAO daoEmp;

     
     

     DefaultTableModel model= new DefaultTableModel();
    
    public ControlOT (FrmOT frmot)     {
        this.frmot = frmot;
        this.frmot.btnleer.addActionListener(this);
        this.frmot.btnactualizar.addActionListener(this);
        this.frmot.btneditar.addActionListener(this);
        this.frmot.btneliminar.addActionListener(this);
        this.frmot.btnregistrar.addActionListener(this);
        this.frmot.btnlimpiar.addActionListener(this);
       
        Read(frmot.tablaot);
        
    } 

    
 
    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == frmot.btnleer)    {
       CleanTable();
       Read(frmot.tablaot);
    }
    if(ae.getSource() == frmot.btnregistrar)   {
        Create();
        CleanTable();
        Read(frmot.tablaot);
    }
    
    if(ae.getSource() == frmot.btneditar)  {
        try {  
            Edit();
        } catch (ParseException ex) {
            Logger.getLogger(ControlOT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if(ae.getSource() == frmot.btnactualizar)  {
        Update();
        Clean();
        CleanTable();
        Read(frmot.tablaot);
    }
    if(ae.getSource() == frmot.btneliminar)    {
       Delete();
       CleanTable();
       Read(frmot.tablaot);
    }
    
    if(ae.getSource() == frmot.btnlimpiar )    {
     Clean();
    }   
    }
    
    

     public void Create()  {
  
    String numero=frmot.txtnumero.getText();
    String empleado=frmot.txtempleado.getText();
   ZoneId defaultZoneId = ZoneId.systemDefault();
   LocalDate fechai = null;
            if (frmot.getjXDatePickerFI().getDate()!= null){
                fechai = new java.sql.Date(frmot.getjXDatePickerFI().getDate().getTime()).toLocalDate();
            }
            Date fechaid = Date.from(fechai.atStartOfDay(defaultZoneId).toInstant());
            
LocalDate fechae = null;
            if (frmot.getjXDatePickerFE().getDate()!= null){
                fechae = new java.sql.Date(frmot.getjXDatePickerFE().getDate().getTime()).toLocalDate();
            }
            Date fechaed = Date.from(fechae.atStartOfDay(defaultZoneId).toInstant());
    String servicio=frmot.txtservicio.getText();
    String dias=frmot.txtdias.getText();
    String descripcion=frmot.getTxtadescripcion().getText();

    
    ot.setNumOT(Integer.parseInt(numero));
    ot.setCodEmpleado(daoEmp.Find(empleado));
    ot.setFechaInicio(fechaid);
    ot.setFechaEntrega(fechaed);
    ot.setServicio(servicio);
    ot.setDias(Integer.parseInt(dias));
    ot.setDescripcion(descripcion);
    
    
    int result=otDAO.Create(ot);
    if (result == 1) {  
        JOptionPane.showMessageDialog(null,"Registro exitoso");
    }else{  
        JOptionPane.showMessageDialog(null,"No se registró");
    }   
        

    }
    
    
    public void Read(JTable jtable)  {
      centrarCeldas(jtable);
        
     model = (DefaultTableModel)jtable.getModel();
     List<OT> lista= otDAO.Read();
     Object[] object= new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            object[0]=lista.get(i).getNumOT();
            object[1]=lista.get(i).getCodEmpleado();
            object[2]=lista.get(i).getFechaInicio();
            object[3]=lista.get(i).getFechaEntrega();
            object[4]=lista.get(i).getServicio();
            object[5]=lista.get(i).getDias();
            object[6]=lista.get(i).getDescripcion();
            
          
            model.addRow(object);
        }
       frmot.tablaot.setModel(model);
    }
    
    public void Update()  {
        if (frmot.txtnumero.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Elija un registro a actualizar");
        }else   {
            
        }
    
    String numero=frmot.txtnumero.getText();
    String empleado=frmot.txtempleado.getText();
   ZoneId defaultZoneId = ZoneId.systemDefault();
   LocalDate fechai = null;
            if (frmot.getjXDatePickerFI().getDate()!= null){
                fechai = new java.sql.Date(frmot.getjXDatePickerFI().getDate().getTime()).toLocalDate();
            }
            Date fechaid = Date.from(fechai.atStartOfDay(defaultZoneId).toInstant());
            
LocalDate fechae = null;
            if (frmot.getjXDatePickerFE().getDate()!= null){
                fechae = new java.sql.Date(frmot.getjXDatePickerFE().getDate().getTime()).toLocalDate();
            }
            Date fechaed = Date.from(fechae.atStartOfDay(defaultZoneId).toInstant());
    String servicio=frmot.txtservicio.getText();
    String dias=frmot.txtdias.getText();
    String descripcion=frmot.getTxtadescripcion().getText();

    
    ot.setNumOT(Integer.parseInt(numero));
    ot.setCodEmpleado(daoEmp.Find(empleado));
    ot.setFechaInicio(fechaid);
    ot.setFechaEntrega(fechaed);
    ot.setServicio(servicio);
    ot.setDias(Integer.parseInt(dias));
    ot.setDescripcion(descripcion);
    
    
    int result=otDAO.Update(ot);
    
    if (result == 1) {  
        JOptionPane.showMessageDialog(null,"Actualizado");
    }else{  
        JOptionPane.showMessageDialog(null,"No se actualizó");
    }
    CleanTable();
    }
    
    public void Delete()  {
    
        int element = frmot.tablaot.getSelectedRow();
        if (element == -1) {
            JOptionPane.showMessageDialog(frmot,"Seleccione el registro a eliminar");
        }else   {
            String codigo=(String)frmot.tablaot.getValueAt(element,0);
            otDAO.Delete(codigo);
            JOptionPane.showMessageDialog(frmot, "Registro eliminado");
        }
    }
    
    
    
    void centrarCeldas(JTable jtable)   {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int i = 0; i < frmot.tablaot.getColumnCount(); i++) {
            frmot.tablaot.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
    
 
    void CleanTable() { 
        for (int i = 0; i < frmot.tablaot.getRowCount(); i++) {
            model.removeRow(i);
            i = i-1;
            
        }
    }
    
    void Edit() throws ParseException{    
        int element= frmot.tablaot.getSelectedRow();
        if (element == -1) {
            JOptionPane.showMessageDialog(null,"Seleccione un registro a editar");
        }else   {
         String elementNUM=(String) frmot.tablaot.getValueAt(element,0);
         String elementEMP=(String) frmot.tablaot.getValueAt(element,1);
         String elementFECI=(String) frmot.tablaot.getValueAt(element,2);
         DateFormat fechaHora = new SimpleDateFormat("yyyy/MM/dd");
         Date fechaid = fechaHora.parse(elementFECI);
         String elementFECE=(String) frmot.tablaot.getValueAt(element,3);
         Date fechaed = fechaHora.parse(elementFECE);
         String elementSERV=(String) frmot.tablaot.getValueAt(element,4);
         String elementDIS=(String) frmot.tablaot.getValueAt(element,5);
         String elementDES=(String) frmot.tablaot.getValueAt(element,6);  
         
         frmot.txtnumero.setText(""+elementNUM);
         frmot.txtempleado.setText(""+elementEMP);
         frmot.getjXDatePickerFI().setDate(fechaid);
         frmot.getjXDatePickerFE().setDate(fechaed);
         frmot.txtservicio.setText(""+elementSERV);
         frmot.txtdias.setText(""+elementDIS);
         frmot.getTxtadescripcion().setText(""+elementDES);
        }
    }
    
    void Clean()    {
     frmot.txtnumero.setText("");
     frmot.txtempleado.setText("");
     frmot.getjXDatePickerFI().setDate(Date.from(Instant.now()));
     frmot.getjXDatePickerFE().setDate(Date.from(Instant.now()));
     frmot.txtservicio.setText("");
     frmot.txtdias.setText("");
     frmot.getTxtadescripcion().setText("");
     frmot.txtnumero.requestFocus();
     
    }
    
    
    
}
