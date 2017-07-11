package ar.com.pixelo.entregablerestaurants.Model;

/**
 * Created by Rodrigo on 7/6/2017.
 */

public class Receta {

    private String Titulo;
    private String Ingredientes;
    private Integer Foto;
    private String Procedimiento;

    public Receta(String titulo, String ingredientes, Integer foto, String procedimiento) {
        Titulo = titulo;
        Ingredientes = ingredientes;
        Foto = foto;
        Procedimiento = procedimiento;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getIngredientes() {
        return Ingredientes;
    }

    public Integer getFoto() {
        return Foto;
    }

    public String getProcedimiento() {
        return Procedimiento;
    }
}
