package org.dam48.proyectofinalbis.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link org.dam48.proyectofinalbis.entities.Playlist}
 */
public class PlaylistDto implements Serializable {
    private final Integer id;
    private final String nombre;
    private final Set<CancionDto> canciones;

    public PlaylistDto(Integer id, String nombre, Set<CancionDto> canciones) {
        this.id = id;
        this.nombre = nombre;
        this.canciones = canciones;
    }

    public Integer getId() {
        return id;
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
        PlaylistDto entity = (PlaylistDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.canciones, entity.canciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, canciones);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nombre = " + nombre + ", " +
                "canciones = " + canciones + ")";
    }

    /**
     * DTO for {@link org.dam48.proyectofinalbis.entities.Cancion}
     */
    public static class CancionDto implements Serializable {
        private final Integer id;
        private final String titulo;
        private final String duracion;

        public CancionDto(Integer id, String titulo, String duracion) {
            this.id = id;
            this.titulo = titulo;
            this.duracion = duracion;
        }

        public Integer getId() {
            return id;
        }

        public String getTitulo() {
            return titulo;
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
                    Objects.equals(this.duracion, entity.duracion);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, titulo, duracion);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "titulo = " + titulo + ", " +
                    "duracion = " + duracion + ")";
        }
    }
}