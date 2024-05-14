package Controlador;

import Dao.DInventario;
import Modelo.Productos;
import Modelo.categorias;
import VistaInventario.Inventario;
import VistaInventario.Inventario_Registro;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CInventario_Registro implements ActionListener {
    private Inventario_Registro vista;
    private Inventario menu;
    private DInventario dao; // Agrega una referencia al DAO

    public CInventario_Registro(Inventario_Registro vista, Inventario menu) {
        this.vista = vista;
        this.menu = menu;
        this.dao = new DInventario(); // Inicializa el DAO

        // Agrega los listeners a los componentes de la vista
        vista.btnAgregarCategorias.addActionListener(this);
        vista.btnBorrarCategorias.addActionListener(this);
        vista.btnEditarCategorias.addActionListener(this);
        vista.btnExportarCatalogo.addActionListener(this);
        vista.btnImagenProduc.addActionListener(this);
        vista.jtxfNombreCategoria.addActionListener(this);
        vista.jcbxCategoria.addActionListener(this);
        vista.jtxfDetalle.addActionListener(this);
        vista.jtxtPrecio.addActionListener(this);
        vista.jtxtStock.addActionListener(this);
          // Carga los productos en la tabla  al iniciar
        cargarProductosATabla();
        // Carga los productos en la tabla de categorías al iniciar
        cargarCategoriasATabla();
        // Carga las categorias en el combobox 
         cargarCategoriasEnComboBox();
        // Agrega un listener a la tabla para detectar clics en las filas
        vista.jtableCategorias.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // Obtiene la fila seleccionada
                int filaSeleccionada = vista.jtableCategorias.getSelectedRow();
                // Obtiene el nombre de la categoría de la fila seleccionada
                String nombreCategoria = (String) vista.jtableCategorias.getValueAt(filaSeleccionada, 1);
                // Rellena el campo de texto con el nombre de la categoría
                vista.jtxfNombreCategoria.setText(nombreCategoria);
            }
        });
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

    // Método para cargar las categorías en la tabla
    private void cargarCategoriasATabla() {
        // Obtiene las categorías de la base de datos
        List<categorias> listaCategorias = dao.obtenerCategoriasOrdenadas();
        // Crea el modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        // Agrega las categorías al modelo de tabla
        for (categorias categoria : listaCategorias) {
            Object[] fila = {categoria.getIdCategoria(), categoria.getNombre()};
            modelo.addRow(fila);
        }
        // Establece el modelo de tabla en la tabla
        vista.jtableCategorias.setModel(modelo);
    }

    // Método para agregar una nueva categoría
    private void agregarCategoria() {
        String nombreCategoria = vista.jtxfNombreCategoria.getText().trim();
        if (!nombreCategoria.isEmpty()) {
            // Inserta la nueva categoría en la base de datos
            boolean insertado = dao.insertarCategoria(new categorias(0, nombreCategoria));
            if (insertado) {
                JOptionPane.showMessageDialog(vista, "Categoría agregada correctamente.");
                // Actualiza la tabla para mostrar la nueva categoría
                cargarCategoriasATabla();
                // Limpia el campo de texto
                vista.jtxfNombreCategoria.setText("");
            } else {
                // Se muestra un mensaje de error si la inserción falla
                JOptionPane.showMessageDialog(vista, "Error al agregar la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Se muestra un mensaje de error si el campo de texto está vacío
            JOptionPane.showMessageDialog(vista, "Por favor, ingresa el nombre de la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
private void cargarCategoriasEnComboBox() {
    // Obtiene las categorías de la base de datos
    List<categorias> listaCategorias = dao.obtenerCategoriasOrdenadas();
    // Limpia el JComboBox antes de agregar los nuevos elementos
    vista.jcbxCategoria.removeAllItems();
    // Agrega los nombres de las categorías al JComboBox
    for (categorias categoria : listaCategorias) {
        vista.jcbxCategoria.addItem(categoria.getNombre());
    }
}
    // Método para eliminar una categoría
    private void eliminarCategoria() {
        // Obtiene el índice de la fila seleccionada en la tabla de categorías
        int filaSeleccionada = vista.jtableCategorias.getSelectedRow();
        if (filaSeleccionada != -1) { // Se verifica que haya una fila seleccionada
            // Obtiene el ID de la categoría seleccionada en la tabla
            int idCategoria = (int) vista.jtableCategorias.getValueAt(filaSeleccionada, 0);
            // Pregunta al usuario si está seguro de eliminar la categoría
            int opcion = JOptionPane.showConfirmDialog(vista, "¿Estás seguro de eliminar esta categoría?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                // Elimina la categoría de la base de datos
                boolean eliminado = dao.eliminarCategoria(idCategoria);
                if (eliminado) {
                    JOptionPane.showMessageDialog(vista, "Categoría eliminada correctamente.");
                    // Actualiza la tabla para reflejar los cambios
                    cargarCategoriasATabla();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al eliminar la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, selecciona una categoría a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para editar el nombre de una categoría
    private void editarCategoria() {
    // Obtiene el índice de la fila seleccionada en la tabla de categorías
    int filaSeleccionada = vista.jtableCategorias.getSelectedRow();
    if (filaSeleccionada != -1) { // Se verifica que haya una fila seleccionada
        // Obtiene el ID de la categoría seleccionada en la tabla
        int idCategoria = (int) vista.jtableCategorias.getValueAt(filaSeleccionada, 0);
        // Obtiene el nuevo nombre de la categoría del campo de texto
        String nuevoNombre = vista.jtxfNombreCategoria.getText().trim();
        if (!nuevoNombre.isEmpty()) {
            // Edita la categoría en la base de datos
            boolean editado = dao.editarCategoria(idCategoria, nuevoNombre);
            if (editado) {
                JOptionPane.showMessageDialog(vista, "Categoría editada correctamente.");
                // Actualiza la tabla para reflejar los cambios
                cargarCategoriasATabla();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al editar la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, ingresa el nuevo nombre de la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(vista, "Por favor, selecciona una categoría a editar.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Método para cargar los productos en la tabla
private void cargarProductosATabla() {
    // Obtiene los productos de la base de datos
    List<Productos> listaProductos = dao.obtenerProductos();
    // Crea el modelo de tabla
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Stock");
    modelo.addColumn("Informacion");
    modelo.addColumn("Precio");
    modelo.addColumn("Imagen");
    modelo.addColumn("ID_Categoria");
    // Agrega los productos al modelo de tabla
    for (Productos producto : listaProductos) {
        Object[] fila = {
            producto.getID_Producto(),
            producto.getNombreP(),
            producto.getStock(),
            producto.getInformacion(),
            producto.getPrecio(),
            producto.getImagenP(), // aqui falta el coso chooose ese para insertar imagen
            producto.getCategoria().getIdCategoria() // aqui modificare quiero mostrar el nombre de la categoria
        };
        modelo.addRow(fila);
    }
    // Establece el modelo de tabla en la tabla
    vista.jtableProductos.setModel(modelo);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregarCategorias) {
            agregarCategoria();
             actualizarVista();
        } else if (e.getSource() == vista.btnBorrarCategorias) {
            eliminarCategoria();
            actualizarVista();
        } else if (e.getSource() == vista.btnEditarCategorias) {
            editarCategoria();
            actualizarVista();
        }
    }
}
