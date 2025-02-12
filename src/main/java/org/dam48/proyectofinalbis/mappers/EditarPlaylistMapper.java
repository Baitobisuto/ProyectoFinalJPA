package org.dam48.proyectofinalbis.mappers;

import org.dam48.proyectofinalbis.dto.EditarPlaylistDto;
import org.dam48.proyectofinalbis.entities.Playlist;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EditarPlaylistMapper {
    Playlist toEntity(EditarPlaylistDto editarPlaylistDto);

    EditarPlaylistDto toDto(Playlist playlist);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Playlist partialUpdate(EditarPlaylistDto editarPlaylistDto, @MappingTarget Playlist playlist);
}