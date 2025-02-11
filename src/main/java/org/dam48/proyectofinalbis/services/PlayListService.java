package org.dam48.proyectofinalbis.services;

import jakarta.transaction.Transactional;
import org.dam48.proyectofinalbis.dto.PlaylistDto;
import org.dam48.proyectofinalbis.entities.Canciones;
import org.dam48.proyectofinalbis.entities.Playlist;
import org.dam48.proyectofinalbis.mappers.PlaylistMapper;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PlayListService {

    @Autowired
    private PlaylistRepository playListRepository;
    @Autowired
    private PlaylistMapper playlistMapper;

    @Transactional
    public ResponseModel crearPlayList(PlaylistDto playListDto){
        Playlist playlist = playlistMapper.toEntity(playListDto);
        playlist = playListRepository.save(playlist);
        if(playlist.getId()!=null){
            return new ResponseModel(0,"Playlist creada correctamente",playlist);
        }
        return new ResponseModel(1,"Error al crear la playlist",null);
    }

    public ResponseModel obtenerPlaylists() {
        List<Playlist> listaPlaylists = playListRepository.findAll(); // Obtiene todas las playlists
        if (!listaPlaylists.isEmpty()) {
            return new ResponseModel(0, "Lista de playlists", listaPlaylists);
        }
        return new ResponseModel(1, "No se encontraron playlists", null);
    }

    public ResponseModel obtenerCancionesPorPlaylist(Integer idPlaylist) {
        Optional<Playlist> playlist = playListRepository.findById(idPlaylist);
        if (playlist.isPresent()) {
            Set<Canciones> listaCanciones = playlist.get().getCanciones();
            if (!listaCanciones.isEmpty()) {
                return new ResponseModel(0, "Lista de canciones", listaCanciones);
            } else {
                return new ResponseModel(1, "No se encontraron canciones para este playlist", null);
            }
        }
        return new ResponseModel(1, "No se encontró el playlist", null);

    }


}
