package Modelo;

public class Productos {
   private String nombreP;
   private String codigo;
   private double precio;
   private byte[] imagenP;
   private int stock;

    public Productos(String nombreP, String codigo, double precio, byte[] imagenP, int stock) {
        this.nombreP = nombreP;
        this.codigo = codigo;
        this.precio = precio;
        this.imagenP = imagenP;
        this.stock = stock;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

   
}