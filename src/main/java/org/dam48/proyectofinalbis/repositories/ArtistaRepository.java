package org.dam48.proyectofinalbis.repositories;

import org.dam48.proyectofinalbis.entities.Artista;
import org.dam48.proyectofinalbis.projections.ArtistaInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistaRepository extends JpaRepository<Artista, Integer> {

    List<ArtistaInfo> findAllBy();
}