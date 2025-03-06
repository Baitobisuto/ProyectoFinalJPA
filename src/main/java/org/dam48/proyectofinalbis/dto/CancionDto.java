package org.dam48.proyectofinalbis.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link org.dam48.proyectofinalbis.entities.Cancion}
 */
public class CancionDto implements Serializable {
    private final Integer id;
    private final String titulo;
    private final AlbumDto1 album;
    private final String archivo;
    private final String duracion;

    public CancionDto(Integer id, String titulo, AlbumDto1 album, String archivo, String duracion) {
        this.id = id;
        this.titulo = titulo;
        this.album = album;
        this.archivo = archivo;
        this.duracion = duracion;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public AlbumDto1 getAlbum() {
        return album;
    }

    public String getArchivo() {
        return archivo;
    }

    public String getDuracion() {
        return duracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CancionDto entity = (CancionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.titulo, entity.titulo) &&
                Objects.equals(this.album, entity.album) &&
                Objects.equals(this.archivo, entity.archivo) &&
                Objects.equals(this.duracion, entity.duracion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, album, archivo, duracion);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "titulo = " + titulo + ", " +
                "album = " + album + ", " +
                "archivo = " + archivo + ", " +
                "duracion = " + duracion + ")";
    }

    /**
     * DTO for {@link org.dam48.proyectofinalbis.entities.Album}
     */
    public static class AlbumDto1 implements Serializable {
        private final Integer id;

        public AlbumDto1(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AlbumDto1 entity = (AlbumDto1) o;
            return Objects.equals(this.id, entity.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ")";
        }
    }
}