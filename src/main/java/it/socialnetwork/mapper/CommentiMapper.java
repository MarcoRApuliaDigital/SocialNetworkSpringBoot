package it.socialnetwork.mapper;

import it.socialnetwork.dto.CommentiDTO;
import it.socialnetwork.entity.CommentiEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UtentiMapper.class})
public interface CommentiMapper {

    CommentiMapper INSTANCE = Mappers.getMapper(CommentiMapper.class);

    // Entity -> DTO
    CommentiDTO toDTO(CommentiEntity entity);

    // DTO -> Entity
    CommentiEntity toEntity(CommentiDTO dto);
}