package Dao;

import Modelo.Pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class DPedidos {
    
    public boolean registrarNuevoPedido(Pedidos pedido) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pstInsert = null;
        PreparedStatement pstUpdate = null;
        ResultSet rs = null;

        try {
            // Establecer conexión
            conexion = db.conectar();

            // Consulta SQL para insertar un nuevo pedido sin ID_Pedidos porque es autoincrementable
            String insertQuery = "INSERT INTO pedidos (ID_Producto, Cantidad, CostoTotal, PrecioVenta, FechaPedido, FechaEntrega, Estado) VALUES ((SELECT ID_Producto FROM productos WHERE Nombre = ?), ?, ?, ?, ?, ?, ?)";

            // Preparar la declaración para la inserción
            pstInsert = conexion.prepareStatement(insertQuery);

            // Establecer los valores de los parámetros en la consulta de inserción
            pstInsert.setString(1, pedido.getnombreProd());
            pstInsert.setInt(2, pedido.getCantidad());
            pstInsert.setDouble(3, pedido.getCostoTotal());
            pstInsert.setDouble(4, pedido.getPrecioVenta());
            pstInsert.setString(5, pedido.getFechaPedido());
            pstInsert.setString(6, pedido.getFechaEntrega());
            pstInsert.setString(7, pedido.getEstado());

            // Ejecutar la inserción
            int filasAfectadas = pstInsert.executeUpdate();

            // Verificar si se ha insertado correctamente
            if (filasAfectadas > 0) {
                // Consulta SQL para verificar el precio en la tabla productos
                String selectQuery = "SELECT Precio, ID_Producto FROM productos WHERE Nombre = ?";
                pstUpdate = conexion.prepareStatement(selectQuery);
                pstUpdate.setString(1, pedido.getnombreProd());
                rs = pstUpdate.executeQuery();

                if (rs.next()) {
                    double precioProducto = rs.getDouble("Precio");
                    int idProducto = rs.getInt("ID_Producto");
                    double precioPedido = pedido.getPrecioVenta();

                    if (precioProducto != precioPedido) {
                        // Actualizar el precio en la tabla productos
                        String updateQuery = "UPDATE productos SET Precio = ? WHERE ID_Producto = ?";
                        pstUpdate = conexion.prepareStatement(updateQuery);
                        pstUpdate.setDouble(1, precioPedido);
                        pstUpdate.setInt(2, idProducto);
                        pstUpdate.executeUpdate();
                    }
                }

                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción de SQL
            JOptionPane.showMessageDialog(null, "Error al registrar el pedido: " + e.getMessage());
            return false;
        } finally {
            // Cerrar la conexión y las declaraciones
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstInsert != null) {
                    pstInsert.close();
                }
                if (pstUpdate != null) {
                    pstUpdate.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public List<Object[]> obtenerTodosPedidos() {
        List<Object[]> pedidos = new ArrayList<>();
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conexion = db.conectar();

            String query = "SELECT p.ID_Pedidos, pr.Nombre AS NombreProducto, p.Cantidad, p.CostoTotal, p.PrecioVenta, p.FechaPedido, p.FechaEntrega, p.Estado " +
                           "FROM pedidos p " +
                           "INNER JOIN productos pr ON p.ID_Producto = pr.ID_Producto";

            pst = conexion.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                int idPedido = rs.getInt("ID_Pedidos");
                String nombreProducto = rs.getString("NombreProducto");
                int cantidad = rs.getInt("Cantidad");
                double costoTotal = rs.getDouble("CostoTotal");
                double precioVenta = rs.getDouble("PrecioVenta");
                String fechaPedido = rs.getString("FechaPedido");
                String fechaEntrega = rs.getString("FechaEntrega");
                String estado = rs.getString("Estado");

                // Calcular valor unitario
                double valorUnitario = costoTotal / cantidad;

                // Agregar los datos transformados a la lista de pedidos
                Object[] pedido = {
                    idPedido,
                    nombreProducto,
                    cantidad,
                    costoTotal,
                    valorUnitario,
                    precioVenta,
                    fechaPedido,
                    fechaEntrega,
                    estado
                };
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los pedidos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }

        return pedidos;
    }
    
    public Pedidos obtenerPedidoPorID(int idPedido) {
        Pedidos pedido = null;
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conexion = db.conectar();

            String query = "SELECT p.ID_Pedidos, pr.Nombre AS NombreProducto, p.Cantidad, p.CostoTotal, p.PrecioVenta, p.FechaPedido, p.FechaEntrega, p.Estado " +
                           "FROM pedidos p " +
                           "INNER JOIN productos pr ON p.ID_Producto = pr.ID_Producto " +
                           "WHERE p.ID_Pedidos = ?";

            pst = conexion.prepareStatement(query);
            pst.setInt(1, idPedido);
            rs = pst.executeQuery();

            if (rs.next()) {
                int idPedidoResultado = rs.getInt("ID_Pedidos");
                String nombreProducto = rs.getString("NombreProducto");
                int cantidad = rs.getInt("Cantidad");
                double costoTotal = rs.getDouble("CostoTotal");
                double precioVenta = rs.getDouble("PrecioVenta");
                String fechaPedido = rs.getString("FechaPedido");
                String fechaEntrega = rs.getString("FechaEntrega");
                String estado = rs.getString("Estado");

                // Calcular valor unitario
                double valorUnitario = costoTotal / cantidad;

                // Crear objeto Pedido con los datos obtenidos
                pedido = new Pedidos(idPedidoResultado, nombreProducto, cantidad, costoTotal, valorUnitario, precioVenta, fechaPedido, fechaEntrega, estado);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el pedido: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }

        return pedido;
    }


    public List<Object[]> filtrarPedidosPorFecha(Date fechaInicio, Date fechaFin, boolean filtrarPorFechaPedido) {
        List<Object[]> pedidosFiltrados = new ArrayList<>();
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conexion = db.conectar();
            String columnaFecha = filtrarPorFechaPedido ? "p.FechaPedido" : "p.FechaEntrega";
            String query = "SELECT p.ID_Pedidos, pr.Nombre AS NombreProducto, p.Cantidad, p.CostoTotal, p.PrecioVenta, p.FechaPedido, p.FechaEntrega, p.Estado " +
                           "FROM pedidos p " +
                           "INNER JOIN productos pr ON p.ID_Producto = pr.ID_Producto " +
                           "WHERE " + columnaFecha + " BETWEEN ? AND ?";

            pst = conexion.prepareStatement(query);
            pst.setDate(1, new java.sql.Date(fechaInicio.getTime()));
            pst.setDate(2, new java.sql.Date(fechaFin.getTime()));
            rs = pst.executeQuery();

            while (rs.next()) {
                int idPedido = rs.getInt("ID_Pedidos");
                String nombreProducto = rs.getString("NombreProducto");
                int cantidad = rs.getInt("Cantidad");
                double costoTotal = rs.getDouble("CostoTotal");
                double precioVenta = rs.getDouble("PrecioVenta");
                String fechaPedido = rs.getString("FechaPedido");
                String fechaEntrega = rs.getString("FechaEntrega");
                String estado = rs.getString("Estado");

                // Calcular valor unitario
                double valorUnitario = costoTotal / cantidad;

                // Agregar los datos transformados a la lista de pedidos
                Object[] pedido = {
                    idPedido,
                    nombreProducto,
                    cantidad,
                    costoTotal,
                    valorUnitario,
                    precioVenta,
                    fechaPedido,
                    fechaEntrega,
                    estado
                };
                pedidosFiltrados.add(pedido);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al filtrar los pedidos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }

        return pedidosFiltrados;
    }

    public List<Object[]> filtrarPedidosPorNombreYFecha(String nombreProducto, Date fechaInicio, Date fechaFin, boolean filtrarPorFechaPedido) {
        List<Object[]> pedidos = new ArrayList<>();
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conexion = db.conectar();

            String query = "SELECT p.ID_Pedidos, pr.Nombre AS NombreProducto, p.Cantidad, p.CostoTotal, p.PrecioVenta, p.FechaPedido, p.FechaEntrega, p.Estado " +
                           "FROM pedidos p " +
                           "INNER JOIN productos pr ON p.ID_Producto = pr.ID_Producto " +
                           "WHERE (pr.Nombre LIKE ?) AND ";

            if (filtrarPorFechaPedido) {
                query += "(p.FechaPedido BETWEEN ? AND ?)";
            } else {
                query += "(p.FechaEntrega BETWEEN ? AND ?)";
            }

            pst = conexion.prepareStatement(query);
            pst.setString(1, "%" + nombreProducto + "%");
            pst.setDate(2, new java.sql.Date(fechaInicio.getTime()));
            pst.setDate(3, new java.sql.Date(fechaFin.getTime()));
            rs = pst.executeQuery();

            while (rs.next()) {
                int idPedido = rs.getInt("ID_Pedidos");
                String nombreProd = rs.getString("NombreProducto");
                int cantidad = rs.getInt("Cantidad");
                double costoTotal = rs.getDouble("CostoTotal");
                double precioVenta = rs.getDouble("PrecioVenta");
                String fechaPedido = rs.getString("FechaPedido");
                String fechaEntrega = rs.getString("FechaEntrega");
                String estado = rs.getString("Estado");

                // Calcular valor unitario
                double valorUnitario = costoTotal / cantidad;

                // Agregar los datos transformados a la lista de pedidos
                Object[] pedido = {
                    idPedido,
                    nombreProd,
                    cantidad,
                    costoTotal,
                    valorUnitario,
                    precioVenta,
                    fechaPedido,
                    fechaEntrega,
                    estado
                };
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los pedidos filtrados: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }

        return pedidos;
    }

    public boolean actualizarPedido(Pedidos pedido) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            conexion = db.conectar();

            // Consulta SQL para actualizar el pedido
            String updateQuery = "UPDATE pedidos SET ID_Producto = (SELECT ID_Producto FROM productos WHERE Nombre = ?), "
                                + "Cantidad = ?, CostoTotal = ?, PrecioVenta = ?, FechaPedido = ?, FechaEntrega = ?, "
                                + "Estado = ? WHERE ID_Pedidos = ?";

            // Preparar la declaración para la actualización
            pstmt = conexion.prepareStatement(updateQuery);
            pstmt.setString(1, pedido.getnombreProd());
            pstmt.setInt(2, pedido.getCantidad());
            pstmt.setDouble(3, pedido.getCostoTotal());
            pstmt.setDouble(4, pedido.getPrecioVenta());
            pstmt.setString(5, pedido.getFechaPedido());
            pstmt.setString(6, pedido.getFechaEntrega());
            pstmt.setString(7, pedido.getEstado());
            pstmt.setInt(8, pedido.getIdPedidos());

            // Ejecutar la actualización
            int filasActualizadas = pstmt.executeUpdate();

            // Verificar si se ha actualizado correctamente
            if (filasActualizadas > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            // Manejar cualquier excepción de SQL
            JOptionPane.showMessageDialog(null, "Error al actualizar el pedido: " + e.getMessage());
            return false;
        } finally {
            // Cerrar la conexión y la declaración
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public boolean eliminarPedido(int idPedido) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;

        try {
            // Establecer conexión
            conexion = db.conectar();

            // Consulta SQL para eliminar un pedido
            String deleteQuery = "DELETE FROM pedidos WHERE ID_Pedidos = ?";
            pst = conexion.prepareStatement(deleteQuery);
            pst.setInt(1, idPedido);

            // Ejecutar la eliminación
            int filasAfectadas = pst.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el pedido: " + e.getMessage());
            return false;
        } finally {
            // Cerrar la conexión y la declaración
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

}
