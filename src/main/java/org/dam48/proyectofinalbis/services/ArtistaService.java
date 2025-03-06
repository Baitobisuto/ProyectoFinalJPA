package org.dam48.proyectofinalbis.services;

import org.dam48.proyectofinalbis.mappers.ArtistaMapper;
import org.dam48.proyectofinalbis.models.ResponseModel;
import org.dam48.proyectofinalbis.projections.ArtistaInfo;
import org.dam48.proyectofinalbis.projections.CancionInfo;
import org.dam48.proyectofinalbis.repositories.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private ArtistaMapper artistaMapper;

    public ResponseModel obtenerArtistas() {
        List<ArtistaInfo> listaArtistas = artistaRepository.findAllBy();
        if (!listaArtistas.isEmpty()) {
            return new ResponseModel(0, "Lista de artistas", listaArtistas);
        }
        return new ResponseModel(1, "No se encontraron artistas", null);
    }
}
