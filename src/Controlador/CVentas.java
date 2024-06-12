
package Controlador;
//import clases

import VistaVentas.Ventas;
import VistaVentas.Ventas_Registro2;

//import librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CVentas implements ActionListener{
    //inicializar
    Ventas vista;
    //constructor
    public CVentas(Ventas menu){
        vista=menu;
        vista.tab1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("tab1");
        Ventas_Registro2 datos=new Ventas_Registro2();
        CVentas_Registro controlador=new CVentas_Registro(datos, vista);
        vista.PrincipalVentas.removeAll();
        vista.PrincipalVentas.setLayout(new BorderLayout());
        vista.PrincipalVentas.add(datos.getContentPane(),BorderLayout.CENTER);
        vista.PrincipalVentas.revalidate();
        vista.PrincipalVentas.repaint();
            
        if(!vista.tab1.isSelected()){
            vista.tab1.setSelected(true);
        }
        
        
        
        
    }
}
