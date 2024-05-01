
package Controlador;
///importar clases
import VistaAdministrador.MenuAdministrador;
import VistaAdministrador.Administrador;
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
        vista.jbtnAdminEmpleados.addActionListener(this);
        vista.jbtnInventario.addActionListener(this);
        vista.jbtnVentas.addActionListener(this);
        vista.jbtnCerrarSesion.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.jbtnAdminEmpleados){
            Administrador adm=new Administrador();//instanciar
            CAdministrador controlador=new CAdministrador(adm);
            vista.PrincipalMenu.removeAll();
            vista.PrincipalMenu.setLayout(new BorderLayout());
            vista.PrincipalMenu.add(adm.getContentPane(),BorderLayout.CENTER);
            vista.PrincipalMenu.revalidate();
            vista.PrincipalMenu.repaint();
        }
        
        
    }
    
}

