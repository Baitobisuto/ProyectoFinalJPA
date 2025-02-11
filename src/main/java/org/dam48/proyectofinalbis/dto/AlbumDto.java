package org.dam48.proyectofinalbis.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link org.dam48.proyectofinalbis.entities.Album}
 */
public class AlbumDto implements Serializable {
    private final Integer id;
    private final String tituloAlbum;
    private final String urlImagen;
    private final Integer anioLanzamiento;

    public AlbumDto(Integer id, String tituloAlbum, String urlImagen, Integer anioLanzamiento) {
        this.id = id;
        this.tituloAlbum = tituloAlbum;
        this.urlImagen = urlImagen;
        this.anioLanzamiento = anioLanzamiento;
    }

    public Integer getId() {
        return id;
    }

    public String getTituloAlbum() {
        return tituloAlbum;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public Integer getAnioLanzamiento() {
        return anioLanzamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumDto entity = (AlbumDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.tituloAlbum, entity.tituloAlbum) &&
                Objects.equals(this.urlImagen, entity.urlImagen) &&
                Objects.equals(this.anioLanzamiento, entity.anioLanzamiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tituloAlbum, urlImagen, anioLanzamiento);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "tituloAlbum = " + tituloAlbum + ", " +
                "urlImagen = " + urlImagen + ", " +
                "anioLanzamiento = " + anioLanzamiento + ")";
    }
}