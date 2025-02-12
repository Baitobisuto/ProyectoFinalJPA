package org.dam48.proyectofinalbis.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link org.dam48.proyectofinalbis.entities.Playlist}
 */
public class EditarPlaylistDto implements Serializable {
    private final Integer id;
    private final String urlImagen;
    private final String nombre;
    private final Set<CancionDto> canciones;

    public EditarPlaylistDto(Integer id, String urlImagen, String nombre, Set<CancionDto> canciones) {
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

    public Set<CancionDto> getCanciones() {
        return canciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditarPlaylistDto entity = (EditarPlaylistDto) o;
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
    public static class CancionDto implements Serializable {
        private final Integer id;

        public CancionDto(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CancionDto entity = (CancionDto) o;
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