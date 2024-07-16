package Modelo;

import java.util.Date;

public class Pedidos {
    //inicialización de atributos
    private String nombreProd;
    private int idPedidos;
    private int idProducto;
    private int cantidad;
    private double costoTotal;
    private double precioVenta;
    private String fechaPedido;
    private String fechaEntrega;
    private String estado;
    private double valorUnidad;
    
    //constructor
    public Pedidos(String nomProd, int cant, double costoT, double PrecioV, String fechaP, String fechaE, String estado){
        this.nombreProd=nomProd;
        this.cantidad=cant;
        this.costoTotal=costoT;
        this.precioVenta=PrecioV;
        this.fechaPedido=fechaP;
        this.fechaEntrega=fechaE;
        this.estado=estado;
    }
    public Pedidos(int idPedi, String nomProd, int cant, double costoT, double PrecioV, String fechaP, String fechaE, String estado){
        this.idPedidos=idPedi;
        this.nombreProd=nomProd;
        this.cantidad=cant;
        this.costoTotal=costoT;
        this.precioVenta=PrecioV;
        this.fechaPedido=fechaP;
        this.fechaEntrega=fechaE;
        this.estado=estado;
    }
    public Pedidos(int idPedi, String nomProd, int cant, double costoT, double valorU, double PrecioV, String fechaP, String fechaE, String estado){
        this.idPedidos=idPedi;
        this.nombreProd=nomProd;
        this.cantidad=cant;
        this.costoTotal=costoT;
        this.valorUnidad=valorU;
        this.precioVenta=PrecioV;
        this.fechaPedido=fechaP;
        this.fechaEntrega=fechaE;
        this.estado=estado;
    }

    

    //metodo getter and setter
    public String getnombreProd() {return nombreProd;}
    public void setnombreProd(String nombreProd) {this.nombreProd = nombreProd;}        
    public int getIdPedidos() {return idPedidos;}
    public void setIdPedidos(int idPedidos) {this.idPedidos = idPedidos;}
    public int getIdProducto() {return idProducto;}
    public void setIdProducto(int idProducto) {this.idProducto = idProducto;}
    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
    public double getCostoTotal() {return costoTotal;}
    public void setCostoTotal(double costoTotal) {this.costoTotal = costoTotal;}
    public double getPrecioVenta() {return precioVenta;}
    public void setPrecioVenta(double precioVenta) {this.precioVenta = precioVenta;}
    public String getFechaPedido() {return fechaPedido;}
    public void setFechaPedido(String fechaPedido) {this.fechaPedido = fechaPedido;}
    public String getFechaEntrega() {return fechaEntrega;}
    public void setFechaEntrega(String fechaEntrega) {this.fechaEntrega = fechaEntrega;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}
    
    
    
    
}
