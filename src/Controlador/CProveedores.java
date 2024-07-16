package Controlador;
//Importar clases

import Dao.DProveedores;
import Modelo.Proveedor;
import VistaAdministrador.Administrador;
import VistaRegistrarPersonasExternas.Proveedores;
import java.awt.event.ActionEvent;
//importar librerias
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CProveedores implements ActionListener {

    //inicializar
    Proveedores vista;
    Administrador adm;
    Proveedor proveedorSeleccionado = new Proveedor();

    //constructor
    public CProveedores(Proveedores regisPoveedores, Administrador menu) {
        vista = regisPoveedores;
        adm = menu;

        vista.btnAgregarProv.addActionListener(this);
        vista.btnBorrarProv.addActionListener(this);
        vista.btnEditarProv.addActionListener(this);
        vista.btnLimpiarCamposProv.addActionListener(this);

        mostrarProveedorTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregarProv) {
            agregarProveedor();
        } else if (e.getSource() == vista.btnBorrarProv) {
            ElimintarProveedor();
        } else if (e.getSource() == vista.btnEditarProv) {
            EditarProveedor();
        } else if (e.getSource() == vista.btnLimpiarCamposProv) {
            limpiarcampos();
        }
    }

    private void mostrarProveedorTabla() {
        DProveedores dao = new DProveedores();
        List<Proveedor> proveedor = dao.obtenerTodosProveedores();

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) vista.tblEmpleados2.getModel();

        // Iterar sobre las columnas y establecer el editor como null para hacerlas no editables
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            vista.tblEmpleados2.setDefaultEditor(modelo.getColumnClass(i), null);
        }
        // Limpiar la tabla antes de agregar los nuevos datos
        modelo.setRowCount(0);

        // Agregar cada cliente a la tabla
        for (Proveedor proveedores : proveedor) {
            Object[] fila = {
                proveedores.getRazon_social(),
                proveedores.getRuc(),
                proveedores.getDireccion(),
                proveedores.getPagina_web(),
                proveedores.getCorreo(),
                proveedores.getTelf_contacto(),
                proveedores.getN_cuenta_bancaria(),
                proveedores.getNombre_banco()
            };
            modelo.addRow(fila);
        }
    }

    //10. limpiar campos
    private void limpiarcampos() {
        vista.jtxtRazonSocialprov.setText(null);
        vista.jtxtRUC.setText(null);
        vista.jtxtDireccionProv.setText(null);
        vista.jtxtPagWeb.setText(null);
        vista.jtxtCorreoProv.setText(null);
        vista.jtxtNumCuentaBancaria.setText(null);
        vista.jtxtNomBanco.setText(null);
        vista.jtxtTelefonoProv.setText(null);
    }

    private void agregarProveedor() {
        DProveedores dao = new DProveedores();

        String razon_social = vista.jtxtRazonSocialprov.getText().trim();
        String RUC = vista.jtxtRUC.getText();
        String direccion = vista.jtxtDireccionProv.getText().trim();
        String paginaWeb = vista.jtxtPagWeb.getText().trim();
        String numCuentaBancaria = vista.jtxtNumCuentaBancaria.getText().trim();
        String nombreBanco = vista.jtxtNomBanco.getText().trim();
        String telefonoContacto = vista.jtxtTelefonoProv.getText();
        String correoElectronico = vista.jtxtCorreoProv.getText().trim();

        if (razon_social.isEmpty() || RUC.isEmpty() || direccion.isEmpty()
                || paginaWeb.isEmpty() || numCuentaBancaria.isEmpty() || nombreBanco.isEmpty()
                || telefonoContacto.isEmpty() || correoElectronico.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, completa todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        long ruc = 0, cuentaBancaria = 0, telefContact = 0;

        try {
            telefContact = Long.parseLong(telefonoContacto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "el telefono de contacto no debe de contener texto.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            ruc = Long.parseLong(RUC);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "el RUC no debe de contener texto.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            cuentaBancaria = Long.parseLong(numCuentaBancaria);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "la cuenta bancaria no debe de contener texto.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        Proveedor proveedor = new Proveedor(razon_social, ruc, direccion, paginaWeb, cuentaBancaria, nombreBanco, telefContact, correoElectronico);

        boolean insertado = dao.registrarProveedor(proveedor);
        if (insertado) {
            JOptionPane.showMessageDialog(vista, "proveedor agregado correctamente.");
            mostrarProveedorTabla();
            limpiarcampos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar al proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ElimintarProveedor() {

        DProveedores dao = new DProveedores();

        int filaSeleccionada = vista.tblEmpleados2.getSelectedRow();

        if (filaSeleccionada != -1) {
            long RUCProveedor = (long) vista.tblEmpleados2.getValueAt(filaSeleccionada, 1);
            int opcion = JOptionPane.showConfirmDialog(vista, "¿Estás seguro de eliminar este proveedor?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                boolean eliminado = dao.eliminarProveedor(RUCProveedor);
                if (eliminado) {
                    JOptionPane.showMessageDialog(vista, "Proveedor eliminado correctamente.");
                    mostrarProveedorTabla();
                    limpiarcampos();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al eliminar al proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, selecciona un proveedor a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void EditarProveedor() {
        DProveedores dao = new DProveedores();

        int proveedorSeleccionada = vista.tblEmpleados2.getSelectedRow();
        System.out.println(proveedorSeleccionada);
        if (proveedorSeleccionada != -1){
            int idProveedor = proveedorSeleccionada;
            String razonSoci = (String) vista.jtxtRazonSocialprov.getText().trim();
            String ruc = (String) vista.jtxtRUC.getText().trim();
            String direccion = vista.jtxtDireccionProv.getText().trim();
            String paginaWeb = vista.jtxtPagWeb.getText().trim();
            String numCuentaBancaria = (String) vista.jtxtNumCuentaBancaria.getText().trim();
            String nombreBanco = vista.jtxtNomBanco.getText().trim();
            String telefonoContacto = (String) vista.jtxtTelefonoProv.getText().trim();
            String correoElectronito = vista.jtxtCorreoProv.getText().trim();

            
            System.out.println(idProveedor+ razonSoci + ruc + direccion + paginaWeb + numCuentaBancaria + nombreBanco+telefonoContacto+correoElectronito);
            if (!razonSoci.isEmpty() || !ruc.isEmpty() || !direccion.isEmpty()
                    || !paginaWeb.isEmpty() || !numCuentaBancaria.isEmpty()
                    || !nombreBanco.isEmpty() || !telefonoContacto.isEmpty() || !correoElectronito.isEmpty()) {

                long RUC = Long.parseLong(ruc);
                long numCuentaBan = Long.parseLong(numCuentaBancaria);
                long telefonoProv = Long.parseLong(telefonoContacto);
                
                System.out.println(RUC + "-" + numCuentaBan + " - " + telefonoProv );

                proveedorSeleccionado.setRazon_social(razonSoci);
                proveedorSeleccionado.setRuc(RUC);
                proveedorSeleccionado.setDireccion(direccion);
                proveedorSeleccionado.setPagina_web(paginaWeb);
                proveedorSeleccionado.setN_cuenta_bancaria(numCuentaBan);
                proveedorSeleccionado.setNombre_banco(nombreBanco);
                proveedorSeleccionado.setTelf_contacto(telefonoProv);
                proveedorSeleccionado.setCorreo(correoElectronito);

                boolean editado = dao.actualizarProveedor(proveedorSeleccionado, idProveedor);
                if (editado) {
                    JOptionPane.showMessageDialog(vista, "Proveedor editado correctamente.");
                    mostrarProveedorTabla();
                    limpiarcampos();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al editar el proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else {
            JOptionPane.showMessageDialog(vista, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }else {
            JOptionPane.showMessageDialog(vista, "Por favor, selecciona un proveedor a editar.", "Error", JOptionPane.ERROR_MESSAGE);
    }

}

}
