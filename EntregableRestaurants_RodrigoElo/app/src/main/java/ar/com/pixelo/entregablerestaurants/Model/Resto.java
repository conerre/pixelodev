package ar.com.pixelo.entregablerestaurants.Model;

/**
 * Created by Rodrigo on 3/6/2017.
 */

public class Resto {

    private String name;
    private String city;
    private Integer foto;

    public Resto(String name, String city, Integer foto) {
        this.name = name;
        this.city = city;
        this.foto = foto;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getFoto() {
        return foto;
    }
}
