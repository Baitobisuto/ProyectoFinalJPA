package org.dam48.proyectofinalbis.services;

import org.dam48.proyectofinalbis.dto.AlbumDto;
import org.dam48.proyectofinalbis.entities.Album;
import org.dam48.proyectofinalbis.entities.Canciones;
import org.dam48.proyectofinalbis.mappers.AlbumMapper;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.projections.AlbumInfo;
import org.dam48.proyectofinalbis.repositories.AlbumRepository;
import org.hibernate.boot.model.internal.BasicValueBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {


    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private AlbumMapper albumMapper;

    public ResponseModel crearAlbum(AlbumDto albumDto) {
        Album album = albumMapper.toEntity(albumDto);
        album = albumRepository.save(album);
        if (album.getId() == null) {
            return new ResponseModel(1, "Error al crear el album", album.getId());
        }
        return new ResponseModel(0, "Album creado correctamente", album.getId());
    }


    public ResponseModel obtenerAlbum() {
        Optional<List<AlbumInfo>> listaAlbums = albumRepository.findAllBy();
        if (listaAlbums.isPresent()) {
            return new ResponseModel(0, "Lista de albums", listaAlbums.get());
        }
        return new ResponseModel(1, "No se pudo obtener los albumes", null);
    }

    public ResponseModel obtenerCancionesPorAlbum(Integer idAlbum) {
        Optional<Album> album = albumRepository.findById(idAlbum);
        if(album.isPresent()){
            List<Canciones> listaCanciones = album.get().getCanciones();
            if (!listaCanciones.isEmpty()) {
                return new ResponseModel(0, "Lista de canciones", listaCanciones);
            } else {
                return new ResponseModel(1, "No se encontraron canciones para este álbum", null);
            }
        }
        return new ResponseModel(1, "No se encontró el álbum", null);
    }




}
