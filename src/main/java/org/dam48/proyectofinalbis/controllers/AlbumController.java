package org.dam48.proyectofinalbis.controllers;

import org.dam48.proyectofinalbis.dto.AlbumDto;
import org.dam48.proyectofinalbis.entities.Album;
import org.dam48.proyectofinalbis.entities.Canciones;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/obtenerAlbums")
    public ResponseEntity<ResponseModel> obtenerAlbums(){
        return ResponseEntity.ok(albumService.obtenerAlbum());
    }

    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearAlbum(@RequestBody AlbumDto albumDto){
        return ResponseEntity.ok(albumService.crearAlbum(albumDto));
    }

    @GetMapping("/cancionesPorAlbum/{idAlbum}")
    public ResponseEntity<ResponseModel> obtenerCancionesPorAlbum(@PathVariable Integer idAlbum){
        return ResponseEntity.ok(albumService.obtenerCancionesPorAlbum(idAlbum));
    }



}
