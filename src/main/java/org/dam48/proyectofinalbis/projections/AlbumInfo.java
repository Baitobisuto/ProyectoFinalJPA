package org.dam48.proyectofinalbis.projections;

/**
 * Projection for {@link org.dam48.proyectofinalbis.entities.Album}
 */
public interface AlbumInfo {
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