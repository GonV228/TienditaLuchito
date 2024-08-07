package Modelo;
public class Usuario {
    //inicialización
    private int id;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private String contraseña;
    private String rol;
    private String tipoDocumento;
    private int numeroDocumento; // Cambiado a int
    private String telefono;
    private byte[] imagenBytes;
    private double sueldo;
    // Constructores
    public Usuario(int id,String nombres, String apellidos, String correoElectronico, String contraseña, String rol, String tipoDocumento, int numeroDocumento, String telefono, byte[] imagenBytes) {
        this.id=id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.rol = rol;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.imagenBytes = imagenBytes;
    }
    public Usuario(String nombres, String apellidos, String correoElectronico, String contraseña, String rol, String tipoDocumento, int numeroDocumento, String telefono, byte[] imagenBytes) {
        
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.rol = rol;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.imagenBytes = imagenBytes;
    }
    public Usuario(String rol, String nombre, String apellido){
        this.rol=rol;
        this.nombres=nombre;
        this.apellidos=apellido;
    }
    public Usuario(String contra, String correo){
        this.contraseña=contra;
        this.correoElectronico=correo;
    }
    public Usuario(){/*constructor vacio*/}

    public Usuario(String nombres, String apellidos, String correo, String contraseña, String rol, String tipoDocumento, int nunDoc, String telefono, byte[] imagenBytes, double sueldo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correo;
        this.contraseña = contraseña;
        this.rol = rol;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = nunDoc;
        this.telefono = telefono;
        this.imagenBytes = imagenBytes;
        this.sueldo=sueldo;
    }

    public Usuario(int id, String nombres, String apellidos, String correo, String contraseña, String rol, String tipoDocumento, int numDoc, String telefono, byte[] imagenBytes, double sueldoD) {
        this.id=id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correo;
        this.contraseña = contraseña;
        this.rol = rol;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numDoc;
        this.telefono = telefono;
        this.imagenBytes = imagenBytes;
        this.sueldo=sueldoD;
    }
    // Getters y setters
    public int      getId() {return id;}
    public void     setId(int id) {    this.id = id;}
    public String   getNombres() {return nombres;}
    public void     setNombres(String nombres) {this.nombres = nombres;}
    public String   getApellidos() {return apellidos;}
    public void     setApellidos(String apellidos) {this.apellidos = apellidos;}
    public String   getCorreoElectronico() {return correoElectronico;}
    public void     setCorreoElectronico(String correoElectronico) {this.correoElectronico = correoElectronico;}
    public String   getContraseña() {return contraseña;}
    public void     setContraseña(String contraseña) {this.contraseña = contraseña;}
    public String   getRol() {return rol;}
    public void     setRol(String rol) {this.rol = rol;}
    public String   getTipoDocumento() {return tipoDocumento;}
    public void     setTipoDocumento(String tipoDocumento) {this.tipoDocumento = tipoDocumento;}
    public int      getNumeroDocumento() {return numeroDocumento;}
    public void     setNumeroDocumento(int numeroDocumento) {this.numeroDocumento = numeroDocumento;}
    public String   getTelefono() {return telefono;}
    public void     setTelefono(String telefono) {this.telefono = telefono;}
    public byte[]   getImagenBytes() {return imagenBytes;}
    public void     setImagenBytes(byte[] imagenBytes) {this.imagenBytes = imagenBytes;}
    public double   getSueldo() {return sueldo;}
    public void     setSueldo(double sueldo) {this.sueldo = sueldo;}
    
}
