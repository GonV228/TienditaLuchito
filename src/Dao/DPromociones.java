
package Dao;

import Modelo.Promociones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class DPromociones {
    
    
    
    public boolean insertarPromocion(Promociones promocion) {
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            // Preparamos la sentencia SQL para insertar el producto
            String sql = "INSERT INTO promociones (ID_Promociones, NombrePromo, ID_Producto, PrecioPromo, Cantidad) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conexion.prepareStatement(sql);
            // Establecemos los valores del producto en el PreparedStatement
            pst.setInt(1, promocion.getIdPromocion());
            pst.setString(2, promocion.getNombrePromo());
            pst.setInt(3, promocion.getIdProducto());
            pst.setDouble(4, promocion.getPrecioPromo());
            pst.setInt(5, promocion.getCantidad());
            
            // Ejecutamos la sentencia SQL
            int filasAfectadas = pst.executeUpdate();
            // Verificamos si se insertó correctamente
            if (filasAfectadas > 0) {
                return true; // El producto se insertó correctamente
            } else {
                return false; // Hubo un problema al insertar el producto
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar la promocion: " + e);
            return false;
        }
    }
    
    
    public List<Promociones> ObtenerPromos(){
        List<Promociones> listaPromos = new ArrayList<>();
        // Utilizamos la conexión a la base de datos
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            // Preparamos la sentencia SQL para seleccionar todos los productos con el nombre de la categoría
            String sql = "select pr.ID_Promociones,pr.NombrePromo,pr.ID_Producto,p.Nombre,pr.PrecioPromo,pr.Cantidad from promociones pr " +
                         "inner join productos p on p.ID_Producto=pr.ID_Producto ";//+
                        // "where ID_Promociones= ? ";

            PreparedStatement pst = conexion.prepareStatement(sql);
            // Ejecutamos la consulta SQL
            ResultSet rs = pst.executeQuery();
            // Recorremos el resultado y creamos objetos Productos para cada fila
            while (rs.next()) {
                int idPromo=rs.getInt("ID_Promociones");
                String namePromo = rs.getString("pr.NombrePromo");
                int idProducto =rs.getInt("pr.ID_Producto");
                String nombreProducto = rs.getString("p.Nombre");
                double precioPromo = rs.getDouble("pr.PrecioPromo");
                int cantidad = rs.getInt("pr.Cantidad");
                
                // Crea un objeto Productos con todos los datos obtenidos
               Promociones promo = new Promociones(idPromo,namePromo,idProducto,nombreProducto,precioPromo,cantidad);

                // Agrega el producto a la lista
                listaPromos.add(promo);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las promociones: " + e);
        }
        return listaPromos;
    }
    
    public Promociones ObtenerPromosPorID(int idPromo){
        Promociones promo=null;
        ConexionBD conexionBD = new ConexionBD();
        System.out.println("vamos bien");
        try (Connection conexion = conexionBD.conectar()) {
            System.out.println("estoy en el try");
            // Preparamos la sentencia SQL para seleccionar todos los productos con el nombre de la categoría
            String sql = "SELECT pr.ID_Promociones, pr.NombrePromo, pr.ID_Producto, p.Nombre, pr.PrecioPromo, pr.Cantidad " +
                     "FROM promociones pr " +
                     "INNER JOIN productos p ON p.ID_Producto = pr.ID_Producto " +
                     "WHERE pr.ID_Promociones = ?";
            System.out.println("try 1");
            PreparedStatement pst = conexion.prepareStatement(sql);
            System.out.println("try2");
            pst.setInt(1, idPromo);
            System.out.println("try3");
            // Ejecutamos la consulta SQL
            ResultSet rs = pst.executeQuery();
            System.out.println("try4");
            // Recorremos el resultado y creamos objetos Productos para cada fila
            while (rs.next()) {
                System.out.println("try5");
                int id = rs.getInt("pr.ID_Promociones");
                String namePromo = rs.getString("pr.NombrePromo");
                int idProducto = rs.getInt("pr.ID_Producto");
                String nombreProducto = rs.getString("p.Nombre");
                double precioPromo = rs.getDouble("pr.PrecioPromo");
                int cantidad = rs.getInt("pr.Cantidad");
                
                System.out.println("try6");
                System.out.println("imprimir todo lo que consulte...: "+ " id promoo: "+id
                        +" nombre proom "+namePromo+" id producto: "+idProducto+" precio promo: "+precioPromo+" cantidad: "+cantidad);
                // Crea un objeto Productos con todos los datos obtenidos
                promo = new Promociones(id, namePromo, idProducto, nombreProducto, precioPromo, cantidad);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las promociones: " + e);
            System.out.println("estoy en el catch");
        }
        return promo;
    }
    
    public List<Promociones> obtenerPromocionesPorNombre(String nombrePromocion) {
        List<Promociones> listaPromociones = new ArrayList<>();
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            String sql = "SELECT * FROM promociones WHERE NombrePromo LIKE ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, "%" + nombrePromocion + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_Promociones");
                String nombrePromo = rs.getString("NombrePromo");
                int idProducto = rs.getInt("ID_Producto");
                double precioPromo = rs.getDouble("PrecioPromo");
                int cantidad = rs.getInt("Cantidad");
                Promociones promo = new Promociones(id, nombrePromo, idProducto, precioPromo, cantidad);
                listaPromociones.add(promo);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener promociones por nombre: " + e);
        }
        return listaPromociones;
    }
    
    public boolean existePromocionConNombre(String nombrePromo) {
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            String sql = "SELECT COUNT(*) FROM promociones WHERE NombrePromo = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, nombrePromo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar la existencia de la promoción: " + e);
        }
        return false;
    }
    
    public boolean borrarPromocion(int idPromocion) {
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            String sql = "DELETE FROM promociones WHERE ID_Promociones = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, idPromocion);
            int filasAfectadas = pst.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al borrar la promoción: " + e);
        }
        return false;
    }
    
    public boolean actualizarPromocion(Promociones promo) {
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            String sql = "UPDATE promociones SET NombrePromo = ?, ID_Producto = ?, PrecioPromo = ?, Cantidad = ? WHERE ID_Promociones = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, promo.getNombrePromo());
            pst.setInt(2, promo.getIdProducto());
            pst.setDouble(3, promo.getPrecioPromo());
            pst.setInt(4, promo.getCantidad());
            pst.setInt(5, promo.getIdPromocion());
            int filasAfectadas = pst.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar la promoción: " + e);
        }
        return false;
    }
    
        //en un campo ingresamos el nombre de un producto y se encargara de mostrar en la tabla las promociones para ese producto indicado
    public List<Promociones> buscarPromocionesPorNombreProducto(String nombreProducto) {
        List<Promociones> promociones = new ArrayList<>();
        String sql = "SELECT p.ID_Promociones, p.NombrePromo, prod.Nombre, p.PrecioPromo, p.Cantidad " +
                     "FROM promociones p " +
                     "JOIN productos prod ON p.ID_Producto = prod.ID_Producto " +
                     "WHERE prod.Nombre LIKE ?";

        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, "%" + nombreProducto + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Promociones promo = new Promociones();  // Crear una nueva instancia para cada iteración
                promo.setIdPromocion(rs.getInt("ID_Promociones"));
                promo.setNombrePromo(rs.getString("NombrePromo"));
                promo.setNombreProducto(rs.getString("Nombre"));
                promo.setPrecioPromo(rs.getDouble("PrecioPromo"));
                promo.setCantidad(rs.getInt("Cantidad"));
                promociones.add(promo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promociones;
    }
    
    // Método en DPromociones para obtener promociones por ID de producto... para actualizar en la tabla de registro de ventas si detecta una promo
    public List<Promociones> obtenerPromocionesPorProducto(String idProducto) {
        List<Promociones> promociones = new ArrayList<>();
        String sql = "SELECT p.ID_Promociones, p.NombrePromo, p.ID_Producto, prod.Nombre, p.PrecioPromo, p.Cantidad " +
                     "FROM promociones p " +
                     "JOIN productos prod ON p.ID_Producto = prod.ID_Producto " +
                     "WHERE p.ID_Producto = ?";
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, idProducto);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Promociones promo = new Promociones();
                promo.setIdPromocion(rs.getInt("ID_Promociones"));
                promo.setNombrePromo(rs.getString("NombrePromo"));
                promo.setIdProducto(rs.getInt("ID_Producto"));
                promo.setNombreProducto(rs.getString("Nombre"));
                promo.setPrecioPromo(rs.getDouble("PrecioPromo"));
                promo.setCantidad(rs.getInt("Cantidad"));
                promociones.add(promo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promociones;
    }
}
