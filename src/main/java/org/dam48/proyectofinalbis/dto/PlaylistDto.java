package org.dam48.proyectofinalbis.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link org.dam48.proyectofinalbis.entities.Playlist}
 */
public class PlaylistDto implements Serializable {
    private final Integer id;
    private final String urlImagen;
    private final String nombre;
    private final Set<CancionDto1> canciones;

    public PlaylistDto(Integer id, String urlImagen, String nombre, Set<CancionDto1> canciones) {
        this.id = id;
        this.urlImagen = urlImagen;
        this.nombre = nombre;
        this.canciones = canciones;
    }

    public Integer getId() {
        return id;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<CancionDto1> getCanciones() {
        return canciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistDto entity = (PlaylistDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.urlImagen, entity.urlImagen) &&
                Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.canciones, entity.canciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, urlImagen, nombre, canciones);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "urlImagen = " + urlImagen + ", " +
                "nombre = " + nombre + ", " +
                "canciones = " + canciones + ")";
    }

    /**
     * DTO for {@link org.dam48.proyectofinalbis.entities.Cancion}
     */
    public static class CancionDto1 implements Serializable {
        private final Integer id;
        private final AlbumDto1 album;

        public CancionDto1(Integer id, AlbumDto1 album) {
            this.id = id;
            this.album = album;
        }

        public Integer getId() {
            return id;
        }

        public AlbumDto1 getAlbum() {
            return album;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CancionDto1 entity = (CancionDto1) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.album, entity.album);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, album);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "album = " + album + ")";
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
}