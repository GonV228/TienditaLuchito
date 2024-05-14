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
        jtableCategorias = new RSMaterialComponent.RSTableMetro();
        jPanel1 = new javax.swing.JPanel();
        jlbCorreoElectronico = new javax.swing.JLabel();
        jtxtPrecio = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbCorreoElectronico3 = new javax.swing.JLabel();
        jcbxCategoria = new RSMaterialComponent.RSComboBoxMaterial();
        jlbCorreoElectronico7 = new javax.swing.JLabel();
        jtxfInformacion = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbCorreoElectronico8 = new javax.swing.JLabel();
        btnImagenProduc = new RSMaterialComponent.RSButtonMaterialOne();
        jlabelImagenInventario = new javax.swing.JLabel();
        jbtnStock = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtxfNombreProducto = new RSMaterialComponent.RSTextFieldIconTwo();
        btnAgregarProducto = new RSMaterialComponent.RSButtonIconShadow();
        btnEliminarProducto = new RSMaterialComponent.RSButtonIconShadow();
        btnEditarProducto = new RSMaterialComponent.RSButtonIconShadow();
        btnExportarCatalogo = new RSMaterialComponent.RSButtonMaterialOne();
        jLabel1 = new javax.swing.JLabel();
        jtxfNombreCategoria = new RSMaterialComponent.RSTextFieldIconTwo();
        btnAgregarCategorias = new RSMaterialComponent.RSButtonIconShadow();
        btnBorrarCategorias = new RSMaterialComponent.RSButtonIconShadow();
        btnEditarCategorias = new RSMaterialComponent.RSButtonIconShadow();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableProductos = new RSMaterialComponent.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setForeground(new java.awt.Color(255, 255, 255));
        Panel.setBgShade(new java.awt.Color(255, 255, 255));
        Panel.setIntensity(5);
        Panel.setPixels(0);
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtableCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID_Categoria", "Categoria"
            }
        ));
        jtableCategorias.setBackgoundHead(new java.awt.Color(51, 51, 51));
        jtableCategorias.setBackgoundHover(new java.awt.Color(102, 102, 102));
        jtableCategorias.setColorPrimaryText(new java.awt.Color(51, 51, 51));
        jtableCategorias.setColorSecundaryText(new java.awt.Color(51, 51, 51));
        jtableCategorias.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(jtableCategorias);

        Panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 680, 140));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbCorreoElectronico.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico.setText("Nombres del producto");
        jPanel1.add(jlbCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jtxtPrecio.setForeground(new java.awt.Color(102, 102, 102));
        jtxtPrecio.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtPrecio.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtPrecio.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtPrecio.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        jtxtPrecio.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtPrecio.setPlaceholder(" S/.");
        jtxtPrecio.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 240, 30));

        jlbCorreoElectronico3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico3.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico3.setText("Categoria");
        jPanel1.add(jlbCorreoElectronico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jcbxCategoria.setForeground(new java.awt.Color(51, 51, 51));
        jcbxCategoria.setColorMaterial(new java.awt.Color(255, 153, 0));
        jPanel1.add(jcbxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 240, 30));

        jlbCorreoElectronico7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico7.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico7.setText("Detalle");
        jPanel1.add(jlbCorreoElectronico7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jtxfInformacion.setForeground(new java.awt.Color(102, 102, 102));
        jtxfInformacion.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxfInformacion.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxfInformacion.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxfInformacion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.COMMENT);
        jtxfInformacion.setPhColor(new java.awt.Color(153, 153, 153));
        jtxfInformacion.setPlaceholder("Breve descripción");
        jtxfInformacion.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxfInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 240, 30));

        jlbCorreoElectronico8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico8.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico8.setText("Precio");
        jPanel1.add(jlbCorreoElectronico8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

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
        jPanel1.add(btnImagenProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 180, 30));

        jlabelImagenInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jlabelImagenInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 230, 190));

        jbtnStock.setText("Stock");
        jPanel1.add(jbtnStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Registro de Inventario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jtxfNombreProducto.setForeground(new java.awt.Color(102, 102, 102));
        jtxfNombreProducto.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxfNombreProducto.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxfNombreProducto.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxfNombreProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BATTERY_STD);
        jtxfNombreProducto.setPhColor(new java.awt.Color(153, 153, 153));
        jtxfNombreProducto.setPlaceholder("Nombre del Producto");
        jtxfNombreProducto.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxfNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btnAgregarProducto.setBackground(new java.awt.Color(0, 204, 102));
        btnAgregarProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);
        jPanel1.add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        btnEliminarProducto.setBackground(new java.awt.Color(255, 28, 28));
        btnEliminarProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        jPanel1.add(btnEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, -1, -1));

        btnEditarProducto.setBackground(new java.awt.Color(255, 204, 0));
        btnEditarProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        jPanel1.add(btnEditarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, -1, -1));

        Panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 810));

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
        Panel.add(btnExportarCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, 180, 30));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Registro Tipo Categoria");
        Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        jtxfNombreCategoria.setForeground(new java.awt.Color(102, 102, 102));
        jtxfNombreCategoria.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxfNombreCategoria.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxfNombreCategoria.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxfNombreCategoria.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BATTERY_STD);
        jtxfNombreCategoria.setPhColor(new java.awt.Color(153, 153, 153));
        jtxfNombreCategoria.setPlaceholder("Nombre de la Categoria");
        jtxfNombreCategoria.setSelectionColor(new java.awt.Color(255, 153, 0));
        Panel.add(jtxfNombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 240, 30));

        btnAgregarCategorias.setBackground(new java.awt.Color(0, 204, 102));
        btnAgregarCategorias.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnAgregarCategorias.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);
        btnAgregarCategorias.setName("jbtnActualizarGDG"); // NOI18N
        Panel.add(btnAgregarCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, -1, -1));

        btnBorrarCategorias.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrarCategorias.setBackgroundHover(new java.awt.Color(153, 0, 0));
        btnBorrarCategorias.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarCategorias.setName("jbtnActualizarGDG"); // NOI18N
        Panel.add(btnBorrarCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, -1, -1));

        btnEditarCategorias.setBackground(new java.awt.Color(255, 204, 0));
        btnEditarCategorias.setBackgroundHover(new java.awt.Color(204, 102, 0));
        btnEditarCategorias.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarCategorias.setName("jbtnActualizarGDG"); // NOI18N
        Panel.add(btnEditarCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, -1, -1));

        jtableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_Producto", "Nombre", "Categoria", "Precio", "Stock", "Informacion", "Imagen"
            }
        ));
        jtableProductos.setBackgoundHead(new java.awt.Color(51, 51, 51));
        jtableProductos.setBackgoundHover(new java.awt.Color(102, 102, 102));
        jtableProductos.setColorPrimaryText(new java.awt.Color(51, 51, 51));
        jtableProductos.setColorSecundaryText(new java.awt.Color(51, 51, 51));
        jtableProductos.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(jtableProductos);

        Panel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 730, 280));

        getContentPane().add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 680));

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
    public RSMaterialComponent.RSButtonIconShadow btnAgregarCategorias;
    public RSMaterialComponent.RSButtonIconShadow btnAgregarProducto;
    public RSMaterialComponent.RSButtonIconShadow btnBorrarCategorias;
    public RSMaterialComponent.RSButtonIconShadow btnEditarCategorias;
    public RSMaterialComponent.RSButtonIconShadow btnEditarProducto;
    public RSMaterialComponent.RSButtonIconShadow btnEliminarProducto;
    public RSMaterialComponent.RSButtonMaterialOne btnExportarCatalogo;
    public RSMaterialComponent.RSButtonMaterialOne btnImagenProduc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JButton jbtnStock;
    public RSMaterialComponent.RSComboBoxMaterial jcbxCategoria;
    private javax.swing.JLabel jlabelImagenInventario;
    private javax.swing.JLabel jlbCorreoElectronico;
    private javax.swing.JLabel jlbCorreoElectronico3;
    private javax.swing.JLabel jlbCorreoElectronico7;
    private javax.swing.JLabel jlbCorreoElectronico8;
    public RSMaterialComponent.RSTableMetro jtableCategorias;
    public RSMaterialComponent.RSTableMetro jtableProductos;
    public RSMaterialComponent.RSTextFieldIconTwo jtxfInformacion;
    public RSMaterialComponent.RSTextFieldIconTwo jtxfNombreCategoria;
    public RSMaterialComponent.RSTextFieldIconTwo jtxfNombreProducto;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtPrecio;
    // End of variables declaration//GEN-END:variables

}
