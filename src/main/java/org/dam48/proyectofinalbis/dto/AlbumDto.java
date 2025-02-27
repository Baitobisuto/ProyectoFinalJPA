package org.dam48.proyectofinalbis.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link org.dam48.proyectofinalbis.entities.Album}
 */
public class AlbumDto implements Serializable {
    private final Integer id;
    private final String titulo;
    private final ArtistaDto artista;
    private final String urlImagen;

    public AlbumDto(Integer id, String titulo, ArtistaDto artista, String urlImagen) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.urlImagen = urlImagen;
    }


    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArtistaDto getArtista() {
        return artista;
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
                Objects.equals(this.artista, entity.artista) &&
                Objects.equals(this.urlImagen, entity.urlImagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, artista, urlImagen);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "titulo = " + titulo + ", " +
                "artista = " + artista + ", " +
                "urlImagen = " + urlImagen + ")";
    }

    /**
     * DTO for {@link org.dam48.proyectofinalbis.entities.Artista}
     */
    public static class ArtistaDto implements Serializable {
        private final Integer id;

        public ArtistaDto(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArtistaDto entity = (ArtistaDto) o;
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