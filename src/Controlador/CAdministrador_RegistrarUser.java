package Controlador;
import Dao.DAdministrarUs;
import Modelo.Usuario;
import VistaAdministrador.Administrador;
import VistaAdministrador.Administrador_RegistrarUsers;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
                seleccionarUsuarioTabla();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            registrarNuevoUsuario();
            //actualizarVista(); //no descomentar
        } else if (e.getSource() == vista.btnBorrar) {
            eliminarUsuario();
            actualizarVista();
        } else if (e.getSource() == vista.btnEditar) {
            actualizarUsuario();
            actualizarVista();
        } else if (e.getSource() == vista.btnSeleccionarImagen) {
            seleccionarImagen();
        }
        mostrarUsuariosEnTabla();
    }

    
    ////////////////////////////////////////////////////////////////////////////////////////
    //Procesos
    ////////////////////////////////////////////////////////////////////////////////////////
    
    //1. SELECCIONAR USUARIO EN LA TABLA
    private void seleccionarUsuarioTabla() {
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
            String numeroDocumento = modelo.getValueAt(filaSeleccionada, 6).toString();
            String telefono = modelo.getValueAt(filaSeleccionada, 7).toString();
            byte[] imagenBytes = (byte[]) modelo.getValueAt(filaSeleccionada, 8);

            // Mostrar los datos en los campos de texto y combobox
            vista.jtxtNombres.setText(nombres);
            vista.jtxtApellidos.setText(apellidos);
            vista.jtxtCorreo.setText(correo);
            vista.jtxtContraseña.setText(contraseña);
            vista.jcbxTipoEmpleado.setSelectedItem(rol);
            vista.jcbxTipoDoc.setSelectedItem(tipoDocumento);
            vista.jtxtNumDocumento.setText(numeroDocumento);
            vista.jtxtTelefono.setText(telefono);

            // Mostrar la imagen en un JLabel
            ImageIcon imagenIcono = new ImageIcon(imagenBytes);
            Image imagenEscalada = imagenIcono.getImage().getScaledInstance(vista.jlblImagen.getWidth(), vista.jlblImagen.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada);
            vista.jlblImagen.setIcon(imagenEscaladaIcono);

            // Guardar el usuario seleccionado
            usuarioSeleccionado = new Usuario(nombres, apellidos, correo, contraseña, rol, tipoDocumento, Integer.parseInt(numeroDocumento), telefono, imagenBytes);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario de la tabla para editar");
        }
    }

    //2. REGISTRAR NUEVO USUARIO
    private void registrarNuevoUsuario() {
        // Obtener los datos ingresados por el usuario
        String nombres = vista.jtxtNombres.getText();
        String apellidos = vista.jtxtApellidos.getText();
        String correo = vista.jtxtCorreo.getText();
        String contraseña = vista.jtxtContraseña.getText();
        String rol = (String) vista.jcbxTipoEmpleado.getSelectedItem();
        String tipoDocumento = (String) vista.jcbxTipoDoc.getSelectedItem();
        String numeroDocumento = vista.jtxtNumDocumento.getText();
        String telefono = vista.jtxtTelefono.getText();
        byte[] imagenBytes = obtenerBytesDeImagen();
        
        //validaciones :D
            //Validar documento de identidad VALIDACIONES EN EL PUNTO "9"...... 9.5 
                int cantidadDeDigitos=numeroDocumento.length();//obtenemos la cantidad de digitos del documento
                if (tipoDocumento.equals("DNI") || tipoDocumento.equals("Carnet de Extranjeria")) {
                    // Validar que el número de documento tenga 8 dígitos
                    if (numeroDocumento.length() != 8) {
                        JOptionPane.showMessageDialog(null, "El número de documento debe tener 8 dígitos tiene: [ "+cantidadDeDigitos+" ] digitos.");
                        return; // Detener la ejecución del método
                    }
                } else if (tipoDocumento.equals("Pasaporte")) {
                    // No aplicar ninguna validación específica para pasaportes
                }
            //Validar numero de teléfono VALIDACIONES EN EL PUNTO "9"...... 9.6  
                String errorTelefono = validarTelefono(telefono);
                if (errorTelefono != null) {
                    JOptionPane.showMessageDialog(null, errorTelefono);
                    return; // Detener la ejecución del método si la validación falla
                }
        // Crear un objeto Usuario con los datos obtenidos
        Usuario nuevoUsuario = new Usuario(nombres, apellidos, correo, contraseña, rol, tipoDocumento, Integer.parseInt(numeroDocumento), telefono, imagenBytes);

        // Llamar al método del DAO para registrar el nuevo usuario
        DAdministrarUs daoRegistrarUs = new DAdministrarUs();
        boolean registroExitoso = daoRegistrarUs.registrarUsuario(nuevoUsuario);

        if (registroExitoso) {
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario. Por favor, inténtalo de nuevo.");
        }
        
        //falta recargar la vista
        //actualizarVista();
    }
    
    //3. ACTUALIZAR USUARIO
    private void actualizarUsuario() {
    if (usuarioSeleccionado != null) {
        // Obtener los datos actualizados del usuario
        String nombres = vista.jtxtNombres.getText();
        String apellidos = vista.jtxtApellidos.getText();
        String correo = vista.jtxtCorreo.getText();
        String contraseña = vista.jtxtContraseña.getText();
        String rol = (String) vista.jcbxTipoEmpleado.getSelectedItem();
        String tipoDocumento = (String) vista.jcbxTipoDoc.getSelectedItem();
        String numeroDocumento = vista.jtxtNumDocumento.getText();
        String telefono = vista.jtxtTelefono.getText();
        byte[] imagenBytes = null; // Inicializar como null por defecto

        // Si se ha seleccionado una imagen nueva, actualizarla
        if (!vista.jlblImagen.getText().isEmpty()) {
            imagenBytes = obtenerBytesDeImagen();
        } else {
            // Si no se selecciona una nueva imagen, mantener la imagen actual
            imagenBytes = usuarioSeleccionado.getImagenBytes();
        }

        // Crear un objeto Usuario con los datos actualizados
        Usuario usuarioActualizado = new Usuario(nombres, apellidos, correo, contraseña, rol, tipoDocumento, Integer.parseInt(numeroDocumento), telefono, imagenBytes);

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

    //4. ELIMINAR USUARIO DE LA BD
    private void eliminarUsuario() {
        if (usuarioSeleccionado != null) {
            // Llamar al método del DAO para eliminar el usuario
            DAdministrarUs daoEliminarUs = new DAdministrarUs();
            boolean eliminacionExitosa = daoEliminarUs.eliminarUsuario(usuarioSeleccionado.getNumeroDocumento());

            if (eliminacionExitosa) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar usuario. Por favor, inténtalo de nuevo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario de la tabla para eliminar");
        }
    }

    //5. OBTENER IMAGEN
    private byte[] obtenerBytesDeImagen() {
        try {
            String rutaImagen = vista.jlblImagen.getText(); // Obtener la ruta del archivo desde el JTextField (o JLabel)
            File archivoImagen = new File(rutaImagen);
            FileInputStream fis = new FileInputStream(archivoImagen);
            byte[] buffer = new byte[(int) archivoImagen.length()];
            fis.read(buffer);
            fis.close();
            return buffer;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener bytes de la imagen: " + e.getMessage());
            return null;
        }
    }

    //6. MOSTRAR LOS USUARIOS DE LA TABLA (EN EL 1 SE SELECCIONAN... ACA SE MUESTRAN CUANDO CARGA LA VISTA)
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
                usuario.getNumeroDocumento(),
                usuario.getTelefono(),
                usuario.getImagenBytes()
            };
            modelo.addRow(fila);
        }
    }

    //7. ACTUALIZAR VISTA (CARGA LA VISTA DESPUES DE CUALQUIER CAMBIO)
    private void actualizarVista() {
        Administrador_RegistrarUsers RegisU = new Administrador_RegistrarUsers();
        CAdministrador_RegistrarUser controlador = new CAdministrador_RegistrarUser(RegisU, menu);
        menu.PrincipalAdministrador.removeAll();
        menu.PrincipalAdministrador.setLayout(new BorderLayout());
        menu.PrincipalAdministrador.add(RegisU.getContentPane(), BorderLayout.CENTER);
        menu.PrincipalAdministrador.revalidate();
        menu.PrincipalAdministrador.repaint();
    }
    //8. SELECCIONAR IMAGEN DESDE LA COMPUTADORA :D
    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png", "gif"));
        int resultado = fileChooser.showOpenDialog(vista);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String rutaImagen = archivoSeleccionado.getAbsolutePath();

            // Mostrar la imagen seleccionada en un JLabel
            ImageIcon imagenIcono = new ImageIcon(rutaImagen);
            Image imagenEscalada = imagenIcono.getImage().getScaledInstance(vista.jlblImagen.getWidth(), vista.jlblImagen.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada);
            vista.jlblImagen.setIcon(imagenEscaladaIcono);

            // Actualizar la ruta del archivo en el JTextField (o JLabel) para poder usarla en obtenerBytesDeImagen
            vista.jlblImagen.setText(rutaImagen);
        }
    }
    //9. VALIDACIONES
    //9.1 VALIDAR NOMBRES
    //9.2 VALIDAR APELLIDOS
    //9.3 VALIDAR CORREO ELECTRÓNICO
    //9.4 VALIDAR CONTRASEÑA
    //9.5 VALIDAR DOCUMENTO DE INDENTIDAD
    //9.6 VALIDAR NÚMERO DE TELÉFONO
    private String validarTelefono(String telefono) {
        int cantDigitos=telefono.length();
        // Verificar que el número de teléfono tenga 9 dígitos y empiece con el número 9
        if (!telefono.matches("^9\\d{8}$")) {
            // Validar la longitud del número de teléfono
            if (telefono.length() != 9) {
                return "El número de teléfono debe tener 9 dígitos, tiene: [ "+cantDigitos+" ] digitos.";
            }
            // Validar que el número de teléfono empiece con el número 9
            if (!telefono.startsWith("9")) {
                return "El número de teléfono debe empezar con el número 9.";
            }
        }
        // El número de teléfono es válido
        return null;
    }
    //9.7 VALIDAR TIPO DE ARCHIVO PARA SUBIR LA IMAGEN
    
}
