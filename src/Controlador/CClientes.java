package Controlador;
//Importar clases

import Dao.DCliente;
import Modelo.Cliente;
import VistaAdministrador.Administrador;
import VistaRegistrarPersonasExternas.Clientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//importar librerias
public class CClientes implements ActionListener {

    //inicializar
    Clientes vista;
    Cliente cli;
    Administrador adm;
    Cliente clienteSeleccionado;
    private int idClienteSeleccionado;

    //constructor
    public CClientes(Clientes regisClientes, Administrador menu) {
        vista = regisClientes;
        adm = menu;
        vista.btnAgregar.addActionListener(this);
        vista.btnBorrar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnLimpiarCampos.addActionListener(this);
        // Inicializar JComboBox para roles y tipos de documento
        String[] genero = {"M", "F"};
        vista.jcbxTipoEmpleado.setModel(new DefaultComboBoxModel<>(genero));
        // Mostrar los usuarios en la tabla
        mostrarClientesEnTabla();
        vista.tblEmpleados1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionarClienteTabla();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            registrarNuevoUsuario();
        } else if (e.getSource() == vista.btnEditar) {
            actualizarCliente();
        } else if (e.getSource() == vista.btnBorrar) {
            eliminarCliente();
        } else if (e.getSource() == vista.btnLimpiarCampos) {
            limpiarcampos();
        }
        mostrarClientesEnTabla();
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    //Procesos
    ////////////////////////////////////////////////////////////////////////////////////////
    //1. SELECCIONAR USUARIO EN LA TABLA
    private void seleccionarClienteTabla() {
        DCliente buscarId = new DCliente();
        int filaSeleccionada = vista.tblEmpleados1.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) vista.tblEmpleados1.getModel();
            // Obtener los datos de la fila seleccionada
            String numeroDocumento = modelo.getValueAt(filaSeleccionada, 0).toString();
            String nombres = modelo.getValueAt(filaSeleccionada, 1).toString();
            String apellidos = modelo.getValueAt(filaSeleccionada, 2).toString();
            String edad = modelo.getValueAt(filaSeleccionada, 3).toString();
            String genero = modelo.getValueAt(filaSeleccionada, 4).toString();
            String telefono = modelo.getValueAt(filaSeleccionada, 5).toString();
            String correo = modelo.getValueAt(filaSeleccionada, 6).toString();

            // Mostrar los datos en los campos de texto y combobox
            vista.jtxtNombres.setText(nombres);
            vista.jtxtApellidos1.setText(apellidos);
            vista.jtxtNumDocumento.setText(numeroDocumento);
            vista.jtxtApellidos.setText(edad);
            vista.jcbxTipoEmpleado.setSelectedItem(genero);
            vista.jtxtTelefono.setText(telefono);
            vista.jtxtCorreo.setText(correo);

            int id = buscarId.existeClienteConDocumentoExcluyendoActual(numeroDocumento); //aqui estoy int id
            System.out.println("ID: " + id);
            // Guardar el ID del usuario seleccionado en la variable de clase
            idClienteSeleccionado = id;

