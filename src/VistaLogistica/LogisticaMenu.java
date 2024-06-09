/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package VistaLogistica;

import VistaAdministrador.*;

/**
 *
 * @author SARA
 */
public class LogisticaMenu extends javax.swing.JFrame {

    /** Creates new form InterfazAdministrador */
    public LogisticaMenu() {
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
        jPanel2 = new javax.swing.JPanel();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        tab1 = new newscomponents.RSButtonIcon_new();
        PrincipalLogistica = new RSMaterialComponent.RSPanelMaterial();
        rSLabelTextIcon3 = new RSMaterialComponent.RSLabelTextIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setPixels(0);
        Panel.setRound(20);
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(153, 153, 153)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelTextIcon1.setForeground(new java.awt.Color(51, 51, 51));
        rSLabelTextIcon1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon1.setText("Administrar Logistica");
        rSLabelTextIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLAYLIST_ADD_CHECK);
        jPanel2.add(rSLabelTextIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 800, -1));

        tab1.setBackground(new java.awt.Color(187, 187, 187));
        tab1.setText("Registro");
        tab1.setBackgroundHover(new java.awt.Color(255, 102, 0));
        tab1.setForegroundIcon(new java.awt.Color(102, 102, 102));
        tab1.setForegroundText(new java.awt.Color(102, 102, 102));
        tab1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SUBTITLES);
        tab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab1ActionPerformed(evt);
            }
        });
        jPanel2.add(tab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 52, 139, -1));

        Panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1020, 100));

        PrincipalLogistica.setBackground(new java.awt.Color(255, 255, 255));
        PrincipalLogistica.setIntensity(5);
        PrincipalLogistica.setPixels(0);
        PrincipalLogistica.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelTextIcon3.setForeground(new java.awt.Color(51, 51, 51));
        rSLabelTextIcon3.setText("Administrar Logistica");
        rSLabelTextIcon3.setFont(new java.awt.Font("Roboto Bold", 1, 48)); // NOI18N
        rSLabelTextIcon3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLAYLIST_ADD_CHECK);
        rSLabelTextIcon3.setSizeIcon(60.0F);
        PrincipalLogistica.add(rSLabelTextIcon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1030, 591));

        Panel.add(PrincipalLogistica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1030, 640));

        getContentPane().add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1040, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab1ActionPerformed
        /*        Administrar_Docente1 admDOC=new Administrar_Docente1();
        CGestionarD contolador=new CGestionarD(admDOC);
        //instanciar controlador de administrar docente
        PrincipalAdministrarCuentas.removeAll();
        PrincipalAdministrarCuentas.setLayout(new BorderLayout());
        PrincipalAdministrarCuentas.add(admDOC.getContentPane(),BorderLayout.CENTER);
        PrincipalAdministrarCuentas.revalidate();
        PrincipalAdministrarCuentas.repaint();
        //System.out.println("hola yo soy la vista1");
        if(this.tab1.isSelected()){
            this.tab1.setSelected(true);
            this.tab2.setSelected(false);
        }*/
    }//GEN-LAST:event_tab1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSPanelMaterial Panel;
    public RSMaterialComponent.RSPanelMaterial PrincipalLogistica;
    private javax.swing.JPanel jPanel2;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon3;
    public newscomponents.RSButtonIcon_new tab1;
    // End of variables declaration//GEN-END:variables

}
