/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Negocio.Categoria;
import Servicios.ServicioCategoria;
import Servicios.ServicioCategoriaImp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ander
 */
public class ControlCategoria  implements ActionListener{
    
    ServicioCategoria SerCat = new ServicioCategoriaImp();
    Categoria cat = new Categoria();
    
    FrmCategoria FrmCat = new FrmCategoria();
    DefaultTableModel Tmodel = new DefaultTableModel();
    
    public ControlCategoria(FrmCategoria FrmCat) {
        this.FrmCat = FrmCat;
        this.FrmCat.btnleer.addActionListener(this);
        this.FrmCat.btnactualizar.addActionListener(this);
        this.FrmCat.btneditar.addActionListener(this);
        this.FrmCat.btneliminar.addActionListener(this);
        this.FrmCat.btnregistrar.addActionListener(this);
        this.FrmCat.btnlimpiar.addActionListener(this);
        Read(FrmCat.tabla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == FrmCat.btnleer) {
            CleanTable();
            Read(FrmCat.tabla);
        }
        if (e.getSource() == FrmCat.btnregistrar) {
            Create();
        }
        if (e.getSource() == FrmCat.btneditar) {
            Edit();
        }
        if (e.getSource() == FrmCat.btnactualizar) {
            Update();
        }
        if (e.getSource() == FrmCat.btneliminar) {
            Delete();
        }
        if (e.getSource() == FrmCat.btnlimpiar) {
            Clean();
        }
        
    }
    
    public void Create(){
        String codigo = FrmCat.txtcodigo.getText();
        String nombre = FrmCat.txtnombre.getText();
        if (ValidarCampos(codigo,nombre)) {
            String msg = SerCat.Create(codigo,nombre);
            JOptionPane.showMessageDialog(null,msg);
            CleanTable();
            Read(FrmCat.tabla);
        }else{
            JOptionPane.showMessageDialog(null,"Complete todos los campos");
        }
    }
    
    public void Read(JTable tabla){
        CentrarCeldas(tabla);
        Tmodel = (DefaultTableModel)tabla.getModel();
        for (int i = 1; i < SerCat.Read().size(); i++){
            Object[] fila = (Object[])SerCat.Read().get(i);
            Tmodel.addRow(fila);
        }
        FrmCat.tabla.setModel(Tmodel);
    }
    
    public void Update(){
        String codigo = FrmCat.txtcodigo.getText();
        String nombre = FrmCat.txtnombre.getText();
        if (ValidarCampos(codigo,nombre)) {
            String msg = SerCat.Update(codigo, nombre);
            JOptionPane.showMessageDialog(null,msg);
            Clean();
            CleanTable();
            Read(FrmCat.tabla);
        }else{
            JOptionPane.showMessageDialog(null,"Complete todos los campos");
        }
    }
    
    public void Delete(){
        int element = FrmCat.tabla.getSelectedRow();
        if (element == -1) {
            JOptionPane.showMessageDialog(null,"Seleccione el registro a eliminar");
        }else{
            String codigo = String.valueOf(FrmCat.tabla.getValueAt(element,0));
            String msg = SerCat.Delete(codigo);
            JOptionPane.showMessageDialog(null,msg);
            CleanTable();
            Read(FrmCat.tabla);
        }
    }
    
    public void Edit(){
        int element = FrmCat.tabla.getSelectedRow();
        if(element == -1){
            JOptionPane.showMessageDialog(null, "Selecciones un registro a editar");
        }else{
        FrmCat.txtcodigo.setText(""+ FrmCat.tabla.getValueAt(element, 0));
        FrmCat.txtnombre.setText(""+ FrmCat.tabla.getValueAt(element, 1));
        }
    }
   
    public void CleanTable(){
        for (int i = 0; i < FrmCat.tabla.getRowCount(); i++) {
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
  
    public void Clean(){
        FrmCat.txtcodigo.setText("");
        FrmCat.txtnombre.setText("");
        FrmCat.txtcodigo.requestFocus();
    }
}
