
package Controlador;
//importar clases
import static Controlador.CAdministrador_RegistrarUser.validarContrasena;
import Dao.DLogin;
import Modelo.Usuario;
import VistaLogin.Login;
import VistaLogin.Recuperar_2Codigo;
import VistaLogin.Recuperar_3Contraseña;
//ijmportar librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CRecuperar_3Contraseña implements ActionListener{
    //inicializar 
    Recuperar_3Contraseña vista;
    String correoElec;
    
    //constructor
    public CRecuperar_3Contraseña (Recuperar_3Contraseña vistaRecuperar, String correo ){
        this.correoElec=correo;
        vista=vistaRecuperar;
        vistaRecuperar.jtxtfContraseña.addActionListener(this);
        vistaRecuperar.jtxtfContraseña1.addActionListener(this);
        vistaRecuperar.jbtnCancelar.addActionListener(this);
        vistaRecuperar.jbtnReestablecer.addActionListener(this);
        
        vistaRecuperar.setVisible(true);
        vistaRecuperar.setTitle("Recuperar contraseña");
        vistaRecuperar.setLocationRelativeTo(null);
        System.out.println(correoElec);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.jbtnCancelar){
            Login vistaLogin=new Login();
            ControladorLogin controlador=new ControladorLogin(vistaLogin);
            vista.dispose();
        }
        
        if(e.getSource()==vista.jbtnReestablecer){
            boolean exito=registrarContraseña();
            if(exito){
                Login vistaLogin =new Login();
                ControladorLogin controlador=new ControladorLogin(vistaLogin);
                vista.dispose();
            }
        }
        
        
        
    }
    
    private boolean registrarContraseña(){
        //instanciamos para actualizar la contraseña
        DLogin daoActualizarContra=new DLogin();
        //Obtenemos las contraseñas del formulario
        String contraseña=vista.jtxtfContraseña.getText();
        String contraseña2=vista.jtxtfContraseña1.getText();
        //validar nivel de contraseña
        String mensaje=validarContrasena(contraseña);
        if(!mensaje.equals("La contraseña es válida.")){
            JOptionPane.showMessageDialog(null, mensaje, "Validación de Contraseña", JOptionPane.INFORMATION_MESSAGE);
            return false;//detener la ejecucion para que el usuario corrija 
        }
        // Validar que ambas contraseñas coincidan
        if (!contraseña.equals(contraseña2)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.", "Error de validación", JOptionPane.INFORMATION_MESSAGE);
            return false; // Detener la ejecución
        }
        // Crear un objeto Usuario con la nueva contraseña y el correo electrónico
        Usuario usuario = new Usuario();
        usuario.setContraseña(contraseña);
        usuario.setCorreoElectronico(correoElec); // Asegúrate de tener el correo disponible

        // Actualizar la contraseña en la base de datos
        boolean actualizado=daoActualizarContra.reestablecerContraseña(usuario); // Asegúrate de tener el correo disponible
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente.", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar la contraseña.", "Error de actualización", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    
}
