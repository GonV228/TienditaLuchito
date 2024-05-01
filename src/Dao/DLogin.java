package Dao;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
