package org.dam48.proyectofinalbis.controllers;

import org.dam48.proyectofinalbis.dto.CancionDto;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.services.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/canciones")
public class CancionesController {

    @Autowired
    private CancionService cancionService;

    // Revisar DTO, obtiene titulo cancion,duracion y album (atributos del album)
    @PutMapping("/editarCancion/{id}")
    public ResponseEntity<ResponseModel> editarCancion(@PathVariable("id") Integer id, @RequestBody CancionDto cancionDto) {
        return ResponseEntity.ok(cancionService.editarCancion(id, cancionDto.getTitulo()));
    }


}
