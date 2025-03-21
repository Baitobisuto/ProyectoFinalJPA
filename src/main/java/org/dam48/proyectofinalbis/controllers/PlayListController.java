package org.dam48.proyectofinalbis.controllers;

import jakarta.transaction.Transactional;
import org.dam48.proyectofinalbis.dto.AlbumDto;
import org.dam48.proyectofinalbis.dto.EditarPlaylistDto;
import org.dam48.proyectofinalbis.dto.PlaylistDto;
import org.dam48.proyectofinalbis.entities.Album;
import org.dam48.proyectofinalbis.entities.Cancion;
import org.dam48.proyectofinalbis.entities.Playlist;
import org.dam48.proyectofinalbis.mappers.PlaylistMapper;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.repositories.CancionRepository;
import org.dam48.proyectofinalbis.repositories.PlaylistRepository;
import org.dam48.proyectofinalbis.services.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
@RequestMapping("playlists")
public class PlayListController {

    @Autowired
    PlayListService playListService;
    @Autowired
    private PlaylistMapper playlistMapper;
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private CancionRepository cancionRepository;


    // Edita playlist
    @PutMapping("/editar")
    public ResponseEntity<ResponseModel> editarPlayList(@RequestBody EditarPlaylistDto playlistDto) {
        return ResponseEntity.ok(playListService.editarPlayList(playlistDto));
    }


    // Crea la playlist nombre y canciones pero imagen a null
//    @PostMapping("/crear")
//    public ResponseEntity<ResponseModel> crearPlayList(@RequestBody PlaylistDto playlistDto) {
//        return ResponseEntity.ok(playListService.crearPlayList(playlistDto));
//    }

    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearPlaylist(@RequestBody PlaylistDto playlistDto) {
        ResponseModel response = playListService.crearPlayList(playlistDto);

        if (response.getSuccess() != 0) {
            return ResponseEntity.ok(response);
        }

        try {
            // Obtener el ID del álbum recién creado
            Integer idPlaylist = (Integer) response.getData();

            // Verificar que la URL de la imagen tenga una extensión válida
            String urlImagenOriginal = playlistDto.getUrlImagen();
            if (urlImagenOriginal != null && !urlImagenOriginal.isEmpty() && urlImagenOriginal.contains(".")) {

                // Extraer la extensión del archivo (ejemplo: ".png", ".jpg")
                String extension = urlImagenOriginal.substring(urlImagenOriginal.lastIndexOf("."));

                // Guardar solo "ID + extensión" en la base de datos (ejemplo: "123.png")
                String nombreImagen = idPlaylist + extension;


                Set<Cancion> canciones = new LinkedHashSet<>();
                for (PlaylistDto.CancionDto1 cancionDto1 : playlistDto.getCanciones()) {
                    // Obtén la canción existente desde la base de datos
                    Cancion cancionExistente = cancionRepository.findById(cancionDto1.getId())
                            .orElseThrow(() -> new RuntimeException("Canción no encontrada"));
                    canciones.add(cancionExistente);
                }

                // Actualizar la URL de la imagen en la entidad Album
                Playlist playlist = playlistMapper.toEntity(playlistDto); // Convertir el DTO a la entidad
                playlist.setId(idPlaylist); // Asignar el ID recién creado
                playlist.setUrlImagen(nombreImagen); // Guardar solo "ID + extensión"
                playlist.setCanciones(canciones);


                // Guardar el álbum con la URL de imagen actualizada en la base de datos
                playlistRepository.save(playlist);

                response.setMessage("Playlist creada y nombre de imagen guardado correctamente");
                response.setData(idPlaylist);
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

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<ResponseModel> borrarPlaylist(@PathVariable Integer id) {
        return ResponseEntity.ok(playListService.borrarPlaylist(id));
    }

    //Obtiene todas las playlists,id,nombre,canciones e imagen
    @GetMapping("/obtenerPlaylists")
    public ResponseEntity<ResponseModel> obtenerPlaylists() {
        return ResponseEntity.ok(playListService.obtenerPlaylists());
    }

}