            // Guardar el usuario seleccionado
            clienteSeleccionado = new Cliente(id, nombres, apellidos, numeroDocumento, Integer.parseInt(edad), genero, telefono, correo);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario de la tabla para editar");
        }
    }

    //2. REGISTRAR NUEVO USUARIO
    private void registrarNuevoUsuario() {
        //instanciamos DAO para administrar los usuarios
        DCliente daoRegistrarUs = new DCliente();
        // Obtener los datos ingresados por el usuario
        String nombres = vista.jtxtNombres.getText();
        String apellidos = vista.jtxtApellidos1.getText();
        String numeroDocumento = vista.jtxtNumDocumento.getText();
        String edad = vista.jtxtApellidos.getText();
        String genero = (String) vista.jcbxTipoEmpleado.getSelectedItem();
        String telefono = vista.jtxtTelefono.getText();
        String correo = vista.jtxtCorreo.getText();
        //byte[] imagenBytes = obtenerBytesDeImagen();

        //validaciones :D
        // Validar que no haya campos vacíos
        if (nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || numeroDocumento.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos para registrar un nuevo usuario.", "Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
            return; // Detener la ejecución del método si hay campos vacíos
        }
        //Validar nombres 9.1
        String nameValid = validarNombre(nombres);
        if (nameValid != null) {
            JOptionPane.showMessageDialog(null, nameValid, "Validación de Nombre", JOptionPane.INFORMATION_MESSAGE);
            return;//detener la ejecucion para que el usuario corrija
        }
        //Validar Apellidos 9.2
        String addressValid = validarApellido(apellidos);
        if (addressValid != null) {
            JOptionPane.showMessageDialog(null, addressValid, "Validación de Apellido", JOptionPane.INFORMATION_MESSAGE);
            return;//detener la ejecucion para que el usuario corrija
        }
        //Validar documento de identidad VALIDACIONES EN EL PUNTO "9"...... 9.5 
        int cantidadDeDigitos = numeroDocumento.length();//obtenemos la cantidad de digitos del documento
        if (numeroDocumento.length() != 8) {
            JOptionPane.showMessageDialog(null, "El número de documento debe tener 8 dígitos tiene: [ " + cantidadDeDigitos + " ] digitos.", "Validación de Nº de Documento", JOptionPane.INFORMATION_MESSAGE);
            return; // Detener la ejecución del método
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
        Cliente nuevoCliente = new Cliente(nombres, apellidos, numeroDocumento, Integer.parseInt(edad), genero, telefono, correo);

        // Llamar al método del DAO para registrar el nuevo usuario
        boolean registroExitoso = daoRegistrarUs.registrarCliente(nuevoCliente);

        if (registroExitoso) {
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
            limpiarcampos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario. Por favor, inténtalo de nuevo.");
        }

        //falta recargar la vista
        //actualizarVista();
    }

    //3. ACTUALIZAR USUARIO
    private void actualizarCliente() {
        if (clienteSeleccionado != null) {
            //instanciamos DAO para administrar los usuarios
            DCliente daoActualizar = new DCliente();
            // Obtener los datos actualizados del usuario
            String nombres = vista.jtxtNombres.getText();
            String apellidos = vista.jtxtApellidos1.getText();
            String documento = vista.jtxtNumDocumento.getText();
            String edad = vista.jtxtApellidos.getText();
            String genero = (String) vista.jcbxTipoEmpleado.getSelectedItem();
            String telefono = vista.jtxtTelefono.getText();
            String correo = vista.jtxtCorreo.getText();

            //VALIDACIONES 
            // Validar que no haya campos vacíos
            if (nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || documento.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos para registrar un nuevo usuario.", "Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
                return; // Detener la ejecución del método si hay campos vacíos
            }
            //Validar nombres 9.1
            String nameValid = validarNombre(nombres);
            if (nameValid != null) {
                JOptionPane.showMessageDialog(null, nameValid, "Validación de Nombre", JOptionPane.INFORMATION_MESSAGE);
                return;//detener la ejecucion para que el usuario corrija
            }
            //Validar Apellidos 9.2
            String addressValid = validarApellido(apellidos);
            if (addressValid != null) {
                JOptionPane.showMessageDialog(null, addressValid, "Validación de Apellido", JOptionPane.INFORMATION_MESSAGE);
                return;//detener la ejecucion para que el usuario corrija
            }
            //Validar Correo electronico 9.3
            //Validar documento de identidad VALIDACIONES EN EL PUNTO "9"...... 9.5 
            int cantidadDeDigitos = documento.length();//obtenemos la cantidad de digitos del documento
            // Validar que el número de documento tenga 8 dígitos
            if (documento.length() != 8) {
                JOptionPane.showMessageDialog(null, "El número de documento debe tener 8 dígitos tiene: [ " + cantidadDeDigitos + " ] digitos.", "Validación de Nº de Documento", JOptionPane.INFORMATION_MESSAGE);
                return; // Detener la ejecución del método
            }
            // Verificar si ya existe un usuario con el número de documento especificado
            // excluyendo al usuario actualmente seleccionado
            if (daoActualizar.existeClienteConDocumento2(documento, idClienteSeleccionado)) {//y aca debo traer el valor de id
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
            Cliente clienteActualizado = new Cliente(clienteSeleccionado.getId(), nombres, apellidos, documento, Integer.parseInt(edad), genero, telefono, correo);

            // Llamar al método del DAO para actualizar el usuario
            boolean actualizacionExitosa = daoActualizar.actualizarCliente(clienteActualizado);

            if (actualizacionExitosa) {
                JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente");
                limpiarcampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar usuario. Por favor, inténtalo de nuevo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario de la tabla para editar");
        }
    }

    //4. ELIMINAR USUARIO DE LA BD
    private void eliminarCliente() {
        if (clienteSeleccionado != null) {
            // Llamar al método del DAO para eliminar el usuario
            DCliente daoEliminarUs = new DCliente();
            boolean eliminacionExitosa = daoEliminarUs.eliminarCliente(clienteSeleccionado.getDocumento());

            if (eliminacionExitosa) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");
                limpiarcampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar usuario. Por favor, inténtalo de nuevo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario de la tabla para eliminar");
        }
    }

    //6. MOSTRAR LOS USUARIOS DE LA TABLA (EN EL 1 SE SELECCIONAN... ACA SE MUESTRAN CUANDO CARGA LA VISTA)
    private void mostrarClientesEnTabla() {
        DCliente dao = new DCliente();
        List<Cliente> clientes = dao.obtenerTodosClientes();

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) vista.tblEmpleados1.getModel();

        // Iterar sobre las columnas y establecer el editor como null para hacerlas no editables
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            vista.tblEmpleados1.setDefaultEditor(modelo.getColumnClass(i), null);
        }
        // Limpiar la tabla antes de agregar los nuevos datos
        modelo.setRowCount(0);

        // Agregar cada cliente a la tabla
        for (Cliente cliente : clientes) {
            Object[] fila = {
                cliente.getDocumento(),
                cliente.getNombres(),
                cliente.getApellidos(),
                cliente.getEdad(),
                cliente.getGenero(),
                cliente.getTelefono(),
                cliente.getCorreo()
            };
            modelo.addRow(fila);
        }
    }

    //9. VALIDACIONES
    //9.1 VALIDAR NOMBRES
    private static String validarNombre(String nombre) {
        StringBuilder mensaje = new StringBuilder();
        String texto = "Nombre propio: ";
        int cont = 0;
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
        if (cont == 0) {
            return null;//"Nombre valido";
        } else {
            return texto + mensaje.toString();
        }
    }

    //9.2 VALIDAR APELLIDOS
    private static String validarApellido(String nombre) {
        StringBuilder mensaje = new StringBuilder();
        String texto = "Los apellidos son nombres propios: ";
        int cont = 0;
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
                    if (i == 1) {
                        mensaje.append("Despues de la primera letra en minúscula.");
                    }
                    cont++;
                }
            }
        }
        if (cont == 0) {
            return null;//"Apellido valido";
        } else {
            return texto + mensaje.toString();
        }
    }

    //9.6 VALIDAR NÚMERO DE TELÉFONO
    private String validarTelefono(String telefono) {
        int cont = 0;
        int cantDigitos = telefono.length();
        String texto = "\"El número de teléfono debe: ";
        StringBuilder mensaje = new StringBuilder();
        // Verificar que el número de teléfono tenga 9 dígitos y empiece con el número 9
        if (!telefono.matches("^9\\d{8}$")) {
            // Validar la longitud del número de teléfono
            if (telefono.length() != 9) {
                mensaje.append("Tener 9 dígitos, tiene: [ " + cantDigitos + " ] digitos.");
                cont++;
            }
            // Validar que el número de teléfono empiece con el número 9
            if (!telefono.startsWith("9")) {
                mensaje.append(" Empezar con el número 9");
                cont++;
            }
        }
        if (cont == 0) {
            return null; //el numero no entro en ninguna condicional anterior por lo tanto mandaremos null
        } else {
            // El número de teléfono es válido
            return texto + mensaje.toString();
        }

    }

    //10. limpiar campos
    private void limpiarcampos() {
        vista.jtxtNombres.setText(null);
        vista.jtxtApellidos.setText(null);
        vista.jtxtApellidos1.setText(null);
        vista.jtxtCorreo.setText(null);
        vista.jtxtTelefono.setText(null);
        vista.jtxtNumDocumento.setText(null);
        vista.jcbxTipoEmpleado.setSelectedIndex(0);
    }
}
