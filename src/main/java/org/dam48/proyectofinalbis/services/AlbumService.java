package org.dam48.proyectofinalbis.services;

import org.dam48.proyectofinalbis.dto.AlbumDto;
import org.dam48.proyectofinalbis.entities.Album;
import org.dam48.proyectofinalbis.entities.Cancion;
import org.dam48.proyectofinalbis.mappers.AlbumMapper;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        List<Album> listaAlbums = albumRepository.findAll();

        if (listaAlbums.isEmpty()) {
            return new ResponseModel(1, "No se encontraron álbumes", null);
        }
        return new ResponseModel(0, "Lista de álbumes", listaAlbums);
    }

    public ResponseModel obtenerCancionesPorAlbum(Integer idAlbum) {
        return albumRepository.findById(idAlbum)
                .map(album -> {
                    Set<Cancion> cancionesSet = album.getCanciones();

                    if (cancionesSet == null || cancionesSet.isEmpty()) {
                        return new ResponseModel(1, "No se encontraron canciones para este álbum", null);
                    }

                    return new ResponseModel(0, "Lista de canciones", cancionesSet.stream().collect(Collectors.toList()));
                })
                .orElse(new ResponseModel(1, "No se encontró el álbum", null));
    }
}
