
package Controlador;

import VistaAdministrador.MenuAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CInterfazAdministrador implements ActionListener {
    MenuAdministrador vista;
   
    public CInterfazAdministrador(MenuAdministrador IAD) {
       vista = IAD;

       IAD.setTitle("Vista Administrador");
       IAD.setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
