
package Controlador;

import Vista.InterfazEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CInterfazEmpleado implements ActionListener{
    InterfazEmpleado vista;
        public CInterfazEmpleado(InterfazEmpleado IE) {
       vista = IE;

       IE.setTitle("InterfazEmpleado");
       IE.setVisible(true);
    }
@Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
