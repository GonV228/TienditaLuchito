/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VistaLogin;

/**
 *
 * @author jheremyPonte
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
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
        rSPanelMaterial2 = new RSMaterialComponent.RSPanelMaterial();
        rSPanelMaterial3 = new RSMaterialComponent.RSPanelMaterial();
        jLabel1 = new javax.swing.JLabel();
        jlbCorreoElectronico = new javax.swing.JLabel();
        JLBContraseña = new javax.swing.JLabel();
        jtxtfIngresaCorreo = new RSMaterialComponent.RSTextFieldIconTwo();
        jtxtfContraseña = new RSMaterialComponent.RSPasswordIconTwo();
        jbtnRecuperarContraseña = new RSMaterialComponent.RSButtonMaterialOne();
        jbtnIniciarSesion = new RSMaterialComponent.RSButtonMaterialOne();
        JLBNombreTienda = new javax.swing.JLabel();
        rSButtonBigIcon_new1 = new newscomponents.RSButtonBigIcon_new();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelMaterial1.setBackground(new java.awt.Color(255, 153, 0));
        rSPanelMaterial1.setBgShade(new java.awt.Color(102, 102, 102));
        rSPanelMaterial1.setPixels(3);
        rSPanelMaterial1.setRound(30);
        rSPanelMaterial1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelMaterial2.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial2.setBgShade(new java.awt.Color(102, 102, 102));
        rSPanelMaterial2.setPixels(3);
        rSPanelMaterial2.setRound(30);
        rSPanelMaterial2.setShadowLeft(false);
        rSPanelMaterial2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelMaterial3.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial3.setBgShade(new java.awt.Color(102, 102, 102));
        rSPanelMaterial3.setPixels(3);
        rSPanelMaterial3.setShadowLeft(false);
        rSPanelMaterial3.setShadowRight(false);
        rSPanelMaterial2.add(rSPanelMaterial3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 30, 580));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BIENVENIDOS A LA BODEGUITA DE LUCHITO");
        rSPanelMaterial2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 450, -1));

        jlbCorreoElectronico.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jlbCorreoElectronico.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico.setText("CORREO ELECTRÓNICO");
        rSPanelMaterial2.add(jlbCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        JLBContraseña.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        JLBContraseña.setForeground(new java.awt.Color(51, 51, 51));
        JLBContraseña.setText("CONTRASEÑA");
        rSPanelMaterial2.add(JLBContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jtxtfIngresaCorreo.setForeground(new java.awt.Color(102, 102, 102));
        jtxtfIngresaCorreo.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtfIngresaCorreo.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtfIngresaCorreo.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtfIngresaCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EMAIL);
        jtxtfIngresaCorreo.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtfIngresaCorreo.setPlaceholder(" abc@mail.com");
        jtxtfIngresaCorreo.setSelectionColor(new java.awt.Color(255, 153, 0));
        rSPanelMaterial2.add(jtxtfIngresaCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 300, -1));

        jtxtfContraseña.setForeground(new java.awt.Color(102, 102, 102));
        jtxtfContraseña.setToolTipText("");
        jtxtfContraseña.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtfContraseña.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtfContraseña.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtfContraseña.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtfContraseña.setPlaceholder("* * * * * * * ");
        jtxtfContraseña.setSelectionColor(new java.awt.Color(255, 153, 0));
        rSPanelMaterial2.add(jtxtfContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 300, -1));

        jbtnRecuperarContraseña.setBackground(new java.awt.Color(102, 102, 102));
        jbtnRecuperarContraseña.setText("RECUPERAR CONTRASEÑA");
        jbtnRecuperarContraseña.setBackgroundHover(new java.awt.Color(153, 153, 153));
        jbtnRecuperarContraseña.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jbtnRecuperarContraseña.setRound(40);
        jbtnRecuperarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRecuperarContraseñaActionPerformed(evt);
            }
        });
        rSPanelMaterial2.add(jbtnRecuperarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 220, -1));

        jbtnIniciarSesion.setBackground(new java.awt.Color(102, 102, 102));
        jbtnIniciarSesion.setText("INICIAR SESIÓN");
        jbtnIniciarSesion.setBackgroundHover(new java.awt.Color(153, 153, 153));
        jbtnIniciarSesion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jbtnIniciarSesion.setRound(40);
        rSPanelMaterial2.add(jbtnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 180, -1));

        rSPanelMaterial1.add(rSPanelMaterial2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 510, 580));

        JLBNombreTienda.setBackground(new java.awt.Color(255, 255, 255));
        JLBNombreTienda.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        JLBNombreTienda.setForeground(new java.awt.Color(255, 255, 255));
        JLBNombreTienda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBNombreTienda.setText("LA BODEGUITA DE LUCHITO");
        rSPanelMaterial1.add(JLBNombreTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 320, 160));

        rSButtonBigIcon_new1.setBackground(new java.awt.Color(255, 153, 0));
        rSButtonBigIcon_new1.setBgHover(new java.awt.Color(255, 153, 0));
        rSButtonBigIcon_new1.setBgShade(new java.awt.Color(255, 153, 0));
        rSButtonBigIcon_new1.setBgShadeHover(new java.awt.Color(255, 153, 0));
        rSButtonBigIcon_new1.setFocusable(false);
        rSButtonBigIcon_new1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STORE);
        rSButtonBigIcon_new1.setRound(30);
        rSPanelMaterial1.add(rSButtonBigIcon_new1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 580));

        getContentPane().add(rSPanelMaterial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnRecuperarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRecuperarContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnRecuperarContraseñaActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel JLBContraseña;
    private javax.swing.JLabel JLBNombreTienda;
    private javax.swing.JLabel jLabel1;
    public RSMaterialComponent.RSButtonMaterialOne jbtnIniciarSesion;
    public RSMaterialComponent.RSButtonMaterialOne jbtnRecuperarContraseña;
    public javax.swing.JLabel jlbCorreoElectronico;
    public RSMaterialComponent.RSPasswordIconTwo jtxtfContraseña;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtfIngresaCorreo;
    private newscomponents.RSButtonBigIcon_new rSButtonBigIcon_new1;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial2;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial3;
    // End of variables declaration//GEN-END:variables
}
