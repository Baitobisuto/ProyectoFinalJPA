package org.dam48.proyectofinalbis.mappers;

import org.dam48.proyectofinalbis.dto.PlaylistDto;
import org.dam48.proyectofinalbis.entities.Cancion;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CancionMapper {
    Cancion toEntity(PlaylistDto.CancionDto cancionDto);

    PlaylistDto.CancionDto toDto(Cancion cancion);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cancion partialUpdate(PlaylistDto.CancionDto cancionDto, @MappingTarget Cancion cancion);
}