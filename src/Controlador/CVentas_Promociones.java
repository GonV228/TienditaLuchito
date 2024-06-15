package Controlador;
//importar clases
import Dao.DInventario;
import Dao.DPromociones;
import Modelo.Productos;
import Modelo.Promociones;
import Modelo.categorias;
import VistaVentas.Ventas_Promociones; //vista
import VistaVentas.Ventas; //menu

//librerias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CVentas_Promociones implements ActionListener{
    //inicializar
    Ventas_Promociones vista;
    Ventas menu;
    private DInventario dao;
    private DPromociones daoPromos;
    Productos productoSeleccionado;
    Promociones promoSeleccionada;
    int idProducto=0;
    int idPromo=0;
/////////////////////////////////////////////////////////////////////////////////    
    //constructor
/////////////////////////////////////////////////////////////////////////////////
    CVentas_Promociones(Ventas_Promociones vistaProm, Ventas menuu) {
        vista=vistaProm;
        menu=menuu;
        this.dao = new DInventario();
        this.daoPromos =new DPromociones();
        cargarCategoriasEnComboBox();
        cargarProductosATabla();
        cargarPromocionesATabla();
        vista.jtxfNombreProducto.setEditable(false);
        vista.jtxfIDProducto.setEditable(false);
        vista.jcbxFiltrarCat.addActionListener(this);
        vista.btnAgregar.addActionListener(this);
        vista.btnBorrar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnLimpiarCampos.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        
        
        vista.JtableMostraProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada1 = vista.JtableMostraProductos.getSelectedRow();
                if (filaSeleccionada1 != -1 ) {
                    idProducto= mostrarDatosProductoSeleccionado(filaSeleccionada1);
                    System.out.println("id de producto = "+idProducto);
                    
                }
            }
        });
        vista.jtblMostrarPromociones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada2 = vista.jtblMostrarPromociones.getSelectedRow();
                if (filaSeleccionada2 != -1) {
                    mostrarDatosPromocionSeleccionada(filaSeleccionada2);
                    System.out.println("id de promo = "+idPromo+" estoy en el museClicked");
                }
            }
        });
    }
/////////////////////////////////////////////////////////////////////////////////
//metodos
/////////////////////////////////////////////////////////////////////////////////  
    
//1
    private void cargarCategoriasEnComboBox() {
        List<categorias> listaCategorias = dao.obtenerCategoriasOrdenadas();
        vista.jcbxFiltrarCat.removeAllItems(); // Limpiar los elementos anteriores del combo box de filtro
        for (categorias categoria : listaCategorias) {       
            vista.jcbxFiltrarCat.addItem(categoria.getNombre()); // Agregar categorías al combo box de filtro
        }
    }
//2
   private void cargarProductosATabla() {
        String categoriaFiltro = (String) vista.jcbxFiltrarCat.getSelectedItem();
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
        modelo.addColumn("Categoría");
        for (Productos producto : listaProductos) {
            Object[] fila = {
                producto.getID_Producto(),
                producto.getNombreP(),
                producto.getStock(),
                producto.getInformacion(),
                producto.getPrecio(),
              
                producto.getCategoria().getNombre()
            };
            modelo.addRow(fila);
        }
        vista.JtableMostraProductos.setModel(modelo);
    }
