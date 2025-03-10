package org.dam48.proyectofinalbis.services;

import org.dam48.proyectofinalbis.dto.AlbumDto;
import org.dam48.proyectofinalbis.entities.Album;
import org.dam48.proyectofinalbis.mappers.AlbumMapper;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.projections.AlbumInfo;
import org.dam48.proyectofinalbis.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {


    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumMapper albumMapper;

    public ResponseModel crearAlbum(AlbumDto albumDto) {
        Album album = albumMapper.toEntity(albumDto);
        Album savedAlbum = albumRepository.save(album);

        if (savedAlbum.getId() == null) {
            return new ResponseModel(1, "Error al crear el álbum", null);
        }
        return new ResponseModel(0, "Álbum creado correctamente", savedAlbum.getId());
    }

    public ResponseModel obtenerAlbum() {
        List<AlbumInfo> listaAlbums = albumRepository.findAllBy();

        if (listaAlbums.isEmpty()) {
            return new ResponseModel(1, "No se encontraron álbumes", null);
        }
        return new ResponseModel(0, "Lista de álbumes", listaAlbums);
    }

    //REVISAR
    public ResponseModel obtenerCancionesDeAlbum(Integer idAlbum) {
        AlbumInfo album = albumRepository.findAlbumById(idAlbum);

        if (album == null) {
            return new ResponseModel(1, "No se encontró el álbum", null);
        }

        // Si no hay canciones, devolvemos un mensaje de error
        if (album.getCanciones() == null || album.getCanciones().isEmpty()) {
            return new ResponseModel(1, "No se encontraron canciones para este álbum", null);
        }

        // Retornamos las canciones en la respuesta
        return new ResponseModel(0, "Canciones encontradas", album.getCanciones());
    }

    public ResponseModel borrarAlbum(Integer idAlbum) {
        albumRepository.deleteById(idAlbum);
        return new ResponseModel(0, "Álbum borrado correctamente", null);
    }
}

