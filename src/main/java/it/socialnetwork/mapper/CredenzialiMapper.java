package it.socialnetwork.mapper;

import it.socialnetwork.dto.CredenzialiDTO;
import it.socialnetwork.entity.CredenzialiEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CredenzialiMapper {
    CredenzialiDTO toDTO(CredenzialiEntity credenzialiEntity);
    CredenzialiEntity toEntity(CredenzialiDTO credenzialiDTO);
}

