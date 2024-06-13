package Dao;

import Modelo.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
