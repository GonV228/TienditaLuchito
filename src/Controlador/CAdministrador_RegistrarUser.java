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
    private int idUsuarioSeleccionado;

    public CAdministrador_RegistrarUser(Administrador_RegistrarUsers adminRegis, Administrador Admin) {
        vista = adminRegis;
        menu = Admin;
        vista.btnAgregar.addActionListener(this);
        vista.btnBorrar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnLimpiarCampos.addActionListener(this);
        vista.btnSeleccionarImagen.addActionListener(this);
        vista.btnValidarContraseña.addActionListener(this);
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
            //actualizarVista(); //no descomentar
        } else if (e.getSource() == vista.btnSeleccionarImagen) {
            seleccionarImagen();
        } else if (e.getSource() == vista.btnLimpiarCampos){
            actualizarVista();
        }
        mostrarUsuariosEnTabla();
        if(e.getSource()==vista.jtxtContraseña||e.getSource()==vista.btnValidarContraseña){
            String contraseña=vista.jtxtContraseña.getText();
            String mensaje=validarContrasena(contraseña);
            JOptionPane.showMessageDialog(null, mensaje, "Validación de Contraseña", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
    ////////////////////////////////////////////////////////////////////////////////////////
    //Procesos
    ////////////////////////////////////////////////////////////////////////////////////////
    
    //1. SELECCIONAR USUARIO EN LA TABLA
    private void seleccionarUsuarioTabla() {
        DAdministrarUs buscarId=new DAdministrarUs();
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

            int id=buscarId.existeUsuarioConDocumentoExcluyendoActual(numeroDocumento); //aqui estoy int id
            System.out.println("id con fe: "+id);
            // Guardar el ID del usuario seleccionado en la variable de clase
            idUsuarioSeleccionado = id;
            // Mostrar la imagen en un JLabel
            ImageIcon imagenIcono = new ImageIcon(imagenBytes);
            Image imagenEscalada = imagenIcono.getImage().getScaledInstance(vista.jlblImagen.getWidth(), vista.jlblImagen.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada);
            vista.jlblImagen.setIcon(imagenEscaladaIcono);

            // Guardar el usuario seleccionado
            usuarioSeleccionado = new Usuario(id, nombres, apellidos, correo, contraseña, rol, tipoDocumento, Integer.parseInt(numeroDocumento), telefono, imagenBytes);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario de la tabla para editar");
        }
    }

    //2. REGISTRAR NUEVO USUARIO
    private void registrarNuevoUsuario() {
        //instanciamos DAO para administrar los usuarios
        DAdministrarUs daoRegistrarUs = new DAdministrarUs();
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
        
            // Validar que no haya campos vacíos
                if (nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || contraseña.isEmpty() ||
                    tipoDocumento.isEmpty() || numeroDocumento.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos para registrar un nuevo usuario.","Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
                    return; // Detener la ejecución del método si hay campos vacíos
                }
            //Validar nombres 9.1
                String nameValid=validarNombre(nombres);
                if(nameValid != null){
                    JOptionPane.showMessageDialog(null, nameValid, "Validación de Nombre", JOptionPane.INFORMATION_MESSAGE);
                    return;//detener la ejecucion para que el usuario corrija
                }
            //Validar Apellidos 9.2
                String addressValid=validarApellido(apellidos);
                if(addressValid!= null){
                    JOptionPane.showMessageDialog(null, addressValid, "Validación de Apellido", JOptionPane.INFORMATION_MESSAGE);
                    return;//detener la ejecucion para que el usuario corrija
                }    
            //Validar Correo electronico 9.3
            //Validar contraseña 9.4
                String mensaje=validarContrasena(contraseña);
                if(mensaje!=null){
                    JOptionPane.showMessageDialog(null, mensaje, "Validación de Contraseña", JOptionPane.INFORMATION_MESSAGE);
                    //return;//detener la ejecucion para que el usuario corrija
                }
            //Validar documento de identidad VALIDACIONES EN EL PUNTO "9"...... 9.5 
                int cantidadDeDigitos=numeroDocumento.length();//obtenemos la cantidad de digitos del documento
                if (tipoDocumento.equals("DNI") || tipoDocumento.equals("Carnet de Extranjeria")) {
                    // Validar que el número de documento tenga 8 dígitos
                    if (numeroDocumento.length() != 8) {
                        JOptionPane.showMessageDialog(null, "El número de documento debe tener 8 dígitos tiene: [ "+cantidadDeDigitos+" ] digitos.","Validación de Nº de Documento", JOptionPane.INFORMATION_MESSAGE);
                        return; // Detener la ejecución del método
                    }
                } else if (tipoDocumento.equals("Pasaporte")) {
                    // No aplicar ninguna validación específica para pasaportes
                }
                // Verificar si ya existe un usuario con el número de documento especificado
                if (daoRegistrarUs.existeUsuarioConDocumento(numeroDocumento)) {
                    JOptionPane.showMessageDialog(null, "El número de documento ya está en uso. Ingrese otro número de documento", "Validación de Número de Documento", JOptionPane.INFORMATION_MESSAGE);
                    return; // Detener la ejecución del método si el número de documento ya está en uso
                }
            //Validar numero de teléfono VALIDACIONES EN EL PUNTO "9"...... 9.6  
                String errorTelefono = validarTelefono(telefono);
                if (errorTelefono != null) {
                    JOptionPane.showMessageDialog(null, errorTelefono, "Validación de Nº de Teléfono", JOptionPane.INFORMATION_MESSAGE);
                    return; // Detener la ejecución del método si la validación falla
                }
        // Crear un objeto Usuario con los datos obtenidos
        Usuario nuevoUsuario = new Usuario(nombres, apellidos, correo, contraseña, rol, tipoDocumento, Integer.parseInt(numeroDocumento), telefono, imagenBytes);

        // Llamar al método del DAO para registrar el nuevo usuario

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
        //instanciamos DAO para administrar los usuarios
        DAdministrarUs daoActualizar = new DAdministrarUs();
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

        
        //VALIDACIONES 
            // Validar que no haya campos vacíos
                if (nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || contraseña.isEmpty() ||
                    tipoDocumento.isEmpty() || numeroDocumento.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos para registrar un nuevo usuario.","Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
                    return; // Detener la ejecución del método si hay campos vacíos
                }
            //Validar nombres 9.1
                String nameValid=validarNombre(nombres);
                if(nameValid != null){
                    JOptionPane.showMessageDialog(null, nameValid, "Validación de Nombre", JOptionPane.INFORMATION_MESSAGE);
                    return;//detener la ejecucion para que el usuario corrija
                }
            //Validar Apellidos 9.2
                String addressValid=validarApellido(apellidos);
                if(addressValid!= null){
                    JOptionPane.showMessageDialog(null, addressValid, "Validación de Apellido", JOptionPane.INFORMATION_MESSAGE);
                    return;//detener la ejecucion para que el usuario corrija
                }    
            //Validar Correo electronico 9.3
            //Validar contraseña 9.4
                String mensaje=validarContrasena(contraseña);
                if(mensaje!=null){
                    JOptionPane.showMessageDialog(null, mensaje, "Validación de Contraseña", JOptionPane.INFORMATION_MESSAGE);
                    //return;//detener la ejecucion para que el usuario corrija
                }
            //Validar documento de identidad VALIDACIONES EN EL PUNTO "9"...... 9.5 
                int cantidadDeDigitos=numeroDocumento.length();//obtenemos la cantidad de digitos del documento
                if (tipoDocumento.equals("DNI") || tipoDocumento.equals("Carnet de Extranjeria")) {
                    // Validar que el número de documento tenga 8 dígitos
                    if (numeroDocumento.length() != 8) {
                        JOptionPane.showMessageDialog(null, "El número de documento debe tener 8 dígitos tiene: [ "+cantidadDeDigitos+" ] digitos.","Validación de Nº de Documento", JOptionPane.INFORMATION_MESSAGE);
                        return; // Detener la ejecución del método
                    }
                } else if (tipoDocumento.equals("Pasaporte")) {
                    // No aplicar ninguna validación específica para pasaportes
                }
                // Verificar si ya existe un usuario con el número de documento especificado
                // excluyendo al usuario actualmente seleccionado
                if (daoActualizar.existeUsuarioConDocumento2(numeroDocumento, idUsuarioSeleccionado)) {//y aca debo traer el valor de id
                    JOptionPane.showMessageDialog(null, "El número de documento ya está en uso. Ingrese otro número de documento", "Validación de Número de Documento", JOptionPane.INFORMATION_MESSAGE);
                    return; // Detener la ejecución del método si el número de documento ya está en uso
                }

            //Validar numero de teléfono VALIDACIONES EN EL PUNTO "9"...... 9.6  
                String errorTelefono = validarTelefono(telefono);
                if (errorTelefono != null) {
                    JOptionPane.showMessageDialog(null, errorTelefono, "Validación de Nº de Teléfono", JOptionPane.INFORMATION_MESSAGE);
                    return; // Detener la ejecución del método si la validación falla
                }
            
        // Crear un objeto Usuario con los datos actualizados
        Usuario usuarioActualizado = new Usuario( usuarioSeleccionado.getId(),nombres, apellidos, correo, contraseña, rol, tipoDocumento, Integer.parseInt(numeroDocumento), telefono, imagenBytes);

        // Llamar al método del DAO para actualizar el usuario
        boolean actualizacionExitosa = daoActualizar.actualizarUsuario(usuarioActualizado);

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
            JOptionPane.showMessageDialog(null, "Error al obtener bytes de la imagen: " + e.getMessage(),"Error al obtener la imagen", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }

    //6. MOSTRAR LOS USUARIOS DE LA TABLA (EN EL 1 SE SELECCIONAN... ACA SE MUESTRAN CUANDO CARGA LA VISTA)
    private void mostrarUsuariosEnTabla() {
        DAdministrarUs dao = new DAdministrarUs();
        List<Usuario> usuarios = dao.obtenerTodosUsuarios();

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) vista.tblEmpleados.getModel();
        
        // Iterar sobre las columnas y establecer el editor como null para hacerlas no editables
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            vista.tblEmpleados.setDefaultEditor(modelo.getColumnClass(i), null);
        }
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
        private static String validarNombre(String nombre) {
            StringBuilder mensaje = new StringBuilder();
            String texto="Nombre propio: ";
            int cont=0;
            // Dividir el nombre en palabras
            String[] palabras = nombre.split("\\s+");
            // Validar cada palabra
            for (String palabra : palabras) {
                // Verificar si la primera letra es mayúscula
                if (!Character.isUpperCase(palabra.charAt(0))) {
                    mensaje.append("Primera letra en mayúscula. ");
                    cont++;
                }
                // Verificar si el resto de las letras son minúsculas
                for (int i = 1; i < palabra.length(); i++) {
                    if (!Character.isLowerCase(palabra.charAt(i))) {
                        mensaje.append("Despues de la primera letra en minúscula.");
                        cont++;
                    }
                }
            }
            if(cont==0){
                return null;//"Nombre valido";
            }else{ 
                return texto+mensaje.toString();
            }
        }
    //9.2 VALIDAR APELLIDOS
        private static String validarApellido(String nombre) {
            StringBuilder mensaje = new StringBuilder();
            String texto="Los apellidos son nombres propios: ";
            int cont=0;
            // Dividir el nombre en palabras
            String[] palabras = nombre.split("\\s+");
            // Validar cada palabra
            for (String palabra : palabras) {
                // Verificar si la primera letra es mayúscula
                if (!Character.isUpperCase(palabra.charAt(0))) {
                    mensaje.append("Primera letra en mayúscula. ");
                    cont++;
                }
                // Verificar si el resto de las letras son minúsculas
                for (int i = 1; i < palabra.length(); i++) {
                    if (!Character.isLowerCase(palabra.charAt(i))) {
                        if(i==1){
                        mensaje.append("Despues de la primera letra en minúscula.");
                        }
                        cont++;
                    }
                }
            }
            if(cont==0){
                return null;//"Apellido valido";
            }else{ 
                return texto+mensaje.toString();
            }
        }
    //9.3 VALIDAR CORREO ELECTRÓNICO
    //9.4 VALIDAR CONTRASEÑA
        public static String validarContrasena(String contrasena) {
            // Comprobar si contiene al menos un símbolo especial, un número, una letra mayúscula y una letra minúscula
            boolean contieneSimboloEspecial = contrasena.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
            boolean contieneNumero = contrasena.matches(".*\\d.*");
            boolean contieneLetraMayuscula = contrasena.matches(".*[A-Z].*");
            boolean contieneLetraMinuscula = contrasena.matches(".*[a-z].*");

            String texto="La contraseña debe contener al menos ";
            StringBuilder mensaje = new StringBuilder();
            // Comprobar la longitud mínima de 8 caracteres
            if (contrasena.length() < 8) {
                mensaje.append( "8 caracteres. ");
            }
            if (!contieneSimboloEspecial) {
                mensaje.append("Un símbolo especial. ");
            }
            if (!contieneNumero) {
                mensaje.append("Un número. ");
            }
            if (!contieneLetraMayuscula) {
                mensaje.append("Una letra mayúscula. ");
            }
            if (!contieneLetraMinuscula) {
                mensaje.append("Una letra minúscula. ");
            }

            if (mensaje.length() == 0) {
                return "La contraseña es válida.";
            } else {
                return texto+mensaje.toString();
            }
        }
    //9.5 VALIDAR DOCUMENTO DE INDENTIDAD
        //ya esta el codigo 
    //9.6 VALIDAR NÚMERO DE TELÉFONO
        private String validarTelefono(String telefono) {
            int cont=0;
            int cantDigitos=telefono.length();
            String texto="\"El número de teléfono debe: ";
            StringBuilder mensaje = new StringBuilder();
            // Verificar que el número de teléfono tenga 9 dígitos y empiece con el número 9
            if (!telefono.matches("^9\\d{8}$")) {
                // Validar la longitud del número de teléfono
                if (telefono.length() != 9) {
                    mensaje.append("Tener 9 dígitos, tiene: [ "+cantDigitos+" ] digitos.") ;
                    cont++;
                }
                // Validar que el número de teléfono empiece con el número 9
                if (!telefono.startsWith("9")) {
                    mensaje.append(" Empezar con el número 9");
                    cont++;
                }
            }
            if(cont==0){
                return null; //el numero no entro en ninguna condicional anterior por lo tanto mandaremos null
            }else{
                // El número de teléfono es válido
                return texto+mensaje.toString();
            }
            
        }
    //9.7 VALIDAR TIPO DE ARCHIVO PARA SUBIR LA IMAGEN
        
}
