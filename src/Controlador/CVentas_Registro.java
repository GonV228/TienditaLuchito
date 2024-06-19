package Controlador;

import Dao.DInventario;
import Dao.DVentaseInventario;
import Dao.DPromociones;
import Modelo.Productos;
import Modelo.categorias;
import Modelo.Promociones;
import VistaVentas.Ventas;
import VistaVentas.Ventas_Registro2;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.TableColumn;

public class CVentas_Registro implements ActionListener {

    // inicializar
    private Ventas_Registro2 vista;
    private Ventas menu;
    private DInventario dao; // DAO para interactuar con la base de datos
    private DVentaseInventario dao1; // DAO para interactuar con la base de datos
    private DPromociones daoPromos; //DAO para obtener promociones de la bd
    private Productos productoSeleccionado; // Producto seleccionado de la tabla

    // constructor
    public CVentas_Registro(Ventas_Registro2 VR, Ventas V) {
        vista = VR;
        menu = V;
        dao = new DInventario(); // Instancia del DAO
        dao1 = new DVentaseInventario(); // Instancia del DAO
        daoPromos = new DPromociones();
        vista.jtxtBuscarPorNombreProducto.addActionListener(this);
        vista.jtxtBuscarPorID.addActionListener(this);
        vista.jbtnBuscarProductos.addActionListener(this);
        vista.jbtnAgregarProductosVentas.addActionListener(this);
        vista.jcbxFiltrarCat.addActionListener(this);
        vista.jbtnBorrarProductoTabla.addActionListener(this);
        vista.jbtnPagaCon.addActionListener(this);
        vista.jbtnBoleta.addActionListener(this);
        // Hacer que jtxtImporteTotal, jtxtPagaCon y jtxtCambio no sean editables
        vista.jtxtImporteTotal.setEditable(false);
        vista.jtxtPagaCon.setEditable(false);
        vista.jtxtCambio.setEditable(false);

        // Llenar el JComboBox con las categorías al inicializar
        llenarComboBoxCategorias();
        // Llenar la tabla con todos los productos al inicializar
        llenarTablaProductos();
        //llenar tabla con proociones al inicializar
        llenarTablaPromociones();

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
// Agregar MouseListener a la tabla de ventas para modificar la cantidad
        vista.jtbRegistroDVentas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = vista.jtbRegistroDVentas.getSelectedRow();
                    int column = vista.jtbRegistroDVentas.getSelectedColumn();
                    if (row != -1 && column == 4) { // Si se hace doble clic en la columna de cantidad
                        actualizarCantidadProducto(row);
                    }
                }
                
/*                int filaSeleccionada = vista.jtbRegistroDVentas.getSelectedRow();
                int columnaCantidad = 4; // Índice de la columna "Cantidad"

                if (filaSeleccionada != -1 && e.getClickCount() == 2) {
                    // Obtener la cantidad actual del producto en la tabla de ventas
                    int cantidadActualTablaVentas = (int) vista.jtbRegistroDVentas.getValueAt(filaSeleccionada, columnaCantidad);

                    // Preguntar al usuario si desea modificar la cantidad
                    int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Quieres modificar la cantidad?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        // Pedir al usuario la nueva cantidad
                        String nuevaCantidadStr = JOptionPane.showInputDialog(vista, "Ingrese la nueva cantidad:");
                        if (nuevaCantidadStr == null || nuevaCantidadStr.isEmpty()) {
                            return; // Si se cancela o se deja vacío, no hacer nada
                        }

                        int nuevaCantidad;
                        try {
                            nuevaCantidad = Integer.parseInt(nuevaCantidadStr);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(vista, "Ingrese una cantidad válida.");
                            return;
                        }

                        if (nuevaCantidad <= 0) {
                            JOptionPane.showMessageDialog(vista, "La cantidad debe ser mayor que cero.");
                            return;
                        }

                        // Obtener el ID del producto en la tabla de ventas
                        int idProducto = (int) vista.jtbRegistroDVentas.getValueAt(filaSeleccionada, 0);

                        // Obtener el producto correspondiente al ID
                        Productos producto = dao.obtenerProductoPorID(idProducto);

                        // Calcular la diferencia de cantidad
                        int diferenciaCantidad = nuevaCantidad - cantidadActualTablaVentas;

                        // Verificar si la nueva cantidad es válida en base al stock disponible
                        if (producto.getStock() < diferenciaCantidad) {
                            JOptionPane.showMessageDialog(vista, "No hay suficiente stock para esa cantidad.");
                            return;
                        }

                        // Actualizar la cantidad en la tabla de ventas
                        vista.jtbRegistroDVentas.setValueAt(nuevaCantidad, filaSeleccionada, columnaCantidad);

                        // Obtener el stock original del producto antes de modificar la cantidad
                        int stockOriginal = producto.getStock();

                        // Actualizar el stock del producto en la tabla de productos
                        producto.setStock(stockOriginal - diferenciaCantidad);
                        dao1.actualizarProducto(producto);

                        // Actualizar la tabla de productos para reflejar el nuevo stock
                        llenarTablaProductos();

                        // Calcular y actualizar el importe total
                        calcularImporteTotal();
                    }
                }*/
            }
        });

        // Configurar el modelo de la tabla de ventas
        DefaultTableModel modeloVentas = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que las celdas no sean editables
            }
        };
        modeloVentas.addColumn("ID");
        modeloVentas.addColumn("Nombre");
        modeloVentas.addColumn("Informacion");
        modeloVentas.addColumn("Precio");
        modeloVentas.addColumn("Cantidad");
        modeloVentas.addColumn("Promocion");
        modeloVentas.addColumn("Importe");

        // Asignar el modelo a la tabla de ventas
        vista.jtbRegistroDVentas.setModel(modeloVentas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnBuscarProductos) {
            buscarProductos();
        } else if (e.getSource() == vista.jbtnAgregarProductosVentas) {
            agregarProductoAVentas();
        } else if (e.getSource() == vista.jbtnBorrarProductoTabla) {
            borrarProductoDeVentas();
        } else if (e.getSource() == vista.jbtnPagaCon) {
            System.out.println("estoy funcionando");
            calcularCambio();
        } else if (e.getSource() == vista.jbtnBoleta) {
            // Verificar que se haya ingresado el pago con
            if (vista.jtxtPagaCon.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debe ingresar el monto con el que paga el cliente.");
            } else {
                generarBoleta();
            }
        }
    }

    // Método para generar la boleta
    private void generarBoleta() {
        // Verificar que se haya ingresado el pago con
        if (vista.jtxtPagaCon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Debe ingresar el monto con el que paga el cliente.");
            return;
        }

        // Obtener el importe total, el pago con y el cambio
        double importeTotal;
        double pagaCon;
        double cambio;

        try {
            importeTotal = Double.parseDouble(vista.jtxtImporteTotal.getText());
            pagaCon = Double.parseDouble(vista.jtxtPagaCon.getText());
            cambio = Double.parseDouble(vista.jtxtCambio.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Ingrese cantidades válidas para generar la boleta.");
            return;
        }

        // Crear el contenido de la boleta
        StringBuilder contenidoBoleta = new StringBuilder();
        contenidoBoleta.append("***************************\n");
        contenidoBoleta.append("          Tienda Luchito\n");
        contenidoBoleta.append("***************************\n\n");

        // Detalle de los productos vendidos
        DefaultTableModel modeloVentas = (DefaultTableModel) vista.jtbRegistroDVentas.getModel();
        contenidoBoleta.append("Detalle de la Venta:\n");
        contenidoBoleta.append("------------------------------------------------\n");
        contenidoBoleta.append(String.format("%-5s %-25s %-10s %-10s\n", "ID", "Producto", "Cantidad", "Importe"));
        contenidoBoleta.append("------------------------------------------------\n");

        for (int i = 0; i < modeloVentas.getRowCount(); i++) {
            int idProducto = (int) modeloVentas.getValueAt(i, 0);
            String nombreProducto = (String) modeloVentas.getValueAt(i, 1);
            int cantidad = (int) modeloVentas.getValueAt(i, 4);
            double importe = (double) modeloVentas.getValueAt(i, 6);

            contenidoBoleta.append(String.format("%-5d %-25s %-10d %-10.2f\n", idProducto, nombreProducto, cantidad, importe));
        }

        contenidoBoleta.append("------------------------------------------------\n");

        // Información de pago y cambio
        contenidoBoleta.append(String.format("Total a Pagar: S/ %.2f\n", importeTotal));
        contenidoBoleta.append(String.format("Pago con: S/ %.2f\n", pagaCon));
        contenidoBoleta.append(String.format("Cambio: S/ %.2f\n", cambio));

        // Mostrar la boleta en un JOptionPane
        JOptionPane.showMessageDialog(vista, contenidoBoleta.toString(), "Boleta de Venta", JOptionPane.PLAIN_MESSAGE);
    }

    private void calcularCambio() {
        // Obtener el importe total
        double importeTotal;
        try {
            importeTotal = Double.parseDouble(vista.jtxtImporteTotal.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "El importe total no es válido.");
            return;
        }

        // Pedir la cantidad con la que paga el cliente
        String pagaConStr = JOptionPane.showInputDialog(vista, "Ingrese la cantidad con la que paga el cliente:");
        if (pagaConStr == null || pagaConStr.isEmpty()) {
            return; // Si se cancela el diálogo o se deja vacío, no hacer nada
        }

        double pagaCon;
        try {
            pagaCon = Double.parseDouble(pagaConStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Ingrese una cantidad válida.");
            return;
        }

        if (pagaCon < importeTotal) {
            JOptionPane.showMessageDialog(vista, "La cantidad con la que paga el cliente no puede ser menor que el importe total.");
            return;
        }

        // Calcular el cambio
        double cambio = pagaCon - importeTotal;

        // Actualizar los campos de texto
        vista.jtxtPagaCon.setText(String.format("%.2f", pagaCon));
        vista.jtxtCambio.setText(String.format("%.2f", cambio));
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
        buscarPromociones();
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

    //metodo para llenar la tabla de promociones
    private void llenarTablaPromociones() {
        List<Promociones> promociones = daoPromos.ObtenerPromos();
        DefaultTableModel modeloPromos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que las celdas no sean editables
            }
        };
        modeloPromos.addColumn("ID");
        modeloPromos.addColumn("Nombre");
        modeloPromos.addColumn("Producto");
        modeloPromos.addColumn("Precio");
        modeloPromos.addColumn("Cantidad");

        for (Promociones promo : promociones) {
            Object[] fila = {
                promo.getIdPromocion(),
                promo.getNombrePromo(),
                promo.getNombreProducto(),
                promo.getPrecioPromo(),
                promo.getCantidad()
            };
            modeloPromos.addRow(fila);
        }
        vista.JtableMostraPromos.setModel(modeloPromos);
    }
    
    //hace la busqueda de promos por el nombre del producto ingresado en el campo jtxtBuscarPorNombreProducto
    private void buscarPromociones() {
        String nombreProducto = vista.jtxtBuscarPorNombreProducto.getText();
        List<Promociones> resultadosPromociones = daoPromos.buscarPromocionesPorNombreProducto(nombreProducto);
        cargarPromocionesATabla(resultadosPromociones);
    }
    
    private void cargarPromocionesATabla(List<Promociones> listaPromociones) {
        DefaultTableModel modeloPromos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas de la tabla sean no editables
            }
        };
        modeloPromos.addColumn("ID");
        modeloPromos.addColumn("Nombre");
        modeloPromos.addColumn("Producto");
        modeloPromos.addColumn("Precio");
        modeloPromos.addColumn("Cantidad");
        for (Promociones promo : listaPromociones) {
            Object[] fila = {
                promo.getIdPromocion(),
                promo.getNombrePromo(),
                promo.getNombreProducto(),
                promo.getPrecioPromo(),
                promo.getCantidad()
            };
            modeloPromos.addRow(fila);
        }
        vista.JtableMostraPromos.setModel(modeloPromos);
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

    // Método para agregar el producto seleccionado a la tabla de ventas y actualizar el stock en tiempo real
    private void agregarProductoAVentas() {
        if (productoSeleccionado == null) {
            JOptionPane.showMessageDialog(vista, "No hay ningún producto seleccionado.");
            return;
        }

        // Obtener la cantidad a agregar
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

        // Verificar si el producto ya está en la tabla de ventas
        DefaultTableModel modeloVentas = (DefaultTableModel) vista.jtbRegistroDVentas.getModel();
        for (int i = 0; i < modeloVentas.getRowCount(); i++) {
            int idProductoTabla = (int) modeloVentas.getValueAt(i, 0);
            if (idProductoTabla == productoSeleccionado.getID_Producto()) {
                // El producto ya está en la tabla, actualizar la cantidad
                int cantidadActual = (int) modeloVentas.getValueAt(i, 4);
                int nuevaCantidad = cantidadActual + cantidad;
                if (nuevaCantidad > productoSeleccionado.getStock()) {
                    JOptionPane.showMessageDialog(vista, "No hay suficiente stock para agregar esa cantidad.");
                    return;
                }
                
                Promociones promo = verificarPromociones(productoSeleccionado.getID_Producto(), nuevaCantidad);
                double precioUnitario = productoSeleccionado.getPrecio();
                double precioFinal = (promo != null) ? promo.getPrecioPromo() : precioUnitario;
                double importe = precioFinal * nuevaCantidad;
            
                // Actualizar la cantidad en la tabla de ventas
                modeloVentas.setValueAt(nuevaCantidad, i, 4);
                modeloVentas.setValueAt((promo != null) ? promo.getNombrePromo() : "", i, 5); // Actualizar promoción
                modeloVentas.setValueAt(precioFinal, i, 3); // Actualizar precio unitario con la promoción
                modeloVentas.setValueAt(importe, i, 6); // Actualizar importe
                
                // Actualizar el stock del producto seleccionado
                productoSeleccionado.setStock(productoSeleccionado.getStock() - cantidad);
                dao1.actualizarProducto(productoSeleccionado);

                // Actualizar la tabla de productos para reflejar el nuevo stock
                llenarTablaProductos();

                // Calcular y actualizar el importe total
//                calcularImporteTotal();
                actualizarTotal();
                return; // Salir del método si se actualizó la cantidad
            }
        }   
        
        // Si el producto no está en la tabla, agregarlo como una nueva fila
//        double importe = cantidad * productoSeleccionado.getPrecio();
        
        Promociones promo = verificarPromociones(productoSeleccionado.getID_Producto(), cantidad);
        double precioUnitario = productoSeleccionado.getPrecio();
        double precioFinal = (promo != null) ? promo.getPrecioPromo() : precioUnitario;
        double importe = precioFinal * cantidad;
        
        Object[] fila = {
            productoSeleccionado.getID_Producto(),
            productoSeleccionado.getNombreP(),
            productoSeleccionado.getInformacion(),
            productoSeleccionado.getPrecio(),
            cantidad,
            (promo != null) ? promo.getNombrePromo() : "", // Nombre de la promoción si aplica
            importe
        };
        modeloVentas.addRow(fila);

        // Actualizar el stock del producto seleccionado
        productoSeleccionado.setStock(productoSeleccionado.getStock() - cantidad);
        dao1.actualizarProducto(productoSeleccionado);

        // Actualizar la tabla de productos para reflejar el nuevo stock
        llenarTablaProductos();

        // Calcular y actualizar el importe total
//        calcularImporteTotal();
        actualizarTotal();
    }

   private Promociones verificarPromociones(int idProducto, int cantidad) {
        List<Promociones> promociones = daoPromos.obtenerPromocionesPorProducto(String.valueOf(idProducto));
        for (Promociones promo : promociones) {
            if (cantidad >= promo.getCantidad()) {
                int gruposDePromocion = cantidad / promo.getCantidad();
                int cantidadRestante = cantidad % promo.getCantidad();
                double precioConPromo = gruposDePromocion * promo.getPrecioPromo();
                double precioSinPromo = cantidadRestante * productoSeleccionado.getPrecio();
                double precioFinal = precioConPromo + precioSinPromo;
                promo.setPrecioPromo(precioFinal / cantidad);
                return promo;
            }
        }
        return null;
    } 
    
    // Método para actualizar el total
    private void actualizarTotal() {
        DefaultTableModel modelo = (DefaultTableModel) vista.jtbRegistroDVentas.getModel();
        double total = 0.0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            total += Double.parseDouble(modelo.getValueAt(i, 6).toString());
        }
        vista.jtxtImporteTotal.setText(String.format("%.2f", total));
    }
    
    private void borrarProductoDeVentas() {
        // Obtener la fila seleccionada de la tabla de ventas
        int filaSeleccionada = vista.jtbRegistroDVentas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un producto para eliminar.");
            return;
        }

        // Obtener el ID del producto a eliminar
        int idProducto = (int) vista.jtbRegistroDVentas.getValueAt(filaSeleccionada, 0);
        // Obtener la cantidad a restablecer al stock
        int cantidad = (int) vista.jtbRegistroDVentas.getValueAt(filaSeleccionada, 4);

        // Preguntar al usuario si está seguro de eliminar el producto
        int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Estás seguro de eliminar el producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Eliminar la fila seleccionada de la tabla de ventas
            DefaultTableModel modeloVentas = (DefaultTableModel) vista.jtbRegistroDVentas.getModel();
            modeloVentas.removeRow(filaSeleccionada);

            // Obtener el producto correspondiente al ID
            Productos producto = dao.obtenerProductoPorID(idProducto);

            // Actualizar el stock del producto en la tabla de productos
            producto.setStock(producto.getStock() + cantidad);
            dao1.actualizarProducto(producto);

            // Actualizar la tabla de productos para reflejar el nuevo stock
            llenarTablaProductos();

            // Calcular y actualizar el importe total
            calcularImporteTotal();
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

