package org.dam48.proyectofinalbis.projections;

import java.util.Set;

/**
 * Projection for {@link org.dam48.proyectofinalbis.entities.Playlist}
 */
public interface PlaylistInfo {
    Integer getId();

    String getNombrePlaylist();

    String getUrlImagen();

    String getDescripcion();

    Set<CancionesInfo> getCanciones();

    /**
     * Projection for {@link org.dam48.proyectofinalbis.entities.Canciones}
     */
    interface CancionesInfo {
        Integer getId();

        String getTituloCancion();

        String getDuracion();

        AlbumInfo1 getAlbum();

        /**
         * Projection for {@link org.dam48.proyectofinalbis.entities.Album}
         */
        interface AlbumInfo1 {
            Integer getId();

            String getTituloAlbum();

            String getUrlImagen();

            Integer getAnioLanzamiento();

            ArtistaInfo getIdArtista();

            /**
             * Projection for {@link org.dam48.proyectofinalbis.entities.Artista}
             */
            interface ArtistaInfo {
                Integer getId();

                String getNombreArtista();

                String getBiografia();
            }
        }
    }
}