package org.dam48.proyectofinalbis.repositories;

import org.dam48.proyectofinalbis.entities.Cancion;
import org.dam48.proyectofinalbis.projections.CancionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CancionRepository extends JpaRepository<Cancion, Integer> {

  @Query("select c from Cancion c where c.id = ?1")
  List<Cancion> obtenerCancionPorID(Integer id);

  List<CancionInfo> findAllBy();




}