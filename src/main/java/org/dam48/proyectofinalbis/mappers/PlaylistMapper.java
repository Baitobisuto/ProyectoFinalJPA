package org.dam48.proyectofinalbis.mappers;

import org.dam48.proyectofinalbis.dto.PlaylistDto;
import org.dam48.proyectofinalbis.entities.Playlist;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlaylistMapper {
    Playlist toEntity(PlaylistDto playlistDto1);

    PlaylistDto toDto(Playlist playlist);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Playlist partialUpdate(PlaylistDto playlistDto1, @MappingTarget Playlist playlist);
}