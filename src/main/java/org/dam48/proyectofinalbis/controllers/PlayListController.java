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

    //FUNCIONA
    @PutMapping("/editar")
    public ResponseEntity<ResponseModel> editarPlayList(@RequestBody EditarPlaylistDto playlistDto) {
        return ResponseEntity.ok(playListService.editarPlayList(playlistDto));
    }

    //FUNCIONA
    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearPlayList(@RequestBody PlaylistDto playlistDto) {
        return ResponseEntity.ok(playListService.crearPlayList(playlistDto));
    }

    //FUNCIONA
    @GetMapping("/obtener")
    public ResponseEntity<ResponseModel> obtenerPlaylists() {
        return ResponseEntity.ok(playListService.obtenerPlaylists());
    }

    //FUNCIONA
    @GetMapping("/cancionesPorPlaylist/{idPlaylist}")
    public ResponseEntity<ResponseModel> obtenerCancionesPorPlaylist(@PathVariable Integer idPlaylist) {
        return ResponseEntity.ok(playListService.obtenerCancionesPorPlaylist(idPlaylist));
    }

}
