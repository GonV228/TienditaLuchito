/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Modelo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author piter
 */
public class DProveedores {
    
     public boolean registrarProveedor(Proveedor proveedor) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;

        try {
            // Establecer conexión
            conexion = db.conectar();

            //consulta SQL para insertar un nuevo cliente
            //String query = "INSERT INTO proveedores (ID_Proveedores, Razon_Social, RUC,Direccion,Pag_web, N_Cuenta,Nombre_Banco, Telefono, Correo_Electronico) VALUES (?,?, ?, ?, ?, ?, ?,?,?)";

            String query = "INSERT INTO proveedores (Razon_Social, RUC,Direccion,Pag_web, N_Cuenta,Nombre_Banco, Telefono, Correo_Electronico) VALUES (?,?, ?, ?, ?, ?, ?,?)";

            // Preparar la declaración
            pst = conexion.prepareStatement(query);

            // Establecer los valores de los parámetros en la consulta
            //pst.setInt(1,0);
            pst.setString(1, proveedor.getRazon_social());
            pst.setLong(2, proveedor.getRuc());
            pst.setString(3, proveedor.getDireccion());
            pst.setString(4, proveedor.getPagina_web());
            pst.setLong(5, proveedor.getN_cuenta_bancaria());
            pst.setString(6, proveedor.getNombre_banco());
            pst.setLong(7, proveedor.getTelf_contacto());
            pst.setString(8, proveedor.getCorreo());
            // Ejecutar la consulta
            int filasAfectadas = pst.executeUpdate();
            
            // Verificar si se ha insertado correctamente
            if (filasAfectadas > 0) {
                // Si se insertó correctamente
                return true;
            } else {
                // Si no se insertó correctamente
                return false;
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción de SQL
            JOptionPane.showMessageDialog(null, "Error al registrar al proveedor: " + e.getMessage());
            return false;
        } finally {
            // Cerrar la conexión y la declaración
            try {
                if (conexion != null) {
                    conexion.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public boolean actualizarProveedor(Proveedor proveedor, int IDProveedor) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;

        try {
            // Establecer conexión
            conexion = db.conectar();

            // Consulta SQL para actualizar un cliente
            String query = "UPDATE proveedores SET Razon_Social = ?, RUC = ?, Direccion=?, "
                    + "Pag_web= ?, N_Cuenta= ?, Nombre_Banco = ?, Telefono= ?, Correo_Electronico=? WHERE ID_Proveedores = ?";

            // Preparar la declaración
            pst = conexion.prepareStatement(query);

            // Establecer los valores de los parámetros en la consulta
            pst.setString(1, proveedor.getRazon_social());
            pst.setLong(2, proveedor.getRuc());
            pst.setString(3, proveedor.getDireccion());
            pst.setString(4, proveedor.getPagina_web());
            pst.setLong(5, proveedor.getN_cuenta_bancaria());
            pst.setString(6, proveedor.getNombre_banco());
            pst.setLong(7, proveedor.getTelf_contacto());
            pst.setString(8, proveedor.getCorreo());
            pst.setLong(9, IDProveedor);

            // Ejecutar la consulta
            int filasAfectadas = pst.executeUpdate();

            // Verificar si se ha actualizado correctamente
            if (filasAfectadas > 0) {
                // Si se actualizó correctamente
                return true;
            } else {
                // Si no se actualizó correctamente
                return false;
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción de SQL
            JOptionPane.showMessageDialog(null, "Error al actualizar proveedor: " + e.getMessage());
            return false;
        } finally {
            // Cerrar la conexión y la declaración
            try {
                if (conexion != null) {
                    conexion.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public boolean eliminarProveedor(long ruc) {
        // Utilizamos la conexión a la base de datos
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conexion = conexionBD.conectar()) {
            // Preparamos la sentencia SQL para eliminar el producto
            String sql = "DELETE FROM proveedores WHERE RUC = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            // Establecemos el ID del producto a eliminar en el PreparedStatement
            pst.setLong(1, ruc);
            // Ejecutamos la sentencia SQL
            int filasAfectadas = pst.executeUpdate();
            // Verificamos si se eliminó correctamente
            if (filasAfectadas > 0) {
                return true; // El producto se eliminó correctamente
            } else {
                return false; // Hubo un problema al eliminar el producto
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el proveedor: " + e);
            return false;
        }
    }

    public List<Proveedor> obtenerTodosProveedores() {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Proveedor> proveedores = new ArrayList<>();

        try {
            // Establecer conexión
            conexion = db.conectar();

            // Consulta SQL para obtener todos los clientes
            String query = "SELECT * FROM proveedores";

            // Preparar la declaración
            pst = conexion.prepareStatement(query);

            // Ejecutar la consulta
            rs = pst.executeQuery();

            // Recorrer los resultados y agregarlos a la lista de clientes
            while (rs.next()) {
                int id = rs.getInt("ID_Proveedores");
                String Razon_social = rs.getString("Razon_Social");
                long Ruc = rs.getLong("RUC");
                String Direccion = rs.getString("Direccion");
                String Pagina_web = rs.getString("Pag_web");
                int N_cuenta = rs.getInt("N_Cuenta");
                String Nombre_banco = rs.getString("Nombre_Banco");
                long telefono = rs.getLong("Telefono");
                String correo = rs.getString("Correo_Electronico");

                Proveedor proveedor = new Proveedor(id, Razon_social, Ruc, Direccion, Pagina_web, N_cuenta, Nombre_banco, telefono, correo);
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción de SQL
            JOptionPane.showMessageDialog(null, "Error al obtener clientes: " + e.getMessage());
        } finally {
            // Cerrar la conexión y la declaración
            try {
                if (rs != null) {
                    rs.close();
                }
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

        return proveedores;
    }

    public boolean existeUsuarioConRuc(long ruc) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean existe = false;
        try {
            // Establecer conexión
            conexion = db.conectar();
            // Consulta SQL para verificar si existe un usuario con el número de documento especificado
            String query = "SELECT COUNT(*) AS count FROM proveedores WHERE RUC = ?";
            // Preparar la declaración
            pst = conexion.prepareStatement(query);
            // Establecer el valor del parámetro en la consulta
            pst.setLong(1, ruc);
            // Ejecutar la consulta
            rs = pst.executeQuery();
            // Verificar si existe algún resultado
            if (rs.next()) {
                // Obtener el número de filas
                int rowCount = rs.getInt("count");
                existe = rowCount > 0;
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción de SQL
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia del proveedor: " + e.getMessage());
        } finally {
            // Cerrar la conexión y la declaración
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return existe;
    }

    public boolean existeProveedorConRuc(long ruc, int id) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean existe = false;
        try {
            // Establecer conexión
            conexion = db.conectar();
            // Consulta SQL para verificar si existe un usuario con el número de documento especificado
            String query = "SELECT COUNT(*) AS count FROM proveedores WHERE RUC= ? AND ID_Proveedores <> ?";
            // Preparar la declaración
            pst = conexion.prepareStatement(query);
            // Establecer el valor del parámetro en la consulta
            pst.setLong(1, ruc);
            pst.setInt(2, id);
            System.out.println("numero de RUC enviado: " + ruc);
            System.out.println("numero de id enviado: " + id);
            // Ejecutar la consulta
            rs = pst.executeQuery();
            // Verificar si existe algún resultado
            if (rs.next()) {
                // Obtener el número de filas
                int rowCount = rs.getInt("count");
                existe = rowCount > 0;
                System.out.println("hay otro RUC?: " + existe);
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción de SQL
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia del proveedor: " + e.getMessage());
        } finally {
            // Cerrar la conexión y la declaración
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return existe;
    }

    public int existeProveedorConRucExcluyendoActual(Long ruc) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int id = 0;
        try {
            // Establecer conexión
            conexion = db.conectar();
            // Consulta SQL para verificar si existe otro usuario con el número de documento especificado
            // excluyendo al usuario actualmente seleccionado
            String query = "SELECT ID_Proveedores FROM proveedores WHERE RUC = ? ";
            // Preparar la declaración
            pst = conexion.prepareStatement(query);
            // Establecer los valores de los parámetros en la consulta
            pst.setLong(1, ruc);
            // Ejecutar la consulta
            rs = pst.executeQuery();
            // Verificar si existe algún resultado
            if (rs.next()) {
                // Obtener el ID
                id = rs.getInt("ID_Proveedores");
            }
            rs.close();  // Asegúrate de cerrar el ResultSet
            pst.close(); // Asegúrate de cerrar el PreparedStatement
            conexion.close(); // Asegúrate de cerrar la conexión
        } catch (SQLException e) {
            // Manejar cualquier excepción de SQL
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia del proveedor: " + e.getMessage());
        } finally {
            // Cerrar la conexión y la declaración
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return id;
    }
    
}
