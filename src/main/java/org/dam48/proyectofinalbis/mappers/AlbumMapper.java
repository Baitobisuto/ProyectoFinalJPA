package org.dam48.proyectofinalbis.mappers;

import org.dam48.proyectofinalbis.dto.AlbumDto;
import org.dam48.proyectofinalbis.entities.Album;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlbumMapper {
    Album toEntity(AlbumDto albumDto);

    AlbumDto toDto(Album album);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Album partialUpdate(AlbumDto albumDto, @MappingTarget Album album);
}