package Presentacion;

import Persistencia.ClienteDAOImp;
import Negocio.Cliente;
import Negocio.Empleado;
import Persistencia.EmpleadoDAO;
import Persistencia.EmpleadoDAOImp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.*;


public class ControlCliente implements ActionListener{
     
     ClienteDAOImp clientDAO=new ClienteDAOImp();
     EmpleadoDAO daoEmp = new EmpleadoDAOImp();
     
     Cliente client=new Cliente();
     Empleado emp = new Empleado();
     
     FrmCliente frmclient=new FrmCliente();
     




     DefaultTableModel model= new DefaultTableModel();

    public ControlCliente (FrmCliente frmclient)     {
        this.frmclient = frmclient;
        this.frmclient.btnleer.addActionListener(this);
        this.frmclient.btnactualizar.addActionListener(this);
        this.frmclient.btneditar.addActionListener(this);
        this.frmclient.btneliminar.addActionListener(this);
        this.frmclient.btnregistrar.addActionListener(this);
        this.frmclient.btnlimpiar.addActionListener(this);

        Read(frmclient.tablacliente);
        Empleados();
    }



    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == frmclient.btnleer)    {
       CleanTable();
       Read(frmclient.tablacliente);
    }
    if(ae.getSource() == frmclient.btnregistrar)   {
        Create();
        CleanTable();
        Read(frmclient.tablacliente);
    }

    if(ae.getSource() == frmclient.btneditar)  {
        try {
            Edit();
        } catch (ParseException ex) {
            Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if(ae.getSource() == frmclient.btnactualizar)  {
        Update();
        Clean();
        CleanTable();
        Read(frmclient.tablacliente);
    }
    if(ae.getSource() == frmclient.btneliminar)    {
       Delete();
       CleanTable();
       Read(frmclient.tablacliente);
    }

    if(ae.getSource() == frmclient.btnlimpiar )    {
     Clean();
    }
    }



     public void Create()  {

        String codigo=frmclient.txtcodigo.getText();
        String nombres=frmclient.txtnombres.getText();
        String empleado=String.valueOf(frmclient.getcomboemp().getSelectedItem()); 
        String telefono=String.valueOf(frmclient.txttelefono.getText());
        String correo= String.valueOf(frmclient.txtcorreo.getText());
        String estado=String.valueOf(frmclient.txtestado.getText());
        String medio=String.valueOf(frmclient.txtmedio.getText());
        String empresa=String.valueOf(frmclient.txtempresa.getText());
        String tipod=String.valueOf(frmclient.txttipod.getText());
        String provincia=String.valueOf(frmclient.txtprovincia.getText());
        
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate fechar = null;
        if (frmclient.getjXDatePickerFR().getDate()!= null){
            fechar = new java.sql.Date(frmclient.getjXDatePickerFR().getDate().getTime()).toLocalDate();
        }
        Date fechard = (Date) Date.from(fechar.atStartOfDay(defaultZoneId).toInstant());

        LocalDate fechac = null;
        if (frmclient.getjXDatePickerFC().getDate()!= null){
            fechac = new java.sql.Date(frmclient.getjXDatePickerFC().getDate().getTime()).toLocalDate();
        }
        Date fechacd = (Date) Date.from(fechac.atStartOfDay(defaultZoneId).toInstant());
        
        String industria=String.valueOf(frmclient.txtindustria.getText());
        String prioridad=String.valueOf(frmclient.txtprioridad.getText());
        String observacion=String.valueOf(frmclient.getjTextArea().getText());


        client.setCodCliente(codigo);
        client.setCodEmpleado(daoEmp.Find(empleado));
        client.setTelefono(Integer.parseInt(telefono));
        client.setCorreo(correo);
        client.setEstado(estado);
        client.setMedio(medio);
        client.setEmpresa(empresa);
        client.setTipoDoc(tipod);
        client.setProvincia(provincia);
        client.setFechaRegistro(fechard);
        client.setFechaContacto(fechacd);
        client.setIndustria(industria);
        client.setPrioridad(prioridad);
        client.setObservacion(observacion);

        
         System.out.println(clientDAO.Create(client));
    }


    public void Read(JTable jtable)  {
      centrarCeldas(jtable);

     model = (DefaultTableModel)jtable.getModel();
     List<Cliente> lista= clientDAO.Read();
     Object[] object= new Object[15];
        for (int i = 0; i < lista.size(); i++) {
            object[0]=lista.get(i).getCodCliente();
            object[1]=lista.get(i).getNombres();
            object[2]=lista.get(i).getCodEmpleado();
            object[3]=lista.get(i).getTelefono();
            object[4]=lista.get(i).getCorreo();
            object[5]=lista.get(i).getEstado();
            object[6]=lista.get(i).getMedio();
            object[7]=lista.get(i).getEmpresa();
            object[8]=lista.get(i).getTipoDoc();
            object[9]=lista.get(i).getObservacion();
            object[10]=lista.get(i).getFechaRegistro();
            object[11]=lista.get(i).getFechaContacto();
            object[12]=lista.get(i).getIndustria();
            object[13]=lista.get(i).getPrioridad();
            object[14]=lista.get(i).getProvincia();

            model.addRow(object);
        }
       frmclient.tablacliente.setModel(model);
    }
    
    public void Empleados(){
        frmclient.getcomboemp().removeAllItems();
        List<Empleado> lista= daoEmp.Read();
        for (int i = 0; i < daoEmp.Read().size(); i++){
            String cod = lista.get(i).getCodigo();
            String nom = lista.get(i).getNombre();
            frmclient.getcomboemp().addItem(new Empleado(cod, nom));
        }
    }
    
    public String Id(){
        Empleado emp = (Empleado)frmclient.getcomboemp().getSelectedItem();
        String id = String.valueOf(emp.getCodigo());
        return id;
    }
    
    public void Update()  {
        if (frmclient.txtcodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Elija un registro a actualizar");
        }else   {

        }

        String codigo=frmclient.txtcodigo.getText();
        String nombres=frmclient.txtnombres.getText();
        String empleado=String.valueOf(frmclient.getcomboemp().getSelectedItem()); 
        String telefono=frmclient.txttelefono.getText();
        String correo=frmclient.txtcorreo.getText();
        String estado=frmclient.txtestado.getText();
        String medio=frmclient.txtmedio.getText();
        String empresa=frmclient.txtempresa.getText();
        String tipod=frmclient.txttipod.getText();
        String provincia=frmclient.txtprovincia.getText();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate fechar = null;
        if (frmclient.getjXDatePickerFR().getDate()!= null){
            fechar = new java.sql.Date(frmclient.getjXDatePickerFR().getDate().getTime()).toLocalDate();
        }
        Date fechard = (Date) Date.from(fechar.atStartOfDay(defaultZoneId).toInstant());

        LocalDate fechac = null;
        if (frmclient.getjXDatePickerFC().getDate()!= null){
            fechac = new java.sql.Date(frmclient.getjXDatePickerFC().getDate().getTime()).toLocalDate();
        }
        Date fechacd = (Date) Date.from(fechac.atStartOfDay(defaultZoneId).toInstant());   
        String industria=frmclient.txtindustria.getText();
        String prioridad=frmclient.txtprioridad.getText();
        String observacion=frmclient.getjTextArea().getText();


        client.setCodCliente(codigo);
        client.setCodEmpleado(daoEmp.Find(empleado));
        client.setTelefono(Integer.parseInt(telefono));
        client.setCorreo(correo);
        client.setEstado(estado);
        client.setMedio(medio);
        client.setEmpresa(empresa);
        client.setTipoDoc(tipod);
        client.setProvincia(provincia);
        client.setFechaRegistro(fechard);
        client.setFechaContacto(fechacd);
        client.setIndustria(industria);
        client.setPrioridad(prioridad);
        client.setObservacion(observacion); 


        int result=clientDAO.Update(client);

        if (result == 1) {
            JOptionPane.showMessageDialog(null,"Actualizado");
        }else{
            JOptionPane.showMessageDialog(null,"No se actualizó");
        }
        CleanTable();
    }

    public void Delete()  {

        int element = frmclient.tablacliente.getSelectedRow();
        if (element == -1) {
            JOptionPane.showMessageDialog(frmclient,"Seleccione el registro a eliminar");
        }else   {
            String codigo=(String)frmclient.tablacliente.getValueAt(element,0);
            clientDAO.Delete(codigo);
            JOptionPane.showMessageDialog(frmclient, "Registro eliminado");
        }
    }



    void centrarCeldas(JTable jtable)   {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < frmclient.tablacliente.getColumnCount(); i++) {
            frmclient.tablacliente.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }


    void CleanTable() {
        for (int i = 0; i < frmclient.tablacliente.getRowCount(); i++) {
            model.removeRow(i);
            i = i-1;

        }
    }

    void Edit() throws ParseException{
        int element= frmclient.tablacliente.getSelectedRow();
        if (element == -1) {
            JOptionPane.showMessageDialog(null,"Seleccione un registro a editar");
        }else   {
         String elementCOD=(String) frmclient.tablacliente.getValueAt(element,0);
         String elementNOMS=(String) frmclient.tablacliente.getValueAt(element,1);
         String elementEMP=String.valueOf(frmclient.tablacliente.getValueAt(element,2));
         String elementTLF=(String) frmclient.tablacliente.getValueAt(element,3);
         String elementCORR=(String) frmclient.tablacliente.getValueAt(element,4);
         String elementEST=(String) frmclient.tablacliente.getValueAt(element,5);
         String elementMED=(String) frmclient.tablacliente.getValueAt(element,6);
         String elementEMPR=(String) frmclient.tablacliente.getValueAt(element,7);
         String elementTIPD=(String) frmclient.tablacliente.getValueAt(element,8);
         String elementOBS=(String) frmclient.tablacliente.getValueAt(element,9);
         String elementFECR=(String) frmclient.tablacliente.getValueAt(element,10);
         DateFormat fechaHora = new SimpleDateFormat("yyyy/MM/dd");
         Date fechard = (Date) fechaHora.parse(elementFECR);
         String elementFECC=(String) frmclient.tablacliente.getValueAt(element,11);
         Date fechacd = (Date) fechaHora.parse(elementFECR);
         String elementINDUS=(String) frmclient.tablacliente.getValueAt(element,12);
         String elementPRIO=(String) frmclient.tablacliente.getValueAt(element,13);
         String elementPROV=(String) frmclient.tablacliente.getValueAt(element,14);
         frmclient.txtcodigo.setText(""+elementCOD);
         frmclient.txtnombres.setText(""+elementNOMS);
         frmclient.getcomboemp().setSelectedItem(daoEmp.Find(elementEMP));
         frmclient.txttelefono.setText(""+elementTLF);
         frmclient.txtcorreo.setText(""+elementCORR);
         frmclient.txtestado.setText(""+elementEST);
          frmclient.txtmedio.setText(""+elementMED);
         frmclient.txtempresa.setText(""+elementEMPR);
         frmclient.txttipod.setText(""+elementTIPD);
         frmclient.getjTextArea().setText(""+elementOBS);
         frmclient.getjXDatePickerFR().setDate(fechard);
         frmclient.getjXDatePickerFR().setDate(fechacd);
         frmclient.txtindustria.setText(""+elementINDUS);
         frmclient.txtprioridad.setText(""+elementPRIO);
         frmclient.txtprovincia.setText(""+elementPROV);
        }
        System.out.println(Id());
    }

    void Clean()    {
     frmclient.txtcodigo.setText("");
     frmclient.txtnombres.setText("");
     frmclient.getcomboemp().setSelectedIndex(0);
     frmclient.txttelefono.setText("");
     frmclient.txtcorreo.setText("");
     frmclient.txtestado.setText("");
      frmclient.txtmedio.setText("");
     frmclient.txtempresa.setText("");
     frmclient.txttipod.setText("");
     frmclient.getjTextArea().setText("");
     frmclient.getjXDatePickerFC().setDate(Date.from(Instant.now()));
     frmclient.getjXDatePickerFR().setDate(Date.from(Instant.now()));
     frmclient.txtindustria.setText("");
     frmclient.txtprioridad.setText("");
     frmclient.txtprovincia.setText("");
     frmclient.txtcodigo.requestFocus();

    }



}