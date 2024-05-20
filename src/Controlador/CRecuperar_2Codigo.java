
package Controlador;
//
import static Procesos.CodigoAleatorio.generarCodigo;
import Procesos.JavaMail;
import VistaLogin.Recuperar;
import VistaLogin.Recuperar_2Codigo;
import VistaLogin.Recuperar_3Contraseña;
import VistaLogin.Login;
//librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CRecuperar_2Codigo implements ActionListener{
    //inicializar 
    Recuperar_2Codigo vista;
    Recuperar principal;
    private String correo; //traemos el correo almacenado en el formulario anterior por si devemos reenviar el codigo
    private String codigoAleatorio;//traemos el codigo a la siguiente vista para validarlo
    //constructor
    public CRecuperar_2Codigo(Recuperar_2Codigo vistaa, String correo, String codigo){
        this.vista=vistaa;
        this.correo=correo;
        this.codigoAleatorio=codigo;
        vistaa.jtxtfIngresaCodigo.addActionListener(this);
        vistaa.jbtnVolverAEnviar.addActionListener(this);
        vistaa.jbtnAceptar.addActionListener(this);
        vistaa.jbtncancelar.addActionListener(this);
        vistaa.setVisible(true);
        vistaa.setTitle("Recuperar contraseña");
        vistaa.setLocationRelativeTo(null);
        System.out.println(codigo);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.jbtnVolverAEnviar){
            System.out.println(correo);
            codigoAleatorio = generarCodigo();
            System.out.println(codigoAleatorio);
            JavaMail javaEmail=new JavaMail(codigoAleatorio,correo);
            
        }
         
        if(e.getSource()==vista.jbtnAceptar){
            //validar
            if(!codigoAleatorio.equals(vista.jtxtfIngresaCodigo.getText())){
                JOptionPane.showMessageDialog(null, "El código ingresado no es correcto", "Código incorrecto", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            System.out.println("codigo ingresado: "+vista.jtxtfIngresaCodigo.getText());
            System.out.println("codigo que debo ingresar: "+codigoAleatorio);
            Recuperar_3Contraseña vista3=new Recuperar_3Contraseña();
            CRecuperar_3Contraseña controlador=new CRecuperar_3Contraseña(vista3, correo);
            vista.dispose();
            //codigo para validar codigo
        }
        
        if(e.getSource()==vista.jbtncancelar){
            //volver al login
            Login vistaLogin=new Login();
            ControladorLogin controlador=new ControladorLogin(vistaLogin);
            vista.dispose();
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////
    //Procesos
    ////////////////////////////////////////////////////////////////////////////////////////
    
    
}
