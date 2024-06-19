package Dao;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DCliente {

    public boolean registrarCliente(Cliente cliente) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;

        try {
            // Establecer conexión
            conexion = db.conectar();

            //consulta SQL para insertar un nuevo cliente
            String query = "INSERT INTO cliente (Nombres, Apellidos, Correo_Electronico, Contraseña, Rol, Tipo_Documento, N_Documento, Telefono, Imagen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Preparar la declaración
            pst = conexion.prepareStatement(query);

            // Establecer los valores de los parámetros en la consulta
            pst.setString(1, cliente.getNombres());
            pst.setString(2, cliente.getApellidos());
            pst.setString(3, cliente.getCorreo());
            pst.setString(6, cliente.getTipoDocumento());
            pst.setString(7, cliente.getDocumento());
            pst.setString(8, cliente.getTelefono());

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
            JOptionPane.showMessageDialog(null, "Error al registrar cliente: " + e.getMessage());
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

    public boolean actualizarCliente(Cliente cliente) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;

        try {
            // Establecer conexión
            conexion = db.conectar();

            // Consulta SQL para actualizar un cliente
            String query = "UPDATE Clientes SET Nombres = ?, Apellidos = ?, Correo_Electronico = ?, Contraseña = ?, Rol = ?, Tipo_Documento = ?, Telefono = ?, Imagen = ? WHERE ID_Empleado = ?";

            // Preparar la declaración
            pst = conexion.prepareStatement(query);

            // Establecer los valores de los parámetros en la consulta
            pst.setString(1, cliente.getNombres());
            pst.setString(2, cliente.getApellidos());
            pst.setString(3, cliente.getCorreo());
            pst.setString(6, cliente.getTipoDocumento());
            pst.setString(7, cliente.getTelefono());
            pst.setInt(9, cliente.getId());

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
            JOptionPane.showMessageDialog(null, "Error al actualizar cliente: " + e.getMessage());
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

    public boolean eliminarCliente(int numeroDocumento) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;

        try {
            // Establecer conexión
            conexion = db.conectar();

            // Consulta SQL para eliminar un cliente por su número de documento
            String query = "DELETE FROM Clientes WHERE N_Documento = ?";

            // Preparar la declaración
            pst = conexion.prepareStatement(query);

            // Establecer el valor del parámetro en la consulta
            pst.setInt(1, numeroDocumento);

            // Ejecutar la consulta
            int filasAfectadas = pst.executeUpdate();

            // Verificar si se ha eliminado correctamente
            if (filasAfectadas > 0) {
                // Si se eliminó correctamente
                return true;
            } else {
                // Si no se eliminó correctamente
                return false;
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción de SQL
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.getMessage());
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

    public List<Cliente> obtenerTodosClientes() {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            // Establecer conexión
            conexion = db.conectar();

            // Consulta SQL para obtener todos los clientes
            String query = "SELECT * FROM cliente";

            // Preparar la declaración
            pst = conexion.prepareStatement(query);

            // Ejecutar la consulta
            rs = pst.executeQuery();

            // Recorrer los resultados y agregarlos a la lista de clientes
            while (rs.next()) {
                int id = rs.getInt("ID_Cliente");
                String nombres = rs.getString("Nombres");
                String apellidos = rs.getString("Apellidos");
                String tipoDocumento = rs.getString("Tipo_Documento");
                String documento = rs.getString("N_Documento");
                int edad = rs.getInt("Edad");
                String genero = rs.getString("Genero");
                String telefono = rs.getString("Telefono");
                String correo = rs.getString("Correo_Electronico");

                Cliente cliente = new Cliente(id, nombres, apellidos, tipoDocumento, documento, edad,genero,telefono,correo);
                clientes.add(cliente);
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

        return clientes;
    }
}
