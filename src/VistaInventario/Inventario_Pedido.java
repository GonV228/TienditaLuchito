
package VistaInventario;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Inventario_Pedido extends javax.swing.JFrame {

    public Inventario_Pedido() {
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Evita que la ventana se cierre al presionar la "X"
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            // Aquí puedes definir la acción que quieres realizar al presionar la "X"
            // Por ejemplo, ocultar la ventana en lugar de cerrarla
            this.setVisible(false); // O también puedes usar dispose() si quieres liberar los recursos de la ventana
        } else {
            super.processWindowEvent(e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jblNombreProd = new javax.swing.JLabel();
        jtxfNombreProducto = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbCantidad = new javax.swing.JLabel();
        jtxtCantidad = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbCostoTotal = new javax.swing.JLabel();
        jtxtCostoTotal = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbCostoUnidad = new javax.swing.JLabel();
        jtxtCostoUnidad = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbPrecioVenta = new javax.swing.JLabel();
        jtxtPrecioVenta = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbFechaPedido = new javax.swing.JLabel();
        jlbFechaEntrega = new javax.swing.JLabel();
        jlbEstado = new javax.swing.JLabel();
        jcbxEstado = new RSMaterialComponent.RSComboBoxMaterial();
        jlbAceptarP = new javax.swing.JLabel();
        btnAceptar = new RSMaterialComponent.RSButtonIconShadow();
        jlbCancelar = new javax.swing.JLabel();
        btnCancelar = new RSMaterialComponent.RSButtonIconShadow();
        jPanel2 = new javax.swing.JPanel();
        jbtnCalcular = new RSMaterialComponent.RSButtonMaterialOne();
        jdtcFechaEntrega2 = new com.toedter.calendar.JCalendar();
        jdtcFechaPedido2 = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setBackground(new java.awt.Color(51, 51, 51));
        titulo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(153, 153, 153));
        titulo.setText("Pedido");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, -1));

        jblNombreProd.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jblNombreProd.setForeground(new java.awt.Color(51, 51, 51));
        jblNombreProd.setText("Nombres del producto");
        jPanel1.add(jblNombreProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 180, -1));

        jtxfNombreProducto.setForeground(new java.awt.Color(102, 102, 102));
        jtxfNombreProducto.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxfNombreProducto.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxfNombreProducto.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxfNombreProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BATTERY_STD);
        jtxfNombreProducto.setPhColor(new java.awt.Color(153, 153, 153));
        jtxfNombreProducto.setPlaceholder("Nombre del Producto");
        jtxfNombreProducto.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxfNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 180, 30));

        jlbCantidad.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCantidad.setForeground(new java.awt.Color(51, 51, 51));
        jlbCantidad.setText("Cantidad");
        jPanel1.add(jlbCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 80, -1));

        jtxtCantidad.setForeground(new java.awt.Color(102, 102, 102));
        jtxtCantidad.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtCantidad.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtCantidad.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtCantidad.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        jtxtCantidad.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtCantidad.setPlaceholder(" S/.");
        jtxtCantidad.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 80, 30));

        jlbCostoTotal.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCostoTotal.setForeground(new java.awt.Color(51, 51, 51));
        jlbCostoTotal.setText("Costo Total");
        jPanel1.add(jlbCostoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 100, -1));

        jtxtCostoTotal.setForeground(new java.awt.Color(102, 102, 102));
        jtxtCostoTotal.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtCostoTotal.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtCostoTotal.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtCostoTotal.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        jtxtCostoTotal.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtCostoTotal.setPlaceholder(" S/.");
        jtxtCostoTotal.setSelectionColor(new java.awt.Color(255, 153, 0));
        jtxtCostoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCostoTotalActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtCostoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 80, 30));

        jlbCostoUnidad.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCostoUnidad.setForeground(new java.awt.Color(51, 51, 51));
        jlbCostoUnidad.setText("Costo Unidad");
        jPanel1.add(jlbCostoUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 180, -1));

        jtxtCostoUnidad.setForeground(new java.awt.Color(102, 102, 102));
        jtxtCostoUnidad.setBorderColor(new java.awt.Color(102, 102, 102));
        jtxtCostoUnidad.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtCostoUnidad.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtCostoUnidad.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        jtxtCostoUnidad.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtCostoUnidad.setPlaceholder(" S/.");
        jtxtCostoUnidad.setSelectionColor(new java.awt.Color(255, 153, 0));
        jtxtCostoUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCostoUnidadActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtCostoUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 180, 30));

        jlbPrecioVenta.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbPrecioVenta.setForeground(new java.awt.Color(51, 51, 51));
        jlbPrecioVenta.setText("Precio venta");
        jPanel1.add(jlbPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 180, -1));

        jtxtPrecioVenta.setForeground(new java.awt.Color(102, 102, 102));
        jtxtPrecioVenta.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtPrecioVenta.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtPrecioVenta.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtPrecioVenta.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        jtxtPrecioVenta.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtPrecioVenta.setPlaceholder(" S/.");
        jtxtPrecioVenta.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 180, 30));

        jlbFechaPedido.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbFechaPedido.setForeground(new java.awt.Color(51, 51, 51));
        jlbFechaPedido.setText("Fecha de pedido");
        jPanel1.add(jlbFechaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 160, -1));

        jlbFechaEntrega.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbFechaEntrega.setForeground(new java.awt.Color(51, 51, 51));
        jlbFechaEntrega.setText("Fecha de entrega");
        jPanel1.add(jlbFechaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 160, -1));

        jlbEstado.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbEstado.setForeground(new java.awt.Color(51, 51, 51));
        jlbEstado.setText("Estado");
        jPanel1.add(jlbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 160, 20));

        jcbxEstado.setForeground(new java.awt.Color(51, 51, 51));
        jcbxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En proceso", "Recibido", "Cancelado" }));
        jcbxEstado.setColorMaterial(new java.awt.Color(255, 153, 0));
        jcbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(jcbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 160, 30));

        jlbAceptarP.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbAceptarP.setForeground(new java.awt.Color(51, 51, 51));
        jlbAceptarP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbAceptarP.setText("Aceptar ");
        jPanel1.add(jlbAceptarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 580, 140, -1));

        btnAceptar.setBackground(new java.awt.Color(0, 204, 102));
        btnAceptar.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);
        btnAceptar.setName("jbtnActualizarGDG"); // NOI18N
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 570, -1, -1));

        jlbCancelar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCancelar.setForeground(new java.awt.Color(51, 51, 51));
        jlbCancelar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbCancelar.setText("Cancelar ");
        jPanel1.add(jlbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, 110, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelar.setBackgroundHover(new java.awt.Color(153, 0, 0));
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnCancelar.setName("jbtnActualizarGDG"); // NOI18N
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 570, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 50));

        jbtnCalcular.setBackground(new java.awt.Color(153, 153, 153));
        jbtnCalcular.setText("Calcular");
        jbtnCalcular.setBackgroundHover(new java.awt.Color(102, 102, 102));
        jbtnCalcular.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jbtnCalcular.setMaximumSize(new java.awt.Dimension(181, 29));
        jbtnCalcular.setMinimumSize(new java.awt.Dimension(181, 29));
        jbtnCalcular.setRound(30);
        jPanel1.add(jbtnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 130, 30));
        jPanel1.add(jdtcFechaEntrega2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));
        jPanel1.add(jdtcFechaPedido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtCostoUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCostoUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCostoUnidadActionPerformed

    private void jtxtCostoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCostoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCostoTotalActionPerformed

    private void jcbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(Inventario_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario_Pedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public RSMaterialComponent.RSButtonIconShadow btnAceptar;
    public RSMaterialComponent.RSButtonIconShadow btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jblNombreProd;
    public RSMaterialComponent.RSButtonMaterialOne jbtnCalcular;
    public RSMaterialComponent.RSComboBoxMaterial jcbxEstado;
    public com.toedter.calendar.JCalendar jdtcFechaEntrega2;
    public com.toedter.calendar.JCalendar jdtcFechaPedido2;
    private javax.swing.JLabel jlbAceptarP;
    private javax.swing.JLabel jlbCancelar;
    private javax.swing.JLabel jlbCantidad;
    private javax.swing.JLabel jlbCostoTotal;
    private javax.swing.JLabel jlbCostoUnidad;
    private javax.swing.JLabel jlbEstado;
    private javax.swing.JLabel jlbFechaEntrega;
    private javax.swing.JLabel jlbFechaPedido;
    private javax.swing.JLabel jlbPrecioVenta;
    public RSMaterialComponent.RSTextFieldIconTwo jtxfNombreProducto;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtCantidad;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtCostoTotal;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtCostoUnidad;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtPrecioVenta;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
