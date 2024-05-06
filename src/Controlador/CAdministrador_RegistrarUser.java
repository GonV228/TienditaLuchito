package Controlador;

import Dao.DAdministrarUs;
import Modelo.Usuario;
import VistaAdministrador.Administrador;
import VistaAdministrador.Administrador_RegistrarUsers;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CAdministrador_RegistrarUser implements ActionListener {
    Administrador_RegistrarUsers vista;
    Administrador menu;
    Usuario usuarioSeleccionado;

    public CAdministrador_RegistrarUser(Administrador_RegistrarUsers adminRegis, Administrador Admin) {
        vista = adminRegis;
        menu = Admin;
        vista.btnAgregar.addActionListener(this);
        vista.btnBorrar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnSeleccionarImagen.addActionListener(this);
        vista.jtxtNombres.addActionListener(this);
        vista.jtxtApellidos.addActionListener(this);
        vista.jtxtCorreo.addActionListener(this);
        vista.jtxtContraseña.addActionListener(this);
        vista.jtxtNumDocumento.addActionListener(this);
        vista.jtxtTelefono.addActionListener(this);

        
        // Inicializar JComboBox para roles y tipos de documento
        String[] roles = {"Administrador", "Empleado"};
        vista.jcbxTipoEmpleado.setModel(new DefaultComboBoxModel<>(roles));

        String[] tiposDocumento = {"DNI", "Carnet de Extranjeria", "Pasaporte"};
        vista.jcbxTipoDoc.setModel(new DefaultComboBoxModel<>(tiposDocumento));
        
        // Mostrar los usuarios en la tabla
        mostrarUsuariosEnTabla();
        
        // Agregar listener a la tabla para seleccionar usuarios
        vista.tblEmpleados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = vista.tblEmpleados.getSelectedRow();
                if (filaSeleccionada != -1) {
                    DefaultTableModel modelo = (DefaultTableModel) vista.tblEmpleados.getModel();
                    // Obtener los datos de la fila seleccionada
                    String nombres = modelo.getValueAt(filaSeleccionada, 0).toString();
                    String apellidos = modelo.getValueAt(filaSeleccionada, 1).toString();
                    String correo = modelo.getValueAt(filaSeleccionada, 2).toString();
                    String contraseña = modelo.getValueAt(filaSeleccionada, 3).toString();
                    String rol = modelo.getValueAt(filaSeleccionada, 4).toString();
                    String tipoDocumento = modelo.getValueAt(filaSeleccionada, 5).toString();
                    int numeroDocumento = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 6).toString());
                    int telefono = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 7).toString());
                    String imagen = modelo.getValueAt(filaSeleccionada, 8).toString();
                   
                    // Mostrar los datos en los campos de texto y combobox
                    vista.jtxtNombres.setText(nombres);
                    vista.jtxtApellidos.setText(apellidos);
                    vista.jtxtCorreo.setText(correo);
                    vista.jtxtContraseña.setText(contraseña);
                    vista.jcbxTipoEmpleado.setSelectedItem(rol);
                    vista.jcbxTipoDoc.setSelectedItem(tipoDocumento);
                    vista.jtxtNumDocumento.setText(String.valueOf(numeroDocumento));
                    vista.jtxtTelefono.setText(String.valueOf(telefono));

                    // Guardar el usuario seleccionado
                    usuarioSeleccionado = new Usuario(nombres, apellidos, contraseña, correo, rol, tipoDocumento, telefono, imagen, numeroDocumento);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            registrarNuevoUsuario();
        } else if (e.getSource() == vista.btnBorrar) {
            eliminarUsuario();
        } else if (e.getSource() == vista.btnEditar) {
            actualizarUsuario();
        }
        
        // Actualizar la vista después de cada acción
        actualizarVista();
        mostrarUsuariosEnTabla();
    }
    
    private void registrarNuevoUsuario() {
        // Obtener los datos ingresados por el usuario
        String nombres = vista.jtxtNombres.getText();
        String apellidos = vista.jtxtApellidos.getText();
        String correo = vista.jtxtCorreo.getText();
        String contraseña = vista.jtxtContraseña.getText();
        String rol = (String) vista.jcbxTipoEmpleado.getSelectedItem();
        String tipoDocumento = (String) vista.jcbxTipoDoc.getSelectedItem();
        int numeroDocumento = Integer.parseInt(vista.jtxtNumDocumento.getText());
        int telefono = Integer.parseInt(vista.jtxtTelefono.getText());
        String imagen = ""; // No pude poner la imagen :c 


        // Crear un objeto Usuario con los datos obtenidos
        Usuario nuevoUsuario = new Usuario(nombres, apellidos, contraseña, correo, rol, tipoDocumento, telefono, "", numeroDocumento);

        // Llamar al método del DAO para registrar el nuevo usuario
        DAdministrarUs daoRegistrarUs = new DAdministrarUs();
        boolean registroExitoso = daoRegistrarUs.registrarUsuario(nuevoUsuario);

        if (registroExitoso) {
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario. Por favor, inténtalo de nuevo.");
        }
    }
    
    private void actualizarUsuario() {
        if (usuarioSeleccionado != null) {
            // Obtener los datos actualizados del usuario
            String nombres = vista.jtxtNombres.getText();
            String apellidos = vista.jtxtApellidos.getText();
            String correo = vista.jtxtCorreo.getText();
            String contraseña = vista.jtxtContraseña.getText();
            String rol = (String) vista.jcbxTipoEmpleado.getSelectedItem();
            String tipoDocumento = (String) vista.jcbxTipoDoc.getSelectedItem();
            int numeroDocumento = Integer.parseInt(vista.jtxtNumDocumento.getText());
            int telefono = Integer.parseInt(vista.jtxtTelefono.getText());
            String imagen = ""; // No pude poner la imagen :c 
 

            // Crear un objeto Usuario con los datos actualizados
            Usuario usuarioActualizado = new Usuario(nombres, apellidos, contraseña, correo, rol, tipoDocumento, telefono, "", numeroDocumento);

            // Llamar al método del DAO para actualizar el usuario
            DAdministrarUs daoActualizarUs = new DAdministrarUs();
            boolean actualizacionExitosa = daoActualizarUs.actualizarUsuario(usuarioActualizado);

            if (actualizacionExitosa) {
                JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar usuario. Por favor, inténtalo de nuevo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario de la tabla para editar");
        }
    }
    
    private void eliminarUsuario() {
        if (usuarioSeleccionado != null) {
            // Llamar al método del DAO para eliminar el usuario
            DAdministrarUs daoEliminarUs = new DAdministrarUs();
            boolean eliminacionExitosa = daoEliminarUs.eliminarUsuario(usuarioSeleccionado.getNumeroDoc());

            if (eliminacionExitosa) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar usuario. Por favor, inténtalo de nuevo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario de la tabla para eliminar");
        }
    }
    
    private void mostrarUsuariosEnTabla() {
        DAdministrarUs dao = new DAdministrarUs();
        List<Usuario> usuarios = dao.obtenerTodosUsuarios();
        
        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) vista.tblEmpleados.getModel();
        
        // Limpiar la tabla antes de agregar los nuevos datos
        modelo.setRowCount(0);
        
        // Agregar cada usuario a la tabla
        for (Usuario usuario : usuarios) {
            Object[] fila = {
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getCorreoElectronico(),
                usuario.getContraseña(),
                usuario.getRol(),
                usuario.getTipoDocumento(),
                usuario.getNumeroDoc(),
                usuario.getTelefono(),
                usuario.getImagen()
            };
            modelo.addRow(fila);
        }
    }
    
    private void actualizarVista() {
        Administrador_RegistrarUsers RegisU = new Administrador_RegistrarUsers();
        CAdministrador_RegistrarUser controlador = new CAdministrador_RegistrarUser(RegisU, menu);
        menu.PrincipalAdministrador.removeAll();
        menu.PrincipalAdministrador.setLayout(new BorderLayout());
        menu.PrincipalAdministrador.add(RegisU.getContentPane(), BorderLayout.CENTER);
        menu.PrincipalAdministrador.revalidate();
        menu.PrincipalAdministrador.repaint();
    }
}
