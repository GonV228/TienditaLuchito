/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author piter
 */
public class Proveedor {
    //atributos
    private int id;
    private String razon_social;
    private long ruc;
    private String direccion;
    private String pagina_web;
    private int N_cuenta_bancaria;
    private String nombre_banco;
    private long telf_contacto;
    private String correo;

    //constructor vacio
    public Proveedor() {
    }

    //constructor
    public Proveedor(int id, String razon_social, long ruc, String direccion, String pagina_web, int N_cuenta_bancaria, String nombre_banco, long telf_contacto, String correo) {
        this.id = id;
        this.razon_social = razon_social;
        this.ruc = ruc;
        this.direccion = direccion;
        this.pagina_web = pagina_web;
        this.N_cuenta_bancaria = N_cuenta_bancaria;
        this.nombre_banco = nombre_banco;
        this.telf_contacto = telf_contacto;
        this.correo = correo;
    }

    public Proveedor(String razon_social, long ruc, String direccion, String pagina_web, int N_cuenta_bancaria, String nombre_banco, long telf_contacto, String correo) {
        this.razon_social = razon_social;
        this.ruc = ruc;
        this.direccion = direccion;
        this.pagina_web = pagina_web;
        this.N_cuenta_bancaria = N_cuenta_bancaria;
        this.nombre_banco = nombre_banco;
        this.telf_contacto = telf_contacto;
        this.correo = correo;
    }

    
    
    //getters y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public long getRuc() {
        return ruc;
    }

    public void setRuc(long ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public int getN_cuenta_bancaria() {
        return N_cuenta_bancaria;
    }

    public void setN_cuenta_bancaria(int N_cuenta_bancaria) {
        this.N_cuenta_bancaria = N_cuenta_bancaria;
    }

    public String getNombre_banco() {
        return nombre_banco;
    }

    public void setNombre_banco(String nombre_banco) {
        this.nombre_banco = nombre_banco;
    }

    public long getTelf_contacto() {
        return telf_contacto;
    }

    public void setTelf_contacto(long telf_contacto) {
        this.telf_contacto = telf_contacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    
    
    
}
