/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package VistaRegistrarPersonasExternas;

import VistaAdministrador.*;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author SARA
 */
public class Proveedores extends javax.swing.JFrame {

    /** Creates new form InterfazAdministrador */
    public Proveedores() {
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
        jPanel1 = new javax.swing.JPanel();
        jlbNombres = new javax.swing.JLabel();
        jtxtRazonSocialprov = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbApellidos = new javax.swing.JLabel();
        jtxtNomBanco = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbCorreoElectronico8 = new javax.swing.JLabel();
        jtxtCorreoProv = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbTelefono = new javax.swing.JLabel();
        jtxtTelefonoProv = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbDocumento = new javax.swing.JLabel();
        jtxtDireccionProv = new RSMaterialComponent.RSTextFieldIconTwo();
        jtxtRUC = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbDocumento1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlbDocumento2 = new javax.swing.JLabel();
        jtxtNumCuentaBancaria = new RSMaterialComponent.RSTextFieldIconTwo();
        jtxtPagWeb = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbDocumento3 = new javax.swing.JLabel();
        btnAgregarProv = new RSMaterialComponent.RSButtonIconShadow();
        btnEditarProv = new RSMaterialComponent.RSButtonIconShadow();
        btnBorrarProv = new RSMaterialComponent.RSButtonIconShadow();
        btnLimpiarCamposProv = new RSMaterialComponent.RSButtonIconShadow();
        jlbAgregar1 = new javax.swing.JLabel();
        jlbEditar1 = new javax.swing.JLabel();
        jlbBorrar3 = new javax.swing.JLabel();
        jlbLimpiarCampos3 = new javax.swing.JLabel();
        jlbLimpiarCampos4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jlbCorreoElectronico16 = new javax.swing.JLabel();
        jlbCorreoElectronico17 = new javax.swing.JLabel();
        jlbCorreoElectronico18 = new javax.swing.JLabel();
        jtxfNombreProducto13 = new RSMaterialComponent.RSTextFieldIconTwo();
        jtxfNombreProducto15 = new RSMaterialComponent.RSTextFieldIconTwo();
        jlbCorreoElectronico19 = new javax.swing.JLabel();
        jlbCorreoElectronico20 = new javax.swing.JLabel();
        jcbxCategoria = new RSMaterialComponent.RSComboBoxMaterial();
        jtxtPrecio = new RSMaterialComponent.RSTextFieldIconTwo();
        jtxtPrecio1 = new RSMaterialComponent.RSTextFieldIconTwo();
        btnAgregar = new RSMaterialComponent.RSButtonIconShadow();
        btnEditar = new RSMaterialComponent.RSButtonIconShadow();
        btnBorrar = new RSMaterialComponent.RSButtonIconShadow();
        btnLimpiarCampos = new RSMaterialComponent.RSButtonIconShadow();
        jlbAgregar = new javax.swing.JLabel();
        jlbEditar = new javax.swing.JLabel();
        jlbBorrar2 = new javax.swing.JLabel();
        jlbLimpiarCampos1 = new javax.swing.JLabel();
        jlbLimpiarCampos2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new RSMaterialComponent.RSTableMetro();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEmpleados2 = new RSMaterialComponent.RSTableMetro();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblEmpleados3 = new RSMaterialComponent.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setForeground(new java.awt.Color(255, 255, 255));
        Panel.setBgShade(new java.awt.Color(255, 255, 255));
        Panel.setIntensity(5);
        Panel.setPixels(0);
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbNombres.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbNombres.setForeground(new java.awt.Color(51, 51, 51));
        jlbNombres.setText("Razón Social *");
        jPanel1.add(jlbNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, -1));

