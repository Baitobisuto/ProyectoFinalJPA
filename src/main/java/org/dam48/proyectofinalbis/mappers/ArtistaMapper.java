package org.dam48.proyectofinalbis.mappers;

import org.dam48.proyectofinalbis.dto.AlbumDto;
import org.dam48.proyectofinalbis.entities.Artista;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ArtistaMapper {
    Artista toEntity(AlbumDto.ArtistaDto artistaDto);

    AlbumDto.ArtistaDto toDto(Artista artista);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Artista partialUpdate(AlbumDto.ArtistaDto artistaDto, @MappingTarget Artista artista);
}