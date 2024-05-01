
package Controlador;
//importar clases
import VistaInventario.Inventario;
import VistaInventario.Inventario_Registro;

//importar librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CInventario_Registro implements ActionListener{
    //inicializar
    Inventario_Registro vista;
    Inventario menu;
    //constructor

    public CInventario_Registro(Inventario_Registro vista, Inventario menu) {
        this.vista = vista;
        this.menu = menu;
        
        vista.btnAgregar.addActionListener(this);
        vista.btnBorrar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnExportarCatalogo.addActionListener(this);
        vista.btnImagenProduc.addActionListener(this);
        vista.jtxfNombreProducto.addActionListener(this);
        vista.jcbxTipoProduc.addActionListener(this);
        vista.jtxfDetalle.addActionListener(this);
        vista.jtxtCodigo.addActionListener(this);
        vista.jtxtPrecio.addActionListener(this);
        //vista.tblinventario.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnAgregar){
            System.out.println("agregar");
        }
    }
    
    
}
