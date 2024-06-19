package Controlador;
//Importar clases

import Dao.DCliente;
import Modelo.Cliente;
import VistaAdministrador.Administrador;
import VistaRegistrarPersonasExternas.Clientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

//importar librerias
public class CClientes implements ActionListener {

    //inicializar
    Clientes vista;
    Administrador adm;

    //constructor
    public CClientes(Clientes regisClientes, Administrador menu) {
        vista = regisClientes;
        adm = menu;
        
        // Mostrar los usuarios en la tabla
        mostrarClientesEnTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mostrarClientesEnTabla();
    }

    //6. MOSTRAR LOS USUARIOS DE LA TABLA (EN EL 1 SE SELECCIONAN... ACA SE MUESTRAN CUANDO CARGA LA VISTA)
    private void mostrarClientesEnTabla() {
        DCliente dao = new DCliente();
        List<Cliente> clientes = dao.obtenerTodosClientes();

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) vista.tblEmpleados1.getModel();

        // Iterar sobre las columnas y establecer el editor como null para hacerlas no editables
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            vista.tblEmpleados1.setDefaultEditor(modelo.getColumnClass(i), null);
        }
        // Limpiar la tabla antes de agregar los nuevos datos
        modelo.setRowCount(0);

        // Agregar cada cliente a la tabla
        for (Cliente cliente : clientes) {
            Object[] fila = {
                cliente.getDocumento(),
                cliente.getNombres(),
                cliente.getApellidos(),
                cliente.getEdad(),
                cliente.getGenero(),
                cliente.getTelefono(),
                cliente.getCorreo()
            };
            modelo.addRow(fila);
        }
    }

    //10. limpiar campos
    private void limpiarcampos() {
        vista.jtxtNombres.setText(null);
        vista.jtxtApellidos.setText(null);
        vista.jtxtCorreo.setText(null);
        vista.jtxtTelefono.setText(null);
        vista.jtxtNumDocumento.setText(null);
        vista.jcbxTipoEmpleado.setSelectedIndex(0);
    }
}
