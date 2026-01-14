package it.socialnetwork.mapper;

import it.socialnetwork.dto.UtentiDTO;
import it.socialnetwork.entity.UtentiEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtentiMapper {
    UtentiDTO toDto(UtentiEntity utentiEntity);

    UtentiEntity toEntity (UtentiDTO utentiDTO);
}
