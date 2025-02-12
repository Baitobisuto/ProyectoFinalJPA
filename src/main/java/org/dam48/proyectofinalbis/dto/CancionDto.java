package org.dam48.proyectofinalbis.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link org.dam48.proyectofinalbis.entities.Cancion}
 */
public class CancionDto implements Serializable {
    private final String titulo;
    private final AlbumDto album;
    private final String duracion;

    public CancionDto(String titulo, AlbumDto album, String duracion) {
        this.titulo = titulo;
        this.album = album;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public AlbumDto getAlbum() {
        return album;
    }

    public String getDuracion() {
        return duracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CancionDto entity = (CancionDto) o;
        return Objects.equals(this.titulo, entity.titulo) &&
                Objects.equals(this.album, entity.album) &&
                Objects.equals(this.duracion, entity.duracion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, album, duracion);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "titulo = " + titulo + ", " +
                "album = " + album + ", " +
                "duracion = " + duracion + ")";
    }

    /**
     * DTO for {@link org.dam48.proyectofinalbis.entities.Album}
     */
    public static class AlbumDto implements Serializable {
        private final Integer id;
        private final String titulo;
        private final String urlImagen;

        public AlbumDto(Integer id, String titulo, String urlImagen) {
            this.id = id;
            this.titulo = titulo;
            this.urlImagen = urlImagen;
        }

        public Integer getId() {
            return id;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getUrlImagen() {
            return urlImagen;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AlbumDto entity = (AlbumDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.titulo, entity.titulo) &&
                    Objects.equals(this.urlImagen, entity.urlImagen);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, titulo, urlImagen);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "titulo = " + titulo + ", " +
                    "urlImagen = " + urlImagen + ")";
        }
    }
}