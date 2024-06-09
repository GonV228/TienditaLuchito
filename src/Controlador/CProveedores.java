package Controlador;
//Importar clases
import VistaAdministrador.Administrador;
import VistaRegistrarPersonasExternas.Proveedores;
import java.awt.event.ActionEvent;
//importar librerias
import java.awt.event.ActionListener;
public class CProveedores implements ActionListener{
    //inicializar
    Proveedores vista;
    //constructor
    public CProveedores (Proveedores regisPoveedores){
        vista=regisPoveedores;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
