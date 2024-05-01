
package Controlador;

import Modelo.Usuario;
import Vista.Login;
import Vista.RecuperarContraseña;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CRecuperarContraseña implements ActionListener {
        RecuperarContraseña vista;
        Usuario us;
    
    public CRecuperarContraseña(RecuperarContraseña recu) {
       vista = recu;
     
       recu.jbtnVolverAtras.addActionListener(this);
       recu.jbtnEnviarCodigo.addActionListener(this);
       recu.setTitle("RECUPERACION DE CONTRASEÑA");
       recu.setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
                if (e.getSource() == vista.jbtnVolverAtras) {   
                        Login lo = new Login();
                        ControladorLogin CLO = new ControladorLogin(lo);
                        vista.dispose();
                }
    }
}
