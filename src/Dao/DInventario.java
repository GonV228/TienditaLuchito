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
 ConexionBD conexionBD = new ConexionBD();
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
        // Preparamos la sentencia SQL para seleccionar todos los productos con el nombre de la categoría
        String sql = "SELECT p.ID_Producto, p.Nombre, p.Stock, p.Informacion, p.Precio, p.Imagen, c.NombreCat AS NombreCategoria " +
                     "FROM Productos p " +
                     "INNER JOIN Categorias c ON p.ID_Categoria = c.ID_Categoria";

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
            String nombreCategoria = rs.getString("NombreCategoria");
            // Crea un objeto Productos con todos los datos obtenidos
           Productos producto = new Productos(idProducto, nombreP, stock, informacion, precio, imagenP, new categorias(0, nombreCategoria));

            // Agrega el producto a la lista
            listaProductos.add(producto);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener los productos: " + e);
    }
    return listaProductos;
}

    // Método para insertar un nuevo producto en la base de datos
    public boolean insertarProducto(Productos producto) {
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            // Preparamos la sentencia SQL para insertar el producto
            String sql = "INSERT INTO Productos (Nombre, Stock, Informacion, Precio, ID_Categoria, Imagen) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conexion.prepareStatement(sql);
            // Establecemos los valores del producto en el PreparedStatement
            pst.setString(1, producto.getNombreP());
            pst.setInt(2, producto.getStock());
            pst.setString(3, producto.getInformacion());
            pst.setDouble(4, producto.getPrecio());
            pst.setInt(5, producto.getCategoria().getIdCategoria());
            pst.setBytes(6, producto.getImagenP());// Se establece la imagen como un arreglo de bytes
            // Ejecutamos la sentencia SQL
            int filasAfectadas = pst.executeUpdate();
            // Verificamos si se insertó correctamente
            if (filasAfectadas > 0) {
                return true; // El producto se insertó correctamente
            } else {
                return false; // Hubo un problema al insertar el producto
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar el producto: " + e);
            return false;
        }
    }

    public categorias obtenerCategoriaPorNombre(String nombreCategoria) {
        categorias categoria = null;
        // Utilizamos la conexión a la base de datos
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            // Preparamos la sentencia SQL para seleccionar la categoría por nombre
            String sql = "SELECT ID_Categoria, NombreCat FROM Categorias WHERE NombreCat = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, nombreCategoria);
            // Ejecutamos la consulta SQL
            ResultSet rs = pst.executeQuery();
            // Verificamos si la consulta devolvió algún resultado
            if (rs.next()) {
                int idCategoria = rs.getInt("ID_Categoria");
                String nombreCat = rs.getString("NombreCat");
                categoria = new categorias(idCategoria, nombreCat);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la categoría por nombre: " + e);
        }
        return categoria;
    }

// Método para eliminar un producto de la base de datos
    public boolean eliminarProducto(int idProducto) {
        // Utilizamos la conexión a la base de datos
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            // Preparamos la sentencia SQL para eliminar el producto
            String sql = "DELETE FROM Productos WHERE ID_Producto = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            // Establecemos el ID del producto a eliminar en el PreparedStatement
            pst.setInt(1, idProducto);
            // Ejecutamos la sentencia SQL
            int filasAfectadas = pst.executeUpdate();
            // Verificamos si se eliminó correctamente
            if (filasAfectadas > 0) {
                return true; // El producto se eliminó correctamente
            } else {
                return false; // Hubo un problema al eliminar el producto
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e);
            return false;
        }
    }
// Método para obtener un producto por su ID

    public Productos obtenerProductoPorID(int idProducto) {
        Productos producto = null;
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            String sql = "SELECT * FROM Productos WHERE ID_Producto = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, idProducto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID_Producto");
                String nombre = rs.getString("Nombre");
                int stock = rs.getInt("Stock");
                String informacion = rs.getString("Informacion");
                double precio = rs.getDouble("Precio");
                byte[] imagen = rs.getBytes("Imagen");
                int idCategoria = rs.getInt("ID_Categoria");
                // Obtener la categoría correspondiente al ID de la categoría
                categorias categoria = obtenerCategoriaPorID(idCategoria); // Implementa este método según necesites
                producto = new Productos(id, nombre, stock, informacion, precio, imagen, categoria);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el producto: " + e);
        }
        return producto;
    }
// Método para obtener una categoría por su ID

    public categorias obtenerCategoriaPorID(int idCategoria) {
        categorias categoria = null;
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            String sql = "SELECT * FROM Categorias WHERE ID_Categoria = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, idCategoria);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID_Categoria");
                String nombre = rs.getString("NombreCat");
                categoria = new categorias(id, nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la categoría: " + e);
        }
        return categoria;
    }
// Método para editar un producto en la base de datos

    public boolean editarProducto(Productos producto) {
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            String sql = "UPDATE Productos SET Nombre = ?, Stock = ?, Informacion = ?, Precio = ?, ID_Categoria = ?, Imagen = ? WHERE ID_Producto = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, producto.getNombreP());
            pst.setInt(2, producto.getStock());
            pst.setString(3, producto.getInformacion());
            pst.setDouble(4, producto.getPrecio());
            pst.setInt(5, producto.getCategoria().getIdCategoria());
            pst.setBytes(6, producto.getImagenP());
            pst.setInt(7, producto.getID_Producto());
            int filasAfectadas = pst.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e);
            return false;
        }
    }
    
    public boolean aumentarStock(int idProducto, int cantidadAumentar) {
        try (Connection conexion = conexionBD.conectar()) {
            String query = "UPDATE Productos SET Stock = Stock + ? WHERE ID_Producto = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, cantidadAumentar);
            statement.setInt(2, idProducto);
            int filasActualizadas = statement.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean disminuirStock(int idProducto, int cantidadDisminuir) {
        try (Connection conexion = conexionBD.conectar()) {
            String query = "UPDATE Productos SET Stock = Stock - ? WHERE ID_Producto = ? AND Stock >= ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, cantidadDisminuir);
            statement.setInt(2, idProducto);
            statement.setInt(3, cantidadDisminuir); // Verifica que el stock sea suficiente antes de disminuir
            int filasActualizadas = statement.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Productos> obtenerProductosPorCategoria(String categoria) {
    List<Productos> listaProductos = new ArrayList<>();
    // Utilizamos la conexión a la base de datos
    ConexionBD conexionBD = new ConexionBD();
    try (Connection conexion = conexionBD.conectar()) {
        // Preparamos la sentencia SQL para seleccionar los productos de una categoría específica
        String sql = "SELECT p.ID_Producto, p.Nombre, p.Stock, p.Informacion, p.Precio, p.Imagen, c.NombreCat AS NombreCategoria " +
                     "FROM Productos p " +
                     "INNER JOIN Categorias c ON p.ID_Categoria = c.ID_Categoria " +
                     "WHERE c.NombreCat = ?";
        PreparedStatement pst = conexion.prepareStatement(sql);
        // Establecemos el parámetro de la categoría en el PreparedStatement
        pst.setString(1, categoria);
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
            String nombreCategoria = rs.getString("NombreCategoria");
            // Crea un objeto Productos con todos los datos obtenidos
            Productos producto = new Productos(idProducto, nombreP, stock, informacion, precio, imagenP, new categorias(0, nombreCategoria));
            // Agrega el producto a la lista
            listaProductos.add(producto);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener los productos por categoría: " + e);
    }
    return listaProductos;
}

}
