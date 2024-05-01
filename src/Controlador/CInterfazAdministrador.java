
package Controlador;

import Vista.InterfazAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CInterfazAdministrador implements ActionListener {
    InterfazAdministrador vista;
   
    public CInterfazAdministrador(InterfazAdministrador IAD) {
       vista = IAD;

       IAD.setTitle("InterfazAdministrador");
       IAD.setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
