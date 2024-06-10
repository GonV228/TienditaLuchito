//submenu del boton Administrador
package Controlador;
import VistaAdministrador.Administrador;//menu
import VistaAdministrador.Administrador_RegistrarUsers;//empleados
import VistaAdministrador.MenuAdministrador;
import VistaRegistrarPersonasExternas.Clientes; //clientes
import VistaRegistrarPersonasExternas.Proveedores;//proveedores
//librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CAdministrador implements ActionListener{
    //inicializar
    Administrador vista;
    //constructor

    public CAdministrador(Administrador menu) {
        this.vista = menu;
        vista.tab1.addActionListener(this);
        vista.tab2.addActionListener(this);
        vista.tab3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //REGISTRO EMPLEADOS
        if(e.getSource()==vista.tab1){
            System.out.println("tab1");
            Administrador_RegistrarUsers datos = new Administrador_RegistrarUsers();
            CAdministrador_RegistrarUser controlador = new  CAdministrador_RegistrarUser(datos, vista);

            vista.PrincipalAdministrador.removeAll();
            vista.PrincipalAdministrador.setLayout(new BorderLayout());
            vista.PrincipalAdministrador.add(datos.getContentPane(),BorderLayout.CENTER);
            vista.PrincipalAdministrador.revalidate();
            vista.PrincipalAdministrador.repaint();
            
            if(!vista.tab1.isSelected()){
                vista.tab1.setSelected(true);
                vista.tab2.setSelected(false);
                vista.tab3.setSelected(false);
                
            }
        }
        //REGISTRO CLIENTES
        if(e.getSource()==vista.tab2){
            System.out.println("tab2");
            Clientes vistaClientes = new Clientes();
            CClientes controlador = new  CClientes(vistaClientes, vista);

            vista.PrincipalAdministrador.removeAll();
            vista.PrincipalAdministrador.setLayout(new BorderLayout());
            vista.PrincipalAdministrador.add(vistaClientes.getContentPane(),BorderLayout.CENTER);
            vista.PrincipalAdministrador.revalidate();
            vista.PrincipalAdministrador.repaint();
            
            if(!vista.tab2.isSelected()){
                vista.tab1.setSelected(false);
                vista.tab2.setSelected(true);
                vista.tab3.setSelected(false);
            }
        }
        //REGISTRO PROVEEDORES
        if(e.getSource()==vista.tab3){
            System.out.println("tab3");
            Proveedores vistaProveedores = new Proveedores();
            CProveedores controlador = new  CProveedores(vistaProveedores);

            vista.PrincipalAdministrador.removeAll();
            vista.PrincipalAdministrador.setLayout(new BorderLayout());
            vista.PrincipalAdministrador.add(vistaProveedores.getContentPane(),BorderLayout.CENTER);
            vista.PrincipalAdministrador.revalidate();
            vista.PrincipalAdministrador.repaint();
            
            if(!vista.tab3.isSelected()){
                vista.tab1.setSelected(false);
                vista.tab2.setSelected(false);
                vista.tab3.setSelected(true);
            }
        }
        
    }
    
    
}
