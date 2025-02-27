package org.dam48.proyectofinalbis.controllers;

import org.dam48.proyectofinalbis.dto.EditarPlaylistDto;
import org.dam48.proyectofinalbis.dto.PlaylistDto;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.services.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("playlists")
public class PlayListController {

    @Autowired
    PlayListService playListService;


    // Edita playlist
    @PutMapping("/editar")
    public ResponseEntity<ResponseModel> editarPlayList(@RequestBody EditarPlaylistDto playlistDto) {
        return ResponseEntity.ok(playListService.editarPlayList(playlistDto));
    }


    // Crea la playlist nombre y canciones pero imagen a null
    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearPlayList(@RequestBody PlaylistDto playlistDto) {
        return ResponseEntity.ok(playListService.crearPlayList(playlistDto));
    }

    //Obtiene todas las playlists,id,nombre,canciones e imagen
    @GetMapping("/obtenerPlaylists")
    public ResponseEntity<ResponseModel> obtenerPlaylists() {
        return ResponseEntity.ok(playListService.obtenerPlaylists());
    }

    //Muestra id playlist,nombre,canciones e imagen busqueda por id de playlist
    @GetMapping("/cancionesPorPlaylist/{idPlaylist}")
    public ResponseEntity<ResponseModel> obtenerCancionesPorPlaylist(@PathVariable int idPlaylist) {
        return ResponseEntity.ok(playListService.obtenerCancionesPorPlaylist(idPlaylist));
    }
}
