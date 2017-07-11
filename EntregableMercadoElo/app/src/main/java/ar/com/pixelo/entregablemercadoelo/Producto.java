package ar.com.pixelo.entregablemercadoelo;

/**
 * Created by Rodrigo on 21/5/2017.
 */

public class Producto {

    private String nombre;
    private Integer precio;
    private Integer foto;
    private String detalle;

    public Producto(String nombre, Integer precio, Integer foto, String detalle) {
        this.nombre = nombre;
        this.precio = precio;
        this.foto = foto;
        this.detalle = detalle;
    }


    public String getNombre() {
        return nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public Integer getFoto() {
        return foto;
    }

    public String getDetalle() {
        return detalle;
    }
}