package org.dam48.proyectofinalbis.repositories;

import org.dam48.proyectofinalbis.entities.Album;
import org.dam48.proyectofinalbis.projections.AlbumInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AlbumRepository extends JpaRepository<Album, Integer> {

    List<AlbumInfo> findAllBy();
    AlbumInfo findAlbumById(Integer idAlbum);




}