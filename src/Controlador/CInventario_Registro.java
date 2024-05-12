
package Controlador;

import Dao.DInventario;
import Modelo.Productos;
import VistaInventario.Inventario;
import VistaInventario.Inventario_Registro;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CInventario_Registro implements ActionListener {
    private Inventario_Registro vista;//s
    private Inventario menu;
    private DInventario dao; // Agrega una referencia al DAO

    public CInventario_Registro(Inventario_Registro vista, Inventario menu) {
        this.vista = vista;
        this.menu = menu;
        this.dao = new DInventario(); // Inicializa el DAO

        // Agrega los listeners a los componentes de la vista
        vista.btnAgregar.addActionListener(this);
        vista.btnBorrar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnExportarCatalogo.addActionListener(this);
        vista.btnImagenProduc.addActionListener(this);
        vista.jtxfNombreProducto.addActionListener(this);
        vista.jcbxTipoProduc.addActionListener(this);
        vista.jtxfDetalle.addActionListener(this);

        vista.jtxtPrecio.addActionListener(this);
        vista.jtxtStock.addActionListener(this);

        // Carga los productos en la tabla al iniciar

    }

    private void actualizarVista() {
        Inventario_Registro RegisI = new Inventario_Registro();
        CInventario_Registro controlador = new CInventario_Registro(RegisI, menu);
        menu.PrincipalInventario.removeAll();
        menu.PrincipalInventario.setLayout(new BorderLayout());
        menu.PrincipalInventario.add(RegisI.getContentPane(), BorderLayout.CENTER);
        menu.PrincipalInventario.revalidate();
        menu.PrincipalInventario.repaint();
    }






    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            System.out.println("agregar");

            actualizarVista();
        }
        
    }
}
