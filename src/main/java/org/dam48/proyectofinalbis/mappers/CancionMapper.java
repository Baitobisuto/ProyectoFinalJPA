package org.dam48.proyectofinalbis.mappers;

import org.dam48.proyectofinalbis.dto.CancionDto;
import org.dam48.proyectofinalbis.entities.Cancion;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CancionMapper {
    Cancion toEntity(CancionDto cancionDto);

    CancionDto toDto(Cancion cancion);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Cancion partialUpdate(CancionDto cancionDto, @MappingTarget Cancion cancion);
}