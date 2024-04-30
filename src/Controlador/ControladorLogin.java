
package Controlador;

import Vista.Login;
import Vista.RecuperarContraseña;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLogin implements ActionListener {
    
    Login vista;
    Usuario us;
    
    public ControladorLogin(Login login) {
       vista = login;
     
       login.jbtnIniciarSesion.addActionListener(this);
       login.jbtnRecuperarContraseña.addActionListener(this);
       login.setTitle("LOGIN");
       login.setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
                if (e.getSource() == vista.jbtnRecuperarContraseña) {   
                        RecuperarContraseña rc = new RecuperarContraseña();
                        CRecuperarContraseña CRC= new CRecuperarContraseña(rc);
                }
    }
    
}
