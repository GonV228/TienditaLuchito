/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VistaLogin;

/**
 *
 * @author jheremyPonte
 */
public class Recuperar_2Codigo extends javax.swing.JFrame {

    /**
     * Creates new form RecuperarContraseña
     */
    public Recuperar_2Codigo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelMaterial1 = new RSMaterialComponent.RSPanelMaterial();
        jLabel2 = new javax.swing.JLabel();
        jtxtfIngresaCodigo = new RSMaterialComponent.RSTextFieldIconTwo();
        jbtncancelar = new RSMaterialComponent.RSButtonMaterialOne();
        jbtnVolverAEnviar = new RSMaterialComponent.RSButtonMaterialOne();
        jlbCorreoElectronico = new javax.swing.JLabel();
        jbtnAceptar = new RSMaterialComponent.RSButtonMaterialOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setBgShade(new java.awt.Color(102, 102, 102));
        rSPanelMaterial1.setIntensity(0);
        rSPanelMaterial1.setRound(25);
        rSPanelMaterial1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RECUPERAR CONTRASEÑA");
        rSPanelMaterial1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 30, 390, -1));

        jtxtfIngresaCodigo.setForeground(new java.awt.Color(102, 102, 102));
        jtxtfIngresaCodigo.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtfIngresaCodigo.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtfIngresaCodigo.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtfIngresaCodigo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LENS);
        jtxtfIngresaCodigo.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtfIngresaCodigo.setPlaceholder("  /  /  /  /  /");
        jtxtfIngresaCodigo.setSelectionColor(new java.awt.Color(255, 153, 0));
        rSPanelMaterial1.add(jtxtfIngresaCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 300, -1));

        jbtncancelar.setBackground(new java.awt.Color(102, 102, 102));
        jbtncancelar.setText("Cancelar");
        jbtncancelar.setBackgroundHover(new java.awt.Color(153, 153, 153));
        jbtncancelar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jbtncancelar.setRound(30);
        jbtncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtncancelarActionPerformed(evt);
            }
        });
        rSPanelMaterial1.add(jbtncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 90, 30));

        jbtnVolverAEnviar.setBackground(new java.awt.Color(102, 102, 102));
        jbtnVolverAEnviar.setText("Volver a enviar");
        jbtnVolverAEnviar.setBackgroundHover(new java.awt.Color(153, 153, 153));
        jbtnVolverAEnviar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jbtnVolverAEnviar.setRound(40);
        jbtnVolverAEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolverAEnviarActionPerformed(evt);
            }
        });
        rSPanelMaterial1.add(jbtnVolverAEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 120, -1));

        jlbCorreoElectronico.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jlbCorreoElectronico.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico.setText("INGRESAR CÓDIGO ");
        rSPanelMaterial1.add(jlbCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jbtnAceptar.setBackground(new java.awt.Color(102, 102, 102));
        jbtnAceptar.setText("Aceptar");
        jbtnAceptar.setBackgroundHover(new java.awt.Color(153, 153, 153));
        jbtnAceptar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jbtnAceptar.setRound(40);
        jbtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAceptarActionPerformed(evt);
            }
        });
        rSPanelMaterial1.add(jbtnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 120, -1));

        getContentPane().add(rSPanelMaterial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtncancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtncancelarActionPerformed

    private void jbtnVolverAEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolverAEnviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnVolverAEnviarActionPerformed

    private void jbtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnAceptarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    public RSMaterialComponent.RSButtonMaterialOne jbtnAceptar;
    public RSMaterialComponent.RSButtonMaterialOne jbtnVolverAEnviar;
    public RSMaterialComponent.RSButtonMaterialOne jbtncancelar;
    public javax.swing.JLabel jlbCorreoElectronico;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtfIngresaCodigo;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    // End of variables declaration//GEN-END:variables
}
