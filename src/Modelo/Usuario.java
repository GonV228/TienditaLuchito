package Modelo;

public class Usuario {
    private String nombres;
    private String apellidos;
    private String contraseña;
    private String correoElectronico;
    private String rol;
    private String tipoDocumento;
    private int telefono;
    private String imagen;
    private int numeroDoc;

    public Usuario(String nombres, String apellidos, String contraseña, String correoElectronico, String rol, String tipoDocumento, int telefono, String imagen, int numeroDoc) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.correoElectronico = correoElectronico;
        this.rol = rol;
        this.tipoDocumento = tipoDocumento;
        this.telefono = telefono;
        this.imagen = imagen;
        this.numeroDoc = numeroDoc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(int numeroDoc) {
        this.numeroDoc = numeroDoc;
    }
}
