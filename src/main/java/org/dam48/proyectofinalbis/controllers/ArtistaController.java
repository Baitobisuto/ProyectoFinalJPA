package org.dam48.proyectofinalbis.controllers;

import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.services.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @GetMapping("/obtenerArtistas")
    public ResponseEntity<ResponseModel> obtenerAtistas(){
        return ResponseEntity.ok(artistaService.obtenerArtistas());
    }

}
