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

    //FUNCIONA
    @GetMapping("/obtenerAlbums")
    public ResponseEntity<ResponseModel> obtenerAlbums(){
        return ResponseEntity.ok(albumService.obtenerAlbum());
    }

    //FUNCIONA
    @PostMapping("/crearAlbum")
    public ResponseEntity<ResponseModel> crearAlbum(@RequestBody AlbumDto albumDto){
        return ResponseEntity.ok(albumService.crearAlbum(albumDto));
    }

    //FUNCIONA
    @GetMapping("/cancionesPorAlbum/{idAlbum}")
    public ResponseEntity<ResponseModel> obtenerCancionesDeAlbum(@PathVariable Integer idAlbum){
        return ResponseEntity.ok(albumService.obtenerCancionesDeAlbum(idAlbum));
    }
}
