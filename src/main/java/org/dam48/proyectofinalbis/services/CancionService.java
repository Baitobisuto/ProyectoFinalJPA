package org.dam48.proyectofinalbis.services;

import jakarta.transaction.Transactional;
import org.dam48.proyectofinalbis.entities.Cancion;
import org.dam48.proyectofinalbis.mappers.CancionMapper;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.projections.CancionInfo;
import org.dam48.proyectofinalbis.repositories.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CancionService {

    @Autowired
    private CancionRepository cancionRepository;

    @Autowired
    private CancionMapper cancionMapper;

    @Transactional
    public ResponseModel editarCancion(Integer id, String titulo) {
        if (id == null) {
            return new ResponseModel(1, "Error: El ID de la canción no puede ser nulo", null);
        }

        Optional<Cancion> cancionOptional = cancionRepository.findById(id);
        if (cancionOptional.isPresent()) {
            Cancion cancion = cancionOptional.get();
            cancion.setTitulo(titulo);

            try {
                cancionRepository.save(cancion);
                return new ResponseModel(0, "Cancion editada correctamente", cancion);
            } catch (Exception e) {
                return new ResponseModel(1, "Error al editar la cancion: " + e.getMessage(), null);
            }
        } else {
            return new ResponseModel(1, "Error: No se encontró la canción con el ID " + id, null);
        }
    }

}