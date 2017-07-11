package ar.com.pixelo.elo_json_entregable.Model.POJO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rodrigo on 17/6/2017.
 */

public class Track {

    private Integer id;
    private Integer albumId;
    private String title;

    @SerializedName("thumbnailUrl")
    private String miniatura;

    @SerializedName("url")
    private String fotoGrande;

    public Track(Integer id, Integer albumId, String title, String miniatura, String fotoGrande) {
        this.id = id;
        this.albumId = albumId;
        this.title = title;
        this.miniatura = miniatura;
        this.fotoGrande = fotoGrande;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public String getTitle() {
        return title;
    }

    public String getMiniatura() {
        return miniatura;
    }

    public String getFotoGrande() {
        return fotoGrande;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", albumId=" + albumId +
                ", title='" + title + '\'' +
                ", miniatura='" + miniatura + '\'' +
                ", fotoGrande='" + fotoGrande + '\'' +
                '}';
    }
}
