
package Modelo;

/**
 *
 * @author SARA
 */
public class UsuarioInfo {
    private String rol;
    private String nombre;
    private String apellido;

    public UsuarioInfo(String rol, String nombre, String apellido) {
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y setters
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
