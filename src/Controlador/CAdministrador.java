//submenu del boton Administrador
package Controlador;
import VistaAdministrador.Administrador;
import VistaAdministrador.Administrador_RegistrarUsers;
import VistaAdministrador.MenuAdministrador;
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //REGISTRO
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
            }
        }
        
        
    }
    
    
}
