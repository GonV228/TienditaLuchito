
package Controlador;
//importar clases
import VistaAdministrador.Administrador;
import VistaAdministrador.Administrador_RegistrarUsers;
import VistaAdministrador.MenuAdministrador;
//importar librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CAdministrador_RegistrarUser implements ActionListener{
    //inicializar
    Administrador_RegistrarUsers vista;//vista actual
    Administrador menu; //menu 
    //constructor
    public CAdministrador_RegistrarUser(Administrador_RegistrarUsers adminRegis, Administrador Admin){
        vista=adminRegis;
        menu=Admin;
        vista.btnAgregar.addActionListener(this);
        vista.btnBorrar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnSubirImagen.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vista.btnAgregar){
           System.out.println("aceptar");
           Administrador_RegistrarUsers RegisU=new Administrador_RegistrarUsers();
           CAdministrador_RegistrarUser controlador=new CAdministrador_RegistrarUser(RegisU, menu);
           menu.PrincipalAdministrador.removeAll();
           menu.PrincipalAdministrador.setLayout(new BorderLayout());
           menu.PrincipalAdministrador.add(RegisU.getContentPane(),BorderLayout.CENTER);
           menu.PrincipalAdministrador.revalidate();
           menu.PrincipalAdministrador.repaint();
           
       } 
        
        
    }
}
