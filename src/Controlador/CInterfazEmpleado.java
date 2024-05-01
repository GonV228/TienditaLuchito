
package Controlador;

import VistaEmpleado.MenuEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CInterfazEmpleado implements ActionListener{
    MenuEmpleado vista;
        public CInterfazEmpleado(MenuEmpleado IE) {
       vista = IE;

       IE.setTitle("InterfazEmpleado");
       IE.setVisible(true);
    }
@Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
