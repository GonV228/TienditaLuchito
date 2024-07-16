package Modelo;

import java.sql.Timestamp;
import java.util.Date;

public class Venta {
    private int ID_Venta;
    private int ID_Producto;
    private Timestamp fechaHora; // Usar Timestamp para coincidir con TIMESTAMP en la base de datos
    private int cantidad;
    private double precio_Unitario;
    private double total;
    private String tipo_Comprobante;

    // Atributos adicionales para manejar detalles de venta
    private Date fechaVenta; // Fecha de la venta
    private double importeTotal; // Importe total de la venta

    public Venta() {
        // Constructor vacío necesario para operaciones de inicialización y carga desde la base de datos
    }

    public Venta(int ID_Producto, Timestamp fechaHora, int cantidad, double precio_Unitario, double total, String tipo_Comprobante) {
        this.ID_Producto = ID_Producto;
        this.fechaHora = fechaHora;
        this.cantidad = cantidad;
        this.precio_Unitario = precio_Unitario;
        this.total = total;
        this.tipo_Comprobante = tipo_Comprobante;
    }

    // Getters y Setters para los atributos adicionales de venta
    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    // Getters y Setters para los atributos existentes
    public int getID_Venta() {
        return ID_Venta;
    }

    public void setID_Venta(int ID_Venta) {
        this.ID_Venta = ID_Venta;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_Unitario() {
        return precio_Unitario;
    }

    public void setPrecio_Unitario(double precio_Unitario) {
        this.precio_Unitario = precio_Unitario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipo_Comprobante() {
        return tipo_Comprobante;
    }

    public void setTipo_Comprobante(String tipo_Comprobante) {
        this.tipo_Comprobante = tipo_Comprobante;
    }
}
