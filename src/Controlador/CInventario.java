
package Controlador;
//importar clases
import VistaInventario.Inventario;
import VistaInventario.Inventario_Registro;
//importar librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CInventario implements ActionListener{
    //inicializar
    Inventario vista;
    //constructor
    public CInventario(Inventario menu){
        vista=menu;
        vista.tab1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("tab1");
        Inventario_Registro datos=new Inventario_Registro();
        CInventario_Registro controlador=new CInventario_Registro(datos, vista);
        vista.PrincipalInventario.removeAll();
        vista.PrincipalInventario.setLayout(new BorderLayout());
        vista.PrincipalInventario.add(datos.getContentPane(),BorderLayout.CENTER);
        vista.PrincipalInventario.revalidate();
        vista.PrincipalInventario.repaint();
            
        if(!vista.tab1.isSelected()){
            vista.tab1.setSelected(true);
        }
        
    }
}
