
package Controlador;
//importar clases
import VistaLogin.Recuperar_1Correo;
import VistaLogin.Login;
import VistaLogin.Recuperar;
import VistaLogin.Recuperar_2Codigo;
import Dao.DLogin;
import Procesos.JavaMail;
import static Procesos.CodigoAleatorio.generarCodigo;
//librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CRecuperar_1Correo implements ActionListener{
    //inicializar
    Recuperar_1Correo vista;
    Login login;
    
    
    //constructor

    public CRecuperar_1Correo(Recuperar_1Correo vista) {
        this.vista = vista;
        
        vista.jbtnEnviarCodigo.addActionListener(this);
        vista.jbtnVolverAtras.addActionListener(this);
        vista.jtxtfIngresaCorreo.addActionListener(this);
        vista.setVisible(true);
        vista.setTitle("Recuperar contraseña");
        vista.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //VOLVER ATRAS
        if(e.getSource()==vista.jbtnVolverAtras){
            System.out.println("btn volver");
            Login vistaLogin=new Login();
            ControladorLogin controlador=new ControladorLogin(vistaLogin);
            vista.dispose();
        }
        //INGRESAR CORREO
        if(e.getSource()==vista.jtxtfIngresaCorreo){
            System.out.println("afads");
            
        }
        //EVIAR CODIGO
        if(e.getSource()==vista.jbtnEnviarCodigo){
            // Acción cuando se presiona el botón de enviar código
            
            // Obtener el correo ingresado en la vista
            String correo = vista.jtxtfIngresaCorreo.getText();
            System.out.println(correo);
            // Verificar si el correo está registrado en el sistema
            if(!validarCorreo(correo)){
                JOptionPane.showMessageDialog(null, "La dirección de correo ingresada no está registrada en el sistema", "Validación de Existencia de correo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }// Si el correo es válido, continuar con el proceso
            String codigoAleatorio = generarCodigo();
            JavaMail javaEmail=new JavaMail(codigoAleatorio,correo);
            
            // Instanciar el controlador del siguiente paso y pasar el correo como argumento
            Recuperar_2Codigo vista2 = new Recuperar_2Codigo();
            CRecuperar_2Codigo controlador = new CRecuperar_2Codigo(vista2, correo,codigoAleatorio);
            
            // Cerrar la vista actual
            vista.dispose();
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////
    //Procesos
    ////////////////////////////////////////////////////////////////////////////////////////
    
    // Método para validar si el correo está registrado en el sistema
    private boolean validarCorreo(String correo){
        DLogin daoCorreo = new DLogin();
        return daoCorreo.existeCorreo(correo);
    }
}
    



/*    
    private void ingresarCorreo(){
        //instanciar Dao para seleccionar el correo y verificar si esta registrado en la bd
        DLogin daoCorreo=new DLogin();
        //obtener correo ingresado en el formulario para recuperar contraseña
        String correo=vista.jtxtfIngresaCorreo.getText();
        //verificar si existe un usuario con ese correo registrado en el sistema
        if(!daoCorreo.existeCorreo(correo)){
            JOptionPane.showMessageDialog(null, "La dirección de correo ingresada no esta registrada en el sistema", "Validación de Existencia de correo", JOptionPane.INFORMATION_MESSAGE);
            return; // Detener la ejecución del método si el número de documento ya está en uso
        }
        System.out.println("correo ingresado"+correo);
    }

}
*/