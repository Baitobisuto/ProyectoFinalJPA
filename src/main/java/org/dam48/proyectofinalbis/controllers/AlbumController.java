package org.dam48.proyectofinalbis.controllers;

import org.dam48.proyectofinalbis.dto.AlbumDto;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    //Obtiene id y titulo del album,id y nombre del artista, urlImagen y canciones del album con id de la cancion,titulo y duracion
    @GetMapping("/obtenerAlbums")
    public ResponseEntity<ResponseModel> obtenerAlbums(){
        return ResponseEntity.ok(albumService.obtenerAlbum());
    }

    //Crea un album con id,titulo,artista,urlImagen
    @PostMapping("/crearAlbum")
    public ResponseEntity<ResponseModel> crearAlbum(@RequestBody AlbumDto albumDto){
        return ResponseEntity.ok(albumService.crearAlbum(albumDto));
    }

    // Obtiene id,titulo y duracion de las canciones de un album
    @GetMapping("/cancionesPorAlbum/{idAlbum}")
    public ResponseEntity<ResponseModel> obtenerCancionesDeAlbum(@PathVariable Integer idAlbum){
        return ResponseEntity.ok(albumService.obtenerCancionesDeAlbum(idAlbum));
    }
}
