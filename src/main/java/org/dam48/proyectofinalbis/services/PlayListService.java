package org.dam48.proyectofinalbis.services;

import jakarta.transaction.Transactional;
import org.dam48.proyectofinalbis.dto.EditarPlaylistDto;
import org.dam48.proyectofinalbis.dto.PlaylistDto;
import org.dam48.proyectofinalbis.entities.Cancion;
import org.dam48.proyectofinalbis.entities.Playlist;
import org.dam48.proyectofinalbis.mappers.EditarPlaylistMapper;
import org.dam48.proyectofinalbis.mappers.PlaylistMapper;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.projections.PlaylistInfo;
import org.dam48.proyectofinalbis.repositories.CancionRepository;
import org.dam48.proyectofinalbis.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class PlayListService {

    @Autowired
    private PlaylistRepository playListRepository;
    @Autowired
    private PlaylistMapper playlistMapper;
    @Autowired
    private EditarPlaylistMapper editarPlaylistMapper;
    @Autowired
    private CancionRepository cancionRepository;


    @Transactional
    public ResponseModel crearPlayList(PlaylistDto playListDto){
        Playlist playlist = playlistMapper.toEntity(playListDto);

        Set<Cancion> canciones = new HashSet<>();
        for (Cancion cancionDto : playlist.getCanciones()) {
            Cancion cancion;
            if (cancionDto.getId() != null) {
                cancion = cancionRepository.findById(cancionDto.getId()).orElse(null); // Busca la canción por ID
            } else {
                cancion = cancionDto; // Si no tiene Id, es una nueva cancion
            }
            if(cancion != null){
                canciones.add(cancion);
            }
        }
        playlist.setCanciones(canciones);


        playlist = playListRepository.save(playlist);

        if(playlist.getId()!=null){
            return new ResponseModel(0,"Playlist creada correctamente",playlist.getId());
        }
        return new ResponseModel(1,"Error al crear la playlist",null);
    }
    @Transactional
    public ResponseModel editarPlayList(EditarPlaylistDto playListDto){
        Playlist playlist = editarPlaylistMapper.toEntity(playListDto);
        Set<Cancion> canciones = new HashSet<>();
        for (Cancion cancionDto : playlist.getCanciones()) {
            Cancion cancion;
            if (cancionDto.getId() != null) {
                cancion = cancionRepository.findById(cancionDto.getId()).orElse(null); // Busca la canción por ID
            } else {
                cancion = cancionDto; // Si no tiene Id, es una nueva cancion
            }
            if(cancion != null){
                canciones.add(cancion);
            }
        }
        playlist.setCanciones(canciones);
        playlist = playListRepository.save(playlist);

        if(playlist.getId()!=null){
            return new ResponseModel(0,"Playlist editada correctamente",playlist);
        }
        return new ResponseModel(1,"Error al editar la playlist",null);
    }

    public ResponseModel obtenerPlaylists() {
        List<PlaylistInfo> listaPlaylists = playListRepository.findAllBy();
        if (!listaPlaylists.isEmpty()) {
            return new ResponseModel(0, "Lista de playlists", listaPlaylists);
        }
        return new ResponseModel(1, "No se encontraron playlists", null);
    }
    //REVISAR ESTO
    public ResponseModel obtenerCancionesPorPlaylist(int idPlaylist) {
       PlaylistInfo playlist = playListRepository.getCancionesPlayList(idPlaylist);
        if (playlist == null) {
            return new ResponseModel(1, "No se encontraron canciones para este playlist", null);
        }
        return new ResponseModel(0, "Lista de canciones", playlist);
    }


}
