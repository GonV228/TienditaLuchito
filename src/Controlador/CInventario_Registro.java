package Controlador;

import Dao.DInventario;
import Modelo.Productos;
import Modelo.categorias;
import Procesos.PrecioDocumentFilter;
import ProcesosPDF.GeneradorPDF;
import VistaInventario.Inventario;
import VistaInventario.Inventario_Registro;
import java.awt.Desktop;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.AbstractDocument;

public class CInventario_Registro implements ActionListener {
    private Inventario_Registro vista;
    private Inventario menu;
    private DInventario dao;
    Productos productoSeleccionado;

    public CInventario_Registro(Inventario_Registro vista, Inventario menu) {
        this.vista = vista;
        this.menu = menu;
        this.dao = new DInventario();

        vista.btnAgregarCategorias.addActionListener(this);
        vista.btnEditarProducto.addActionListener(this);
        vista.btnEliminarProducto.addActionListener(this);
        vista.btnAgregarProducto.addActionListener(this);
        vista.btnLimpiarCampos.addActionListener(this);
        vista.btnBorrarCategorias.addActionListener(this);
        vista.btnEditarCategorias.addActionListener(this);
        vista.btnExportarCatalogoProductos.addActionListener(this);
        vista.btnImagenProduc.addActionListener(this);
        vista.jtxfNombreCategoria.addActionListener(this);
        vista.jcbxCategoria.addActionListener(this);
        vista.jtxfInformacion.addActionListener(this);
        vista.jtxtPrecio.addActionListener(this);
        vista.jbtnStock.addActionListener(this);
        vista.jcbxFiltroCategoria.addActionListener(this);

        cargarProductosATabla();
        cargarCategoriasATabla();
        cargarCategoriasEnComboBox();
        //este metodo convierte los , en . para el ingreso de precios en inventario
        ((AbstractDocument) vista.jtxtPrecio.getDocument()).setDocumentFilter(new PrecioDocumentFilter()); 
        
        vista.jtableCategorias.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int filaSeleccionada = vista.jtableCategorias.getSelectedRow();
                String nombreCategoria = (String) vista.jtableCategorias.getValueAt(filaSeleccionada, 1);
                vista.jtxfNombreCategoria.setText(nombreCategoria);
            }
        });
        vista.jtableProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = vista.jtableProductos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    mostrarDatosProductoSeleccionado(filaSeleccionada);
                }
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

    private void cargarCategoriasATabla() {
        List<categorias> listaCategorias = dao.obtenerCategoriasOrdenadas();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas de la tabla sean no editables
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        for (categorias categoria : listaCategorias) {
            Object[] fila = {categoria.getIdCategoria(), categoria.getNombre()};
            modelo.addRow(fila);
        }
        vista.jtableCategorias.setModel(modelo);
    }

    private void agregarCategoria() {
        String nombreCategoria = vista.jtxfNombreCategoria.getText().trim();
        if (!nombreCategoria.isEmpty()) {
            boolean insertado = dao.insertarCategoria(new categorias(0, nombreCategoria));
            if (insertado) {
                JOptionPane.showMessageDialog(vista, "Categoría agregada correctamente.");
                cargarCategoriasATabla();
                cargarCategoriasEnComboBox();
                limpiarCamposRegistroCategoria();
                vista.jtxfNombreCategoria.setText("");
            } else {
                JOptionPane.showMessageDialog(vista, "Error al agregar la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, ingresa el nombre de la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarCategoriasEnComboBox() {
        List<categorias> listaCategorias = dao.obtenerCategoriasOrdenadas();
        vista.jcbxCategoria.removeAllItems();
        vista.jcbxFiltroCategoria.removeAllItems(); // Limpiar los elementos anteriores del combo box de filtro
        for (categorias categoria : listaCategorias) {
            vista.jcbxCategoria.addItem(categoria.getNombre());
            vista.jcbxFiltroCategoria.addItem(categoria.getNombre()); // Agregar categorías al combo box de filtro
        }
    }

    private void eliminarCategoria() {
        int filaSeleccionada = vista.jtableCategorias.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idCategoria = (int) vista.jtableCategorias.getValueAt(filaSeleccionada, 0);
            int opcion = JOptionPane.showConfirmDialog(vista, "¿Estás seguro de eliminar esta categoría?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                boolean eliminado = dao.eliminarCategoria(idCategoria);
                if (eliminado) {
                    JOptionPane.showMessageDialog(vista, "Categoría eliminada correctamente.");
                    cargarCategoriasATabla();
                    limpiarCamposRegistroCategoria();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al eliminar la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, selecciona una categoría a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarCategoria() {
        int filaSeleccionada = vista.jtableCategorias.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idCategoria = (int) vista.jtableCategorias.getValueAt(filaSeleccionada, 0);
            String nuevoNombre = vista.jtxfNombreCategoria.getText().trim();
            if (!nuevoNombre.isEmpty()) {
                boolean editado = dao.editarCategoria(idCategoria, nuevoNombre);
                if (editado) {
                    JOptionPane.showMessageDialog(vista, "Categoría editada correctamente.");
                    cargarCategoriasATabla();
                    limpiarCamposRegistroCategoria();
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

    private void cargarProductosATabla() {
        String categoriaFiltro = (String) vista.jcbxFiltroCategoria.getSelectedItem();
        List<Productos> listaProductos;
        if (categoriaFiltro != null && !categoriaFiltro.isEmpty()) {
            listaProductos = dao.obtenerProductosPorCategoria(categoriaFiltro);

        } else {
            listaProductos = dao.obtenerProductos();
        }

        DefaultTableModel modelo = new DefaultTableModel(){
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
        modelo.addColumn("Imagen");
        modelo.addColumn("Categoría");
        for (Productos producto : listaProductos) {
            Object[] fila = {
                producto.getID_Producto(),
                producto.getNombreP(),
                producto.getStock(),
                producto.getInformacion(),
                producto.getPrecio(),
                producto.getImagenP(),
                producto.getCategoria().getNombre()
            };
            modelo.addRow(fila);
        }
        vista.jtableProductos.setModel(modelo);
        // Configurar el renderizador para la columna de "Stock"
        vista.jtableProductos.getColumnModel().getColumn(2).setCellRenderer(new StockCellRenderer());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregarCategorias) {
            agregarCategoria();
            //actualizarVista();
        } else if (e.getSource() == vista.btnBorrarCategorias) {
            eliminarCategoria();
            //actualizarVista();
        } else if (e.getSource() == vista.btnEditarCategorias) {
            editarCategoria();
            //actualizarVista();
        } else if (e.getSource() == vista.btnAgregarProducto) {
            agregarProducto();
            //actualizarVista();
        } else if (e.getSource() == vista.btnEliminarProducto) {
            eliminarProducto();
            //actualizarVista();
        } else if (e.getSource() == vista.btnEditarProducto) {
            editarProducto();
            //actualizarVista();
        } else if (e.getSource() == vista.btnLimpiarCampos){
            limpiarCaposRegistro();
            //actualizarVista();
        }else if (e.getSource() == vista.jbtnStock) {
            manejarBotonStock();

        } else if (e.getSource() == vista.jcbxFiltroCategoria) {
            cargarProductosATabla();
       
        } else if (e.getSource() == vista.btnExportarCatalogoProductos) {
         // Llama al método exportarCatalogoPDF con la categoría seleccionada
            String categoria = (String) vista.jcbxFiltroCategoria.getSelectedItem();
            String rutaArchivo = exportarCatalogoPDF(categoria);
            abrirPDF(rutaArchivo);
            JOptionPane.showMessageDialog(vista, "El catálogo de productos se ha exportado correctamente como " + rutaArchivo, "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == vista.btnImagenProduc) {
            seleccionarImagenProducto();
        }

}

    private void manejarBotonStock() {
        int filaSeleccionada = vista.jtableProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idProducto = (int) vista.jtableProductos.getValueAt(filaSeleccionada, 0);
            String[] opciones = {"Aumentar Stock", "Disminuir Stock"};
            int opcionSeleccionada = JOptionPane.showOptionDialog(
                vista,
                "¿Qué acción deseas realizar?",
                "Stock de Producto",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );
            if (opcionSeleccionada == 0) {
                aumentarStock(idProducto);
            } else if (opcionSeleccionada == 1) {
                disminuirStock(idProducto);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, selecciona un producto para modificar el stock.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void aumentarStock(int idProducto) {
        String cantidad = JOptionPane.showInputDialog(vista, "Ingrese la cantidad a aumentar:", "Aumentar Stock", JOptionPane.QUESTION_MESSAGE);
        if (cantidad != null && !cantidad.isEmpty()) {
            try {
                int cantidadAumentar = Integer.parseInt(cantidad);
                if (cantidadAumentar > 0) {
                    boolean stockAumentado = dao.aumentarStock(idProducto, cantidadAumentar);
                    if (stockAumentado) {
                        JOptionPane.showMessageDialog(vista, "Stock aumentado correctamente.");
                        cargarProductosATabla();
                    } else {
                        JOptionPane.showMessageDialog(vista, "Error al aumentar el stock.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(vista, "La cantidad a aumentar debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "Por favor, ingresa una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void disminuirStock(int idProducto) {
        String cantidad = JOptionPane.showInputDialog(vista, "Ingrese la cantidad a disminuir:", "Disminuir Stock", JOptionPane.QUESTION_MESSAGE);
        if (cantidad != null && !cantidad.isEmpty()) {
            try {
                int cantidadDisminuir = Integer.parseInt(cantidad);
                if (cantidadDisminuir > 0) {
                    boolean stockDisminuido = dao.disminuirStock(idProducto, cantidadDisminuir);
                    if (stockDisminuido) {
                        JOptionPane.showMessageDialog(vista, "Stock disminuido correctamente.");
                        cargarProductosATabla();
                    } else {
                        JOptionPane.showMessageDialog(vista, "Error al disminuir el stock.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(vista, "La cantidad a disminuir debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "Por favor, ingresa una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void agregarProducto() {
        String nombre = vista.jtxfNombreProducto.getText().trim();
        String informacion = vista.jtxfInformacion.getText().trim();
        String precioStr = vista.jtxtPrecio.getText().trim();
        String categoriaNombre = (String) vista.jcbxCategoria.getSelectedItem();
        byte[] imagen = obtenerImagen();

        if (nombre.isEmpty() || precioStr.isEmpty() || categoriaNombre == null) {
            JOptionPane.showMessageDialog(vista, "Por favor, completa todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double precio;
        try {
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "El precio ingresado no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        categorias categoria = dao.obtenerCategoriaPorNombre(categoriaNombre);
        if (categoria == null) {
            JOptionPane.showMessageDialog(vista, "La categoría seleccionada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Productos producto = new Productos(0, nombre, 0, informacion, precio, null, categoria);

        boolean insertado = dao.insertarProducto(producto);
        if (insertado) {
            JOptionPane.showMessageDialog(vista, "Producto agregado correctamente.");
            cargarProductosATabla();
            limpiarCaposRegistro();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarProducto() {
        int filaSeleccionada = vista.jtableProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idProducto = (int) vista.jtableProductos.getValueAt(filaSeleccionada, 0);
            int opcion = JOptionPane.showConfirmDialog(vista, "¿Estás seguro de eliminar este producto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                boolean eliminado = dao.eliminarProducto(idProducto);
                if (eliminado) {
                    JOptionPane.showMessageDialog(vista, "Producto eliminado correctamente.");
                    cargarProductosATabla();
                    limpiarCaposRegistro();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al eliminar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, selecciona un producto a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarDatosProductoSeleccionado(int filaSeleccionada) {
        int idProducto = (int) vista.jtableProductos.getValueAt(filaSeleccionada, 0);
        productoSeleccionado = dao.obtenerProductoPorID(idProducto);
        if (productoSeleccionado != null) {
        vista.jtxfNombreProducto.setText(productoSeleccionado.getNombreP());
        //vista.jtxfStock.setText(String.valueOf(productoSeleccionado.getStock()));
        vista.jtxfInformacion.setText(productoSeleccionado.getInformacion());
        vista.jtxtPrecio.setText(String.valueOf(productoSeleccionado.getPrecio()));
        vista.jcbxCategoria.setSelectedItem(productoSeleccionado.getCategoria().getNombre());
        if (productoSeleccionado.getImagenP() != null) {
            ImageIcon imagen = new ImageIcon(productoSeleccionado.getImagenP());
            imagen.setDescription("ImageFromDB");
            vista.jlabelImagenInventario.setIcon(imagen);
        } else {
            vista.jlabelImagenInventario.setIcon(null);
        }
    } else {
        // Manejar el caso en que productoSeleccionado es null
        JOptionPane.showMessageDialog(vista, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
    }
        /*if (producto != null) {
            vista.jtxfNombreProducto.setText(producto.getNombreP());
            // vista.jtxtStock.setText(String.valueOf(producto.getStock())); // Excluir el campo de stock
            vista.jtxfInformacion.setText(producto.getInformacion());
            vista.jtxtPrecio.setText(String.valueOf(producto.getPrecio()));
            //vista.jtxtImagen.setText(producto.getImagenP());
            vista.jcbxCategoria.setSelectedItem(producto.getCategoria().getNombre());
        if (productoSeleccionado.getImagenP() != null) {
                ImageIcon imagen = new ImageIcon(productoSeleccionado.getImagenP());
                imagen.setDescription("ImageFromDB");
                vista.jlabelImagenInventario.setIcon(imagen);
            } else {
                vista.jlabelImagenInventario.setIcon(null);
            }
        }   */ 
        /*} else {
            JOptionPane.showMessageDialog(vista, "Error al obtener los datos del producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }*/
    }
 
    private void editarProducto() {
        
        if (productoSeleccionado != null) {
        String nombre = vista.jtxfNombreProducto.getText().trim();
        //String stockTexto = vista.jt.getText().trim();
        String informacion = vista.jtxfInformacion.getText().trim();
        String precioTexto = vista.jtxtPrecio.getText().trim();
        String categoriaNombre = (String) vista.jcbxCategoria.getSelectedItem();
        byte[] imagen = obtenerImagen();

        if (!nombre.isEmpty() && !informacion.isEmpty() && !precioTexto.isEmpty() && categoriaNombre != null && !categoriaNombre.isEmpty()) {
            try {
                //int stock = Integer.parseInt(stockTexto);
                double precio = Double.parseDouble(precioTexto);

                categorias categoria = dao.obtenerCategoriaPorNombre(categoriaNombre);
                if (categoria == null) {
                    JOptionPane.showMessageDialog(vista, "La categoría seleccionada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                productoSeleccionado.setNombreP(nombre);
                //productoSeleccionado.setStock(stock);
                productoSeleccionado.setInformacion(informacion);
                productoSeleccionado.setPrecio(precio);
                productoSeleccionado.setCategoria(categoria);
                if (imagen != null) {
                    productoSeleccionado.setImagenP(imagen);
                }

                boolean editado = dao.editarProducto(productoSeleccionado);
                if (editado) {
                    JOptionPane.showMessageDialog(vista, "Producto editado correctamente.");
                    cargarProductosATabla();
                    limpiarCaposRegistro();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al editar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(vista, "Por favor, ingresa valores numéricos válidos para el precio.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(vista, "Por favor, selecciona un producto a editar.", "Error", JOptionPane.ERROR_MESSAGE);
    }
/*        if (productoSeleccionado != null) {
            String nombre = vista.jtxfNombreProducto.getText().trim();
            //String stockTexto = vista.jt.getText().trim();
            String informacion = vista.jtxfInformacion.getText().trim();
            String precioTexto = vista.jtxtPrecio.getText().trim();
            String categoria = (String) vista.jcbxCategoria.getSelectedItem();
            byte[] imagen = obtenerImagen();

            if (!nombre.isEmpty() && !informacion.isEmpty() && !precioTexto.isEmpty() && !categoria.isEmpty()) {
                try {
                    //int stock = Integer.parseInt(stockTexto);
                    double precio = Double.parseDouble(precioTexto);
                    productoSeleccionado.setNombreP(nombre);
                    //productoSeleccionado.setStock(stock);
                    productoSeleccionado.setInformacion(informacion);
                    productoSeleccionado.setPrecio(precio);
                    productoSeleccionado.setCategoria(new categorias(categoria));
                    if (imagen != null) {
                        productoSeleccionado.setImagenP(imagen);
                    }
                    boolean editado = dao.editarProducto(productoSeleccionado);
                    if (editado) {
                        JOptionPane.showMessageDialog(vista, "Producto editado correctamente.");
                        cargarProductosATabla();
                        limpiarCaposRegistro();
                    } else {
                        JOptionPane.showMessageDialog(vista, "Error al editar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(vista, "Por favor, ingresa valores numéricos válidos para stock y precio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, selecciona un producto a editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
*/        
/*        // Obtener el índice de la fila seleccionada en la tabla de productos
        int filaSeleccionada = vista.jtableProductos.getSelectedRow();
        if (filaSeleccionada != -1) { // Se verifica que haya una fila seleccionada
            // Obtener el ID del producto seleccionado en la tabla
            int idProducto = (int) vista.jtableProductos.getValueAt(filaSeleccionada, 0);
            // Obtener los nuevos valores de los campos
            String nuevoNombre = vista.jtxfNombreProducto.getText().trim();
            String nuevaInformacion = vista.jtxfInformacion.getText().trim();
            double nuevoPrecio = Double.parseDouble(vista.jtxtPrecio.getText().trim());
            String nuevaCategoriaNombre = (String) vista.jcbxCategoria.getSelectedItem();
            byte[] imagenBytes = null; // Inicializar como null por defecto

            // Si se ha seleccionado una imagen nueva, actualizarla
            if (!vista.jlabelImagenInventario.getText().isEmpty()) {
                imagenBytes = obtenerBytesDeImagen();
            } else {
                // Si no se selecciona una nueva imagen, mantener la imagen actual
                imagenBytes = productoSeleccionado.getImagenP();
            }
            // Obtener la categoría seleccionada del combo box
            categorias nuevaCategoria = dao.obtenerCategoriaPorNombre(nuevaCategoriaNombre);
            if (nuevaCategoria == null) {
                JOptionPane.showMessageDialog(vista, "La categoría seleccionada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Obtener el stock del producto actual
            int stockActual = (int) vista.jtableProductos.getValueAt(filaSeleccionada, 2); // Asegúrate de que la columna del stock sea la correcta
            // Crear un objeto Producto con los nuevos valores y el stock actual
            Productos productoActualizado = new Productos(idProducto, nuevoNombre, stockActual, nuevaInformacion, nuevoPrecio, null, nuevaCategoria);
            // Actualizar el producto en la base de datos
            boolean actualizado = dao.editarProducto(productoActualizado);
            if (actualizado) {
                JOptionPane.showMessageDialog(vista, "Producto actualizado correctamente.");
                // Actualizar la tabla de productos si es necesario
                cargarProductosATabla();
                limpiarCaposRegistro();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al actualizar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, selecciona un producto a editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
*/
    }
    
    // Método para exportar el catálogo PDF
    private String exportarCatalogoPDF(String categoria) {

        // Obtén la lista de productos de la categoría seleccionada
        List<Productos> listaProductos = dao.obtenerProductosPorCategoria(categoria);

        // Crea una instancia del GeneradorPDF
        GeneradorPDF generadorPDF = new GeneradorPDF();

        // Genera el catálogo PDF y devuelve la ruta del archivo generado
        return generadorPDF.generarCatalogoPDF(listaProductos, categoria);
    }
    
    private void abrirPDF(String rutaArchivo) {
        try {
            File archivoPDF = new File(rutaArchivo);
            if (archivoPDF.exists()) {
                Desktop.getDesktop().open(archivoPDF);
            } else {
                JOptionPane.showMessageDialog(vista, "El archivo PDF no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(vista, "Error al abrir el archivo PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    //limpiar Registro de inventario
    private void limpiarCaposRegistro(){
        vista.jtxfNombreProducto.setText(null);
        vista.jcbxCategoria.setSelectedIndex(0);
        vista.jtxfInformacion.setText(null);
        vista.jtxtPrecio.setText(null);
        vista.jlabelImagenInventario.setIcon(null);
        productoSeleccionado = null;
    }
    
    //11. Limpiar campos de Registro Tipo Categoria
    private void limpiarCamposRegistroCategoria(){
        vista.jtxfNombreCategoria.setText(null);
    }
    
    //12. cambiar color de celda
    private class StockCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value instanceof Integer) {
                int stock = (Integer) value;
                if (stock <= 5) {
                    cell.setForeground(Color.RED); // Pintar de rojo si el stock es <= 5
                } else {
                    cell.setForeground(Color.BLACK); // De otro modo, pintar de negro
                }
            }
            return cell;
        }
    }
    
    //13. seleccionar imagen
    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png", "gif"));
        int resultado = fileChooser.showOpenDialog(vista);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String rutaImagen = archivoSeleccionado.getAbsolutePath();

            // Mostrar la imagen seleccionada en un JLabel
            ImageIcon imagenIcono = new ImageIcon(rutaImagen);
            Image imagenEscalada = imagenIcono.getImage().getScaledInstance(vista.jlabelImagenInventario.getWidth(), vista.jlabelImagenInventario.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada);
            vista.jlabelImagenInventario.setIcon(imagenEscaladaIcono);

            // Actualizar la ruta del archivo en el JTextField (o JLabel) para poder usarla en obtenerBytesDeImagen
            vista.jlabelImagenInventario.setText(rutaImagen);
        }
    }
    private void seleccionarImagenProducto() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png"));
        int resultado = fileChooser.showOpenDialog(vista);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            ImageIcon imagen = new ImageIcon(archivoSeleccionado.getPath());
            imagen.setDescription(archivoSeleccionado.getPath());
            vista.jlabelImagenInventario.setIcon(imagen);
        }
    }
    
    //14. OBTENER IMAGEN "no estamos usando este metodo" 
    private byte[] obtenerBytesDeImagen() {
        try {
            String rutaImagen = vista.jlabelImagenInventario.getText(); // Obtener la ruta del archivo desde el JTextField (o JLabel)
            File archivoImagen = new File(rutaImagen);
            FileInputStream fis = new FileInputStream(archivoImagen);
            byte[] buffer = new byte[(int) archivoImagen.length()];
            fis.read(buffer);
            fis.close();
            return buffer;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener bytes de la imagen: " + e.getMessage(),"Error al obtener la imagen", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
    
    private byte[] obtenerImagen() {
        if (vista.jlabelImagenInventario.getIcon() != null) {
            String rutaImagen = ((ImageIcon) vista.jlabelImagenInventario.getIcon()).getDescription();
            File imagenArchivo = new File(rutaImagen);
            byte[] imagen = new byte[(int) imagenArchivo.length()];
            try (FileInputStream fis = new FileInputStream(imagenArchivo)) {
                fis.read(imagen);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return imagen;
        }
        return null;
    }
}
