package Modelo;

public class Productos {
   private String nombreP;
   private String codigo;
   private String SubCategoria;
   private byte[] imagenP;
   private int stock;

    public Productos(String nombreP, String codigo, String SubCategoria, byte[] imagenP, int stock) {
        this.nombreP = nombreP;
        this.codigo = codigo;
        this.SubCategoria = SubCategoria;
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

    public String getSubCategoria() {
        return SubCategoria;
    }

    public void setSubCategoria(String SubCategoria) {
        this.SubCategoria = SubCategoria;
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
