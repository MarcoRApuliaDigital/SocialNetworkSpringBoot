package it.socialnetwork.mapper;

import it.socialnetwork.dto.ContenutiPostDTO;
import it.socialnetwork.entity.ContenutiPostEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ContenutiPostMapper {
    ContenutiPostDTO toDTO (ContenutiPostEntity ContenutiPostEntity);
    ContenutiPostEntity toEntity (ContenutiPostDTO ContenutiPostDTO);
}
