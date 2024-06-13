
package Modelo;

public class Promociones {
    //inicializar
    int idPromocion;
    String nombrePromo;
    int idProducto;
    String nombreProducto;
    Double precioPromo;
    int cantidad;
    

    public int getIdPromocion() {
        return idPromocion;
    }
    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }
    public String getNombrePromo() {
        return nombrePromo;
    }
    public void setNombrePromo(String nombrePromo) {
        this.nombrePromo = nombrePromo;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public Double getPrecioPromo() {
        return precioPromo;
    }
    public void setPrecioPromo(Double precioPromo) {
        this.precioPromo = precioPromo;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProduc) {
        this.nombreProducto = nombreProduc;
    }    
    public Promociones(int idPromocion, String nombrePromo, int idProducto, String nombreProducto, Double precioPromo, int cantidad) {
        this.idPromocion = idPromocion;
        this.nombrePromo = nombrePromo;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioPromo = precioPromo;
        this.cantidad = cantidad;
    }

    public Promociones(int idPromocion, String nombrePromo, int idProducto, Double precioPromo, int cantidad) {
        this.idPromocion = idPromocion;
        this.nombrePromo = nombrePromo;
        this.idProducto = idProducto;
        this.precioPromo = precioPromo;
        this.cantidad = cantidad;
    }
    public Promociones(String namePromo,int idProducto, String nombreProducto, Double precioPromo,int cantidad){
        this.nombrePromo=namePromo;
        this.idProducto=idProducto;
        this.nombreProducto=nombreProducto;
        this.precioPromo=precioPromo;
        this.cantidad=cantidad;
        
    }
    
    
    
}
    
    
    //constructores
    
    

