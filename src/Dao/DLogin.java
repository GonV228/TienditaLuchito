package Dao;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DLogin {
    
    public String obtenerRolUsuario(Usuario u) {
        String rol = null;
        ConexionBD db = new ConexionBD();
        try {
            Connection conexion = db.conectar();
            PreparedStatement pst = conexion.prepareStatement("SELECT Rol FROM Usuarios WHERE Correo_Electronico = ? AND Contraseña = ?");
            pst.setString(1, u.getCorreoElectronico());
            pst.setString(2, u.getContraseña());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                rol = rs.getString("Rol");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el rol del usuario: " + e);
        }
        return rol;
    }
    
    public boolean existeCorreo(String correo){
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean existe = false;

        try {
            // Establecer conexión
            conexion = db.conectar();
            // Consulta SQL para verificar si existe ese correo electronico registrado en el sistema
            String query = "SELECT COUNT(*) AS count FROM Usuarios Where Correo_Electronico = ?";
            // Preparar la declaración
            pst = conexion.prepareStatement(query);
            // Establecer el valor del parámetro en la consulta
            pst.setString(1, correo);
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
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia de correo: " + e.getMessage());
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
