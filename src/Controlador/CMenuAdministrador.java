
package Controlador;
///importar clases
import VistaLogin.Login;
import VistaAdministrador.MenuAdministrador;
import VistaAdministrador.Administrador;
import VistaInventario.Inventario;
import VistaVentas.Ventas;
import VistaAdministrador.Administrador_RegistrarUsers;

//importar librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CMenuAdministrador implements ActionListener{
    //inicialización
    MenuAdministrador vista;
    //inicialización del dao para poder traer al menu los datos del usuario que inicia sesión
    
    //constructor
    public CMenuAdministrador(MenuAdministrador menu){
        vista=menu;
        menu.setVisible(true);
        menu.setTitle("Administrador");
        menu.setLocationRelativeTo(null); //centrar ventana
        vista.jbtnAdminEmpleados.addActionListener(this);
        vista.jbtnInventario.addActionListener(this);
        vista.jbtnVentas.addActionListener(this);
        vista.jbtnCerrarSesion.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ADMINISTRAR EMPLEADOS
        if(e.getSource()==vista.jbtnAdminEmpleados){
            Administrador adm=new Administrador();//instanciar
            CAdministrador controlador=new CAdministrador(adm);
            vista.PrincipalMenu.removeAll();
            vista.PrincipalMenu.setLayout(new BorderLayout());
            vista.PrincipalMenu.add(adm.getContentPane(),BorderLayout.CENTER);
            vista.PrincipalMenu.revalidate();
            vista.PrincipalMenu.repaint();
        }
        
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

