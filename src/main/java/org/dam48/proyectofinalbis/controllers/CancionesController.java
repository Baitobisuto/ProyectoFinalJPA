package org.dam48.proyectofinalbis.controllers;

import org.dam48.proyectofinalbis.dto.CancionDto;
import org.dam48.proyectofinalbis.dto.PlaylistDto;
import org.dam48.proyectofinalbis.entities.Cancion;
import org.dam48.proyectofinalbis.mappers.CancionMapper;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.repositories.CancionRepository;
import org.dam48.proyectofinalbis.services.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/canciones")
public class CancionesController {

    @Autowired
    private CancionService cancionService;

    @Autowired
    private CancionRepository cancionRepository;

    @Autowired
    private CancionMapper cancionMapper;

    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearCancion(@RequestBody CancionDto cancionDto) {
        ResponseModel responseModel = cancionService.crearCancion(cancionDto);

        if(responseModel.getSuccess() != 0){
            return ResponseEntity.ok(responseModel);
        }

        try{
            // Obtener el id de la cancion recien creada
            Integer idCancion = (Integer) responseModel.getData();

            // Verificar que la URL del audio tenga una extensión válida
            String urlAudioOriginal = cancionDto.getArchivo();
            if(urlAudioOriginal != null && !urlAudioOriginal.isEmpty() && urlAudioOriginal.contains(".")){
                String extension = urlAudioOriginal.substring(urlAudioOriginal.lastIndexOf("."));

                String nombreAudio = idCancion +  extension;

                Cancion cancion = cancionMapper.toEntity(cancionDto);
                cancion.setId(idCancion);
                cancion.setArchivo(nombreAudio);

                cancionRepository.save(cancion);

                responseModel.setMessage("Cancion creada con exito");
                responseModel.setData(idCancion);
            } else{
                responseModel.setSuccess(1);
                responseModel.setMessage("Extensión del audio no válida");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseModel.setSuccess(1);
            responseModel.setMessage("Error al actualizar el nombre de la imagen");
        }
        return ResponseEntity.ok(responseModel);
    }

    // Revisar DTO, obtiene titulo cancion,duracion y album (atributos del album)
    @PutMapping("/editarCancion/{id}")
    public ResponseEntity<ResponseModel> editarCancion(@PathVariable("id") Integer id, @RequestBody CancionDto cancionDto) {
        return ResponseEntity.ok(cancionService.editarCancion(id, cancionDto.getTitulo()));
    }

    @GetMapping("/obtenerCanciones")
    public ResponseEntity<ResponseModel> obtenerCanciones() {
        return ResponseEntity.ok(cancionService.obtenerCanciones());
    }

}
