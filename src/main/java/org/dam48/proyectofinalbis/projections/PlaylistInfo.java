package org.dam48.proyectofinalbis.projections;

import java.util.Set;

/**
 * Projection for {@link org.dam48.proyectofinalbis.entities.Playlist}
 */
public interface PlaylistInfo {
    Integer getId();

    String getUrlImagen();

    String getNombre();

    Set<CancionInfo1> getCanciones();

    /**
     * Projection for {@link org.dam48.proyectofinalbis.entities.Cancion}
     */
    interface CancionInfo1 {
        Integer getId();

        String getTitulo();

        String getArchivo();

        AlbumInfo1 getAlbum();

        /**
         * Projection for {@link org.dam48.proyectofinalbis.entities.Album}
         */
        interface AlbumInfo1 {
            Integer getId();

            String getTitulo();

            String getUrlImagen();

            ArtistaInfo1 getArtista();

            /**
             * Projection for {@link org.dam48.proyectofinalbis.entities.Artista}
             */
            interface ArtistaInfo1 {
                Integer getId();

                String getNombre();
            }
        }
    }
}