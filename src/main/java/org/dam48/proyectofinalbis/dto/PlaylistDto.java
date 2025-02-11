package org.dam48.proyectofinalbis.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link org.dam48.proyectofinalbis.entities.Playlist}
 */
public class PlaylistDto implements Serializable {
    private final String nombrePlaylist;
    private final String urlImagen;
    private final String descripcion;
    private final Set<CancionesDto> canciones;

    public PlaylistDto(String nombrePlaylist, String urlImagen, String descripcion, Set<CancionesDto> canciones) {
        this.nombrePlaylist = nombrePlaylist;
        this.urlImagen = urlImagen;
        this.descripcion = descripcion;
        this.canciones = canciones;
    }

    public String getNombrePlaylist() {
        return nombrePlaylist;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Set<CancionesDto> getCanciones() {
        return canciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistDto entity = (PlaylistDto) o;
        return Objects.equals(this.nombrePlaylist, entity.nombrePlaylist) &&
                Objects.equals(this.urlImagen, entity.urlImagen) &&
                Objects.equals(this.descripcion, entity.descripcion) &&
                Objects.equals(this.canciones, entity.canciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombrePlaylist, urlImagen, descripcion, canciones);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "nombrePlaylist = " + nombrePlaylist + ", " +
                "urlImagen = " + urlImagen + ", " +
                "descripcion = " + descripcion + ", " +
                "canciones = " + canciones + ")";
    }

    /**
     * DTO for {@link org.dam48.proyectofinalbis.entities.Canciones}
     */
    public static class CancionesDto implements Serializable {
        private final Integer id;
        private final String tituloCancion;

        public CancionesDto(Integer id, String tituloCancion) {
            this.id = id;
            this.tituloCancion = tituloCancion;
        }

        public Integer getId() {
            return id;
        }

        public String getTituloCancion() {
            return tituloCancion;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CancionesDto entity = (CancionesDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.tituloCancion, entity.tituloCancion);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, tituloCancion);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "tituloCancion = " + tituloCancion + ")";
        }
    }
}