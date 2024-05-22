package Dao;
import Modelo.Productos;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DNotificaciones {
    public List<Productos> obtenerProductosConStockBajo(int umbral) {
        ConexionBD db = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pst = null;
        List<Productos> productosConStockBajo = new ArrayList<>();
        try {
            conexion = db.conectar();
            String query = "SELECT * FROM Productos WHERE Stock <= ?";
            pst = conexion.prepareStatement(query); 
            pst.setInt(1, umbral);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Productos producto = new Productos();
                producto.setID_Producto(rs.getInt("ID_Producto"));
                producto.setNombreP(rs.getString("Nombre"));
                producto.setStock(rs.getInt("Stock"));
                // Añadir más atributos según tu clase Productos
                productosConStockBajo.add(producto);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return productosConStockBajo;
        } 
        
    }    

        
        
        // Aquí debes hacer la consulta a tu base de datos
        // Este es solo un ejemplo de cómo podrías hacerlo
/*        String query = "SELECT * FROM Productos WHERE Stock <= ?";
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement pst = conexion.prepareStatement(query)) {
            pst.setInt(1, umbral);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Productos producto = new Productos();
                producto.setID_Producto(rs.getInt("ID_Producto"));
                producto.setNombreP(rs.getString("NombreP"));
                producto.setStock(rs.getInt("Stock"));
                // Añadir más atributos según tu clase Productos
                productosConStockBajo.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productosConStockBajo;*/
    

