package Controlador;

import Dao.DInventario;
import Dao.DVentaseInventario;
import Modelo.Productos;
import Modelo.categorias;
import VistaVentas.Ventas;
import VistaVentas.Ventas_Registro2;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.TableColumn;

public class CVentas_Registro implements ActionListener {

    // inicializar
    Ventas_Registro2 vista;
    Ventas menu;
    DInventario dao; // DAO para interactuar con la base de datos
    DVentaseInventario dao1; // DAO para interactuar con la base de datos
    Productos productoSeleccionado; // Para almacenar el producto seleccionado

    // constructor
    public CVentas_Registro(Ventas_Registro2 VR, Ventas V) {
        vista = VR;
        menu = V;
        dao = new DInventario(); // Instancia del DAO
        dao1 = new DVentaseInventario(); // Instancia del DAO
        vista.jtxtBuscarPorNombreProducto.addActionListener(this);
        vista.jtxtBuscarPorID.addActionListener(this);
        vista.jbtnBuscarProductos.addActionListener(this);
        vista.jbtnAgregarProductosVentas.addActionListener(this);
        vista.jcbxFiltrarCat.addActionListener(this);

        // Llenar el JComboBox con las categorías al inicializar
        llenarComboBoxCategorias();
        // Llenar la tabla con todos los productos al inicializar
        llenarTablaProductos();

        // Agregar listener al JComboBox para detectar cambios de selección de categoría
        vista.jcbxFiltrarCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String categoriaSeleccionada = vista.jcbxFiltrarCat.getSelectedItem().toString();
                if (!categoriaSeleccionada.equals("Todas")) {
                    // Obtener productos por la categoría seleccionada y actualizar la tabla
                    llenarTablaProductosPorCategoria(categoriaSeleccionada);
                } else {
                    // Si se selecciona "Todas", mostrar todos los productos
                    llenarTablaProductos();
                }
            }
        });
