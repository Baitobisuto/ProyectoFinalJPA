package org.dam48.proyectofinalbis.projections;

import java.util.Set;

/**
 * Projection for {@link org.dam48.proyectofinalbis.entities.Album}
 */
public interface AlbumInfo {
    Integer getId();

    String getTitulo();

    String getUrlImagen();

    ArtistaInfo getArtista();

    Set<CancionInfo> getCanciones();

    /**
     * Projection for {@link org.dam48.proyectofinalbis.entities.Artista}
     */
    interface ArtistaInfo {
        Integer getId();

        String getNombre();
    }

    /**
     * Projection for {@link org.dam48.proyectofinalbis.entities.Cancion}
     */
    interface CancionInfo {
        Integer getId();

        String getTitulo();

        String getDuracion();
    }
}