package Controlador;
//Importar clases
import VistaAdministrador.Administrador;
import VistaRegistrarPersonasExternas.Clientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//importar librerias
public class CClientes implements ActionListener{
    //inicializar
    Clientes vista;
    Administrador adm;
    //constructor
    public CClientes (Clientes regisClientes,Administrador menu){
        vista=regisClientes;
        adm=menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
   
    
}
