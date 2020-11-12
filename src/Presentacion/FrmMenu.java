/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Presentacion.FrmEmpleado;
import Presentacion.ControlEmpleado;
import Negocio.Empleado;
import Persistencia.EmpleadoDAOImp;
import javax.swing.JOptionPane;

/**
 *
 * @author SERGIO
 */
public class FrmMenu extends javax.swing.JFrame {

    public FrmMenu() {
        initComponents();
        this.setLocationRelativeTo(this);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblcod = new javax.swing.JLabel();
        lblnon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        salir = new javax.swing.JMenuItem();
        acerca = new javax.swing.JMenuItem();
        cerrarsesion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        gempleado = new javax.swing.JMenuItem();
        gcliente = new javax.swing.JMenuItem();
        gproveedor = new javax.swing.JMenuItem();
        gmaterial = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        ingreso = new javax.swing.JMenuItem();
        salida = new javax.swing.JMenuItem();
        visual = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        ringreso = new javax.swing.JMenuItem();
        rsalida = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        fondo = new javax.swing.JMenuItem();

        jPasswordField1.setText("jPasswordField1");

        jMenu3.setText("jMenu3");

        jMenuItem9.setText("jMenuItem9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));

        lbl.setFont(new java.awt.Font("Eras Demi ITC", 1, 14)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 255, 255));
        lbl.setText("Codigo :");

        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre :");

        lblcod.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        lblcod.setForeground(new java.awt.Color(0, 0, 0));

        lblnon.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        lblnon.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblcod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblnon, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblnon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/Logo-Oficial-SIOSAC.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 506, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setToolTipText("");
        jMenuBar1.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/files.png"))); // NOI18N
        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Eras Demi ITC", 1, 14)); // NOI18N

        salir.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/salirico.png"))); // NOI18N
        salir.setText("Salir");
        jMenu1.add(salir);

        acerca.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        acerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/acerico.png"))); // NOI18N
        acerca.setText("Acerca de");
        jMenu1.add(acerca);

        cerrarsesion.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        cerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/logico.png"))); // NOI18N
        cerrarsesion.setText("Cerrar Sesión");
        cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarsesionActionPerformed(evt);
            }
        });
        jMenu1.add(cerrarsesion);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/iconman.png"))); // NOI18N
        jMenu2.setText("Mantenimiento");
        jMenu2.setFont(new java.awt.Font("Eras Demi ITC", 1, 14)); // NOI18N

        gempleado.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        gempleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/empleadoico.png"))); // NOI18N
        gempleado.setText("Gestión Empleado");
        gempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gempleadoActionPerformed(evt);
            }
        });
        jMenu2.add(gempleado);

        gcliente.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        gcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/clienteico.png"))); // NOI18N
        gcliente.setText("Gestión Cliente");
        gcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gclienteActionPerformed(evt);
            }
        });
        jMenu2.add(gcliente);

        gproveedor.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        gproveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/proveico.png"))); // NOI18N
        gproveedor.setText("Gestión Proveedor");
        jMenu2.add(gproveedor);

        gmaterial.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        gmaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/materialico.png"))); // NOI18N
        gmaterial.setText("Gestión Materiales");
        jMenu2.add(gmaterial);

        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/almacenicon.png"))); // NOI18N
        jMenu4.setText("Almacén");
        jMenu4.setFont(new java.awt.Font("Eras Demi ITC", 1, 14)); // NOI18N

        ingreso.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        ingreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/entradaico.png"))); // NOI18N
        ingreso.setText("Ingresos");
        jMenu4.add(ingreso);

        salida.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/salidaico.png"))); // NOI18N
        salida.setText("Salidas");
        jMenu4.add(salida);

        visual.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        visual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/Boxes-Self_35539.png"))); // NOI18N
        visual.setText("Visualizador");
        jMenu4.add(visual);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/informes.png"))); // NOI18N
        jMenu5.setText("Informes");
        jMenu5.setFont(new java.awt.Font("Eras Demi ITC", 1, 14)); // NOI18N

        ringreso.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        ringreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/business_table_order_report_history_2332.png"))); // NOI18N
        ringreso.setText("Reporte ingresos");
        jMenu5.add(ringreso);

        rsalida.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        rsalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/business_table_order_report_history_2332.png"))); // NOI18N
        rsalida.setText("Reporte salidas");
        jMenu5.add(rsalida);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/iconconfig.png"))); // NOI18N
        jMenu6.setText("Configuración");
        jMenu6.setFont(new java.awt.Font("Eras Demi ITC", 1, 14)); // NOI18N

        fondo.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/mac_icon-icons.com_54610.png"))); // NOI18N
        fondo.setText("Fondo de Pantalla");
        jMenu6.add(fondo);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gempleadoActionPerformed
    
    }//GEN-LAST:event_gempleadoActionPerformed

    private void gclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gclienteActionPerformed
       
        FrmEmpleado pc=new FrmEmpleado();
        ControlEmpleado conEMP=new ControlEmpleado(pc);
        pc.setVisible(true);
    }//GEN-LAST:event_gclienteActionPerformed

    private void cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarsesionActionPerformed
        int opcion=JOptionPane.showConfirmDialog(null,"Desea cerrar Sesión ?","Cerrar Sesión",JOptionPane.YES_NO_OPTION,1);
        if (opcion==JOptionPane.YES_OPTION) {
        FrmLogin pc=new FrmLogin();
        ControlAcceso conAcc=new ControlAcceso(pc);
        pc.setVisible(true);
        this.dispose();  
        }else   {
            
        }
   
    }//GEN-LAST:event_cerrarsesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      FrmMenu frmmenu=new FrmMenu();
      frmmenu.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem acerca;
    private javax.swing.JMenuItem cerrarsesion;
    private javax.swing.JMenuItem fondo;
    private javax.swing.JMenuItem gcliente;
    private javax.swing.JMenuItem gempleado;
    private javax.swing.JMenuItem gmaterial;
    private javax.swing.JMenuItem gproveedor;
    private javax.swing.JMenuItem ingreso;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    public javax.swing.JLabel lbl;
    public javax.swing.JLabel lblcod;
    public javax.swing.JLabel lblnon;
    private javax.swing.JMenuItem ringreso;
    private javax.swing.JMenuItem rsalida;
    private javax.swing.JMenuItem salida;
    private javax.swing.JMenuItem salir;
    private javax.swing.JMenuItem visual;
    // End of variables declaration//GEN-END:variables
}
