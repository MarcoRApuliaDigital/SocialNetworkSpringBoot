package it.socialnetwork.mapper;

import it.socialnetwork.dto.UtentiDTO;
import it.socialnetwork.entity.UtentiEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UtentiMapper {
    UtentiMapper INSTANCE = Mappers.getMapper(UtentiMapper.class);

    // Entity -> DTO
    UtentiDTO toDTO(UtentiEntity utentiEntity);

    // DTO -> Entity
    UtentiEntity toEntity(UtentiDTO utentiDTO);
}