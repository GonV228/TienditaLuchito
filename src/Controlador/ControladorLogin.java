package Controlador;

import Dao.DLogin;
import VistaLogin.Login;
import VistaLogin.RecuperarContraseña;
import VistaAdministrador.MenuAdministrador;
import VistaEmpleado.MenuEmpleado;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener {
    
    Login vista;
    Usuario usuario; 
    DLogin dLogin; 
    
    public ControladorLogin(Login login) {
       vista = login;
       dLogin = new DLogin(); // Inicializado el objeto "dLogin"
     
       login.jbtnIniciarSesion.addActionListener(this);
       login.jbtnRecuperarContraseña.addActionListener(this);
       login.setTitle("LOGIN");
       login.setVisible(true);
       login.setLocationRelativeTo(null);//centra la vista :D
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnIniciarSesion) {
            String correo = vista.jtxtfIngresaCorreo.getText();
            String contraseña = vista.jtxtfContraseña.getText();
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////           
            // Verificar el inicio de sesión en la base de datos
            //usuario = new Usuario("", "", contraseña, correo, "", "", 0, "", 0, ""); // Creación del objeto "usuario" con valores vacíos
            
        // String rol = dLogin.obtenerRolUsuario(usuario); // Usando el objeto "dLogin" en lugar de "dao"
String rol="Empleado";            

            if (rol != null) {
                // El usuario existe y tiene un rol asignado
                if (rol.equals("Administrador")) {
            MenuAdministrador rc = new MenuAdministrador();
            CMenuAdministrador CMA = new CMenuAdministrador(rc);
            vista.dispose(); // Cerrar la ventana de inicio de sesión

                } else if (rol.equals("Empleado")) {
                    MenuEmpleado IE = new MenuEmpleado();
                    CMenuEmpleado CIE = new CMenuEmpleado(IE);  //DEJA ESTE ERROR AHI UN MOMENTO///////////////////////////////////////////////////////
                    vista.dispose(); // Cerrar la ventana de inicio de sesión
                }
            } else {
            JOptionPane.showMessageDialog(vista, "El usuario no está registrado en la base de datos.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
        } 
        if (e.getSource() == vista.jbtnRecuperarContraseña) {   
            RecuperarContraseña rc = new RecuperarContraseña();
            CRecuperarContraseña CRC = new CRecuperarContraseña(rc);
            vista.dispose(); // Cerrar la ventana de inicio de sesión
        }
    }
}