        jtxtRazonSocialprov.setForeground(new java.awt.Color(102, 102, 102));
        jtxtRazonSocialprov.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtRazonSocialprov.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtRazonSocialprov.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtRazonSocialprov.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);
        jtxtRazonSocialprov.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtRazonSocialprov.setPlaceholder("Razón Social");
        jtxtRazonSocialprov.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtRazonSocialprov, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, 30));

        jlbApellidos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbApellidos.setForeground(new java.awt.Color(51, 51, 51));
        jlbApellidos.setText("RUC *");
        jPanel1.add(jlbApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 150, -1));

        jtxtNomBanco.setForeground(new java.awt.Color(102, 102, 102));
        jtxtNomBanco.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtNomBanco.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtNomBanco.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtNomBanco.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);
        jtxtNomBanco.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtNomBanco.setPlaceholder("Banco");
        jtxtNomBanco.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtNomBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 150, 30));

        jlbCorreoElectronico8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico8.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico8.setText("Correo electrónico *");
        jPanel1.add(jlbCorreoElectronico8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 150, -1));

        jtxtCorreoProv.setForeground(new java.awt.Color(102, 102, 102));
        jtxtCorreoProv.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtCorreoProv.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtCorreoProv.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtCorreoProv.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EMAIL);
        jtxtCorreoProv.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtCorreoProv.setPlaceholder(" abc@mail.com");
        jtxtCorreoProv.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtCorreoProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 150, 30));

        jlbTelefono.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbTelefono.setForeground(new java.awt.Color(51, 51, 51));
        jlbTelefono.setText("Telf. de Contacto *");
        jPanel1.add(jlbTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 150, -1));

        jtxtTelefonoProv.setForeground(new java.awt.Color(102, 102, 102));
        jtxtTelefonoProv.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtTelefonoProv.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtTelefonoProv.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtTelefonoProv.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PHONE);
        jtxtTelefonoProv.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtTelefonoProv.setPlaceholder("999999999");
        jtxtTelefonoProv.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtTelefonoProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 150, 30));

        jlbDocumento.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbDocumento.setForeground(new java.awt.Color(51, 51, 51));
        jlbDocumento.setText("Página web");
        jPanel1.add(jlbDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 150, -1));

        jtxtDireccionProv.setForeground(new java.awt.Color(102, 102, 102));
        jtxtDireccionProv.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtDireccionProv.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtDireccionProv.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtDireccionProv.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ASSIGNMENT);
        jtxtDireccionProv.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtDireccionProv.setPlaceholder("");
        jtxtDireccionProv.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtDireccionProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 150, 30));

        jtxtRUC.setForeground(new java.awt.Color(102, 102, 102));
        jtxtRUC.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtRUC.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtRUC.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtRUC.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);
        jtxtRUC.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtRUC.setPlaceholder("00000000000");
        jtxtRUC.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 150, 30));

        jlbDocumento1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbDocumento1.setForeground(new java.awt.Color(51, 51, 51));
        jlbDocumento1.setText("Dirección *");
        jPanel1.add(jlbDocumento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 150, -1));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Registro de Proveedores");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jlbDocumento2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbDocumento2.setForeground(new java.awt.Color(51, 51, 51));
        jlbDocumento2.setText("Nombre del Banco *");
        jPanel1.add(jlbDocumento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 150, -1));

        jtxtNumCuentaBancaria.setForeground(new java.awt.Color(102, 102, 102));
        jtxtNumCuentaBancaria.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtNumCuentaBancaria.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtNumCuentaBancaria.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtNumCuentaBancaria.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ASSIGNMENT);
        jtxtNumCuentaBancaria.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtNumCuentaBancaria.setPlaceholder("55555555");
        jtxtNumCuentaBancaria.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtNumCuentaBancaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 150, 30));

        jtxtPagWeb.setForeground(new java.awt.Color(102, 102, 102));
        jtxtPagWeb.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtPagWeb.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtPagWeb.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtPagWeb.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);
        jtxtPagWeb.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtPagWeb.setPlaceholder("www.proveedor.com");
        jtxtPagWeb.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel1.add(jtxtPagWeb, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 150, 30));

        jlbDocumento3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbDocumento3.setForeground(new java.awt.Color(51, 51, 51));
        jlbDocumento3.setText("Nº Cuenta Bancaria *");
        jPanel1.add(jlbDocumento3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 150, -1));

        btnAgregarProv.setBackground(new java.awt.Color(0, 204, 102));
        btnAgregarProv.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnAgregarProv.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);
        btnAgregarProv.setName("jbtnActualizarGDG"); // NOI18N
        jPanel1.add(btnAgregarProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        btnEditarProv.setBackground(new java.awt.Color(255, 204, 0));
        btnEditarProv.setBackgroundHover(new java.awt.Color(204, 102, 0));
        btnEditarProv.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarProv.setName("jbtnActualizarGDG"); // NOI18N
        jPanel1.add(btnEditarProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        btnBorrarProv.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrarProv.setBackgroundHover(new java.awt.Color(153, 0, 0));
        btnBorrarProv.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarProv.setName("jbtnActualizarGDG"); // NOI18N
        jPanel1.add(btnBorrarProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, -1, -1));

        btnLimpiarCamposProv.setBackground(new java.awt.Color(51, 153, 255));
        btnLimpiarCamposProv.setBackgroundHover(new java.awt.Color(0, 102, 255));
        btnLimpiarCamposProv.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLEAR_ALL);
        btnLimpiarCamposProv.setName("jbtnActualizarGDG"); // NOI18N
        jPanel1.add(btnLimpiarCamposProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, -1, -1));

        jlbAgregar1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbAgregar1.setForeground(new java.awt.Color(51, 51, 51));
        jlbAgregar1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbAgregar1.setText("Agregar");
        jPanel1.add(jlbAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        jlbEditar1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbEditar1.setForeground(new java.awt.Color(51, 51, 51));
        jlbEditar1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbEditar1.setText("Actualizar");
        jPanel1.add(jlbEditar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        jlbBorrar3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbBorrar3.setForeground(new java.awt.Color(51, 51, 51));
        jlbBorrar3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbBorrar3.setText("Borrar");
        jPanel1.add(jlbBorrar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, -1, -1));

        jlbLimpiarCampos3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbLimpiarCampos3.setForeground(new java.awt.Color(51, 51, 51));
        jlbLimpiarCampos3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbLimpiarCampos3.setText("Limpiar");
        jPanel1.add(jlbLimpiarCampos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, -1, -1));

        jlbLimpiarCampos4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbLimpiarCampos4.setForeground(new java.awt.Color(51, 51, 51));
        jlbLimpiarCampos4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbLimpiarCampos4.setText("campos");
        jPanel1.add(jlbLimpiarCampos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, -1, -1));

        Panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1000, 180));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(153, 153, 153)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbCorreoElectronico16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico16.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico16.setText("Precio unidad");
        jPanel4.add(jlbCorreoElectronico16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        jlbCorreoElectronico17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico17.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico17.setText("Nombre de producto");
        jPanel4.add(jlbCorreoElectronico17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        jlbCorreoElectronico18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico18.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico18.setText("Precio al mayor");
        jPanel4.add(jlbCorreoElectronico18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        jtxfNombreProducto13.setForeground(new java.awt.Color(102, 102, 102));
        jtxfNombreProducto13.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxfNombreProducto13.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxfNombreProducto13.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxfNombreProducto13.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BATTERY_STD);
        jtxfNombreProducto13.setPhColor(new java.awt.Color(153, 153, 153));
        jtxfNombreProducto13.setPlaceholder("Producto");
        jtxfNombreProducto13.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel4.add(jtxfNombreProducto13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 150, 30));

        jtxfNombreProducto15.setForeground(new java.awt.Color(102, 102, 102));
        jtxfNombreProducto15.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxfNombreProducto15.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxfNombreProducto15.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxfNombreProducto15.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BATTERY_STD);
        jtxfNombreProducto15.setPhColor(new java.awt.Color(153, 153, 153));
        jtxfNombreProducto15.setPlaceholder("Cant.");
        jtxfNombreProducto15.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel4.add(jtxfNombreProducto15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 120, 30));

        jlbCorreoElectronico19.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico19.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico19.setText("Cantidad");
        jPanel4.add(jlbCorreoElectronico19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        jlbCorreoElectronico20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbCorreoElectronico20.setForeground(new java.awt.Color(51, 51, 51));
        jlbCorreoElectronico20.setText("Categoría");
        jPanel4.add(jlbCorreoElectronico20, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        jcbxCategoria.setForeground(new java.awt.Color(51, 51, 51));
        jcbxCategoria.setColorMaterial(new java.awt.Color(255, 153, 0));
        jPanel4.add(jcbxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 120, 30));

        jtxtPrecio.setForeground(new java.awt.Color(102, 102, 102));
        jtxtPrecio.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtPrecio.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtPrecio.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtPrecio.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        jtxtPrecio.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtPrecio.setPlaceholder(" S/.");
        jtxtPrecio.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel4.add(jtxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 150, 30));

        jtxtPrecio1.setForeground(new java.awt.Color(102, 102, 102));
        jtxtPrecio1.setBorderColor(new java.awt.Color(255, 153, 0));
        jtxtPrecio1.setCaretColor(new java.awt.Color(0, 153, 255));
        jtxtPrecio1.setColorIcon(new java.awt.Color(204, 204, 204));
        jtxtPrecio1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        jtxtPrecio1.setPhColor(new java.awt.Color(153, 153, 153));
        jtxtPrecio1.setPlaceholder(" S/.");
        jtxtPrecio1.setSelectionColor(new java.awt.Color(255, 153, 0));
        jPanel4.add(jtxtPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 150, 30));

        btnAgregar.setBackground(new java.awt.Color(0, 204, 102));
        btnAgregar.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnAgregar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);
        btnAgregar.setName("jbtnActualizarGDG"); // NOI18N
        jPanel4.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        btnEditar.setBackground(new java.awt.Color(255, 204, 0));
        btnEditar.setBackgroundHover(new java.awt.Color(204, 102, 0));
        btnEditar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditar.setName("jbtnActualizarGDG"); // NOI18N
        jPanel4.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        btnBorrar.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrar.setBackgroundHover(new java.awt.Color(153, 0, 0));
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.setName("jbtnActualizarGDG"); // NOI18N
        jPanel4.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        btnLimpiarCampos.setBackground(new java.awt.Color(51, 153, 255));
        btnLimpiarCampos.setBackgroundHover(new java.awt.Color(0, 102, 255));
        btnLimpiarCampos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLEAR_ALL);
        btnLimpiarCampos.setName("jbtnActualizarGDG"); // NOI18N
        jPanel4.add(btnLimpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, -1));

        jlbAgregar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbAgregar.setForeground(new java.awt.Color(51, 51, 51));
        jlbAgregar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbAgregar.setText("Agregar");
        jPanel4.add(jlbAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        jlbEditar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbEditar.setForeground(new java.awt.Color(51, 51, 51));
        jlbEditar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbEditar.setText("Actualizar");
        jPanel4.add(jlbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jlbBorrar2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbBorrar2.setForeground(new java.awt.Color(51, 51, 51));
        jlbBorrar2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbBorrar2.setText("Borrar");
        jPanel4.add(jlbBorrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jlbLimpiarCampos1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbLimpiarCampos1.setForeground(new java.awt.Color(51, 51, 51));
        jlbLimpiarCampos1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbLimpiarCampos1.setText("Limpiar");
        jPanel4.add(jlbLimpiarCampos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        jlbLimpiarCampos2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbLimpiarCampos2.setForeground(new java.awt.Color(51, 51, 51));
        jlbLimpiarCampos2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbLimpiarCampos2.setText("campos");
        jPanel4.add(jlbLimpiarCampos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Productos");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        Panel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 420, 250));

        tblEmpleados.setForeground(new java.awt.Color(153, 153, 153));
        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Producto", "Categoría", "Precio al Mayor", "Cantidad al Mayor", "Precio Unidad"
            }
        ));
        tblEmpleados.setBackgoundHead(new java.awt.Color(51, 51, 51));
        tblEmpleados.setBackgoundHover(new java.awt.Color(102, 102, 102));
        tblEmpleados.setColorPrimaryText(new java.awt.Color(51, 51, 51));
        tblEmpleados.setColorSecundaryText(new java.awt.Color(51, 51, 51));
        tblEmpleados.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(tblEmpleados);

        Panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 550, 180));

        tblEmpleados2.setForeground(new java.awt.Color(153, 153, 153));
        tblEmpleados2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Razón Social", "RUC", "Dirección", "Página Web", "Correo", "Teléfono", "N cuenta bancaria", "Nombre Banco"
            }
        ));
        tblEmpleados2.setBackgoundHead(new java.awt.Color(51, 51, 51));
        tblEmpleados2.setBackgoundHover(new java.awt.Color(102, 102, 102));
        tblEmpleados2.setColorPrimaryText(new java.awt.Color(51, 51, 51));
        tblEmpleados2.setColorSecundaryText(new java.awt.Color(51, 51, 51));
        tblEmpleados2.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane3.setViewportView(tblEmpleados2);

        Panel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 1000, 180));

        tblEmpleados3.setForeground(new java.awt.Color(153, 153, 153));
        tblEmpleados3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Razón Social", "RUC", "Dirección", "Página Web", "Correo", "Teléfono", "N cuenta bancaria", "Nombre Banco", "Categorías"
            }
        ));
        tblEmpleados3.setBackgoundHead(new java.awt.Color(51, 51, 51));
        tblEmpleados3.setBackgoundHover(new java.awt.Color(102, 102, 102));
        tblEmpleados3.setColorPrimaryText(new java.awt.Color(51, 51, 51));
        tblEmpleados3.setColorSecundaryText(new java.awt.Color(51, 51, 51));
        tblEmpleados3.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane4.setViewportView(tblEmpleados3);

        Panel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 1000, 180));

        getContentPane().add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public RSMaterialComponent.RSPanelMaterial Panel;
    public RSMaterialComponent.RSButtonIconShadow btnAgregar;
    public RSMaterialComponent.RSButtonIconShadow btnAgregarProv;
    public RSMaterialComponent.RSButtonIconShadow btnBorrar;
    public RSMaterialComponent.RSButtonIconShadow btnBorrarProv;
    public RSMaterialComponent.RSButtonIconShadow btnEditar;
    public RSMaterialComponent.RSButtonIconShadow btnEditarProv;
    public RSMaterialComponent.RSButtonIconShadow btnLimpiarCampos;
    public RSMaterialComponent.RSButtonIconShadow btnLimpiarCamposProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public RSMaterialComponent.RSComboBoxMaterial jcbxCategoria;
    public javax.swing.JLabel jlbAgregar;
    public javax.swing.JLabel jlbAgregar1;
    public javax.swing.JLabel jlbApellidos;
    public javax.swing.JLabel jlbBorrar2;
    public javax.swing.JLabel jlbBorrar3;
    private javax.swing.JLabel jlbCorreoElectronico16;
    private javax.swing.JLabel jlbCorreoElectronico17;
    private javax.swing.JLabel jlbCorreoElectronico18;
    private javax.swing.JLabel jlbCorreoElectronico19;
    private javax.swing.JLabel jlbCorreoElectronico20;
    public javax.swing.JLabel jlbCorreoElectronico8;
    public javax.swing.JLabel jlbDocumento;
    public javax.swing.JLabel jlbDocumento1;
    public javax.swing.JLabel jlbDocumento2;
    public javax.swing.JLabel jlbDocumento3;
    public javax.swing.JLabel jlbEditar;
    public javax.swing.JLabel jlbEditar1;
    public javax.swing.JLabel jlbLimpiarCampos1;
    public javax.swing.JLabel jlbLimpiarCampos2;
    public javax.swing.JLabel jlbLimpiarCampos3;
    public javax.swing.JLabel jlbLimpiarCampos4;
    public javax.swing.JLabel jlbNombres;
    public javax.swing.JLabel jlbTelefono;
    public RSMaterialComponent.RSTextFieldIconTwo jtxfNombreProducto13;
    public RSMaterialComponent.RSTextFieldIconTwo jtxfNombreProducto15;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtCorreoProv;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtDireccionProv;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtNomBanco;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtNumCuentaBancaria;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtPagWeb;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtPrecio;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtPrecio1;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtRUC;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtRazonSocialprov;
    public RSMaterialComponent.RSTextFieldIconTwo jtxtTelefonoProv;
    public RSMaterialComponent.RSTableMetro tblEmpleados;
    public RSMaterialComponent.RSTableMetro tblEmpleados2;
    public RSMaterialComponent.RSTableMetro tblEmpleados3;
    // End of variables declaration//GEN-END:variables

}
