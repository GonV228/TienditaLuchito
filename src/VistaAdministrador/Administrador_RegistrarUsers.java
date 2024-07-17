/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package VistaAdministrador;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author SARA
 */
public class Administrador_RegistrarUsers extends javax.swing.JFrame {

    /** Creates new form InterfazAdministrador */
    public Administrador_RegistrarUsers() {
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
        tblEmpleados = new RSMaterialComponent.RSTableMetro();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbNombres = new javax.swing.JLabel();
        jtxtNombres = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbApellidos = new javax.swing.JLabel();
        jtxtApellidos = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbCorreoElectronico8 = new javax.swing.JLabel();
        jtxtSueldo = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbTelefono = new javax.swing.JLabel();
        jtxtTelefono = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbTipoEmpleado = new javax.swing.JLabel();
        jcbxTipoEmpleado = new RSMaterialComponent.RSComboBoxMaterial();
        jlbTipoDocumento = new javax.swing.JLabel();
        jcbxTipoDoc = new RSMaterialComponent.RSComboBoxMaterial();
        jlbDocumento = new javax.swing.JLabel();
        jtxtNumDocumento = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbContraseña = new javax.swing.JLabel();
        jtxtContraseña = new RSMaterialComponent.RSPasswordIconTwo();
        jlbValidar = new javax.swing.JLabel();
        jlbcontraseña = new javax.swing.JLabel();
        btnValidarContraseña = new RSMaterialComponent.RSButtonIconShadow();
        btnSeleccionarImagen = new RSMaterialComponent.RSButtonMaterialOne();
        jlblImagen = new javax.swing.JLabel();
        jlbAgregar = new javax.swing.JLabel();
        btnAgregar = new RSMaterialComponent.RSButtonIconShadow();
        jlbEditar = new javax.swing.JLabel();
        btnEditar = new RSMaterialComponent.RSButtonIconShadow();
        jlbBorrar2 = new javax.swing.JLabel();
        btnBorrar = new RSMaterialComponent.RSButtonIconShadow();
        jlbLimpiarCampos1 = new javax.swing.JLabel();
        jlbLimpiarCampos2 = new javax.swing.JLabel();
        btnLimpiarCampos = new RSMaterialComponent.RSButtonIconShadow();
        jtxtCorreo = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbCorreoElectronico9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setForeground(new java.awt.Color(255, 255, 255));
        Panel.setBgShade(new java.awt.Color(255, 255, 255));
        Panel.setIntensity(5);
        Panel.setPixels(0);
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombres", "Apellidos", "Correo", "Contraseña", "Rol", "Tipo de documento", "Numero de documento", "Telefono", "Imagen", "Sueldo"
            }
        ));
        tblEmpleados.setBackgoundHead(new java.awt.Color(51, 51, 51));
        tblEmpleados.setBackgoundHover(new java.awt.Color(102, 102, 102));
        tblEmpleados.setColorPrimaryText(new java.awt.Color(51, 51, 51));
        tblEmpleados.setColorSecundaryText(new java.awt.Color(51, 51, 51));
        tblEmpleados.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(tblEmpleados);

        Panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 1000, 350));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Registro de Empleados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jlbNombres.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbNombres.setForeground(new java.awt.Color(51, 51, 51));
        jlbNombres.setText("Nombres");
        jPanel1.add(jlbNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jtxtNombres.setForeground(new java.awt.Color(102, 102, 102));
        jtxtNombres.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtNombres.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtNombres.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtNombres.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);
        jtxtNombres.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtNombres.setPlaceholder("Nombres");
        jtxtNombres.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 30));

        jlbApellidos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbApellidos.setForeground(new java.awt.Color(51, 51, 51));
        jlbApellidos.setText("Apellidos");
        jPanel1.add(jlbApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        jtxtApellidos.setForeground(new java.awt.Color(102, 102, 102));
        jtxtApellidos.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtApellidos.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtApellidos.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtApellidos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);
        jtxtApellidos.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtApellidos.setPlaceholder("Apellidos");
        jtxtApellidos.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 170, 30));

        jlbCorreoElectronico8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico8.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico8.setText("Sueldo");
        jPanel1.add(jlbCorreoElectronico8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, -1, -1));

        jtxtSueldo.setForeground(new java.awt.Color(102, 102, 102));
        jtxtSueldo.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtSueldo.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtSueldo.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtSueldo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        jtxtSueldo.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtSueldo.setPlaceholder(" S/.");
        jtxtSueldo.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 170, 30));

        jlbTelefono.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbTelefono.setForeground(new java.awt.Color(51, 51, 51));
        jlbTelefono.setText("Telf. de Contacto");
        jPanel1.add(jlbTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jtxtTelefono.setForeground(new java.awt.Color(102, 102, 102));
        jtxtTelefono.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtTelefono.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtTelefono.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtTelefono.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PHONE);
        jtxtTelefono.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtTelefono.setPlaceholder("999999999");
        jtxtTelefono.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 170, 30));

        jlbTipoEmpleado.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbTipoEmpleado.setForeground(new java.awt.Color(51, 51, 51));
        jlbTipoEmpleado.setText("Tipo de Empleado");
        jPanel1.add(jlbTipoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        jcbxTipoEmpleado.setForeground(new java.awt.Color(51, 51, 51));
        jcbxTipoEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Empleado", "Administrador", "" }));
        jcbxTipoEmpleado.setColorMaterial(new java.awt.Color(255, 153, 0));
        jPanel1.add(jcbxTipoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 170, 30));

        jlbTipoDocumento.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbTipoDocumento.setForeground(new java.awt.Color(51, 51, 51));
        jlbTipoDocumento.setText("Tipo de Doc. Identidad");
        jPanel1.add(jlbTipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        jcbxTipoDoc.setForeground(new java.awt.Color(51, 51, 51));
        jcbxTipoDoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DNI", "Pasaporte", "Carné de Extranjería" }));
        jcbxTipoDoc.setColorMaterial(new java.awt.Color(255, 153, 0));
        jPanel1.add(jcbxTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 170, 30));

        jlbDocumento.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbDocumento.setForeground(new java.awt.Color(51, 51, 51));
        jlbDocumento.setText("Documento de Identidad");
        jPanel1.add(jlbDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        jtxtNumDocumento.setForeground(new java.awt.Color(102, 102, 102));
        jtxtNumDocumento.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtNumDocumento.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtNumDocumento.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtNumDocumento.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ASSIGNMENT);
        jtxtNumDocumento.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtNumDocumento.setPlaceholder("55555555");
        jtxtNumDocumento.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtNumDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 170, 30));

        jlbContraseña.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbContraseña.setForeground(new java.awt.Color(51, 51, 51));
        jlbContraseña.setText("Contraseña");
        jPanel1.add(jlbContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jtxtContraseña.setForeground(new java.awt.Color(102, 102, 102));
        jtxtContraseña.setToolTipText("");
        jtxtContraseña.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtContraseña.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtContraseña.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtContraseña.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtContraseña.setPlaceholder("* * * * * * * ");
        jtxtContraseña.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 170, 30));

        jlbValidar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbValidar.setForeground(new java.awt.Color(51, 51, 51));
        jlbValidar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbValidar.setText("Validar");
        jPanel1.add(jlbValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        jlbcontraseña.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbcontraseña.setForeground(new java.awt.Color(51, 51, 51));
        jlbcontraseña.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbcontraseña.setText("contraseña");
        jPanel1.add(jlbcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        btnValidarContraseña.setBackground(new java.awt.Color(255, 153, 0));
        btnValidarContraseña.setForeground(new java.awt.Color(204, 204, 204));
        btnValidarContraseña.setBackgroundHover(new java.awt.Color(255, 102, 0));
        btnValidarContraseña.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LOCK);
        jPanel1.add(btnValidarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        btnSeleccionarImagen.setBackground(new java.awt.Color(102, 102, 102));
        btnSeleccionarImagen.setText("Seleccionar Imagen");
        btnSeleccionarImagen.setBackgroundHover(new java.awt.Color(153, 153, 153));
        btnSeleccionarImagen.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnSeleccionarImagen.setRound(30);
        btnSeleccionarImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSeleccionarImagenMouseClicked(evt);
            }
        });
        btnSeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarImagenActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, 140, 30));

        jlblImagen.setForeground(new java.awt.Color(255, 255, 255));
        jlblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jlblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 230, 200));

        jlbAgregar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbAgregar.setForeground(new java.awt.Color(51, 51, 51));
        jlbAgregar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbAgregar.setText("Agregar");
        jPanel1.add(jlbAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(0, 204, 102));
        btnAgregar.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnAgregar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);
        btnAgregar.setName("jbtnActualizarGDG"); // NOI18N
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));

        jlbEditar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbEditar.setForeground(new java.awt.Color(51, 51, 51));
        jlbEditar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbEditar.setText("Actualizar");
        jPanel1.add(jlbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, -1));

        btnEditar.setBackground(new java.awt.Color(255, 204, 0));
        btnEditar.setBackgroundHover(new java.awt.Color(204, 102, 0));
        btnEditar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditar.setName("jbtnActualizarGDG"); // NOI18N
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, -1));

        jlbBorrar2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbBorrar2.setForeground(new java.awt.Color(51, 51, 51));
        jlbBorrar2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbBorrar2.setText("Borrar");
        jPanel1.add(jlbBorrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, -1, -1));

        btnBorrar.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrar.setBackgroundHover(new java.awt.Color(153, 0, 0));
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.setName("jbtnActualizarGDG"); // NOI18N
        jPanel1.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, -1, -1));

        jlbLimpiarCampos1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbLimpiarCampos1.setForeground(new java.awt.Color(51, 51, 51));
        jlbLimpiarCampos1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbLimpiarCampos1.setText("Limpiar");
        jPanel1.add(jlbLimpiarCampos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, -1, -1));

        jlbLimpiarCampos2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbLimpiarCampos2.setForeground(new java.awt.Color(51, 51, 51));
        jlbLimpiarCampos2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbLimpiarCampos2.setText("campos");
        jPanel1.add(jlbLimpiarCampos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, -1, -1));

        btnLimpiarCampos.setBackground(new java.awt.Color(51, 153, 255));
        btnLimpiarCampos.setBackgroundHover(new java.awt.Color(0, 102, 255));
        btnLimpiarCampos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLEAR_ALL);
        btnLimpiarCampos.setName("jbtnActualizarGDG"); // NOI18N
        jPanel1.add(btnLimpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));

        jtxtCorreo.setForeground(new java.awt.Color(102, 102, 102));
        jtxtCorreo.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtCorreo.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtCorreo.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EMAIL);
        jtxtCorreo.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtCorreo.setPlaceholder(" abc@mail.com");
        jtxtCorreo.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 170, 30));

        jlbCorreoElectronico9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico9.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico9.setText("Correo electrónico");
        jPanel1.add(jlbCorreoElectronico9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        Panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1000, 270));

        getContentPane().add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarImagenActionPerformed
 
    }//GEN-LAST:event_btnSeleccionarImagenActionPerformed

    private void btnSeleccionarImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeleccionarImagenMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionarImagenMouseClicked

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
            java.util.logging.Logger.getLogger(Administrador_RegistrarUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador_RegistrarUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador_RegistrarUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador_RegistrarUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Administrador_RegistrarUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public RSMaterialComponent.RSPanelMaterial Panel;
    public RSMaterialComponent.RSButtonIconShadow btnAgregar;
    public RSMaterialComponent.RSButtonIconShadow btnBorrar;
    public RSMaterialComponent.RSButtonIconShadow btnEditar;
    public RSMaterialComponent.RSButtonIconShadow btnLimpiarCampos;
    public RSMaterialComponent.RSButtonMaterialOne btnSeleccionarImagen;
    public RSMaterialComponent.RSButtonIconShadow btnValidarContraseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public RSMaterialComponent.RSComboBoxMaterial jcbxTipoDoc;
    public RSMaterialComponent.RSComboBoxMaterial jcbxTipoEmpleado;
    public javax.swing.JLabel jlbAgregar;
    public javax.swing.JLabel jlbApellidos;
    public javax.swing.JLabel jlbBorrar2;
    public javax.swing.JLabel jlbContraseña;
    public javax.swing.JLabel jlbCorreoElectronico8;
    public javax.swing.JLabel jlbCorreoElectronico9;
    public javax.swing.JLabel jlbDocumento;
    public javax.swing.JLabel jlbEditar;
    public javax.swing.JLabel jlbLimpiarCampos1;
    public javax.swing.JLabel jlbLimpiarCampos2;
    public javax.swing.JLabel jlbNombres;
    public javax.swing.JLabel jlbTelefono;
    public javax.swing.JLabel jlbTipoDocumento;
    public javax.swing.JLabel jlbTipoEmpleado;
    public javax.swing.JLabel jlbValidar;
    public javax.swing.JLabel jlbcontraseña;
    public javax.swing.JLabel jlblImagen;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtApellidos;
    public RSMaterialComponent.RSPasswordIconTwo jtxtContraseña;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtCorreo;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtNombres;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtNumDocumento;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtSueldo;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtTelefono;
    public RSMaterialComponent.RSTableMetro tblEmpleados;
    // End of variables declaration//GEN-END:variables

}
