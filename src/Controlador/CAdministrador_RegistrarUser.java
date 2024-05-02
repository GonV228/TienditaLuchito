
package Controlador;

import Dao.DAdministrarUs;
import VistaAdministrador.Administrador;
import VistaAdministrador.Administrador_RegistrarUsers;
import Modelo.Usuario;
import VistaAdministrador.MenuAdministrador;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class CAdministrador_RegistrarUser implements ActionListener {
    Administrador_RegistrarUsers vista;
    Administrador menu;

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
        vista.jcbxTipoEmpleado.addActionListener(this);
        vista.jcbxTipoDoc.addActionListener(this);
        vista.jtxtNumDocumento.addActionListener(this);
        vista.jtxtTelefono.addActionListener(this);
        vista.jtxtToken.addActionListener(this);
        
        // Inicializar JComboBox para roles y tipos de documento
        String[] roles = {"Administrador", "Empleado"};
        vista.jcbxTipoEmpleado.setModel(new DefaultComboBoxModel<>(roles));

        String[] tiposDocumento = {"DNI", "Pasaporte", "Carné de Extranjería"};
        vista.jcbxTipoDoc.setModel(new DefaultComboBoxModel<>(tiposDocumento));
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
        String imagen = ""; // No se obtiene en esta parte del código
        String token = vista.jtxtToken.getText();


        // Crear un objeto Usuario con los datos obtenidos
 Usuario nuevoUsuario = new Usuario(nombres, apellidos, contraseña, correo, rol, tipoDocumento, telefono, imagen, numeroDocumento, token);

        // Llamar al método del DAO para registrar el nuevo usuario
        DAdministrarUs daoRegistrarUs = new DAdministrarUs();
        boolean registroExitoso = daoRegistrarUs.registrarUsuario(nuevoUsuario);

        if (registroExitoso) {
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario. Por favor, inténtalo de nuevo.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
        System.out.println("aceptar");
        registrarNuevoUsuario();
           Administrador_RegistrarUsers RegisU=new Administrador_RegistrarUsers();
           CAdministrador_RegistrarUser controlador=new CAdministrador_RegistrarUser(RegisU, menu);
           menu.PrincipalAdministrador.removeAll();
           menu.PrincipalAdministrador.setLayout(new BorderLayout());
           menu.PrincipalAdministrador.add(RegisU.getContentPane(),BorderLayout.CENTER);
           menu.PrincipalAdministrador.revalidate();
           menu.PrincipalAdministrador.repaint();
        }
        
    }
}
