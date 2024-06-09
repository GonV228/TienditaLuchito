package Controlador;
//import clases
import VistaLogistica.Logistica;    //acciones de logistica
import VistaLogistica.LogisticaMenu; //menu
//importar librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CLogistica implements ActionListener{
    //inicializar
    Logistica vista;
    //constructor
    public CLogistica(Logistica menu){
        vista=menu;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }
}
