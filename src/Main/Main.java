
package Main;
import Vista.Login;
import Controlador.ControladorLogin;

public class Main {
    public static void iniciarSesion(){
        Login login = new Login();
        ControladorLogin CLG = new ControladorLogin(login);
        
    }
    public static void main(String[] args) {
     iniciarSesion();  
    }
    //hola
}
