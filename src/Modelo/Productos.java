package Modelo;

public class Productos {
    private int idProducto;
    private String nombre;
    private int stock;
    private String informacion;
    private double precio;
    private byte[] imagen;
    private String categoria; // Nuevo campo para la categoría

    public Productos(int idProducto, String nombre, int stock, String informacion, double precio, byte[] imagen, String categoria) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.informacion = informacion;
        this.precio = precio;
        this.imagen = imagen;
        this.categoria = categoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
