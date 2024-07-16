package Dao;

import Modelo.Productos;
import Modelo.Venta;
import Modelo.VentaDetalle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DVentaseInventario {

// Método para buscar productos por ID o nombre
public List<Productos> buscarProductosVenta(String idProducto, String nombreProducto) {
    // Lista para almacenar los resultados de la búsqueda
    List<Productos> resultados = new ArrayList<>();

    // Consulta SQL para buscar productos por ID o nombre
    String sql = "SELECT ID_Producto, Nombre, Stock, Informacion, Precio FROM Productos WHERE ID_Producto = ? OR Nombre LIKE ?";

    // Establecer la conexión a la base de datos
    ConexionBD conexionBD = new ConexionBD();
    try (Connection conn = conexionBD.conectar(); PreparedStatement statement = conn.prepareStatement(sql)) {
        // Establecer los parámetros de la consulta
        statement.setString(1, idProducto);
        statement.setString(2, "%" + nombreProducto + "%");

        // Ejecutar la consulta
        try (ResultSet resultSet = statement.executeQuery()) {
            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                Productos producto = new Productos();
                producto.setID_Producto(resultSet.getInt("ID_Producto"));
                producto.setNombreP(resultSet.getString("Nombre"));
                producto.setStock(resultSet.getInt("Stock"));
                producto.setInformacion(resultSet.getString("Informacion"));
                producto.setPrecio(resultSet.getDouble("Precio"));
                // Agregar más campos según tu estructura de base de datos
                resultados.add(producto);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return resultados;
}

    // Método para actualizar el stock de un producto
    public void actualizarProducto(Productos producto) {
        // Consulta SQL para actualizar el stock de un producto
        String sql = "UPDATE Productos SET Stock = ? WHERE ID_Producto = ?";

        // Establecer la conexión a la base de datos
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conn = conexionBD.conectar(); PreparedStatement statement = conn.prepareStatement(sql)) {
            // Establecer los parámetros de la consulta
            statement.setInt(1, producto.getStock());
            statement.setInt(2, producto.getID_Producto());

            // Ejecutar la actualización
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       // Método para insertar una nueva venta y sus detalles en la base de datos
    public boolean insertarVentaConDetalle(Venta venta, List<VentaDetalle> detalles) {
        // Consulta SQL para insertar una nueva venta
        String sqlVenta = "INSERT INTO Ventas (ID_Producto, Cantidad, Precio_Unitario, Total, Tipo_Comprobante) " +
                          "VALUES (?, ?, ?, ?, ?)";

        // Consulta SQL para insertar detalles de venta
        String sqlVentaDetalle = "INSERT INTO VentaDetalle (ID_Venta, ID_Producto, Nombre, PrecioUnitario, Cantidad, Importe) " +
                                 "VALUES (?, ?, ?, ?, ?, ?)";

        // Establecer la conexión a la base de datos
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conn = conexionBD.conectar();
             PreparedStatement statementVenta = conn.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement statementVentaDetalle = conn.prepareStatement(sqlVentaDetalle)) {

            // Establecer los parámetros de la consulta de venta principal
            statementVenta.setInt(1, venta.getID_Producto());
            statementVenta.setInt(2, venta.getCantidad());
            statementVenta.setDouble(3, venta.getPrecio_Unitario());
            statementVenta.setDouble(4, venta.getTotal());
            statementVenta.setString(5, venta.getTipo_Comprobante());

            // Ejecutar la inserción de la venta principal
            int filasInsertadasVenta = statementVenta.executeUpdate();

            // Verificar si la inserción de la venta principal fue exitosa
            if (filasInsertadasVenta == 0) {
                throw new SQLException("Fallo al insertar la venta. No se insertaron filas.");
            }

            // Obtener la clave generada automáticamente (ID_Venta)
            try (ResultSet generatedKeys = statementVenta.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idVentaGenerada = generatedKeys.getInt(1);
                    // Iterar sobre los detalles de la venta y agregarlos
                    for (VentaDetalle detalle : detalles) {
                        // Establecer los parámetros de la consulta de venta detalle
                        statementVentaDetalle.setInt(1, idVentaGenerada); // ID_Venta generado automáticamente
                        statementVentaDetalle.setInt(2, detalle.getIdProducto());
                        statementVentaDetalle.setString(3, detalle.getNombreProducto());
                        statementVentaDetalle.setDouble(4, detalle.getPrecioUnitario());
                        statementVentaDetalle.setInt(5, detalle.getCantidad());
                        statementVentaDetalle.setDouble(6, detalle.getImporte());

                        // Agregar la consulta al lote de inserción
                        statementVentaDetalle.addBatch();
                    }

                    // Ejecutar el lote de inserciones de detalles de venta
                    int[] filasInsertadasDetalle = statementVentaDetalle.executeBatch();

                    // Verificar si todas las inserciones de detalles fueron exitosas
                    for (int resultado : filasInsertadasDetalle) {
                        if (resultado == 0) {
                            throw new SQLException("Fallo al insertar detalles de la venta. No se insertaron todas las filas.");
                        }
                    }

                    // Si llegamos aquí, todo fue exitoso
                    return true;

                } else {
                    throw new SQLException("Fallo al obtener la clave generada para la venta.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retornar false en caso de error
        }
    }
 




}
