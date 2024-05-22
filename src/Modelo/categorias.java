
package Modelo;

public class categorias {
    private int idCategoria;
    private String nombreCat;

    public categorias(int idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombreCat = nombre;
    }

    public categorias(String categoria) {
       this.nombreCat=categoria; 
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombreCat;
    }

    public void setNombre(String nombre) {
        this.nombreCat = nombre;
    }


}