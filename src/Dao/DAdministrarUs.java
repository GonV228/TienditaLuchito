package Dao;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAdministrarUs {
    
    public boolean registrarUsuario(Usuario usuario) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        
        try {
            // Establecer conexión
            conexion = db.conectar();
            
            // Creamos la consulta SQL para insertar un nuevo usuario
            String query = "INSERT INTO Usuarios (Nombres, Apellidos, Correo_Electronico, Contraseña, Rol, Tipo_Documento, N_Documento, Telefono, Imagen, Token) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            // Preparar la declaración
            pst = conexion.prepareStatement(query);
            
            // Establecer los valores de los parámetros en la consulta
            pst.setString(1, usuario.getNombres());
            pst.setString(2, usuario.getApellidos());
            pst.setString(3, usuario.getCorreoElectronico());
            pst.setString(4, usuario.getContraseña());
            pst.setString(5, usuario.getRol());
            pst.setString(6, usuario.getTipoDocumento());
            pst.setInt(7, usuario.getNumeroDoc());
            pst.setInt(8, usuario.getTelfono());
            pst.setString(9, usuario.getImagen());
            pst.setString(10, usuario.getToken());
            
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
}
