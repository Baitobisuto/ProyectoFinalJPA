package org.dam48.proyectofinalbis.repositories;

import org.dam48.proyectofinalbis.entities.Cancion;
import org.dam48.proyectofinalbis.entities.Playlist;
import org.dam48.proyectofinalbis.projections.PlaylistInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

    //Obtener todas las playlists
    List<PlaylistInfo> findAllBy();

    //Obtiene la info de una playlist
    @Query("select p from Playlist p where p.id = ?1")
    PlaylistInfo getCancionesPlayList(Integer id);



}