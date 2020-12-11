/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import Negocio.Categoria;
import Negocio.Material;
import Servicios.ServicioCategoria;
import Servicios.ServicioCategoriaImp;
import Servicios.ServicioMaterial;
import Servicios.ServicioMaterialImp;
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
public class ControlMaterial implements ActionListener{
    
    ServicioCategoria SerCat = new ServicioCategoriaImp();
    ServicioMaterial SerMat = new ServicioMaterialImp();
    Material mat = new Material();
  
    
    FrmMaterial FrmMat = new FrmMaterial();
    DefaultTableModel Tmodel = new DefaultTableModel();

    public ControlMaterial(FrmMaterial FrmMat) {
        this.FrmMat = FrmMat;
        this.FrmMat.btnleer.addActionListener(this);
        this.FrmMat.btnactualizar.addActionListener(this);
        this.FrmMat.btneditar.addActionListener(this);
        this.FrmMat.btneliminar.addActionListener(this);
        this.FrmMat.btnregistrar.addActionListener(this);
        this.FrmMat.btnlimpiar.addActionListener(this);
        Read(FrmMat.tabla);
        Categorias();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == FrmMat.btnleer) {
            CleanTable();
            Read(FrmMat.tabla);
        }
        if (e.getSource() == FrmMat.btnregistrar) {
            Create();
        }
        if (e.getSource() == FrmMat.btneditar) {
            Edit();
        }
        if (e.getSource() == FrmMat.btnactualizar) {
            Update();
        }
        if (e.getSource() == FrmMat.btneliminar) {
            Delete();
        }
        if (e.getSource() == FrmMat.btnlimpiar) {
            Clean();
        }
    }
    
    public void Create(){
        String codigo = FrmMat.txtcodigo.getText();
        String categoria = Id();
        String nombre = FrmMat.txtnombre.getText();
        String stock = FrmMat.txtstock.getText();
        String descripcion = FrmMat.getTxtadescripcion().getText();
        String unidad = FrmMat.txtunidad.getText();
        String alto = FrmMat.txtmalto.getText();
        String ancho = FrmMat.txtmancho.getText();
        
        if (ValidarCampos(codigo,categoria,nombre,stock,descripcion,unidad,alto,ancho)){
            String msg = SerMat.Create(codigo, categoria , nombre, stock, descripcion, unidad, alto, ancho);
            JOptionPane.showMessageDialog(null,msg);
            CleanTable();
            Read(FrmMat.tabla);
        }else{
            
            JOptionPane.showMessageDialog(null,"Complete todos los campos");
        }
        
    }
    
    public void Read(JTable tabla){
        CentrarCeldas(tabla);
        Tmodel = (DefaultTableModel)tabla.getModel();
        for (int i = 1; i < SerMat.Read().size(); i++){
            Object[] fila = (Object[])SerMat.Read().get(i);
            Tmodel.addRow(fila);
        }
        FrmMat.tabla.setModel(Tmodel);
       
    }
    
    
    public void Update(){
        String codigo = FrmMat.txtcodigo.getText();
        String categoria = Id();
        String nombre = FrmMat.txtnombre.getText();
        String stock = FrmMat.txtstock.getText();
        String descripcion = FrmMat.getTxtadescripcion().getText();
        String unidad = FrmMat.txtunidad.getText();
        String alto = FrmMat.txtmalto.getText();
        String ancho = FrmMat.txtmancho.getText();
        
        if (ValidarCampos(codigo,categoria,nombre,stock,descripcion,unidad,alto,ancho)){
            String msg = SerMat.Update(codigo, categoria, nombre, stock, descripcion, unidad, alto, ancho);
            JOptionPane.showMessageDialog(null,msg);
            CleanTable();
            Read(FrmMat.tabla);
        }else{
            
            JOptionPane.showMessageDialog(null,"Complete todos los campos");
        }
    }
    
    public void Delete(){
        int element = FrmMat.tabla.getSelectedRow();
        if (element == -1) {
            JOptionPane.showMessageDialog(null,"Seleccione el registro a eliminar");
        }else{
            String codigo = String.valueOf(FrmMat.tabla.getValueAt(element,0));
            String msg = SerMat.Delete(codigo);
            JOptionPane.showMessageDialog(null,msg);
            CleanTable();
            Read(FrmMat.tabla);
        }
    }
    
    public void Categorias(){
        FrmMat.getCategoria().removeAllItems();
        for (int i = 1; i < SerCat.Read().size(); i++){
            Object[] fila = (Object[])SerCat.Read().get(i);
            Integer id = Integer.parseInt(String.valueOf(fila[0]));
            String nombre = String.valueOf(fila[1]);
            FrmMat.getCategoria().addItem(new Categoria(id, nombre));
        }
    }
    
    public String Id(){
        Categoria cat = (Categoria)FrmMat.getCategoria().getSelectedItem();
        String id = String.valueOf(cat.getCodigo());
        return id;
        }
    
    public void Edit(){
        int element = FrmMat.tabla.getSelectedRow();
        if(element == -1){
            JOptionPane.showMessageDialog(null, "Selecciones un registro a editar");
        }else{
            FrmMat.txtcodigo.setText(""+ FrmMat.tabla.getValueAt(element, 0));
            FrmMat.getCategoria().getModel().setSelectedItem(SerCat.Find(String.valueOf(FrmMat.tabla.getValueAt(element, 1))));
            FrmMat.txtnombre.setText(""+ FrmMat.tabla.getValueAt(element, 2));
            FrmMat.txtstock.setText(""+ FrmMat.tabla.getValueAt(element, 3));
            FrmMat.getTxtadescripcion().setText(""+ FrmMat.tabla.getValueAt(element, 4));
            FrmMat.txtunidad.setText(""+ FrmMat.tabla.getValueAt(element, 5));
            FrmMat.txtmalto.setText(""+ FrmMat.tabla.getValueAt(element, 6));
            FrmMat.txtmancho.setText(""+ FrmMat.tabla.getValueAt(element, 7));
        }
    }
    
    
    public void CleanTable(){
        for (int i = 0; i < FrmMat.tabla.getRowCount(); i++) {
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
        FrmMat.txtcodigo.setText("");
        FrmMat.getCategoria().setSelectedIndex(0);
        FrmMat.txtnombre.setText("");
        FrmMat.txtstock.setText("");
        FrmMat.getTxtadescripcion().setText("");
        FrmMat.txtunidad.setText("");
        FrmMat.txtmalto.setText("");
        FrmMat.txtmancho.setText("");
        FrmMat.txtcodigo.requestFocus();
    }
     
}
