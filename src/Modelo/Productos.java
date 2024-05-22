package Modelo;

public class Productos {
   private String nombreP;
   private int codigo;
   private int stock;
   private String informacion;
   private double precio;
   private byte[] imagenP;
    private categorias categoria; // Relación con la clase Categorias

    public Productos(int codigo, String nombreP, int stock, String informacion, double precio, byte[] imagenP, categorias categoria) {
        this.codigo = codigo;
        this.nombreP = nombreP;
        this.stock = stock;
        this.informacion = informacion;
        this.precio = precio;
        this.imagenP = imagenP;
        this.categoria = categoria;
    }

    public Productos() {
        
    }

    public int getID_Producto() {
        return codigo;
    }

    public void setID_Producto(int ID_Producto) {
        this.codigo = ID_Producto;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
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

    public byte[] getImagenP() {
        return imagenP;
    }

    public void setImagenP(byte[] imagenP) {
        this.imagenP = imagenP;
    }

    public categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(categorias categoria) {
        this.categoria = categoria;
    }

    
}
