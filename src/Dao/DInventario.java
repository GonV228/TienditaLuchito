package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.Productos;
import javax.swing.JOptionPane;

public class DInventario {
    // Aquí creamos una instancia de ConexionBD para obtener la conexión
    private ConexionBD conexionBD;

    // Constructor que inicializa la instancia de ConexionBD
    public DInventario() {
        this.conexionBD = new ConexionBD();
    }

    // Método para obtener todos los productos de la base de datos

public List<Productos> obtenerProductos() {
        List<Productos> productos = new ArrayList<>();
        String sql = "SELECT * FROM Productos";
        try (Connection connection = conexionBD.conectar();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idProducto = resultSet.getInt("ID_Producto");
                String nombre = resultSet.getString("Nombre");
                int stock = resultSet.getInt("Stock");
                String informacion = resultSet.getString("Informacion");
                double precio = resultSet.getDouble("Precio");
                byte[] imagen = resultSet.getBytes("Imagen");
                String categoria = resultSet.getString("Categoria");

                Productos producto = new Productos(idProducto, nombre, stock, informacion, precio, imagen, categoria);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    // Método para agregar un nuevo producto a la base de datos
public boolean registrarProducto(Productos producto) {
    String sql = "INSERT INTO Productos (Nombre, Stock, Informacion, Precio, Categoria) VALUES (?, ?, ?, ?, ?)";
    try (Connection connection = conexionBD.conectar();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, producto.getNombre());
        statement.setInt(2, producto.getStock());
        statement.setString(3, producto.getInformacion());
        statement.setDouble(4, producto.getPrecio());
        statement.setString(5, producto.getCategoria());
        int filasAfectadas = statement.executeUpdate();
        return filasAfectadas > 0; // Devuelve true si al menos una fila fue afectada (es decir, si se realizó la inserción correctamente)
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Devuelve false en caso de cualquier excepción SQL
    }
}








}
