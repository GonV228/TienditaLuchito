package Controlador;
//importar clases
import Dao.DInventario;
import VistaInventario.Inventario_Pedido;
import VistaInventario.Inventario_Registro;
import Dao.DPedidos;
import Modelo.Pedidos;
import VistaInventario.Inventario;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class CInventario_Pedido implements ActionListener{
    //inicializar
    Inventario_Pedido vista;
    Inventario menu;
   
    int id;
    String producto;//nombre producto pedido 
    double costoTPedido;//costo total del pedido
    double precioVPedido; //precio de venta del producto que pedimos
    String fechaPPedido; //fecha de realizacion del pedido 
    String fechaEPedido; //fecha de entrega del pedido
    String estadoPedido; //estado del pedido
    int cantidadPedido; //cantidad pedido
    
    double costoUnidad=0.0;
    boolean accion;
  
    
    //constructor
    //constructor para hacer nuevo pedido
    public CInventario_Pedido(Inventario_Pedido vista, String nombreProd, Inventario menu, boolean accion){
        this.vista=vista;
        this.producto=nombreProd;
        this.menu=menu;
        this.accion=accion; //verdadero=btnhacerpedido ///falso=btnActualizar
        
        vista.btnAceptar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.jbtnCalcular.addActionListener(this);
        
        vista.jtxfNombreProducto.setText(producto);//asignar valor al campo
        vista.jtxfNombreProducto.setEditable(false);//desactivar la edición
        vista.jtxtCostoUnidad.setEditable(false);//desactivar costo unidad
        
        vista.setVisible(true);
        vista.setTitle("Pedido");
        vista.setLocationRelativeTo(null);
    }
    //constructor para actualizar pedido
    public CInventario_Pedido(Inventario_Pedido vista, int idPedido,String nombreProd, double costoTP, double precioVP, 
                            String fechaPP, String fechaEP, String estadoP, int cantidadP,
                            Inventario menu, boolean accion) throws ParseException {
        this.vista = vista;
        this.id=idPedido;
        this.producto = nombreProd;
        this.menu = menu;
        this.accion = accion; // verdadero = btnhacerpedido /// falso = btnActualizar
        this.costoTPedido = costoTP;
        this.precioVPedido = precioVP;
        this.fechaPPedido = fechaPP;
        this.fechaEPedido = fechaEP;
        this.estadoPedido = estadoP;
        this.cantidadPedido = cantidadP;

        vista.btnAceptar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.jbtnCalcular.addActionListener(this);

        vista.jtxfNombreProducto.setText(producto); // asignar valor al campo
        vista.jtxtCantidad.setText(Integer.toString(cantidadP));
        vista.jtxtCostoTotal.setText(Double.toString(costoTP));
        double costoU=costoTP/cantidadP;
        vista.jtxtCostoUnidad.setText(String.valueOf(costoU));
        vista.jtxtPrecioVenta.setText(Double.toString(precioVP));
        // El formato de la fecha en la cadena
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");       
        // Convertir la cadena a Date
        try {
            Date fechaDateP = dateFormat.parse(fechaPP);
            Date fechaDateE = dateFormat.parse(fechaEP);
            // Actualizar los componentes de fecha en el EDT
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    if (fechaDateP != null) {
                        System.out.println("Fecha Pedido parseada correctamente: " + fechaDateP);
                        vista.jdtcFechaPedido2.setDate(fechaDateP);
                        vista.jdtcFechaPedido2.repaint();
                    } else {
                        System.out.println("Fecha Pedido no pudo ser parseada: " + fechaPP);
                    }
                    if (fechaDateE != null) {
                        System.out.println("Fecha Entrega parseada correctamente: " + fechaDateE);
                        vista.jdtcFechaEntrega2.setDate(fechaDateE);
                        vista.jdtcFechaEntrega2.repaint();
                    } else {
                        System.out.println("Fecha Entrega no pudo ser parseada: " + fechaEP);
                    }
                }
            });
        } catch (ParseException e) {
            e.printStackTrace();
        }
        vista.jcbxEstado.setSelectedItem(estadoP);
        vista.jtxfNombreProducto.setEditable(false); // desactivar la edición
        vista.jtxtCostoUnidad.setEditable(false); // desactivar costo unidad

        vista.setVisible(true);
        vista.setTitle("Pedido");
        vista.setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAceptar){
            //obtener valores de los campos de entrada
            if(this.accion){//verdadero=btnhacerpedido 
                registrarNuevoPedido();
                return; //detener la ejecucion
            }else{
                try { 
                    System.out.println("actualizar pedido");
                    actualizarPedido();
                } catch (ParseException ex) {
                    System.out.println("estoy en un catch de btnAceptar en CInventario_Pedido");
                    Logger.getLogger(CInventario_Pedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }           
        }
        
        if (e.getSource() == vista.btnCancelar){
            //cerrar la vista pedidos
            vista.dispose();
        }
        
        if(e.getSource() == vista.jbtnCalcular){
            //obtener valores
            String cantidadStr = vista.jtxtCantidad.getText(); // int
            String costoTotalStr = vista.jtxtCostoTotal.getText(); // double
            // Conversión de cadenas a sus respectivos tipos
            int cantidad = Integer.parseInt(cantidadStr);
            double costoTotal = Double.parseDouble(costoTotalStr);
            this.cantidadPedido=cantidad;
            this.costoTPedido=costoTotal;
            
            this.costoUnidad=this.costoTPedido/this.cantidadPedido;
            System.out.println("costo double "+this.costoUnidad);
            System.out.println("costo convertido "+String.valueOf(this.costoUnidad));
            vista.jtxtCostoUnidad.setText(String.valueOf(this.costoUnidad));
        }
    }
    
    //metodos
    //obtener valores de los campos de entrada
    private void registrarNuevoPedido(){
        //instanciar el dao cuando lo tenga xd
        DPedidos daoPedidoRegistrar=new DPedidos();
        try {
            // obtener valores en string y date
            String nombre = vista.jtxfNombreProducto.getText();
            String cantidadStr = vista.jtxtCantidad.getText(); // int
            String costoTotalStr = vista.jtxtCostoTotal.getText(); // double
            String precioVentaStr = vista.jtxtPrecioVenta.getText(); // double
            Date fechaPedidoDate = vista.jdtcFechaPedido2.getDate(); // date
            Date fechaEntregaDate = vista.jdtcFechaEntrega2.getDate(); // date
            System.out.println("fecha nueva "+vista.jdtcFechaEntrega2.getDate());
            String estadoPedido =(String) vista.jcbxEstado.getSelectedItem();

            if(nombre.equals("")||cantidadStr.equals("")||costoTotalStr.equals("")||
                    precioVentaStr.equals("")||fechaPedidoDate==null||fechaEntregaDate==null){
                System.out.println("nombre: "+nombre+"\n"+
                        "cantidad: "+cantidadStr+"\n"+
                        "costoT: "+costoTotalStr+"\n"+
                        "precioV: "+precioVentaStr+"\n"+
                        "FechaP: "+fechaPedidoDate+"\n"+
                        "FechaE: "+fechaEntregaDate+"\n"+
                        "Estado: "+estadoPedido+"\n"
                        );
                JOptionPane.showMessageDialog(null, "Ingrese valores en todos los campos");
                return;
            }
            // Conversión de cadenas a sus respectivos tipos
            int cantidad = Integer.parseInt(cantidadStr);
            double costoTotal = Double.parseDouble(costoTotalStr);
            double precioVenta = Double.parseDouble(precioVentaStr);
            

            // Formateo de las fechas para MySQL
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaPedidoStr = dateFormat.format(fechaPedidoDate);
            String fechaEntregaStr = dateFormat.format(fechaEntregaDate);

            // Impresión en consola porsiacaso :D
            System.out.println("Nombre del producto: " + nombre);
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Costo Total: " + costoTotal);
            System.out.println("Precio Venta: " + precioVenta);
            System.out.println("Fecha Pedido: " + fechaPedidoStr);
            System.out.println("Fecha Entrega: " + fechaEntregaStr);

            //instanciamos objeto tipo Pedidos
            Pedidos pedidoAlmacenar=new Pedidos(nombre, cantidad, costoTotal, precioVenta, fechaPedidoStr, fechaEntregaStr, estadoPedido);
            boolean registroExitoso = daoPedidoRegistrar.registrarNuevoPedido(pedidoAlmacenar);

            if (registroExitoso) {
                JOptionPane.showMessageDialog(null, "Pedido registrado exitosamente");
                if(pedidoRecibido()){//si es true significa que en estado pedido se ha seleccionado "Recibido" por lo tanto se actualiza el stock
                    DInventario daoProductoStock=new DInventario();
                    boolean actualizarStock = daoProductoStock.aumentarStockPorNombreProducto(nombre, cantidad);
                    if(actualizarStock){
                        JOptionPane.showMessageDialog(null, "Stock actualizado exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar el Stock. Por favor, inténtalo de nuevo.");
                    }
                }
                actualizarVista();
                vista.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar pedido. Por favor, inténtalo de nuevo.");
            }
            // Prepara y ejecuta la consulta con los valores obtenidos y convertidos
            // Ejecuta la consulta aquí

        } catch (NumberFormatException e) {
            System.err.println("Error al convertir un número: " + e.getMessage());
        } 
        
    }
    //actualizar pedidos
    private void actualizarPedido() throws ParseException {
        try {
            // Obtener valores actuales de los campos de la vista
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");       
        // Convertir la cadena a Date
        
            Date fechaDateP = dateFormat.parse(this.fechaPPedido);
            Date fechaDateE = dateFormat.parse(this.fechaEPedido);
            
            String nombreProductoNuevo = vista.jtxfNombreProducto.getText();
            int cantidadPedidoNuevo = Integer.parseInt(vista.jtxtCantidad.getText());
            double costoTotalNuevo = Double.parseDouble(vista.jtxtCostoTotal.getText());
            double precioVentaNuevo = Double.parseDouble(vista.jtxtPrecioVenta.getText());
            Date fechaPedidoNueva = vista.jdtcFechaPedido2.getDate();
            Date fechaEntregaNueva = vista.jdtcFechaEntrega2.getDate();
            String estadoPedidoNuevo = (String) vista.jcbxEstado.getSelectedItem();
            System.out.println("nombre: "+nombreProductoNuevo+" "+producto+"\n"+
                    "cantidad: "+cantidadPedidoNuevo+" "+cantidadPedido+"\n"+
                    "costoT: "+costoTotalNuevo+" "+costoTPedido+"\n"+
                    "precioV: "+precioVentaNuevo+" "+precioVPedido+"\n"+
                    "fechaPedido: "+fechaPedidoNueva+" "+fechaDateP+"\n"+
                    "fechaEntrega: "+fechaEntregaNueva+" "+fechaDateE+"\n"+
                    "estado: "+estadoPedidoNuevo+" "+estadoPedido+"\n"
                                );
            
            //dar formato a fechas como tipo Date
            
            
            // Comparar con los valores actuales almacenados en las variables de la clase
            if (!nombreProductoNuevo.equals(producto) || cantidadPedidoNuevo != cantidadPedido ||
                costoTotalNuevo != costoTPedido || precioVentaNuevo != precioVPedido ||
                !fechaDateP.equals(fechaPedidoNueva) ||
                !fechaDateE.equals(fechaEntregaNueva) ||
                !estadoPedidoNuevo.equals(estadoPedido)) {
                System.out.println("estamos en el if");
                // Construir objeto Pedidos con los nuevos valores
                Pedidos pedidoActualizado = new Pedidos(id, nombreProductoNuevo, cantidadPedidoNuevo,
                                                        costoTotalNuevo, precioVentaNuevo,
                                                        dateFormat.format(fechaPedidoNueva),
                                                        dateFormat.format(fechaEntregaNueva),
                                                        estadoPedidoNuevo);

                // Instanciar DPedidos
                DPedidos daoPedidos = new DPedidos();

                // Llamar al método de actualización en DPedidos
                boolean actualizacionExitosa = daoPedidos.actualizarPedido(pedidoActualizado);

                if (actualizacionExitosa) {
                    JOptionPane.showMessageDialog(null, "Pedido actualizado exitosamente");
                    if(pedidoRecibido()){//si es true se actualiza el stock de productos
                        DInventario daoProdcutoStock=new DInventario();
                        boolean actualizarstok = daoProdcutoStock.aumentarStockPorNombreProducto(nombreProductoNuevo, cantidadPedido);
                        if(actualizarstok){
                            JOptionPane.showMessageDialog(null, "Stock actualizado exitosamente");
                        }else{
                            JOptionPane.showMessageDialog(null, "No se pudo actualizar el Stock. Inténtalo de nuevo.");
                        }
                    } 
                    actualizarVista();
                    vista.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el pedido. Inténtalo de nuevo.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se detectaron cambios para actualizar el pedido.");
                vista.dispose();
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("aqui toy");
            JOptionPane.showMessageDialog(null, "Error al actualizar el pedido. Por favor, inténtalo de nuevo.");
        }
    }

    private boolean pedidoRecibido (){
        String pedido=(String) vista.jcbxEstado.getSelectedItem();
        if(pedido.equals("Recibido")){
            return true;
        }
        return false;
    }
    
    
    
    //actualizar vista de inventario_registro
    private void actualizarVista() {
        Inventario_Registro RegisI = new Inventario_Registro();
        CInventario_Registro controlador = new CInventario_Registro(RegisI, menu);
        menu.PrincipalInventario.removeAll();
        menu.PrincipalInventario.setLayout(new BorderLayout());
        menu.PrincipalInventario.add(RegisI.getContentPane(), BorderLayout.CENTER);
        menu.PrincipalInventario.revalidate();
        menu.PrincipalInventario.repaint();
    }
    
    

}




/*

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

*/