package org.dam48.proyectofinalbis.projections;

import java.util.Set;

/**
 * Projection for {@link org.dam48.proyectofinalbis.entities.Playlist}
 */
public interface PlaylistInfo {
    Integer getId();

    String getUrlImagen();

    String getNombre();

    Set<CancionInfo> getCanciones();

    /**
     * Projection for {@link org.dam48.proyectofinalbis.entities.Cancion}
     */
    interface CancionInfo {
        Integer getId();

        String getTitulo();

        String getDuracion();
    }
}