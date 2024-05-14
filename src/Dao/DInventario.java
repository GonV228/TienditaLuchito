package Dao;

import Modelo.Productos;
import Modelo.categorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DInventario {
    
    // Método para insertar una nueva categoría en la base de datos
    public boolean insertarCategoria(categorias categoria) {
        // Utilizamos la conexión a la base de datos
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            // Preparamos la sentencia SQL para insertar la categoría
            String sql = "INSERT INTO Categorias (NombreCat) VALUES (?)";
            PreparedStatement pst = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // Establecemos el nombre de la categoría en el PreparedStatement
            pst.setString(1, categoria.getNombre());
            // Ejecutamos la sentencia SQL
            int filasAfectadas = pst.executeUpdate();
            // Verificamos si se insertó correctamente
            if (filasAfectadas > 0) {
                // Si se insertó correctamente, obtenemos el ID generado
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    System.out.println("Se insertó la categoría con el ID: " + idGenerado);
                    // Actualizamos el objeto categoría con el ID generado
                    categoria.setIdCategoria(idGenerado);
                }
                return true; // La categoría se insertó correctamente
            } else {
                return false; // Hubo un problema al insertar la categoría
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar la categoría: " + e);
            return false;
        }
    }

// Método para obtener todas las categorías de la base de datos, ordenadas por ID ascendente
public List<categorias> obtenerCategoriasOrdenadas() {
    List<categorias> listaCategorias = new ArrayList<>();
    // Utilizamos la conexión a la base de datos
    ConexionBD conexionBD = new ConexionBD();
    try (Connection conexion = conexionBD.conectar()) {
        // Preparamos la sentencia SQL para seleccionar todas las categorías ordenadas por ID ascendente
        String sql = "SELECT ID_Categoria, NombreCat FROM Categorias ORDER BY ID_Categoria ASC";
        PreparedStatement pst = conexion.prepareStatement(sql);
        // Ejecutamos la consulta SQL
        ResultSet rs = pst.executeQuery();
        // Recorremos el resultado y creamos objetos categorías para cada fila
        while (rs.next()) {
            int idCategoria = rs.getInt("ID_Categoria");
            String nombreCategoria = rs.getString("NombreCat");
            categorias categoria = new categorias(idCategoria, nombreCategoria);
            listaCategorias.add(categoria);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener las categorías: " + e);
    }
    return listaCategorias;
}


// Método para verificar si una categoría ya existe en la base de datos
public boolean categoriaExiste(String nombreCategoria) {
    // Utilizamos la conexión a la base de datos
    ConexionBD conexionBD = new ConexionBD();
    try (Connection conexion = conexionBD.conectar()) {
        // Preparamos la sentencia SQL para contar las categorías con el mismo nombre
        String sql = "SELECT COUNT(*) AS cantidad FROM Categorias WHERE NombreCat = ?";
        PreparedStatement pst = conexion.prepareStatement(sql);
        pst.setString(1, nombreCategoria);
        // Ejecutamos la consulta SQL
        ResultSet rs = pst.executeQuery();
        // Verificamos si la consulta devolvió algún resultado
        if (rs.next()) {
            int cantidad = rs.getInt("cantidad");
            // Si la cantidad es mayor que 0, significa que la categoría ya existe
            return cantidad > 0;
        }
    } catch (SQLException e) {
        System.out.println("Error al verificar si la categoría existe: " + e);
    }
    // Si ocurrió algún error o la consulta no devolvió resultados, asumimos que la categoría no existe
    return false;
}


// Método para eliminar una categoría de la base de datos
public boolean eliminarCategoria(int idCategoria) {
    // Utilizamos la conexión a la base de datos
    ConexionBD conexionBD = new ConexionBD();
    try (Connection conexion = conexionBD.conectar()) {
        // Preparamos la sentencia SQL para eliminar la categoría
        String sql = "DELETE FROM Categorias WHERE ID_Categoria = ?";
        PreparedStatement pst = conexion.prepareStatement(sql);
        // Establecemos el ID de la categoría a eliminar en el PreparedStatement
        pst.setInt(1, idCategoria);
        // Ejecutamos la sentencia SQL
        int filasAfectadas = pst.executeUpdate();
        // Verificamos si se eliminó correctamente
        if (filasAfectadas > 0) {
            return true; // La categoría se eliminó correctamente
        } else {
            return false; // Hubo un problema al eliminar la categoría
        }
    } catch (SQLException e) {
        System.out.println("Error al eliminar la categoría: " + e);
        return false;
    }
}

// Método para editar el nombre de una categoría en la base de datos
public boolean editarCategoria(int idCategoria, String nuevoNombre) {
    // Utilizamos la conexión a la base de datos
    ConexionBD conexionBD = new ConexionBD();
    try (Connection conexion = conexionBD.conectar()) {
        // Preparamos la sentencia SQL para actualizar el nombre de la categoría
        String sql = "UPDATE Categorias SET NombreCat = ? WHERE ID_Categoria = ?";
        PreparedStatement pst = conexion.prepareStatement(sql);
        // Establecemos el nuevo nombre y el ID de la categoría en el PreparedStatement
        pst.setString(1, nuevoNombre);
        pst.setInt(2, idCategoria);
        // Ejecutamos la sentencia SQL
        int filasAfectadas = pst.executeUpdate();
        // Verificamos si se actualizó correctamente
        if (filasAfectadas > 0) {
            return true; // El nombre de la categoría se actualizó correctamente
        } else {
            return false; // Hubo un problema al actualizar el nombre de la categoría
        }
    } catch (SQLException e) {
        System.out.println("Error al editar la categoría: " + e);
        return false;
    }
}

// Método para obtener todos los productos de la base de datos
public List<Productos> obtenerProductos() {
    List<Productos> listaProductos = new ArrayList<>();
    // Utilizamos la conexión a la base de datos
    ConexionBD conexionBD = new ConexionBD();
    try (Connection conexion = conexionBD.conectar()) {
        // Preparamos la sentencia SQL para seleccionar todos los productos con todos los campos
        String sql = "SELECT ID_Producto, Nombre, Stock, Informacion, Precio, Imagen, ID_Categoria FROM Productos";

        PreparedStatement pst = conexion.prepareStatement(sql);
        // Ejecutamos la consulta SQL
        ResultSet rs = pst.executeQuery();
        // Recorremos el resultado y creamos objetos Productos para cada fila
        while (rs.next()) {
            int idProducto = rs.getInt("ID_Producto");
            String nombreP = rs.getString("Nombre");
            int stock = rs.getInt("Stock");
            String informacion = rs.getString("Informacion");
            double precio = rs.getDouble("Precio");
            byte[] imagenP = rs.getBytes("Imagen");
            int idCategoria = rs.getInt("ID_Categoria");
            // Crea un objeto Categorias para representar la categoría asociada al producto
            categorias categoria = new categorias(idCategoria, null); // Aquí necesitas establecer el nombre de la categoría si lo deseas
            // Crea un objeto Productos con todos los datos obtenidos
            Productos producto = new Productos(idProducto, nombreP, stock, informacion, precio, imagenP, categoria);
            // Agrega el producto a la lista
            listaProductos.add(producto);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener los productos: " + e);
    }
    return listaProductos;
}




}
