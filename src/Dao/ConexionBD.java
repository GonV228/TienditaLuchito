package Dao;

// librerias para el SQL
import java.sql.ResultSet;;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexionBD {
    
    //atributos para manejo de comandos sql
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    //atributos de conexion
    String ip="localhost";
    String puerto="3306";
    String nombreBD="tluchito";
    String ruta="jdbc:mysql://"+ip+":"+puerto+"/"+nombreBD;
    
    String user="admin";
    String pass="123456789";  
    
    //conexion local
    public Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection(ruta,user,pass);
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexion local " + e);
        }
        return null;
    }
public static void main(String[] args) {
    ConexionBD conexionBD = new ConexionBD();
    Connection conexion = conexionBD.conectar();
    
    if (conexion != null) {
        System.out.println("Conexión exitosa a la base de datos.");
        // Aquí puedes realizar cualquier operación adicional con la conexión
        // Por ejemplo, consultar datos o ejecutar comandos SQL.
    } else {
        System.out.println("Error al conectar a la base de datos.");
    }
}

}

