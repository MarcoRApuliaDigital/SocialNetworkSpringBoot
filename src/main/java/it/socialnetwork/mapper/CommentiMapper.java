package it.socialnetwork.mapper;

import it.socialnetwork.dto.CommentiDTO;
import it.socialnetwork.entity.CommentiEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {})

public interface CommentiMapper {
    CommentiDTO toDTO (CommentiEntity CommentiEntity);
    CommentiEntity toEntity (CommentiDTO CommentiDTO);
}
