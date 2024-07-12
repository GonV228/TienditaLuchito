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
            String query = "INSERT INTO cliente (Nombres, Apellidos, N_Documento,Edad,Genero, Telefono,Correo_Electronico) VALUES (?, ?, ?, ?, ?, ?, ?)";

            // Preparar la declaración
            pst = conexion.prepareStatement(query);

            // Establecer los valores de los parámetros en la consulta
            pst.setString(1, cliente.getNombres());
            pst.setString(2, cliente.getApellidos());
            pst.setString(3, cliente.getDocumento());
            pst.setInt(4, cliente.getEdad());
            pst.setString(5, cliente.getGenero());
            pst.setString(6, cliente.getTelefono());
            pst.setString(7, cliente.getCorreo());
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
            String query = "UPDATE cliente SET Nombres = ?, Apellidos = ?, N_Documento=?, Edad= ?, Genero= ?, Telefono = ?, Correo_Electronico= ? WHERE ID_Cliente = ?";

            // Preparar la declaración
            pst = conexion.prepareStatement(query);

            // Establecer los valores de los parámetros en la consulta
            pst.setString(1, cliente.getNombres());
            pst.setString(2, cliente.getApellidos());
            pst.setString(3, cliente.getDocumento());
            pst.setInt(4, cliente.getEdad());
            pst.setString(5, cliente.getGenero());
            pst.setString(6, cliente.getTelefono());
            pst.setString(7, cliente.getCorreo());
            pst.setInt(8, cliente.getId());

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

    public boolean eliminarCliente(String numeroDocumento) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;

        try {
            // Establecer conexión
            conexion = db.conectar();

            // Consulta SQL para eliminar un cliente por su número de documento
            String query = "DELETE FROM cliente WHERE N_Documento = ?";

            // Preparar la declaración
            pst = conexion.prepareStatement(query);

            // Establecer el valor del parámetro en la consulta
            pst.setString(1, numeroDocumento);

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

                Cliente cliente = new Cliente(id, nombres, apellidos, tipoDocumento, documento, edad, genero, telefono, correo);
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

    public boolean existeUsuarioConDocumento(String numeroDocumento) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean existe = false;
        try {
            // Establecer conexión
            conexion = db.conectar();
            // Consulta SQL para verificar si existe un usuario con el número de documento especificado
            String query = "SELECT COUNT(*) AS count FROM cliente WHERE N_Documento = ?";
            // Preparar la declaración
            pst = conexion.prepareStatement(query);
            // Establecer el valor del parámetro en la consulta
            pst.setString(1, numeroDocumento);
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
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia de usuario: " + e.getMessage());
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

    public boolean existeClienteConDocumento2(String numeroDocumento, int id) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean existe = false;
        try {
            // Establecer conexión
            conexion = db.conectar();
            // Consulta SQL para verificar si existe un usuario con el número de documento especificado
            String query = "SELECT COUNT(*) AS count FROM cliente WHERE N_Documento = ? AND ID_Cliente <> ?";
            // Preparar la declaración
            pst = conexion.prepareStatement(query);
            // Establecer el valor del parámetro en la consulta
            pst.setString(1, numeroDocumento);
            pst.setInt(2, id);
            System.out.println("numero de documento enviado: " + numeroDocumento);
            System.out.println("numero de id enviado: " + id);
            // Ejecutar la consulta
            rs = pst.executeQuery();
            // Verificar si existe algún resultado
            if (rs.next()) {
                // Obtener el número de filas
                int rowCount = rs.getInt("count");
                existe = rowCount > 0;
                System.out.println("hay otro documento?: " + existe);
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción de SQL
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia de usuario: " + e.getMessage());
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

    public int existeClienteConDocumentoExcluyendoActual(String numeroDocumento) {
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
            String query = "SELECT ID_Cliente FROM cliente WHERE N_Documento = ? ";
            // Preparar la declaración
            pst = conexion.prepareStatement(query);
            // Establecer los valores de los parámetros en la consulta
            pst.setString(1, numeroDocumento);
            // Ejecutar la consulta
            rs = pst.executeQuery();
            // Verificar si existe algún resultado
            if (rs.next()) {
                // Obtener el ID
                id = rs.getInt("ID_Cliente");
            }
            rs.close();  // Asegúrate de cerrar el ResultSet
            pst.close(); // Asegúrate de cerrar el PreparedStatement
            conexion.close(); // Asegúrate de cerrar la conexión
        } catch (SQLException e) {
            // Manejar cualquier excepción de SQL
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia de usuario: " + e.getMessage());
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
