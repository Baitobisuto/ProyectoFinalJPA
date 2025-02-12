package org.dam48.proyectofinalbis.repositories;

import org.dam48.proyectofinalbis.entities.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CancionRepository extends JpaRepository<Cancion, Integer> {
  List<Cancion> findByTitulo(String titulo);
}