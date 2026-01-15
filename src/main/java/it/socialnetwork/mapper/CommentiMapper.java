package it.socialnetwork.mapper;

import it.socialnetwork.dto.CommentiDTO;
import it.socialnetwork.entity.CommentiEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentiMapper {
    CommentiDTO toDTO(CommentiEntity commentiEntity);
    CommentiEntity toEntity(CommentiDTO commentiDTO);
}
