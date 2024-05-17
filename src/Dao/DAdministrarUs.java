package Dao;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAdministrarUs {
    
    public boolean registrarUsuario(Usuario usuario) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        
        try {
            // Establecer conexión
            conexion = db.conectar();
            
            //consulta SQL para insertar un nuevo usuario
            String query = "INSERT INTO Usuarios (Nombres, Apellidos, Correo_Electronico, Contraseña, Rol, Tipo_Documento, N_Documento, Telefono, Imagen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            // Preparar la declaración
            pst = conexion.prepareStatement(query);
            
            // Establecer los valores de los parámetros en la consulta
            pst.setString(1, usuario.getNombres());
            pst.setString(2, usuario.getApellidos());
            pst.setString(3, usuario.getCorreoElectronico());
            pst.setString(4, usuario.getContraseña());
            pst.setString(5, usuario.getRol());
            pst.setString(6, usuario.getTipoDocumento());
            pst.setInt(7, usuario.getNumeroDocumento());
            pst.setString(8, usuario.getTelefono());
            pst.setBytes(9, usuario.getImagenBytes()); // Se establece la imagen como un arreglo de bytes
            
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
            JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage());
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
    
    public boolean actualizarUsuario(Usuario usuario) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        
        try {
            // Establecer conexión
            conexion = db.conectar();
            
            // Consulta SQL para actualizar un usuario
            String query = "UPDATE Usuarios SET Nombres = ?, Apellidos = ?, Correo_Electronico = ?, Contraseña = ?, Rol = ?, Tipo_Documento = ?, Telefono = ?, Imagen = ? WHERE N_Documento = ?";
            
            // Preparar la declaración
            pst = conexion.prepareStatement(query);
            
            // Establecer los valores de los parámetros en la consulta
            pst.setString(1, usuario.getNombres());
            pst.setString(2, usuario.getApellidos());
            pst.setString(3, usuario.getCorreoElectronico());
            pst.setString(4, usuario.getContraseña());
            pst.setString(5, usuario.getRol());
            pst.setString(6, usuario.getTipoDocumento());
            pst.setString(7, usuario.getTelefono());
            pst.setBytes(8, usuario.getImagenBytes()); // Se establece la imagen como un arreglo de bytes
            pst.setInt(9, usuario.getNumeroDocumento());

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
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage());
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
    
    public boolean eliminarUsuario(int numeroDocumento) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        
        try {
            // Establecer conexión
            conexion = db.conectar();
            
            // Consulta SQL para eliminar un usuario por su número de documento
            String query = "DELETE FROM Usuarios WHERE N_Documento = ?";
            
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
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
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
    
    public List<Usuario> obtenerTodosUsuarios() {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            // Establecer conexión
            conexion = db.conectar();
            
            // Consulta SQL para obtener todos los usuarios
            String query = "SELECT * FROM Usuarios";
            
            // Preparar la declaración
            pst = conexion.prepareStatement(query);
            
            // Ejecutar la consulta
            rs = pst.executeQuery();
            
            // Recorrer los resultados y agregarlos a la lista de usuarios
            while (rs.next()) {
                int id = rs.getInt("ID_Empleado");
                String nombres = rs.getString("Nombres");
                String apellidos = rs.getString("Apellidos");
                String correo = rs.getString("Correo_Electronico");
                String contraseña = rs.getString("Contraseña");
                String rol = rs.getString("Rol");
                String tipoDocumento = rs.getString("Tipo_Documento");
                int numeroDocumento = rs.getInt("N_Documento");
                String telefono = rs.getString("Telefono");
                byte[] imagenBytes = rs.getBytes("Imagen");

                Usuario usuario = new Usuario(nombres, apellidos, correo, contraseña, rol, tipoDocumento, numeroDocumento, telefono, imagenBytes);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción de SQL
            JOptionPane.showMessageDialog(null, "Error al obtener usuarios: " + e.getMessage());
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
        
        return usuarios;
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
            String query = "SELECT COUNT(*) AS count FROM Usuarios WHERE N_Documento = ?";

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

    
}