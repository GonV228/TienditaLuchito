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
        jtxfNombreProducto = new RSMaterialComponent.RSTextFieldIconTwo();
        jcbxCategoria = new RSMaterialComponent.RSComboBoxMaterial();
        jtxfInformacion = new RSMaterialComponent.RSTextFieldIconTwo();
        jtxtPrecio = new RSMaterialComponent.RSTextFieldIconTwo();
        jlabelImagenInventario = new javax.swing.JLabel();
        jlbCorreoElectronico = new javax.swing.JLabel();
        jlbCorreoElectronico3 = new javax.swing.JLabel();
        jlbCorreoElectronico7 = new javax.swing.JLabel();
        jlbCorreoElectronico8 = new javax.swing.JLabel();
        btnImagenProduc = new RSMaterialComponent.RSButtonMaterialOne();
        btnAgregarProducto = new RSMaterialComponent.RSButtonIconShadow();
        btnEliminarProducto = new RSMaterialComponent.RSButtonIconShadow();
        btnEditarProducto = new RSMaterialComponent.RSButtonIconShadow();
        jLabel3 = new javax.swing.JLabel();
        jlbAgregar1 = new javax.swing.JLabel();
        jlbAgregar2 = new javax.swing.JLabel();
        jlbAgregar4 = new javax.swing.JLabel();
        jlbAgregar5 = new javax.swing.JLabel();
        jlbAgregar6 = new javax.swing.JLabel();
        jlbAgregar7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxfNombreCategoria = new RSMaterialComponent.RSTextFieldIconTwo();
        btnAgregarCategorias = new RSMaterialComponent.RSButtonIconShadow();
        btnBorrarCategorias = new RSMaterialComponent.RSButtonIconShadow();
        btnEditarCategorias = new RSMaterialComponent.RSButtonIconShadow();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableProductos = new RSMaterialComponent.RSTableMetro();
        btnExportarCatalogoProductos = new RSMaterialComponent.RSButtonMaterialOne();
        jbtnStock = new RSMaterialComponent.RSButtonMaterialOne();
        jLabel2 = new javax.swing.JLabel();
        jcbxFiltroCategoria = new RSMaterialComponent.RSComboBoxMaterial();
        jlbAgregar = new javax.swing.JLabel();
        jlbAgregar3 = new javax.swing.JLabel();
        jlbAgregar8 = new javax.swing.JLabel();

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

        Panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 600, 140));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxfNombreProducto.setForeground(new java.awt.Color(102, 102, 102));
        jtxfNombreProducto.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxfNombreProducto.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxfNombreProducto.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxfNombreProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BATTERY_STD);
        jtxfNombreProducto.setPhColor(new java.awt.Color(153, 153, 153));
        jtxfNombreProducto.setPlaceholder("Nombre del Producto");
        jtxfNombreProducto.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxfNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 30));

        jcbxCategoria.setForeground(new java.awt.Color(51, 51, 51));
        jcbxCategoria.setColorMaterial(new java.awt.Color(255, 153, 0));
        jPanel1.add(jcbxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 250, 30));

        jtxfInformacion.setForeground(new java.awt.Color(102, 102, 102));
        jtxfInformacion.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxfInformacion.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxfInformacion.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxfInformacion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.COMMENT);
        jtxfInformacion.setPhColor(new java.awt.Color(153, 153, 153));
        jtxfInformacion.setPlaceholder("Breve descripción");
        jtxfInformacion.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxfInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 240, 30));

        jtxtPrecio.setForeground(new java.awt.Color(102, 102, 102));
        jtxtPrecio.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtPrecio.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtPrecio.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtPrecio.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        jtxtPrecio.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtPrecio.setPlaceholder(" S/.");
        jtxtPrecio.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 240, 30));

        jlabelImagenInventario.setBackground(new java.awt.Color(102, 153, 255));
        jlabelImagenInventario.setForeground(new java.awt.Color(153, 255, 51));
        jlabelImagenInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jlabelImagenInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 230, 190));

        jlbCorreoElectronico.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico.setText("Nombres del producto");
        jPanel1.add(jlbCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jlbCorreoElectronico3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico3.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico3.setText("Categoria");
        jPanel1.add(jlbCorreoElectronico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jlbCorreoElectronico7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico7.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico7.setText("Detalle");
        jPanel1.add(jlbCorreoElectronico7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jlbCorreoElectronico8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico8.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico8.setText("Precio");
        jPanel1.add(jlbCorreoElectronico8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

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
        jPanel1.add(btnImagenProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 180, 30));

        btnAgregarProducto.setBackground(new java.awt.Color(0, 204, 102));
        btnAgregarProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);
        jPanel1.add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, -1, -1));

        btnEliminarProducto.setBackground(new java.awt.Color(255, 28, 28));
        btnEliminarProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        jPanel1.add(btnEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, -1, -1));

        btnEditarProducto.setBackground(new java.awt.Color(255, 204, 0));
        btnEditarProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        jPanel1.add(btnEditarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, -1, -1));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Registro de Inventario");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jlbAgregar1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbAgregar1.setForeground(new java.awt.Color(51, 51, 51));
        jlbAgregar1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbAgregar1.setText("producto");
        jPanel1.add(jlbAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 620, -1, -1));

        jlbAgregar2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbAgregar2.setForeground(new java.awt.Color(51, 51, 51));
        jlbAgregar2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbAgregar2.setText("Editar");
        jPanel1.add(jlbAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, -1, -1));

        jlbAgregar4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbAgregar4.setForeground(new java.awt.Color(51, 51, 51));
        jlbAgregar4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbAgregar4.setText("producto");
        jPanel1.add(jlbAgregar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 70, -1));

        jlbAgregar5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbAgregar5.setForeground(new java.awt.Color(51, 51, 51));
        jlbAgregar5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbAgregar5.setText("Agregar");
        jPanel1.add(jlbAgregar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 70, -1));

        jlbAgregar6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbAgregar6.setForeground(new java.awt.Color(51, 51, 51));
        jlbAgregar6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbAgregar6.setText("producto");
        jPanel1.add(jlbAgregar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 620, -1, -1));

        jlbAgregar7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbAgregar7.setForeground(new java.awt.Color(51, 51, 51));
        jlbAgregar7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbAgregar7.setText("Borrar");
        jPanel1.add(jlbAgregar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, 80, -1));

        Panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 680));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Registro Tipo Categoria");
        Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        jtxfNombreCategoria.setForeground(new java.awt.Color(102, 102, 102));
        jtxfNombreCategoria.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxfNombreCategoria.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxfNombreCategoria.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxfNombreCategoria.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BATTERY_STD);
        jtxfNombreCategoria.setPhColor(new java.awt.Color(153, 153, 153));
        jtxfNombreCategoria.setPlaceholder("Nombre de la Categoria");
        jtxfNombreCategoria.setSelectionColor(new java.awt.Color(255, 153, 0));
        Panel.add(jtxfNombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 240, 30));

        btnAgregarCategorias.setBackground(new java.awt.Color(0, 204, 102));
        btnAgregarCategorias.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnAgregarCategorias.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);
        btnAgregarCategorias.setName("jbtnActualizarGDG"); // NOI18N
        Panel.add(btnAgregarCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, -1, -1));

        btnBorrarCategorias.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrarCategorias.setBackgroundHover(new java.awt.Color(153, 0, 0));
        btnBorrarCategorias.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarCategorias.setName("jbtnActualizarGDG"); // NOI18N
        Panel.add(btnBorrarCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 500, -1, -1));

        btnEditarCategorias.setBackground(new java.awt.Color(255, 204, 0));
        btnEditarCategorias.setBackgroundHover(new java.awt.Color(204, 102, 0));
        btnEditarCategorias.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarCategorias.setName("jbtnActualizarGDG"); // NOI18N
        Panel.add(btnEditarCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 550, -1, -1));

        jtableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Stock", "Informacion", "Precio", "Imagen", "Categoria"
            }
        ));
        jtableProductos.setBackgoundHead(new java.awt.Color(51, 51, 51));
        jtableProductos.setBackgoundHover(new java.awt.Color(102, 102, 102));
        jtableProductos.setColorPrimaryText(new java.awt.Color(51, 51, 51));
        jtableProductos.setColorSecundaryText(new java.awt.Color(51, 51, 51));
        jtableProductos.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(jtableProductos);
        if (jtableProductos.getColumnModel().getColumnCount() > 0) {
            jtableProductos.getColumnModel().getColumn(0).setMinWidth(40);
            jtableProductos.getColumnModel().getColumn(0).setMaxWidth(60);
            jtableProductos.getColumnModel().getColumn(1).setMinWidth(120);
            jtableProductos.getColumnModel().getColumn(1).setMaxWidth(120);
            jtableProductos.getColumnModel().getColumn(2).setMinWidth(40);
            jtableProductos.getColumnModel().getColumn(2).setMaxWidth(60);
            jtableProductos.getColumnModel().getColumn(4).setMinWidth(40);
            jtableProductos.getColumnModel().getColumn(4).setMaxWidth(60);
            jtableProductos.getColumnModel().getColumn(5).setMinWidth(60);
            jtableProductos.getColumnModel().getColumn(5).setMaxWidth(60);
            jtableProductos.getColumnModel().getColumn(6).setMinWidth(120);
            jtableProductos.getColumnModel().getColumn(6).setMaxWidth(120);
        }

        Panel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 720, 260));

        btnExportarCatalogoProductos.setBackground(new java.awt.Color(255, 102, 102));
        btnExportarCatalogoProductos.setText("Exportar catálogo en pdf");
        btnExportarCatalogoProductos.setBackgroundHover(new java.awt.Color(255, 51, 51));
        btnExportarCatalogoProductos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnExportarCatalogoProductos.setMaximumSize(new java.awt.Dimension(181, 29));
        btnExportarCatalogoProductos.setMinimumSize(new java.awt.Dimension(181, 29));
        btnExportarCatalogoProductos.setRound(30);
        btnExportarCatalogoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarCatalogoProductosActionPerformed(evt);
            }
        });
        Panel.add(btnExportarCatalogoProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 190, -1));

        jbtnStock.setBackground(new java.awt.Color(153, 153, 153));
        jbtnStock.setText("Modificar stock");
        jbtnStock.setBackgroundHover(new java.awt.Color(102, 102, 102));
        jbtnStock.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jbtnStock.setMaximumSize(new java.awt.Dimension(181, 29));
        jbtnStock.setMinimumSize(new java.awt.Dimension(181, 29));
        jbtnStock.setRound(30);
        Panel.add(jbtnStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 140, -1));
        jbtnStock.getAccessibleContext().setAccessibleParent(jPanel1);

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Filtrar por Categorias");
        Panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, -1));

        jcbxFiltroCategoria.setForeground(new java.awt.Color(51, 51, 51));
        jcbxFiltroCategoria.setColorMaterial(new java.awt.Color(255, 153, 0));
        Panel.add(jcbxFiltroCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 180, 30));
        jcbxFiltroCategoria.getAccessibleContext().setAccessibleParent(jPanel1);

        jlbAgregar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbAgregar.setForeground(new java.awt.Color(51, 51, 51));
        jlbAgregar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbAgregar.setText("Agregar");
        Panel.add(jlbAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 460, -1, -1));

        jlbAgregar3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbAgregar3.setForeground(new java.awt.Color(51, 51, 51));
        jlbAgregar3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbAgregar3.setText("Editar");
        Panel.add(jlbAgregar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 560, 80, -1));

        jlbAgregar8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbAgregar8.setForeground(new java.awt.Color(51, 51, 51));
        jlbAgregar8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbAgregar8.setText("Borrar");
        Panel.add(jlbAgregar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 510, 80, -1));

        getContentPane().add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarCatalogoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarCatalogoProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportarCatalogoProductosActionPerformed

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
    public RSMaterialComponent.RSButtonMaterialOne btnExportarCatalogoProductos;
    public RSMaterialComponent.RSButtonMaterialOne btnImagenProduc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public RSMaterialComponent.RSButtonMaterialOne jbtnStock;
    public RSMaterialComponent.RSComboBoxMaterial jcbxCategoria;
    public RSMaterialComponent.RSComboBoxMaterial jcbxFiltroCategoria;
    private javax.swing.JLabel jlabelImagenInventario;
    public javax.swing.JLabel jlbAgregar;
    public javax.swing.JLabel jlbAgregar1;
    public javax.swing.JLabel jlbAgregar2;
    public javax.swing.JLabel jlbAgregar3;
    public javax.swing.JLabel jlbAgregar4;
    public javax.swing.JLabel jlbAgregar5;
    public javax.swing.JLabel jlbAgregar6;
    public javax.swing.JLabel jlbAgregar7;
    public javax.swing.JLabel jlbAgregar8;
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
