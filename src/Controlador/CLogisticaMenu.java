package Controlador;
//importar clases
import VistaLogistica.LogisticaMenu; //menu
import VistaLogistica.Logistica;    //acciones de logistica
//importar librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CLogisticaMenu implements ActionListener{
    //inicializar
    LogisticaMenu vista;
    //constructor
    public CLogisticaMenu(LogisticaMenu menu){
        vista=menu;
        vista.tab1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("tab1");
        Logistica vistaLog=new Logistica();
        CLogistica controlador=new CLogistica(vistaLog);
        vista.PrincipalLogistica.removeAll();
        vista.PrincipalLogistica.setLayout(new BorderLayout());
        vista.PrincipalLogistica.add(vistaLog.getContentPane(),BorderLayout.CENTER);
        vista.PrincipalLogistica.revalidate();
        vista.PrincipalLogistica.repaint();
            
        if(!vista.tab1.isSelected()){
            vista.tab1.setSelected(true);
        }
    }
    
}
