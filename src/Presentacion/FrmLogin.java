
package Presentacion;

import Presentacion.ControlAcceso;


public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtuserlog = new javax.swing.JTextField();
        txtpasslog = new javax.swing.JPasswordField();
        btningresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtuserlog.setBackground(new java.awt.Color(255, 255, 255));
        txtuserlog.setBorder(null);
        txtuserlog.setOpaque(false);
        jPanel1.add(txtuserlog, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 180, 20));

        txtpasslog.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N
        txtpasslog.setBorder(null);
        txtpasslog.setOpaque(false);
        jPanel1.add(txtpasslog, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 180, 20));

        btningresar.setBackground(new java.awt.Color(51, 204, 255));
        btningresar.setFont(new java.awt.Font("Eras Bold ITC", 1, 14)); // NOI18N
        btningresar.setForeground(new java.awt.Color(255, 255, 255));
        btningresar.setText("Ingresar");
        jPanel1.add(btningresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 110, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilitarios/GUILOGIN.PNG"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 340));

        btnsalir.setBackground(new java.awt.Color(255, 0, 0));
        btnsalir.setFont(new java.awt.Font("Eras Bold ITC", 1, 14)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 360, 390));

        jPanel3.setBackground(new java.awt.Color(51, 204, 255));
        jPanel3.setForeground(new java.awt.Color(51, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SIOSAC LOGIN");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
      System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      FrmLogin frmlog=new FrmLogin();
      ControlAcceso conACC=new ControlAcceso(frmlog);
      frmlog.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btningresar;
    public javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPasswordField txtpasslog;
    public javax.swing.JTextField txtuserlog;
    // End of variables declaration//GEN-END:variables
}