// Iniciar el modelo de la tabla de ventas
        DefaultTableModel modeloVentas = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas de la tabla sean no editables
            }
        };
        modeloVentas.addColumn("ID");
        modeloVentas.addColumn("Nombre");
        modeloVentas.addColumn("Informacion");
        modeloVentas.addColumn("Precio");
        modeloVentas.addColumn("Cantidad");
        modeloVentas.addColumn("Promocion");
        modeloVentas.addColumn("Importe");

        vista.jtbRegistroDVentas.setModel(modeloVentas);

        // Agregar MouseListener al JTable para mostrar la imagen en el JLabel
        // Agregar MouseListener al JTable para autocompletar campos de texto
        vista.JtableMostraProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = vista.JtableMostraProductos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    // Obtener el ID y el nombre del producto de la fila seleccionada
                    int idProducto = (int) vista.JtableMostraProductos.getValueAt(filaSeleccionada, 0);
                    String nombreProducto = (String) vista.JtableMostraProductos.getValueAt(filaSeleccionada, 1);
                    // Autocompletar los campos de texto con el ID y el nombre del producto
                    vista.jtxtBuscarPorID.setText(String.valueOf(idProducto));
                    vista.jtxtBuscarPorNombreProducto.setText(nombreProducto);
                    // Obtener el producto correspondiente del DAO
                    productoSeleccionado = dao.obtenerProductoPorID(idProducto);
                    // Mostrar la imagen del producto en el JLabel
                    mostrarImagenProducto(productoSeleccionado);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnBuscarProductos) {
            buscarProductos();
        } else if (e.getSource() == vista.jbtnAgregarProductosVentas) {
            agregarProductoAVentas();
        }
    }

    private void actualizarVista() {
        Ventas_Registro2 VR = new Ventas_Registro2();
        CVentas_Registro controlador = new CVentas_Registro(VR, menu);
        menu.PrincipalVentas.removeAll();
        menu.PrincipalVentas.setLayout(new BorderLayout());
        menu.PrincipalVentas.add(VR.getContentPane(), BorderLayout.CENTER);
        menu.PrincipalVentas.revalidate();
        menu.PrincipalVentas.repaint();
    }

    // Método para buscar productos y actualizar la tabla
    private void buscarProductos() {
        String idProducto = vista.jtxtBuscarPorID.getText();
        String nombreProducto = vista.jtxtBuscarPorNombreProducto.getText();
        List<Productos> resultados;

        if (!idProducto.isEmpty()) {
            // Si se ha ingresado un ID, buscar por ID
            resultados = dao1.buscarProductosVenta(idProducto, null);
        } else {
            // Si no se ha ingresado un ID, buscar por nombre de producto
            resultados = dao1.buscarProductosVenta(null, nombreProducto);
        }

        cargarProductosATabla(resultados);
    }

    // Método para configurar el renderizador de imágenes en una tabla
    private void setImageRenderer(JTable table) {
        TableColumn imageColumn = table.getColumnModel().getColumn(5);
        imageColumn.setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return new JLabel((ImageIcon) value);
            }
        });
    }

    // Método para llenar el JComboBox con las categorías disponibles
    private void llenarComboBoxCategorias() {
        vista.jcbxFiltrarCat.removeAllItems(); // Asegurarse de que el JComboBox esté vacío antes de llenarlo
        List<categorias> categorias = dao.obtenerCategoriasOrdenadas();
        vista.jcbxFiltrarCat.addItem("Todas"); // Opción para mostrar todos los productos
        for (categorias categoria : categorias) {
            vista.jcbxFiltrarCat.addItem(categoria.getNombre());
        }
    }

    // Método para llenar la tabla con todos los productos
    private void llenarTablaProductos() {
        List<Productos> productos = dao.obtenerProductos();
        cargarProductosATabla(productos);
    }

    // Método para llenar la tabla con productos filtrados por categoría
    private void llenarTablaProductosPorCategoria(String categoria) {
        List<Productos> productos = dao.obtenerProductosPorCategoria(categoria);
        cargarProductosATabla(productos);
    }

    // Método para llenar la tabla con la lista de productos dada
    private void cargarProductosATabla(List<Productos> listaProductos) {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas de la tabla sean no editables
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Stock");
        modelo.addColumn("Informacion");
        modelo.addColumn("Precio");
        modelo.addColumn("Categoría");

        for (Productos producto : listaProductos) {
            Object[] fila = {
                producto.getID_Producto(),
                producto.getNombreP(),
                producto.getStock(),
                producto.getInformacion(),
                producto.getPrecio(),
                producto.getCategoria() != null ? producto.getCategoria().getNombre() : "Sin categoría"
            };
            modelo.addRow(fila);
        }
        vista.JtableMostraProductos.setModel(modelo);
    }

    // Método para mostrar la imagen del producto seleccionado en un JLabel
    private void mostrarImagenProducto(Productos producto) {
        if (producto.getImagenP() != null) {
            ImageIcon imagenIcono = new ImageIcon(producto.getImagenP());
            Image imagen = imagenIcono.getImage().getScaledInstance(vista.jlblMostrarProductoVenta.getWidth(), vista.jlblMostrarProductoVenta.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imagenEscalada = new ImageIcon(imagen);
            vista.jlblMostrarProductoVenta.setIcon(imagenEscalada);
        } else {
            vista.jlblMostrarProductoVenta.setIcon(null); // Limpiar el JLabel si no hay imagen disponible
        }
    }

    // Método para agregar el producto seleccionado a la tabla de ventas
    private void agregarProductoAVentas() {
        if (productoSeleccionado == null) {
            JOptionPane.showMessageDialog(vista, "No hay ningún producto seleccionado.");
            return;
        }

        // Pedir la cantidad a agregar
        String cantidadStr = JOptionPane.showInputDialog(vista, "Ingrese la cantidad a agregar:");
        if (cantidadStr == null || cantidadStr.isEmpty()) {
            return; // Si se cancela el diálogo o se deja vacío, no hacer nada
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Ingrese una cantidad válida.");
            return;
        }

        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(vista, "La cantidad debe ser mayor que cero.");
            return;
        }

        if (cantidad > productoSeleccionado.getStock()) {
            JOptionPane.showMessageDialog(vista, "No hay suficiente stock para agregar esa cantidad.");
            return;
        }

        // Agregar el producto y la cantidad a la tabla de ventas
        DefaultTableModel modeloVentas = (DefaultTableModel) vista.jtbRegistroDVentas.getModel();
        modeloVentas.addRow(new Object[]{
            productoSeleccionado.getID_Producto(),
            productoSeleccionado.getNombreP(),
            productoSeleccionado.getInformacion(),
            productoSeleccionado.getPrecio(),
            cantidad,
            "" // Campo para promoción vacío por ahora
        });

        // No actualizar el stock aquí
    }

}
