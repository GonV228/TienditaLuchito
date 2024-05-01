/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package VistaInventario;

import VistaAdministrador.*;

/**
 *
 * @author SARA
 */
public class Inventario_Registro extends javax.swing.JFrame {

    /** Creates new form InterfazAdministrador */
    public Inventario_Registro() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new RSMaterialComponent.RSPanelMaterial();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblinventario = new RSMaterialComponent.RSTableMetro();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxfNombreProducto = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbCorreoElectronico = new javax.swing.JLabel();
        jtxtCodigo = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbCorreoElectronico1 = new javax.swing.JLabel();
        jtxtPrecio = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbCorreoElectronico3 = new javax.swing.JLabel();
        jcbxTipoProduc = new RSMaterialComponent.RSComboBoxMaterial();
        jlbCorreoElectronico6 = new javax.swing.JLabel();
        jlbCorreoElectronico7 = new javax.swing.JLabel();
        jtxfDetalle = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbCorreoElectronico8 = new javax.swing.JLabel();
        btnAgregar = new RSMaterialComponent.RSButtonIconShadow();
        btnBorrar = new RSMaterialComponent.RSButtonIconShadow();
        btnEditar = new RSMaterialComponent.RSButtonIconShadow();
        jlbCorreoElectronico10 = new javax.swing.JLabel();
        jlbCorreoElectronico11 = new javax.swing.JLabel();
        btnImagenProduc = new RSMaterialComponent.RSButtonMaterialOne();
        btnExportarCatalogo = new RSMaterialComponent.RSButtonMaterialOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setForeground(new java.awt.Color(255, 255, 255));
        Panel.setBgShade(new java.awt.Color(255, 255, 255));
        Panel.setIntensity(5);
        Panel.setPixels(0);
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblinventario.setBackground(new java.awt.Color(255, 255, 255));
        tblinventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Prod", "Código", "Tipo", "Precio", "Stock", "Detalle", "Imagen"
            }
        ));
        tblinventario.setBackgoundHead(new java.awt.Color(51, 51, 51));
        tblinventario.setBackgoundHover(new java.awt.Color(102, 102, 102));
        tblinventario.setColorPrimaryText(new java.awt.Color(51, 51, 51));
        tblinventario.setColorSecundaryText(new java.awt.Color(51, 51, 51));
        tblinventario.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(tblinventario);

        Panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 720, 450));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Registro de Inventario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jtxfNombreProducto.setForeground(new java.awt.Color(102, 102, 102));
        jtxfNombreProducto.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxfNombreProducto.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxfNombreProducto.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxfNombreProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BATTERY_STD);
        jtxfNombreProducto.setPhColor(new java.awt.Color(153, 153, 153));
        jtxfNombreProducto.setPlaceholder("Nombre de producto");
        jtxfNombreProducto.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxfNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 240, 30));

        jlbCorreoElectronico.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico.setText("Nombres del producto");
        jPanel1.add(jlbCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jtxtCodigo.setForeground(new java.awt.Color(102, 102, 102));
        jtxtCodigo.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtCodigo.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtCodigo.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtCodigo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ASSIGNMENT);
        jtxtCodigo.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtCodigo.setPlaceholder("Código");
        jtxtCodigo.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 240, 30));

        jlbCorreoElectronico1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico1.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico1.setText("Código");
        jPanel1.add(jlbCorreoElectronico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jtxtPrecio.setForeground(new java.awt.Color(102, 102, 102));
        jtxtPrecio.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtPrecio.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtPrecio.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtPrecio.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        jtxtPrecio.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtPrecio.setPlaceholder(" S/.");
        jtxtPrecio.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 240, 30));

        jlbCorreoElectronico3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico3.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico3.setText("Tipo de Producto");
        jPanel1.add(jlbCorreoElectronico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jcbxTipoProduc.setForeground(new java.awt.Color(51, 51, 51));
        jcbxTipoProduc.setColorMaterial(new java.awt.Color(255, 153, 0));
        jPanel1.add(jcbxTipoProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 240, 30));

        jlbCorreoElectronico6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico6.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbCorreoElectronico6.setText("Agregar");
        jPanel1.add(jlbCorreoElectronico6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, -1, -1));

        jlbCorreoElectronico7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico7.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico7.setText("Detalle");
        jPanel1.add(jlbCorreoElectronico7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jtxfDetalle.setForeground(new java.awt.Color(102, 102, 102));
        jtxfDetalle.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxfDetalle.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxfDetalle.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxfDetalle.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.COMMENT);
        jtxfDetalle.setPhColor(new java.awt.Color(153, 153, 153));
        jtxfDetalle.setPlaceholder("Breve descripción");
        jtxfDetalle.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxfDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 240, 30));

        jlbCorreoElectronico8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico8.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico8.setText("Precio");
        jPanel1.add(jlbCorreoElectronico8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(0, 204, 102));
        btnAgregar.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnAgregar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);
        btnAgregar.setName("jbtnActualizarGDG"); // NOI18N
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, -1, -1));

        btnBorrar.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrar.setBackgroundHover(new java.awt.Color(153, 0, 0));
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.setName("jbtnActualizarGDG"); // NOI18N
        jPanel1.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, -1, -1));

        btnEditar.setBackground(new java.awt.Color(255, 204, 0));
        btnEditar.setBackgroundHover(new java.awt.Color(204, 102, 0));
        btnEditar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditar.setName("jbtnActualizarGDG"); // NOI18N
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, -1, -1));

        jlbCorreoElectronico10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico10.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbCorreoElectronico10.setText("Borrar");
        jPanel1.add(jlbCorreoElectronico10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, -1, -1));

        jlbCorreoElectronico11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico11.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbCorreoElectronico11.setText("Editar");
        jPanel1.add(jlbCorreoElectronico11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, -1, -1));

        btnImagenProduc.setBackground(new java.awt.Color(102, 102, 102));
        btnImagenProduc.setText("Subir imagen producto");
        btnImagenProduc.setBackgroundHover(new java.awt.Color(153, 153, 153));
        btnImagenProduc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnImagenProduc.setRound(30);
        btnImagenProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenProducActionPerformed(evt);
            }
        });
        jPanel1.add(btnImagenProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 180, 30));

        Panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 280, 620));

        btnExportarCatalogo.setBackground(new java.awt.Color(102, 102, 102));
        btnExportarCatalogo.setText("Exportar catálogo");
        btnExportarCatalogo.setBackgroundHover(new java.awt.Color(153, 153, 153));
        btnExportarCatalogo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnExportarCatalogo.setRound(30);
        btnExportarCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarCatalogoActionPerformed(evt);
            }
        });
        Panel.add(btnExportarCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 590, 180, 30));

        getContentPane().add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarCatalogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportarCatalogoActionPerformed

    private void btnImagenProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenProducActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImagenProducActionPerformed

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
            java.util.logging.Logger.getLogger(Inventario_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario_Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public RSMaterialComponent.RSPanelMaterial Panel;
    public RSMaterialComponent.RSButtonIconShadow btnAgregar;
    public RSMaterialComponent.RSButtonIconShadow btnBorrar;
    public RSMaterialComponent.RSButtonIconShadow btnEditar;
    public RSMaterialComponent.RSButtonMaterialOne btnExportarCatalogo;
    public RSMaterialComponent.RSButtonMaterialOne btnImagenProduc;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public RSMaterialComponent.RSComboBoxMaterial jcbxTipoProduc;
    private javax.swing.JLabel jlbCorreoElectronico;
    private javax.swing.JLabel jlbCorreoElectronico1;
    private javax.swing.JLabel jlbCorreoElectronico10;
    private javax.swing.JLabel jlbCorreoElectronico11;
    private javax.swing.JLabel jlbCorreoElectronico3;
    private javax.swing.JLabel jlbCorreoElectronico6;
    private javax.swing.JLabel jlbCorreoElectronico7;
    private javax.swing.JLabel jlbCorreoElectronico8;
    public RSMaterialComponent.RSTextFieldIconTwo jtxfDetalle;
    public RSMaterialComponent.RSTextFieldIconTwo jtxfNombreProducto;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtCodigo;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtPrecio;
    public RSMaterialComponent.RSTableMetro tblinventario;
    // End of variables declaration//GEN-END:variables

}