// Método para calcular el importe total de todos los productos en la tabla de ventas
    private void calcularImporteTotal() {
        double importeTotal = 0;
        DefaultTableModel modeloVentas = (DefaultTableModel) vista.jtbRegistroDVentas.getModel();

        for (int i = 0; i < modeloVentas.getRowCount(); i++) {
            int cantidad = (int) modeloVentas.getValueAt(i, 4);
            double precio = (double) modeloVentas.getValueAt(i, 3);
            double importe = cantidad * precio;
            modeloVentas.setValueAt(importe, i, 6); // Actualizar el importe en la tabla de ventas
            importeTotal += importe;
        }

        vista.jtxtImporteTotal.setText(String.format("%.2f", importeTotal));
    }

    
    private void actualizarCantidadProducto(int row) {
        DefaultTableModel modeloVentas = (DefaultTableModel) vista.jtbRegistroDVentas.getModel();
        int idProducto = (int) modeloVentas.getValueAt(row, 0);
        int cantidadActual = (int) modeloVentas.getValueAt(row, 4);

        // Obtener la nueva cantidad
        String nuevaCantidadStr = JOptionPane.showInputDialog(vista, "Ingrese la nueva cantidad:", cantidadActual);
        if (nuevaCantidadStr == null || nuevaCantidadStr.isEmpty()) {
            return; // Si se cancela el diálogo o se deja vacío, no hacer nada
        }

        int nuevaCantidad;
        try {
            nuevaCantidad = Integer.parseInt(nuevaCantidadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Ingrese una cantidad válida.");
            return;
        }

        if (nuevaCantidad <= 0) {
            JOptionPane.showMessageDialog(vista, "La cantidad debe ser mayor que cero.");
            return;
        }

        // Verificar si hay suficiente stock
        Productos producto = dao.obtenerProductoPorID(idProducto);
        if (nuevaCantidad > producto.getStock() + cantidadActual) { // + cantidadActual porque ya está en la tabla
            JOptionPane.showMessageDialog(vista, "No hay suficiente stock para agregar esa cantidad.");
            return;
        }

        // Actualizar la cantidad en la tabla de ventas
        modeloVentas.setValueAt(nuevaCantidad, row, 4);

        // Verificar promociones
        Promociones promo = verificarPromociones(idProducto, nuevaCantidad);
        if (promo != null) {
            modeloVentas.setValueAt(promo.getNombrePromo(), row, 5);
            modeloVentas.setValueAt(promo.getPrecioPromo(), row, 3); // Actualizar precio unitario con la promoción
        } else {
            modeloVentas.setValueAt("", row, 5); // No hay promoción
            modeloVentas.setValueAt(producto.getPrecio(), row, 3); // Restaurar precio original
        }

        // Actualizar el importe
        double precioUnitario = (double) modeloVentas.getValueAt(row, 3);
        double importe = nuevaCantidad * precioUnitario;
        modeloVentas.setValueAt(importe, row, 6);

        // Calcular y actualizar el importe total
        actualizarTotal();

        // Actualizar el stock del producto seleccionado
        producto.setStock(producto.getStock() + cantidadActual - nuevaCantidad); // Restablecer stock original y sustraer nueva cantidad
        dao1.actualizarProducto(producto);

        // Actualizar la tabla de productos para reflejar el nuevo stock
        llenarTablaProductos();
    }

        
}
