
package Controlador;
//importar clases
import VistaLogin.Login;
import VistaLogin.Recuperar_2Codigo;
import VistaLogin.Recuperar_3Contraseña;
//ijmportar librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CRecuperar_3Contraseña implements ActionListener{
    //inicializar 
    Recuperar_3Contraseña vista;
    
    //constructor
    public CRecuperar_3Contraseña (Recuperar_3Contraseña vistaRecuperar){
        vista=vistaRecuperar;
        vistaRecuperar.jtxtfContraseña.addActionListener(this);
        vistaRecuperar.jtxtfContraseña1.addActionListener(this);
        vistaRecuperar.jbtnCancelar.addActionListener(this);
        vistaRecuperar.jbtnReestablecer.addActionListener(this);
        
        vistaRecuperar.setVisible(true);
        vistaRecuperar.setTitle("Recuperar contraseña");
        vistaRecuperar.setLocationRelativeTo(null);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.jbtnCancelar){
            Login vistaLogin=new Login();
            ControladorLogin controlador=new ControladorLogin(vistaLogin);
            vista.dispose();
        }
        
        if(e.getSource()==vista.jbtnReestablecer){
            Login vistaLogin =new Login();
            ControladorLogin controlador=new ControladorLogin(vistaLogin);
            vista.dispose();
        }
        
        
        
    }
    
    
    
}