//3
   private int mostrarDatosProductoSeleccionado(int filaSeleccionada) {
        idProducto = (int) vista.JtableMostraProductos.getValueAt(filaSeleccionada, 0);
        productoSeleccionado = dao.obtenerProductoPorID(idProducto);
        if (productoSeleccionado != null) {
            vista.jtxfNombreProducto.setText(productoSeleccionado.getNombreP());
            vista.jtxfIDProducto.setText(Integer.toString(productoSeleccionado.getID_Producto()));
        } else {
            // Manejar el caso en que productoSeleccionado es null
            JOptionPane.showMessageDialog(vista, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return idProducto;
   }
//4
    private void agregarPromocion() {
        String nombrePromo = vista.jtxtNombrePromo.getText().trim();
        String precioText = vista.jtxtPrecioVenta.getText().trim();
        String idProductoText = vista.jtxfIDProducto.getText().trim();
        String cantidadText = vista.jtxtCantPromo.getText().trim();

        if (nombrePromo.isEmpty() || precioText.isEmpty() || idProductoText.isEmpty() || cantidadText.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;//detener la ejecución
        }
        // Verificar si ya existe una promoción con el mismo nombre
        if (daoPromos.existePromocionConNombre(nombrePromo)) {
            JOptionPane.showMessageDialog(vista, "Ya existe una promoción con este nombre. Por favor, elija un nombre diferente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;//detener la ejecución para dar oportunidad al usuario de cambiar el nombre de la promocion por otro
        }
        //una vez validada la condición hacemos las conversiones a los tipos de datos respectivos para insertar a la bd
        try {
            double precio = Double.parseDouble(precioText);
            int idProducto = Integer.parseInt(idProductoText);
            int cantidad = Integer.parseInt(cantidadText);

            boolean insertado = daoPromos.insertarPromocion(new Promociones(0, nombrePromo, idProducto, precio, cantidad));
            if (insertado) {
                JOptionPane.showMessageDialog(vista, "Promoción agregada correctamente.");
                /* cargarCategoriasATabla();
                   cargarCategoriasEnComboBox();
                   limpiarCamposRegistroCategoria();
                   vista.jtxfNombreCategoria.setText(""); */
                cargarPromocionesATabla();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al agregar la promoción.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Por favor, ingrese valores numéricos válidos para precio, ID de producto y cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//5
    private void cargarPromocionesATabla(){
        List<Promociones> ListaPromos;
        ListaPromos = daoPromos.ObtenerPromos();
        System.out.println("id del producto");
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas de la tabla sean no editables
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("Nombre Promo");
        modelo.addColumn("ID producto");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Promocional");
        for(Promociones promo: ListaPromos){
            Object[]fila={
                promo.getIdPromocion(),
                promo.getNombrePromo(),
                promo.getIdProducto(),
                promo.getNombreProducto(),
                promo.getCantidad(),
                promo.getPrecioPromo()
                
            };
            modelo.addRow(fila);
        }
        vista.jtblMostrarPromociones.setModel(modelo);
       
    }
//6
    private int mostrarDatosPromocionSeleccionada(int filaSeleccionada){
        idPromo = (int) vista.jtblMostrarPromociones.getValueAt(filaSeleccionada, 0);
        promoSeleccionada = daoPromos.ObtenerPromosPorID(idPromo);
        if (promoSeleccionada != null) {
            vista.jtxtNombrePromo.setText(promoSeleccionada.getNombrePromo());
            vista.jtxtPrecioVenta.setText((promoSeleccionada.getPrecioPromo()).toString());
            vista.jtxfIDProducto.setText(String.valueOf(promoSeleccionada.getIdProducto()));
            vista.jtxfNombreProducto.setText(promoSeleccionada.getNombreProducto());
            vista.jtxtCantPromo.setText(String.valueOf(promoSeleccionada.getCantidad()));
        } else {
            // Manejar el caso en que promoSeleccionada es null
            JOptionPane.showMessageDialog(vista, "Promoción no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return idPromo;
    }
//7
    private void limpiarCampos(){
        vista.jtxtNombrePromo.setText("");
        vista.jtxtPrecioVenta.setText("");
        vista.jtxfIDProducto.setText("");
        vista.jtxfNombreProducto.setText("");
        vista.jtxtCantPromo.setText("");
    }
//8
    private void borrarPromocion() {
        int filaSeleccionada = vista.jtblMostrarPromociones.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idPromocion = (int) vista.jtblMostrarPromociones.getValueAt(filaSeleccionada, 0);
            int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro de que desea borrar esta promoción?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                boolean borrado = daoPromos.borrarPromocion(idPromocion);
                if (borrado) {
                    JOptionPane.showMessageDialog(vista, "Promoción borrada correctamente. No olvides hacer la validacion cuando se implemente ventas con clientes");
                    cargarPromocionesATabla();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al borrar la promoción.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, seleccione una promoción de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//9
    private void editarPromocion() {
        int filaSeleccionada = vista.jtblMostrarPromociones.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idPromocion = (int) vista.jtblMostrarPromociones.getValueAt(filaSeleccionada, 0);
            //obtenemos los valores de los campos que necesitamos para actualizar la bd
            String nombrePromo = vista.jtxtNombrePromo.getText().trim();
            String precioText = vista.jtxtPrecioVenta.getText().trim();
            String idProductoText = vista.jtxfIDProducto.getText().trim();
            String cantidadText = vista.jtxtCantPromo.getText().trim();

            if (nombrePromo.isEmpty() || precioText.isEmpty() || idProductoText.isEmpty() || cantidadText.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                //de una vez hacemos la conversión de los datos que no son te tipo String
                double precio = Double.parseDouble(precioText);
                int idProducto = Integer.parseInt(idProductoText);
                int cantidad = Integer.parseInt(cantidadText);

                Promociones promo = new Promociones(idPromocion, nombrePromo, idProducto, "", precio, cantidad);
                boolean actualizado = daoPromos.actualizarPromocion(promo); //hacemos update a la bd y con fe funciona
                if (actualizado) {
                    JOptionPane.showMessageDialog(vista, "Promoción actualizada correctamente.");
                    cargarPromocionesATabla();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al actualizar la promoción.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(vista, "Por favor, ingrese valores numéricos válidos para precio, ID de producto y cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, seleccione una promoción de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//10
    private void buscarPromocionPorID(int idPromocion) {
        Promociones promocion = daoPromos.ObtenerPromosPorID(idPromocion);
        if (promocion != null) {
            DefaultTableModel modelo = (DefaultTableModel) vista.jtblMostrarPromociones.getModel();
            modelo.setRowCount(0); // Limpiar la tabla
            Object[] fila = {
                promocion.getIdPromocion(),
                promocion.getNombrePromo(),
                promocion.getIdProducto(),
                promocion.getPrecioPromo(),
                promocion.getCantidad()
            };
            modelo.addRow(fila);
        } else {
            JOptionPane.showMessageDialog(vista, "Promoción no encontrada.");
        }
    }
//11
    private void buscarPromocionPorNombre(String nombrePromocion) {
        List<Promociones> listaPromociones = daoPromos.obtenerPromocionesPorNombre(nombrePromocion);
        DefaultTableModel modelo = (DefaultTableModel) vista.jtblMostrarPromociones.getModel();
        modelo.setRowCount(0); // Limpiar la tabla
        for (Promociones promocion : listaPromociones) {
            Object[] fila = {
                promocion.getIdPromocion(),
                promocion.getNombrePromo(),
                promocion.getIdProducto(),
                promocion.getPrecioPromo(),
                promocion.getCantidad()
            };
            modelo.addRow(fila);
        }
    }
    
    
//metodos abstractos
    

    @Override
    public void actionPerformed(ActionEvent e) {
        //FILTRAR CATEGORIAS
        if (e.getSource() == vista.jcbxFiltrarCat) {
            cargarProductosATabla();   
        }
        //AGREGAR PROMOCIONES
        if (e.getSource()==vista.btnAgregar){
            agregarPromocion();
        }
        //BORRAR PROMOCIONES
        if (e.getSource()==vista.btnBorrar){
            borrarPromocion();
            /*
                aca vamos a esperar a que la parte de ventas funcione correctamente porque
                hay que tener en cuenta que si borramos una promocion y esa promocion ya se ha usado en algunas ventas
                podriamos tener problemas, entonces por ahora no se implementara
                se hara una validacion para que haga una consulta si hay una venta con una promocion ya usada esa promocion no se podra borrar
                pero si la promocion no se usa en ninguna venta aun... se podra borrar tranquilamente
                "se necesita hacer una consulta a boletas y facturas"
            */
        }
        //EDITAR PROMOCIONES
        if (e.getSource()==vista.btnEditar){
            editarPromocion();
        }
        //LIMPIAR CAMPOS
        if (e.getSource()==vista.btnLimpiarCampos){
            limpiarCampos();
            System.out.println("funciono");
        }
        //BUSCAR PROMOCIONES
        if (e.getSource() == vista.btnBuscar) {
            String textoBusqueda = vista.jtxtBuscarPorNombrePromo.getText().trim();
            String idBusqueda = vista.jtxtBuscarPorID.getText().trim();

            if (!textoBusqueda.isEmpty() && !idBusqueda.isEmpty()) {
                try {
                    int idBusquedaPromo = Integer.parseInt(idBusqueda);
                    buscarPromocionPorID(idBusquedaPromo);
                    buscarPromocionPorNombre(textoBusqueda);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista, "Por favor, ingrese un ID de promoción válido.");
                }
            } else if (!textoBusqueda.isEmpty()) {
                buscarPromocionPorNombre(textoBusqueda);
            } else if (!idBusqueda.isEmpty()) {
                try {
                    int idBusquedaPromo = Integer.parseInt(idBusqueda);
                    buscarPromocionPorID(idBusquedaPromo);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista, "Por favor, ingrese un ID de promoción válido.");
                }
            } else {
                cargarPromocionesATabla();
            }
        }
        
        
        
    }
}    