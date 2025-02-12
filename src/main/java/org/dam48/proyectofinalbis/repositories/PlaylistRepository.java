package org.dam48.proyectofinalbis.repositories;

import org.dam48.proyectofinalbis.entities.Playlist;
import org.dam48.proyectofinalbis.projections.PlaylistInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

    Optional<List<PlaylistInfo>> findAllBy();

    @Query("""
            select p from Playlist p inner join p.canciones canciones
            where upper(canciones.titulo) like upper(?1)""")
    List<Playlist> obtenerCancionesPlaylist(String tituloCancion);

    //Método para obtener canciones de un playlist
    @Query("select p from Playlist p left join p.canciones canciones where canciones.id in ?1")
    List<Playlist> findByCanciones_IdIn(Collection<Integer> ids);


}