package org.dam48.proyectofinalbis.projections;

/**
 * Projection for {@link org.dam48.proyectofinalbis.entities.Cancion}
 */
public interface CancionInfo {
    Integer getId();

    String getTitulo();

    String getDuracion();

    AlbumInfo1 getAlbum();

    /**
     * Projection for {@link org.dam48.proyectofinalbis.entities.Album}
     */
    interface AlbumInfo1 {
        Integer getId();

        String getTitulo();

        ArtistaInfo getArtista();

        /**
         * Projection for {@link org.dam48.proyectofinalbis.entities.Artista}
         */
        interface ArtistaInfo {
            Integer getId();

            String getNombre();
        }
    }
}