
package Controlador;
//importar clases
import VistaVentas.Ventas;
import VistaVentas.Ventas_Registro2;

//importar librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class CVentas_Registro  implements ActionListener{
    //inicializar
    Ventas_Registro2 vista;
    Ventas menu;
    
    //constructor
    public CVentas_Registro(Ventas_Registro2 VR, Ventas V){
        vista=VR;
        menu=V;
        
        vista.jtxtBuscarPorNombreProducto.addActionListener(this);
        vista.jtxtBuscarPorID.addActionListener(this);
        vista.jbtnBuscarProductos.addActionListener(this);
        vista.jbtnAgregarProductosVentas.addActionListener(this);
        
                vista.JtableMostraProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = vista.JtableMostraProductos.getSelectedRow();
                if (filaSeleccionada != -1) {
                
                }
            }
        });
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    //Metodos para VENTAS
        private void actualizarVista() {
        Ventas_Registro2 VR = new Ventas_Registro2();
        CVentas_Registro controlador = new CVentas_Registro(VR, menu);
        menu.PrincipalVentas.removeAll();
        menu.PrincipalVentas.setLayout(new BorderLayout());
        menu.PrincipalVentas.add(VR.getContentPane(), BorderLayout.CENTER);
        menu.PrincipalVentas.revalidate();
        menu.PrincipalVentas.repaint();
    
        //hola estoy haciendo prueba desde git hub desk
    }
}
