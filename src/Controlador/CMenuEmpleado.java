
package Controlador;
//importar clases
import VistaEmpleado.MenuEmpleado;
import VistaInventario.Inventario;
import VistaLogin.Login;
import VistaVentas.Ventas;
//importar librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CMenuEmpleado implements ActionListener{
    //inicializar
    MenuEmpleado vista;
    //inicializar el dao para poder traer al menu los datos del usuario que inicia sesion
    
    //constructor
    public CMenuEmpleado(MenuEmpleado menu){
        vista=menu;
        menu.setVisible(true);
        menu.setTitle("Administrador");
        menu.setLocationRelativeTo(null); //centrar ventana
        vista.jbtnInventario.addActionListener(this);
        vista.jbtnVentas.addActionListener(this);
        vista.jbtnCerrarSesion.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //INVENTARIO
        if(e.getSource()==vista.jbtnInventario){
            Inventario vistaInve=new Inventario();
            CInventario controlador=new CInventario(vistaInve);
            vista.PrincipalMenu.removeAll();
            vista.PrincipalMenu.setLayout(new BorderLayout());
            vista.PrincipalMenu.add(vistaInve.getContentPane(),BorderLayout.CENTER);
            vista.PrincipalMenu.revalidate();
            vista.PrincipalMenu.repaint();
        }
        //VENTAS
        if(e.getSource()==vista.jbtnVentas){
            Ventas vistaVen=new Ventas();
            CVentas controlador=new CVentas(vistaVen);
        }
                //CERRAR SESIÓN
        if(e.getSource()==vista.jbtnCerrarSesion){
            Login vistaLogin=new Login();
            ControladorLogin controlador=new ControladorLogin(vistaLogin);
            vista.dispose();
        }
        
        
    }
    
    
}
