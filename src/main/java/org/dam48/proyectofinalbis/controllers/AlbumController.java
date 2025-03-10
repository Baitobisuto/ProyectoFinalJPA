package org.dam48.proyectofinalbis.controllers;

import org.dam48.proyectofinalbis.dto.AlbumDto;
import org.dam48.proyectofinalbis.entities.Album;
import org.dam48.proyectofinalbis.mappers.AlbumMapper;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.repositories.AlbumRepository;
import org.dam48.proyectofinalbis.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumMapper albumMapper;

    //Obtiene id y titulo del album,id y nombre del artista, urlImagen y canciones del album con id de la cancion,titulo y duracion
    @GetMapping("/obtenerAlbums")
    public ResponseEntity<ResponseModel> obtenerAlbums(){
        return ResponseEntity.ok(albumService.obtenerAlbum());
    }

    @PostMapping("/crearAlbum")
    public ResponseEntity<ResponseModel> crearAlbum(@RequestBody AlbumDto albumDto) {
        // Crear el álbum usando el servicio y obtener la respuesta inicial
        ResponseModel response = albumService.crearAlbum(albumDto);

        // Si la creación no fue exitosa, devolver la respuesta tal cual
        if (response.getSuccess() != 0) {
            return ResponseEntity.ok(response);
        }

        try {
            // Obtener el ID del álbum recién creado
            Integer idAlbum = (Integer) response.getData();

            // Verificar que la URL de la imagen tenga una extensión válida
            String urlImagenOriginal = albumDto.getUrlImagen();
            if (urlImagenOriginal != null && !urlImagenOriginal.isEmpty() && urlImagenOriginal.contains(".")) {

                // Extraer la extensión del archivo (ejemplo: ".png", ".jpg")
                String extension = urlImagenOriginal.substring(urlImagenOriginal.lastIndexOf("."));

                // Guardar solo "ID + extensión" en la base de datos (ejemplo: "123.png")
                String nombreImagen = idAlbum + extension;

                // Actualizar la URL de la imagen en la entidad Album
                Album album = albumMapper.toEntity(albumDto); // Convertir el DTO a la entidad
                album.setId(idAlbum); // Asignar el ID recién creado
                album.setUrlImagen(nombreImagen); // Guardar solo "ID + extensión"

                // Guardar el álbum con la URL de imagen actualizada en la base de datos
                albumRepository.save(album);

                response.setMessage("Álbum creado y nombre de imagen guardado correctamente");
                response.setData(idAlbum);
            } else {
                response.setSuccess(1);
                response.setMessage("Extensión de imagen no válida");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.setSuccess(1);
            response.setMessage("Error al actualizar el nombre de la imagen");
        }

        return ResponseEntity.ok(response);
    }

    // Obtiene id,titulo y duracion de las canciones de un album
    @GetMapping("/cancionesPorAlbum/{idAlbum}")
    public ResponseEntity<ResponseModel> obtenerCancionesDeAlbum(@PathVariable Integer idAlbum){
        return ResponseEntity.ok(albumService.obtenerCancionesDeAlbum(idAlbum));
    }

    @DeleteMapping("/borrarAlbum/{id_album}")
    public ResponseEntity<ResponseModel> borrarAlbum(@PathVariable Integer id_album){
        return ResponseEntity.ok(albumService.borrarAlbum(id_album));
    }


}
