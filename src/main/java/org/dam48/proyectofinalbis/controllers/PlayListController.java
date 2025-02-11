package org.dam48.proyectofinalbis.controllers;

import org.dam48.proyectofinalbis.dto.PlaylistDto;
import org.dam48.proyectofinalbis.entities.Canciones;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.services.AlbumService;
import org.dam48.proyectofinalbis.services.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("playlists")
public class PlayListController {

    @Autowired
    PlayListService playListService;



    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearPlayList(@RequestBody PlaylistDto playlistDto){
        return ResponseEntity.ok(playListService.crearPlayList(playlistDto));
    }

    @GetMapping("/obtener")
    public ResponseEntity<ResponseModel> obtenerPlaylists() {
        return ResponseEntity.ok(playListService.obtenerPlaylists());
    }

    @GetMapping("/cancionesPorPlaylist/{idPlaylist}")
    public ResponseEntity<ResponseModel> obtenerCancionesPorPlaylist(@PathVariable Integer idPlaylist){
        return ResponseEntity.ok(playListService.obtenerCancionesPorPlaylist(idPlaylist));
    }

}
