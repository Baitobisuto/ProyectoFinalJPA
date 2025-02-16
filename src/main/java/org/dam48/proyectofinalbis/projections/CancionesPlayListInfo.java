package org.dam48.proyectofinalbis.projections;

import java.util.Set;

/**
 * Projection for {@link org.dam48.proyectofinalbis.entities.Playlist}
 */
public interface CancionesPlayListInfo {
    Integer getId();

    Set<CancionInfo1> getCanciones();

    /**
     * Projection for {@link org.dam48.proyectofinalbis.entities.Cancion}
     */
    interface CancionInfo1 {
        Integer getId();

        String getTitulo();

        String getDuracion();
    }
}