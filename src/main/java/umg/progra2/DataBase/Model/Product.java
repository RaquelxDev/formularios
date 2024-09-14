package umg.progra2.DataBase.Model;

public class Product {
    private int idProducto;
    private String descripcion;
    private String origen;


    public Product() {

    }

    // Constructor
    public Product(int idProducto, String descripcion, String origen) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.origen = origen;
    }

    // Getters and setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public static void setOrigen(String origen) {
        this.origen = origen;
    }



}
















