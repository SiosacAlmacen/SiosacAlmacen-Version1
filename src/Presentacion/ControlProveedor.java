/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Negocio.Proveedor;
import Servicios.ServicioProveedor;
import Servicios.ServicioProveedorImp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ander
 */
public class ControlProveedor implements ActionListener{
    
    ServicioProveedor SerProv = new ServicioProveedorImp();
    Proveedor prov = new Proveedor();
    
    FrmProveedor FrmProv = new FrmProveedor();
    DefaultTableModel Tmodel = new DefaultTableModel();

    public ControlProveedor(FrmProveedor FrmProv) {
        this.FrmProv = FrmProv;
        this.FrmProv.btnleer.addActionListener(this);
        this.FrmProv.btnactualizar.addActionListener(this);
        this.FrmProv.btneditar.addActionListener(this);
        this.FrmProv.btneliminar.addActionListener(this);
        this.FrmProv.btnregistrar.addActionListener(this);
        this.FrmProv.btnlimpiar.addActionListener(this);
        Read(FrmProv.tabla);
        FrmProv.getFecha().setDate(new Date());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == FrmProv.btnleer) {
            CleanTable();
            Read(FrmProv.tabla);
        }
        if (e.getSource() == FrmProv.btnregistrar) {
            Create();
        }
        if (e.getSource() == FrmProv.btneditar) {
           
            try {
                Edit();
            } catch (ParseException ex) {
                Logger.getLogger(ControlProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        if (e.getSource() == FrmProv.btnactualizar) {
            Update();
        }
        if (e.getSource() == FrmProv.btneliminar) {
            Delete();
        }
        if (e.getSource() == FrmProv.btnlimpiar) {
            Clean();
        }
    }
    
    public void Create(){
        String codigo = FrmProv.txtcodigo.getText();
        String nombre = FrmProv.txtnombre.getText();
        String empresa = FrmProv.txtempresa.getText();
        String telefono = FrmProv.txttelefono.getText();
        String correo = FrmProv.txtcorreo.getText();
        String tipo = FrmProv.txt_tipo.getText();
        String direccion = FrmProv.txtdireccion.getText();
        String fecha = fecha();
        if (ValidarCampos(codigo,nombre,empresa,telefono,correo,tipo,direccion)){
            String msg = SerProv.Create(codigo,nombre,empresa,telefono,correo,fecha,tipo, direccion);
            JOptionPane.showMessageDialog(null,msg);
            CleanTable();
            Read(FrmProv.tabla);
        }else{
            JOptionPane.showMessageDialog(null,"Complete todos los campos");
        }
    }
    
    public void Read(JTable tabla){
        CentrarCeldas(tabla);
        Tmodel = (DefaultTableModel)tabla.getModel();
        for (int i = 1; i < SerProv.Read().size(); i++){
            Object[] fila = (Object[])SerProv.Read().get(i);
            Tmodel.addRow(fila);
        }
        FrmProv.tabla.setModel(Tmodel);
    }
    
    public void Update(){
        String codigo = FrmProv.txtcodigo.getText();
        String nombre = FrmProv.txtnombre.getText();
        String empresa = FrmProv.txtempresa.getText();
        String telefono = FrmProv.txttelefono.getText();
        String correo = FrmProv.txtcorreo.getText();
        String tipo = FrmProv.txt_tipo.getText();
        String direccion = FrmProv.txtdireccion.getText();
        String fecha = fecha();
        if (ValidarCampos(codigo,nombre,empresa,telefono,correo,tipo,direccion)){
            String msg = SerProv.Update(codigo,nombre,empresa,telefono,correo,fecha,tipo, direccion);
            JOptionPane.showMessageDialog(null,msg);
            Clean();
            CleanTable();
            Read(FrmProv.tabla);
        }else{
            JOptionPane.showMessageDialog(null,"Complete todos los campos");
        }
    }
    
    public void Delete(){
        int element = FrmProv.tabla.getSelectedRow();
        if (element == -1) {
            JOptionPane.showMessageDialog(null,"Seleccione el registro a eliminar");
        }else{
            String codigo = String.valueOf(FrmProv.tabla.getValueAt(element,0));
            String msg = SerProv.Delete(codigo);
            JOptionPane.showMessageDialog(null,msg);
            CleanTable();
            Read(FrmProv.tabla);
        }
    }
    
    public void Edit() throws ParseException{
        int element = FrmProv.tabla.getSelectedRow();
        if(element == -1){
            JOptionPane.showMessageDialog(null, "Selecciones un registro a editar");
        }else{
            FrmProv.txtcodigo.setText(""+ FrmProv.tabla.getValueAt(element, 0));
            FrmProv.txtnombre.setText(""+ FrmProv.tabla.getValueAt(element, 1));
            FrmProv.txtempresa.setText(""+FrmProv.tabla.getValueAt(element, 2));
            FrmProv.txttelefono.setText(""+FrmProv.tabla.getValueAt(element, 3));
            FrmProv.txtcorreo.setText(""+FrmProv.tabla.getValueAt(element, 4));
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(FrmProv.tabla.getValueAt(element, 5)));
            FrmProv.getFecha().setDate(fecha);
            FrmProv.txt_tipo.setText(""+FrmProv.tabla.getValueAt(element, 6));
            FrmProv.txtdireccion.setText(""+FrmProv.tabla.getValueAt(element, 7));
        }
    }
   
    public void CleanTable(){
        for (int i = 0; i < FrmProv.tabla.getRowCount(); i++) {
            Tmodel.removeRow(i);
            i = i-1;
        }
    }
    
    public void CentrarCeldas(JTable tabla){
        DefaultTableCellRenderer dtc = new DefaultTableCellRenderer();
        dtc.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(dtc);
        }
        
    }
  
    public boolean ValidarCampos(String... texts){ 
        for(String s : texts) if(s == null || "".equals(s)) return false; 
        return true; 
    }
    
    public String fecha(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            return sdf.format(FrmProv.getFecha().getDate());
        } catch (Exception e) {
            return "Ingrese una fecha";
        }
        
       
    }
    
    public void Clean(){
        FrmProv.txtcodigo.setText("");
        FrmProv.txtnombre.setText("");
        FrmProv.txtempresa.setText("");
        FrmProv.txttelefono.setText("");
        FrmProv.txtcorreo.setText("");
        FrmProv.getFecha().setDate(new Date());
        FrmProv.txt_tipo.setText("");
        FrmProv.txtdireccion.setText("");
        FrmProv.txtcodigo.requestFocus();
    }
    
    
    
}
