
package Controlador;
//importar clases
import VistaVentas.Ventas;
import VistaVentas.Ventas_Registro;

//importar librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CVentas_Registro  implements ActionListener{
    //inicializar
    Ventas_Registro vista;
    Ventas menu;
    
    //constructor
    public CVentas_Registro(Ventas_Registro vista, Ventas menu){
        vista=vista;
        menu=menu;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
